package co.edu.uniquindio;

public record DetalleReserva(
        EquipoAudiovisual equipoAudiovisualDetalleReserva,
        int horasUsoDetalleReserva
) {
    public double calcularSubtotal() {
        return equipoAudiovisualDetalleReserva.calcularCostoAlquiler(horasUsoDetalleReserva);
    }
}