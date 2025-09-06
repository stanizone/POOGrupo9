package Caso1.src;

/**
 *
 * @author Angel
 */
class Trabajador {
  // Atributos
    private String nombre;
    private String apellido;
    private int edad;
    private double pagoPorDia;
    
    // Constructor completo
    public Trabajador(String nombre, String apellido, int edad, double pagoPorDia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.pagoPorDia = pagoPorDia;
    }
    
    // Constructor simplificado
    public Trabajador(String nombre, String apellido, double pagoPorDia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pagoPorDia = pagoPorDia;
        this.edad = 0;
    }
    
    // Constructor vacío
    public Trabajador() {
        this.nombre = "";
        this.apellido = "";
        this.edad = 0;
        this.pagoPorDia = 0.0;
    }
    
    // Métodos getters y setters
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public double getPagoPorDia() {
        return pagoPorDia;
    }
    
    public void setPagoPorDia(double pagoPorDia) {
        this.pagoPorDia = pagoPorDia;
    }
    
    // Calcular pago por hora automáticamente (8 horas por día)
    public double getPagoPorHora() {
        return pagoPorDia / 8;
    }
    
    public void mostrarInformacion() {
        System.out.println("Trabajador: " + getNombreCompleto());
        System.out.println("Edad: " + edad + " años");
        System.out.println("Pago por día: S/." + String.format("%.2f", pagoPorDia));
        System.out.println("Pago por hora: S/." + String.format("%.2f", getPagoPorHora()));
    }
}