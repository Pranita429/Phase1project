package test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 

		        System.setProperty("webdriver.chrome.driver","chromedriver.exe");

		        WebDriver driver = new ChromeDriver();

		        //Launch Amazon.in
		        driver.get("https://www.amazon.in/");
		        driver.manage().window().maximize();
		        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		        //Getting Parent Window Handler
		        String ParentWin = driver.getWindowHandle();
		        //Search for Samsung
		        
		        WebElement SearchInput = driver.findElement(By.id("twotabsearchtextbox"));
		        SearchInput.sendKeys("Samsung");

		    
		        
		        //Click Search Button
		        Thread.sleep(3000);
		        WebElement SearchButton = driver.findElement(By.id("nav-search-submit-button"));
		        SearchButton.click();

		        //Print Product Details and Price
		        //div[@data-component-type='s-search-result']//h2  or   //div[@class='a-section']//span[starts-with(text(),'Samsung ')]

		        List<WebElement> ProductDesc = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2/a"));
		        System.out.println("Total num of links are " + ProductDesc.size());
		        List<WebElement> ProductPrice = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price']"));

		        for(int index=0;index<ProductDesc.size();index++) {

		            System.out.print(ProductDesc.get(index).getText() + "Price : Rupees ");
		            System.out.println(ProductPrice.get(index).getText());
		        }

		        //Fetch string to validate on Parent Window
		        String toValidate = ProductDesc.get(0).getText();
		        System.out.println(toValidate);

		        // Click on First Product Link
		        ProductDesc.get(0).click();

		        //Validation of Header String parent and child windows

		        Set<String> allWinHan = driver.getWindowHandles();
		        System.out.println("Before Clicking Tab button the win is " + ParentWin);

		        //Switching Window Handlers
		        for(String win:allWinHan){
		            if(!win.equals(ParentWin)){
		                driver.switchTo().window(win);
		            }
		        }

		        //zfetch Header String on child window
		        WebElement HeadingOnNewTab = driver.findElement(By.xpath("//div[@id='title_feature_div']//span"));
		        String headerString = HeadingOnNewTab.getText();
		        System.out.println(headerString);

		        //Validating
		        if(headerString.equals(toValidate)){
		            System.out.println("TC Passed");
		        }else {
		            System.out.println("TC Failed");
		        }
		
	}

}
