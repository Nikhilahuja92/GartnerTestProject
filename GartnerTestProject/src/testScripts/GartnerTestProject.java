package testScripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import businessComponents.FunctionalComponents;
import objectRepository.AddProductPage;

public class GartnerTestProject {
	FunctionalComponents func = new FunctionalComponents();	
	AddProductPage addPage = new AddProductPage();
	
  @BeforeMethod
  public void InitializeTest() {
	  func.LaunchBrowser();
  }
  
  @Test(priority=1)
  public void VerifyAddProductFunctionality()
  {
	  //Enter API Key
	  func.EnterApiKey();	 
	  
	  //Click Add Product
	  func.ClickAddProduct();
	  
	  //Add All product properties
	  func.AddAllProductProperties();
	  
	  //ClickSave
	  func.ClickSave(addPage.txtAddProduct);
  }
  
  @Test(priority=2)
  public void VerifyEditProductFunctionality() throws InterruptedException
  {
	  //Enter API Key
	  func.EnterApiKey();
	
	  //Edit existing Product
	  func.EditProduct();
		  
	  //ClickSave
	  func.ClickSave(addPage.txtEditProduct);	  
  }
  
  @AfterMethod
  public void CleanUp()
  {
	  func.CloseBrowser();
  }
  
}
