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
		double erythema = Math.pow(teste.erythema - treinamento.erythema, q);		
		double scaling = Math.pow(teste.scaling - treinamento.scaling, q);		
		double definiteBorders = Math.pow(teste.definiteBorders - treinamento.definiteBorders, q);		
		double itching = Math.pow(teste.itching - treinamento.itching, q);		
		double koebnerPhenomenon = Math.pow(teste.koebnerPhenomenon - treinamento.koebnerPhenomenon, q);			
		double polygonalPapules = Math.pow(teste.polygonalPapules - treinamento.polygonalPapules, q);			
		double follicularPapules = Math.pow(teste.follicularPapules - treinamento.follicularPapules, q);
		double oralMucosalInvolvement = Math.pow(teste.oralMucosalInvolvement - treinamento.oralMucosalInvolvement, q);
		double scalpInvolvement = Math.pow(teste.scalpInvolvement - treinamento.scalpInvolvement, q);
		double familyHistory = Math.pow(teste.familyHistory - treinamento.familyHistory, q);
		double melaninIncontinence = Math.pow(teste.melaninIncontinence - treinamento.melaninIncontinence, q);		
		double eosinophilsInfiltrate = Math.pow(teste.eosinophilsInfiltrate - treinamento.eosinophilsInfiltrate, q);
		double PNL_Infiltrate = Math.pow(teste.PNL_Infiltrate - treinamento.PNL_Infiltrate, q);
		double fibrosisPapillaryDermis = Math.pow(teste.fibrosisPapillaryDermis - treinamento.fibrosisPapillaryDermis, q);
		double exocytosis = Math.pow(teste.exocytosis - treinamento.exocytosis, q);
		double acanthosis = Math.pow(teste.acanthosis - treinamento.acanthosis, q);
		double hyperkeratosis = Math.pow(teste.hyperkeratosis - treinamento.hyperkeratosis, q);
		double parakeratosis = Math.pow(teste.parakeratosis - treinamento.parakeratosis, q);
		double clubbingReteRidges = Math.pow(teste.clubbingReteRidges - treinamento.clubbingReteRidges, q);
		double elongationReteRidges = Math.pow(teste.elongationReteRidges - treinamento.elongationReteRidges, q);
		double thinningSuprapapillaryEpidermis = Math.pow(teste.thinningSuprapapillaryEpidermis - treinamento.thinningSuprapapillaryEpidermis, q);
		double spongiformPustule = Math.pow(teste.spongiformPustule - treinamento.spongiformPustule, q);
		double munroMicroabcess = Math.pow(teste.munroMicroabcess - treinamento.munroMicroabcess, q);
		double focalHypergranulosis = Math.pow(teste.focalHypergranulosis - treinamento.focalHypergranulosis, q);
		double disappearanceGranularLayer = Math.pow(teste.disappearanceGranularLayer - treinamento.disappearanceGranularLayer, q);
		double vacuolisationAndDamageOfBasalLayer = Math.pow(teste.vacuolisationAndDamageOfBasalLayer - treinamento.vacuolisationAndDamageOfBasalLayer, q);
		double spongiosis = Math.pow(teste.spongiosis - treinamento.spongiosis, q);
		double sawToothAppearanceRetes = Math.pow(teste.sawToothAppearanceRetes - treinamento.sawToothAppearanceRetes, q);
		double follicularHornPlug = Math.pow(teste.follicularHornPlug - treinamento.follicularHornPlug, q);
		double perifollicularParakeratosis = Math.pow(teste.perifollicularParakeratosis - treinamento.perifollicularParakeratosis, q);
		double inflammatoryMonoluclearInflitrate = Math.pow(teste.inflammatoryMonoluclearInflitrate - treinamento.inflammatoryMonoluclearInflitrate, q);
		double bandLikeInfiltrate = Math.pow(teste.bandLikeInfiltrate - treinamento.bandLikeInfiltrate, q);
		double age = Math.pow(teste.age - treinamento.age, q);
		double kneeAndElbowInvolvement = Math.pow(teste.kneeAndElbowInvolvement - treinamento.kneeAndElbowInvolvement, q);
			
		this.distancia = erythema + scaling + definiteBorders + itching + koebnerPhenomenon + polygonalPapules +
				follicularPapules + oralMucosalInvolvement + scalpInvolvement + familyHistory + melaninIncontinence +
				eosinophilsInfiltrate + PNL_Infiltrate + fibrosisPapillaryDermis + exocytosis + acanthosis + 
				hyperkeratosis + parakeratosis + clubbingReteRidges + elongationReteRidges + thinningSuprapapillaryEpidermis +
				spongiformPustule + munroMicroabcess + focalHypergranulosis + disappearanceGranularLayer + vacuolisationAndDamageOfBasalLayer +
				spongiosis + sawToothAppearanceRetes + follicularHornPlug + perifollicularParakeratosis + inflammatoryMonoluclearInflitrate +
				bandLikeInfiltrate + age + kneeAndElbowInvolvement;		
		
		this.distancia = Math.cbrt(this.distancia);		
		
		return this.distancia;
	}

}
