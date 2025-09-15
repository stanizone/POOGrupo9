import java.util.ArrayList;

public class Ej3 
{
    public static void main(String[] args) 
    {
        ArrayList<String> estudiantes = new ArrayList<>();

        
        estudiantes.add("Stefanno");
        estudiantes.add("Angel");
        estudiantes.add("Miguel");
        estudiantes.add("Will");
        estudiantes.add("Franco"); //agregamos los 5 estudiantes
        

        System.out.println("Lista completa de estudiantes: " + estudiantes);

        estudiantes.remove(2);
        System.out.println("");

        System.out.println("Lista después de eliminar el tercer estudiante:");
        for (String nombre : estudiantes) //hacemos un forEach
        {
            System.out.println(nombre);
        }
    }
}