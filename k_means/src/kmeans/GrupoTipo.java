package kmeans;

public enum GrupoTipo
{
	TIPO_1(1), 
	TIPO_2(2);
	
    private int valor;

    GrupoTipo(int numVal) 
    {
        this.valor = numVal;
    }

    public int getNumVal() 
    {
        return valor;
    }
}
