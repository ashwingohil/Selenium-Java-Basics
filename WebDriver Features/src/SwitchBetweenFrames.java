import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SwitchBetweenFrames {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium_Java_Basics/WebDriver%20Features/src/Frames.html");

        /*
        This code switches to right side that is second frame. frame1. I have switched it over there but findingElement
        to right text on frame0 text box. It will not be able to write because frame selected is 1 I want to write it
        on 0.
        driver.switchTo().frame(1);
        WebElement text = driver.findElement(By.name("1"));
        text.sendKeys("This is frame 1");
        */

        driver.switchTo().frame(0);
        WebElement text = driver.findElement(By.name("1"));
        Thread.sleep(2000); ////throws exception so it has to be mentioned in main
        text.sendKeys("This is frame 1");

        //Now I need to switch to right frame that is frame1 but I will have to switch back to defaultContent();

        /*
        This code will throw an exception and will not switch so switch to defaultContent() and then switch to 1
        driver.switchTo().frame(1);
        WebElement text2 = driver.findElement(By.name("2"));
        Thread.sleep(2000);
        text2.sendKeys("This is frame 2");
        */

        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement text2 = driver.findElement(By.name("2"));
        Thread.sleep(2000);
        text2.sendKeys("This is frame 2");

        //---------------------------------------------
        /*
        Now there are 2 more overloaded methods of frame
        WebDriver frame(String frameNameorFrameID)
        WebDriver frame(WebElement frameElement)
         */
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frameTwo");
        text2.sendKeys("Called by frame name");

        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        WebElement frame = driver.findElement(By.name("frameTwo"));
        driver.switchTo().frame(frame);
        text2.sendKeys("Last typing");
        
    }
}
