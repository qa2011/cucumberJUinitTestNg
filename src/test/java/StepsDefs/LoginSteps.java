package StepsDefs;

import java.util.List;

import org.testng.asserts.SoftAssert;

import com.global.BaseClass;
import com.qa.pages.DashboardPage;
import com.qa.pages.HomePage;
import com.qa.pages.InventoryPage;
import com.qa.pages.LoginPage;
import com.qa.pages.ManufacturingOrdersPage;
import com.qa.pages.ProductsPage;
import com.util.common.TestUtility;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends BaseClass{
	SoftAssert s_assert;

	public LoginSteps() throws InterruptedException {
		Base();
		setUp();
		loginpage = new LoginPage();
		dashboardpage=new DashboardPage();
		inventorypage=new InventoryPage();
		productpage=new ProductsPage();
		manufacturingpage=new ManufacturingOrdersPage();
		homepage=new HomePage();
	}
	
	


	@Given("^User on the Login page$")
	public void user_on_the_login_page() {
		s_assert = new SoftAssert();
		System.out.println("Home Page title ::"+TestUtility.getTitlePage(driver));
		boolean flag=homepage.loginInMyAccount();
		System.out.println(flag);
		System.out.println("Login Page title ::"+TestUtility.getTitlePage(driver));
		s_assert.assertAll();	

	}

	@When("^Login with CSA credential$")
	public void login_with_csa_credential(DataTable usercredentials) {
		s_assert = new SoftAssert();
		/*boolean flag=loginpage.userLogin(email, pass);
		System.out.println(flag);*/
		
		List<List<String>> data = usercredentials.raw();
		boolean flag=loginpage.userLogin(data.get(0).get(0), data.get(0).get(1));
		System.out.println(flag);
		System.out.println("DashboardPage title ::"+TestUtility.getTitlePage(driver));
		s_assert.assertAll();	
	}

	@Then("^validate title after login$")
	public void validate_title_after_login() {
		s_assert = new SoftAssert();
		System.out.println("Dashboard page title ::"+TestUtility.getTitlePage(driver));
		s_assert.assertAll();	
	}

	@And("^Close browser$")
	public void Close_browser() {
		System.out.println("close");
		driver.close();
		//driver.quit();
	}
	
}
