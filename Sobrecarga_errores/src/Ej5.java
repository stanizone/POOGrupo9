import java.util.Scanner;
import java.util.InputMismatchException;

public class Ej5 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        try 
        {
            System.out.print("Ingrese un número entero: ");
            int numero = sc.nextInt(); sc.nextLine();  //el programa registra el numero

            if (numero < 0) 
            {
                throw new NumeroNegativoException("Se ha ingresado un número negativo"); //si el numero es menor a 0, nos da este error.
            }

            System.out.println("Número ingresado correctamente"); //sino, nos lo permite

        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Ingresa un número válido."); //otros tipo de errores:
        } 
        catch (NumeroNegativoException e) 
        {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e) //por ejemplo, este es para cuando ingresas algo que no es un número cuando pedimos uno.
        {
          System.out.println("Ingresa un número válido");
        }
    }
}

class NumeroNegativoException extends Exception 
{
    public NumeroNegativoException(String mensaje) 
    {
        super(mensaje); //llamamos al método de Exception y le enviamos el mensaje
    }
}

