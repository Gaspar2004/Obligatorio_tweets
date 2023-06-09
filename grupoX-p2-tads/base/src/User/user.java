package User;

public class user implements user_interface {
    private long id;
    private String name;

    private int cant_tweets;
    private boolean verified;
    private String username;
    private String user_location;
    private String user_description;
    private String UserCreated;
    private int followers_count;
    private int friends_count;
    private int favourites_count;


    public user( int id,String name, String username, String user_location, String user_description,
            String UserCreated, int followers_count, int friends_count, int favourites_count) {
        this.id = id;
        this.name = name;
        this.verified = false;
        this.username = username;
        this.user_location = user_location;
        this.user_description = user_description;
        this.UserCreated = UserCreated;
        this.followers_count = followers_count;
        this.friends_count = friends_count;
        this.favourites_count = favourites_count;
        cant_tweets=0;
    }

    @Override
    public long getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void sumarTweet() {
        cant_tweets++;
    }



}
