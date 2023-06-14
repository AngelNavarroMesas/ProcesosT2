package ejercicios.filosofos;

public class Mesa {
    private boolean[] tenedores;
    public Mesa(int numTenedores){
        this.tenedores = new boolean[numTenedores];
    }
    public int PalilloIzquierda(int i){
        return i;
    }
    public int PalilloDerecha(int i){
        if(i == 0){
            return this.tenedores.length - 1;
        }else{
            return i - 1;
        }
    }
    public synchronized void cogerPalillos(int comensal){
        while(tenedores[PalilloIzquierda(comensal)] || tenedores[PalilloDerecha(comensal)]){
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        tenedores[PalilloIzquierda(comensal)] = true;
        tenedores[PalilloDerecha(comensal)] = true;
    }
    public synchronized void soltarPalillos(int comensal){
        tenedores[PalilloIzquierda(comensal)] = false;
        tenedores[PalilloDerecha(comensal)] = false;
        this.notifyAll();
    }
}