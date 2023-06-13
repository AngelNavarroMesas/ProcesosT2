package ejercicios.estudiantes_y_libros;

import java.util.Random;

public class Estudiante implements Runnable {
    public static void main(String[] args) {
        Estudiante e = new Estudiante();
        for (int i = 1; i <= 4; i++) {
            Thread hilo = new Thread(e);
            hilo.setName("Estudiante " + i);
            hilo.start();
        }
    }

    @Override
    public void run() {
        try {
            int libro1, libro2;
            while (true) {
                libro1 = new Random().nextInt(9);
                libro2 = new Random().nextInt(9);
                while (libro2 == libro1) {
                    libro2 = new Random().nextInt(9);
                }
                Libro libro = new Libro(libro1, libro2);
                libro.reservaLibros();
                Thread.sleep((long) (Math.random() * 5000 + 3000));
                libro.liberaLibros();
                System.out.println(Thread.currentThread().getName() + " ha terminado de leer");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}