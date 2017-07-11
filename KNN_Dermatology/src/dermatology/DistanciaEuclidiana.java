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
		double erythema = Math.pow(teste.erythema - treinamento.erythema, 2);
		double scaling = Math.pow(teste.scaling - treinamento.scaling, 2);		
		double definiteBorders = Math.pow(teste.definiteBorders - treinamento.definiteBorders, 2);
		double itching = Math.pow(teste.itching - treinamento.itching, 2);		
		double koebnerPhenomenon = Math.pow(teste.koebnerPhenomenon - treinamento.koebnerPhenomenon, 2);		
		double polygonalPapules = Math.pow(teste.polygonalPapules - treinamento.polygonalPapules, 2);	
		double follicularPapules = Math.pow(teste.follicularPapules - treinamento.follicularPapules, 2);
		double oralMucosalInvolvement = Math.pow(teste.oralMucosalInvolvement - treinamento.oralMucosalInvolvement, 2);
		double scalpInvolvement = Math.pow(teste.scalpInvolvement - treinamento.scalpInvolvement, 2);
		double familyHistory = Math.pow(teste.familyHistory - treinamento.familyHistory, 2);
		double melaninIncontinence = Math.pow(teste.melaninIncontinence - treinamento.melaninIncontinence, 2);		
		double eosinophilsInfiltrate = Math.pow(teste.eosinophilsInfiltrate - treinamento.eosinophilsInfiltrate, 2);
		double PNL_Infiltrate = Math.pow(teste.PNL_Infiltrate - treinamento.PNL_Infiltrate, 2);
		double fibrosisPapillaryDermis = Math.pow(teste.fibrosisPapillaryDermis - treinamento.fibrosisPapillaryDermis, 2);
		double exocytosis = Math.pow(teste.exocytosis - treinamento.exocytosis, 2);
		double acanthosis = Math.pow(teste.acanthosis - treinamento.acanthosis, 2);
		double hyperkeratosis = Math.pow(teste.hyperkeratosis - treinamento.hyperkeratosis, 2);
		double parakeratosis = Math.pow(teste.parakeratosis - treinamento.parakeratosis, 2);
		double clubbingReteRidges = Math.pow(teste.clubbingReteRidges - treinamento.clubbingReteRidges, 2);
		double elongationReteRidges = Math.pow(teste.elongationReteRidges - treinamento.elongationReteRidges, 2);
		double thinningSuprapapillaryEpidermis = Math.pow(teste.thinningSuprapapillaryEpidermis - treinamento.thinningSuprapapillaryEpidermis, 2);
		double spongiformPustule = Math.pow(teste.spongiformPustule - treinamento.spongiformPustule, 2);
		double munroMicroabcess = Math.pow(teste.munroMicroabcess - treinamento.munroMicroabcess, 2);
		double focalHypergranulosis = Math.pow(teste.focalHypergranulosis - treinamento.focalHypergranulosis, 2);
		double disappearanceGranularLayer = Math.pow(teste.disappearanceGranularLayer - treinamento.disappearanceGranularLayer, 2);
		double vacuolisationAndDamageOfBasalLayer = Math.pow(teste.vacuolisationAndDamageOfBasalLayer - treinamento.vacuolisationAndDamageOfBasalLayer, 2);
		double spongiosis = Math.pow(teste.spongiosis - treinamento.spongiosis, 2);
		double sawToothAppearanceRetes = Math.pow(teste.sawToothAppearanceRetes - treinamento.sawToothAppearanceRetes, 2);
		double follicularHornPlug = Math.pow(teste.follicularHornPlug - treinamento.follicularHornPlug, 2);
		double perifollicularParakeratosis = Math.pow(teste.perifollicularParakeratosis - treinamento.perifollicularParakeratosis, 2);
		double inflammatoryMonoluclearInflitrate = Math.pow(teste.inflammatoryMonoluclearInflitrate - treinamento.inflammatoryMonoluclearInflitrate, 2);
		double bandLikeInfiltrate = Math.pow(teste.bandLikeInfiltrate - treinamento.bandLikeInfiltrate, 2);
		double age = Math.pow(teste.age - treinamento.age, 2);
		double kneeAndElbowInvolvement = Math.pow(teste.kneeAndElbowInvolvement - treinamento.kneeAndElbowInvolvement, 2);
		
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
