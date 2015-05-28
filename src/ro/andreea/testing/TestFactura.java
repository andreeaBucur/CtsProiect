package ro.andreea.testing;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ro.andreea.proiect.Factura;
import ro.andreea.proiect.Produse;
import ro.andreea.proiect.ValoareNecorespunzatoareException;

public class TestFactura extends TestCase{
	private Factura factura;
	
	public Calendar cal = Calendar.getInstance();

	@Before
	public void setUp() throws Exception {
		System.out.println("Pregatire test - creare obiecte");
		factura = new Factura();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Finalizare test - stergere obiecte");
	}
	
	public TestFactura(String name){
		super(name);
	}

	public void testAnFacturaMaiMic() throws ValoareNecorespunzatoareException{
		Date data = new Date();
		int year = this.factura.getYearFromDate(data);
		assertEquals(year, 2015);
		
	}
	
	public void testAnFacturaMaiMare() throws ValoareNecorespunzatoareException{
		Date data1 = new Date();
		int year = this.factura.getYearFromDate(data1);
		assertEquals(year, 2015);
	}
	
	public void testFacturareSambDum() throws ValoareNecorespunzatoareException{
		Date data2 = new Date();
		int day = this.factura.getDayFromDate(data2);
		assertEquals(day, 5);
	}
	
	public void testTotalFacturaNull(){
		try{
			assertNull(this.factura.totalFactura());
		}catch(Exception ex){}
	}
	
	public void testTotalFacturaNotNull(){
		try{
			assertNotNull(this.factura.totalFactura());
		}catch(Exception ex){
			
		}
	}
	
	}


