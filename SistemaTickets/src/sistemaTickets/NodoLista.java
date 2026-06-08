package sistemaTickets;

public class NodoLista {

    // Atributos
    private Ticket ticket;

    // Referencia al siguiente nodo
    private NodoLista siguiente;

    // Métodos
    // Constructor
    public NodoLista(Ticket ticket) {
        this.ticket = ticket;
        siguiente = null;
    }

    // Getters
    public Ticket getTicket() {
        return ticket;
    }

    public NodoLista getSiguiente() {
        return siguiente;
    }

    // Setters
    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setSiguiente(NodoLista siguiente) {
        this.siguiente = siguiente;
    }

    // toString()
    public String toString() {
        return ticket.toString();
    }
}