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
		double erythema = Math.abs((teste.erythema - atual.erythema));
		double scaling = Math.abs((teste.scaling - atual.scaling));	
		double definiteBorders =Math.abs((teste.definiteBorders - atual.definiteBorders));
		double itching = Math.abs((teste.itching - atual.itching));		
		double koebnerPhenomenon = Math.abs((teste.koebnerPhenomenon - atual.koebnerPhenomenon));	
		double polygonalPapules = Math.abs((teste.polygonalPapules - atual.polygonalPapules));
		double follicularPapules = Math.abs((teste.follicularPapules - atual.follicularPapules));
		double oralMucosalInvolvement = Math.abs((teste.oralMucosalInvolvement - atual.oralMucosalInvolvement));
		double scalpInvolvement = Math.abs((teste.scalpInvolvement - atual.scalpInvolvement));
		double familyHistory = Math.abs((teste.familyHistory - atual.familyHistory));
		double melaninIncontinence = Math.abs((teste.melaninIncontinence - atual.melaninIncontinence));		
		double eosinophilsInfiltrate = Math.abs((teste.eosinophilsInfiltrate - atual.eosinophilsInfiltrate));
		double PNL_Infiltrate = Math.abs((teste.PNL_Infiltrate - atual.PNL_Infiltrate));
		double fibrosisPapillaryDermis = Math.abs((teste.fibrosisPapillaryDermis - atual.fibrosisPapillaryDermis));
		double exocytosis = Math.abs((teste.exocytosis - atual.exocytosis));
		double acanthosis = Math.abs((teste.acanthosis - atual.acanthosis));
		double hyperkeratosis = Math.abs((teste.hyperkeratosis - atual.hyperkeratosis));
		double parakeratosis = Math.abs((teste.parakeratosis - atual.parakeratosis));
		double clubbingReteRidges = Math.abs((teste.clubbingReteRidges - atual.clubbingReteRidges));
		double elongationReteRidges = Math.abs((teste.elongationReteRidges - atual.elongationReteRidges));
		double thinningSuprapapillaryEpidermis = Math.abs((teste.thinningSuprapapillaryEpidermis - atual.thinningSuprapapillaryEpidermis));
		double spongiformPustule = Math.abs((teste.spongiformPustule - atual.spongiformPustule));
		double munroMicroabcess = Math.abs((teste.munroMicroabcess - atual.munroMicroabcess));
		double focalHypergranulosis = Math.abs((teste.focalHypergranulosis - atual.focalHypergranulosis));
		double disappearanceGranularLayer = Math.abs((teste.disappearanceGranularLayer - atual.disappearanceGranularLayer));
		double vacuolisationAndDamageOfBasalLayer = Math.abs((teste.vacuolisationAndDamageOfBasalLayer - atual.vacuolisationAndDamageOfBasalLayer));
		double spongiosis = Math.abs((teste.spongiosis - atual.spongiosis));
		double sawToothAppearanceRetes = Math.abs((teste.sawToothAppearanceRetes - atual.sawToothAppearanceRetes));
		double follicularHornPlug = Math.abs((teste.follicularHornPlug - atual.follicularHornPlug));
		double perifollicularParakeratosis = Math.abs((teste.perifollicularParakeratosis - atual.perifollicularParakeratosis));
		double inflammatoryMonoluclearInflitrate = Math.abs((teste.inflammatoryMonoluclearInflitrate - atual.inflammatoryMonoluclearInflitrate));
		double bandLikeInfiltrate = Math.abs((teste.bandLikeInfiltrate - atual.bandLikeInfiltrate));
		double age = Math.abs((teste.age - atual.age));
		double kneeAndElbowInvolvement = Math.abs((teste.kneeAndElbowInvolvement - atual.kneeAndElbowInvolvement));
		
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
