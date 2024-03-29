package ejercicios.semaforos;

import java.util.concurrent.Semaphore;

public class Semaforo implements Runnable{
    static Semaphore carniceria = new Semaphore(4);
    @Override
    public void run() {
        try {
            carniceria.acquire();
            System.out.println("El cliente esta en la carniceria");
            Thread.sleep((long) (Math.random()*10000));
            System.out.println("El cliente ha terminado en la carnicería");
            carniceria.release();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Semaforo sb = new Semaforo();
        for(int i=0; i<10; i++) {
            new Thread(sb).start();
        }
    }
}