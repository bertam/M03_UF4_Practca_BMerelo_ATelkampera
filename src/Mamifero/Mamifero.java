package Mamifero;

import Animal.Animal;

public abstract class Mamifero extends Animal {
    protected String tipo_pelo;

    public Mamifero() {
    }

    public Mamifero(String color, String raza, String tamaño, int meses, String sexo, String tipo_pelo) {
        super(color, raza, tamaño, meses, sexo);
        this.tipo_pelo = tipo_pelo;
    }

    public String getTipo_pelo() {
        return tipo_pelo;
    }

    public void setTipo_pelo(String tipo_pelo) {
        this.tipo_pelo = tipo_pelo;
    }
}