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
            int numero = sc.nextInt(); sc.nextLine();

            if (numero < 0) 
            {
                throw new NumeroNegativoException("Se ha ingresado un número negativo");
            }

            System.out.println("Número ingresado correctamente");

        } 
        catch (NumberFormatException e) 
        {
            System.out.println("Ingresa un número válido.");
        } 
        catch (NumeroNegativoException e) 
        {
            System.out.println(e.getMessage());
        }
        catch (InputMismatchException e)
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

