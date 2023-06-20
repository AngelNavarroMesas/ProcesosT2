package ejercicios.filosofos;

public class Filosofo extends Thread {
    private Mesa mesa;
    private int numFilosofo;

    public Filosofo(Mesa mesa, int numFilosofo){
        this.mesa = mesa;
        this.numFilosofo = numFilosofo;
    }

    public synchronized void run(){
        while(true){
            System.out.println("El "+Thread.currentThread().getName() +" está pensando");
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println(e);
            }
            this.mesa.cogerPalillos(this.numFilosofo);
            try{
                Thread.sleep(3000);
            }catch (Exception e){
                System.out.println(e);
            }
            this.mesa.dejarPalillos(this.numFilosofo);
        }
    }

    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        mesa.palillos = new Boolean[]{false, false, false, false, false};
        for (int i = 0; i < 5; i++) {
            Filosofo f = new Filosofo(mesa, i);
            Thread h = new Thread(f);
            h.setName("filosofo "+i);
            h.start();
        }
    }
}