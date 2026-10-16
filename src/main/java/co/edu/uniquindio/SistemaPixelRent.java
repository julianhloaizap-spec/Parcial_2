package co.edu.uniquindio;

import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaPixelRent {
    private ArrayList<Sede> sedesSistemaPixelRent;
    private ArrayList<EquipoAudiovisual> equiposAudiovisualesSistemaPixelRent;
    private ArrayList<Cliente> clientesSistemaPixelRent;
    private ArrayList<Operador> operadoresSistemaPixelRent;
    private ArrayList<Reserva> reservasSistemaPixelRent;

    public SistemaPixelRent() {
        this.sedesSistemaPixelRent = new ArrayList<>();
        this.equiposAudiovisualesSistemaPixelRent = new ArrayList<>();
        this.clientesSistemaPixelRent = new ArrayList<>();
        this.operadoresSistemaPixelRent = new ArrayList<>();
        this.reservasSistemaPixelRent = new ArrayList<>();
    }

    public EquipoAudiovisual buscarEquipoAudiovisual(String codigoEquipoAudiovisual) {
        for (int i = 0; i < equiposAudiovisualesSistemaPixelRent.size(); i++) {
            if (equiposAudiovisualesSistemaPixelRent.get(i).getCodigoEquipoAudiovisual().equalsIgnoreCase(codigoEquipoAudiovisual)) {
                return equiposAudiovisualesSistemaPixelRent.get(i);
            }
        }
        return null;
    }

    public Cliente buscarCliente(String id) {
        for (int i = 0; i < clientesSistemaPixelRent.size(); i++) {
            if (clientesSistemaPixelRent.get(i).numeroIdentificacionCliente().equalsIgnoreCase(id)) {
                return clientesSistemaPixelRent.get(i);
            }
        }
        return null;
    }

    public Operador buscarOperador(String id) {
        for (int i = 0; i < operadoresSistemaPixelRent.size(); i++) {
            if (operadoresSistemaPixelRent.get(i).numeroIdentificacionOperador().equalsIgnoreCase(id)) {
                return operadoresSistemaPixelRent.get(i);
            }
        }
        return null;
    }

    public Reserva buscarReserva(String codigoReserva) {
        for (int i = 0; i < reservasSistemaPixelRent.size(); i++) {
            if (reservasSistemaPixelRent.get(i).getCodigoReserva().equalsIgnoreCase(codigoReserva)) {
                return reservasSistemaPixelRent.get(i);
            }
        }
        return null;
    }

    public Sede buscarSede(String codigoSede) {
        for (int i = 0; i < sedesSistemaPixelRent.size(); i++) {
            if (sedesSistemaPixelRent.get(i).getCodigoSede().equalsIgnoreCase(codigoSede)) {
                return sedesSistemaPixelRent.get(i);
            }
        }
        return null;
    }

    public boolean registrarSede(Sede sede) {
        if (sede == null || buscarSede(sede.getCodigoSede()) != null) {
            return false;
        }
        sedesSistemaPixelRent.add(sede);
        return true;
    }

    public boolean registrarEquipoAudiovisual(EquipoAudiovisual equipoAudiovisual, String codigoSede) {
        if (equipoAudiovisual == null || buscarEquipoAudiovisual(equipoAudiovisual.getCodigoEquipoAudiovisual()) != null) {
            return false;
        }
        Sede sede = buscarSede(codigoSede);
        if (sede == null) {
            return false;
        }
        equiposAudiovisualesSistemaPixelRent.add(equipoAudiovisual);
        sede.agregarEquipoAudiovisual(equipoAudiovisual);
        return true;
    }

    public boolean registrarCliente(Cliente cliente) {
        if (cliente == null || buscarCliente(cliente.numeroIdentificacionCliente()) != null) {
            return false;
        }
        clientesSistemaPixelRent.add(cliente);
        return true;
    }

    public boolean registrarOperador(Operador operador) {
        if (operador == null || buscarOperador(operador.numeroIdentificacionOperador()) != null) {
            return false;
        }
        operadoresSistemaPixelRent.add(operador);
        return true;
    }

    public boolean crearReserva(String codigoReserva, String idCliente, LocalDate fecha, Turno turno) {
        if (buscarReserva(codigoReserva) != null) {
            return false;
        }
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null || fecha == null) {
            return false;
        }
        Reserva nuevaReserva = new Reserva(codigoReserva, cliente, fecha, turno);
        reservasSistemaPixelRent.add(nuevaReserva);
        return true;
    }

    public String agregarEquipoAudiovisualAReserva(String codigoReserva, String codigoEquipoAudiovisual, int horas) {
        Reserva reserva = buscarReserva(codigoReserva);
        if (reserva == null) {
            return "La reserva no existe.";
        }
        if (reserva.getEstadoReserva() != EstadoReserva.SOLICITADA) {
            return "Solo se pueden modificar reservas en estado SOLICITADA.";
        }
        EquipoAudiovisual equipoAudiovisual = buscarEquipoAudiovisual(codigoEquipoAudiovisual);
        if (equipoAudiovisual == null) {
            return "El equipo audiovisual no existe.";
        }
        if (equipoAudiovisual.getCondicionEquipoAudiovisual() != CondicionEquipoAudiovisual.DISPONIBLE) {
            return "El equipo audiovisual no está en condición DISPONIBLE.";
        }
        if (reserva.siEquipoAudiovisual(codigoEquipoAudiovisual) == true) {
            return "El equipo audiovisual ya está incluido en esta reserva.";
        }
        boolean exito = reserva.agregarDetalle(equipoAudiovisual, horas);
        if (exito == true) {
            return "Equipo audiovisual agregado exitosamente a la reserva.";
        } else {
            return "No se pudo agregar el equipo audiovisual a la reserva.";
        }
    }

    public boolean asignarOperadorAReserva(String codigoReserva, String idOperador) {
        Reserva reserva = buscarReserva(codigoReserva);
        Operador operador = buscarOperador(idOperador);
        if (reserva == null || operador == null) {
            return false;
        }
        if (reserva.getEstadoReserva() != EstadoReserva.SOLICITADA) {
            return false;
        }
        reserva.setOperadorReserva(operador);
        return true;
    }

    public String confirmarReserva(String codigoReserva) {
        Reserva reserva = buscarReserva(codigoReserva);
        if (reserva == null) {
            return "Reserva no encontrada.";
        }
        if (reserva.getEstadoReserva() == EstadoReserva.CANCELADA || reserva.getEstadoReserva() == EstadoReserva.FINALIZADA) {
            return "Una reserva Cancelada o Finalizada no puede ser confirmada.";
        }
        if (reserva.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
            return "La reserva ya se encuentra confirmada.";
        }
        if (reserva.getDetallesReserva().isEmpty() == true) {
            return "La reserva debe contener al menos un equipo audiovisual.";
        }
        if (reserva.siOperador() == true && reserva.getOperadorReserva() == null) {
            return "La reserva contiene equipos que requieren un operador asignado.";
        }

        for (int i = 0; i < reserva.getDetallesReserva().size(); i++) {
            EquipoAudiovisual equipoAudiovisual = reserva.getDetallesReserva().get(i).equipoAudiovisualDetalleReserva();
            for (int j = 0; j < reservasSistemaPixelRent.size(); j++) {
                Reserva otra = reservasSistemaPixelRent.get(j);
                if (otra.getCodigoReserva().equalsIgnoreCase(reserva.getCodigoReserva()) == false && otra.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
                    if (otra.getFechaReserva().equals(reserva.getFechaReserva()) && otra.getTurnoReserva() == reserva.getTurnoReserva()) {
                        if (otra.siEquipoAudiovisual(equipoAudiovisual.getCodigoEquipoAudiovisual()) == true) {
                            return "ERROR: El equipo audiovisual " + equipoAudiovisual.getCodigoEquipoAudiovisual() + " ya está reservado y confirmado para la fecha ("
                                    + reserva.getFechaReserva() + ") y turno (" + reserva.getTurnoReserva() + ").";
                        }
                    }
                }
            }
        }
        reserva.setEstadoReserva(EstadoReserva.CONFIRMADA);
        return "Reserva " + codigoReserva + " confirmada con éxito.";
    }

    public String cambiarEstadoReserva(String codigoReserva, EstadoReserva nuevoEstado) {
        Reserva reserva = buscarReserva(codigoReserva);
        if (reserva == null) {
            return "Reserva no encontrada.";
        }
        EstadoReserva estadoActual = reserva.getEstadoReserva();
        if (estadoActual == EstadoReserva.CANCELADA || estadoActual == EstadoReserva.FINALIZADA) {
            return "No se puede cambiar el estado de una reserva que ya está CANCELADA o FINALIZADA.";
        }
        if (nuevoEstado == EstadoReserva.CONFIRMADA) {
            return confirmarReserva(codigoReserva);
        } else if (nuevoEstado == EstadoReserva.CANCELADA || nuevoEstado == EstadoReserva.FINALIZADA) {
            reserva.setEstadoReserva(nuevoEstado);
            return "Estado cambiado a " + nuevoEstado + " exitosamente.";
        } else {
            return "Estado no válido.";
        }
    }

    public ArrayList<EquipoAudiovisual> obtenerEquiposAudiovisualesDisponibles(LocalDate fecha, Turno turno) {
        ArrayList<EquipoAudiovisual> disponibles = new ArrayList<>();
        if (fecha == null || turno == null) {
            return disponibles;
        }
        for (int i = 0; i < equiposAudiovisualesSistemaPixelRent.size(); i++) {
            EquipoAudiovisual eq = equiposAudiovisualesSistemaPixelRent.get(i);
            if (eq.getCondicionEquipoAudiovisual() == CondicionEquipoAudiovisual.DISPONIBLE) {
                boolean ocupado = false;
                for (int j = 0; j < reservasSistemaPixelRent.size(); j++) {
                    Reserva res = reservasSistemaPixelRent.get(j);
                    if (res.getEstadoReserva() == EstadoReserva.CONFIRMADA
                            && res.getFechaReserva().equals(fecha)
                            && res.getTurnoReserva() == turno) {
                        if (res.siEquipoAudiovisual(eq.getCodigoEquipoAudiovisual()) == true) {
                            ocupado = true;
                            break;
                        }
                    }
                }
                if (ocupado == false) {
                    disponibles.add(eq);
                }
            }
        }
        return disponibles;
    }

    public ArrayList<Reserva> obtenerReservasConfirmadasCliente(String idCliente) {
        ArrayList<Reserva> confirmadas = new ArrayList<>();
        for (int i = 0; i < reservasSistemaPixelRent.size(); i++) {
            Reserva res = reservasSistemaPixelRent.get(i);
            if (res.getClienteReserva().numeroIdentificacionCliente().equalsIgnoreCase(idCliente)
                    && res.getEstadoReserva() == EstadoReserva.CONFIRMADA) {
                confirmadas.add(res);
            }
        }
        return confirmadas;
    }
}