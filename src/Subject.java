// Importação de Bibliotecas necessárias a classe
import java.util.List;
import java.util.ArrayList;

public class Subject {
    // Atributos da Classe Suject
    private List<Observer> observers;

    // Método Construtor da Classe Suject
    public Subject() {
        this.observers = new ArrayList<Observer>();
    }

    // Métodos de Adição e Remoção de Observers
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    // Método para Notificação dos Observadores
    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update(this);
        }
    }
}
