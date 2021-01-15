
import com.google.gson.Gson;

import javax.smartcardio.Card;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

// code to get the information from the database in the constructor
// store the info into arrays
// make functions that return the arrays of info when called in other classes

/* This class would have been replaced by something more appropriate within a Servlet to directly connect to the DB and not perform another GET request */
/* We are aware that our client is the browser and not this .java page */

public class GetDB_clients {
    //ArrayList of ArrayList that stores all info from the DB
    ArrayList<ArrayList> AllClients = new ArrayList<ArrayList>();
    String jsonS = "";

    // Arrays into which the info will be moved to be used in the other classes:
    ArrayList<String> lastName = new ArrayList<>();
    ArrayList<String> firstName = new ArrayList<>();
    ArrayList<String> CardNumber = new ArrayList<>();
    ArrayList<String> CCV = new ArrayList<>();
    ArrayList<String> expDate = new ArrayList<>();
    ArrayList<String> password = new ArrayList<>();
    ArrayList<String> ID = new ArrayList<>();


    public GetDB_clients() {
        try {
            URL myURL = new URL("https://projectservlet.herokuapp.com/access?item=clients");
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
            AllClients = gson.fromJson(jsonS, ArrayList.class);


        } catch (Exception e) {
            System.out.println("Something went wrong");
        }


        // Arrays that will store the info by type

        for(int i = 0; i<AllClients.size(); i++){
            ArrayList<String> clients = new ArrayList<String>();
            clients = AllClients.get(i); // getting all the info for 1 product
            // ordering from DB: lastname, firstname,cardnumber, ccv, expdate, password, id
            lastName.add(clients.get(0));
            firstName.add(clients.get(1));
            CardNumber.add(clients.get(2));
            CCV.add(clients.get(3));
            expDate.add(clients.get(4));
            password.add(clients.get(5));
            ID.add(clients.get(6));
        }

       /* System.out.println(lastName);
        System.out.println(firstName);
        System.out.println(CardNumber);
        System.out.println(CCV);
        System.out.println(expDate);
        System.out.println(password);
        System.out.println(ID);*/
    }

    public ArrayList<String> getLastName() { return lastName; }

    public ArrayList<String> getFirstName() { return firstName; }

    public ArrayList<String> getCardNumber() { return CardNumber; }

    public ArrayList<String> getCCV() { return CCV; }

    public ArrayList<String> getExpDate() { return expDate; }

    public ArrayList<String> getPassword() { return password; }

    public ArrayList<String> getID() { return ID; }
}