import java.util.ArrayList;

public class Ej4
{
    public static void main(String[] args) 
    {
        Inventario inv = new Inventario();

        inv.agregarProducto("Laptop");
        inv.agregarProducto("Mouse", 50);
        inv.agregarProducto("Teclado", 100, 5);
        inv.agregarProducto("Monitor", -300, 2); //Esto debe dar error pq el precio está en negativo (esto no se va a agregar)

        System.out.println("\nInventario:");
        inv.mostrarInventario();
    }
}

//acá abajo dejo la clase producto y la clase Inventario.

class Producto 
{
    String nombre = "";
    double precio = 0;
    int cantidad = 0;

    public Producto(String nombre) 
    {
        this.nombre = nombre;
    }

    public Producto(String nombre, double precio) //sobrecarga
    {
        this.nombre = nombre;
        this.precio = precio;
    }

    public Producto(String nombre, double precio, int cantidad) //sobrecarga
    {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }
}



// Clase Inventario
class Inventario 
{
    ArrayList<Producto> productos = new ArrayList<>(); // cada instancia de inventario va a tener su propia lista de productos.

    public void agregarProducto(String nombre) 
    {
        productos.add(new Producto(nombre));
    }

    public void agregarProducto(String nombre, double precio) 
    {
        if (precio < 0) 
        {
            System.out.println("El precio no puede ser negativo");
            return;
        }
        productos.add(new Producto(nombre, precio));
    }

    public void agregarProducto(String nombre, double precio, int cantidad) 
    {
        if (precio < 0 || cantidad < 0) 
        {
            System.out.println("El precio o la cantidad no pueden ser negativos");
            return;
        }
        productos.add(new Producto(nombre, precio, cantidad));
    }

    public void mostrarInventario() 
    {
        for (Producto p : productos) 
        {
            System.out.println("");
            System.out.println("Nombre del producto: " + p.nombre + "\nCantidad: " + p.cantidad + "\nPrecio: " + p.precio);
        }
    }
}