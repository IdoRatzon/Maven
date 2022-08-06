import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ProjectTest {

    @BeforeClass

    public static void setupClass() {
        WebDriverManager.chromiumdriver().setup();


    }

    @Test

    public void testOne() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }

    @Test

    public void testTwo() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.GOOGLEURL);
        driver.manage().window().fullscreen();
        Thread.sleep(3000);
        driver.quit();
    }

    @Test

    public void testThree() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.navigate().to(Helper.PLUMBHURL);
        Thread.sleep(3000);
        driver.quit();
    }

    @Test

    public void testFour() {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.PLUMBHURL);
        WebElement loginfield = driver.findElement(By.id(Helper.USERNAMEID));
        loginfield.sendKeys(Helper.USERNAME);

        WebElement loginphone = driver.findElement(By.id(Helper.PHONEID));
        loginphone.sendKeys(Helper.POHNE);
        WebElement loginEmail = driver.findElement(By.id(Helper.EMAILID));
        loginEmail.sendKeys(Helper.EMAIL);
        WebElement loginBtn = driver.findElement(By.id(Helper.LOGINBTNID));
        loginBtn.click();
        driver.quit();
    }

    @Test

    public void testFive() {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.PLUMBHURL);
        String text = driver.findElement(By.id("copyright")).getText();
        System.out.println(text);
        driver.quit();
    }

    @Test

    public void testSix() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get(Helper.PLUMBHURL);

        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(Helper.SAVEFOLDER + Helper.JPG));
        driver.quit();
    }


}
