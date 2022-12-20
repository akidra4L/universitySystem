package universitySystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

import classes.News;

public class NewsData implements Serializable {
	private static final long serialVersionUID = 1L;

	static {
		if (new File("news.ser").exists()) {
			try {
				UniversitySystem.news = readNews();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			UniversitySystem.news = new Vector<News>();
		}
	}
	
	static Vector<News> readNews() throws Exception {
		FileInputStream fis = new FileInputStream("news.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		Vector<News> courses = (Vector<News>) ois.readObject();
		
		fis.close();
		ois.close();
		
		return courses;
	}
	
	static void saveNews() throws Exception {
		FileOutputStream fos = new FileOutputStream("news.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(UniversitySystem.news);
		
		fos.close();
		oos.close();
	}
}
