package javaselprac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Prog1 {

	public static void main(String[] args) throws InterruptedException {
		// setting chrome driver to selenium web driver
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Drivers\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//launching URL
		driver.get("http://www.newtours.demoaut.com");
		
		//maximizing browser window
		driver.manage().window().maximize();
		
		//To print title of web page in console
		System.out.println(driver.getTitle());
		
		//to print current URL in console
		System.out.println(driver.getCurrentUrl());
		
		//To print Complete page Source
		System.out.println(driver.getPageSource());
		
		//To print the title of the web page
		System.out.println(driver.getTitle());
		
		//To get the Window Handler on console
		System.out.println(driver.getWindowHandle());
		
		//To get all Cookies
		System.out.println(driver.manage().getCookies());
		
		//To Find/locate element by linkText or hyperLink
		//All links have an action method which we have to perform.
		//so we have to use Click method
		driver.findElement(By.linkText("REGISTER")).click();
		
		//Blind sleep in order to halt the process of our execution process so that we can observe all the actions
		//But Thread.sleep() is not a good practice.
		//So we will use wait methods in selenium in future
		Thread.sleep(4000);
		
		//we can locate elements by id,name,classname,tag,linktext,partiallinktext,cssselector,xpath
		/*To locate an element by name
		this is a textbox which require an input so we need to send keys as a string*/
		driver.findElement(By.name("firstName")).sendKeys("sowjanya");
		
		driver.findElement(By.name("lastName")).sendKeys("surisetty");
		
		driver.findElement(By.name("phone")).sendKeys("2778913");
		
		driver.findElement(By.id("userName")).sendKeys("sowjanya@gmail.com");
		
		driver.findElement(By.name("address1")).sendKeys("90_winwille_road");
		
		driver.findElement(By.name("address2")).sendKeys("56 lawrance road");
		
		driver.findElement(By.name("city")).sendKeys("Toronto");
		
		driver.findElement(By.name("state")).sendKeys("Ontario");
		
		driver.findElement(By.name("postalCode")).sendKeys("543278654");
		
		//Locating an element by name as country and assigning it to webelement
		WebElement e=driver.findElement(By.name("country"));
		
		//instantiating Select class with webelement object
				Select s=new Select(e);
				//Selecting value "CANADA" by the selectBYVisibleText method 
				s.selectByVisibleText("CANADA");
				
				//to get the text and to  print  in console.
				System.out.println(e.getText());
				
				//To get the  tag name and to print in the console.
				System.out.println(e.getTagName());
				
				
				
				Thread.sleep(4000);
				
		driver.findElement(By.name("email")).sendKeys("sowjanya"); 
		
		driver.findElement(By.name("password")).sendKeys("1234"); 
		
		driver.findElement(By.name("confirmPassword")).sendKeys("1234"); 
		
		driver.findElement(By.name("register")).click(); 
		
		Thread.sleep(2000);
		String Expected="Dear sowjanya surisetty,";
		//WebElement e1=driver.findElement(By.xpath("//*[text()=' Dear sowjanya surisetty,']"));
		WebElement e1=driver.findElement(By.xpath("//*[@src='/images/masts/mast_register.gif']/parent::td/parent::tr/following-sibling::tr[2]/td/p/font[1]/b"));
		//WebElement e1=driver.getTitle();
		
		System.out.println(e1.getText());
		String Actual=e1.getText();
		
		if(Actual.equals(Expected))
		{
			System.out.println("Registration is Passed");
		}
		else
		{
			System.out.println("Registration is Failed");
		}
		driver.close();
	}

}
