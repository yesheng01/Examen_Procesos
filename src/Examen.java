/**
 * PACKAGE_NAME
 * Nombre_project: Examen_Procesos
 * Examen
 * Created by: sheng
 * Date : 22/11/2021
 * Description:
 **/
public class Examen {
    static int escaladores = 86;

    public static void main(String[] args) throws InterruptedException {
        // shared object
        Examen obj = new Examen();
        // Creating 3 threads

        Thread t1 = new Thread(new Helicoptero(obj, 0, 5), "Helicoptero 1");
        Thread t2 = new Thread(new Helicoptero(obj, 1, 3), "Helicoptero 2");
        Thread t3 = new Thread(new Helicoptero(obj, 2, 1), "Helicoptero 3");

        t1.start();
        t2.start();
        t3.start();
    }
    public static void rest(int cantidad){
        escaladores -= cantidad;
    }
}



