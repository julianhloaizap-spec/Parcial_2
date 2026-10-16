package co.edu.uniquindio;

import java.util.ArrayList;

public class Sede {
    private String codigoSede;
    private String nombreSede;
    private String direccionSede;
    private ArrayList<EquipoAudiovisual> equiposAudiovisualesSede;

    public Sede(String codigoSede, String nombreSede, String direccionSede) {
        this.codigoSede = codigoSede;
        this.nombreSede = nombreSede;
        this.direccionSede = direccionSede;
        this.equiposAudiovisualesSede = new ArrayList<>();
    }

    public String getCodigoSede() {
        return codigoSede;
    }

    public String getNombreSede() {
        return nombreSede;
    }

    public String getDireccionSede() {
        return direccionSede;
    }

    public ArrayList<EquipoAudiovisual> getEquiposAudiovisualesSede() {
        return equiposAudiovisualesSede;
    }

    public boolean agregarEquipoAudiovisual(EquipoAudiovisual equipoAudiovisual) {
        if (equipoAudiovisual == null) {
            return false;
        }
        for (int i = 0; i < equiposAudiovisualesSede.size(); i++) {
            if (equiposAudiovisualesSede.get(i).getCodigoEquipoAudiovisual().equalsIgnoreCase(equipoAudiovisual.getCodigoEquipoAudiovisual())) {
                return false;
            }
        }
        equiposAudiovisualesSede.add(equipoAudiovisual);
        return true;
    }
}