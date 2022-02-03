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



}
