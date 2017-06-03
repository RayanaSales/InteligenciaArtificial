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
		double erythema = Math.pow((teste.erythema - atual.erythema) * -1 , q);		
		double scaling = Math.pow((teste.scaling - atual.scaling) * -1, q);		
		double definiteBorders = Math.pow((teste.definiteBorders - atual.definiteBorders) * -1, q);		
		double itching = Math.pow((teste.itching - atual.itching) * -1, q);		
		double koebnerPhenomenon = Math.pow((teste.koebnerPhenomenon - atual.koebnerPhenomenon) * -1, q);			
		double polygonalPapules = Math.pow((teste.polygonalPapules - atual.polygonalPapules) * -1, q);			
		double follicularPapules = Math.pow((teste.follicularPapules - atual.follicularPapules) * -1, q);
		double oralMucosalInvolvement = Math.pow((teste.oralMucosalInvolvement - atual.oralMucosalInvolvement) * -1, q);
		double scalpInvolvement = Math.pow((teste.scalpInvolvement - atual.scalpInvolvement) * -1, q);
		double familyHistory = Math.pow((teste.familyHistory - atual.familyHistory) * -1, q);
		double melaninIncontinence = Math.pow((teste.melaninIncontinence - atual.melaninIncontinence) * -1, q);		
		double eosinophilsInfiltrate = Math.pow((teste.eosinophilsInfiltrate - atual.eosinophilsInfiltrate) * -1, q);
		double PNL_Infiltrate = Math.pow((teste.PNL_Infiltrate - atual.PNL_Infiltrate) * -1, q);
		double fibrosisPapillaryDermis = Math.pow((teste.fibrosisPapillaryDermis - atual.fibrosisPapillaryDermis) * -1, q);
		double exocytosis = Math.pow((teste.exocytosis - atual.exocytosis) * -1, q);
		double acanthosis = Math.pow((teste.acanthosis - atual.acanthosis) * -1, q);
		double hyperkeratosis = Math.pow((teste.hyperkeratosis - atual.hyperkeratosis) * -1, q);
		double parakeratosis = Math.pow((teste.parakeratosis - atual.parakeratosis) * -1, q);
		double clubbingReteRidges = Math.pow((teste.clubbingReteRidges - atual.clubbingReteRidges) * -1, q);
		double elongationReteRidges = Math.pow((teste.elongationReteRidges - atual.elongationReteRidges) * -1, q);
		double thinningSuprapapillaryEpidermis = Math.pow((teste.thinningSuprapapillaryEpidermis - atual.thinningSuprapapillaryEpidermis) * -1, q);
		double spongiformPustule = Math.pow((teste.spongiformPustule - atual.spongiformPustule) * -1, q);
		double munroMicroabcess = Math.pow((teste.munroMicroabcess - atual.munroMicroabcess) * -1, q);
		double focalHypergranulosis = Math.pow((teste.focalHypergranulosis - atual.focalHypergranulosis) * -1, q);
		double disappearanceGranularLayer = Math.pow((teste.disappearanceGranularLayer - atual.disappearanceGranularLayer) * -1, q);
		double vacuolisationAndDamageOfBasalLayer = Math.pow((teste.vacuolisationAndDamageOfBasalLayer - atual.vacuolisationAndDamageOfBasalLayer) * -1, q);
		double spongiosis = Math.pow((teste.spongiosis - atual.spongiosis) * -1, q);
		double sawToothAppearanceRetes = Math.pow((teste.sawToothAppearanceRetes - atual.sawToothAppearanceRetes) * -1, q);
		double follicularHornPlug = Math.pow((teste.follicularHornPlug - atual.follicularHornPlug) * -1, q);
		double perifollicularParakeratosis = Math.pow((teste.perifollicularParakeratosis - atual.perifollicularParakeratosis) * -1, q);
		double inflammatoryMonoluclearInflitrate = Math.pow((teste.inflammatoryMonoluclearInflitrate - atual.inflammatoryMonoluclearInflitrate) * -1, q);
		double bandLikeInfiltrate = Math.pow((teste.bandLikeInfiltrate - atual.bandLikeInfiltrate) * -1, q);
		double age = Math.pow((teste.age - atual.age) * -1, q);
		double kneeAndElbowInvolvement = Math.pow((teste.kneeAndElbowInvolvement - atual.kneeAndElbowInvolvement) * -1, q);
		
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
