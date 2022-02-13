package Program;

public class userAPI {

    /*
        PRIVATE VARIABLES
    */

    private static String _userBtcBalance;
    private static String _userUsdBalance;
    private static String _userPublicWallet;

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
