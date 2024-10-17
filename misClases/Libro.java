package misClases;

public class Libro {
    private Autor autor;
    private String titulo;
    private int anoPublicacion;
    private int num_pag;
    private float precio;



    public Libro(Autor autor,String titulo,int anoPublicacion,int num_pag,float precio ){
        this.autor=autor;
        this.titulo=titulo;
        this.anoPublicacion=anoPublicacion;
        this.num_pag=num_pag;
        this.num_pag=num_pag;
        this.precio=precio;
    }

    public Libro(){
        
    }



    public Autor getAutor() {
        return this.autor;
    }


    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoPublicacion() {
        return this.anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public int getNum_pag() {
        return this.num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public float getPrecio() {
        return this.precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setAutor(Autor autor){
        this.autor=autor;
    }
}
