package co.edu.uniquindio;

public abstract class EquipoAudiovisual {
    //Atributos
    protected String codigoEquipo;
    protected String marca;
    protected String modelo;
    //Constructor

    public EquipoAudiovisual(String codigoEquipo, String marca, String modelo) {
        this.codigoEquipo = codigoEquipo;
        this.marca = marca;
        this.modelo = modelo;
    }
    //Getters and setters

    public String getCodigoEquipo() {
        return codigoEquipo;
    }
    public void setCodigoEquipo(String codigoEquipo) {
        this.codigoEquipo = codigoEquipo;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public abstract double calcularCostoAlquiler (int horasUsoEquipo);
}
