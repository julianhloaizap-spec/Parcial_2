package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {

    //Atributos
    private String idReserva;
    private Cliente infoCliente;
    private LocalDate fechaSolicitada;
    private Turno turno;
    private Operador operador;
    private EstadoReserva estadoReserva;

    private ArrayList<DetalleReserva> listDetalleReserva;

    //Constructor
    public Reserva(String idReserva, Cliente infoCliente, LocalDate fechaSolicitada, Turno turno, Operador operador, ArrayList<DetalleReserva> listDetalleReserva, EstadoReserva estadoReserva) {
        this.idReserva = idReserva;
        this.infoCliente = infoCliente;
        this.fechaSolicitada = fechaSolicitada;
        this.turno = turno;
        this.operador = operador;
        this.listDetalleReserva = listDetalleReserva;
        this.estadoReserva = estadoReserva;
    }

    //Getters and Setters
    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public Cliente getInfoCliente() {
        return infoCliente;
    }

    public void setInfoCliente(Cliente infoCliente) {
        this.infoCliente = infoCliente;
    }

    public LocalDate getFechaSolicitada() {
        return fechaSolicitada;
    }


    public Turno getTurno() {
        return turno;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public ArrayList<DetalleReserva> getListDetalleReserva() {
        return listDetalleReserva;
    }

    public void setListDetalleReserva(ArrayList<DetalleReserva> listDetalleReserva) {
        this.listDetalleReserva = listDetalleReserva;
    }
}
