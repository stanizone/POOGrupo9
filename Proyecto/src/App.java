import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args)
    {
          Scanner leer = new Scanner(System.in);
          List<Cliente> clientes = new LinkedList<>();
          List<Habitacion> habitaciones = new LinkedList<>();
          List<String> listafeedback = new LinkedList<>();
          int opcion = 0;

          //Clientes ya generados
          Cliente cliente1 = new Cliente(72733562, "Stefanno", "Rossel", "15-10-04", "si");
          Cliente cliente2 = new Cliente(30303030, "Ramon", "Valdez", "20-05-66", "no");
          clientes.add(cliente1);
          clientes.add(cliente2);

          //habitaciones ya generadas
          Habitacion hab1 = new Habitacion(101, "Individual", 20);    habitaciones.add(hab1);
          Habitacion hab2 = new Habitacion(102, "Doble", 30);         habitaciones.add(hab2);
          Habitacion hab3 = new Habitacion(201, "Individual", 20);    habitaciones.add(hab3);
          Habitacion hab4 = new Habitacion(202, "Doble", 30);         habitaciones.add(hab4);
          Habitacion hab5 = new Habitacion(301, "Triple", 35);        habitaciones.add(hab5);
          Habitacion hab6 = new Habitacion(302, "Triple", 35);        habitaciones.add(hab6);

          do 
          {
            System.out.println("\nBienvenido al Hotel EXID, donde excederemos tus expectativas");
            System.out.println("Por favor, escriba la opción que describa la acción que desea realizar:");
            System.out.println("1. Registrarse");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Consultar habitación");
            System.out.println("4. Dejar feedback");
            System.out.println("5. Salir");

            try 
            {
                opcion = leer.nextInt();
                leer.nextLine();
            }
            catch(Exception e)
            {
                System.out.println("Ingresa una opción (número)");
            }
         
          }while(opcion != 5);

          leer.close();
    }

//------------------------------------------------------------------
// Separación del codigo con las clases:
//------------------------------------------------------------------


    abstract static class Persona 
    {
       protected int DNI;
       protected String nombre;
       protected String apellido;
       protected String fechaNacimiento;
       
       public Persona(int DNI, String nombre, String apellido, String fechaNacimiento) 
       {
          this.DNI = DNI;
          this.nombre = nombre;
          this.apellido = apellido;
          this.fechaNacimiento = fechaNacimiento;
       }

       public abstract void mostrarDatos();
    }


    static class Cliente extends Persona
    {
      private String tienePromocion = "no";
      private int numHab;
      private int totalAPagar;

       public Cliente(int DNI, String nombre, String apellido, String fechaNacimiento, String tienePromocion)
       {
         super(DNI, nombre, apellido, fechaNacimiento);
         this.tienePromocion = tienePromocion;
       }

           @Override //Esto de override, nos indica que es un método traido del padre.
           public void mostrarDatos() 
           {
               System.out.println("DNI: " + this.DNI + "Nombre: " + this.nombre + "Apellido: " + this.apellido + "Fecha de nacimiento: " + this.fechaNacimiento + "Promocion: " + this.tienePromocion);
           }

           public void setHabitacion(int num)
           {
            this.numHab = num;
           }

           public void setTotalAPagar(int num)
           {
            this.totalAPagar = num;
           }
    }

    static class Habitacion
    {
       private int numero = 0;
       private String tipo = "";
       private Cliente cliente = null;
       private boolean ocupado = false;
       private int precioPorNoche = 0;
       private int diasReservados = 0;

       public Habitacion(int numero, String tipo, int precio)
       {
         this.numero = numero;
         this.tipo = tipo;
         this.precioPorNoche = precio;
       }

       public void estaOcupada()
       {
          if(ocupado == false)
          {
            System.out.println("Esta habitación está libre");
          }
          else  
          {
            System.out.println("Esta habitación está ocupada por " + diasReservados);
          }
       }

       public void setDiasReservados(int num)
       {
        this.diasReservados = num;
       }
    }
}

