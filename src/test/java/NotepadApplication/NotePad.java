package NotepadApplication;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class NotePad {

	public static WindowsDriver driver = null ;

	@BeforeClass
	public void Setup() throws IOException, InterruptedException 
	{
		Desktop desktop = Desktop.getDesktop();
		desktop.open(new File("C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe"));
		Thread.sleep(2000);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("appium:app", "C:\\Windows\\System32\\notepad.exe");
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "WindowsPC");
		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}

	@Test
	public void WriteInNotepad ()
	{

		WebElement TextEditor = driver.findElement(By.name("Text Editor"));
		TextEditor.sendKeys("I am a software test engineer");
		WebElement Format = driver.findElement(By.name("Format"));
		Format.click();
		WebElement Font = driver.findElement(By.id("33")); 
		Font.click();
		WebElement FontStyle = driver.findElement(By.name("Forte"));
		FontStyle.sendKeys(Keys.ENTER);
		WebElement File = driver.findElement(By.name("File")); 
		File.click();
		WebElement Save = driver.findElement(By.id("3")); 
		Save.click();
		WebElement FileName = driver.findElement(By.id("1001")); 
		FileName.sendKeys("NotePad File");
		WebElement SaveBtn = driver.findElement(By.name("Save")); 
		SaveBtn.click();		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
