package ejercicios.estudiantes_y_libros;

public class Libro {
    public boolean enPosesion = false;
    private String name;

    public Libro(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public boolean isEnPosesion() {
        return enPosesion;
    }

    public void setEnPosesion(boolean enPosesion) {
        this.enPosesion = enPosesion;
    }
}