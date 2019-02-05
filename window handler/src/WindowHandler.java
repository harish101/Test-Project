import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandler {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\selenium drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F%3Ftab%3Dwm&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.findElement(By.linkText("Help")).click();
		driver.findElement(By.linkText("Privacy")).click();
		driver.findElement(By.linkText("Terms")).click();
		System.out.println("before switching");
		System.out.println(driver.getTitle());
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids.size());
		Iterator<String> itr = ids.iterator();
		String parent = itr.next();
		String child1 = itr.next();
		String child2 = itr.next();
		String child3 = itr.next();
		System.out.println("after switching");
		driver.switchTo().window(child1);
		System.out.println(driver.getTitle());
		driver.switchTo().window(child2);
		System.out.println(driver.getTitle());
		driver.switchTo().window(child3);
		System.out.println(driver.getTitle());
		System.out.println("return to parent");
		driver.switchTo().window(parent);
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
