import java.util.Scanner;


public class Ej5 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        try 
        {
            System.out.print("Ingrese un número entero: ");
            String input = sc.nextLine();

            int numero = Integer.parseInt(input);

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
    }
}

class NumeroNegativoException extends Exception 
{
    public NumeroNegativoException(String mensaje) 
    {
        super(mensaje);
    }
}
