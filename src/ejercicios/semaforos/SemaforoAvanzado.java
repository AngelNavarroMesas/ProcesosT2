package ejercicios.semaforos;
import java.util.concurrent.Semaphore;

public class SemaforoAvanzado implements Runnable {
    Semaphore semaforo = new Semaphore(4);
    Semaphore semaforo2 = new Semaphore(2);

    @Override
    public void run() {
        try {
            Boolean carniceria = false;
            if (semaforo.availablePermits() > 0) {
                semaforo.acquire();
                Accion("carnicería");
                semaforo.release();
                carniceria = true;
            } else {
                semaforo2.acquire();
                Accion("charcutería");
                semaforo2.release();
            }
            if (carniceria) {
                semaforo2.acquire();
                Accion("charcutería");
                semaforo2.release();
            } else {
                semaforo.acquire();
                Accion("carnicería");
                semaforo.release();
            }
        } catch (Exception ex) {
            System.out.println();
        }
    }

    private static void Accion(String seccion) {
        System.out.println("El " + Thread.currentThread().getName() + " esta siendo atendio en la " + seccion);
        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        System.out.println("El " + Thread.currentThread().getName() + " a terminado en la " + seccion);
    }

    public static void main(String[] args) {
        SemaforoAvanzado sb = new SemaforoAvanzado();
        for (int i = 0; i < 10; i++) {
            Thread hilo = new Thread(sb);
            hilo.setName("cliente " + i);
            hilo.start();
        }
    }
}