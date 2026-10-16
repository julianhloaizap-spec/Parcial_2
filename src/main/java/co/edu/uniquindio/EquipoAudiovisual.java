package co.edu.uniquindio;

public abstract class EquipoAudiovisual {
    private String codigoEquipoAudiovisual;
    private String marcaEquipoAudiovisual;
    private String modeloEquipoAudiovisual;
    private CondicionEquipoAudiovisual condicionEquipoAudiovisual;

    public EquipoAudiovisual(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, CondicionEquipoAudiovisual condicionEquipoAudiovisual) {
        this.codigoEquipoAudiovisual = codigoEquipoAudiovisual;
        this.marcaEquipoAudiovisual = marcaEquipoAudiovisual;
        this.modeloEquipoAudiovisual = modeloEquipoAudiovisual;
        this.condicionEquipoAudiovisual = condicionEquipoAudiovisual;
    }

    public String getCodigoEquipoAudiovisual() {
        return codigoEquipoAudiovisual;
    }

    public String getMarcaEquipoAudiovisual() {
        return marcaEquipoAudiovisual;
    }

    public String getModeloEquipoAudiovisual() {
        return modeloEquipoAudiovisual;
    }

    public CondicionEquipoAudiovisual getCondicionEquipoAudiovisual() {
        return condicionEquipoAudiovisual;
    }

    public void setCondicionEquipoAudiovisual(CondicionEquipoAudiovisual condicionEquipoAudiovisual) {
        this.condicionEquipoAudiovisual = condicionEquipoAudiovisual;
    }

    public abstract boolean siOperador();
    public abstract double calcularCostoAlquiler(int horas);
}
