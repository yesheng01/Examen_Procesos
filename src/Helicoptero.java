/**
 * PACKAGE_NAME
 * Nombre_project: Examen_Procesos
 * Helicoptero
 * Created by: sheng
 * Date : 22/11/2021
 * Description:
 **/
public class Helicoptero implements Runnable {
    int cantidades;
    Examen obj;
    int threadNumber;
    static int number = 0;

    Helicoptero(Examen obj, int result, int cantidad) {
        this.obj = obj;
        this.threadNumber = result;
        this.cantidades = cantidad;
    }

    @Override
    public void run() {
        while (0 < Examen.escaladores) {
            synchronized (obj) {
                try {
                    if (number % 3 == threadNumber && 0 < Examen.escaladores) {
                        if (Examen.escaladores >= cantidades) {
                            int numero = (int) (Math.random() * 10) + 10;
                            System.out.println("Sale a rescatar el " + Thread.currentThread().getName());
                            Examen.rest(cantidades);
                            System.out.println("Ha rescatado: " + cantidades + " Aun quedan en la cima : " + Examen.escaladores + " escaladores " + " El tiempo que ha tardado ha sido: " + numero + "seg");
                            Thread.sleep(numero);
                            System.out.println("Ha vuelto a la base");
                            System.out.println("***************************************************************");
                        }
                        number++;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
