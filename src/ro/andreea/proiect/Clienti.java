package ro.andreea.proiect;
import java.util.ArrayList;


public class Clienti implements Observer {
	private String nume, prenume;
	private String CNP;
	private double venitLunar;
	
	//valoare maxima venit
	public final static double max = 1000000.0;
	
	public Clienti(String nume, String prenume, String CNP, double venit){
		this.nume = nume;
		this.prenume = prenume;
		this.CNP = CNP;
		this.venitLunar = venit;
	}
	
	public Clienti(){}
	

	public String getNume() {
		return nume;
	}



	public void setNume(String nume) {
		this.nume = nume;
	}



	public String getPrenume() {
		return prenume;
	}



	public void setPrenume(String prenume) {
		this.prenume = prenume;
	}


	public String getCNP() {
		return CNP;
	}

	public void setCNP(String cNP) throws IllegalException, FirstNumberException {
		if(cNP.length() != 13) 
			throw new IllegalException(" ");
		if(cNP.charAt(0)!=1)
			throw new FirstNumberException(" ");
		else if(cNP.charAt(0)!=2)
			throw new FirstNumberException(" ");
		this.CNP = cNP;
		
	}	

	public double getVenitLunar() {
		return venitLunar;
	}

	public void setVenitLunar(double VenitLunar) throws VenitMaxException, ValoriNegativeException {
		if(VenitLunar>Clienti.max) 
			throw new VenitMaxException();
		if(VenitLunar<0) 
			throw new ValoriNegativeException();
		
		this.venitLunar = VenitLunar;
	}

	@Override
	public void modifica(String disponibilitate) {
		System.out.println("Buna ziua "+nume+" "+prenume+", produsul solicitat este acum "+disponibilitate+" . Va multumim!");
		
	}

	public ArrayList<String> listaNume(String nume, String prenume){
		ArrayList<String> lista=null;
		if(nume.length()>8 || prenume.length()>20){
			lista = new ArrayList<String>();
			lista.add(nume);
			lista.add(prenume);
		}
		return lista;
	}
	
	public double calculVenitAnual(double venitLunar) throws VenitMaxException, ValoareNecorespunzatoareException, ZeroException{
		if(venitLunar> Clienti.max) 
			throw new VenitMaxException();
		if(!esteValid(venitLunar))
			throw new ValoareNecorespunzatoareException();
		if(venitLunar==0)
			throw new ZeroException();
		venitLunar = this.getVenitLunar() * 12;
		return venitLunar;
	}
	
	private boolean esteValid(double valoare) {
		double valoare2 = valoare*100;
		double intreg = Math.floor(valoare2);
		double valoare3 = (double)intreg / 100.0;
		
		if(valoare <= valoare3)
			return true;
		
		return false;
	}

	public double calculBonus(Clienti detaliiClient){
		double bonus = 0;
		if(detaliiClient.getVenitLunar()< 1500 && detaliiClient.getVenitLunar()!=0){
			bonus = 50;
		}else {
			bonus = 100;
		}
		if(detaliiClient.getVenitLunar()==0){
			bonus=0;
		}
		return bonus;
	}
	
	
	public Clienti clone(){
		return new Clienti(this.nume, this.prenume, this.CNP, this.venitLunar);
	}

	}

