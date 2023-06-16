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
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class Main2 {

    public static void main(String[] args)  {
        cargarDatosApache();
       // cargarDatosApache();
        user [] usuariosConMasTweetsList = new user[0];
        user [] usuariosConMasFavsList = new user[0];


        BST<String,hashtag> hashtagsBST = new BST<String,hashtag>();

        hash users = new hash(10);
        heap<user> heapUsers = new heap<user>();

        user user2 = new user("name2","username2",1,true);
        tweet tweet2 = new tweet(2,"sadasdsadasd","2023-06-10");
        user2.addTweet(tweet2);
        users.put("username2",user2);



        user user3 = new user("name3","username3",5,true);
        tweet tweet3 = new tweet(3,"32AaaSpiloto1","2023-06-05");
        user3.addTweet(tweet3);
        tweet tweet5 = new tweet(5,"teFDFDFDDFxt5","2023-06-10");
        user3.addTweet(tweet5);
        tweet tweet6 = new tweet(6,"teFDFDFDDFxt6 piloto1","2023-06-10");
        user3.addTweet(tweet6);
        users.put("username3",user3);

        user user4 = new user("name4","username4",18,true);
        tweet tweet4 = new tweet(4,"XDXDXD<xt4piloto2","2023-06-10");
        user4.addTweet(tweet4);
        tweet tweet7 = new tweet(7,"teFDFDFDDFxd7piloto2","2023-06-10");
        user4.addTweet(tweet7);
        users.put("username4",user4);

        user user5 = new user("name5","username5",15,true);
        tweet tweet8 = new tweet(8,"teFDFDFDDFxd8piloto2","2023-06-10");
        user5.addTweet(tweet8);
        users.put("username5",user5);

        heapUsers.insert(user2);
        heapUsers.insert(user3);
        heapUsers.insert(user4);
        heapUsers.insert(user5);




        if(!hashtagsBST.contains("hashtag1")) {
            hashtag hashtag1 = new hashtag("hashtag1");
            hashtagsBST.add("hashtag1", hashtag1);
            hashtag1.setTweets(tweet2);
        }else
            hashtagsBST.find("hashtag1").setTweets(tweet2);


        if(!hashtagsBST.contains("hashtag2")) {
            hashtag hashtag2 = new hashtag("hashtag2");
            hashtagsBST.add("hashtag2", hashtag2);
            hashtag2.setTweets(tweet3);
        }else
            hashtagsBST.find("hashtag2").setTweets(tweet3);


        if(!hashtagsBST.contains("hashtag1")) {
            hashtag hashtag3 = new hashtag("hashtag1");
            hashtagsBST.add("hashtag1", hashtag3);
            hashtag3.setTweets(tweet5);
        }else
            hashtagsBST.find("hashtag1").setTweets(tweet5);


        Linked_list<hashtag> valuesHashtags = hashtagsBST.inOrder();
        imprimirCantHashDistintos(valuesHashtags,"2023-06-10");

        hashMasUsadoParaUnDia(valuesHashtags,"2023-06-05");

        Linked_list valuesUsers = users.values();
        cantTweetEspecifico(valuesUsers,"xd");


        System.out.println("Usuario con mas tweets1: " + Top15usuariosConMasTweets(valuesUsers)[0].getName());
        System.out.println("Usuario con mas tweets2: " + Top15usuariosConMasTweets(valuesUsers)[1].getName());
        System.out.println("Usuario con mas tweets3: " + Top15usuariosConMasTweets(valuesUsers)[2].getName());

        System.out.println("Usuario con mas favs1: " + Top7usuariosConMasFavs(valuesUsers)[0].getName());
        System.out.println("Usuario con mas favs2: " + Top7usuariosConMasFavs(valuesUsers)[1].getName());
        System.out.println("Usuario con mas favs3: " + Top7usuariosConMasFavs(valuesUsers)[2].getName());
        //hashtag hashtag1 = new hashtag("hashtag1");

        //cargardatos();
        String pilotosABuscar[] = {"piloto1","piloto2","piloto3"};
        long startTime = System.currentTimeMillis();

        System.out.println(pilotosMasMencionadosPorMes(valuesUsers,"2023-06-10",pilotosABuscar)[0]);

        long endTime = System.currentTimeMillis() - startTime;
        System.out.println("Tiempo de ejecucion: " + endTime + "ms");
        int dataSize = 1024 * 1024;

        Runtime runtime = Runtime.getRuntime();

        System.out.println ("Memoria máxima: " + runtime.maxMemory() / dataSize + "MB");
        System.out.println ("Memoria total: " + runtime.totalMemory() / dataSize + "MB");
        System.out.println ("Memoria libre: " + runtime.freeMemory() / dataSize + "MB");
        System.out.println ("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / dataSize + "MB");

    }

    public static String[] pilotosMasMencionadosPorMes(Linked_list<user> valuesUsers,String fecha,String [] pilotos){

        String[] top10pilotos = new String[10];
        for (int i = 0; i < pilotos.length; i++) {
            int cant = pilotosCantMencionadosPorMes(valuesUsers,fecha,pilotos[i]);
            if(cant>0){
                for (int j = 0; j < top10pilotos.length; j++) {
                    if(top10pilotos[j] == null){
                        top10pilotos[j] = pilotos[i];
                        break;
                    }
                    if(cant > pilotosCantMencionadosPorMes(valuesUsers,fecha,top10pilotos[j])){
                        String aux = top10pilotos[j];
                        top10pilotos[j] = pilotos[i];
                        pilotos[i] = aux;
                    }
                }
            }
        }
        return top10pilotos;

    }
    public static int pilotosCantMencionadosPorMes(Linked_list<user> valuesUsers,String fecha,String piloto){
        int cant = 0;
        String[] fechaArray = fecha.split("-");
        int mes = Integer.parseInt(fechaArray[1]);
        int año = Integer.parseInt(fechaArray[0]);
        for(int i = 0; i<valuesUsers.size();i++){
            user user = valuesUsers.get(i);
            for(int j = 0; j<user.getCantTweets();j++){
                int mesTweet = user.getTweets().get(j).getFecha()[1];
                int añoTweet = user.getTweets().get(j).getFecha()[0];
                if(mesTweet == mes && añoTweet == año){
                    if(user.getTweets().get(j).getText().toLowerCase().contains(piloto.toLowerCase())) {
                        System.out.println(user.getName() + " menciono a " + piloto + " en " + user.getTweets().get(j).getText());
                        cant++;
                    }
                }
            }
        }
        return cant;
    }
    public static void cantTweetEspecifico(Linked_list valuesUsers,String texto){
        for(int i = 0; i<valuesUsers.size();i++){
            user user = (user) valuesUsers.get(i);
            //System.out.println(user.getName()+":");
            for(int j = 0; j<user.getCantTweets();j++){
                if(user.getTweets().get(j).getText().toLowerCase().contains(texto.toLowerCase()))
                    System.out.println("Tweet que contiene "+ texto + " es " +user.getTweets().get(j).getText());
            }
        }
    }
    public static void hashMasUsadoParaUnDia(Linked_list<hashtag> valuesHashtags,String fecha){
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
                    System.out.println(hashtag.getText()+" esta en el dia:");
                    System.out.println("Año: "+año+" Mes: "+mes+" Dia: "+dia);
                }
            }
            if(cantHash>cantHashMasUsado){
                cantHashMasUsado = cantHash;
                hashMasUsado = hashtag.getText();
            }
        }
        System.out.println("El hashtag mas usado en el dia: "+fecha+" es: "+hashMasUsado);
    }
    public static void imprimirCantHashDistintos(Linked_list<hashtag> valuesHashtags,String fecha){
        String[] fechaArray = fecha.split("-");
        int dia = Integer.parseInt(fechaArray[2]);
        int mes = Integer.parseInt(fechaArray[1]);
        int año = Integer.parseInt(fechaArray[0]);

        for(int i = 0; i<valuesHashtags.size();i++){
            hashtag hashtag = valuesHashtags.get(i);

            boolean estaEnElDía = false;
            for(int j = 0; j<hashtag.cant_tweets();j++){
                tweet tweet = (tweet) hashtag.getTweets().get(j);
                if(tweet.getFecha()[0]==año&&tweet.getFecha()[1]==mes&&tweet.getFecha()[2]==dia&&!estaEnElDía) {
                    estaEnElDía = true;
                    System.out.println(hashtag.getText()+" esta en el dia:");
                    System.out.println(tweet.getText());
                    //break;
                }
            }
        }
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
                while(usuariosConMasTweetsList[min]!=null && usuariosConMasTweetsList[min].getCantTweets() > user.getCantTweets()){
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


    public static user[] Top7usuariosConMasFavs(Linked_list listausuarios){
        //devolver los 15 usuarios con mas tweets de la lista de usuarios
        user [] usuariosConMasFavsList = new user[0];
        for(int i = 0; i<listausuarios.size();i++) {
            user user = (user) listausuarios.get(i);
            if(usuariosConMasFavsList.length == 0){
                usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                usuariosConMasFavsList[usuariosConMasFavsList.length - 1] = (user) listausuarios.get(i);
            }else{
                int min = 0;
                while(usuariosConMasFavsList[min]!=null && usuariosConMasFavsList[min].getFavorites() > user.getFavorites()){
                    min++;
                }

                if(usuariosConMasFavsList.length < 7){
                    usuariosConMasFavsList = Arrays.copyOf(usuariosConMasFavsList, usuariosConMasFavsList.length + 1);
                    for(int j = usuariosConMasFavsList.length-1; j>min;j--){
                        usuariosConMasFavsList[j]=usuariosConMasFavsList[j-1];
                    }
                    usuariosConMasFavsList[min] = user;
                }
                else if(usuariosConMasFavsList[min]!=null && user.getFavorites() < usuariosConMasFavsList[min].getFavorites()){
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
    public static void cargardatos() throws FileNotFoundException {
        //FileReader fileReader = new FileReader("C:\\Users\\Usuario\\Desktop\\tweets.txt")
        File file = new File("C:\\f1_dataset_test.csv");
        //Scanner sc = new Scanner(file);
        //sc.useDelimiter(",");
        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");
        //System.out.print(sc.next());
        for(int i=0;i<12;i++) {
            System.out.println(sc.next());
        }


        hash<String, user> users = new hash<String, user>(100);
        while(sc.hasNext()) {
            sc.nextLine();
            boolean terminado = false;
            int id = Integer.parseInt(sc.next());
            System.out.println("ID: " + id);
            String name = sc.next();
            System.out.println("user_name: " + name);

            String user_location = sc.next();
            String user_description="";
            while (true) {
                String aux=sc.next();
                user_description=aux;
                if(aux.indexOf("\"") != -1&&aux.trim().indexOf("\"") != 0) {
                    //user_location += sc.next();
                    break;
                }
                user_location += aux;
            }
            System.out.println("Loc: " + user_location);
            //String user_description = sc.next();
            while(true){
                String aux=sc.next();
                if(aux.indexOf("\"") != -1 && aux.trim().indexOf("\"") != 0) {
                    //user_description += sc.next();
                    break;
                }
                user_description += aux;
            }


            System.out.println("Desc: " + user_description);
            String UserCreated = sc.next();
            System.out.println("Creado el:" + UserCreated);
            sc.next();
            sc.next();
            sc.next();
            sc.next();
            String dateTweet = sc.next();
            System.out.println("Fecha del tweet: " + dateTweet);
            String tweetText = sc.next();
            String nextHashtag = sc.next();
            while (true){
                if(nextHashtag.indexOf("[") == -1) {
                    //tweetText += nextHashtag;
                    break;
                }
                tweetText += nextHashtag;
                nextHashtag = sc.next();

            }

            System.out.println("Tweet: " + tweetText);

            terminado=false;
            Linked_list<String> hashtags = new Linked_list<String>();
            while (!terminado) {

                hashtags.add(nextHashtag.replace("[", "").replace("]", "").replace("\"", "").trim());
                if (nextHashtag.indexOf("]") != -1)
                    terminado = true;
                nextHashtag = sc.next();
            }

            System.out.println("Hashtags: ");
            for (int i = 0; i < hashtags.size(); i++) {
                System.out.println(hashtags.get(i));
            }
            //sc.next();
            //sc.next();
            //sc.next();
            //sc.nextLine();
        }
        sc.close();
    }




    public static void cargarDatosApache(){

        String SAMPLE_CSV_FILE_PATH = "C:\\f1_dataset_test.csv";

        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
               // csvParser=csvParser.withFirstRecordAsHeader();
        ) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                //idTweet,user_name,user_location,user_description,user_created,user_followers,user_friends,user_favourites,user_verified,date,text,hashtags,source,is_retweet

                int i=0;
                int idTweet=Integer.parseInt(csvRecord.get(i));i++;
                String user_name = csvRecord.get(i);i++;
                System.out.println(idTweet + " - " + user_name);//i++;
                String user_location = csvRecord.get(i);i++;
                String user_description = csvRecord.get(i);i++;
                String user_created = csvRecord.get(i);i++;
                //int user_followers = Integer.parseInt(csvRecord.get(5));
                i++;
                int user_friends = (int) Double.parseDouble(csvRecord.get(i));i++;
                int user_favourites = (int) Double.parseDouble(csvRecord.get(i));i++;
                boolean user_verified = Boolean.parseBoolean(csvRecord.get(i));i++;
                String date = csvRecord.get(i);i++;
                String text = csvRecord.get(i);i++;
                String hashtags = csvRecord.get(i);i++;
                String source = csvRecord.get(i);i++;
                boolean is_retweet = Boolean.parseBoolean(csvRecord.get(i));



                System.out.println("Record No - " + csvRecord.getRecordNumber());

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}