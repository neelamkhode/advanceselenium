package POMRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationCreationPage {
	public OrganizationCreationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	
    //Declaration
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement organizationCreateImage;
	
	@FindBy(name="accountname")
	private WebElement organizationNamesTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	
	//getter Methods
	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getOrganizationNamesTextField() {
		return organizationNamesTextField;
	}
	
	public WebElement getOrganizationCreateImage() {
		return organizationCreateImage;
	}
	
	/**
	 * This Method is used for ClickOn +img
	 */
	public void clickOrganizationCreateImage()
	{
		organizationCreateImage.click();
	}

	/**
	 * This Method is used to Pass Value to Organization TextField
	 */
	public void organizationNamesTextField(String orgName)
	{
		organizationNamesTextField.sendKeys(orgName);
	}
	/**
	 * This Method is used to Save OrgName
	 */

	public void saveButton()
	{
		saveButton.click();	
	}

}
