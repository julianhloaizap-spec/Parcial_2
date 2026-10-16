package co.edu.uniquindio;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    public static boolean esNumeroEntero(String str) {
        if (str == null) {
            return false;
        }
        if (str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }

    public static LocalDate convertirAFecha(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() != 10) {
            return null;
        }
        if (str.charAt(4) != '-' || str.charAt(7) != '-') {
            return null;
        }
        String aStr = str.substring(0, 4);
        String mStr = str.substring(5, 7);
        String dStr = str.substring(8, 10);
        if (esNumeroEntero(aStr) == false || esNumeroEntero(mStr) == false || esNumeroEntero(dStr) == false) {
            return null;
        }
        int anio = Integer.parseInt(aStr);
        int mes = Integer.parseInt(mStr);
        int dia = Integer.parseInt(dStr);

        if (mes < 1 || mes > 12) {
            return null;
        }
        int maxDias = 31;
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            maxDias = 30;
        } else if (mes == 2) {
            boolean esBisiesto = false;
            if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
                esBisiesto = true;
            }
            if (esBisiesto == true) {
                maxDias = 29;
            } else {
                maxDias = 28;
            }
        }
        if (dia < 1 || dia > maxDias) {
            return null;
        }
        return LocalDate.of(anio, mes, dia);
    }

    public static void main(String[] args) {
        SistemaPixelRent sistema = new SistemaPixelRent();
        inicializarDatosPrueba(sistema);

        boolean salir = false;

        while (salir == false) {
            String menu = "=== SISTEMA DE GESTIÓN PIXELRENT ===\n"
                    + "1. Registrar Sede\n"
                    + "2. Registrar Equipo Audiovisual\n"
                    + "3. Registrar Cliente\n"
                    + "4. Registrar Operador\n"
                    + "5. Crear Nueva Reserva\n"
                    + "6. Agregar Equipo Audiovisual a Reserva\n"
                    + "7. Asignar Operador a Reserva\n"
                    + "8. Confirmar Reserva\n"
                    + "9. Cambiar Estado de Reserva (Cancelar/Finalizar)\n"
                    + "10. Consultar Equipos Audiovisuales Disponibles (Fecha/Turno)\n"
                    + "11. Consultar Reservas Confirmadas de un Cliente\n"
                    + "12. Consultar Valor Total de una Reserva\n"
                    + "13. Salir\n\n"
                    + "Seleccione una opción (1-13):";

            String opcionStr = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.QUESTION_MESSAGE);

            if (opcionStr == null) {
                break;
            }

            if (esNumeroEntero(opcionStr) == false) {
                JOptionPane.showMessageDialog(null, "Opción inválida. Ingrese un número entre 1 y 13.", "Atención", JOptionPane.WARNING_MESSAGE);
                continue;
            }

            int opcion = Integer.parseInt(opcionStr);

            switch (opcion) {
                case 1:
                    registrarSede(sistema);
                    break;
                case 2:
                    registrarEquipoAudiovisual(sistema);
                    break;
                case 3:
                    registrarCliente(sistema);
                    break;
                case 4:
                    registrarOperador(sistema);
                    break;
                case 5:
                    crearReserva(sistema);
                    break;
                case 6:
                    agregarEquipoAudiovisualAReserva(sistema);
                    break;
                case 7:
                    asignarOperadorAReserva(sistema);
                    break;
                case 8:
                    confirmarReserva(sistema);
                    break;
                case 9:
                    cambiarEstadoReserva(sistema);
                    break;
                case 10:
                    consultarEquiposAudiovisualesDisponibles(sistema);
                    break;
                case 11:
                    consultarReservasConfirmadasCliente(sistema);
                    break;
                case 12:
                    consultarValorTotalReserva(sistema);
                    break;
                case 13:
                    salir = true;
                    JOptionPane.showMessageDialog(null, "¡Gracias por utilizar el sistema de PixelRent!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }

    public static void registrarSede(SistemaPixelRent sistema) {
        String codSede = JOptionPane.showInputDialog("Ingrese código de la sede:");
        String nomSede = JOptionPane.showInputDialog("Ingrese nombre de la sede:");
        String dirSede = JOptionPane.showInputDialog("Ingrese dirección de la sede:");
        if (codSede != null && nomSede != null && dirSede != null) {
            Sede nuevaSede = new Sede(codSede, nomSede, dirSede);
            if (sistema.registrarSede(nuevaSede) == true) {
                JOptionPane.showMessageDialog(null, "Sede registrada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Código de sede ya existente.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void registrarEquipoAudiovisual(SistemaPixelRent sistema) {
        String codSedeEq = JOptionPane.showInputDialog("Ingrese código de la sede a asignar:");
        if (sistema.buscarSede(codSedeEq) == null) {
            JOptionPane.showMessageDialog(null, "Error: La sede especificada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String codEq = JOptionPane.showInputDialog("Ingrese código del equipo audiovisual:");
        String marca = JOptionPane.showInputDialog("Ingrese marca:");
        String modelo = JOptionPane.showInputDialog("Ingrese modelo:");

        String menuTipo = "Seleccione el tipo de equipo audiovisual:\n1. Cámara\n2. Dron\n3. Kit Iluminación";
        String tipoStr = JOptionPane.showInputDialog(null, menuTipo, "Tipo Equipo", JOptionPane.QUESTION_MESSAGE);

        if (tipoStr == null || esNumeroEntero(tipoStr) == false) {
            JOptionPane.showMessageDialog(null, "Opción de tipo no válida.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int tipo = Integer.parseInt(tipoStr);
        EquipoAudiovisual nuevoEquipo = null;

        if (tipo == 1) {
            String res = JOptionPane.showInputDialog("Ingrese resolución máxima (ej: 4K, 8K):");
            String estabStr = JOptionPane.showInputDialog("¿Cuenta con estabilizador?\n1. Sí\n2. No");
            boolean tieneEstabilizador = false;
            if (estabStr != null && estabStr.equals("1")) {
                tieneEstabilizador = true;
            }
            nuevoEquipo = new Camara(codEq, marca, modelo, EstadoEquipoAudiovisual.DISPONIBLE, res, tieneEstabilizador);

        } else if (tipo == 2) {
            String autStr = JOptionPane.showInputDialog("Ingrese autonomía en minutos:");
            int aut = 20;
            if (esNumeroEntero(autStr) == true) {
                aut = Integer.parseInt(autStr);
            }
            String batStr = JOptionPane.showInputDialog("¿Cuenta con batería adicional?\n1. Sí\n2. No");
            boolean tieneBateria = false;
            if (batStr != null && batStr.equals("1")) {
                tieneBateria = true;
            }
            nuevoEquipo = new Dron(codEq, marca, modelo, EstadoEquipoAudiovisual.DISPONIBLE, aut, tieneBateria);

        } else if (tipo == 3) {
            String lucesStr = JOptionPane.showInputDialog("Ingrese cantidad de luces:");
            int luces = 2;
            if (esNumeroEntero(lucesStr) == true) {
                luces = Integer.parseInt(lucesStr);
            }
            String ctrlStr = JOptionPane.showInputDialog("¿Cuenta con control inalámbrico?\n1. Sí\n2. No");
            boolean tieneControl = false;
            if (ctrlStr != null && ctrlStr.equals("1")) {
                tieneControl = true;
            }
            nuevoEquipo = new KitIluminacion(codEq, marca, modelo, EstadoEquipoAudiovisual.DISPONIBLE, luces, tieneControl);
        }

        if (nuevoEquipo != null) {
            if (sistema.registrarEquipoAudiovisual(nuevoEquipo, codSedeEq) == true) {
                JOptionPane.showMessageDialog(null, "Equipo audiovisual registrado correctamente en la sede " + codSedeEq);
            } else {
                JOptionPane.showMessageDialog(null, "Error: El código de equipo audiovisual ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void registrarCliente(SistemaPixelRent sistema) {
        String idCli = JOptionPane.showInputDialog("Ingrese número de identificación:");
        String nomCli = JOptionPane.showInputDialog("Ingrese nombre cliente:");
        String telCli = JOptionPane.showInputDialog("Ingrese teléfono:");
        String mailCli = JOptionPane.showInputDialog("Ingrese correo electrónico:");

        if (idCli != null && nomCli != null) {
            Cliente nuevoCliente = new Cliente(nomCli, idCli, telCli, mailCli);
            if (sistema.registrarCliente(nuevoCliente) == true) {
                JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Ya existe un cliente con ese documento.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void registrarOperador(SistemaPixelRent sistema) {
        String idOp = JOptionPane.showInputDialog("Ingrese identificación del operador:");
        String nomOp = JOptionPane.showInputDialog("Ingrese nombre operador:");
        String certOp = JOptionPane.showInputDialog("Ingrese certificación:");
        String expStr = JOptionPane.showInputDialog("Ingrese años de experiencia:");

        int expOp = 0;
        if (esNumeroEntero(expStr) == true) {
            expOp = Integer.parseInt(expStr);
        }

        if (idOp != null && nomOp != null) {
            Operador nuevoOp = new Operador(idOp, nomOp, certOp, expOp);
            if (sistema.registrarOperador(nuevoOp) == true) {
                JOptionPane.showMessageDialog(null, "Operador registrado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Operador ya registrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void crearReserva(SistemaPixelRent sistema) {
        String codRes = JOptionPane.showInputDialog("Ingrese código único para la reserva:");
        String idCliRes = JOptionPane.showInputDialog("Ingrese número de identificación del cliente:");
        String fechaResStr = JOptionPane.showInputDialog("Ingrese fecha de uso (AAAA-MM-DD, Ejemplo: 2026-11-20):");

        LocalDate fechaRes = convertirAFecha(fechaResStr);
        if (fechaRes == null) {
            JOptionPane.showMessageDialog(null, "Error: Fecha inválida. Utilice el formato AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String menuTurno = "Seleccione el turno:\n1. Mañana\n2. Tarde\n3. Noche";
        String turnoStr = JOptionPane.showInputDialog(null, menuTurno, "Turno", JOptionPane.QUESTION_MESSAGE);

        Turno turnoRes = Turno.MANANA;
        if (turnoStr != null) {
            if (turnoStr.equals("2")) {
                turnoRes = Turno.TARDE;
            } else if (turnoStr.equals("3")) {
                turnoRes = Turno.NOCHE;
            }
        }

        if (codRes != null && idCliRes != null) {
            if (sistema.crearReserva(codRes, idCliRes, fechaRes, turnoRes) == true) {
                JOptionPane.showMessageDialog(null, "Reserva creada en estado SOLICITADA.");
            } else {
                JOptionPane.showMessageDialog(null, "Error: Código duplicado o Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void agregarEquipoAudiovisualAReserva(SistemaPixelRent sistema) {
        String cRes = JOptionPane.showInputDialog("Ingrese código de la reserva:");
        String cEq = JOptionPane.showInputDialog("Ingrese código del equipo audiovisual:");
        String hStr = JOptionPane.showInputDialog("Ingrese horas de uso requeridas:");

        int hrs = 0;
        if (esNumeroEntero(hStr) == true) {
            hrs = Integer.parseInt(hStr);
        }

        String resAgregar = sistema.agregarEquipoAudiovisualAReserva(cRes, cEq, hrs);
        JOptionPane.showMessageDialog(null, resAgregar);
    }

    public static void asignarOperadorAReserva(SistemaPixelRent sistema) {
        String cResOp = JOptionPane.showInputDialog("Ingrese código de la reserva:");
        String idOpAsig = JOptionPane.showInputDialog("Ingrese número de identificación del operador:");

        if (sistema.asignarOperadorAReserva(cResOp, idOpAsig) == true) {
            JOptionPane.showMessageDialog(null, "Operador asignado a la reserva.");
        } else {
            JOptionPane.showMessageDialog(null, "Error: No se pudo asignar. Verifique estado de reserva o existencia de datos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void confirmarReserva(SistemaPixelRent sistema) {
        String cResConf = JOptionPane.showInputDialog("Ingrese código de la reserva a confirmar:");
        String resConfirm = sistema.confirmarReserva(cResConf);
        JOptionPane.showMessageDialog(null, resConfirm);
    }

    public static void cambiarEstadoReserva(SistemaPixelRent sistema) {
        String cResCamb = JOptionPane.showInputDialog("Ingrese código de la reserva:");
        String menuEstado = "Seleccione el nuevo estado:\n1. CANCELADA\n2. FINALIZADA";
        String estStr = JOptionPane.showInputDialog(null, menuEstado, "Cambio de Estado", JOptionPane.QUESTION_MESSAGE);

        if (estStr != null) {
            if (estStr.equals("1")) {
                String respCambio = sistema.cambiarEstadoReserva(cResCamb, EstadoReserva.CANCELADA);
                JOptionPane.showMessageDialog(null, respCambio);
            } else if (estStr.equals("2")) {
                String respCambio = sistema.cambiarEstadoReserva(cResCamb, EstadoReserva.FINALIZADA);
                JOptionPane.showMessageDialog(null, respCambio);
            }
        }
    }

    public static void consultarEquiposAudiovisualesDisponibles(SistemaPixelRent sistema) {
        String fConsStr = JOptionPane.showInputDialog("Ingrese fecha a consultar (AAAA-MM-DD, Ej: 2026-11-20):");
        LocalDate fCons = convertirAFecha(fConsStr);
        if (fCons == null) {
            JOptionPane.showMessageDialog(null, "Error: Fecha inválida. Debe ser formato AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String menuTurno = "Seleccione turno a consultar:\n1. Mañana\n2. Tarde\n3. Noche";
        String tStr = JOptionPane.showInputDialog(null, menuTurno, "Consulta Disponibilidad", JOptionPane.QUESTION_MESSAGE);

        Turno tSeleccionado = Turno.MANANA;
        if (tStr != null) {
            if (tStr.equals("2")) {
                tSeleccionado = Turno.TARDE;
            } else if (tStr.equals("3")) {
                tSeleccionado = Turno.NOCHE;
            }
        }

        ArrayList<EquipoAudiovisual> dispon = sistema.obtenerEquiposAudiovisualesDisponibles(fCons, tSeleccionado);
        String mensajeDispon = "Equipos Audiovisuales Disponibles para " + fCons + " [" + tSeleccionado + "]:\n";
        if (dispon.isEmpty() == true) {
            mensajeDispon = mensajeDispon + "No hay equipos disponibles.";
        } else {
            for (int i = 0; i < dispon.size(); i++) {
                EquipoAudiovisual e = dispon.get(i);
                mensajeDispon = mensajeDispon + "- [" + e.getCodigoEquipoAudiovisual() + "] " + e.getMarcaEquipoAudiovisual() + " " + e.getModeloEquipoAudiovisual()
                        + " (" + e.getClass().getSimpleName() + ")\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensajeDispon);
    }

    public static void consultarReservasConfirmadasCliente(SistemaPixelRent sistema) {
        String idCliConsulta = JOptionPane.showInputDialog("Ingrese identificación del cliente:");
        ArrayList<Reserva> confs = sistema.obtenerReservasConfirmadasCliente(idCliConsulta);
        String mensajeConf = "Reservas Confirmadas del Cliente " + idCliConsulta + ":\n";
        if (confs.isEmpty() == true) {
            mensajeConf = mensajeConf + "No se encontraron reservas confirmadas.";
        } else {
            for (int i = 0; i < confs.size(); i++) {
                Reserva r = confs.get(i);
                mensajeConf = mensajeConf + "Código: " + r.getCodigoReserva()
                        + " | Fecha: " + r.getFechaReserva()
                        + " | Turno: " + r.getTurnoReserva()
                        + " | Total: $" + r.calcularValorTotal() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, mensajeConf);
    }

    public static void consultarValorTotalReserva(SistemaPixelRent sistema) {
        String cResValor = JOptionPane.showInputDialog("Ingrese código de la reserva:");
        Reserva rValor = sistema.buscarReserva(cResValor);
        if (rValor != null) {
            String detalleVal = "Reserva: " + rValor.getCodigoReserva() + "\n"
                    + "Cliente: " + rValor.getClienteReserva().getNombreCliente() + "\n"
                    + "Estado: " + rValor.getEstadoReserva() + "\n"
                    + "VALOR TOTAL: $" + rValor.calcularValorTotal();
            JOptionPane.showMessageDialog(null, detalleVal);
        } else {
            JOptionPane.showMessageDialog(null, "Reserva no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void inicializarDatosPrueba(SistemaPixelRent sistema) {
        sistema.registrarSede(new Sede("S01", "Sede Central", "Calle 10 # 12-34"));

        sistema.registrarEquipoAudiovisual(new Camara("CAM01", "Sony", "FX3", EstadoEquipoAudiovisual.DISPONIBLE, "4K", true), "S01");
        sistema.registrarEquipoAudiovisual(new Dron("DRN01", "DJI", "Mavic 3", EstadoEquipoAudiovisual.DISPONIBLE, 45, true), "S01");
        sistema.registrarEquipoAudiovisual(new KitIluminacion("KIT01", "Aputure", "600d", EstadoEquipoAudiovisual.DISPONIBLE, 3, true), "S01");

        sistema.registrarCliente(new Cliente("Carlos Gómez", "1010", "3001234567", "carlos@gmail.com"));
        sistema.registrarOperador(new Operador("9090", "Ana Martínez", "Piloto Dron Pro", 5));
    }
}