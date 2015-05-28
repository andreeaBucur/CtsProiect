package ro.andreea.proiect;


public class Utilizator {
	
	private String nume;
	private int varsta;
	
	
	
	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public int getVarsta() {
		return varsta;
	}

	public void setVarsta(int varsta) {
		this.varsta = varsta;
	}
	
	//singleton
	//creare obiect pentru Utilizator
	private static Utilizator instance = new Utilizator();
	
	//constructor privat pentru a nu putea fi instantiat
	private Utilizator(){}
	
	//metoda ce da acces la instanta unica
	public static Utilizator getInstance(){
		return instance;
	}
	
	public void showMessage(){
		System.out.println("Utilizator unic!");
	}
	
	
}
	
	

