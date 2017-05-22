package dermatology;

public enum Diagnostico
{
	PSORIASIS(1), 
	SEBOREIC_DERMATITIS(2), 
	LICHEN_PLANUS(3), 
	PITYRIASIS_ROSEA(4), 
	CRONIC_DERMATITIS(5), 
	PITYRIASIS_RUBRA_PILARIS(6);
	
	
    private int valor;

    Diagnostico(int numVal) {
        this.valor = numVal;
    }

    public int getNumVal() {
        return valor;
    }
}
