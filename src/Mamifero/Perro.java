package Mamifero;

import java.util.Date;

public class Perro extends Mamifero{
    private String cola;
    private  String oreja;

    public Perro(String color, String raza, String tamaño, int meses, String sexo, String tipo_pelo, String cola, String oreja) {
        super(color, raza, tamaño, meses, sexo, tipo_pelo);
        this.cola = cola;
        this.oreja = oreja;
    }

    @Override
    public String toString() {
        return "Perro{" +
                "cola='" + cola + '\'' +
                ", oreja='" + oreja + '\'' +
                ", tipo_pelo='" + tipo_pelo + '\'' +
                ", color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", meses=" + meses +
                ", sexo='" + sexo + '\'' +
                '}';
    }

    public String getCola() {
        return cola;
    }

    public void setCola(String cola) {
        this.cola = cola;
    }

    public String getOreja() {
        return oreja;
    }

    public void setOreja(String oreja) {
        this.oreja = oreja;
    }

}
