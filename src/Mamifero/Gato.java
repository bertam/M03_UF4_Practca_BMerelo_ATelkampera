package Mamifero;

public class Gato extends Mamifero{

    public Gato() {
    }

    public Gato(String color, String raza, String tamaño, int meses, String sexo, String tipo_pelo) {
        super(color, raza, tamaño, meses, sexo, tipo_pelo);
    }

    @Override
    public String toString() {
        return "Gato{" +
                "tipo_pelo='" + tipo_pelo + '\'' +
                ", color='" + color + '\'' +
                ", raza='" + raza + '\'' +
                ", tamaño='" + tamaño + '\'' +
                ", meses=" + meses +
                ", sexo='" + sexo + '\'' +
                '}';
    }
}
