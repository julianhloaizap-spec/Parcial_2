package co.edu.uniquindio;

import java.util.ArrayList;

public class Sede {

    //Atributos
    private String codigoSede;
    private String nombreSede;
    private String direccionSede;
    private ArrayList<EquipoAudiovisual> listEquiposAudiovisuales;



    //Constructor
    public Sede(String codigoSede, String nombreSede, String direccionSede) {
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.listEquiposAudiovisuales = new ArrayList<>();
    }
    public ArrayList<EquipoAudiovisual> getEquipos() {
        return listEquiposAudiovisuales;
    }
    // Agregar equipo audivisual en la sede
    public boolean agregarEquipo(EquipoAudiovisual equipo) {
        if (equipo == null) {
            return false;
        }
        for (int i = 0; i < listEquiposAudiovisuales.size(); i++) {
            if (listEquiposAudiovisuales.get(i).getCodigoEquipo().equalsIgnoreCase(equipo.getCodigoEquipo())) {
                return false;
            }
        }
        listEquiposAudiovisuales.add(equipo);
        return true;
    }

    //Getters and Setters
    public String getCodigoSede() {
        return codigoSede;
    }

    public void setCodigoSede(String codigoSede) {
        this.codigoSede = codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public void setNombreSede(String nombreSede) {
        this.nombreSede = nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public void setDireccionSede(String direccionSede) {
        this.direccionSede = direccionSede;
    }
}
