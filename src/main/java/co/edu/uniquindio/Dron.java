package co.edu.uniquindio;

public class Dron extends EquipoAudiovisual {
    private int autonomiaMinutosDron;
    private boolean tieneBateriaAdicionalDron;

    public Dron(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, CondicionEquipoAudiovisual condicionEquipoAudiovisual, int autonomiaMinutosDron, boolean tieneBateriaAdicionalDron) {
        super(codigoEquipoAudiovisual, marcaEquipoAudiovisual, modeloEquipoAudiovisual, condicionEquipoAudiovisual);
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
KitIluminacion.java
        Java
public class KitIluminacion extends EquipoAudiovisual {
    private int cantidadLucesKitIluminacion;
    private boolean tieneControlInalambricoKitIluminacion;

    public KitIluminacion(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, CondicionEquipoAudiovisual condicionEquipoAudiovisual, int cantidadLucesKitIluminacion, boolean tieneControlInalambricoKitIluminacion) {
        super(codigoEquipoAudiovisual, marcaEquipoAudiovisual, modeloEquipoAudiovisual, condicionEquipoAudiovisual);
        this.cantidadLucesKitIluminacion = cantidadLucesKitIluminacion;
        this.tieneControlInalambricoKitIluminacion = tieneControlInalambricoKitIluminacion;
    }

    public int getCantidadLucesKitIluminacion() {
        return cantidadLucesKitIluminacion;
    }

    public boolean siControlInalambricoKitIluminacion() {
        return tieneControlInalambricoKitIluminacion;
    }

    @Override
    public boolean siOperador() {
        return false;
    }

    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 10000.0 * horas;
        if (tieneControlInalambricoKitIluminacion == true) {
            costoBase = costoBase + 12000.0;
        }
        return costoBase;
    }
}