package co.edu.uniquindio;

public class Camara extends EquipoAudiovisual {
    //Atributos
    private String resolucionMaxima;
    private boolean estabilizador;
    private static final double ALQUILERCAMARAHORA = 12000;
    private static final double ALQUILERESTABILIZADOR = 15000;
    //Constructor
    public Camara (String codigoEquipo, String marca,String modelo, String resolucionMaxima, boolean estabilizador) {
        super(codigoEquipo,marca,modelo);
        this.resolucionMaxima = resolucionMaxima;
        this.estabilizador = estabilizador;
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
    public double getALQUILERCAMARAHORA() {
        return ALQUILERCAMARAHORA;
    }
    public double getALQUILERESTABILIZADOR() {
        return AlQUILERESTABILIZADOR;}

    @Override
    public double calcularCostoAlquiler(double ALQUILERCAMARAHORA, double ALQUILERESTABILIZADOR, int horasUsoEquipo) {
        double costo = 0;
        if (estabilizador) {
            costo = ALQUILERCAMARAHORA * horasUsoEquipo + ALQUILERESTABILIZADOR;
        } else {
            costo = ALQUILERCAMARAHORA * horasUsoEquipo;
        }
        return costo;
    }
}
