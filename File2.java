// Ejemplo 1: El siguiente programa muestra el uso de algunos métodos de la clase File.
// Se crea un objeto File ruta asociado al directorio c:/ficheros y un objeto File f asociado al fichero datos.txt que se encuentra en ese directorio.
// Si el fichero no existe se crea y si el directorio no existe se crea y a continuación se crea el fichero. Si el fichero existe se muestra el tamaño del mismo.
import java.io.File;
import java.io.IOException;

public class File2 {

    public static void main(String[] args) throws IOException {
        File ruta = new File("c:/ficheros");
        File f = new File(ruta, "datos.txt");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());
        System.out.println(ruta.getAbsolutePath());
        System.out.println(ruta.getParent());
        if (!f.exists()) {  //se comprueba si el fichero existe o no
            System.out.println("Fichero " + f.getName() + " no existe");
            if (!ruta.exists()) {  //se comprueba si la ruta existe o no
                System.out.println("El directorio " + ruta.getName() + " no existe");
                if (ruta.mkdir()) { //se crea la ruta. Si se ha creado correctamente
                    System.out.println("Directorio creado");
                    if (f.createNewFile()) {  //se crea el fichero. Si se ha creado correctamente
                        System.out.println("Fichero " + f.getName() + " creado");
                    } else {
                        System.out.println("No se ha podido crear " + f.getName());
                    }
                } else {
                    System.out.println("No se ha podido crear " + ruta.getName());
                }
            } else {  //si la ruta existe creamos el fichero
                if (f.createNewFile()) {
                    System.out.println("Fichero " + f.getName() + " creado");
                } else {
                    System.out.println("No se ha podido crear " + f.getName());
                }
            }
        } else { //el fichero existe. Mostramos el tamaño
            System.out.println("Fichero " + f.getName() + " existe");
            System.out.println("Tamaño " + f.length() + " bytes");
        }
    }
}