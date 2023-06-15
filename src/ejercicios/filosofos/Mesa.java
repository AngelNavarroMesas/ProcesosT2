package ejercicios.filosofos;

public class Mesa {
    private boolean[] palillos;
    public Mesa(int numTenedores){
        this.palillos = new boolean[numTenedores];
    }
    public int PalilloIzquierda(int i){
        return i;
    }
    public int PalilloDerecha(int i){
        if(i == 0){
            return this.palillos.length - 1;
        }else{
            return i - 1;
        }
    }
    public synchronized void cogerPalillos(int comensal){
        while(palillos[PalilloIzquierda(comensal)] || palillos[PalilloDerecha(comensal)]){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        palillos[PalilloIzquierda(comensal)] = true;
        palillos[PalilloDerecha(comensal)] = true;
    }
    public synchronized void soltarPalillos(int comensal){
        palillos[PalilloIzquierda(comensal)] = false;
        palillos[PalilloDerecha(comensal)] = false;
        this.notifyAll();
    }
}