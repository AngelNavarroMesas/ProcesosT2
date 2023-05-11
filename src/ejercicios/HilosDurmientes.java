package ejercicios;

public class HilosDurmientes extends Thread{

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Thread hilo = new HilosDurmientes();
            hilo.setName("hilo " + (i+1));
            hilo.start();
        }
    }
    @Override
    public void run(){
        while (true){
            System.out.println("Soy el bucle " + this.getName() + " y estoy trabajando");
            try {
                Thread.sleep((int) (Math.random()*10+1)*1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
