package decorators;

public class EmployeeResearcher extends UserDecorator {
	public EmployeeResearcher(Researcher researcher) {
		super(researcher);
	}

	public String makeResearch() {
		return super.makeResearch() + " : employee";
	}
}
