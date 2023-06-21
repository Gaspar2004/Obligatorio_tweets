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

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Hello world!");

        File file = new File("C:\\f1_dataset_test.csv");

        Scanner sc = new Scanner(file);
        sc.useDelimiter(",");
        //System.out.print(sc.next());
        for(int i=0;i<12;i++) {

            System.out.println(sc.next());
        }
        sc.nextLine();

        hash<String, user> users = new hash<String, user>(100);
        //for(int i=0;i<50;i++) {
        int id = Integer.parseInt(sc.next());
        System.out.println("ID: "+id);
        String name = sc.next();
        System.out.println("user_name: "+name);
        String user_location = sc.next();
        System.out.println("Loc: "+user_location);
        String user_description = sc.next();
        System.out.println("Desc: "+user_description);
        String UserCreated = sc.next();
        System.out.println("Creado el:" + UserCreated);
        sc.nextInt();
        sc.nextInt();

        int friends_count = sc.nextInt();
        System.out.println(friends_count);
        int favourites_count = sc.nextInt();
        System.out.println(favourites_count);
        // users.put(sc.next(), new user(id,name, user_location, user_description,UserCreated, followers_count, friends_count, favourites_count));
        System.out.print(sc.next() + " //// ");  //find and returns the next complete token from this scanner
        //}
        // }
        sc.close();


        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file.toString().trim()), StandardCharsets.UTF_8)))
        {
            String line;
            line = br.readLine().trim();
            System.out.println(line);
            for(int i=0;i<10;i++){
                line = br.readLine();
                String[] attr = line.split(",");
                hash<String, user> users = new hash<String, user>(100);
                for (int j = 0; j < attr.length; j++) {
                    System.out.println(attr[j] + "|");
                }
            }
            user new_user = new user();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }
}