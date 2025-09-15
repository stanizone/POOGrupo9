import java.util.Scanner;

public class Ej2 
{
    public static void main(String[] args)
    {
      Scanner sca = new Scanner(System.in);

      try 
      {
        System.out.print("Ingrese el primer número entero: ");
        int a = sca.nextInt(); sca.nextLine();

        System.out.print("Ingrese el segundo número entero: ");
        int b = sca.nextInt(); sca.nextLine();
        
        double resultado = (double) a / b;
        System.out.println("Resultado de la división: " + resultado);
      } 
      catch (ArithmeticException e) 
      {
        System.out.println("Error: división entre cero no permitida.");
      }
    }
}

