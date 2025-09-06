

class Estudiante {
    
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