package view;

import users.Librarian;

public class viewLibrarianController {
	public static void showLibrarianMenu(Librarian librarian) {
		viewUserController.showUserMenu(librarian);
		System.out.println("3. View all books");
		System.out.println("4. Add new book");
		System.out.println("5. Give book to user");
		System.out.println("6. Logout");
	}
}
