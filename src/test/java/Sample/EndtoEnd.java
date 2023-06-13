package Sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class EndtoEnd
{
    public static void main(String args[]) throws InterruptedException {
        String productName = "zara coat 3";
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://rahulshettyacademy.com/client/");
        driver.findElement(By.id("userEmail")).sendKeys("mouni95.j@gmail.com");
        driver.findElement(By.id("userPassword")).sendKeys("Angel@2020");
        driver.findElement(By.id("login")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        List<WebElement> allProducts = driver.findElements(By.cssSelector(".offset-md-0"));
        WebElement prod = allProducts.stream().
             filter(product->product.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productName)).
                findFirst().orElse(null);
       //prod.findElement(By.cssSelector(".card-body button:last-of-type")).click(); //why he have used this
        prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
//wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector(".btn.btn-custom"))));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//
//       wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
    //   Thread.sleep(1000);
        //how to write indexing for css
       List<WebElement> cart = driver.findElements(By.cssSelector(".btn.btn-custom"));
       WebElement cartButton=cart.stream().filter(ca->ca.getText().contains("Cart")).findFirst().orElse(null);
        System.out.println(cartButton.getText());
        wait.until(ExpectedConditions.elementToBeClickable(cartButton));
       cartButton.click();

//       // driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
//        List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//        Boolean match = cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
//        Assert.assertTrue(match);
//        driver.findElement(By.cssSelector(".totalRow button")).click();
//        Actions action = new Actions(driver);
//        action.sendKeys(driver.findElement(By.cssSelector("[placeholder ='Select Country']")),"india").perform();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//       // driver.findElement(By.)


        //y for country dropdown we need to mention wait explicitly when we mentioned implicit wait





    }
}
