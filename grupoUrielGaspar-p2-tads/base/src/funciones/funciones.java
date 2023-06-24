package funciones;

import BST.BST;
import Hash.hash;
import HashTag.hashtag;
import Heap.heap;
import Tweet.tweet;
import User.user;
import linked_list.Linked_list;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class funciones {
    //public static heap<user> heapUsers = new heap<user>(false);
    public static Linked_list valuesUsers;
    public static hash<String,user> users = new hash<String,user>(65000);
    public static hash<String,hashtag> hashtagsHash = new hash<String,hashtag>(20000);
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
                            top10pilotos[k] = pilotos[k] + " - " + cantMenciones[k]+" menciones";
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
    public void cantTweetEspecifico(String texto){
        int canttweets = 0;
       // Linked_list valuesUsers = users.values();
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
    public static user[] Top15usuariosConMasTweets(){
        //Linked_list listausuarios = users.values();
        //devolver los 15 usuarios con mas tweets de la lista de usuarios
        user [] usuariosConMasTweetsList = new user[0];
        for(int i = 0; i<valuesUsers.size();i++) {
            user user = (user) valuesUsers.get(i);
            if(usuariosConMasTweetsList.length == 0){
                usuariosConMasTweetsList = Arrays.copyOf(usuariosConMasTweetsList, usuariosConMasTweetsList.length + 1);
                usuariosConMasTweetsList[usuariosConMasTweetsList.length - 1] = (user) valuesUsers.get(i);
            }else{
                int min = 0;
                while(min<usuariosConMasTweetsList.length && usuariosConMasTweetsList[min]!=null && usuariosConMasTweetsList[min].getCantTweets()>user.getCantTweets()){
                    min++;
                }
                if(min<usuariosConMasTweetsList.length && usuariosConMasTweetsList[min]!=null){
                    usuariosConMasTweetsList = Arrays.copyOf(usuariosConMasTweetsList, usuariosConMasTweetsList.length + 1);
                    for(int j = usuariosConMasTweetsList.length-1;j>min;j--){
                        usuariosConMasTweetsList[j] = usuariosConMasTweetsList[j-1];
                    }
                    usuariosConMasTweetsList[min] = user;
                }else{
                    usuariosConMasTweetsList = Arrays.copyOf(usuariosConMasTweetsList, usuariosConMasTweetsList.length + 1);
                    usuariosConMasTweetsList[usuariosConMasTweetsList.length - 1] = user;
                }
            }
        }
        return usuariosConMasTweetsList;
    }


    public static user[] Top7usuariosConMasFavs(){
        //Linked_list listausuarios = users.values();
        //devolver los 15 usuarios con mas tweets de la lista de usuarios
        user [] usuariosConMasFavsList = new user[0];
        for(int i = 0; i<valuesUsers.size();i++) {
            user user = (user) valuesUsers.get(i);
            if(usuariosConMasFavsList.length == 0){
                usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                usuariosConMasFavsList[usuariosConMasFavsList.length - 1] = (user) valuesUsers.get(i);
            }else{
                int min = 0;
                while(min<usuariosConMasFavsList.length && usuariosConMasFavsList[min]!=null && usuariosConMasFavsList[min].getFavorites()>user.getFavorites()){
                    min++;
                }
                if(min<usuariosConMasFavsList.length && usuariosConMasFavsList[min]!=null){
                    usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                    for(int j = usuariosConMasFavsList.length-1;j>min;j--){
                        usuariosConMasFavsList[j] = usuariosConMasFavsList[j-1];
                    }
                    usuariosConMasFavsList[min] = user;
                }else{
                    usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                    usuariosConMasFavsList[usuariosConMasFavsList.length - 1] = user;
                }
            }
        }
        return usuariosConMasFavsList;
    }


    public void cargarDatosApache(){
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


        String csvFile = "C://f1_dataset_test.csv";
        File file = new File(csvFile);

        try (
                CSVParser csvParser = CSVParser.parse(file, StandardCharsets.UTF_8, CSVFormat.DEFAULT);
        ) {
            for (CSVRecord csvRecord : csvParser) {
                //idTweet,user_name,user_location,user_description,user_created,user_followers,user_friends,user_favourites,user_verified,date,text,hashtags,source,is_retweet
                try {
                    int idTweet = Integer.parseInt(csvRecord.get(0));

                    String user_name = csvRecord.get(1);

                    double user_favourites;
                    user_favourites = Double.parseDouble(csvRecord.get(7));
                    String user_verifieds = csvRecord.get(8);
                    boolean user_verified = Boolean.parseBoolean(user_verifieds);//i++;

                    String date = csvRecord.get(9);

                    String text = csvRecord.get(10);
                    String hashtags = csvRecord.get(11);
                    hashtags = hashtags.replace("[", "").replace("]", "").replace("\"", "").replace(" ", "").trim();
                    String[] hashtagsArray = hashtags.split(",");

                    user user;
                    if (!users.contains(user_name)) {
                        user = new user(user_name, user_favourites, user_verified);
                        users.put(user_name, user);
                    }else {
                        user = (user) users.get(user_name);
                    }

                    tweet tweet = new tweet(idTweet, text, date);
                    user.addTweet(tweet);
                    for (int j = 0; j < hashtagsArray.length; j++) {
                        String hashtagS = hashtagsArray[j].replace("'", "");
                        if (hashtagS.equals("F1")) continue;
                        if (!hashtagsHash.contains(hashtagS)) {
                            hashtag hashtag = new hashtag(hashtagS);
                            hashtagsHash.put(hashtagS, hashtag);
                            hashtag.setTweets(tweet);
                        } else
                            hashtagsHash.get(hashtagS).setTweets(tweet);
                    }

                    System.out.println("Record No - " + csvRecord.getRecordNumber());
                } catch (Exception e) {
                    System.out.println("Error en la linea " + csvRecord.getRecordNumber());
                    e.printStackTrace();
                }
            }
            this.valuesUsers = users.values();
            users=null;
            valuesHashtags = hashtagsHash.values();
            hashtagsHash=null;
            System.out.println("Tamaño de usuarios " + valuesUsers.size());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}