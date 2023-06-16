package User;

import Tweet.tweet;
import linked_list.Linked_list;

public class user implements user_interface, Comparable<user> {

    private String name;

    private int cant_tweets;
    private boolean verified;
    private String username;

    private int favourites_count;
    private Linked_list <tweet> tweets =null;


    public user(String name, String username, int favourites_count,boolean verified) {
        this.name = name;
        this.username = username;
        this.favourites_count = favourites_count;
        this.verified=verified;
        cant_tweets=0;
        tweets = new Linked_list<tweet>();
    }



    @Override
    public String getName() {
        return name;
    }



    @Override
    public void addTweet(tweet t) {
        tweets.add(t);
        cant_tweets++;
    }

    @Override
    public int getFavorites() {
        return this.favourites_count;
    }

    @Override
    public int getCantTweets() {
        return this.cant_tweets;
    }
    @Override
    public Linked_list<tweet> getTweets(){
        return tweets;
    }


    @Override
    public int compareTo(user o) {
        return o.cant_tweets-cant_tweets;
    }
}
