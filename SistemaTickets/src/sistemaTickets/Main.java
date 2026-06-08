package sistemaTickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ColaPrioridad colaPendientes = new ColaPrioridad();
        ListaEnlazada listaResueltos = new ListaEnlazada();

        int opcionPrincipal;

        do {
            System.out.println("Sistema de tickets");
            System.out.println("1. Usuario");
            System.out.println("2. Administrador");
            System.out.println("3. Salir");
            System.out.print("Digite una opción: ");
            opcionPrincipal = Integer.parseInt(br.readLine());

            switch (opcionPrincipal) {

                case 1:
                    menuUsuario(br, colaPendientes, listaResueltos);
                    break;

                case 2:
                    menuAdministrador(br, colaPendientes, listaResueltos);
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción inválida.\n");
                    break;
            }

        } while (opcionPrincipal != 3);
    }

    public static void menuUsuario(BufferedReader br, ColaPrioridad colaPendientes,
                                   ListaEnlazada listaResueltos) throws IOException {

        int opcionUsuario;

        do {
            System.out.println("Menú de usuario");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("3. Volver");
            System.out.print("Digite una opción: ");
            opcionUsuario = Integer.parseInt(br.readLine());

            switch (opcionUsuario) {

                case 1:
                    crearTicket(br, colaPendientes);
                    break;

                case 2:
                    buscarTicket(br, listaResueltos);
                    break;

                case 3:
                    System.out.println("Volviendo al menú principal.\n");
                    break;

                default:
                    System.out.println("Opción inválida.\n");
                    break;
            }

        } while (opcionUsuario != 3);
    }

    public static void menuAdministrador(BufferedReader br, ColaPrioridad colaPendientes,
                                         ListaEnlazada listaResueltos) throws IOException {

        int opcionAdministrador;

        do {
            System.out.println("Menú de administrador");
            System.out.println("1. Ver ticket al frente");
            System.out.println("2. Resolver ticket al frente");
            System.out.println("3. Mostrar tickets pendientes");
            System.out.println("4. Mostrar tickets resueltos");
            System.out.println("5. Volver");
            System.out.print("Digite una opción: ");
            opcionAdministrador = Integer.parseInt(br.readLine());

            switch (opcionAdministrador) {

                case 1:
                    verTicketFrente(colaPendientes);
                    break;

                case 2:
                    resolverTicket(colaPendientes, listaResueltos);
                    break;

                case 3:
                    colaPendientes.mostrar();
                    break;

                case 4:
                    listaResueltos.mostrar();
                    break;

                case 5:
                    System.out.println("Volviendo al menú principal.\n");
                    break;

                default:
                    System.out.println("Opción inválida.\n");
                    break;
            }

        } while (opcionAdministrador != 5);
    }

    public static void crearTicket(BufferedReader br, ColaPrioridad colaPendientes) throws IOException {

        System.out.println("Crear ticket");

        System.out.print("Digite su nombre completo: ");
        String nombreCompleto = br.readLine();

        System.out.print("Digite la descripción del problema: ");
        String descripcion = br.readLine();

        System.out.println("Prioridad");
        System.out.println("1. Alta");
        System.out.println("2. Media");
        System.out.println("3. Baja");
        System.out.print("Digite la prioridad: ");
        int prioridad = Integer.parseInt(br.readLine());

        if (prioridad < 1 || prioridad > 3) {
            System.out.println("Prioridad inválida. Se asignó prioridad baja.\n");
            prioridad = 3;
        }

        Ticket ticket = new Ticket(descripcion, nombreCompleto, prioridad);
        colaPendientes.insertar(ticket);

        System.out.println("Ticket creado.");
        System.out.println("El id del ticket es: " + ticket.getId() + "\n");
    }

    public static void buscarTicket(BufferedReader br, ListaEnlazada listaResueltos) throws IOException {

        System.out.println("Buscar ticket resuelto");

        System.out.print("Digite el id del ticket: ");
        int id = Integer.parseInt(br.readLine());

        Ticket ticket = listaResueltos.buscar(id);

        if (ticket == null) {
            System.out.println("El ticket está pendiente o no existe.\n");
        } else {
            System.out.println("Ticket encontrado:");
            System.out.println(ticket);
        }
    }

    public static void verTicketFrente(ColaPrioridad colaPendientes) {

        System.out.println("Ticket al frente de la cola");

        Ticket ticket = colaPendientes.verFrente();

        if (ticket != null) {
            System.out.println(ticket);
        }
    }

    public static void resolverTicket(ColaPrioridad colaPendientes,
                                      ListaEnlazada listaResueltos) {

        System.out.println("Resolver ticket");

        Ticket ticket = colaPendientes.remover();

        if (ticket != null) {
            ticket.setFechaResolucion(LocalDateTime.now());
            listaResueltos.insertarFinal(ticket);

            System.out.println("Ticket resuelto correctamente.");
            System.out.println(ticket);
        }
    }
}