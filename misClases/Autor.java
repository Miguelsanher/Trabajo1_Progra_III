package misClases;

public class Autor {
    private String nombre;
    private String apellidos;
    private boolean premioPlaneta;


    public Autor(String nombre,String apellidos,boolean premioPlaneta){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.premioPlaneta=premioPlaneta;
    }

    public Autor(){
        
    }
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isPremioPlaneta() {
        return this.premioPlaneta;
    }

    public void setPremioPlaneta(boolean premioPlaneta) {
        this.premioPlaneta = premioPlaneta;
    }
}
