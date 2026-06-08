package sistemaTickets;

public class ListaEnlazada {

    // Atributos
    private NodoLista primero;

    // Métodos
    // Constructor
    public ListaEnlazada() {
        primero = null;
    }

    // Getters
    public NodoLista getPrimero() {
        return primero;
    }

    // Setters
    public void setPrimero(NodoLista primero) {
        this.primero = primero;
    }

    // Operaciones
    private boolean estaVacia() {
        return primero == null;
    }

    public void insertarFinal(Ticket ticket) {
        NodoLista nodo = new NodoLista(ticket);

        if (estaVacia()) {
            primero = nodo;
            return;
        }

        NodoLista temp = primero;

        while (temp.getSiguiente() != null) {
            temp = temp.getSiguiente();
        }

        temp.setSiguiente(nodo);
    }

    public Ticket buscar(int id) {
        if (estaVacia()) {
            return null;
        }

        NodoLista temp = primero;

        while (temp != null) {
            if (temp.getTicket().getId() == id) {
                return temp.getTicket();
            }

            temp = temp.getSiguiente();
        }

        return null;
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("La lista de tickets resueltos está vacía.\n");
            return;
        }

        NodoLista temp = primero;

        while (temp != null) {
            System.out.println(temp);
            temp = temp.getSiguiente();
        }
    }
}