package co.edu.uniquindio;

public class Dron extends EquipoAudiovisual {
    //Atributos
    private int vueloMinutos;
    private boolean bateriaAdicional;
    private static final double ALQUILERDRONHORA = 18000;
    private static final double AlQUILERBATERIAADICIONAL = 20000;
    //Constructor

    public Dron (String codigoEquipo, String marca, String modelo, int vueloMinutos, boolean bateriaAdicional) {
        super(codigoEquipo, marca, modelo);
        this.vueloMinutos = vueloMinutos;
        this.bateriaAdicional = bateriaAdicional;
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
    public double getALQUILERDRONHORA() {
        return ALQUILERDRONHORA;
    }
    public double getAlQUILERBATERIAADICIONAL() {
        return AlQUILERBATERIAADICIONAL;
    }
}
