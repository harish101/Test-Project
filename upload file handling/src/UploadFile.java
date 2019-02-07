import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//uploading word document only

public class UploadFile {

	public static void main(String[] args) throws Exception {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		
		WebElement element = driver.findElement(By.id("pickfiles"));
		element.click();
		Robot r = new Robot();
		r.setAutoDelay(3000);
		String path = "C:\\Users\\user\\Desktop\\demo1.txt";
		StringSelection s = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
		r.setAutoDelay(3000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.setAutoDelay(3000);
	/*	for(int i=1;i<4;i++) {           //if we want to click on cancel button 
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
		}   */
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		boolean b = driver.findElement(By.id("uploadfiles")).isDisplayed();		
		if(b==true) {
			System.out.println("upload file successfully");
		}
		else {
			System.out.println("file not uploaded");
		}
		if(!path.contains(".docx")) {
			System.out.println(driver.findElement(By.className("bootbox-body")).getText());
		}
		
		driver.close();
	}

}
