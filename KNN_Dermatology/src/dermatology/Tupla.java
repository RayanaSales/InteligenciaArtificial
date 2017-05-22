package dermatology;

public class Tupla
{
	int id;

	int erythema, // 1
			scaling, // 2
			definiteBorders, // 3
			itching, // 4
			koebnerPhenomenon, // 5
			polygonalPapules, // 6
			follicularPapules, // 7
			oralMucosalInvolvement, // 8
			kneeAndElbowInvolvement, // 9
			scalpInvolvement, // 10
			familyHistory, // 11
			melaninIncontinence, // 12
			eosinophilsInfiltrate, // 13
			PNL_Infiltrate, // 14
			fibrosisPapillaryDermis, // 15
			exocytosis, // 15
			acanthosis, // 17
			hyperkeratosis, // 18
			parakeratosis, // 19
			clubbingReteRidges, // 20
			elongationReteRidges, // 21
			thinningSuprapapillaryEpidermis, // 22
			spongiformPustule, // 23
			munroMicroabcess, // 24
			focalHypergranulosis, // 25
			disappearanceGranularLayer, // 26
			vacuolisationAndDamageOfBasalLayer, // 27
			spongiosis, // 28
			sawToothAppearanceRetes, // 29
			follicularHornPlug, // 30
			perifollicularParakeratosis, // 31
			inflammatoryMonoluclearInflitrate, // 32
			bandLikeInfiltrate, // 33
			age; // 34

	Diagnostico RESPOSTA_REAL;

	public Tupla(int id, int erythema, int scaling, int definiteBorders, int itching, int koebnerPhenomenon,
			int polygonalPapules, int follicularPapules, int oralMucosalInvolvement, int kneeAndElbowInvolvement,
			int scalpInvolvement, int familyHistory, int melaninIncontinence, int eosinophilsInfiltrate,
			int PNL_Infiltrate, int fibrosisPapillaryDermis, int exocytosis, int acanthosis, int hyperkeratosis,
			int parakeratosis, int clubbingReteRidges, int elongationReteRidges, int thinningSuprapapillaryEpidermis,
			int spongiformPustule, int munroMicroabcess, int focalHypergranulosis, int disappearanceGranularLayer,
			int vacuolisationAndDamageOfBasalLayer, int spongiosis, int sawToothAppearanceRetes, int follicularHornPlug,
			int perifollicularParakeratosis, int inflammatoryMonoluclearInflitrate, int bandLikeInfiltrate, int age, 
			Diagnostico RESPOSTA_REAL)
	{
		this.id = id;
		this.erythema = erythema;
		this.scaling = scaling;
		this.definiteBorders = definiteBorders;
		this.itching = itching;
		this.koebnerPhenomenon = koebnerPhenomenon;
		this.polygonalPapules = polygonalPapules;
		this.follicularPapules = follicularPapules;
		this.oralMucosalInvolvement = oralMucosalInvolvement;
		this.kneeAndElbowInvolvement = kneeAndElbowInvolvement;
		this.scalpInvolvement = scalpInvolvement;
		this.familyHistory = familyHistory;
		this.melaninIncontinence = melaninIncontinence;
		this.eosinophilsInfiltrate = eosinophilsInfiltrate;
		this.PNL_Infiltrate = PNL_Infiltrate;
		this.fibrosisPapillaryDermis = fibrosisPapillaryDermis;
		this.exocytosis = exocytosis;
		this.acanthosis = acanthosis;
		this.hyperkeratosis = hyperkeratosis;
		this.parakeratosis = parakeratosis;
		this.clubbingReteRidges = clubbingReteRidges;
		this.elongationReteRidges = elongationReteRidges;
		this.thinningSuprapapillaryEpidermis = thinningSuprapapillaryEpidermis;
		this.spongiformPustule = spongiformPustule;
		this.munroMicroabcess = munroMicroabcess;
		this.focalHypergranulosis = focalHypergranulosis;
		this.disappearanceGranularLayer = disappearanceGranularLayer;
		this.vacuolisationAndDamageOfBasalLayer = vacuolisationAndDamageOfBasalLayer;
		this.spongiosis = spongiosis;
		this.sawToothAppearanceRetes = sawToothAppearanceRetes;
		this.follicularHornPlug = follicularHornPlug;
		this.perifollicularParakeratosis = perifollicularParakeratosis;
		this.inflammatoryMonoluclearInflitrate = inflammatoryMonoluclearInflitrate;
		this.bandLikeInfiltrate = bandLikeInfiltrate;
		this.age = age;
		
		this.RESPOSTA_REAL = RESPOSTA_REAL;
	}
}