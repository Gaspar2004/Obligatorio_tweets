package User;

import Tweet.tweet;
import linked_list.Linked_list;

public interface user_interface {
    //public void user (String name, String username, String user_location, String user_description, String UserCreated, int followers_count, int friends_count, int favourites_count);

    String getName();

    void addTweet(tweet t);

    int getFavorites();

    int getCantTweets();

    Linked_list<tweet> getTweets();

}
