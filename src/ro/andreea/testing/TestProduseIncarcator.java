package ro.andreea.testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

import ro.andreea.proiect.Incarcator;
import ro.andreea.proiect.PretMaxException;
import ro.andreea.proiect.ValoriNegativeException;
import ro.andreea.proiect.ZeroException;

public class TestProduseIncarcator extends TestCase {

	private Incarcator incarcator;
	
	static double[] valoriNegative;
	
	public void setUp()throws Exception{
		System.out.println("Pregatire test - creare obiecte.");
		incarcator = new Incarcator(250, "Nokia wireless charging stand");
		valoriNegative= new double [3];
		valoriNegative[0]=-3;
		valoriNegative[1]=-5;
		valoriNegative[2]=-2;
	}
	
	public void tearDown()throws Exception{
		System.out.println("Finalizare test - stergere obiecte.");
	}
	
	public TestProduseIncarcator(String name){
		super(name);
	}
	
	public void testPretMaxim(){
		try{
		float pret = 789;
		this.incarcator.setPret(pret);
		fail("Lipsa exceptie pentru un pret mai mare decat pretul maxim.");
		}catch(Exception ex){
			
		}
	}
	
	public void testPretZeroValue(){
		try{
			this.incarcator.setPret(0.0);
			fail("Metoda nu genereaza exceptie pe input  = 0.");
		}catch(Exception ex){
			
		}
	}
	
	public void testPretValoareNegativa() throws PretMaxException, ZeroException{
		for(double valoare:valoriNegative ){
			Incarcator c = this.incarcator.clone();
			try{
			c.setPret(valoare);
			this.incarcator.setPret(-24);
			fail("Metoda nu genereaza exceptie pe input-uri negative.");
			}catch(ValoriNegativeException ex){}
		}
	}
}
