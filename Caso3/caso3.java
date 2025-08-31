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