package caso1;
import java.util.Scanner;

/**
 *
 * @author Angel
 */
public class Incio {
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== SISTEMA DE SUELDO ===");
        System.out.println("Calculo de Sueldo de Trabajadores");
        System.out.println("================================");
        
        
        System.out.print("Ingrese el nombre del trabajador: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Ingrese el apellido del trabajador: ");
        String apellido = scanner.nextLine();
        
        System.out.print("Ingrese la edad del trabajador: ");
        int edad = scanner.nextInt();
        
        System.out.print("Ingrese el pago por dia: S/.");
        double pagoPorDia = scanner.nextDouble();
        
        System.out.print("Ingrese los dias trabajados: ");
        int diasTrabajados = scanner.nextInt();
        
        System.out.print("Ingrese las horas extras trabajadas: ");
        int horasExtras = scanner.nextInt();
        
      
        Trabajador trabajador = new Trabajador(nombre, apellido, edad, pagoPorDia);
        
       
        Pago pago = new Pago(trabajador, diasTrabajados, horasExtras);
        
     
        System.out.println("\n=== RESULTADOS DEL CÁLCULO ===");
        pago.calcularSueldo();
        pago.mostrarDetallesPago();
        
        scanner.close();
    }
}