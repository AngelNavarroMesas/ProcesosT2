package ejercicios.estudiantes_y_libros;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estudiante implements Runnable{
    public static List<Libro> listaLibros=new ArrayList<>();
    public boolean terminado;

    @Override
    public void run() {
        try {
            Libro libro1=listaLibros.get((int)(Math.random()*9));
            Libro libro2=listaLibros.get((int)(Math.random()*9));
            synchronized (libro1) {
                while (!terminado && libro1.isEnPosesion()) {
                    libro1.wait();
                }
                libro1.setEnPosesion(true);
                System.out.println(Thread.currentThread().getName()+" esta usando el "+libro1.getName());
                Thread.sleep(((long) Math.random()*2000)+3000);
                System.out.println(Thread.currentThread().getName()+" ha terminado de usar el"+libro1.getName());
                terminado = true;
                libro1.setEnPosesion(false);
                libro1.notifyAll();
            }
            synchronized (libro2) {
                while (!terminado && libro2.isEnPosesion()) {
                    libro1.wait();
                }
                libro2.setEnPosesion(true);
                System.out.println(Thread.currentThread().getName()+" esta usando el "+libro2.getName());
                Thread.sleep(((long) Math.random()*2000)+3000);
                System.out.println(Thread.currentThread().getName()+" ha terminado de usar el "+libro2.getName());
                terminado = true;
                libro2.setEnPosesion(false);
                libro2.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i<9; i++){
            listaLibros.add(new Libro("Libro "+i));
        }
        for (int i = 0; i < 4; i++) {
            Estudiante ewn = new Estudiante();
            Thread hilo = new Thread(ewn);
            hilo.setName("Estudiante "+i);
            hilo.start();
        }
    }
}