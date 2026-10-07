package vista;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import validaciones.validaciones;
import modelo.solicitud;

public class metodos {
    Scanner sc = new Scanner(System.in);
    validaciones v = new validaciones();
    public Queue<solicitud> registrarSolicitud(Queue<solicitud> solicitudes) {
    boolean continuar = true;
    while (continuar) {
        solicitud solicitud = new solicitud();
        System.out.println("Ingrese el nombre del remitente:");
        solicitud.setNombre(sc.nextLine());
        System.out.println("Ingrese el ID de la solicitud:");
        solicitud.setId(String.valueOf(v.ValidarEntero(sc)));
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese el origen:");
        solicitud.setOrigen(sc.nextLine());
        System.out.println("Ingrese el destino:");
        solicitud.setDestino(sc.nextLine());
        System.out.println("Ingrese la mercancia:");
        solicitud.setMercancia(sc.nextLine());
        System.out.println("Ingrese el peso (en kg):");
        solicitud.setPeso(v.ValidarDecimal(sc));
        sc.nextLine(); // Limpiar el buffer
        System.out.println("Ingrese la prioridad (1.alta, 2.media, 3.baja):");
        solicitud.setPrioridad(String.valueOf(v.ValidarEntero(sc)));
        sc.nextLine(); // Limpiar el buffer
        solicitud.setEstado("Pendiente");

        solicitudes.add(solicitud);

        System.out.println("¿Desea registrar otra solicitud? (si/no)");
        String respuesta = v.ValidarSioNo(sc);
        if (respuesta.equalsIgnoreCase("no")) {
            continuar = false;
        }    
    }
    return solicitudes;
    }

    public void asignarSolicitud(Queue<solicitud> solicitudes) {
        if (solicitudes.isEmpty()) {
            System.out.println("No hay solicitudes pendientes.");
            return;
        }
            Queue<solicitud> prioridadAlta = new LinkedList<>();
            Queue<solicitud> prioridadMedia = new LinkedList<>();
            Queue<solicitud> prioridadBaja = new LinkedList<>();
        for (solicitud s : solicitudes) {
            if (s.getEstado().equalsIgnoreCase("Pendiente")) {
                switch (s.getPrioridad()) {
                    case "1":
                        prioridadAlta.add(s);
                        break;
                    case "2":
                        prioridadMedia.add(s);
                        break;
                    case "3":
                        prioridadBaja.add(s);
                        break;
                    default:
                        System.out.println("Prioridad no válida para la solicitud con ID: " + s.getId());
                }
            }
        }
        System.out.println("Ingrese la placa del vehículo:");
        String placa = sc.nextLine();
        System.out.println("Ingrese la capacidad del vehículo (en kg):");
        double capacidad = v.ValidarDecimal(sc);
        String asignado = "no";
        sc.nextLine(); // Limpiar el buffer
        boolean continuarAlta = true;
        boolean continuarMedia = true;
        boolean continuarBaja = true;
        while(continuarAlta){
            if(!prioridadAlta.isEmpty()){
                for (solicitud s : prioridadAlta) {
                if (s.getPeso() <= capacidad) {
                s.setEstado("Asignada");
                System.out.println("Solicitud con ID " + s.getId() + " asignada al vehículo con placa " + placa);
                asignado = "si";
                continuarAlta = false;
            } else {
                System.out.println("Solicitud con ID " + s.getId() + " no puede ser asignada al vehículo con placa " + placa + " debido a que excede la capacidad.");
                System.out.println("Se asignará la siguiente solicitud.");
            }
            }
            continuarAlta = false;
        } else {
            System.out.println("No hay solicitudes de prioridad alta pendientes.");
            continuarAlta = false;
        }
    }
            if(asignado.equals("no")){
                while(continuarMedia){
                if(!prioridadMedia.isEmpty()){
                    for (solicitud s : prioridadMedia) {
                    if (s.getPeso() <= capacidad) {
                    s.setEstado("Asignada");
                    System.out.println("Solicitud con ID " + s.getId() + " asignada al vehículo con placa " + placa);
                    asignado = "si";
                    continuarMedia = false;
                } else {
                    System.out.println("Solicitud con ID " + s.getId() + " no puede ser asignada al vehículo con placa " + placa + " debido a que excede la capacidad.");
                    System.out.println("Se asignará la siguiente solicitud.");
                }
            }
            continuarMedia = false;
        }else{
            System.out.println("No hay solicitudes de prioridad media pendientes.");
                    continuarMedia = false;
                }
            }
        }
    
    if(asignado.equals("no")){
        while(continuarBaja){
            if(!prioridadBaja.isEmpty()){
                for (solicitud s : prioridadBaja) {
                    if (s.getPeso() <= capacidad) {
                    s.setEstado("Asignada");
                    System.out.println("Solicitud con ID " + s.getId() + " asignada al vehículo con placa " + placa);
                    asignado = "si";
                    continuarBaja = false;
                } else {
                    System.out.println("Solicitud con ID " + s.getId() + " no puede ser asignada al vehículo con placa " + placa + " debido a que excede la capacidad.");
                    System.out.println("Se asignará la siguiente solicitud.");
                }
            }
            System.out.println("No se pudo asignar ninguna solicitud al vehículo con placa " + placa);
             continuarBaja = false;  
            }else{
                System.out.println("No se pudo asignar ninguna solicitud al vehículo con placa " + placa);
                continuarBaja = false;
            }
        }
    }
            
    }
}
