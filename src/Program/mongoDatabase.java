package Program;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import org.bson.Document;

import javax.print.Doc;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.eq;

public class mongoDatabase {

    /*
        PRIVATE VARIABLES
    */

    private static MongoClientURI _connectionURI = new MongoClientURI("mongodb+srv://gabby:winter22@personaldatabase.wqq3m.mongodb.net/MyBitcoinWallet?retryWrites=true&w=majority");
    private static MongoClient _mongoClient = new MongoClient(_connectionURI);
    private static DB _database = _mongoClient.getDB("MyBitcoinWallet");;

    static bitcoinAPI btc = new bitcoinAPI();

    // @METHOD: Insert new user.
    // @DESCRIPTION: Inserts new user to the database.
    public static void insertNewUser(String email, String password) {

        try {

            boolean genWalletSuccess = btc.generateNewWallet();

            if(genWalletSuccess == true) {

                DBCollection users = _database.getCollection("users");
                DBObject newUser = new BasicDBObject()
                        .append("user_email", email)
                        .append("user_password", password)
                        .append("public_btc_wallet", btc._publicBitcoinWallet)
                        .append("private_wallet_key", btc._privatePrivateWalletKey)
                        .append("user_balance", 0);

                users.insert(newUser);

            } else {
                System.out.println("There has been an issue.");
            }

        } catch(Exception e) {
            System.out.println(e);
        }

    }

    // @METHOD: Find user.
    // @DESCRIPTION: Searches for the user with the parameter, if user is found, the method will return a true.
    public static boolean findUser(String email) {

        boolean userFound = false;

        try {

            DBCollection users = _database.getCollection("users");

            BasicDBObject searchUser = new BasicDBObject();
            searchUser.put("user_email", email);
            DBCursor cursor = users.find(searchUser);

            if(cursor.hasNext()) {

                userFound = true;

            } else if(!cursor.hasNext()) {

                userFound = false;

            }

        } catch (Exception e) {
            userFound = false;
        }

        return userFound;

    }

}
