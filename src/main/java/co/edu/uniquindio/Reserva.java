package co.edu.uniquindio;

import java.time.LocalDate;

public class Reserva {
    private String idReserva;
    private LocalDate fechaSolicitada;

    public Reserva(String idReserva, LocalDate fechaSolicitada) {
        this.idReserva = idReserva;
        this.fechaSolicitada = fechaSolicitada;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public LocalDate getFechaSolicitada() {
        return fechaSolicitada;
    }

}
