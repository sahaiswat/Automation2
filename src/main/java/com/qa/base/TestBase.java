package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import com.qa.util.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	/**
	 * Code to pick up browser details for the config file and initiate the browser driver and then launch the URL defined in the config file.
	 * Browser and URL paramaters picked up from the config.properties file
	 */

	
	public TestBase() {
		
		prop= new Properties();
		FileInputStream fis;
		try {
			fis = new FileInputStream

					("C:\\Users\\ssinha\\eclipse-workspace\\Ubiquity\\src\\main\\java\\com\\qa\\config\\config.properties");
					try {
						prop.load(fis);
					} catch (FileNotFoundException e) {
							e.printStackTrace();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
					
			}

	
	public static void initialization()
	{
		prop.getProperty("browser");
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		String osname =System.getProperty("os.name").toLowerCase();
		
		if (osname.contains("windows") && prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		} else if (osname.contains("mac os") && prop.getProperty("browser").contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\ssinha\\\\Desktop\\\\driver\\\\chromedriver.exe");
		}

	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}

	
	public void TearDown()
	{
		driver.quit();
	}
}
