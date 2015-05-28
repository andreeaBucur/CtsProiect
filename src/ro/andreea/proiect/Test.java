package ro.andreea.proiect;
import java.util.ArrayList;


public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ProduseFactory factory = new ProduseFactory();
		
		IProduse produs1 = factory.getProduse("Telefon");
		produs1.getPret();
		
		
		IProduse produs2 = factory.getProduse("Tableta");
		produs2.getDenumire();
		
		IProduse produs3 = factory.getProduse("Telefon");
		
	
		//singleton
		Utilizator unic = Utilizator.getInstance();
		unic.showMessage();
		
		//observer
		Clienti client1 = new Clienti("Cretu", "Elena","2671023152490", 1780);
		Clienti client2 = new Clienti("Popescu", "Marian", "1690702151324", 1500);
		
		Produse produse1 = new Produse("Samsung galaxy S6", "Smartphone", "Disponibil");
		produse1.attach(client1);
		produse1.attach(client2);
		
		produse1.setDisponibilitate("Indisponibil");
	
		
	}

}
