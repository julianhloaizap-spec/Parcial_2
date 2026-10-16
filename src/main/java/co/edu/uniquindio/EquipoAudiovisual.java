package co.edu.uniquindio;

public abstract class EquipoAudiovisual {
    private String codigoEquipoAudiovisual;
    private String marcaEquipoAudiovisual;
    private String modeloEquipoAudiovisual;
    private EstadoEquipoAudiovisual estadoEquipoAudiovisual;

    public EquipoAudiovisual(String codigoEquipoAudiovisual, String marcaEquipoAudiovisual, String modeloEquipoAudiovisual, EstadoEquipoAudiovisual estadoEquipoAudiovisual) {
        this.codigoEquipoAudiovisual = codigoEquipoAudiovisual;
        this.marcaEquipoAudiovisual = marcaEquipoAudiovisual;
        this.modeloEquipoAudiovisual = modeloEquipoAudiovisual;
        this.estadoEquipoAudiovisual = estadoEquipoAudiovisual;
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

    public EstadoEquipoAudiovisual getEstadoEquipoAudiovisual() {
        return estadoEquipoAudiovisual;
    }

    public void setEstadoEquipoAudiovisual(EstadoEquipoAudiovisual estadoEquipoAudiovisual) {
        this.estadoEquipoAudiovisual = estadoEquipoAudiovisual;
    }

    public abstract boolean siOperador();
    public abstract double calcularCostoAlquiler(int horas);
}