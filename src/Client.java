import java.time.LocalDate;
import java.util.HashMap;

public class Client {
	protected String Nume;
	protected String Prenume;
	protected String CNP;
	protected LocalDate DataNasterii;
	protected HashMap<Integer, Cont> ListaConturi;
	protected int NumarConturi;
	protected int ID;

	public Client() {
		this.Nume			= "NULL";
		this.Prenume		= "NULL";
		this.CNP			= "NULL";
		this.DataNasterii	= LocalDate.now();
		this.ListaConturi	= new HashMap<>();
		this.ID				= -1;
		this.NumarConturi	= 0;
	}
	public Client(String nume, String prenume, String CNP, LocalDate dataNasterii, int ID) {
		this.Nume			= nume;
		this.Prenume		= prenume;
		this.CNP			= CNP;
		this.DataNasterii	= dataNasterii;
		this.ListaConturi	= new HashMap<Integer, Cont>();
		this.ID				= ID;
		this.NumarConturi	= 0;
	}

	public String					getNume() {
		return Nume;
	}
	public String 					getPrenume() {
		return Prenume;
	}
	public String 					getCNP() {
		return CNP;
	}
	public LocalDate 				getDataNasterii() {
		return DataNasterii;
	}
	public HashMap<Integer, Cont> 	getListaConturi() {
		return ListaConturi;
	}
	public int						getID() {
		return ID;
	}
	public int						getNumarConturi() {
		return NumarConturi;
	}

	public void setNumarConturi	(int numarConturi) {
		NumarConturi = numarConturi;
	}
	public void setNume			(String nume) {
		Nume = nume;
	}
	public void setPrenume		(String prenume) {
		Prenume = prenume;
	}
	public void setCNP			(String CNP) {
		this.CNP = CNP;
	}
	public void setDataNasterii	(LocalDate dataNasterii) {
		DataNasterii = dataNasterii;
	}
	public void setListaConturi	(HashMap<Integer, Cont> listaConturi) {
		ListaConturi = listaConturi;
	}
	public void setID			(int ID) {
		this.ID = ID;
	}

	@Override
	public String toString() {
		return "Client{" +
				"Nume='" + Nume + '\'' +
				", Prenume='" + Prenume + '\'' +
				", CNP='" + CNP + '\'' +
				", DataNasterii=" + DataNasterii +
				", ListaConturi=" + ListaConturi +
				", NumarConturi=" + NumarConturi +
				", ID=" + ID +
				'}';
	}
}