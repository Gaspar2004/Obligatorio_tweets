package funciones;

import BST.BST;
import Hash.hash;
import HashTag.hashtag;
import Heap.heap;
import Tweet.tweet;
import User.user;
import linked_list.Linked_list;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class funciones {
    public static heap<user> heapUsers = new heap<user>();

    public static Linked_list<user> getHeapUsers() {
        return heapUsers.toList();
    }
    public static hash<String,user> users = new hash<String,user>(65000);
    public static BST<String,hashtag> hashtagsBST = new BST<String,hashtag>();
    public static Linked_list<hashtag> valuesHashtags;

    static String[] pilotosAbuscar;
   /* public static void main(String[] args)  {
        long startTime = System.currentTimeMillis();
        cargarDatosApache();

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecucion: " + endTime + "ms");
        int dataSize = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println ("Memoria máxima: " + runtime.maxMemory() / dataSize + "MB");
        System.out.println ("Memoria total: " + runtime.totalMemory() / dataSize + "MB");
        System.out.println ("Memoria libre: " + runtime.freeMemory() / dataSize + "MB");
        System.out.println ("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");

    }*/

    public String[] pilotosMasMencionadosPorMes(int mes, int anio){
        String[] pilotos=pilotosAbuscar;
        Linked_list valuesUsers = users.values();
        String[] top10pilotos = new String[20];
        int[] cantMenciones = new int[20];
        for(int i = 0; i<valuesUsers.size();i++){
            user user = (user) valuesUsers.get(i);
            for(int j = 0; j<user.getCantTweets();j++){
                int mesTweet = user.getTweets().get(j).getFecha()[1];
                int añoTweet = user.getTweets().get(j).getFecha()[0];
                if(mesTweet == mes && añoTweet == anio){
                    for(int k = 0; k<pilotos.length;k++){
                        if(user.getTweets().get(j).getText().toLowerCase().contains(pilotos[k].toLowerCase())){
                            cantMenciones[k]++;
                            top10pilotos[k] = pilotos[k];
                        }
                    }
                }
            }
        }
        for(int i = 0; i<top10pilotos.length;i++){
            for(int j = 0; j<top10pilotos.length;j++){
                if(cantMenciones[i]>cantMenciones[j]){
                    int aux = cantMenciones[i];
                    cantMenciones[i] = cantMenciones[j];
                    cantMenciones[j] = aux;
                    String aux2 = top10pilotos[i];
                    top10pilotos[i] = top10pilotos[j];
                    top10pilotos[j] = aux2;
                }
            }
        }
        return top10pilotos;

    }
    public static int pilotosCantMencionadosPorMes(Linked_list<user> valuesUsers,int mes,int anio,String piloto){
        int cant = 0;
        for(int i = 0; i<valuesUsers.size();i++){
            user user = valuesUsers.get(i);
            for(int j = 0; j<user.getCantTweets();j++){
                int mesTweet = user.getTweets().get(j).getFecha()[1];
                int añoTweet = user.getTweets().get(j).getFecha()[0];
                if(mesTweet == mes && añoTweet == anio){
                    if(user.getTweets().get(j).getText().toLowerCase().contains(piloto.toLowerCase())) {
                      //  System.out.println(user.getName() + " menciono a " + piloto + " en " + user.getTweets().get(j).getText());
                        cant++;
                    }
                }
            }
        }
        return cant;
    }
    public static void cantTweetEspecifico(String texto){
        int canttweets = 0;
        Linked_list valuesUsers = users.values();
        for(int i = 0; i<valuesUsers.size();i++){
            user user = (user) valuesUsers.get(i);
            //System.out.println(user.getName()+":");
            for(int j = 0; j<user.getCantTweets();j++){
                if(user.getTweets().get(j).getText().toLowerCase().contains(texto.toLowerCase()))
                    canttweets++;
                //    System.out.println("Tweet que contiene "+ texto + " es " +user.getTweets().get(j).getText());
            }
        }
        System.out.println("La cantidad de tweets que contienen "+texto+" es: "+canttweets);
    }
    public static void hashMasUsadoParaUnDia(String fecha){
        String[] fechaArray = fecha.split("-");
        int dia = Integer.parseInt(fechaArray[2]);
        int mes = Integer.parseInt(fechaArray[1]);
        int año = Integer.parseInt(fechaArray[0]);
        String hashMasUsado = "";
        int cantHashMasUsado = 0;
        for(int i = 0; i<valuesHashtags.size();i++){
            hashtag hashtag = valuesHashtags.get(i);
            int cantHash = 0;
            for(int j = 0; j<hashtag.cant_tweets();j++){
                tweet tweet = (tweet) hashtag.getTweets().get(j);
                if(tweet.getFecha()[0]==año&&tweet.getFecha()[1]==mes&&tweet.getFecha()[2]==dia && hashtag.getText()!="f1") {
                    cantHash++;
                  //  System.out.println(hashtag.getText()+" esta en el dia:");
                  //  System.out.println("Año: "+año+" Mes: "+mes+" Dia: "+dia);
                }
            }
            if(cantHash>cantHashMasUsado){
                cantHashMasUsado = cantHash;
                hashMasUsado = hashtag.getText();
            }
        }
        System.out.println("El hashtag mas usado en el dia: "+fecha+" es: "+hashMasUsado);
    }
    public static void imprimirCantHashDistintos(String fecha){
        String[] fechaArray = fecha.split("-");
        int dia = Integer.parseInt(fechaArray[2]);
        int mes = Integer.parseInt(fechaArray[1]);
        int año = Integer.parseInt(fechaArray[0]);
        int canthashdisintos = 0;
        for(int i = 0; i<valuesHashtags.size();i++){
            hashtag hashtag = valuesHashtags.get(i);

            boolean estaEnElDía = false;
            for(int j = 0; j<hashtag.cant_tweets();j++){
                tweet tweet = (tweet) hashtag.getTweets().get(j);
                if(tweet.getFecha()[0]==año&&tweet.getFecha()[1]==mes&&tweet.getFecha()[2]==dia&&!estaEnElDía) {
                    estaEnElDía = true;
                    canthashdisintos++;
                   // System.out.println(hashtag.getText()+" esta en el dia:");
                   // System.out.println(tweet.getText());
                    //break;
                }
            }
        }
        System.out.println("La cantidad de hashtags distintos en el dia: "+fecha+" es: "+canthashdisintos);
    }
    public static user[] Top15usuariosConMasTweets(Linked_list listausuarios){
        //devolver los 15 usuarios con mas tweets de la lista de usuarios
        user [] usuariosConMasTweetsList = new user[0];
        for(int i = 0; i<listausuarios.size();i++) {
            user user = (user) listausuarios.get(i);
            if(usuariosConMasTweetsList.length == 0){
                usuariosConMasTweetsList = Arrays.copyOf(usuariosConMasTweetsList, usuariosConMasTweetsList.length + 1);
                usuariosConMasTweetsList[usuariosConMasTweetsList.length - 1] = (user) listausuarios.get(i);
            }else{
                int min = 0;
                while(min<usuariosConMasTweetsList.length && usuariosConMasTweetsList[min]!=null && usuariosConMasTweetsList[min].getCantTweets() > user.getCantTweets()){
                    min++;
                }

                if(usuariosConMasTweetsList.length < 15){
                    usuariosConMasTweetsList = Arrays.copyOf(usuariosConMasTweetsList, usuariosConMasTweetsList.length + 1);
                    for(int j = usuariosConMasTweetsList.length-1; j>min;j--){
                        usuariosConMasTweetsList[j]=usuariosConMasTweetsList[j-1];
                    }
                    usuariosConMasTweetsList[min] = user;
                }
                else if(usuariosConMasTweetsList[min]!=null && user.getCantTweets() < usuariosConMasTweetsList[min].getCantTweets()){
                    for(int j = min; j<usuariosConMasTweetsList.length;j++){
                        if(usuariosConMasTweetsList[j+1]!=null)
                            usuariosConMasTweetsList[j+1]=usuariosConMasTweetsList[j];
                    }
                    usuariosConMasTweetsList[min] = user;
                }

            }
        }
        return usuariosConMasTweetsList;
    }


    public static user[] Top7usuariosConMasFavs(){
        Linked_list listausuarios = users.values();
        //devolver los 15 usuarios con mas tweets de la lista de usuarios
        user [] usuariosConMasFavsList = new user[0];
        for(int i = 0; i<listausuarios.size();i++) {
            user user = (user) listausuarios.get(i);
            if(usuariosConMasFavsList.length == 0){
                usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                usuariosConMasFavsList[usuariosConMasFavsList.length - 1] = (user) listausuarios.get(i);
            }else{
                int min = 0;
                while(min<usuariosConMasFavsList.length && usuariosConMasFavsList[min]!=null && usuariosConMasFavsList[min].getFavorites() > user.getFavorites()){
                    min++;
                }

                if(usuariosConMasFavsList.length < 7){
                    usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                    for(int j = usuariosConMasFavsList.length-1; j>min;j--){
                        usuariosConMasFavsList[j]=usuariosConMasFavsList[j-1];
                    }
                    usuariosConMasFavsList[min] = user;
                }
                else if(min<usuariosConMasFavsList.length && usuariosConMasFavsList[min]!=null && user.getFavorites() < usuariosConMasFavsList[min].getFavorites()){
                    for(int j = min; j<usuariosConMasFavsList.length;j++){
                        if(usuariosConMasFavsList[j+1]!=null)
                            usuariosConMasFavsList[j+1]=usuariosConMasFavsList[j];
                    }
                    usuariosConMasFavsList[min] = user;
                }

            }
        }
        return usuariosConMasFavsList;
    }


    public static void cargarDatosApache(){
        try
        {
            File file=new File("C:\\drivers.txt");    //creates a new file instance
            FileReader fr=new FileReader(file);   //reads the file
            BufferedReader br=new BufferedReader(fr);  //creates a buffering character input stream
            StringBuffer sb=new StringBuffer();    //constructs a string buffer with no characters
            String line;
            String[] pilotosAbuscar2 = new String[20];
            int i = 0;
            while((line=br.readLine())!=null)
            {
               // pilotosAbuscar
                pilotosAbuscar2[i] = line;
                sb.append(line);      //appends line to string buffer
                sb.append("\n");     //line feed
                i++;
            }
            pilotosAbuscar = pilotosAbuscar2;
            fr.close();    //closes the stream and release the resources
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());   //returns a string that textually represents the object
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }


        String SAMPLE_CSV_FILE_PATH = "C:\\f1_dataset_test.csv";

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
               // csvParser=csvParser.withFirstRecordAsHeader();
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                //idTweet,user_name,user_location,user_description,user_created,user_followers,user_friends,user_favourites,user_verified,date,text,hashtags,source,is_retweet
               // if(csvRecord.getRecordNumber()==0)continue;
                int i=0;
                int idTweet=Integer.parseInt(csvRecord.get(i));i++;
                String user_name = csvRecord.get(i);i++;
                System.out.println(idTweet + " - " + user_name);//i++;
                String user_location = csvRecord.get(i);i++;
                System.out.println("Loc " + user_location);
                String user_description = csvRecord.get(i);i++;
                System.out.println("Desc " + user_description);
                String user_created = "";
                int iaux = 0;
                while (true && iaux < 10) {
                    try {
                        user_created = csvRecord.get(i);
                        String [] aux = user_created.split("-");
                        if (aux.length >= 3) {
                            System.out.println("Creado " + user_created);
                            i++;
                            break;
                        }
                    } catch (Exception e) {
                        i++;
                    }
                    iaux++;
                }
                if(iaux>12)continue;

                //int user_followers = Integer.parseInt(csvRecord.get(5));
                //i++;

                int user_friends = (int) Double.parseDouble(csvRecord.get(i));i++;
                int user_favourites;
                iaux=0;
                while (true){
                    try{
                        user_favourites = (int) Double.parseDouble(csvRecord.get(i));
                        i++;
                        break;
                    } catch (Exception e){
                        i++;
                    }
                    iaux++;
                }
                i++;
                String user_verifieds = csvRecord.get(i);
                iaux=0;
                while (!(user_verifieds.toLowerCase().equals("true") || user_verifieds.toLowerCase().equals("false"))) {
                    i++;
                    user_verifieds = csvRecord.get(i);
                    iaux++;
                    if(iaux>12)break;
                }
                if(iaux>12)continue;
                i++;
                boolean user_verified = Boolean.parseBoolean(user_verifieds);//i++;
                System.out.println("Verificado " + user_verifieds);
                String date = csvRecord.get(i);
                System.out.println("Fecha " + date);
                iaux = 0;
                while (true && iaux<13) {
                    try {
                        String [] aux = date.split("-");
                        if (aux.length >= 3) {
                            System.out.println("Creado T " + date);
                            i++;
                            break;
                        }
                        date = csvRecord.get(i);

                    } catch (Exception e) {
                        i++;
                    }
                    iaux++;
                }
                if(iaux>12)continue;
                //String date = csvRecord.get(i);i++;
                String text = csvRecord.get(i);i++;
                String hashtags = csvRecord.get(i);i++;
                hashtags = hashtags.replace("[", "").replace("]", "").replace("\"", "").replace(" ","").trim();
                String [] hashtagsArray = hashtags.split(",");
                System.out.println("Hashtags " + hashtags);
                String source = csvRecord.get(i);i++;
                boolean is_retweet = Boolean.parseBoolean(csvRecord.get(i));

                user user = users.get(user_name);
                if(user == null){
                    user = new user(user_name,user_favourites,user_verified);
                    users.put(user_name,user);
                    heapUsers.insert(user);
                }

                tweet tweet = new tweet(idTweet,text,date);
                user.addTweet(tweet);
                for(int j=0;j<hashtagsArray.length;j++){
                    String hashtagS = hashtagsArray[j].replace("'","");
                    if(hashtagS.equals("F1"))continue;
                    if(!hashtagsBST.contains(hashtagS)) {
                        hashtag hashtag = new hashtag(hashtagS);
                        hashtagsBST.add(hashtagS, hashtag);
                        hashtag.setTweets(tweet);
                    }else
                        hashtagsBST.find(hashtagS).setTweets(tweet);
                }

                System.out.println("Record No - " + csvRecord.getRecordNumber());

            }

          //  Linked_list valuesUsers = users.values();

           // cantTweetEspecifico(valuesUsers,"Abu Dhabi GP main grandstand");



            valuesHashtags = hashtagsBST.inOrder();
          //  imprimirCantHashDistintos(valuesHashtags,"2010-11-10");

           // hashMasUsadoParaUnDia(valuesHashtags,"2022-07-04");

            Linked_list<user> top15 = heapUsers.toList();
           // user[] top15 = Top15usuariosConMasTweets(valuesUsers);
   //         System.out.println("Usuario con mas tweets1: " + top15.get(0).getName());
  //          System.out.println("Usuario con mas tweets2: " + top15.get(1).getName());
   //         System.out.println("Usuario con mas tweets3: " + top15.get(2).getName());

  //          user[] top7 = Top7usuariosConMasFavs(valuesUsers);
    //        System.out.println("Usuario con mas favs1: " + top7[0].getName());
    //        System.out.println("Usuario con mas favs2: " + top7[1].getName());
     //       System.out.println("Usuario con mas favs3: " + top7[2].getName());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}