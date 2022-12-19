package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import classes.*;
import users.*;

public class UsersData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static {
		if (new File("users.ser").exists()) {
			try {
				UniversitySystem.users = readUsers();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			@SuppressWarnings("unused")
			Admin a = new Admin(new ID(), "Alikhan", "admin");
			UniversitySystem.users = new Vector<User>();
		}
	}
	
	static Vector<User> readUsers() throws Exception {
		FileInputStream fis = new FileInputStream("users.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<User> users = (Vector<User>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return users;
	}
	
	static void saveUsers() throws Exception {
		FileOutputStream fos = new FileOutputStream("users.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.users);
		
		fos.close();
		oos.close();
	}
}
