package Tweet;


import User.user;

public class tweet implements tweet_interface{
    private int id;
    private String text;
    private String fecha;
    private int año;
    private int mes;
    private int dia;

   // user user = null;


    public  tweet(int id, String text, String fecha) {
        this.id = id;
        this.text = text;
        //this.user = user;
        this.fecha = fecha;
        String[] fecha_separada = fecha.split("-");
        this.año = Integer.parseInt(fecha_separada[0]);
        this.mes = Integer.parseInt(fecha_separada[1]);
        this.dia = Integer.parseInt(fecha_separada[2].substring(0,2));
        //user.sumarTweet();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int[] getFecha() {
        int[] fecha = new int[3];
        fecha[0] = año;
        fecha[1] = mes;
        fecha[2] = dia;
        return fecha;
    }
}
