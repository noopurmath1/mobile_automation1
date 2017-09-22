package mobile_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Setup {
	
	HashMap<String, String> propMap = new HashMap();
	
	
	public WebDriver launch() throws IOException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName" , Platform.ANDROID);
		capabilities.setVersion("6.0.1");
		capabilities.setCapability("deviceName", "moto g3");
		//capabilities.setCapability("appActivity", "com.digitalchemy.calculator.droidphone.CalculatorMainActivity");
		//capabilities.setCapability("appPackage", "com.digitalchemy.calculator.freedecimal");
		capabilities.setCapability("app","G:/study/mobile_test/com.digitalchemy.calculator.freedecimal-5.2.5@APK4Fun.com.apk");
		WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		read();
		return driver;
	}
	
	public void read() throws IOException{
		Properties prop = new Properties();
		InputStream input;
		System.out.println(prop.getClass());
		System.out.println(prop.getClass().getClassLoader());
		System.out.println(prop.getClass().getResourceAsStream("/xpath.properties"));
		input = prop.getClass().getResourceAsStream("/xpath.properties");
		if(prop!=null)
			prop.load(input);
		Set<String> propNames = prop.stringPropertyNames();
		for(String p : propNames){
			propMap.put(p , prop.getProperty(p));
			System.out.println(p);
			System.out.println(prop.getProperty(p));
		}
	}
	
	public String getProp(String key){
		return propMap.get(key);
	}

}
