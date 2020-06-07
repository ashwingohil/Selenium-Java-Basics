import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitTime {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.google.com/");

        /*
        driver.manage() is in WebDriver gives return as WebDriver.Option which is a nested class in WebDriver.
        It is a public static interface which contains method timeouts(). timeouts() gives return WebDriver.timeouts
        which is also a static interface which contains ImplicitlyWait method. It returns WebDriver.timeouts

        https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.html
        https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Options.html
        https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebDriver.Timeouts.html
         */

        /*
        The above line can be simplified as under:
        WebDriver.Options object = driver.manage();
        WebDriver.Timeouts object2 = object.timeouts();
        object2.implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("https://www.google.com/");
        Know more on this. Though it is static why does object and object2 work
        */
    }
}
