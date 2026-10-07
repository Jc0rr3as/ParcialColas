package controlador;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import validaciones.validaciones;
import modelo.solicitud;
import vista.metodos;

public class menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        validaciones v = new validaciones();
        metodos m = new metodos();
        Queue<solicitud> solicitudes = new LinkedList<>();
        boolean continuar = true;
        while (continuar) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Registrar solicitud");
            System.out.println("2. Asignar solicitud");
            System.out.println("3. Salir");
            int opcion = v.ValidarEntero(sc);
            switch (opcion) {
                case 1:
                    solicitudes = m.registrarSolicitud(solicitudes);
                    break;
                case 2:
                    m.asignarSolicitud(solicitudes);
                    break;
                case 3:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
