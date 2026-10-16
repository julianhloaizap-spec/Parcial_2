package co.edu.uniquindio;

public class Dron extends EquipoAudiovisual {
    //Atributos
    private int vueloMinutos;
    private boolean bateriaAdicional;
    //Constructor
    public Dron (String codigoEquipo, String marca, String modelo, int vueloMinutos, boolean bateriaAdicional) {
        super(codigoEquipo, marca, modelo, EstadoEquipo.DISPONIBLE);
        this.vueloMinutos = vueloMinutos;
        this.bateriaAdicional = bateriaAdicional;

    }
    @Override
    public double calcularCostoAlquiler(int horas) {
        double costoBase = 18000.0 * horas;
        if (bateriaAdicional) {
            costoBase = costoBase + 20000.0;
        }
        return costoBase;
    }
    //Getters and Setters
    public int getVueloMinutos() {
        return vueloMinutos;
    }
    public void setVueloMinutos(int vueloMinutos) {
        this.vueloMinutos = vueloMinutos;
    }
    public boolean getBateriaAdicional() {
        return bateriaAdicional;
    }
    public void setBateriaAdicional(boolean bateriaAdicional) {
        this.bateriaAdicional = bateriaAdicional;
    }
}
