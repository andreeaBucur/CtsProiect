package ro.andreea.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.TestCase;
import ro.andreea.proiect.*;


import org.junit.Test;

public class TestClienti extends TestCase {

	private Clienti client ; 
	
	static double[] valoriNegative;
	
	
	public void setUp(){
		System.out.println("Pregatire test - creare obiecte");
		client = new Clienti("Bucur", "Andreea","2930702152490", 1500);
		valoriNegative= new double[3];
		valoriNegative[0]=-9;
		valoriNegative[1]=-18;
		valoriNegative[2]=-4;
	}
	
	public void tearDown(){
		System.out.println("Finalizare test - stergere obiecte");
	}
	
	public TestClienti(String name){
		super(name);
	}
	
	public void testListaNumeNULL(){
		
		ArrayList<String> lista = client.listaNume(" ", " ");
		assertNull(lista);
	}
	
	public void testListaNumeNOTNULL(){
		
		ArrayList<String> lista = client.listaNume("Numede familie foarte lung", "Ana-Maria Elena");
		assertNotNull(lista);
	}
	
	
	public void testCNPScurt(){
		try{
			this.client.setCNP("2935249");
			fail("Metoda nu genereaza exceptie pe cnp scurt.");
			
		}catch(Exception ex){
		}
	}
	
	public void testFirstNumberCNP(){
		try{
			this.client.setCNP("5239439345678");
			fail("Prima cifra este 5!");
		}catch(Exception ex){
			
		}
	}
	
	public void testCNPLung(){
		try{
			this.client.setCNP("29003041827138922");
			fail("Cnp-ul are prea multe cifre");
		}catch(Exception ex){
			
		}
	}
	
	public void testCalculVenitAnual(){
		try{
		double venit = this.client.calculVenitAnual(3800);
		assertEquals(18000,  venit, 0.0);
		}catch(Exception ex){
			
		}
	}
	
	public void testVenitMaxim(){
		try{
			double venit = 485750890.35;
			this.client.calculVenitAnual(venit);
			fail("Lipsa exceptie pe venit mai mare decat maxim.");
		}catch(Exception ex){}
	}
	
	public void testValoareRealaVenit(){
		try{
			double venit = 1700.2555;
			this.client.calculVenitAnual(venit);
			fail("Se accepta si valori cu mai multe de 2 zecimale.");
		}catch(Exception ex){}
	}
	
	public void testVenitZero(){
		try{
			this.client.calculVenitAnual(0);
			fail("Nu se genereaza exceptie pentru input = 0");
		}catch(Exception ex){}
	}
	
	public void testCalculBonus(){
		try{
			this.client.setVenitLunar(3000);
			double bonus = this.client.calculBonus(client);
			assertEquals(100, bonus, 0.0);
		}catch (Exception ex){
			
		}
	}
	
	public void testVenitNull(){
		try{
			this.client.setVenitLunar(0);
			double venit = this.client.calculBonus(client);
			assertEquals(0,  venit, 0.0);
		}catch(Exception ex){
			
		}
	}
	
	
	public void testClientiSalariuMax(){
		try{
			double sal = 9999999.99;
			this.client.setVenitLunar(sal);
			fail("Metoda nu genereaza exceptie pentru un venit mai mare decat salariul maxim.");
		}catch(Exception ex){	
		}
	}
	
	public void testClientiSalariuValNegativa() throws VenitMaxException, ZeroException, ValoriNegativeException{
		for(double valoare: valoriNegative){
			Clienti c = this.client.clone();
			try{
			c.setVenitLunar(valoare);
			this.client.setVenitLunar(-36);
			fail("Metoda nu genereaza exceptie pentru valori negative");
		}
		catch(ValoriNegativeException ex){}
		
	}}
	
}
