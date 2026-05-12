package Reglas;

public class Cuenta {
    protected double saldo;

    public Cuenta() {
        saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean retirar(double valor) {
        if(valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public void consignar(double valor) {
        saldo += valor;
    }
}

