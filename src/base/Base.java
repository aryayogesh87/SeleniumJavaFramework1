package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {
	    public WebDriver driver;
	    public Properties properties;

		public void setup() {
	    	WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
	       	       
	        // Load properties from config file
	        properties = new Properties();
	        try (FileInputStream fis = new FileInputStream("resources\\config.properties")) {
	            properties.load(fis);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        // Set up WebDriver according to properties
	        String browser = properties.getProperty("browser", "chrome");
	        if (browser.equalsIgnoreCase("chrome")) {
	            WebDriverManager.chromedriver().setup();
	            driver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            WebDriverManager.edgedriver().setup();
	            driver = new EdgeDriver();
	        }

	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));	
	    	}
	    
	    @AfterMethod
	    public void tearDown() {
	        // Close the browser and quit the driver
	        if (driver != null) {
	         // driver.quit();
	        }
	}
	}