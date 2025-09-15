public class Ej1 
{
    public static void main(String[] args)
    {
        Calculadora calcu = new Calculadora();

        System.out.println("Suma de 2 enteros: " + calcu.sumar(5, 3));
        System.out.println("Suma de 3 enteros: " + calcu.sumar(2, 4, 6));
        System.out.println("Suma de 2 decimales: " + calcu.sumar(3.5, 2.7));
    }
}


class Calculadora 
{
    public int sumar(int a, int b) 
    {
        return a + b;
    }

    
    public int sumar(int a, int b, int c) //sobrecarga
    {
        return a + b + c;
    }

    
    public double sumar(double a, double b) // sobrecarga, double es para decimales
    {
        return a + b;
    }
}