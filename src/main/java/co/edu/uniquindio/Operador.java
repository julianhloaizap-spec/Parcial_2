package co.edu.uniquindio;


public class Operador {
    private String numeroIdentificacionOperador;
    private String nombreOperador;
    private String certificacionOperador;
    private int aniosExperienciaOperador;

    public Operador(String numeroIdentificacionOperador, String nombreOperador, String certificacionOperador, int aniosExperienciaOperador) {
        this.numeroIdentificacionOperador = numeroIdentificacionOperador;
        this.nombreOperador = nombreOperador;
        this.certificacionOperador = certificacionOperador;
        this.aniosExperienciaOperador = aniosExperienciaOperador;
    }

    public String getNumeroIdentificacionOperador() {
        return numeroIdentificacionOperador;
    }

    public String getNombreOperador() {
        return nombreOperador;
    }

    public String getCertificacionOperador() {
        return certificacionOperador;
    }

    public int getAniosExperienciaOperador() {
        return aniosExperienciaOperador;
    }
}