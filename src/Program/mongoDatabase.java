package Program;

import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import org.bson.Document;

import javax.print.Doc;

import java.awt.Cursor;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Filters.eq;

public class mongoDatabase {

    /*
        PRIVATE VARIABLES
    */

    private static MongoClientURI _connectionURI = new MongoClientURI("mongodb+srv://gabby:winter22@personaldatabase.wqq3m.mongodb.net/MyBitcoinWallet?retryWrites=true&w=majority");
    private static MongoClient _mongoClient = new MongoClient(_connectionURI);
    private static DB _database = _mongoClient.getDB("MyBitcoinWallet");;

    static bitcoinAPI bitcoinAPI = new bitcoinAPI();
    static userAPI userAPI = new userAPI();

    // @METHOD: Insert new user.
    // @DESCRIPTION: Inserts new user to the database.
    public static void insertNewUser(String email, String password) {

        try {

            boolean genWalletSuccess = bitcoinAPI.generateNewWallet();
            boolean getBtcWalletBalanceSuccess = bitcoinAPI.getBtcWalletBalance(bitcoinAPI._publicBitcoinWallet);
            boolean getUsdWalletBalanceSuccess = bitcoinAPI.getUsdWalletBalance(bitcoinAPI._publicBitcoinWallet);

            if(genWalletSuccess == true && getBtcWalletBalanceSuccess == true) {

                DBCollection users = _database.getCollection("users");
                DBObject newUser = new BasicDBObject()
                        .append("user_email", email)
                        .append("user_password", password)
                        .append("public_btc_wallet", bitcoinAPI._publicBitcoinWallet)
                        .append("private_wallet_key", bitcoinAPI._privatePrivateWalletKey)
                        .append("btc_wallet_balance", bitcoinAPI._btcWalletBalance)
                        .append("usd_wallet_balance", bitcoinAPI._usdWalletBalance);

                users.insert(newUser);

            } else {
                System.out.println("There has been an issue inserting new user.");
            }

        } catch(Exception e) {
            System.out.println(e);
        }

    }

    public static boolean loginUser(String email, String password) {

        boolean loginUser = false;

        String userBtcBalance;
        String userUsdBalance;
        String userPublicWallet;
        String userPrivateKey;

        try {

            DBCollection users = _database.getCollection("users");

            BasicDBObject searchUser = new BasicDBObject();
            searchUser.put("user_email", email);
            searchUser.put("user_password", password);
            DBCursor cursor = users.find(searchUser);

            if(cursor.hasNext()) {

                String cursorToString = cursor.next().toString();
                String[] cursorSplitted = cursorToString.split(", ");

                String userBtcBalanceBeforeSplit = cursorSplitted[5];
                String[] userBtcBalanceSplitted = userBtcBalanceBeforeSplit.split(" ");
                userBtcBalance = userBtcBalanceSplitted[1].substring(1, userBtcBalanceSplitted[1].length() - 1);

                String userUsdBalanceBeforeSplit = cursorSplitted[6];
                String[] userUsdBalanceSplitted = userUsdBalanceBeforeSplit.split(" ");
                userUsdBalance = userUsdBalanceSplitted[1].substring(1, userUsdBalanceSplitted[1].length() - 2);

                String publicBitcoinAddressBeforeSplit = cursorSplitted[3];
                String[] publicBitcoinAddressSplitted = publicBitcoinAddressBeforeSplit.split(" ");
                userPublicWallet = publicBitcoinAddressSplitted[1].substring(1, publicBitcoinAddressSplitted[1].length() - 1);

                String privateKeyBeforeSplit = cursorSplitted[4];
                String[] privateKeySplitted = privateKeyBeforeSplit.split(" ");
                userPrivateKey = privateKeySplitted[1].substring(1, privateKeySplitted[1].length() - 1);

                userAPI.setUserBtcBalance(userBtcBalance);
                userAPI.setUserUsdBalance(userUsdBalance);
                userAPI.setUserPublicWallet(userPublicWallet);
                userAPI.setUserPrivateKey(userPrivateKey);

                loginUser = true;

            } else if(!cursor.hasNext()) {

                loginUser = false;

            }

        } catch(Exception e) {

            System.out.println("There has been an error: " + e);
            loginUser = false;

        }

        return loginUser;

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

    public static void insertNewSendOrder(String senderWallet, String receiverWallet, String amountOfBtc) {

        try {

            DBCollection orders = _database.getCollection("orders");
            DBObject newOrder = new BasicDBObject()
                    .append("sender_wallet", senderWallet)
                    .append("receiver_wallet", receiverWallet)
                    .append("amount_of_bitcoin", amountOfBtc);

            orders.insert(newOrder);

        } catch(Exception e) {

            System.out.println("There has been an issue creating a new send order.");

        }

    }

    public static void updateUserBalance(String publicWallet, String currentBtcBalance, String currentUsdBalance) {

        try {

            DBCollection users = _database.getCollection("users");

            BasicDBObject findUser = new BasicDBObject();
            findUser.put("public_btc_wallet", publicWallet);
            DBCursor cursor = users.find(findUser);

            if(cursor.hasNext()) {

                try {

                    boolean getBtcBalanceSuccess = bitcoinAPI.getBtcWalletBalance(publicWallet);
                    boolean getUsdBalanceSuccess = bitcoinAPI.getUsdWalletBalance(publicWallet);

                    if(getBtcBalanceSuccess == true && getUsdBalanceSuccess == true) {

                        // UPDATE BTC BALANCE
                        BasicDBObject btcQuery = new BasicDBObject();
                        btcQuery.put("btc_wallet_balance", currentBtcBalance);

                        BasicDBObject updatedBtcQuery = new BasicDBObject();
                        updatedBtcQuery.put("btc_wallet_balance", bitcoinAPI._btcWalletBalance);

                        BasicDBObject updateBtcDocument = new BasicDBObject();
                        updateBtcDocument.put("$set", updatedBtcQuery);

                        users.update(btcQuery, updateBtcDocument);

                        // UPDATE USD BALANCE
                        BasicDBObject usdQuery = new BasicDBObject();
                        usdQuery.put("usd_wallet_balance", currentUsdBalance);

                        BasicDBObject updatedUsdQuery = new BasicDBObject();
                        updatedUsdQuery.put("usd_wallet_balance", bitcoinAPI._usdWalletBalance);

                        BasicDBObject updateUsdDocument = new BasicDBObject();
                        updateUsdDocument.put("$set", updatedUsdQuery);

                        users.update(usdQuery, updateUsdDocument);

                    } else {

                        System.out.println("There has been an issue.");

                    }

                } catch(Exception err) {

                    System.out.println(err);

                }

            } else if(!cursor.hasNext()) {

                System.out.println("User not found.");

            }

        } catch(Exception e) {



        }

    }

    public static void deleteUser(String publicWallet) {

        MongoCollection<Document> users = (MongoCollection<Document>) _database.getCollection("users");

        users.deleteOne(new Document("public_btc_wallet", publicWallet));

        System.out.println("Deleted");

    }

}
