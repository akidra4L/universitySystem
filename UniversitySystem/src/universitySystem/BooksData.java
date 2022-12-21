package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import classes.Book;

public class BooksData implements Serializable {
	private static final long serialVersionUID = 1L;

	static {
		if (new File("books.ser").exists()) {
			try {
				UniversitySystem.books = readBooks();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UniversitySystem.books = new Vector<Book>();
		}
	}
	
	static Vector<Book> readBooks() throws Exception {
		FileInputStream fis = new FileInputStream("books.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<Book> courses = (Vector<Book>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return courses;
	}
	
	static void saveBooks() throws Exception {
		FileOutputStream fos = new FileOutputStream("books.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.courses);
		
		fos.close();
		oos.close();
	}
}
