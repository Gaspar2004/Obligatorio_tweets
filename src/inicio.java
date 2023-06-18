import User.user;
import funciones.funciones;
import linked_list.Linked_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class inicio {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //funciones.cargarDatosApache();
        funciones c = new funciones();
        c.cargarDatosApache();
        while(true) {


            System.out.println("Ingrese el numero de la opcion que desea realizar");
            System.out.println("1. Listar los 10 pilotos activos en la temporada 2023 en un mes");
            System.out.println("2. Top 15 usuarios con más tweets");
            System.out.println("3. Cantidad de hashtags distintos para un día dado");
            System.out.println("4. Hashtag más usado para un día dado");
            System.out.println("5. Top 7 cuentas con más favoritos");
            System.out.println("6. Cantidad de tweets con una palabra o frase ");
            System.out.println("7. Salir");
            String input = br.readLine();
            long startTime = System.currentTimeMillis();
            switch (input) {
                case "1":
                    //String pilotosABuscar[] = {"Max Verstappen", "Sergio Pérez", "Charles Leclerc"};
                    System.out.println("Ingresar año YYYY");
                    int anio = Integer.parseInt(br.readLine());
                    System.out.println("Ingresar mes MM");
                    int mes = Integer.parseInt(br.readLine());
                    System.out.println("Pilotos mas mencionados: ");
                    String[] pilotos = c.pilotosMasMencionadosPorMes(mes,anio);
                    for (int i = 0; i < 10; i++) {
                        System.out.println(pilotos[i]);
                    }

                    break;
                case "2":
                    Linked_list<user> lista = c.getHeapUsers();
                    System.out.println("Top 15 usuarios con mas tweets: ");
                    for (int i = 0; i < 15; i++) {
                        System.out.println(lista.get(i).getName());
                    }
                    break;
                case "3":
                    System.out.println("Ingrese la fecha en formato YYYY-MM-DD");
                    String fecha = br.readLine();
                    c.imprimirCantHashDistintos(fecha);
                    break;
                case "4":
                    System.out.println("Ingrese la fecha en formato YYYY-MM-DD");
                    String fecha2 = br.readLine();
                    c.hashMasUsadoParaUnDia(fecha2);
                    break;
                case "5":
                    user[] top7 = c.Top7usuariosConMasFavs();
                    System.out.println("Top 7 usuarios con mas favoritos: ");
                    for (int i = 0; i < 7; i++) {
                        System.out.println(top7[i].getName());
                    }
                    break;
                case "6":
                    System.out.println("Ingrese la palabra o frase a buscar");
                    String palabra = br.readLine();
                    c.cantTweetEspecifico(palabra);
                    break;
                case "7":
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            //  }

            long endTime = System.currentTimeMillis() - startTime;
            System.out.println("Tiempo de ejecucion: " + endTime + "ms");
            int dataSize = 1024 * 1024;

            Runtime runtime = Runtime.getRuntime();

            System.out.println("Memoria máxima: " + runtime.maxMemory() / dataSize + "MB");
            System.out.println("Memoria total: " + runtime.totalMemory() / dataSize + "MB");
            System.out.println("Memoria libre: " + runtime.freeMemory() / dataSize + "MB");
            System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");
            System.out.println("------------------------------------------------------------------");
        }
    }
}
