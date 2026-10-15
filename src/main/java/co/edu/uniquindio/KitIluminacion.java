package co.edu.uniquindio;

public class KitIluminacion extends EquipoAudiovisual {
    //Atributos
    private int cantidadLuces;
    private boolean controlInalambrico;
    private static final double ALQUILERKITILUMINACION = 12000;
    private static final double AlQUILERCONTROLINALAMBRICO = 15000;
    //Constructor


    public KitIluminacion(String codigoEquipo, String marca, String modelo, int cantidadLuces, boolean controlInalambrico) {
        super(codigoEquipo, marca, modelo);
        this.cantidadLuces = cantidadLuces;
        this.controlInalambrico = controlInalambrico;
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
    public double getALQUILERKITILUMINACION() {
        return ALQUILERKITILUMINACION;
    }
    public double getAlQUILERCONTROLINALAMBRICO() {
        return AlQUILERCONTROLINALAMBRICO;
    }
}
