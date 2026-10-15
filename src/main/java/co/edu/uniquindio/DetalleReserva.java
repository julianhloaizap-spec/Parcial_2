package co.edu.uniquindio;

public class DetalleReserva {
    //Atributos
    private int horasUsoEquipo;
    private EquipoAudiovisual equipoAudiovisual;


    //Constructor
    public DetalleReserva(int horasUsoEquipo, EquipoAudiovisual equipoAudiovisual) {
        this.horasUsoEquipo = horasUsoEquipo;
        this.equipoAudiovisual = equipoAudiovisual;
    }

    //Getters and Setters
    public int getHorasUsoEquipo() {
        return horasUsoEquipo;
    }

    public void setHorasUsoEquipo(int horasUsoEquipo) {
        this.horasUsoEquipo = horasUsoEquipo;
    }

    public EquipoAudiovisual getEquipoAudiovisual() {
        return equipoAudiovisual;
    }

    public void setEquipoAudiovisual(EquipoAudiovisual equipoAudiovisual) {
        this.equipoAudiovisual = equipoAudiovisual;
    }


}
