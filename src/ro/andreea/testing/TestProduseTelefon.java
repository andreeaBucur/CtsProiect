package ro.andreea.testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.andreea.proiect.Telefon;

public class TestProduseTelefon extends TestCase{
	
	private Telefon telefon;
	

	@Before
	public void setUp() throws Exception {
		System.out.println("Pregatire test - creare obiecte.");
		telefon = new Telefon(900, "Samsung Galaxy S6");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizare test - stergere obiecte.");
	}

	public TestProduseTelefon(String name){
		super(name);
	}

	public void testLungimeMinimaDenumire(){
		try{
			this.telefon.setDenumire("sg");
			fail("Metoda nu genereaza exceptie pentru denumire cu mai putin de 5 caractere.");
		}catch(Exception ex){
			
		}	
	}
	
	public void testLungimeMaximaDenumire(){
		try{
			this.telefon.setDenumire("telefon cu un numar foarte mare de caractere...etc etc etc");
			fail("Metoda nu genereaza exceptie pentru denumire cu un numar foarte mare de caractere.");
		}catch(Exception ex){
			
		}
	}
	
	public void testFirstCharacter(){
		try{
			this.telefon.setDenumire("*$madalina");
			fail("Metoda nu genereaza exceptie pentru denumirea ce incepe cu simbol.");
		}catch(Exception ex){
			
		}
	}
	
	public void testNoLetterInDenumire(){
		try{
			this.telefon.setDenumire("Samsung ###");
			fail("Metoda nu genereaza exceptie pentru denumiri ce nu contin litere.");
		}catch(Exception ex){}
	}
}
