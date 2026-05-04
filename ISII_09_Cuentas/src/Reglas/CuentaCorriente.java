package Reglas;
public class CuentaCorriente {
    public static double balance = 0;
    public void setCuenta(double saldo) {
        balance = saldo;
    }
    public static void depositar(double consignacion) {
        balance = balance + consignacion;
    }
    public static void retirar(double retiro) {
        if (balance != 0) {
            balance = balance - retiro;
        }
    }
    public static double getbalance() {
        return balance;
    }
}