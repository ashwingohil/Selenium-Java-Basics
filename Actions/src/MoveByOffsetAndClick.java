import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.CompositeAction;

public class MoveByOffsetAndClick {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Selectable.html");

        /*
        WebElement class: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html
        It is an interface which extends SearchContext and TakesScreenshot. So it cannot be instantiated. WebDriver is
        another interface containing abstract methods. ChromeDriver class extends RemoteWebDriver which implements
        WebDriver. So we create an instance of ChromeDriver class and use methods in WebElement.
         */

        /*
        By Package: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/By.html
        By Package contains static sub classes classes. Contains static methods so called as By.method
        WebElement contains method findElement(By by). It returns WebElement instance so we contain data in that variable
         */

        /*
        Open Chrome browser and inspect the element by pointing on tile1. You will see name attribute with value one.
        Now we will get location where the method is in WebElement class. It returns Point Class instance.
        Location is the top left-hand corner of the element. Now on inspecting look into the CSS section below where
        we get the dimensions of the web-element that is tile1. Width is 100 and height is 80 and below is shown the
        border which is 1.
        Point Class: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/Point.html
        It inherits java.lang.Object. Contains a constructor(int x, int y).
        getlocation() method returns Point object.
        */

        WebElement one = driver.findElement(By.name("one"));
        WebElement eleven = driver.findElement(By.name("eleven"));
        WebElement five = driver.findElement(By.name("five"));

        int border = 1;
        int tileWidth = 100;
        int tileHeight = 80;

        /*
        Actions class: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/Actions.html
        One constructor is constructor(Webdriver driver)
        So we instantiate an object of Actions
        moveByOffset method is defined in actions.
        Composite Action: https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/interactions/CompositeAction.html
        One of the implementing class is Action. So object of Action will be used. Moreover Actions contain method build
        which returns an Action object. Action contains method perform.
        Below three lines can be written like this:

        Actions builder = new Actions(driver);
        builder.moveByOffset(one.getLocation().getX()+border, one.getLocation().getY()+border).click();
        Action object = new CompositeAction();
        object = builder.build();
        object.perform();
         */




        Actions builder = new Actions(driver);
        builder.moveByOffset(one.getLocation().getX()+border, one.getLocation().getY()+border).click();
        builder.build().perform();


        /*
        The above 3 lines can be written as below:
        WebElement instance can get location which returns Point object

        Point locationObject = new Point(0,0); //instantiating an object
        locationObject = one.getLocation();
        int xValue;
        int yValue;
        xValue = locationObject.getX();
        yValue = locationObject.getY();
        builder.moveByOffset(xValue+border, yValue+border).click();
        builder.build().perform();
        */


        builder.moveByOffset(2*tileWidth+4*border, 2*tileHeight+4*border).click();
        builder.build().perform();

        builder.moveByOffset(-2*tileWidth-4*border, -tileHeight-2*border).click();
        builder.build().perform();

        /*
        Now lets say we want to click in the middle of the webElement tile12. We use other method click() in Actions
        class. So we are not moving in offSets but clicking in the middle of WebElement
         */

        WebElement twelve = driver.findElement(By.name("twelve"));
        builder.click(twelve);
        builder.build().perform();

        WebElement nine = driver.findElement(By.name("nine"));
        WebElement ten = driver.findElement(By.name("ten"));
        builder.click(nine).click(ten).build().perform();
    }
}
