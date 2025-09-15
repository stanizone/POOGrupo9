import java.util.Scanner;

public class Ej2 
{
    public static void main(String[] args)
    {
      Scanner sca = new Scanner(System.in);

      try 
      {
        System.out.print("Ingrese el primer número entero: "); //Ingresamos el primer parametro
        int a = sca.nextInt(); sca.nextLine();

        System.out.print("Ingrese el segundo número entero: "); //Ingresamos el segundo parámetro
        int b = sca.nextInt(); sca.nextLine();
        
        double resultado = (double) a / b; //dividimos los 2 numeros
        System.out.println("Resultado de la división: " + resultado); //nos muestra el resultado.
      } 
      catch (ArithmeticException e) 
      {
        System.out.println("Error: división entre cero no permitida."); //error si se da una división con 0
      }
    }
}

