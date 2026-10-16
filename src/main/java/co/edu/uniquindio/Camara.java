package co.edu.uniquindio;

public class Camara extends EquipoAudiovisual {
    private String resolucionMaximaCamara;
    private boolean tieneEstabilizadorCamara;

    public Camara(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, CondicionEquipoAudiovisual condicionEquipoAudiovisual, String resolucionMaximaCamara, boolean tieneEstabilizadorCamara) {
        super(codigoEquipoAudiovisual, marcaEquipoAudiovisual, modeloEquipoAudiovisual, condicionEquipoAudiovisual);
        this.resolucionMaximaCamara = resolucionMaximaCamara;
        this.tieneEstabilizadorCamara = tieneEstabilizadorCamara;
    }

    public String getResolucionMaximaCamara() {
        return resolucionMaximaCamara;
    }

    public boolean siEstabilizadorCamara() {
        return tieneEstabilizadorCamara;
    }

    @Override
    public boolean siOperador() {
        return false;
    }

    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 12000.0 * horas;
        if (tieneEstabilizadorCamara == true) {
            costoBase = costoBase + 15000.0;
        }
        return costoBase;
    }
}