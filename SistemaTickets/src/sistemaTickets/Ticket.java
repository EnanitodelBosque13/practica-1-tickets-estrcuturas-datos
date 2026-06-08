package sistemaTickets;

import java.time.LocalDateTime;

public class Ticket {

    // Atributo estático para generar id consecutivo
    private static int cantidad = 0;

    // Atributos
    private int id;
    private String descripcion;
    private String nombreCompleto;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private int prioridad;

    // Constructor
    public Ticket(String descripcion, String nombreCompleto, int prioridad) {
        cantidad++;
        this.id = cantidad;
        this.descripcion = descripcion;
        this.nombreCompleto = nombreCompleto;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaResolucion = null;
        this.prioridad = prioridad;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public int getPrioridad() {
        return prioridad;
    }

    // Setters
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setFechaResolucion(LocalDateTime fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    // toString()
    public String toString() {
        return "ID: " + id +
                "\nUsuario: " + nombreCompleto +
                "\nDescripcion: " + descripcion +
                "\nPrioridad: " + prioridad +
                "\nFecha de creacion: " + fechaCreacion +
                "\nFecha de resolucion: " + fechaResolucion + "\n";
    }
}