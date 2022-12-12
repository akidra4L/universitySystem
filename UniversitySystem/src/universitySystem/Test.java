package universitySystem;

import classes.ID;
import enums.Role;
import users.User;

public class Test {
	public static void main(String[] args) {
		UniversitySystem app = new UniversitySystem("WSP");
		UniversitySystem.users.add(new User(new ID(), "Alikhan", Role.Student));
		System.out.println(UniversitySystem.users);
	}
}
