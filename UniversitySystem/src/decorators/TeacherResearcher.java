package decorators;

public class TeacherResearcher extends EmployeeResearcher {
	public TeacherResearcher(Researcher researcher) {
		super(researcher);
	}
	
	public String makeResearch() {
		return super.makeResearch() + " : teacher";
	}
}
