package businessComponents;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import objectRepository.AddProductPage;
import objectRepository.ProductListPage;

public class FunctionalComponents {

	String strPath ="C:\\Users\\Nikhil Ahuja\\Downloads\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	String url ="https://gdm-interview.azurewebsites.net/#/product/list";
	String strKey="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiI0NCIsInVuaXF1ZV9uYW1lIjoiaW50ZXJ2aWV3YXBpQGdhcnRuZXIuY29tIiwiZW1haWwiOiJpbnRlcnZpZXdhcGlAZ2FydG5lci5jb20iLCJuYmYiOjE1MzgxNDgzMTEsImV4cCI6MTU5ODE0ODI1MSwiaWF0IjoxNTM4MTQ4MzExfQ.xpaJPan1BjvkRuoP5JkAcBPYKTv2ajM5rlNcM9eU5BE";
	DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	Date date = new Date();
	ProductListPage productsPage = new  ProductListPage();
	AddProductPage addPage = new AddProductPage();
	
	public void LaunchBrowser()
	{
		  System.setProperty("webdriver.chrome.driver", strPath);
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.navigate().to(url);	  	  
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.txtProductList));
	}
	
	public void EnterApiKey()
	{		
		try
		{
		  driver.findElement(productsPage.txtboxApiKey).sendKeys(strKey);
		  driver.findElement(productsPage.btnRefresh).click();
		  Thread.sleep(5000);
		}
		catch(Exception ex)
		{System.out.println(ex.getMessage());}
	}
	
	public void ClickAddProduct()
	{
		try{
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.btnAddProduct));
		  driver.findElement(productsPage.btnAddProduct).click();
		  Thread.sleep(2000);
		}
		catch(Exception ex)
		{System.out.println(ex.getMessage());}
	}
	
	public void AddAllProductProperties()
	{
		try
		{
		  //EnterName		  
		  String strName= "Gmail"+(sdf.format(date)).toString();
		  driver.findElement(addPage.txtBoxName).sendKeys(strName);
		  
		  //EnterDescription
		  driver.findElement(addPage.txtBoxDescription).sendKeys("Gmail is a free email service developed by Google. Users can access Gmail on the web");
		  
		  //EnterUrl
		  driver.findElement(addPage.txtBoxUrl).sendKeys("http://www.Gmail.com");
		  
		  //SelectCategory Email
		  driver.findElement(addPage.cmbBoxCategories).click();
		  driver.findElement(addPage.chkBoxEmail).click();
		  Thread.sleep(3000);
		}
		catch(Exception ex)
		{System.out.println(ex.getMessage());}
	}
	
	public void ClickSave(By pageName)
	{
		try
		{
		  Actions act =new Actions(driver);
		  act.moveToElement(driver.findElement(pageName)).click().perform();
		  driver.findElement(addPage.btnSave).click();
		  Thread.sleep(3000);
		}
		catch(Exception ex)
		{System.out.println(ex.getMessage());}		  
	}
	
	public void EditProduct()
	{
		try
		{
		  WebDriverWait wait = new WebDriverWait(driver,10);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(productsPage.btnEdit));
		  if(driver.findElement(productsPage.btnEdit) !=null)
		  {
			  //ClickEdit Icon
			  driver.findElement(productsPage.btnEdit).click();
			  Thread.sleep(3000);
			  
			  //EnterName
			  driver.findElement(addPage.txtBoxName).clear();			  
			  String strName= "Gmail"+(sdf.format(date)).toString();
			  driver.findElement(addPage.txtBoxName).sendKeys(strName);
			  
			  //EnterDescription
			  driver.findElement(addPage.txtBoxDescription).clear();
			  driver.findElement(addPage.txtBoxDescription).sendKeys("Description is edited for "+strName);
			  
			  //SelectCategory Email
			  driver.findElement(addPage.cmbBoxCategories).click();			  
			  driver.findElement(addPage.chkBoxEmail).click();
			  Thread.sleep(5000);
		  }
		}
		catch(Exception ex)
		{System.out.println(ex.getMessage());}
	}
	
	public void CloseBrowser()
	  {
		  driver.close();
		  driver.quit();
	  }
}
