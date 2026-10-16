package co.edu.uniquindio;

public class Cliente {
    private String nombreCliente;
    private String numeroIdentificacionCliente;
    private String telefonoCliente;
    private String correoElectronicoCliente;

    public Cliente(String nombreCliente, String numeroIdentificacionCliente, String telefonoCliente, String correoElectronicoCliente) {
        this.nombreCliente = nombreCliente;
        this.numeroIdentificacionCliente = numeroIdentificacionCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoElectronicoCliente = correoElectronicoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getNumeroIdentificacionCliente() {
        return numeroIdentificacionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public String getCorreoElectronicoCliente() {
        return correoElectronicoCliente;
    }
}