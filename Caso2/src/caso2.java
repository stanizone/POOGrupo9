package src;
public class caso2
{
    public static void main(String[] args) 
    {
        System.out.println("=== CASO 2: CLASE ESTUDIANTE CON ATRIBUTOS PRIVADOS ===\n");
        
       
        Estudiante estudiante1 = new Estudiante();
        
    
        estudiante1.setNombre("María");
        estudiante1.setApellido("González");
        estudiante1.setEdad(20);
        estudiante1.setCarrera("Ingeniería de Sistemas");
        estudiante1.setPromedio(15.5);
        estudiante1.setCodigo("2024001");
        
        
        System.out.println("Información obtenida con métodos GET:");
        System.out.println("Nombre: " + estudiante1.getNombre());
        System.out.println("Apellido: " + estudiante1.getApellido());
        System.out.println("Edad: " + estudiante1.getEdad());
        System.out.println("Carrera: " + estudiante1.getCarrera());
        System.out.println("Promedio: " + estudiante1.getPromedio());
        System.out.println("Código: " + estudiante1.getCodigo());
        System.out.println();
        
 
        estudiante1.mostrarInformacion();
        
       
        if (estudiante1.estaAprobado()) {
            System.out.println("El estudiante APROBÓ con promedio: " + estudiante1.getPromedio());
        } else {
            System.out.println("El estudiante DESAPROBÓ con promedio: " + estudiante1.getPromedio());
        }
        
        System.out.println("\n" + "=".repeat(50));
        
        
        Estudiante estudiante2 = new Estudiante("Carlos", "Ramírez", 19, "Administración", 9.5, "2024002");
        
        System.out.println("\nSegundo estudiante:");
        estudiante2.mostrarInformacion();
        
        if (estudiante2.estaAprobado()) {
            System.out.println("El estudiante APROBÓ con promedio: " + estudiante2.getPromedio());
        } else {
            System.out.println("El estudiante DESAPROBÓ con promedio: " + estudiante2.getPromedio());
        }
        
     
        System.out.println("\n--- Modificando datos del estudiante 2 ---");
        estudiante2.setPromedio(13.8); 
        estudiante2.setEdad(20);
        
        System.out.println("Después de la modificación:");
        estudiante2.mostrarInformacion();
        
        if (estudiante2.estaAprobado()) {
            System.out.println("Ahora el estudiante APROBÓ con promedio: " + estudiante2.getPromedio());
        }
    }

   
}


class Estudiante 
{
    
    private String nombre;
    private String apellido;
    private int edad;
    private String carrera;
    private double promedio;
    private String codigo;
    
   
    public Estudiante() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.carrera = "";
        this.promedio = 0.0;
        this.codigo = "";
    }
    
   
    public Estudiante(String nombre, String apellido, int edad, String carrera, double promedio, String codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.carrera = carrera;
        this.promedio = promedio;
        this.codigo = codigo;
    }
    
   
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public String getCarrera() {
        return carrera;
    }
    
    public double getPromedio() {
        return promedio;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        }
    }
    
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    public void setPromedio(double promedio) {
        if (promedio >= 0.0 && promedio <= 20.0) { 
            this.promedio = promedio;
        }
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    public void mostrarInformacion() {
        System.out.println("=== INFORMACIÓN DEL ESTUDIANTE ===");
        System.out.println("Código: " + codigo);
        System.out.println("Nombre completo: " + nombre + " " + apellido);
        System.out.println("Edad: " + edad + " años");
        System.out.println("Carrera: " + carrera);
        System.out.println("Promedio: " + promedio);
        System.out.println("====================================");
    }
    
   
    public boolean estaAprobado() {
        return promedio >= 11.0;
    }
    
}