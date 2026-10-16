package co.edu.uniquindio;

import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.util.ArrayList;

public class MainEmpresaPixelRent {

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
            String menu = "SISTEMA DE GESTIÓN PIXELRENT\n" +
                    "Seleccione una opción de (1 a 13):"
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
                    + "13. Salir\n\n";


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
                    String codSede = JOptionPane.showInputDialog("Ingrese código de la sede:");
                    String nomSede = JOptionPane.showInputDialog("Ingrese nombre de la sede:");
                    String dirSede = JOptionPane.showInputDialog("Ingrese dirección de la sede:");
                    if (codSede != null && nomSede != null && dirSede != null) {
                        Sede nuevaSede = new Sede(codSede, nomSede, dirSede);
                        if (sistema.registrarSede(nuevaSede) == true) {
                            JOptionPane.showMessageDialog(null, "Sede registrada exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Código de sede ya existente.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    String codSedeEq = JOptionPane.showInputDialog("Ingrese código de la sede a asignar:");
                    if (sistema.buscarSede(codSedeEq) == null) {
                        JOptionPane.showMessageDialog(null, "La sede especificada no existe.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    String codEq = JOptionPane.showInputDialog("Ingrese código del equipo audiovisual:");
                    String marca = JOptionPane.showInputDialog("Ingrese marca:");
                    String modelo = JOptionPane.showInputDialog("Ingrese modelo:");

                    String[] opcionesTipo = {"Cámara", "Dron", "Kit Iluminación"};
                    int tipo = JOptionPane.showOptionDialog(null, "Seleccione el tipo de equipo audiovisual:", "Tipo Equipo",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesTipo, opcionesTipo[0]);

                    EquipoAudiovisual nuevoEquipo = null;

                    if (tipo == 0) {
                        String res = JOptionPane.showInputDialog("Ingrese resolución máxima (ej: 4K, 8K):");
                        int estab = JOptionPane.showConfirmDialog(null, "¿Cuenta con estabilizador?", "Estabilizador", JOptionPane.YES_NO_OPTION);

                        boolean tieneEstabilizador = false;
                        if (estab == JOptionPane.YES_OPTION) {
                            tieneEstabilizador = true;
                        }

                        nuevoEquipo = new Camara(codEq, marca, modelo, CondicionEquipoAudiovisual.DISPONIBLE, res, tieneEstabilizador);

                    } else if (tipo == 1) {
                        String autStr = JOptionPane.showInputDialog("Ingrese autonomía en minutos:");
                        int aut = 20;
                        if (esNumeroEntero(autStr) == true) {
                            aut = Integer.parseInt(autStr);
                        }

                        int bat = JOptionPane.showConfirmDialog(null, "¿Cuenta con batería adicional?", "Batería Extra", JOptionPane.YES_NO_OPTION);
                        boolean tieneBateria = false;
                        if (bat == JOptionPane.YES_OPTION) {
                            tieneBateria = true;
                        }

                        nuevoEquipo = new Dron(codEq, marca, modelo, CondicionEquipoAudiovisual.DISPONIBLE, aut, tieneBateria);

                    } else if (tipo == 2) {
                        String lucesStr = JOptionPane.showInputDialog("Ingrese cantidad de luces:");
                        int luces = 2;
                        if (esNumeroEntero(lucesStr) == true) {
                            luces = Integer.parseInt(lucesStr);
                        }

                        int ctrl = JOptionPane.showConfirmDialog(null, "¿Cuenta con control inalámbrico?", "Control Inalámbrico", JOptionPane.YES_NO_OPTION);
                        boolean tieneControl = false;
                        if (ctrl == JOptionPane.YES_OPTION) {
                            tieneControl = true;
                        }

                        nuevoEquipo = new KitIluminacion(codEq, marca, modelo, CondicionEquipoAudiovisual.DISPONIBLE, luces, tieneControl);
                    }

                    if (nuevoEquipo != null) {
                        if (sistema.registrarEquipoAudiovisual(nuevoEquipo, codSedeEq) == true) {
                            JOptionPane.showMessageDialog(null, "Equipo audiovisual registrado correctamente en la sede " + codSedeEq);
                        } else {
                            JOptionPane.showMessageDialog(null, "El código de equipo audiovisual ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 3:
                    String idCli = JOptionPane.showInputDialog("Ingrese número de identificación:");
                    String nomCli = JOptionPane.showInputDialog("Ingrese nombre cliente:");
                    String telCli = JOptionPane.showInputDialog("Ingrese teléfono:");
                    String mailCli = JOptionPane.showInputDialog("Ingrese correo electrónico:");

                    if (idCli != null && nomCli != null) {
                        Cliente nuevoCliente = new Cliente(nomCli, idCli, telCli, mailCli);
                        if (sistema.registrarCliente(nuevoCliente) == true) {
                            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Ya existe un cliente con ese documento.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 4:
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
                            JOptionPane.showMessageDialog(null, "Operador ya registrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 5:
                    String codRes = JOptionPane.showInputDialog("Ingrese código único para la reserva:");
                    String idCliRes = JOptionPane.showInputDialog("Ingrese número de identificación del cliente:");
                    String fechaResStr = JOptionPane.showInputDialog("Ingrese fecha de uso (AAAA-MM-DD, Ejemplo: 2026-11-20):");

                    LocalDate fechaRes = convertirAFecha(fechaResStr);
                    if (fechaRes == null) {
                        JOptionPane.showMessageDialog(null, "Fecha inválida. Utilice el formato AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    Turno[] turnosEnum = Turno.values();
                    String[] turnosStr = {"MAÑANA", "TARDE", "NOCHE"};
                    int selTurno = JOptionPane.showOptionDialog(null, "Seleccione el turno:", "Turno",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, turnosStr, turnosStr[0]);

                    Turno turnoRes = Turno.MANANA;
                    if (selTurno >= 0) {
                        turnoRes = turnosEnum[selTurno];
                    }

                    if (codRes != null && idCliRes != null) {
                        if (sistema.crearReserva(codRes, idCliRes, fechaRes, turnoRes) == true) {
                            JOptionPane.showMessageDialog(null, "Reserva creada en estado SOLICITADA.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Código duplicado o Cliente no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    break;

                case 6:
                    String cRes = JOptionPane.showInputDialog("Ingrese código de la reserva:");
                    String cEq = JOptionPane.showInputDialog("Ingrese código del equipo audiovisual:");
                    String hStr = JOptionPane.showInputDialog("Ingrese horas de uso requeridas:");

                    int hrs = 0;
                    if (esNumeroEntero(hStr) == true) {
                        hrs = Integer.parseInt(hStr);
                    }

                    String resAgregar = sistema.agregarEquipoAudiovisualAReserva(cRes, cEq, hrs);
                    JOptionPane.showMessageDialog(null, resAgregar);
                    break;

                case 7:
                    String cResOp = JOptionPane.showInputDialog("Ingrese código de la reserva:");
                    String idOpAsig = JOptionPane.showInputDialog("Ingrese número de identificación del operador:");

                    if (sistema.asignarOperadorAReserva(cResOp, idOpAsig) == true) {
                        JOptionPane.showMessageDialog(null, "Operador asignado a la reserva.");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo asignar. Verifique estado de reserva o existencia de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 8:
                    String cResConf = JOptionPane.showInputDialog("Ingrese código de la reserva a confirmar:");
                    String resConfirm = sistema.confirmarReserva(cResConf);
                    JOptionPane.showMessageDialog(null, resConfirm);
                    break;

                case 9:
                    String cResCamb = JOptionPane.showInputDialog("Ingrese código de la reserva:");
                    String[] opcionesEstado = {"CANCELADA", "FINALIZADA"};
                    int selEst = JOptionPane.showOptionDialog(null, "Seleccione el nuevo estado:", "Cambio de Estado",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcionesEstado, opcionesEstado[0]);

                    if (selEst == 0) {
                        String respCambio = sistema.cambiarEstadoReserva(cResCamb, EstadoReserva.CANCELADA);
                        JOptionPane.showMessageDialog(null, respCambio);
                    } else if (selEst == 1) {
                        String respCambio = sistema.cambiarEstadoReserva(cResCamb, EstadoReserva.FINALIZADA);
                        JOptionPane.showMessageDialog(null, respCambio);
                    }
                    break;

                case 10:
                    String fConsStr = JOptionPane.showInputDialog("Ingrese fecha a consultar (AAAA-MM-DD, Ej: 2026-11-20):");
                    LocalDate fCons = convertirAFecha(fConsStr);
                    if (fCons == null) {
                        JOptionPane.showMessageDialog(null, "Fecha inválida. Debe ser formato AAAA-MM-DD.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    String[] turnosCons = {"MAÑANA", "TARDE", "NOCHE"};
                    int tCons = JOptionPane.showOptionDialog(null, "Seleccione turno a consultar:", "Consulta Disponibilidad",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, turnosCons, turnosCons[0]);

                    if (tCons >= 0) {
                        Turno tSeleccionado = Turno.values()[tCons];
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
                    break;

                case 11:
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
                    break;

                case 12:
                    String cResValor = JOptionPane.showInputDialog("Ingrese código de la reserva:");
                    Reserva rValor = sistema.buscarReserva(cResValor);
                    if (rValor != null) {
                        String detalleVal = "Reserva: " + rValor.getCodigoReserva() + "\n"
                                + "Cliente: " + rValor.getClienteReserva().nombreCliente() + "\n"
                                + "Estado: " + rValor.getEstadoReserva() + "\n"
                                + "VALOR TOTAL: $" + rValor.calcularValorTotal();
                        JOptionPane.showMessageDialog(null, detalleVal);
                    } else {
                        JOptionPane.showMessageDialog(null, "Reserva no encontrada.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
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

    private static void inicializarDatosPrueba(SistemaPixelRent sistema) {
        sistema.registrarSede(new Sede("S01", "Sede Central", "Calle 10 # 12-34"));

        sistema.registrarEquipoAudiovisual(new Camara("CAM01", "Sony", "FX3", CondicionEquipoAudiovisual.DISPONIBLE, "4K", true), "S01");
        sistema.registrarEquipoAudiovisual(new Dron("DRN01", "DJI", "Mavic 3", CondicionEquipoAudiovisual.DISPONIBLE, 45, true), "S01");
        sistema.registrarEquipoAudiovisual(new KitIluminacion("KIT01", "Aputure", "600d", CondicionEquipoAudiovisual.DISPONIBLE, 3, true), "S01");

        sistema.registrarCliente(new Cliente("Carlos Gómez", "1010", "3001234567", "carlos@gmail.com"));
        sistema.registrarOperador(new Operador("9090", "Ana Martínez", "Piloto Dron Pro", 5));
    }
}