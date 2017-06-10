package dermatology;

public class DistanciaMinkowski extends Distancia
{
	int q = 3;
	
	public DistanciaMinkowski(Tupla atual, Tupla teste)
	{		
		super(atual, teste);
	}

	@Override
	public double Calcular()
	{
		double erythema = Math.pow(Math.abs(teste.erythema - atual.erythema) , q);		
		double scaling = Math.pow(Math.abs(teste.scaling - atual.scaling), q);		
		double definiteBorders = Math.pow(Math.abs(teste.definiteBorders - atual.definiteBorders), q);		
		double itching = Math.pow(Math.abs(teste.itching - atual.itching), q);		
		double koebnerPhenomenon = Math.pow(Math.abs(teste.koebnerPhenomenon - atual.koebnerPhenomenon), q);			
		double polygonalPapules = Math.pow(Math.abs(teste.polygonalPapules - atual.polygonalPapules), q);			
		double follicularPapules = Math.pow(Math.abs(teste.follicularPapules - atual.follicularPapules), q);
		double oralMucosalInvolvement = Math.pow(Math.abs(teste.oralMucosalInvolvement - atual.oralMucosalInvolvement), q);
		double scalpInvolvement = Math.pow(Math.abs(teste.scalpInvolvement - atual.scalpInvolvement), q);
		double familyHistory = Math.pow(Math.abs(teste.familyHistory - atual.familyHistory), q);
		double melaninIncontinence = Math.pow(Math.abs(teste.melaninIncontinence - atual.melaninIncontinence), q);		
		double eosinophilsInfiltrate = Math.pow(Math.abs(teste.eosinophilsInfiltrate - atual.eosinophilsInfiltrate), q);
		double PNL_Infiltrate = Math.pow(Math.abs(teste.PNL_Infiltrate - atual.PNL_Infiltrate), q);
		double fibrosisPapillaryDermis = Math.pow(Math.abs(teste.fibrosisPapillaryDermis - atual.fibrosisPapillaryDermis), q);
		double exocytosis = Math.pow(Math.abs(teste.exocytosis - atual.exocytosis), q);
		double acanthosis = Math.pow(Math.abs(teste.acanthosis - atual.acanthosis), q);
		double hyperkeratosis = Math.pow(Math.abs(teste.hyperkeratosis - atual.hyperkeratosis), q);
		double parakeratosis = Math.pow(Math.abs(teste.parakeratosis - atual.parakeratosis), q);
		double clubbingReteRidges = Math.pow(Math.abs(teste.clubbingReteRidges - atual.clubbingReteRidges), q);
		double elongationReteRidges = Math.pow(Math.abs(teste.elongationReteRidges - atual.elongationReteRidges), q);
		double thinningSuprapapillaryEpidermis = Math.pow(Math.abs(teste.thinningSuprapapillaryEpidermis - atual.thinningSuprapapillaryEpidermis), q);
		double spongiformPustule = Math.pow(Math.abs(teste.spongiformPustule - atual.spongiformPustule), q);
		double munroMicroabcess = Math.pow(Math.abs(teste.munroMicroabcess - atual.munroMicroabcess), q);
		double focalHypergranulosis = Math.pow(Math.abs(teste.focalHypergranulosis - atual.focalHypergranulosis), q);
		double disappearanceGranularLayer = Math.pow(Math.abs(teste.disappearanceGranularLayer - atual.disappearanceGranularLayer), q);
		double vacuolisationAndDamageOfBasalLayer = Math.pow(Math.abs(teste.vacuolisationAndDamageOfBasalLayer - atual.vacuolisationAndDamageOfBasalLayer), q);
		double spongiosis = Math.pow(Math.abs(teste.spongiosis - atual.spongiosis), q);
		double sawToothAppearanceRetes = Math.pow(Math.abs(teste.sawToothAppearanceRetes - atual.sawToothAppearanceRetes), q);
		double follicularHornPlug = Math.pow(Math.abs(teste.follicularHornPlug - atual.follicularHornPlug), q);
		double perifollicularParakeratosis = Math.pow(Math.abs(teste.perifollicularParakeratosis - atual.perifollicularParakeratosis), q);
		double inflammatoryMonoluclearInflitrate = Math.pow(Math.abs(teste.inflammatoryMonoluclearInflitrate - atual.inflammatoryMonoluclearInflitrate), q);
		double bandLikeInfiltrate = Math.pow(Math.abs(teste.bandLikeInfiltrate - atual.bandLikeInfiltrate), q);
		double age = Math.pow(Math.abs(teste.age - atual.age), q);
		double kneeAndElbowInvolvement = Math.pow(Math.abs(teste.kneeAndElbowInvolvement - atual.kneeAndElbowInvolvement), q);
			
		this.distancia = erythema + scaling + definiteBorders + itching + koebnerPhenomenon + polygonalPapules +
				follicularPapules + oralMucosalInvolvement + scalpInvolvement + familyHistory + melaninIncontinence +
				eosinophilsInfiltrate + PNL_Infiltrate + fibrosisPapillaryDermis + exocytosis + acanthosis + 
				hyperkeratosis + parakeratosis + clubbingReteRidges + elongationReteRidges + thinningSuprapapillaryEpidermis +
				spongiformPustule + munroMicroabcess + focalHypergranulosis + disappearanceGranularLayer + vacuolisationAndDamageOfBasalLayer +
				spongiosis + sawToothAppearanceRetes + follicularHornPlug + perifollicularParakeratosis + inflammatoryMonoluclearInflitrate +
				bandLikeInfiltrate + age + kneeAndElbowInvolvement;		
		
		this.distancia = this.distancia / q;		
		
		return this.distancia;
	}

}
