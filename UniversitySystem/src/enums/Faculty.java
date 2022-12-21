package enums;

/**
 * Faculty Enum
 *
 */
public enum Faculty {
	FIT, ISE, KMA, SECAEN, SCE, RECMC, KBS, GEF, FEOGI, FGE, Undefined;
	
	/**
	 * Method of Faculty Enum, which is receive faculty as String and return it as Enum
	 * @param faculty
	 * @return Faculty
	 */
	static public Faculty of (final String faculty) {
		switch (faculty) {
		case "fit":
			return FIT;
		case "ise":
			return ISE;
		case "kma":
			return KMA;
		case "secaen":
			return SECAEN;
		case "sce":
			return SCE;
		case "recmc":
			return RECMC;
		case "kbs":
			return KBS;
		case "gef":
			return GEF;
		case "feogi":
			return FEOGI;
		case "fge":
			return FGE;
		default:
			return Undefined;
		}
	}
}
