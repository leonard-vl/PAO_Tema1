
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Controller {
	public Controller() {
	}

	// Implementare Comenzi Utilizator
	public void UserCommand(int option, Client client){
		Scanner scanner	= new Scanner(System.in);

		// Depoziteaza bani
		if (option == 1) {
			int idCont = -1;
			int suma;
			boolean found = false;
			String numeCont;

			System.out.println("Enter account name: ");
			numeCont = scanner.next();

			for (Cont cont : client.getListaConturi().values()) {
				if(cont.getNume().equals(numeCont)) {
					idCont	= cont.getID();
					found	= true;
				}
			}

			if (found) {
				System.out.println("Enter desired amount: ");
				suma = scanner.nextInt();

				client.getListaConturi().get(idCont)
						.setBalantaCont(client.getListaConturi().get(idCont)
								.getBalantaCont()+suma);
				// client.depoziteaza(idCont, suma);
			}
		}

		// Retrage bani
		else if (option == 2) {
			int idCont = -1;
			int suma;
			boolean found = false;
			String numeCont;

			System.out.println("Enter account name: ");
			numeCont = scanner.next();

			for (Cont cont : client.getListaConturi().values()) {
				if(cont.getNume().equals(numeCont)) {
					idCont	= cont.getID();
					found	= true;
				}
			}

			if (found) {
				System.out.println("Enter desired amount: ");
				suma = scanner.nextInt();

				client.getListaConturi().get(idCont)
						.setBalantaCont(client.getListaConturi().get(idCont)
								.getBalantaCont() - suma);
			}
		}

		// Transfera bani
		else if (option == 3) {
			int idContSursa = -1, idContDest = -1, suma;
			boolean foundSursa = false, foundDest = false;
			String numeContSursa, numeContDest;

			System.out.println("Enter sender account name: ");
			numeContSursa = scanner.next();

			System.out.println("Enter receiver account name: ");
			numeContDest  = scanner.next();

			for (Cont cont : client.getListaConturi().values()) {
				if (cont.getNume().equals(numeContSursa)){
					idContSursa = cont.getID();
					foundSursa	= true;
				}

				else if (cont.getNume().equals(numeContDest)) {
					idContDest	= cont.getID();
					foundDest	= true;
				}
			}

			if (foundDest && foundSursa){
				System.out.println("Enter desired amount: ");
				suma = scanner.nextInt();

				client.getListaConturi().get(idContSursa)
						.setBalantaCont(client.getListaConturi().get(idContSursa)
								.getBalantaCont() - suma);

				client.getListaConturi().get(idContDest)
						.setBalantaCont(client.getListaConturi().get(idContDest)
								.getBalantaCont() + suma);
			}
		}

		// Afiseaza conturile curente
		else if (option == 4) {
			for (Cont cont : client.getListaConturi().values()) {
				System.out.println(cont.toString());
			}
		}

		// Afiseaza balanta totala
		else if (option == 5) {
			int balantaTotala = 0;
			for (Cont cont : client.getListaConturi().values()) {
				balantaTotala += cont.getBalantaCont();
			}

			System.out.println("Total balance: " + balantaTotala);
		}

		// Deschide cont nou
		else if (option == 6) {
			String	numeCont;
			Cont	newCont = new Cont();

			System.out.println("Account name: ");
			numeCont = scanner.next();

			newCont.setNume	(numeCont);
			newCont.setID	(client.getNumarConturi());

			client.setNumarConturi(client.getNumarConturi()+1);
			client.getListaConturi().put(newCont.getID(), newCont);
		}

		// Deconectare
		else if (option == 9) {

		}
	}

	// Implementare Comenzi Admin
	public void AdminCommand(int option, Banca bank) {
		Scanner scanner = new Scanner(System.in);
		int adminOpt = -1;

		// Insereaza client
		if (option == 1) {
			System.out.println("1. Natural Person");
			System.out.println("2. Legal Person");

			adminOpt = scanner.nextInt();

			if (adminOpt == 1) {
				Client client = new PersoanaFizica();

				System.out.println("Firstname: ");
				client.setNume(scanner.next());

				System.out.println("Lastname: ");
				client.setPrenume(scanner.next());

				System.out.println("Social Security ID: ");
				client.setCNP(scanner.next());

				System.out.println("Birthdate:  day/month/year (01.01.1999)");
				String dateInput = scanner.next();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
				LocalDate dataNasterii = LocalDate.parse(dateInput, dateFormat);
				client.setDataNasterii(dataNasterii);

				client.setID(bank.getNumarClienti());

				bank.setNumarClienti(bank.getNumarClienti() + 1);
				bank.getListaClienti().put(client.getID(), client);
				// bank.adaugaClient(client.getID(), client);
			}

			if (adminOpt == 2) {
				Client client = new PersoanaJuridica();

				System.out.println("Firstname: ");
				client.setNume(scanner.next());

				System.out.println("Lastname: ");
				client.setPrenume(scanner.next());

				System.out.println("Social Security ID: ");
				client.setCNP(scanner.next());

				System.out.println("Birthdate: ");
				String dateInput = scanner.next();
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
				LocalDate dataNasterii = LocalDate.parse(dateInput, dateFormat);
				client.setDataNasterii(dataNasterii);

				client.setID(bank.getNumarClienti());

				bank.setNumarClienti(bank.getNumarClienti() + 1);
				bank.getListaClienti().put(client.getID(), client);
			}

			System.out.println("Data was successfully inserted");
		}
		
		// Modifica date client
		else if (option == 2) {
			Client temp  = new Client();
			String newName, newPrenume, newCNP, dateInput;
			DateTimeFormatter dateFormat;
			LocalDate dataNasterii;

			System.out.println("Enter Client ID: ");
			int idClient = scanner.nextInt();

			System.out.println("New Firstname: ");
			newName		= scanner.next();

			System.out.println("New Lastname: ");
			newPrenume	= scanner.next();

			System.out.println("New Social Security ID: ");
			newCNP 		= scanner.next();

			System.out.println("New Birthdate: ");
			dateInput = scanner.next();
			dateFormat = DateTimeFormatter.ofPattern("d/M/yyyy");
			dataNasterii = LocalDate.parse(dateInput, dateFormat);

			temp.setNume		(newName);
			temp.setPrenume		(newPrenume);
			temp.setCNP			(newCNP);
			temp.setDataNasterii(dataNasterii);
			temp.setID			(bank.getListaClienti().get(idClient).getID());
			temp.setListaConturi(bank.getListaClienti().get(idClient).getListaConturi());
			temp.setNumarConturi(bank.getListaClienti().get(idClient).getNumarConturi());

			bank.getListaClienti().replace(idClient, temp);

			System.out.println("Data for Client ID " + idClient + " have been updated");
		}

		// Sterge client
		else if (option == 3) {
			System.out.println("Enter Client ID: ");
			int idClient = scanner.nextInt();

			bank.getListaClienti().remove(idClient);

			System.out.println("The Client with ID " + idClient + " has been deleted");
		}

		// Afiseaza toti clientii
		else if (option == 4) {
			for (Client client : bank.getListaClienti().values()) {
				System.out.println(client.toString());
			}
		}

		// Deconectare
		else if (option == 9) {
		}
	}
}
