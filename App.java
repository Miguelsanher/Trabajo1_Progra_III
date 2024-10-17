import java.util.Scanner;
import misClases.*;
public class App {
    public static void main(String [] args){
        int salir=0;
        Scanner sc = new Scanner(System.in);
        int tamAlmacen=2;
        int pagMinuto=1;
        int minTotales=0;
        float precioTotal=0;

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
        Almacen alm = new Almacen(tamAlmacen); //le pongo dos libros por defecto
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
                if(!(alm.getNum_libros_almacenados()>=alm.getTam())){
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
                }else{
                    System.out.println("Esta lleno el almacen");
                }

            }else if(opcion==4){
                //momento hacer el display
                System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.println("| LIBROS EN EL ALMACÉN                                                                                                                                |");
                System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.printf("| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-10s|\n", 
                "Titulo","Año publicacion","Autor","Premio planeta","Paginas","Tiempo lectura","Precio");
                System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
                
                /*Libro [] libros = alm.getLibros();
                for(Libro libro2 : libros){
                    autor= libro2.getAutor(); //cojemos la info del autor para tenerlo todo
                    System.out.printf("| %-20s   %-20d   %-20s   %-20b   %-20d   %-20d   %-10.3f\n", libro2.getTitulo(),libro2.getAnoPublicacion(),autor.getNombre(),autor.isPremioPlaneta(),libro2.getNum_pag()
                    ,(libro2.getNum_pag()*pagMinuto),libro2.getPrecio());
                }*/ //esto estaria bien si lo hicieramos en una coleccion pero si no no, ya que se nos puede colar algun elemento nulo
                
                Libro [] libros= alm.getLibros();
                minTotales=0;
                precioTotal=0;
                for(int i=0;i<alm.getNum_libros_almacenados();i++){
                    Libro libro2 = libros[i];
                    autor= libro2.getAutor();
                    System.out.printf("| %-20s | %-20d | %-20s | %-20b | %-20d | %-20d | %-9.3f%s|\n", libro2.getTitulo(),libro2.getAnoPublicacion(),autor.getNombre(),autor.isPremioPlaneta(),libro2.getNum_pag()
                    ,(libro2.getNum_pag()*pagMinuto),libro2.getPrecio(),"$");
                    minTotales+=libro2.getNum_pag()*pagMinuto;
                    precioTotal+=libro2.getPrecio();
                }
                System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
                System.out.printf("| Tiempo de lectura total del almacén: %-10d min                                                                                                 |\n",minTotales );
                System.out.printf("| Valor total del almacén: %-9.3f$                                                                                                                 |\n", precioTotal);
                System.out.println("|-----------------------------------------------------------------------------------------------------------------------------------------------------|");
            }else if(opcion==5){
                salir=1;
            }else{
                System.out.println("Teclea un numero válido");
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
