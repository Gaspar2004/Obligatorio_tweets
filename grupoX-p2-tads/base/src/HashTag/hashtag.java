package HashTag;

import Tweet.tweet;
import linked_list.Linked_list;

public class hashtag implements hashtag_interface {
    private long id;
    private String text;
    private int cant_tweets;
    Linked_list<tweet> tweets = new Linked_list<tweet>();
    @Override
    public void hashtag (long id, String text) {
        this.id = id;
        this.text = text;
        cant_tweets=0;
    }
    @Override
    public long getID() {
        return id;
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
}
