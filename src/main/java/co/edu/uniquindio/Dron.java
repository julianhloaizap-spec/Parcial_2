package co.edu.uniquindio;

public class Dron extends EquipoAudiovisual {
    private int autonomiaMinutosDron;
    private boolean tieneBateriaAdicionalDron;

    public Dron(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, EstadoEquipoAudiovisual estadoEquipoAudiovisual, int autonomiaMinutosDron, boolean tieneBateriaAdicionalDron) {
        super(codigoEquipoAudiovisual, marcaEquipoAudiovisual, modeloEquipoAudiovisual, estadoEquipoAudiovisual);
        this.autonomiaMinutosDron = autonomiaMinutosDron;
        this.tieneBateriaAdicionalDron = tieneBateriaAdicionalDron;
    }

    public int getAutonomiaMinutosDron() {
        return autonomiaMinutosDron;
    }

    public boolean siBateriaAdicionalDron() {
        return tieneBateriaAdicionalDron;
    }

    @Override
    public boolean siOperador() {
        return true;
    }

    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 18000.0 * horas;
        if (tieneBateriaAdicionalDron == true) {
            costoBase = costoBase + 20000.0;
        }
        return costoBase;
    }
}