import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class WindowHandling {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium_Java_Basics/WebDriver%20Features/src/Window.html");

        String window1 = driver.getWindowHandle();
        System.out.println("First Window Handle is: "+window1);

        WebElement link = driver.findElement(By.linkText("Google Search"));
        link.click();

        String window2 = driver.getWindowHandle();
        System.out.println("Second Window Handle is: "+window2);

        Set<String> windowHandles = new HashSet<>();
        windowHandles = driver.getWindowHandles();
        System.out.println("Total window handles is: "+windowHandles.size());

        //getWindowHandle() taken into a string is creating same values in both the strings. using set values
        String[] myarray = new String[windowHandles.size()];

        Iterator<String> i = windowHandles.iterator();
        int j=0;
        while(i.hasNext())
        {
            myarray[j] = (String)i.next();
            j++;
        }

        System.out.println("Handle1: "+myarray[0]);
        System.out.println("Handle2: "+myarray[1]);

        (driver.switchTo()).window(myarray[0]); //this works. When clicking it switches to new window so be switch to main0
        Thread.sleep(3000); //throws exception so it has to be mentioned in main
        driver.switchTo().window(myarray[1]);
        //driver.switchTo() returns WebDriver.TargetLocator which is static interface which has method window()


    }
}
