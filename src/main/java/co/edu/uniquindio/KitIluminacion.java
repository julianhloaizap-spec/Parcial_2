package co.edu.uniquindio;

public class KitIluminacion extends EquipoAudiovisual {
    //Atributos
    private int cantidadLuces;
    private boolean controlInalambrico;
    //Constructor
    public KitIluminacion(String codigoEquipo, String marca, String modelo, int cantidadLuces, boolean controlInalambrico) {
        super(codigoEquipo, marca, modelo, EstadoEquipo.DISPONIBLE);
        this.cantidadLuces = cantidadLuces;
        this.controlInalambrico = controlInalambrico;
    }
    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 10000.0 * horas;
        if (controlInalambrico) {
            costoBase = costoBase + 12000.0;
        }
        return costoBase;
    }
    //Getters and Setters
    public int getCantidadLuces() {
        return cantidadLuces;
    }
    public void setCantidadLuces(int cantidadLuces) {
        this.cantidadLuces = cantidadLuces;
    }
    public boolean getControlInalambrico() {
        return controlInalambrico;
    }
    public void setControlInalambrico(boolean controlInalambrico) {
        this.controlInalambrico = controlInalambrico;
    }
}
