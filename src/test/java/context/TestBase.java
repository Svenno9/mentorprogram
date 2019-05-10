package context;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    protected WebDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        // running with selenium server on jenkins
        //ChromeOptions chromeOptions = new ChromeOptions();
        //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);

        // running localy
        System.setProperty("webdriver.chrome.driver", "C:\\tmp\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.close(); //closes browser
        driver.quit(); //quits session
    }
}
