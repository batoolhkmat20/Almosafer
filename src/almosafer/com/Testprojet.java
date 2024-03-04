package almosafer.com;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testprojet {
	WebDriver driver = new ChromeDriver();
String websit="https://www.almosafer.com/ar/hotel/details/atg/%D9%81%D9%86%D8%AF%D9%82-%D9%83%D8%B1%D8%A7%D9%88%D9%86-%D8%B1%D9%88%D8%B2-1798809";
	String websit1="https://www.almosafer.com/en";
@BeforeTest
	public void sutup() {
	
	driver.manage().window().maximize();}
	@Test(enabled = false)
	public void printallthefeedback() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
driver.get(websit);
WebElement bo=driver.findElement(By.cssSelector(".sc-jrIrqw.giSwMU"));
WebElement link=driver.findElement(By.cssSelector(".cta__button.cta__saudi.sc-hEsumM.hrmypP.btn.btn-primary"));
link.click();	
driver.get(websit);
WebElement taqe=driver.findElement(By.xpath("//a[contains(text(),'التقييمات')]"));
taqe.click();
Thread.sleep(1000);
WebElement firstit=driver.findElement(By.cssSelector("div[class='sc-bkypNX flewFU'] span:nth-child(1)"));
firstit.getText();
System.out.println(firstit);	

List<WebElement> feedbackElements = driver.findElements(By.className("iPdku"));
for( int i=0;i<feedbackElements.size();i++)		
{  String allfeedba=feedbackElements.get(i).getText();  
	System.out.println(allfeedba);	
}		
	}
 @Test(enabled = false)
 public void hoteltabsection() {
	 driver.get(websit1);
String [] cities= {"amman","dubai","jeddah","muscat"};
Random rand = new Random();
int Randomen=rand.nextInt(cities.length);

	 WebElement welo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button[1]"));
		welo.click();
	 WebElement hotel=driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
	 hotel.click();
WebElement hotelTap=driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
hotelTap.sendKeys(cities[Randomen] + Keys.ENTER);
driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click();
	 
 }
 @Test(enabled = false)
 public void vistornumber() {
	 driver.get(websit1);	 
	 WebElement welo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button[1]"));
		welo.click();
	 WebElement hotel=driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
	 hotel.click(); 
	 WebElement mySelectElement = driver
				.findElement(By.xpath("//select[@class='tln3e3-1 eFsRGb']"));
		Select selector = new Select(mySelectElement);
		selector.selectByVisibleText("1 Room, 1 Adult, 0 Children");
 }
     @Test(enabled = false)
     public void Date() {
    	 driver.get(websit1);	 
    	 WebElement welo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button[1]"));
    		welo.click();
    		WebElement hotel=driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
    		 hotel.click(); 
       	 WebElement begining  = driver.findElement(By.xpath("//*[@id=\"js-hotelsSearchBoxDatePickerCheckInDate\"]"));
       	 begining.click();
       	 WebElement checkInDate = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[5]/div[5]"));
         checkInDate.click();
       	 WebElement end   = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[2]/div/div/div[1]/div[2]"));
       	end.click();
       	 WebElement checkoutDate = driver.findElement(By.xpath("//*[@id=\"uncontrolled-tab-example-tabpane-hotels\"]/div/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div[6]"));
       	checkoutDate .click();
       	 
// 		LocalDate today = LocalDate.now();
//       	int epeteddebaturedate = today.plusDays(1).getDayOfMonth();
//		int epeteddatereturn = today.plusDays(2).getDayOfMonth();
//    	 
     }

 @Test()
 public void printtotheconsolethefirstresult() throws InterruptedException {
	 
	 driver.get(websit1);
	 String [] cities= {"amman","dubai","jeddah","muscat"};
	 Random rand = new Random();
	 int Randomen=rand.nextInt(cities.length);

	 	 WebElement welo = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/div/button[1]"));
	 		welo.click();
	 	 WebElement hotel=driver.findElement(By.cssSelector("#uncontrolled-tab-example-tab-hotels"));
	 	 hotel.click();
	 WebElement hotelTap=driver.findElement(By.cssSelector("input[placeholder='Search for hotels or places']"));
	 hotelTap.sendKeys(cities[Randomen] + Keys.ENTER);
	 driver.findElement(By.xpath("//button[@data-testid='HotelSearchBox__SearchButton']")).click();
	//  sc-lnrBVv bwbOtR
	 Thread.sleep(5000);
	 WebElement firstresult =driver.findElement(By.className("bwbOtR"));
	String result= firstresult.getText();
	System.out.println(result+"the hotel first");
	 
 }
     
	@AfterTest
	public void end() {}
}
