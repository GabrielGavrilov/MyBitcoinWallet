package Program;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class bitcoinAPI {

    /*
        PUBLIC VARIABLES
    */

    public static String _publicBitcoinWallet;
    public static String _privatePrivateWalletKey;
    public static String _btcWalletBalance;
    public static String _usdWalletBalance;

    // @METHOD: Bitcoin wallet generator.
    // @DESCRIPTION: Goes to "https://walletgenerator.net", generates a new wallet, and scrapes the data.
    public static boolean generateNewWallet() {

        try(Playwright playwright = Playwright.create()) {

            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            String websiteUrl = "https://walletgenerator.net/";
            String selectorSkip = "#seedSkipper > a";
            String selectorWallet = "#btcaddress";

            page.navigate(websiteUrl);
            page.waitForSelector(selectorSkip);
            page.click(selectorSkip);
            page.waitForSelector(selectorWallet);

            Object scrapePublicWallet = page.evaluate("()=> {\n" +
                    "   var btcWallet = document.getElementById(\"btcaddress\").innerHTML\n" +
                    "   return btcWallet\n" +
                    "}");

            Object scrapePrivateWalletKey = page.evaluate("()=> {\n" +
                    "   var privWallet = document.getElementById(\"btcprivwif\").innerHTML\n" +
                    "   return privWallet\n" +
                    "}");

            _publicBitcoinWallet = scrapePublicWallet.toString();
            _privatePrivateWalletKey = scrapePrivateWalletKey.toString();

            browser.close();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    // @METHOD: Bitcoin Wallet Balance Scraper
    // @DESCRIPTION: Goes to "https://bitref.com/" and scrapes the bitcoin wallet's btc balance
    public static boolean getBtcWalletBalance(String btcWalletAddress) {

        try(Playwright playwright = Playwright.create()) {

            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            String btcWalletBalanceWebsiteUrl = "https://bitref.com/" + btcWalletAddress;

            page.navigate(btcWalletBalanceWebsiteUrl);
            page.waitForTimeout(3000);

            Object scrapeBtcWalletBalance = page.evaluate("() => {\n" +
                    "   var btcBalance = document.getElementById(\"final_balance\").innerHTML\n" +
                    "   return btcBalance\n" +
                    "}");

            _btcWalletBalance = scrapeBtcWalletBalance.toString();

            return true;

        } catch(Exception e) {

            System.out.println(e);
            return false;

        }

    }

    // @METHOD: USD Wallet Balance Scraper
    // @DESCRIPTION: Goes to "https://www.cointracker.io/" and scrapes the bitcoin wallet's USD balance.
    public static boolean getUsdWalletBalance(String btcWalletBalance) {

        try(Playwright playwright = Playwright.create()) {

            Browser browser = playwright.firefox().launch();
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            String usdWalletBalanceWebsiteUrl = "https://www.cointracker.io/wallet/bitcoin?address=" + btcWalletBalance;

            page.navigate(usdWalletBalanceWebsiteUrl);
            page.waitForTimeout(10000);

            Object scrapeUsdWalletBalance = page.evaluate("()=> {\n" +
                    "   var usdBalance = document.getElementById(\"balance-usd-container\").innerHTML\n" +
                    "   return usdBalance\n" +
                    "}");

            _usdWalletBalance = scrapeUsdWalletBalance.toString();

            return true;

        } catch(Exception e) {

            System.out.println(e);
            return false;

        }

    }


}
