package Reglas;

public class CuentaAhorros extends Cuenta {

    private static final double INTERES_POR_TRANSACCION = 0.01;

    @Override
    public void consignar(double monto) {

        if (monto > 0) {

            saldo += monto;

            aplicarInteres();
        }
    }

    @Override
    public boolean retirar(double monto) {

        if (monto > 0 && saldo >= monto) {

            saldo -= monto;

            aplicarInteres();

            return true;
        }

        return false;
    }

    private void aplicarInteres() {

        saldo += saldo * INTERES_POR_TRANSACCION;
    }
}