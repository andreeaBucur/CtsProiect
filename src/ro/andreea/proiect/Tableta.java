package ro.andreea.proiect;
import java.util.ArrayList;


public class Tableta implements IProduse {
	private double pret;
	private String denumire;
	
	public Tableta(){}
	
	public Tableta(float pret, String den){
		this.pret=pret;
		this.denumire = denumire;
	}
	public double getPret() {
		
		return this.pret;
	}

	public String getDenumire() {
		
		return this.denumire;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

}
