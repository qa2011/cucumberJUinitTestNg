package com.global;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.pages.DashboardPage;
import com.qa.pages.HomePage;
import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ManufacturingOrdersPage;
import com.qa.pages.ProductsPage;
import com.report.Reporter;
import com.util.common.TestUtility;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;
	public static final String CHROME_DRIVER_PATH = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 5;
	public static String ProductName="MyProduct424";
	public static int productqtyTxt=11;
	public static String email;
	public static String pass;
	
	public LoginPage loginpage;
	public DashboardPage dashboardpage;
	public InventoryPage inventorypage;
	public ProductsPage productpage;
	public ManufacturingOrdersPage manufacturingpage;
	public HomePage homepage;
	
	

	
	
	//@BeforeSuite
	public void Base(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\config.properties");
			prop.load(ip);
			
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\resources\\Log4j.properties");
			
			email=prop.getProperty("CSA_userEmail");
			pass=prop.getProperty("CSA_userPass");
			
		} catch (Exception e) {
			Reporter.error(e.getMessage());
		} 
	}
	
	
	public void setUp() throws InterruptedException{
		System.out.println("setUp");
		initializeFramework(prop.getProperty("url"));
	}

	public static void initializeFramework(String url) throws InterruptedException{
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "");	
			driver = new FirefoxDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
		TimeUnit.SECONDS.sleep(2);
		TestUtility.BrowserAndOSDetails();
		driver.get(url);
		TimeUnit.SECONDS.sleep(2);
	}

}
