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
          Cliente cliactual = null;
          Cliente cliente1 = new Cliente(72733562, "Stefanno", "Rossel", "15-10-04", "papaya3");
          clientes.add(cliente1);
          

          //habitaciones ya generadas
          Habitacion hab1 = new Habitacion(101, "Individual", 20);    habitaciones.add(hab1);
          Habitacion hab2 = new Habitacion(102, "Doble", 30);         habitaciones.add(hab2);
          Habitacion hab3 = new Habitacion(201, "Individual", 20);    habitaciones.add(hab3);
          Habitacion hab4 = new Habitacion(202, "Doble", 30);         habitaciones.add(hab4);
          Habitacion hab5 = new Habitacion(301, "Triple", 35);        habitaciones.add(hab5);
          Habitacion hab6 = new Habitacion(302, "Triple", 35);        habitaciones.add(hab6);

          //supervisor generado:
          Supervisor Javier = new Supervisor(78085567, "Javier", "Conde", "10-06-76", "Gelatina");

          do 
          {
            System.out.println("\nBienvenido al Hotel EXID, donde excederemos tus expectativas");
            System.out.println("Por favor, escriba la opción que describa la acción que desea realizar:");
            System.out.println("1. Registrarse");
            System.out.println("2. Reservar habitación");
            System.out.println("3. Consultar habitación");
            System.out.println("4. Dejar feedback");
            System.out.println("5. Pedir comida a habitación");
            System.out.println("6. Comer");
            System.out.println("7. Ver información de usuarios");
            System.out.println("8. Ver feedback");
            System.out.println("9. Elegir/Cambiar de usuario");
            System.out.println("10. Salir");

            try 
            {
                opcion = leer.nextInt();
                leer.nextLine();

                switch (opcion) 
                {
                    case 1:
                        System.out.print("Ingrese su DNI: ");
                        try 
                        {
                            int dni = leer.nextInt();    
                            leer.nextLine();

                            if (dni < 10000000 || dni > 99999999) 
                            {
                                System.out.println("Lo sentimos, su DNI no es válido.");
                                break;
                            }

                            int cancelar = 0; //para que vuelva a hacer bucle;
                            for(Cliente cliente : clientes)
                            {
                              if(dni == cliente.DNI)
                              {
                                System.out.println("Este cliente ya está registrado");
                                cancelar = 1;
                              }
                            }

                            if(cancelar == 1) //si se encuentra el dni registrado, hace el bucle
                            {
                                break;
                            }

                            System.out.print("Ingrese su Nombre: ");
                            String nombre = leer.nextLine().trim();
                            
                            if (nombre.isEmpty() || !nombre.matches("[A-Za-z ]+")) 
                            {
                                System.out.println("Nombre inválido");
                                break;
                            }

                            System.out.print("Ingrese su Apellido: ");
                            String apellido = leer.nextLine().trim();
                            
                            if (apellido.isEmpty() || !apellido.matches("[A-Za-z ]+"))
                            {
                                System.out.println("El apellido no puede estar vacío.");
                                break;
                            }

                            System.out.print("Ingrese su fecha de nacimiento (día-mes-año): ");
                            try
                            {
                               String fechaNacimiento = leer.nextLine().trim();
                               if(!fechaNacimiento.matches("\\d{2}-\\d{2}-(\\d{2}|\\d{4})"))
                               { 
                                 System.out.println("fecha inválida");
                               }
                               else
                               {
                                  System.out.println("Cree su contraseña");
                                  String contraseña = leer.nextLine();
                                
                                  Cliente nuevo = new Cliente(dni, nombre, apellido, fechaNacimiento,contraseña);
                                  clientes.add(nuevo);
                                  cliactual = nuevo;
                                  System.out.println("Has creado un cliente");
                                  break; 
                               }
                               
                            }
                            catch(Exception e)
                            {
                                System.out.println("Fecha no válida");
                            }
                            break;
                        } 
                        catch (Exception e) 
                        {
                            System.out.println("El DNI es inválido.");
                            leer.nextLine();
                        }
                        break;

                    case 2:
                    
                        if(cliactual == null)
                        {
                            System.out.println("Necesitas estar registrado para reservar una habitación");
                            break;
                        }
                        else
                        {
                          System.out.println("Actualmente tenemos disponibles las siguientes habitaciones:\n");    
                          for(Habitacion hab : habitaciones)
                          {
                              if(hab.ocupado == false)
                              {
                                  System.out.println("Número " + hab.numero + ": Tipo " + hab.tipo + "      Precio: " + hab.precioPorNoche + " Soles por noche");
                              }
                          }

                          System.out.println("\nQué habitación deseas reservar?");
                          int numHabElegida = leer.nextInt(); leer.nextLine();

                          cliactual.setHabitacion(numHabElegida); 

                          Habitacion habElegida = getHabitacion(habitaciones, numHabElegida);

                          if(habElegida.ocupado == true)
                          {
                            System.out.println("Esta habitación ya está ocupada");
                            break;
                          }
                          else
                          {
                            System.out.println("Cuántos días lo vas a reservar?");
                            int numDias = leer.nextInt(); leer.nextLine();

                            System.out.println("\nEl cliente " + cliactual.nombre + " con DNI " + cliactual.DNI + " ha reservado la habitación por " + numDias + " días"); 
                            habElegida.ocupado = true;
                            habElegida.diasReservados = numDias;   
                            cliactual.totalAPagar = (habElegida.precioPorNoche * numDias);              
                          }
                          

                        }
                        break;

                    case 3:
                        System.out.println("Ingrese el número de habitación para recibir información");
                        try
                        {
                          int habElegida = leer.nextInt(); leer.nextLine(); 
                          Habitacion hab = getHabitacion(habitaciones, habElegida);
                          if(hab == null) 
                          {
                            System.out.println("Esta habitación no existe");
                          }
                          System.out.println("\nTipo de habitación: " + hab.tipo + "\nPrecio por noche: " + hab.precioPorNoche + " soles.");
                          System.out.println(hab.estaOcupada());
                          break;
                        }
                        catch(Exception e)
                        {
                            
                        }
                        break;

                    case 4:
                        if(cliactual == null)
                        {
                          System.out.println("Necesitas estar registrado");
                        }
                        else
                        {
                           System.out.println("Escriba lo que desea que el hotel sepa");                       
                          try
                          {
                            String fb = leer.nextLine();
                            listafeedback.add("\nEl cliente con DNI " + cliactual.DNI + " ha dado la siguiente retroalimentación: "  + fb);
                          }
                          catch(Exception e)
                          {
                            System.out.println("Ingrese una cadena de texto");
                          } 
                        }                        
                        break;

                    case 5:
                        if(cliactual == null)
                        {
                          System.out.println("Necesitas estar registrado");
                        }
                        else
                        {
                          cliactual.solicitarComida();  
                        }
                        break;
                    
                    case 6:
                        if(cliactual == null)
                        {
                          System.out.println("Necesitas estar registrado");
                        }
                        else if(cliactual.comida == null)
                        {
                          System.out.println("Para comer, primero debes pedir comida");
                        }
                        else
                        {
                          cliactual.Comer();
                        }
                        break;
                    
                    case 7: 
                        System.out.println("Bienvenido supervisor, escriba su contraseña.");
                        String contra = leer.nextLine();

                        if(!Javier.contraseña.equals(contra))
                        {
                          System.out.println("Contraseña incorrecta");
                        }
                        else
                        {
                          System.out.println("Escriba el DNI del usuario que desea ver");
                          try
                          {
                            int dni = leer.nextInt();
                            leer.nextLine();
                            Javier.mostrarDatosCliente(clientes, dni);
                          }
                          catch(Exception e)
                          {
                            System.out.println("DNI incorrecto");
                            leer.nextLine();
                          }  
                        }
                        break;

                    case 8:
                        System.out.println("Bienvenido supervisor, escriba su contraseña.");
                        contra = leer.nextLine();
                        
                        if(!Javier.contraseña.equals(contra))
                        {
                          System.out.println("Contraseña incorrecta"); 
                        }
                        else
                        {
                           System.out.println("Escriba el número feedback que desea ver");
                          try
                          {
                            int num = leer.nextInt(); leer.nextLine();
                            Javier.verFeedback(listafeedback, num);                           
                          }
                          catch(Exception e)
                          {
                            System.out.println("Este número de feedback no existe");
                            leer.nextLine();
                          }
                        }
                        break;

                    case 9:
                        System.out.println("Selecciona el DNI de la otra persona para cambiar de usuario");
                        try
                        {
                          int dni = leer.nextInt();
                          leer.nextLine();

                          Cliente cliPrueba = getCliente(clientes, dni);
                          System.out.println("Escriba la contraseña del usuario");
                          contra = leer.nextLine(); 
                          if(cliPrueba.contraseña.equals(contra))
                          {
                            cliactual = cliPrueba;
                          }
                          else
                          {
                            System.out.println("Contaseña incorrecta");
                          }
                        }
                        catch(Exception e)
                        {
                          System.out.println("Codigo invalido");
                          leer.nextLine();
                        } 
                        break;

                    case 10:
                         System.out.println("Has salido del programa");
                         break;
                       
                     default:
                         System.out.println("Ingresa un número correcto.");
                         break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Ingresa una opción (número)");
                leer.nextLine();
            }
         
          }while(opcion != 10);

          leer.close();
    }


