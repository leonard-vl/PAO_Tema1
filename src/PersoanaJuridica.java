import java.time.LocalDate;

public class PersoanaJuridica extends Client{
	public PersoanaJuridica() {
	}
	public PersoanaJuridica(String nume, String prenume, String CNP, LocalDate dataNasterii, int ID) {
		super(nume, prenume, CNP, dataNasterii, ID);
	}
}