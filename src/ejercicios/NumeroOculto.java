package ejercicios;

import java.util.Scanner;

public class NumeroOculto extends Thread{
    public static int numOculto;
    public static boolean adivinado = false;

    public static void main(String[] args) {
        numOculto = (int) (Math.random()*101);
        for (int i = 0; i < 10; i++) {
            NumeroOculto hilo = new NumeroOculto();
            hilo.setName("hilo " + (i+1));
            hilo.start();
        }
    }
    @Override

    public void run(){
        int num, s = 0;
        Scanner sc = new Scanner(System.in);
        while (s == 0){
            num = (int) (Math.random()*101);
            s = propuestaNumero(num);
            System.out.println("El " + Thread.currentThread().getName() + " propone el número: " + num);
            System.out.println("Solución: " + s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (s == 1)
            System.out.println("El " + this.getName() + " ha adivinado el número oculto: " + numOculto);
    }
    public static int propuestaNumero(int num){
        int sol = 0;
        if (adivinado){
            sol = -1;
        }else if (num == numOculto){
            sol = 1;
            adivinado = true;
        }
        return sol;
    }
}
