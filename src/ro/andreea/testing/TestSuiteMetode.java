package ro.andreea.testing;

import static org.junit.Assert.*;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

public class TestSuiteMetode extends TestCase {

	public static TestSuite suite(){
		TestSuite test = new TestSuite();
		
		//adaugare partiala de metode
		test.addTest(new TestProduseIncarcator("testPretZeroValue"));
		test.addTest(new TestClienti("testListaNumeNULL"));
		
		//agaudare totala
		test.addTestSuite(TestClienti.class);
		test.addTestSuite(TestProduseIncarcator.class);
		test.addTestSuite(TestProduseTelefon.class);
		test.addTestSuite(TestProduse.class);
		test.addTestSuite(TestFactura.class);
		test.addTestSuite(TestCitireFisier.class);
		
		return test;
	}
}
