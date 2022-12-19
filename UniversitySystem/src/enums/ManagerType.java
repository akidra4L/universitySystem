package enums;

public enum ManagerType {
	Manager, ManagerFinancial, ManagerDepartment, Undefined;
	
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
