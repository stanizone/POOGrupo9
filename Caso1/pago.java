package caso1;

/**
 *
 * @author Angel
 */
class Pago {
 private Trabajador trabajador;
    private int diasTrabajados;
    private int horasExtras;
    private double sueldoBase;
    private double pagoHorasExtras;
    private double sueldoBruto;
    private double descuentoSeguro;
    private double sueldoNeto;
    
    // Constructor
    public Pago(Trabajador trabajador, int diasTrabajados, int horasExtras) {
        this.trabajador = trabajador;
        this.diasTrabajados = diasTrabajados;
        this.horasExtras = horasExtras;
    }
    
    // Método para calcular el sueldo completo
    public void calcularSueldo() {
        // Calcular sueldo base
        sueldoBase = diasTrabajados * trabajador.getPagoPorDia();
        
        // Calcular pago de horas extras (1.5 veces el pago normal por hora)
        pagoHorasExtras = horasExtras * trabajador.getPagoPorHora() * 1.5;
        
        // Calcular sueldo bruto
        sueldoBruto = sueldoBase + pagoHorasExtras;
        
        // Calcular descuento de seguro (10%)
        descuentoSeguro = sueldoBruto * 0.10;
        
        // Calcular sueldo neto
        sueldoNeto = sueldoBruto - descuentoSeguro;
    }
    
    // Método para mostrar detalles del pago
    public void mostrarDetallesPago() {
        System.out.println("\n--- INFORMACIÓN DEL TRABAJADOR ---");
        trabajador.mostrarInformacion();
        
        System.out.println("\n--- DETALLES DEL PAGO ---");
        System.out.println("Días trabajados: " + diasTrabajados + " días");
        System.out.println("Horas extras: " + horasExtras + " horas");
        System.out.println("Sueldo base: S/." + String.format("%.2f", sueldoBase));
        System.out.println("Pago horas extras: S/." + String.format("%.2f", pagoHorasExtras));
        System.out.println("Sueldo bruto: S/." + String.format("%.2f", sueldoBruto));
        System.out.println("Descuento seguro (10%): S/." + String.format("%.2f", descuentoSeguro));
        System.out.println("SUELDO NETO: S/." + String.format("%.2f", sueldoNeto));
        
        System.out.println("\n--- DESGLOSE DETALLADO ---");
        System.out.println("• Días normales: " + diasTrabajados + " días x S/." + 
                          String.format("%.2f", trabajador.getPagoPorDia()) + " = S/." + 
                          String.format("%.2f", sueldoBase));
        System.out.println("• Horas extras: " + horasExtras + " horas x S/." + 
                          String.format("%.2f", trabajador.getPagoPorHora() * 1.5) + " = S/." + 
                          String.format("%.2f", pagoHorasExtras));
        System.out.println("• Total bruto: S/." + String.format("%.2f", sueldoBruto));
        System.out.println("• Descuento seguro: -S/." + String.format("%.2f", descuentoSeguro));
        System.out.println("• NETO A PAGAR: S/." + String.format("%.2f", sueldoNeto));
    }
    
    // Getters
    public double getSueldoNeto() {
        return sueldoNeto;
    }
    
    public double getSueldoBruto() {
        return sueldoBruto;
    }
    
    public double getDescuentoSeguro() {
        return descuentoSeguro;
    }
    
    public int getDiasTrabajados() {
        return diasTrabajados;
    }
    
    public int getHorasExtras() {
        return horasExtras;
    }
}

