package ro.andreea.testing;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ro.andreea.proiect.Clienti;
import ro.andreea.proiect.Factura;
import ro.andreea.proiect.ValoareNecorespunzatoareException;
import ro.andreea.proiect.ValoriNegativeException;
import ro.andreea.proiect.VenitMaxException;
import ro.andreea.proiect.ZeroException;

public class TestCitireFisier extends TestCase {
	static BufferedReader bf;
	static FileReader reader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println(" Pregatire executie test.");
		reader = new FileReader(new File("date"));
		bf = new BufferedReader(reader);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bf.close();
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("Pregatire test - creare obiecte.");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizare test.");
	}

	public void testCitireFisier() throws VenitMaxException,
			ValoriNegativeException, ValoareNecorespunzatoareException,
			ZeroException {
		Clienti client = new Clienti();
		try {
			reader = new FileReader("date");
			bf = new BufferedReader(reader);

			String inregistrare = bf.readLine();
			while ((inregistrare != null) && (inregistrare.length() != 0)) {
				String[] valori = inregistrare.split(",");
				String nume = valori[0];
				String prenume = valori[1];
				double venitLunar = Double.parseDouble(valori[2]);
				double venitAnual = Double.parseDouble(valori[3]);
				client.setVenitLunar(venitLunar);
				System.out.println("Clientul: " + nume + prenume
						+ " are un venit lunar de: " + venitLunar
						+ " ,iar pe an castiga: " + venitAnual);
				assertEquals(venitAnual, client.calculVenitAnual(venitLunar), 0);

				inregistrare = bf.readLine();
			}
		} catch (FileNotFoundException ex) {
		} catch (IOException E) {

		}

	}
	
	public void testCitireNull(){
		Clienti client = new Clienti();
		try{
			String linie = bf.readLine();
			while(linie!=null){
				String[] linii = linie.split(",");
				String nume = linii[0];
				String prenume = linii[1];
				double venitLunar = Double.parseDouble(linii[2]);
				double venitAnual = Double.parseDouble(linii[3]);
				client.setVenitLunar(venitLunar);
				assertNull(client.calculVenitAnual(venitLunar));
			}
		}catch(Exception ex){
			
		}
	}
	
	public void testCitireFIsierNotNull(){
		Clienti client = new Clienti();
		try{
			String linie = bf.readLine();
			while(linie!=null){
				String[] linii = linie.split(",");
				String nume = linii[0];
				String prenume = linii[1];
				double venitLunar = Double.parseDouble(linii[2]);
				double venitAnual = Double.parseDouble(linii[3]);
				client.setVenitLunar(venitLunar);
				assertNotNull(client.calculVenitAnual(venitLunar));
			}
	}catch(Exception ex){}
}
	}
