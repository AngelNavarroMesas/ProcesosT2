package ejercicios.filosofos;

public class Mesa {
    public Boolean[] palillos;

    public int palillo2(int palillo){
        if(palillo+1 == this.palillos.length){
            return 0;
        }else{
            return palillo + 1;
        }
    }

    public synchronized void cogerPalillos(int filosofo){

        while(palillos[filosofo] || palillos[palillo2(filosofo)]){
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        palillos[filosofo] = true;
        palillos[palillo2(filosofo)] = true;
        System.out.println("El "+Thread.currentThread().getName() +" esta comiendo con los palillos: "+filosofo +" y "+ palillo2(filosofo));
    }

    public synchronized void dejarPalillos(int filosofo){
        palillos[filosofo] = false;
        palillos[palillo2(filosofo)] = false;
        System.out.println("El "+Thread.currentThread().getName() +" ha terminado de comer" + ", palillos libres: "+filosofo +" y "+ palillo2(filosofo));
        notifyAll();
    }

}
