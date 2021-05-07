
import java.util.Scanner;

public class UI {

	public void program() {
		int option;

		Scanner scanner 		= new Scanner(System.in);
		Controller controller 	= new Controller();

		System.out.println("Introdu numele bancii: ");
		String BankName = scanner.next();

		Banca Bank = new Banca(BankName);

		System.out.println("Banca " + BankName);
		System.out.println("--------------");
		System.out.println("1. User	 Menu");
		System.out.println("2. Admin Menu");
		System.out.println("9. Exit");

		option = scanner.nextInt();

		while (option!=9) {

			// Meniu Utilizator
			if (option == 1) {
				boolean userAuth	= false;
				int idClient		= -1;
				int userOpt			= -1;

				System.out.println("Introduceti CNP:");
				String loginCNP = scanner.next();

				// Autentificare client
				for (Client client : Bank.getListaClienti().values()) {
					if (loginCNP.equals(client.getCNP())) {
						userAuth = true;
						idClient = client.getID();

						System.out.println("Autentificare Utilizator permisa");

						System.out.println("\nUserMenu");
						System.out.println("1. Depoziteaza bani");
						System.out.println("2. Retrage bani");
						System.out.println("3. Transfera bani");
						System.out.println("4. Afiseaza conturile");
						System.out.println("5. Afiseaza balanta");
						System.out.println("6. Deschide cont nou");
						System.out.println("9. Log-Out");

						userOpt = scanner.nextInt();

						while (userOpt != 9) {
							controller.UserCommand(userOpt, client);

							System.out.println("\nUserMenu");
							System.out.println("1. Depoziteaza bani");
							System.out.println("2. Retrage bani");
							System.out.println("3. Transfera bani");
							System.out.println("4. Afiseaza conturile");
							System.out.println("5. Afiseaza balanta");
							System.out.println("6. Deschide cont nou");
							System.out.println("9. Log-Out");

							userOpt = scanner.nextInt();
						}
					}
				}

				// Autentificarea esueaza
				if (!userAuth) {
					System.out.println("Date de autentificare incorecte");
					System.out.println("Deconectare..");
					option = 9;
				}
			}

			// Meniu Admin
			if (option == 2) {
				boolean adminAuth 	= false;
				int 	adminOpt 	= -1;

				System.out.println("Introduceti parola: ");
				String password = scanner.next();

				// Autentificare admin
				if (password.equals("1234")) {
					System.out.println("Autentificare Admin permisa");

					System.out.println("\nAdmin Menu");
					System.out.println("1. Adauga Client");
					System.out.println("2. Actualizeaza Date Client");
					System.out.println("3. Sterge Client");
					System.out.println("4. Afiseaza Clienti");
					System.out.println("9. Log-Out");

					adminOpt = scanner.nextInt();

					while (adminOpt!=9) {
						controller.AdminCommand(adminOpt, Bank);

						System.out.println("\nAdmin Menu");
						System.out.println("1. Adauga Client");
						System.out.println("2. Actualizeaza Date Client");
						System.out.println("3. Sterge Client");
						System.out.println("4. Afiseaza Clienti");
						System.out.println("9. Log-Out");

						adminOpt = scanner.nextInt();
					}
				}
			}

			System.out.println();
			System.out.println();

			System.out.println("Banca " + BankName);
			System.out.println("--------------");
			System.out.println("1. User	 Menu");
			System.out.println("2. Admin Menu");
			System.out.println("9. Exit");

			option = scanner.nextInt();
		}
	}
}
