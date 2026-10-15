package co.edu.uniquindio;

import java.util.ArrayList;

public class Operador {
    private String idOperador;
    private String nombreOperador;
    private String certificacionOperador;
    private String aniosEperiencia;



    public Operador(String idOperador, String nombreOperador, String certificacionOperador, String aniosEperiencia) {
        this.idOperador = idOperador;
        this.nombreOperador = nombreOperador;
        this.certificacionOperador = certificacionOperador;
        this.aniosEperiencia = aniosEperiencia;
    }

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
