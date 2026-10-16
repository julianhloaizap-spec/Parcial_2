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

    public EquipoAudiovisual getEquipoAudiovisual() {
        return equipoAudiovisual;
    }

    //Metodo para el calculo del subtotal
    public double calcularSubtotal() {
        double subtotal = equipo.calcularCostoAlquiler(horasUsoEquipo);
            return subtotal;
        }
    }

