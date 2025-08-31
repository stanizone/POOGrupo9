package caso3;

public class CuentaBancaria {
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito realizado. Su saldo actual es: S/ " + saldo);
        } else {
            System.out.println("El monto a depositar debe ser mayor a S/ 0.");
        }
    }

    public void retirar(double monto) {
        if (monto > 0) {
            if (monto <= saldo) {
                saldo -= monto;
                System.out.println("Su retiro fue exitoso. Su saldo actual es: S/ " + saldo);
            } else {
                System.out.println("No cuenta con saldo suficiente para realizar el retiro solicitado.");
            }
        } else {
            System.out.println("El monto a retirar debe ser mayor a S/ 0.");
        }
    }

    public double getSaldo() {
        return saldo;
    }
}