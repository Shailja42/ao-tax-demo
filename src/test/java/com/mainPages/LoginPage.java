package com.mainPages;

import java.awt.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.utils.CommonUtils;

public class LoginPage extends CommonUtils {
	public static Map<String, String> xpaths;

	// WebDriver driver;
	public void loadData() throws IOException {
		xpaths = new HashMap<>();
		Properties obj = new Properties();
		FileInputStream objfile = new FileInputStream(
				"C:\\work-stuff\\workspace\\ao-tax\\src\\test\\java\\com\\objectrepository\\iotax\\application.properties");
		obj.load(objfile);
		for (String key : obj.stringPropertyNames()) {
			String value = obj.getProperty(key);
			xpaths.put(key, (value));
		}
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		driver = new ChromeDriver();

	}

	public void launch() throws IOException {
		loadData();
		System.setProperty("webdriver.chrome.driver", "Driver\\chromedriver.exe");
		driver.get(xpaths.get("AppUrl"));
		driver.manage().window().maximize();
	}

	public void login() throws IOException, InterruptedException {
		readExcelData();
		Thread.sleep(1000);
		driver.findElement(By.xpath(xpaths.get("email_xpath"))).sendKeys(user_name);
		driver.findElement(By.xpath(xpaths.get("password_xpath"))).sendKeys(pwd_value);
		driver.findElement(By.xpath(xpaths.get("logon_xpath"))).click();
     Thread.sleep(5000);
		java.util.List<WebElement> ticketlist = driver.findElements(By.xpath(xpaths.get("ticket_status_xpath")));

		int size = ticketlist.size();
		System.out.println("size is "+size);
		for (int i = 0; i < size; i++) {

			String options = ticketlist.get(i).getText();
			System.out.println("All ticekt status are " + options);
			if (!options.equalsIgnoreCase("Close")) {
				driver.findElement(By.xpath(xpaths.get("ticket_status_xpath"))).click();
				break;
			}

		}

	}

}
