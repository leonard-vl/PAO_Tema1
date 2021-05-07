import java.util.HashMap;

public class Banca {
	private String Nume;
	private HashMap<Integer, Client> ListaClienti;
	private int NumarClienti;

	public Banca(String nume) {
		this.Nume           = nume;
		this.ListaClienti   = new HashMap<Integer, Client>();
		this.NumarClienti   = 0;
	}

	public int 						getNumarClienti(){
		return NumarClienti;
	}
	public String 					getNume(){
		return this.Nume;
	}
	public HashMap<Integer, Client> getListaClienti(){
		return this.ListaClienti;
	}

	public void setNume			(String nume) {
		this.Nume = nume;
	}
	public void setListaClienti	(HashMap<Integer,Client> ListaClienti) {
		this.ListaClienti = ListaClienti;
	}
	public void setNumarClienti (int numarClienti) {
		NumarClienti = numarClienti;
	}
}