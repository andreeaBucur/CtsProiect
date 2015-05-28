package ro.andreea.proiect;
import java.util.ArrayList;


public class Incarcator implements IProduse {
	private double pret;
	private String denumire;
	
	public final static double pretMax = 500;
	
	public Incarcator(double pret, String denumire){
		this.pret = pret;
		this.denumire = denumire;
	}
	
	public Incarcator(){}

	public double getPret() {
		return this.pret;
	}

	public String getDenumire() {
		return this.denumire;
	}

	public void setPret(double Pret) throws PretMaxException, ValoriNegativeException, ZeroException {
		if(Pret> Incarcator.pretMax) 
			throw new PretMaxException();
		if(Pret< 0) 
			throw new ValoriNegativeException();
		if(Pret == 0)
			throw new ZeroException();
		this.pret = Pret;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Incarcator clone(){
		return new Incarcator(this.pret, this.denumire);
	}
	
	
	

}
