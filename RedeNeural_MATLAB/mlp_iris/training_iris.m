function resultado = training_iris()

    caminho = 'IrisNormalizada.data';

    base = lerBaseDados(caminho);

    [treinamento, teste] = quebrarBase(base);

    

    rede_bp = treinar_mlp(treinamento);

    

    % remove a classe da base de teste

    [amostras, saidas] = ajustarBase(teste)

    resultado = classificar_mlp(amostras, rede_bp);

    

    % Comparar resultado

    

    

    

end



function base = lerBaseDados(caminho)

   base = csvread(caminho); 

end



function [treinamento, teste] = quebrarBase(base)

    treinamento(1:30, :) = base(1:30,:);

    teste(1:20,:)= base(31:50,:);

    treinamento(31:60, :) = base(51:80,:);

    teste(21:40,:)= base(81:100,:);

    treinamento(61:90, :) = base(101:130,:);

    teste(41:60,:)= base(131:150,:);

end



function [amostras, saidas] = ajustarBase(base)

    [n,m] = size(base);

    maior = max(base(:,m));

    menor = min(base(:,m));

    num_classe = maior - menor + 1; 



    saidas = zeros(num_classe,n);



    for i = 1:n

        saidas(base(i,m),i) = 1;

    end



    amostras = base(:,1:m-1);

    amostras = transpose(amostras);

end



function rede_bp = treinar_mlp(treinamento)

    [~,m] = size(treinamento);

    epoca = 150000;

    erro = 1e-3;

    camada_escondida = m-1;

 

    [treino_mlp, vetor_classe] = ajustarBase(treinamento);

    rede_bp = newff(treino_mlp,vetor_classe,camada_escondida,{'tansig','logsig'},'traingd');

    rede_bp.trainParam.epochs = epoca;

    rede_bp.trainParam.goal = erro;

    rede_bp.trainParam.max_fail = 10;

    rede_bp=initnw(rede_bp,1);

    rede_bp=initnw(rede_bp,2);



    rede_bp = train(rede_bp,treino_mlp,vetor_classe);

end



function resultado = classificar_mlp(teste, rede_bp)    

    resultado = sim(rede_bp,teste);    

end