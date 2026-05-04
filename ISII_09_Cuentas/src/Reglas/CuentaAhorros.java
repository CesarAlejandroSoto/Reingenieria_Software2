package Reglas;
public class CuentaAhorros extends CuentaCorriente {
    private double tasaIntereses = 2;
    public double getbalance(double intereses){
        return balance = balance +(balance* tasaIntereses/100)/12;
    }
}