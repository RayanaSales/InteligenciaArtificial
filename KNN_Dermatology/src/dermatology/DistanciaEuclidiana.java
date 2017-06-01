package dermatology;

public class DistanciaEuclidiana extends Distancia
{	
	public DistanciaEuclidiana(Tupla atual, Tupla teste)
	{		
		super(atual, teste);
	}
	
	@Override
	public double Calcular()
	{
		double erythema = Math.pow(teste.erythema - atual.erythema, 2);
		double scaling = Math.pow(teste.scaling - atual.scaling, 2);		
		double definiteBorders = Math.pow(teste.definiteBorders - atual.definiteBorders, 2);
		double itching = Math.pow(teste.itching - atual.itching, 2);		
		double koebnerPhenomenon = Math.pow(teste.koebnerPhenomenon - atual.koebnerPhenomenon, 2);		
		double polygonalPapules = Math.pow(teste.polygonalPapules - atual.polygonalPapules, 2);	
		double follicularPapules = Math.pow(teste.follicularPapules - atual.follicularPapules, 2);
		double oralMucosalInvolvement = Math.pow(teste.oralMucosalInvolvement - atual.oralMucosalInvolvement, 2);
		double scalpInvolvement = Math.pow(teste.scalpInvolvement - atual.scalpInvolvement, 2);
		double familyHistory = Math.pow(teste.familyHistory - atual.familyHistory, 2);
		double melaninIncontinence = Math.pow(teste.melaninIncontinence - atual.melaninIncontinence, 2);		
		double eosinophilsInfiltrate = Math.pow(teste.eosinophilsInfiltrate - atual.eosinophilsInfiltrate, 2);
		double PNL_Infiltrate = Math.pow(teste.PNL_Infiltrate - atual.PNL_Infiltrate, 2);
		double fibrosisPapillaryDermis = Math.pow(teste.fibrosisPapillaryDermis - atual.fibrosisPapillaryDermis, 2);
		double exocytosis = Math.pow(teste.exocytosis - atual.exocytosis, 2);
		double acanthosis = Math.pow(teste.acanthosis - atual.acanthosis, 2);
		double hyperkeratosis = Math.pow(teste.hyperkeratosis - atual.hyperkeratosis, 2);
		double parakeratosis = Math.pow(teste.parakeratosis - atual.parakeratosis, 2);
		double clubbingReteRidges = Math.pow(teste.clubbingReteRidges - atual.clubbingReteRidges, 2);
		double elongationReteRidges = Math.pow(teste.elongationReteRidges - atual.elongationReteRidges, 2);
		double thinningSuprapapillaryEpidermis = Math.pow(teste.thinningSuprapapillaryEpidermis - atual.thinningSuprapapillaryEpidermis, 2);
		double spongiformPustule = Math.pow(teste.spongiformPustule - atual.spongiformPustule, 2);
		double munroMicroabcess = Math.pow(teste.munroMicroabcess - atual.munroMicroabcess, 2);
		double focalHypergranulosis = Math.pow(teste.focalHypergranulosis - atual.focalHypergranulosis, 2);
		double disappearanceGranularLayer = Math.pow(teste.disappearanceGranularLayer - atual.disappearanceGranularLayer, 2);
		double vacuolisationAndDamageOfBasalLayer = Math.pow(teste.vacuolisationAndDamageOfBasalLayer - atual.vacuolisationAndDamageOfBasalLayer, 2);
		double spongiosis = Math.pow(teste.spongiosis - atual.spongiosis, 2);
		double sawToothAppearanceRetes = Math.pow(teste.sawToothAppearanceRetes - atual.sawToothAppearanceRetes, 2);
		double follicularHornPlug = Math.pow(teste.follicularHornPlug - atual.follicularHornPlug, 2);
		double perifollicularParakeratosis = Math.pow(teste.perifollicularParakeratosis - atual.perifollicularParakeratosis, 2);
		double inflammatoryMonoluclearInflitrate = Math.pow(teste.inflammatoryMonoluclearInflitrate - atual.inflammatoryMonoluclearInflitrate, 2);
		double bandLikeInfiltrate = Math.pow(teste.bandLikeInfiltrate - atual.bandLikeInfiltrate, 2);
		double age = Math.pow(teste.age - atual.age, 2);
		double kneeAndElbowInvolvement = Math.pow(teste.kneeAndElbowInvolvement - atual.kneeAndElbowInvolvement, 2);
		
		this.distancia = erythema + scaling + definiteBorders + itching + koebnerPhenomenon + polygonalPapules +
				follicularPapules + oralMucosalInvolvement + scalpInvolvement + familyHistory + melaninIncontinence +
				eosinophilsInfiltrate + PNL_Infiltrate + fibrosisPapillaryDermis + exocytosis + acanthosis + 
				hyperkeratosis + parakeratosis + clubbingReteRidges + elongationReteRidges + thinningSuprapapillaryEpidermis +
				spongiformPustule + munroMicroabcess + focalHypergranulosis + disappearanceGranularLayer + vacuolisationAndDamageOfBasalLayer +
				spongiosis + sawToothAppearanceRetes + follicularHornPlug + perifollicularParakeratosis + inflammatoryMonoluclearInflitrate +
				bandLikeInfiltrate + age + kneeAndElbowInvolvement;
		
		return Math.sqrt(this.distancia);
	}
}
