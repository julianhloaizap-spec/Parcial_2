package co.edu.uniquindio;

public class DetalleReserva {
    private EquipoAudiovisual equipoAudiovisualDetalleReserva;
    private int horasUsoDetalleReserva;

    public DetalleReserva(EquipoAudiovisual equipoAudiovisualDetalleReserva, int horasUsoDetalleReserva) {
        this.equipoAudiovisualDetalleReserva = equipoAudiovisualDetalleReserva;
        this.horasUsoDetalleReserva = horasUsoDetalleReserva;
    }

    public EquipoAudiovisual getEquipoAudiovisualDetalleReserva() {
        return equipoAudiovisualDetalleReserva;
    }

    public int getHorasUsoDetalleReserva() {
        return horasUsoDetalleReserva;
    }

    public double calcularSubtotal() {
        return equipoAudiovisualDetalleReserva.calcularCostoAlquiler(horasUsoDetalleReserva);
    }
}