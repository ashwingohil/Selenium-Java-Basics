import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class BrowserCapabilities {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        Map capabilitiesMap = new HashMap();
        capabilitiesMap.put("takesScreenshot",true);
        DesiredCapabilities capabilities = new DesiredCapabilities(capabilitiesMap);
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");

    }
}

