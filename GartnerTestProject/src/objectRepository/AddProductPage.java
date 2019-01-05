package objectRepository;

import org.openqa.selenium.By;

public class AddProductPage {

	public By txtBoxName = By.id("mat-input-1");
	public By txtBoxDescription = By.id("mat-input-2");
	public By txtBoxUrl = By.id("mat-input-3");
	public By cmbBoxCategories = By.className("mat-select-arrow-wrapper");
	public By chkBoxEmail = By.xpath("//span[text()='Email']/preceding-sibling::mat-pseudo-checkbox");
	public By txtAddProduct = By.xpath("//h1[text()='Add Product']");
	public By txtEditProduct = By.xpath("//h1[text()='Edit Product']");
	public By btnSave = By.xpath("//span[text()='Save']");
}
