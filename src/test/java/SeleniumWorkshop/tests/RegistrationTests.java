package SeleniumWorkshop.tests;

import static org.junit.Assert.assertTrue;

import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.loader.LoaderType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import SeleniumWorkshop.pages.PageObjectManager;
import SeleniumWorkshop.patch.org.easetech.easytest.annotation.DataLoader;
import SeleniumWorkshop.patch.org.easetech.easytest.runner.DataDrivenTestRunner;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = { "src/test/resources/registrationTests.xml" }, loaderType = LoaderType.XML, writeData = false)
public class RegistrationTests {

	private static final String PAGE_URL = "http://newtours.demoaut.com";

	private WebDriver driver;
	private PageObjectManager manager;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		manager = new PageObjectManager(driver);
		driver.get(PAGE_URL);
	}

	@Test
	public void registerUserTest(@Param(name = "userName") String userName, @Param(name = "password") String password,
			@Param(name = "firstName") String firstName, @Param(name = "lastName") String lastName,
			@Param(name = "phoneNumber") String phoneNumber, @Param(name = "email") String email,
			@Param(name = "address1") String address1, @Param(name = "address2") String address2,
			@Param(name = "city") String city, @Param(name = "state") String state,
			@Param(name = "postalCode") String postalCode, @Param(name = "country") String country) {
		manager.getHomePage().clickOnRegisterLink();
		manager.getRegistrationPage().inputContactInformationForm(firstName, lastName, phoneNumber, email);
		manager.getRegistrationPage().inputMailingInformationForm(address1, address2, city, state, postalCode, country);
		manager.getRegistrationPage().inputUserInformationForm(userName, password, password);
		manager.getRegistrationPage().clickOnSubmitButton();
		manager.getRegistrationConfirmationPage().clickOnSignInLink();
		manager.getLoginPage().userLogin(userName, password);
		assertTrue(manager.getHomePage().isUserIsLoggedIn());
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}