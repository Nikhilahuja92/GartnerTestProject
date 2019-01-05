package objectRepository;

import org.openqa.selenium.By;

public class ProductListPage {

	public By txtboxApiKey = By.id("mat-input-0");
	public By btnAddProduct = By.xpath("//span[text()='Add Product']");
	public By txtProductList = By.xpath("//*[text()='Product List']");
	public By btnRefresh = By.xpath("//span[text()='Refresh']");
	public By productnames = By.xpath("//td[@class='mat-cell cdk-column-Name mat-column-Name ng-star-inserted']");
	public By btnEdit = By.xpath("//tr[1]//button[@title='Edit']");
}
