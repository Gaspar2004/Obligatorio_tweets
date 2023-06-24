package HashTag;

import Tweet.tweet;
import linked_list.Linked_list;

public interface hashtag_interface {

    public String getText();
    public void setText(String text);
    public void setTweets(tweet tweet);
    int cant_tweets();
    Linked_list getTweets();
}
