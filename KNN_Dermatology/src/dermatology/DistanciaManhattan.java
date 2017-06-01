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
		double erythema = (teste.erythema - atual.erythema) * -1;
		double scaling = (teste.scaling - atual.scaling) * -1;	
		double definiteBorders =(teste.definiteBorders - atual.definiteBorders) * -1;
		double itching = (teste.itching - atual.itching) * -1;		
		double koebnerPhenomenon = (teste.koebnerPhenomenon - atual.koebnerPhenomenon) * -1;	
		double polygonalPapules = (teste.polygonalPapules - atual.polygonalPapules) * -1;
		double follicularPapules = (teste.follicularPapules - atual.follicularPapules) * -1;
		double oralMucosalInvolvement = (teste.oralMucosalInvolvement - atual.oralMucosalInvolvement) * -1;
		double scalpInvolvement = (teste.scalpInvolvement - atual.scalpInvolvement) * -1;
		double familyHistory = (teste.familyHistory - atual.familyHistory) * -1;
		double melaninIncontinence = (teste.melaninIncontinence - atual.melaninIncontinence) * -1;		
		double eosinophilsInfiltrate = (teste.eosinophilsInfiltrate - atual.eosinophilsInfiltrate) * -1;
		double PNL_Infiltrate = (teste.PNL_Infiltrate - atual.PNL_Infiltrate) * -1;
		double fibrosisPapillaryDermis = (teste.fibrosisPapillaryDermis - atual.fibrosisPapillaryDermis) * -1;
		double exocytosis = (teste.exocytosis - atual.exocytosis) * -1;
		double acanthosis = (teste.acanthosis - atual.acanthosis) * -1;
		double hyperkeratosis = (teste.hyperkeratosis - atual.hyperkeratosis) * -1;
		double parakeratosis = (teste.parakeratosis - atual.parakeratosis) * -1;
		double clubbingReteRidges = (teste.clubbingReteRidges - atual.clubbingReteRidges) * -1;
		double elongationReteRidges = (teste.elongationReteRidges - atual.elongationReteRidges) * -1;
		double thinningSuprapapillaryEpidermis = (teste.thinningSuprapapillaryEpidermis - atual.thinningSuprapapillaryEpidermis) * -1;
		double spongiformPustule = (teste.spongiformPustule - atual.spongiformPustule) * -1;
		double munroMicroabcess = (teste.munroMicroabcess - atual.munroMicroabcess) * -1;
		double focalHypergranulosis = (teste.focalHypergranulosis - atual.focalHypergranulosis) * -1;
		double disappearanceGranularLayer = (teste.disappearanceGranularLayer - atual.disappearanceGranularLayer) * -1;
		double vacuolisationAndDamageOfBasalLayer = (teste.vacuolisationAndDamageOfBasalLayer - atual.vacuolisationAndDamageOfBasalLayer) * -1;
		double spongiosis = (teste.spongiosis - atual.spongiosis) * -1;
		double sawToothAppearanceRetes = (teste.sawToothAppearanceRetes - atual.sawToothAppearanceRetes) * -1;
		double follicularHornPlug = (teste.follicularHornPlug - atual.follicularHornPlug) * -1;
		double perifollicularParakeratosis = (teste.perifollicularParakeratosis - atual.perifollicularParakeratosis) * -1;
		double inflammatoryMonoluclearInflitrate = (teste.inflammatoryMonoluclearInflitrate - atual.inflammatoryMonoluclearInflitrate) * -1;
		double bandLikeInfiltrate = (teste.bandLikeInfiltrate - atual.bandLikeInfiltrate) * -1;
		double age = (teste.age - atual.age) * -1;
		double kneeAndElbowInvolvement = (teste.kneeAndElbowInvolvement - atual.kneeAndElbowInvolvement) * -1;
		
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
