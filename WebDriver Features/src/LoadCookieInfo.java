import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
import java.util.Date;

public class LoadCookieInfo {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        try{
            File file = new File("Browser.data");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String name, value, domain, path, dt;
            Date expiry = null;
            name = null;
            value = null;
            domain =  null;
            path = null;
            dt = null;
            boolean isSecure = false;
            while((line=br.readLine()) != null){
                StringTokenizer str = new StringTokenizer(line,";");
                while(str.hasMoreTokens()) {
                    name = str.nextToken();
                    value = str.nextToken();
                    domain = str.nextToken();
                     path = str.nextToken();
                     expiry = null;
                    dt = str.nextToken();
                    expiry = new Date(dt);
                    isSecure = new Boolean(str.nextToken()).booleanValue();

                }
            }
            System.out.println("name"+name);
            System.out.println("value"+value);
            Cookie ck = new Cookie(name,value,domain,path,expiry,isSecure);
            driver.manage().addCookie(ck);

        }catch(Exception ex){
            ex.printStackTrace();
        }

        driver.get("https://www.facebook.com/");
    }
}
