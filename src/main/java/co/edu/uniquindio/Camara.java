package co.edu.uniquindio;

public class Camara extends EquipoAudiovisual {
    //Atributos
    private String resolucionMaxima;
    private boolean estabilizador;
    //Constructor
    public Camara (String codigoEquipo, String marca,String modelo, String resolucionMaxima, boolean estabilizador) {
        super(codigoEquipo,marca,modelo,EstadoEquipo.DISPONIBLE);
        this.resolucionMaxima = resolucionMaxima;
        this.estabilizador = estabilizador;
    }
    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 12000.0 * horas;
        if (estabilizador) {
            costoBase = costoBase + 15000.0;
        }
        return costoBase;
    }
    //Getters and Setters
    public String getResolucionMaxima() {
        return resolucionMaxima;
    }
    public void setResolucionMaxima(String resolucionMaxima) {
        this.resolucionMaxima = resolucionMaxima;
    }
    public boolean getEstabilizador() {
        return estabilizador;
    }
    public void setEstabilizador(boolean estabilizador) {
        this.estabilizador = estabilizador;
    }
}
