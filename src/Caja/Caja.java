package Caja;

public class Caja {
    private double caja;

    public Caja(double caja) {
        this.caja = caja;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }

    public void añadirDinero(double cantidad){
        this.caja += cantidad;
    }

    public void retirarDinero(double cantidad){
        this.caja -= cantidad;
    }

    @Override
    public String toString() {
        return "El saldo en caja actualmente es de " + caja + "€";
    }
}

