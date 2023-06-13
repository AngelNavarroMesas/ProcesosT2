package ejercicios.semaforos;
import java.util.concurrent.Semaphore;

public class SemaforoAvanzado implements Runnable{
    static Semaphore carniceria = new Semaphore(4);
    static Semaphore charcuteria = new Semaphore(2);

    @Override
    public void run() {
        try {
            carniceria.acquire();
            System.out.println("El cliente esta en la carniceria");
            Thread.sleep((long) (Math.random()*10000));
            System.out.println("El cliente ha terminado en la carnicería");
            carniceria.release();
            charcuteria.acquire();
            System.out.println("El cliente esta en la charcuteria");
            Thread.sleep((long) (Math.random()*10000));
            System.out.println("El cliente ha terminado en la charcuteria");
            charcuteria.release();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        SemaforoAvanzado sb = new SemaforoAvanzado();
        for(int i=0; i<5; i++) {
            new Thread(sb).start();
        }
    }
}

