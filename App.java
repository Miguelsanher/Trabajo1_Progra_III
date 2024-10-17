import java.util.Scanner;
import misClases.*;
public class App {
    public static void main(String [] args){
        int salir=0;
        Scanner sc = new Scanner(System.in);
        int tamAlmacen;
        int pagMinuto=1;

        //cosas del autor
        String nombreAutor;
        String apellidos;
        boolean premioPlaneta;

        //cosas del libro
        String titulo;
        int anoPublicacion;
        int num_pag;
        float precio;

        //recipientes
        Almacen alm = new Almacen(2); //le pongo dos libros por defecto
        Libro libro= new Libro(); //ponemos un objeto libro que usaremos luego para referenciar
        Autor autor= new Autor(); // usaremo esto tambien como recipiente

        do{
            mostrarMenu();
            int opcion= sc.nextInt();
            sc.nextLine();

            if(opcion==1){
                System.out.printf("\nIntroduce el tamaño del almacen: ");
                tamAlmacen= sc.nextInt();
                sc.nextLine();
                alm = new Almacen(tamAlmacen); //perdemos la referencia del anterior almacen
            }else if(opcion==2){
                System.out.printf("\nIntroduzca las paginas por minuto: ");
                pagMinuto= sc.nextInt();
            }else if(opcion==3){
                //primero hacemos al autor
                System.out.printf("\nIntroduce el nomnbre del autor: ");
                nombreAutor=sc.nextLine();
                System.out.printf("\nIntroduce el apellido del autor: ");
                apellidos=sc.nextLine();
                System.out.printf("\nTiene premio planeta (true/false)? " );
                premioPlaneta=sc.nextBoolean();
                //creamos el autor
                autor=new Autor(nombreAutor, apellidos, premioPlaneta);

                //ahora hacemos el libro
                System.out.printf("\nIntroduce el titulo del libro: ");
                sc.nextLine(); //barrido de buffer
                titulo=sc.nextLine();
                System.out.printf("\nIntroduce el año de publicacion del libro: ");
                anoPublicacion=sc.nextInt();
                System.out.printf("\nIntroduce el numero de paginas del libro: ");
                num_pag=sc.nextInt();
                System.out.printf("\nIntroduce el precio del libro: ");
                precio=sc.nextFloat();
                //creamos el libro
                libro= new Libro(autor, titulo, anoPublicacion, num_pag, precio);

                //ahora lo metemos en el almacen que se guardara su referencia
                alm.introducirLibro(libro);

            }else if(opcion==4){

            }else if(opcion==5){
                salir=1;
            }

        }while(salir==0);
    }


    public static void mostrarMenu(){
        System.out.println("|----------------------------------------------|");
        System.out.println("|           MIS LIBROS                         |");
        System.out.println("|----------------------------------------------|");
        System.out.println("   1) Nuevo almacén de libros                   ");
        System.out.println("   2) Establecer ritmo de lectura (páginas por minuto)");
        System.out.println("   3) Añadir un nuevo libro al almacén");
        System.out.println("   4) Mostrar información actual de libros");
        System.out.println("   5) Salir (se borrará toda la información)");
        System.out.println("|----------------------------------------------|\n");
        System.out.printf("=> ");
    }

}
