package sistemaTickets;

import java.util.ArrayList;

public class ColaPrioridad {

    // Atributos
    private final ArrayList<Ticket> ticketsPendientes;

    // Métodos
    // Constructor
    public ColaPrioridad() {
        ticketsPendientes = new ArrayList<>();
    }

    // Operaciones
    public boolean estaVacia() {
        return ticketsPendientes.isEmpty();
    }

    public void insertar(Ticket ticket) {
        int posicion = 0;

        while (posicion < ticketsPendientes.size()
                && ticketsPendientes.get(posicion).getPrioridad() <= ticket.getPrioridad()) {
            posicion++;
        }

        ticketsPendientes.add(posicion, ticket);
        System.out.println("El ticket se creó correctamente.\n");
    }

    public Ticket remover() {
        if (estaVacia()) {
            System.out.println("No se puede resolver ningún ticket, la cola está vacía.\n");
            return null;
        }

        return ticketsPendientes.remove(0);
    }

    public Ticket verFrente() {
        if (estaVacia()) {
            System.out.println("No hay tickets pendientes en la cola.\n");
            return null;
        }

        return ticketsPendientes.get(0);
    }

    public void mostrar() {
        if (estaVacia()) {
            System.out.println("No hay tickets pendientes en la cola.\n");
            return;
        }

        for (Ticket ticket : ticketsPendientes) {
            System.out.println(ticket);
        }
    }
}