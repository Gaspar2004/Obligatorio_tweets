package Tweet;


import User.user;

public class tweet implements tweet_interface{
    private long id;
    private String text;
    private String source;
    private boolean retweet;
    private String fecha;


    user user = null;



    @Override
    public void tweet(long id, String text, User.user user, String fecha, String source, boolean retweet) {
        this.id = id;
        this.text = text;
        this.user = user;
        this.fecha = fecha;
        this.source = source;
        this.retweet = retweet;
        user.sumarTweet();
    }
}
