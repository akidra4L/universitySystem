package enums;

/**
 * ManagerType Enum
 *
 */
public enum ManagerType {
	Manager, ManagerFinancial, ManagerDepartment, Undefined;
	
	/**
	 * Method of ManagerType Enum, which is receive type as String and return it as Enum
	 * @param type
	 * @return
	 */
	static public ManagerType of (final String type) {
		switch(type) {
		case "manager":
			return Manager;
		case "manager financial":
			return ManagerFinancial;
		case "manager department":
			return ManagerDepartment;
		default:
			return Undefined;
		}
	}
}
