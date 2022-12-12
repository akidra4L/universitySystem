package decorators;

public class UserDecorator implements Researcher {
	private Researcher researcher;
	
	public UserDecorator(Researcher researcher) {
		this.researcher = researcher;
	}

	public Researcher getResearcher() {
		return researcher;
	}

	public void setResearcher(Researcher researcher) {
		this.researcher = researcher;
	}

	@Override
	public String makeResearch() {
		return researcher.makeResearch();
	}
}
