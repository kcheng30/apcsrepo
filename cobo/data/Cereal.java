public class Cereal {
    private double rating;
    private int sugar;

    public Cereal (double rating, int sugar) {
        this.rating = rating;
        this.sugar = sugar;
    }

    public double getRating () {
        return rating;
    }
    
    public int getSugar() {
        return sugar;
    }

    public String toString() {
        String retVal = "Rating: " + rating + "\n";
        retVal = retVal + "Sugar: " + sugar;
        return retVal;
    }

    public static void main(String[] args) {
        Cereal raisin = new Cereal(10.2, 2);
        Cereal cheerio = new Cereal(4, 244);
        Cereal idk = new Cereal(-1, 44545);
        System.out.println(raisin);
        System.out.println(cheerio);
        System.out.println(idk);

    }
}