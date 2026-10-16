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
        this.operador = null;
        this.listDetalleReserva = listDetalleReserva;
        this.estadoReserva = estadoReserva.SOLICITADA;
        this.listDetalleReserva = new ArrayList<>();
    }

    //Getters and Setters
    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getInfoCliente() {
        return infoCliente;
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

    public boolean agregarDetalleReserva(int horasUsoEquipo, EquipoAudiovisual equipoAudiovisual) {
        if (equipoAudiovisual == null || horasUsoEquipo <= 0) {
            return false;
        }
        if (equipoAudiovisual.getEsta() != EstadoEquipo.DISPONIBLE) {
            return false;
        }
        if (tieneEquipo(equipoAudiovisual.getCodigo())) {
            return false;
        }
        detalles.add(new DetalleReserva(equipoAudiovisual, horas));
        return true;
    }



}
