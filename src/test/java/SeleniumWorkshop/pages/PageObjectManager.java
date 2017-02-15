package SeleniumWorkshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObjectManager {

	private final WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private RegistrationConfirmationPage registrationConfirmationPage;
	private RegistrationPage registrationPage;

	public PageObjectManager(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public HomePage getHomePage() {
		if (homePage == null) {
			homePage = PageFactory.initElements(driver, HomePage.class);
		}
		return homePage;
	}

	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
		}
		return loginPage;
	}

	public RegistrationConfirmationPage getRegistrationConfirmationPage() {
		if (registrationConfirmationPage == null) {
			registrationConfirmationPage = PageFactory.initElements(driver, RegistrationConfirmationPage.class);
		}
		return registrationConfirmationPage;
	}

	public RegistrationPage getRegistrationPage() {
		if (registrationPage == null) {
			registrationPage = PageFactory.initElements(driver, RegistrationPage.class);
		}
		return registrationPage;
	}

}