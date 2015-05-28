package ro.andreea.proiect;

public interface SubjectObserver {
	public void attach(Observer observer);
	public void detach(Observer observer);
	public void notifyObserver();
}
