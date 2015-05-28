package ro.andreea.proiect;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Factura {
	private Produse produs;
	private String furnizor;
	private Date dataFacturarii;
	
	public static Calendar cal = Calendar.getInstance();
    
	
	public Factura(){}
	
	public Factura(Produse produs, String furnizor, Date data){
		this.produs = produs;
		this.furnizor = furnizor;
		this.dataFacturarii = data;
	}

	public Produse getProdus() {
		return produs;
	}

	public void setProdus(Produse produs) {
		this.produs = produs;
	}

	public String getFurnizor() {
		return furnizor;
	}

	public void setFurnizor(String furnizor) {
		this.furnizor = furnizor;
	}

	public Date getDataFacturarii() {
		return dataFacturarii;
	}

	public void setDataFacturarii(Date dataFacturarii) throws ValoareNecorespunzatoareException {
		this.dataFacturarii = dataFacturarii;
	}
	
	public static int getYearFromDate(Date data) throws ValoareNecorespunzatoareException {
	    int rezultat = -1;
	    if (data != null) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(data);
	        rezultat = cal.get(Calendar.YEAR);
	    }
	    if(rezultat< 2015) 
	    	throw new ValoareNecorespunzatoareException();
	    if(rezultat > 2015)
	    	throw new ValoareNecorespunzatoareException();
	    return rezultat;
	    
	}
	public static int getDayFromDate(Date data) throws ValoareNecorespunzatoareException {
	    int rez = -1;
	    if (data != null) {
	        Calendar cal = Calendar.getInstance();
	        cal.setTime(data);
	        rez = cal.get(Calendar.DAY_OF_WEEK);
	    }
	    if(rez==cal.get(Calendar.SATURDAY) && rez == cal.get(Calendar.SUNDAY))
	    	throw new ValoareNecorespunzatoareException();
	    return rez;
	    
	}
	public double totalFactura(){
		//ArrayList<Produse> listaProduse = new ArrayList<>();
		ArrayList<Produse> listaProduse = null;
		double total = 0;
		if(listaProduse.size()>1){
		listaProduse = new ArrayList<>();
		for(int i=0; i<listaProduse.size();i++){
			listaProduse.add(produs);
		}
		int[] cantitati = new int[listaProduse.size()];
		Random rand = new Random();
		for(int i=0; i<cantitati.length; i++){
			cantitati[i] = rand.nextInt((100 - 1) + 1) + 1;
		}
		for(int i=0; i<listaProduse.size();i++){
			total = total+produs.getPretProdus()*cantitati[i];
		}
		}
		return  total;
	}
	
}
