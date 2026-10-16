package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;

public class Reserva {
    private String codigoReserva;
    private Cliente clienteReserva;
    private LocalDate fechaReserva;
    private Turno turnoReserva;
    private EstadoReserva estadoReserva;
    private Operador operadorReserva;
    private ArrayList<DetalleReserva> detallesReserva;

    public Reserva(String codigoReserva, Cliente clienteReserva, LocalDate fechaReserva, Turno turnoReserva) {
        this.codigoReserva = codigoReserva;
        this.clienteReserva = clienteReserva;
        this.fechaReserva = fechaReserva;
        this.turnoReserva = turnoReserva;
        this.estadoReserva = EstadoReserva.SOLICITADA;
        this.operadorReserva = null;
        this.detallesReserva = new ArrayList<>();
    }

    public String getCodigoReserva() {
        return codigoReserva;
    }

    public Cliente getClienteReserva() {
        return clienteReserva;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public Turno getTurnoReserva() {
        return turnoReserva;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Operador getOperadorReserva() {
        return operadorReserva;
    }

    public void setOperadorReserva(Operador operadorReserva) {
        this.operadorReserva = operadorReserva;
    }

    public ArrayList<DetalleReserva> getDetallesReserva() {
        return detallesReserva;
    }

    public boolean agregarDetalle(EquipoAudiovisual equipoAudiovisual, int horas) {
        if (equipoAudiovisual == null || horas <= 0) {
            return false;
        }
        if (equipoAudiovisual.getEstadoEquipoAudiovisual() != EstadoEquipoAudiovisual.DISPONIBLE) {
            return false;
        }
        if (siEquipoAudiovisual(equipoAudiovisual.getCodigoEquipoAudiovisual()) == true) {
            return false;
        }
        detallesReserva.add(new DetalleReserva(equipoAudiovisual, horas));
        return true;
    }

    public boolean siEquipoAudiovisual(String codigoEquipoAudiovisual) {
        for (int i = 0; i < detallesReserva.size(); i++) {
            if (detallesReserva.get(i).getEquipoAudiovisualDetalleReserva().getCodigoEquipoAudiovisual().equalsIgnoreCase(codigoEquipoAudiovisual)) {
                return true;
            }
        }
        return false;
    }

    public boolean siOperador() {
        for (int i = 0; i < detallesReserva.size(); i++) {
            if (detallesReserva.get(i).getEquipoAudiovisualDetalleReserva().siOperador() == true) {
                return true;
            }
        }
        return false;
    }

    public double calcularValorTotal() {
        double total = 0.0;
        for (int i = 0; i < detallesReserva.size(); i++) {
            total = total + detallesReserva.get(i).calcularSubtotal();
        }
        return total;
    }
}