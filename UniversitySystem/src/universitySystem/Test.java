package universitySystem;

import decorators.EmployeeResearcher;
import decorators.Researcher;
import decorators.ResearcherItem;

public class Test {

	public static void main(String[] args) {
//		System.out.println("Hello, World!");
		
		Researcher r = new EmployeeResearcher(new ResearcherItem());
		System.out.println(r.makeResearch());
	}

}
