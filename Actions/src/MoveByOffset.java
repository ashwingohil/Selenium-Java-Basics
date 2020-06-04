import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Actions;

public class MoveByOffset {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Selectable.html");

        WebElement three = driver.findElement(By.name("three"));
        Point location = new Point(0,0);
        location = three.getLocation();
        System.out.println(location.getX());
        System.out.println(location.getY());
        //OR
        System.out.println("X coordinate: "+three.getLocation().getX());
        System.out.println("Y coordinate: "+three.getLocation().getY());
        Actions builder = new Actions(driver);
        builder.moveByOffset(three.getLocation().getX()+1, three.getLocation().getY()+1).click();
        //Actions newbuilder = builder.moveByOffset(three.getLocation().getX()+1, three.getLocation().getY()+1);
        //builder.click();
        builder.build().perform();
    }
}
