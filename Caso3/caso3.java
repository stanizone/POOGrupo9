package caso3;

import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("BIENVENIDO A SU CUENTA BANCARIA");
        System.out.print("Ingrese su nombre: ");
        String nombreCliente = sc.nextLine();

        double saldoInicial = -1;
        while (saldoInicial < 0) {
            System.out.print("Ingrese su saldo inicial: ");
            if (sc.hasNextDouble()) {
                saldoInicial = sc.nextDouble();
                if (saldoInicial < 0) {
                    System.out.println("Por favor ingrese un saldo inicial válido.");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                sc.next(); // limpia el buffer
            }
        }
        CuentaBancaria cuenta = new CuentaBancaria(saldoInicial);

        String continuar;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. CONSULTA DE SALDO");
            System.out.println("2. REALIZAR UN DEPÓSITO");
            System.out.println("3. RETIRO DE DINERO");
            System.out.print("\nSELECCIONE UNA OPCIÓN DEL MENÚ: ");

            String opcion = sc.next();

            switch (opcion) {
                case "1":
                    System.out.println("Su saldo actual es de: S/ " + cuenta.getSaldo());
                    break;
                case "2":
                    System.out.print("Ingrese el monto a depositar: ");
                    if (sc.hasNextDouble()) {
                        double deposito = sc.nextDouble();
                        cuenta.depositar(deposito);
                    } else {
                        System.out.println("El monto ingresado no es válido.");
                        sc.next();
                    }
                    break;
                case "3":
                    System.out.print("Ingrese el monto a retirar: ");
                    if (sc.hasNextDouble()) {
                        double retiro = sc.nextDouble();
                        cuenta.retirar(retiro);
                    } else {
                        System.out.println("El monto ingresado no es válido.");
                        sc.next();
                    }
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }

            do {
                System.out.print("\n¿DESEA REALIZAR OTRA OPERACIÓN? (s/n): ");
                continuar = sc.next().toLowerCase();

                if (!continuar.equals("s") && !continuar.equals("n")) {
                    System.out.println("¡ERROR!, por favor escriba 's' para sí o 'n' para no.");
                }
            } while (!continuar.equals("s") && !continuar.equals("n"));

        } while (continuar.equals("s"));

        System.out.println("\nGracias por usar nuestro sistema bancario, " + nombreCliente + ".");
    }
}