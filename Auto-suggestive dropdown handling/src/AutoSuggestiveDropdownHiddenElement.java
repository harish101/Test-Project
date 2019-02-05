import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestiveDropdownHiddenElement {

	public static void main(String[] args) throws Exception {

		// setting path of the driver for the chrome browser
		System.setProperty("webdriver.chrome.driver", "D:\\selenium drivers\\chromedriver.exe");
		// launching chrome browser
		WebDriver driver = new ChromeDriver();
		// browser navigate to required url
		driver.get("https://ksrtc.in/oprs-web/");
		// maximizing the browser
		driver.manage().window().maximize();
		// handling leaving from auto-suggestive dropdown box
		String Exp = "banahatti";
		String passing="ban";
		WebElement element = driver.findElement(By.id("fromPlaceName"));
		element.sendKeys(passing);
		// retriving element using javascript DOM
		String Act = passing;	
		int j = 1;
		while (!Act.equalsIgnoreCase(Exp)) {
			j++;
			element.sendKeys(Keys.DOWN);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "return document.getElementById(\"fromPlaceName\").value;";
			Act = (String) js.executeScript(script);
			if (Act.equalsIgnoreCase(Exp)) {
				element.sendKeys(Keys.ENTER);
				System.out.println("element found");
				break;
			}
			if (j > 15) {
				System.out.println("element not found");
				break;
			}
			Thread.sleep(3000);
		}
		driver.close();

	}

}
