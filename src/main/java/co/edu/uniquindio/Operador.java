package co.edu.uniquindio;


public class Operador {
    //Atributos
    private String idOperador;
    private String nombreOperador;
    private String certificacionOperador;
    private String aniosEperiencia;


    //Constructor
    public Operador(String idOperador, String nombreOperador, String certificacionOperador, String aniosEperiencia) {
        this.idOperador = idOperador;
        this.nombreOperador = nombreOperador;
        this.certificacionOperador = certificacionOperador;
        this.aniosEperiencia = aniosEperiencia;
    }

    //Getters and Setters
    public String getIdOperador() {
        return idOperador;
    }

    public void setIdOperador(String idOperador) {
        this.idOperador = idOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public void setNombreOperador(String nombreOperador) {
        this.nombreOperador = nombreOperador;
    }

    public String getCertificacionOperador() {
        return certificacionOperador;
    }

    public void setCertificacionOperador(String certificacionOperador) {
        this.certificacionOperador = certificacionOperador;
    }

    public String getAniosEperiencia() {
        return aniosEperiencia;
    }

    public void setAniosEperiencia(String aniosEperiencia) {
        this.aniosEperiencia = aniosEperiencia;
    }

}
