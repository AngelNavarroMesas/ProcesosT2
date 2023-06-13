package ejercicios.estudiantes_y_libros;

import java.util.Random;

public class Libro {
    public static boolean[] libros = new boolean[9];
    int libro1, libro2;
    public Libro() {}

    public Libro(int libro1, int libro2) {
        this.libro1 = libro1;
        this.libro2 = libro2;
    }

    public synchronized void reservaLibros() {
        while (libros[libro1] == true || libros[libro2] == true|| libro1==libro2) {
            while (libros[libro1]==true) {
                libro1 = new Random().nextInt(9);
            }
            while (libros[libro2]==true) {
                libro2 = new Random().nextInt(9);
            }
        }
        System.out.println(Thread.currentThread().getName() + " tiene reservados los libros " + libro1 + " y " + libro2);
        libros[libro1] = true;
        libros[libro2] = true;
    }

    public synchronized void liberaLibros() {
        libros[libro1] = false;
        libros[libro2] = false;
        this.notifyAll();
    }
}
