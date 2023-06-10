package HashTag;

import Tweet.tweet;
import linked_list.Linked_list;

public class hashtag implements hashtag_interface, Comparable<hashtag> {
    private String text;
    private int cant_tweets;
    Linked_list<tweet> tweets;

    public hashtag (String text) {
        this.text = text;
        cant_tweets=0;
        tweets = new Linked_list<tweet>();
    }

    @Override
    public String getText() {
        return text;
    }
    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setTweets(tweet tweet) {
        tweets.add(tweet);
        cant_tweets++;
    }

    @Override
    public int cant_tweets() {
        return cant_tweets;
    }

    @Override
    public Linked_list getTweets() {
        return tweets;
    }



    @Override
    public int compareTo(hashtag o) {
        return this.cant_tweets - o.cant_tweets;
    }
}
