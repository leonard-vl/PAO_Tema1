import java.time.LocalDate;

public class PersoanaFizica extends Client{
	public PersoanaFizica() {
	}
	public PersoanaFizica(String nume, String prenume, String CNP, LocalDate dataNasterii, int ID) {
		super(nume, prenume, CNP, dataNasterii, ID);
	}
}
