package HashTag;

import Tweet.tweet;

public interface hashtag_interface {
    public void hashtag (long id, String text);
    public long getID();
    public String getText();
    public void setText(String text);
    public void setTweets(tweet tweet);
}
