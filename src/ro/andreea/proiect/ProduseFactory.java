package ro.andreea.proiect;

public class ProduseFactory {

	public IProduse getProduse(String getTip){
		if(getTip==null){
			return null;
		}
		if(getTip.equalsIgnoreCase("Tableta")){
			return new Tableta();
		}
		else if(getTip.equalsIgnoreCase("Telefon")){
			return new Telefon();
		}
		else if(getTip.equalsIgnoreCase("Incarcator")){
			return new Incarcator();
		}
		return null;
	}
}
