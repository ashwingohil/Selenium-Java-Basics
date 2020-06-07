import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class StoreCookieInfo {

    //The following program does not automatically log into facebook. persis
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        WebElement email = driver.findElement(By.name("email"));
        WebElement password = driver.findElement(By.name("pass"));
       // WebElement persistent = driver.findElement(By.name("persistent"));
       // persistent.click(); gives error

        email.sendKeys("ashwin.k.gohil@gmailcom");
        password.sendKeys("password");
        password.submit();

        File file = new File("Browser.data");

        try{
            file.delete();
            file.createNewFile();
            FileWriter writeObject = new FileWriter(file);
            BufferedWriter bufferObject = new BufferedWriter(writeObject);

            for(Cookie ck : driver.manage().getCookies()){
                bufferObject.write(ck.getName()+ ";" +ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure());
                bufferObject.newLine();
            }
            bufferObject.flush();
            bufferObject.close();
            writeObject.close();

        }catch(Exception ex){
            ex.printStackTrace();
        }


    }
}
