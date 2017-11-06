import Caja.Caja;
import Mamifero.Gato;
import Mamifero.Perro;
import Animal.Animal;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        /*Código usado paracrear el archivo Animal.dat

        Animal a1 = new Perro("Rojo", "Shiba","Grande", 6, "Corto","Hembra", "Larga", "Arriba");
        Animal a2 = new Perro("Fuego y negro", "Shiba","Grande", 4, "Corto","Macho", "Larga", "Arriba");
        Animal a3 = new Perro("Negro y dorado", "Yorkshire","Pequeño", 3, "Corto","Hembra", "Corta", "Arriba");
        Animal a4 = new Gato("Negro", "Europeo común","Grande", 14,"Corto", "Macho");
        Animal a5 = new Gato("Naranja", "Persa","Pequeño", 2,"Largo", "Macho");
        Animal a6 = new Gato("Negro", "Siamés","Pequeño", 5,"Corto", "Hembra");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Animales.dat"));

        oos.writeObject(a1);
        oos.writeObject(a2);
        oos.writeObject(a3);
        oos.writeObject(a4);
        oos.writeObject(a5);
        oos.writeObject(a6);
        oos.close();*/

        String str;
        int option;
        boolean exit = false;
        boolean datosCargados = false;
        ArrayList<Animal> animal_List = new ArrayList<Animal>();
        Animal auxAnimal;
        final int PRECIO_MAYORISTA_PERRO = 700;
        final int PRECIO_MAYORISTA_GATO = 500;
        Caja caja_Actual = new Caja(5000);

        do {
            System.out.println("MENÚ");
            System.out.println("1. Cargar datos");
            System.out.println("2. Comprar animal");
            System.out.println("3. Vender animal");
            System.out.println("4. Comprobar saldo caja");
            System.out.println("5. Ver stock");
            System.out.println("6. Salir del programa");

            System.out.println("Elige una opción");
            option = askNumber();

            switch (option){
                case 1:
                    //si ya se han cargado los datos no queremos que se vuelvan a cargar
                    if (datosCargados == false){
                        cargarDatosIniciales(animal_List);
                        datosCargados = true;
                    }else{
                        System.out.println("Los datos ya han sido cargados.");
                    }
                    break;
                case 2:
                    System.out.println("Qué animal quieres comprar?");
                    System.out.println("1. Perro");
                    System.out.println("2. Gato");
                    option = askNumber();

                    switch (option){
                        case 1:
                            System.out.println("Introduce los atributos del perro separados por comas sin espacios como en el ejemplo de abajo:");
                            System.out.println("color,raza,tamaño,meses,sexo,tipo pelo,cola,oreja");
                            str = br.readLine();

                            String atribute[] = str.split(",");
                            auxAnimal = new Perro(atribute[0],atribute[1],atribute[2],Integer.parseInt(atribute[3]),atribute[4],atribute[5],atribute[6],atribute[7]);
                            animal_List.add(auxAnimal);

                            //Comprobamos que se ha comprado el perro y si se ha comprado(añadido a la arraylist correctamente) se paga
                            if (animal_List.contains(auxAnimal)){
                                caja_Actual.retirarDinero(PRECIO_MAYORISTA_PERRO);
                            }else{
                                System.out.println("No se ha comprado ningún perro");
                            }
                            break;
                        case 2:
                            System.out.println("Introduce los atributos del gato separados por comas sin espacios como en el ejemplo de abajo:");
                            System.out.println("color,raza,tamaño,meses,sexo,tipo de pelo");
                            str = br.readLine();

                            String atributo[] = str.split(",");
                            auxAnimal = new Gato(atributo[0],atributo[1],atributo[2],Integer.parseInt(atributo[3]),atributo[4],atributo[5]);
                            animal_List.add(auxAnimal);


                            if (animal_List.contains(auxAnimal)){
                                caja_Actual.retirarDinero(PRECIO_MAYORISTA_GATO);
                            }else{
                                System.out.println("No se ha comprado ningún gato");
                            }
                            break;
                        default:
                            System.out.println("Introduce una opción válida");
                            break;
                    }
                    break;
                case 3:
                    boolean animalEncontrado = false;
                    String edad;
                    System.out.println("Qué raza ha comprado el cliente?");
                    str = br.readLine();
                    System.out.println("Qué edad tiene el animal?");
                    edad = br.readLine();
                    option = Integer.parseInt(edad);

                    //si el animal comprado concuerda con las especificaciones dadas se añade dinero a la caja
                    for (int i = 0; i < animal_List.size() ; i++) {
                        auxAnimal = animal_List.get(i);
                    if (auxAnimal.getRaza().toUpperCase().equals(str.toUpperCase())){
                            if (auxAnimal.getMeses() == option){
                                animal_List.remove(auxAnimal);
                                System.out.println("Se ha vendido el animal correctamente");
                                caja_Actual.añadirDinero(auxAnimal.precioBase());
                                animalEncontrado = true;
                                break;
                            }
                        }
                    }
                    if (animalEncontrado == false){
                        System.out.println("No se ha encontrado ningún animal con esas especificaciones");
                    }
                    break;
                case 4:
                    System.out.println(caja_Actual.toString());
                    break;
                case 5:
                    System.out.println("Qué tipo de animal quieres ver?");
                    System.out.println("1.Perro");
                    System.out.println("2.Gato");
                    option = askNumber();

                    switch (option){
                        case 1:
                            for (int i = 0; i < animal_List.size(); i++) {
                                auxAnimal = animal_List.get(i);
                                if (auxAnimal instanceof Perro){
                                    System.out.println(auxAnimal.toString());
                                }
                            }
                            break;
                        case 2:
                            for (int i = 0; i < animal_List.size(); i++) {
                                auxAnimal = animal_List.get(i);
                                if (auxAnimal instanceof Gato){
                                    System.out.println(auxAnimal.toString());
                                }
                            }
                            break;
                        default:
                            System.out.println("Introduzca una opción válida");
                            break;
                    }

                    break;
                case 6:
                    System.out.println("Saliendo del programa");
                    exit = true;
                    break;
                default:
                    System.out.println("Introduce un número válido");
                    break;
            }

        }while (!exit);
    }
    public static void cargarDatosIniciales(ArrayList<Animal> animal_List ) throws IOException {
        //creamos este metodo para cargar los datos iniciales en la arraylist
        //pide por parametros la arraylist donde se almacenaran los animales
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animales.dat"));

        try{
            Animal auxAnimal;
            while (true){
                auxAnimal = (Animal) ois.readObject();
                animal_List.add(auxAnimal);
            }
        }catch (EOFException e){
            ois.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int askNumber() throws IOException {
        //pide un numero al usuario y comprueba que lo que introduce es un numero, si no lo es se vuelve a pedir un numero hasta que lo sea
        String str;
        while(true){
            str = br.readLine();
            if (str.matches("[0-9]*")){
                return Integer.parseInt(str);
            }else{
                System.out.println("Introduce solamente números.");
            }
        }
    }
}
