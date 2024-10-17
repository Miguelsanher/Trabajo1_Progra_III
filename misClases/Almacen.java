package misClases;

import java.util.ArrayList;

public class Almacen{
    private Libro[] libros; // declaracion pero no iniciacion
    private int tam;
    private int num_libros_almacenados;



    public Almacen(int tam){
        this.tam=tam;
        this.libros=new Libro[tam]; //inicializar
        this.num_libros_almacenados=0;
    }

    public Libro[] getLibros() {
        return this.libros;
    }

    public void setLibros(Libro[] libros) {
        this.libros = libros;
    }

    public int getTam() {
        return this.tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getNum_libros_almacenados() {
        return this.num_libros_almacenados;
    }

    public void setNum_libros_almacenados(int num_libros_almacenados) {
        this.num_libros_almacenados = num_libros_almacenados;
    }

    public int introducirLibro(Libro libro){
        if(num_libros_almacenados>=tam){
            System.out.println("No hay hueco para otro libro mas");
            return -1;
        }else{
            libros[num_libros_almacenados]=libro;
            System.out.println("Libro introducido de forma exitosa");
            num_libros_almacenados++;
            return 0;
        }
    }
}