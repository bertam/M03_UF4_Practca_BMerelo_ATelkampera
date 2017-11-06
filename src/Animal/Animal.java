package Animal;

import java.io.Serializable;

public abstract class Animal implements Serializable {
    protected String color;
    protected String raza;
    protected String tamaño;
    protected int meses;
    protected String sexo;
    protected final double SEGURO_BASE_COMPRA = 123.85;
    protected final int TASA_MACHO = 800;
    protected  final int TASA_HEMBRA = 1000;
    protected final int TASA_TAMANO_GRANDE = 500;
    protected final int TASA_TAMANO_PEQUENO = 300;

    public Animal() {
    }

    public Animal(String color, String raza, String tamaño, int meses, String sexo) {
        this.color = color;
        this.raza = raza;
        this.tamaño = tamaño;
        this.meses = meses;
        this.sexo = sexo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double precioBase(){
        double total = 0;
        if (this.sexo.toUpperCase().equals("MACHO") && this.tamaño.toUpperCase().equals("GRANDE")){
            total = SEGURO_BASE_COMPRA + TASA_MACHO + TASA_TAMANO_GRANDE;
        }
        if (this.sexo.toUpperCase().equals("MACHO") && this.tamaño.toUpperCase().equals("PEQUEÑO")){
            total = SEGURO_BASE_COMPRA + TASA_MACHO + TASA_TAMANO_PEQUENO;
        }
        if (this.sexo.toUpperCase().equals("HEMBRA") && this.tamaño.toUpperCase().equals("GRANDE")){
            total = SEGURO_BASE_COMPRA + TASA_HEMBRA + TASA_TAMANO_GRANDE;
        }
        if (this.sexo.toUpperCase().equals("HEMBRA") && this.tamaño.toUpperCase().equals("PEQUEÑO")){
            total = SEGURO_BASE_COMPRA + TASA_HEMBRA + TASA_TAMANO_PEQUENO;
        }
        return total;
    }
}