//------------------------------------------------------------------
// Separación del codigo con las clases:
//------------------------------------------------------------------



// 1. Método que devuelve un cliente solo con buscar el dni
static Cliente getCliente(List<Cliente> clientes, int dni)  
{
  for (Cliente cli : clientes) 
  {
    if(dni == cli.DNI)
    {
      return cli;
    } 
  }
  return null;    
}


// 2. hice lo mismo acá para buscar una habitación por su número
static Habitacion getHabitacion(List<Habitacion> habitaciones, int num)  
{
  for (Habitacion hab : habitaciones) 
  {
    if(num == hab.numero)
    {
      return hab;
    } 
  }
  return null;
}


//-----------------------------------------------

//3. Clase abstracta de Persona, que se usará en el Cliente y el Supervisor.
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

}


//4. Clase cliente
static class Cliente extends Persona
{
    private int numHab;
    private int totalAPagar;
    private boolean solicitoComida = false;
    private String comida;
    private String contraseña = "";

    public Cliente(int DNI, String nombre, String apellido, String fechaNacimiento, String contraseña)
    {
       super(DNI, nombre, apellido, fechaNacimiento);
       this.contraseña = contraseña;
    }

    public void mostrarDatos() 
    {
       System.out.println("DNI: " + this.DNI + "Nombre: " + this.nombre + "Apellido: " + this.apellido + "Fecha de nacimiento: " + this.fechaNacimiento + " Se encuentra en la habitación "+ numHab + " y tiene un total a pagar de: " + totalAPagar + " soles.");
    }

