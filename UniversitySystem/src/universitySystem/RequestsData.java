package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import classes.Request;

public class RequestsData implements Serializable {
	private static final long serialVersionUID = 1L;
	
	static {
		if (new File("requests.ser").exists()) {
			try {
				UniversitySystem.requests = readRequests();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UniversitySystem.requests = new ArrayList<Request>();
		}
	}
	
	static  ArrayList<Request> readRequests() throws Exception {
		FileInputStream fis = new FileInputStream("requests.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		ArrayList<Request> requests = (ArrayList<Request>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return requests;
	}
	
	static void saveRequests() throws Exception {
		FileOutputStream fos = new FileOutputStream("requests.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.requests);
		
		fos.close();
		oos.close();
	}
}
