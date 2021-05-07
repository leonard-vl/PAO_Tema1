public class Cont {
	private String	Nume;
	private int		ID;
	private int		BalantaCont;

	public Cont() {
		this.Nume			= "NULL";
		this.ID				= -1;
		this.BalantaCont	= 0;
	}
	public Cont(String nume) {
		this.Nume 			= nume;
		this.ID 			= -1;
		this.BalantaCont 	= 0;
	}

	public int			getBalantaCont() {
		return BalantaCont;
	}
	public String		getNume() {
		return Nume;
	}
	public int 			getID() {
		return ID;
	}

	public void setNume			(String nume) {
		Nume = nume;
	}
	public void setID			(int ID) {
		this.ID = ID;
	}
	public void setBalantaCont	(int balantaCont) {
		BalantaCont = balantaCont;
	}

	@Override
	public String toString() {
		return "Cont{" +
				"Nume='" + Nume + '\'' +
				", ID=" + ID +
				", BalantaCont=" + BalantaCont +
				'}';
	}
}
