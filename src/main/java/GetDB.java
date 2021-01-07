import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

// code to get the information from the database in the constructor
// store the info into arrays
// make functions that return the arrays of info when called in other classes

public class GetDB {
    //ArrayList of ArrayList that stores all info from the DB
    ArrayList<ArrayList> AllProducts = new ArrayList<ArrayList>();
    String jsonS = "";

    // Arrays into which the info will be moved to be used in the other classes:
    ArrayList<String> Brand = new ArrayList<>();
    ArrayList<String> Amount = new ArrayList<>();
    ArrayList<String> SPrice = new ArrayList<>();
    ArrayList<String> PPrice = new ArrayList<>();
    ArrayList<String> FullStock = new ArrayList<>();
    ArrayList<String> Limit = new ArrayList<>();
    ArrayList<String> Description = new ArrayList<>();
    ArrayList<String> Category = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();
    ArrayList<String> CurrentStock = new ArrayList<>();


    public GetDB() {
        try {
            URL myURL = new URL("https://phabonlineshop.herokuapp.com/DBaccess");
            HttpURLConnection conn = (HttpURLConnection) myURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("charset", "utf-8");

            BufferedReader in = new BufferedReader(new InputStreamReader(myURL.openStream()));
            String inputLine;
            //read the body of the response:
            while ((inputLine = in.readLine()) != null) {
                jsonS += inputLine;
            }
            in.close();

            Gson gson = new Gson();
            AllProducts = gson.fromJson(jsonS, ArrayList.class);


        } catch (Exception e) {
            System.out.println("Something went wrong");
        }


        // arrays that will store the info by type

        for(int i = 0; i<AllProducts.size(); i++){
            ArrayList<String> product = new ArrayList<String>();
            product = AllProducts.get(i); // getting all the info for 1 product
            // ordering from DB: barnd, amount, salesprice, purchaseprice
            // fullstock, limit, decription, category, id, current stock
            Brand.add(product.get(0));
            Amount.add(product.get(1));
            SPrice.add(product.get(2));
            PPrice.add(product.get(3));
            FullStock.add(product.get(4));
            Limit.add(product.get(5));
            Description.add(product.get(6));
            Category.add(product.get(7));
            ID.add(product.get(8));
            CurrentStock.add(product.get(8));

            //System.out.println(product);
        }

       /* System.out.println(Brand);
        System.out.println(Amount);
        System.out.println(SPrice);
        System.out.println(PPrice);
        System.out.println(FullStock);
        System.out.println(Limit);
        System.out.println(Description);
        System.out.println(Category);
        System.out.println(ID);
        System.out.println(CurrentStock); */


    }

    public ArrayList<String> getBrand() { return Brand; }

    public ArrayList<String> getAmount() { return Amount; }

    public ArrayList<String> getSPrice() { return SPrice; }

    public ArrayList<String> getPPrice(){ return PPrice; }

    public ArrayList<String> getFullStock() { return FullStock; }

    public ArrayList<String> getLimit() { return Limit; }

    public ArrayList<String> getDescription() { return Description; }

    public ArrayList<String> getCategory(){ return Category; }

    public ArrayList<String> getID() { return ID; }

    public ArrayList<String> getCurrentStock(){ return CurrentStock; }

}