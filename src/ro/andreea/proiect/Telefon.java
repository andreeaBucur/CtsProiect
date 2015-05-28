package ro.andreea.proiect;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class Telefon implements IProduse{
	private double pret;
	private String denumire;

	private static final Pattern[] regex = new Pattern[2];
	{		
			regex[0]=Pattern.compile(".*[[:punct:]]");
			regex[1]=Pattern.compile(".[a-z].*");
	}
	private final static String denMaxim="Cea mai lunga denumire posibila a unui tip de telefon ";
	
	public Telefon(){}
	
	public Telefon(double pret, String denumire){
		this.pret = pret;
		this.denumire = denumire;
	}

	public void setPret(double pret) {
		this.pret = pret;
	}
	public void setDenumire(String Denumire) throws LungimeMinException, LungimeMaxException, FirstNumberException, ValoareNecorespunzatoareException {
		if(Denumire.length()<5) 
			throw new LungimeMinException();
		if(Denumire.length()> denMaxim.length())
			throw new LungimeMaxException();
		if(!regex[0].matcher(Denumire).matches())
			throw new LungimeMaxException();
		if(regex[1].matcher(Denumire).matches()) 
			throw new ValoareNecorespunzatoareException();
		this.denumire = Denumire;
		 
	}
	public double getPret() {
		return this.pret;
	}
	public String getDenumire() {
		return this.denumire;
	}

}
