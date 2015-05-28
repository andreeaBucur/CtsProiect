package ro.andreea.testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.andreea.proiect.Produse;

public class TestProduse extends TestCase {
	
	private Produse produs;

	@Before
	public void setUp() throws Exception {
		System.out.println("Pregatire test - creare obiecte");
		produs = new Produse("Samsung Galaxy Tab 3", "tableta", "disponibil");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizare test - stergere obiecte");
	}
	public TestProduse(String name){
		super(name);
	}
	
	public void testTipProdusLungimeMax(){
		try{
			this.produs.setTipProdus("smartphone - tip telefon avansat cu functionalitati inteligente");
			fail("Metoda nu genereaza exceptie pentru o lungime mai mare decat lungimea maxima a tipului de produs.");
		}catch(Exception ex){
			
		}
	}
	
	public void testTipProdusLungimeMin(){
		try{
			this.produs.setTipProdus("prod");
			fail("Metoda nu genereaza exceptie pentru o lungime mai putin de 4 caractere.");
		}catch(Exception ex){
			
		}
	}
	public void testTipProdus(){
		try{
			this.produs.setTipProdus("ruj");
			fail("Metoda nu genereaza exceptie pentru alte tipuri de produse");
		}catch(Exception ex){
			
		}
	}

	

}
