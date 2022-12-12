package decorators;

public class StudentResearcher extends UserDecorator {
	public StudentResearcher(Researcher researcher) {
		super(researcher);
	}
	
	public String makeResearch() {
		return super.makeResearch() + " : student";
	}
}