    public void setHabitacion(int num)
    {
       this.numHab = num;
    }

    public void setTotalAPagar(int num)
    {
       this.totalAPagar = num;
    }

    public void solicitarComida()
    { 
      Scanner sc = new Scanner(System.in);
             
      if(solicitoComida == true)
      {
         System.out.println("Ya has pedido comida!");
         sc.close();
         return;
      }
        
      System.out.println("\nElija la opción que quiera comer\n1. Lasaña\n2. Causa\n3. Pan con chicharrón");

      try
      {
        int op = sc.nextInt();
        sc.nextLine();
        switch(op)
        {
            case 1: comida = "lasaña";
            break;

            case 2: comida = "causa";
            break;
                    
            case 3: comida = "pan con chicharrón";
            break;

            default:
            System.out.println("Esta no es una opción válida");
            sc.close();
            return;
        }

        try
        {
            this.solicitoComida = true;
            System.out.println("El cliente " + this.nombre + " solicita comer " + comida + "\nDespués de unos minutos, la comida llega a su puerta.");
        }
        catch(Exception e)
        {
            System.out.println("Esta no es una opción válida");   
        }
      }
      catch(Exception e)
      {
        System.out.println("Elija un número!");
        sc.nextLine();
      }
      sc.close();
    }

    public void Comer()
    {
      System.out.println(this.nombre + " está comiendo " + comida);
      this.solicitoComida = false;
    }
}


//5. Clase habitación
static class Habitacion
{
  private int numero = 0;
  private String tipo = "";
  private boolean ocupado = false;
  private int precioPorNoche = 0;
  private int diasReservados = 0;

  public Habitacion(int numero, String tipo, int precio)
  {
    this.numero = numero;
    this.tipo = tipo;
    this.precioPorNoche = precio;
  }

  public String estaOcupada()
  {
    if(ocupado == false)
    {
      return "Esta habitación está libre";
    }
    else  
    {
      return("Esta habitación está ocupada por " + diasReservados + " días");
    }
  }

  public void setDiasReservados(int num)
  {
     this.diasReservados = num;
  }
}


static class Supervisor extends Persona
{
  private int DNI;
  private String contraseña = "";

  public Supervisor(int DNI, String nombre, String apellido, String fechaNacimiento, String contraseña)
  {
    super(DNI, nombre, apellido, fechaNacimiento);
    this.contraseña = contraseña;
  }

  public void mostrarDatosCliente(List<Cliente> lista, int dni) 
  {
    try
    {
      Cliente cli = getCliente(lista, dni);
      cli.mostrarDatos();

    }catch(Exception e)
    {
      System.out.println("Este cliente no existe");
    }
    
  }
  
  public void verFeedback(List<String> fb, int x)
  {
    try
    {
       System.out.println(fb.get(x));
    }
    catch(Exception e)
    {
      System.out.println("Este mensaje no existe");
    }
  }

  }
}




