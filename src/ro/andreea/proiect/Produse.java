package ro.andreea.proiect;
import java.util.ArrayList;


public class Produse implements SubjectObserver{
	private String denumire;
	private String tipProdus;
	String disponibilitate;
	private double pretProdus;
	private ArrayList<Observer> listaObs = new ArrayList<Observer>();
	
	private final static String tipMaxim = "tipul produs lungime maxima";
	
	public Produse(String denumire, String tipProdus, String disponibilitate){
		super();
		this.denumire = denumire;
		this.tipProdus = tipProdus;
		this.disponibilitate = disponibilitate;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public String getTipProdus() {
		return tipProdus;
	}
	
	

	public double getPretProdus() {
		return pretProdus;
	}

	public void setPretProdus(double pretProdus) {
		this.pretProdus = pretProdus;
	}

	public void setTipProdus(String tipProdus) throws ValoareNecorespunzatoareException, LungimeMaxException, LungimeMinException {
		if(tipProdus.length()>tipMaxim.length()) 
			throw new LungimeMaxException();
		if(tipProdus.length()<4)
			throw new LungimeMinException();
		if(tipProdus.equals("tableta")==false && tipProdus.equals("telefon")==false && tipProdus.equals("incarcator")==false)
			throw new ValoareNecorespunzatoareException();
		this.tipProdus = tipProdus;
	}

	public String getDisponibilitate() {
		return disponibilitate;
	}

	public void setDisponibilitate(String disponibilitate) {
		this.disponibilitate = disponibilitate;
		notifyObserver();
		
	}

	public ArrayList<Observer> getListaObs() {
		return listaObs;
	}

	public void setListaObs(ArrayList<Observer> listaObs) {
		this.listaObs = listaObs;
	}

	@Override
	public void attach(Observer observer) {
		listaObs.add(observer);
		
	}

	@Override
	public void detach(Observer observer) {
		listaObs.remove(observer);
		
	}

	@Override
	public void notifyObserver() {
		System.out.println("Notificare atunci cand produsul devine disponibil.");
		for(Observer ob:listaObs){
			ob.modifica(this.disponibilitate);
		}
	}
	
	
}
