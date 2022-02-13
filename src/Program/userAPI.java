package Program;

public class userAPI {

    /*
        PRIVATE VARIABLES
    */

    private static String _userBtcBalance = "0.00000000";
    private static String _userUsdBalance = "$0.00";
    private static String _userPublicWallet = "null";

    /*
        GETTERS
    */

    public static String getUserBtcBalance() {
        String userBtcBalance;
        userBtcBalance = _userBtcBalance;
        return userBtcBalance;
    }

    public static String getUserUsdBalance() {
        String userUsdBalance;
        userUsdBalance = _userUsdBalance;
        return userUsdBalance;
    }

    public static String getUserPublicWallet() {
        String userPublicWallet;
        userPublicWallet = _userPublicWallet;
        return userPublicWallet;
    }

    /*
        SETTERS
    */

    public static void setUserBtcBalance(String balance) {
        _userBtcBalance = balance;
    }

    public static void setUserUsdBalance(String balance) {
        _userUsdBalance = balance;
    }

    public static void setUserPublicWallet(String wallet) {
        _userPublicWallet = wallet;
    }

}
