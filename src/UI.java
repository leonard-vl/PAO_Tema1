
import java.util.Scanner;

public class UI {

	public void program() {
		int option;

		Scanner scanner 		= new Scanner(System.in);
		Controller controller 	= new Controller();

		System.out.println("Enter the Bank name: ");
		String BankName = scanner.next();

		Banca Bank = new Banca(BankName);

		System.out.println("Bank " + BankName);
		System.out.println("--------------");
		System.out.println("1. User	 Menu");
		System.out.println("2. Admin Menu");
		System.out.println("9. Exit");

		option = scanner.nextInt();

		while (option!=9) {

			// User menu
			if (option == 1) {
				boolean userAuth	= false;
				int idClient		= -1;
				int userOpt			= -1;

				System.out.println("Introduceti CNP:");
				String loginCNP = scanner.next();

				// Client authentication
				for (Client client : Bank.getListaClienti().values()) {
					if (loginCNP.equals(client.getCNP())) {
						userAuth = true;
						idClient = client.getID();

						System.out.println("User authentication successful\n");

						System.out.println("UserMenu");
						System.out.println("1. Deposit money");
						System.out.println("2. Withdraw money");
						System.out.println("3. Transfer money");
						System.out.println("4. Display accounts");
						System.out.println("5. Display balance");
						System.out.println("6. Open new account");
						System.out.println("9. Log-Out");

						userOpt = scanner.nextInt();

						while (userOpt != 9) {
							controller.UserCommand(userOpt, client);

							System.out.println("UserMenu");
							System.out.println("1. Deposit money");
							System.out.println("2. Withdraw money");
							System.out.println("3. Transfer money");
							System.out.println("4. Display accounts");
							System.out.println("5. Display balance");
							System.out.println("6. Open new account");
							System.out.println("9. Log-Out");

							userOpt = scanner.nextInt();
						}
					}
				}

				if (!userAuth) {
					System.out.println("Wrong credentials");
					System.out.println("Disconnecting...");
					option = 9;
				}
			}

			// Meniu Admin
			if (option == 2) {
				boolean adminAuth 	= false;
				int 	adminOpt 	= -1;

				System.out.println("Enter password: ");
				String password = scanner.next();

				// Admin authentication
				if (password.equals("1234")) {
					System.out.println("Admin authentication successful");

					System.out.println("\nAdmin Menu");
					System.out.println("1. Add Client");
					System.out.println("2. Update Client data");
					System.out.println("3. Delete Client");
					System.out.println("4. Display Clients");
					System.out.println("9. Log-Out");

					adminOpt = scanner.nextInt();

					while (adminOpt!=9) {
						controller.AdminCommand(adminOpt, Bank);

						System.out.println("\nAdmin Menu");
						System.out.println("1. Add Client");
						System.out.println("2. Update Client data");
						System.out.println("3. Delete Client");
						System.out.println("4. Display Clients");
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
