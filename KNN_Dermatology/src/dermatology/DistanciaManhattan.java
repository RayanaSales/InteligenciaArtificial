package dermatology;

public class DistanciaManhattan extends Distancia
{
	public DistanciaManhattan(Tupla atual, Tupla teste)
	{		
		super(atual, teste);
	}

	@Override
	public double Calcular()
	{
		double erythema = Math.abs((teste.erythema - treinamento.erythema));
		double scaling = Math.abs((teste.scaling - treinamento.scaling));	
		double definiteBorders =Math.abs((teste.definiteBorders - treinamento.definiteBorders));
		double itching = Math.abs((teste.itching - treinamento.itching));		
		double koebnerPhenomenon = Math.abs((teste.koebnerPhenomenon - treinamento.koebnerPhenomenon));	
		double polygonalPapules = Math.abs((teste.polygonalPapules - treinamento.polygonalPapules));
		double follicularPapules = Math.abs((teste.follicularPapules - treinamento.follicularPapules));
		double oralMucosalInvolvement = Math.abs((teste.oralMucosalInvolvement - treinamento.oralMucosalInvolvement));
		double scalpInvolvement = Math.abs((teste.scalpInvolvement - treinamento.scalpInvolvement));
		double familyHistory = Math.abs((teste.familyHistory - treinamento.familyHistory));
		double melaninIncontinence = Math.abs((teste.melaninIncontinence - treinamento.melaninIncontinence));		
		double eosinophilsInfiltrate = Math.abs((teste.eosinophilsInfiltrate - treinamento.eosinophilsInfiltrate));
		double PNL_Infiltrate = Math.abs((teste.PNL_Infiltrate - treinamento.PNL_Infiltrate));
		double fibrosisPapillaryDermis = Math.abs((teste.fibrosisPapillaryDermis - treinamento.fibrosisPapillaryDermis));
		double exocytosis = Math.abs((teste.exocytosis - treinamento.exocytosis));
		double acanthosis = Math.abs((teste.acanthosis - treinamento.acanthosis));
		double hyperkeratosis = Math.abs((teste.hyperkeratosis - treinamento.hyperkeratosis));
		double parakeratosis = Math.abs((teste.parakeratosis - treinamento.parakeratosis));
		double clubbingReteRidges = Math.abs((teste.clubbingReteRidges - treinamento.clubbingReteRidges));
		double elongationReteRidges = Math.abs((teste.elongationReteRidges - treinamento.elongationReteRidges));
		double thinningSuprapapillaryEpidermis = Math.abs((teste.thinningSuprapapillaryEpidermis - treinamento.thinningSuprapapillaryEpidermis));
		double spongiformPustule = Math.abs((teste.spongiformPustule - treinamento.spongiformPustule));
		double munroMicroabcess = Math.abs((teste.munroMicroabcess - treinamento.munroMicroabcess));
		double focalHypergranulosis = Math.abs((teste.focalHypergranulosis - treinamento.focalHypergranulosis));
		double disappearanceGranularLayer = Math.abs((teste.disappearanceGranularLayer - treinamento.disappearanceGranularLayer));
		double vacuolisationAndDamageOfBasalLayer = Math.abs((teste.vacuolisationAndDamageOfBasalLayer - treinamento.vacuolisationAndDamageOfBasalLayer));
		double spongiosis = Math.abs((teste.spongiosis - treinamento.spongiosis));
		double sawToothAppearanceRetes = Math.abs((teste.sawToothAppearanceRetes - treinamento.sawToothAppearanceRetes));
		double follicularHornPlug = Math.abs((teste.follicularHornPlug - treinamento.follicularHornPlug));
		double perifollicularParakeratosis = Math.abs((teste.perifollicularParakeratosis - treinamento.perifollicularParakeratosis));
		double inflammatoryMonoluclearInflitrate = Math.abs((teste.inflammatoryMonoluclearInflitrate - treinamento.inflammatoryMonoluclearInflitrate));
		double bandLikeInfiltrate = Math.abs((teste.bandLikeInfiltrate - treinamento.bandLikeInfiltrate));
		double age = Math.abs((teste.age - treinamento.age));
		double kneeAndElbowInvolvement = Math.abs((teste.kneeAndElbowInvolvement - treinamento.kneeAndElbowInvolvement));
		
		this.distancia = erythema + scaling + definiteBorders + itching + koebnerPhenomenon + polygonalPapules +
				follicularPapules + oralMucosalInvolvement + scalpInvolvement + familyHistory + melaninIncontinence +
				eosinophilsInfiltrate + PNL_Infiltrate + fibrosisPapillaryDermis + exocytosis + acanthosis + 
				hyperkeratosis + parakeratosis + clubbingReteRidges + elongationReteRidges + thinningSuprapapillaryEpidermis +
				spongiformPustule + munroMicroabcess + focalHypergranulosis + disappearanceGranularLayer + vacuolisationAndDamageOfBasalLayer +
				spongiosis + sawToothAppearanceRetes + follicularHornPlug + perifollicularParakeratosis + inflammatoryMonoluclearInflitrate +
				bandLikeInfiltrate + age + kneeAndElbowInvolvement;
		
		return distancia;
	}

}
