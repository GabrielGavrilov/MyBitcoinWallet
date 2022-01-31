package Program;

import com.mongodb.*;

public class mongoDatabase {

    private static MongoClientURI _connectionURI = new MongoClientURI("mongodb+srv://gabby:winter22@personaldatabase.wqq3m.mongodb.net/MyBitcoinWallet?retryWrites=true&w=majority");
    private static MongoClient _mongoClient = new MongoClient(_connectionURI);
    private static DB _database = _mongoClient.getDB("MyBitcoinWallet");

    static bitcoinAPI btc = new bitcoinAPI();

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

}
