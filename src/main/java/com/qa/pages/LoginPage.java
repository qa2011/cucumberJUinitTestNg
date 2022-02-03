package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class LoginPage extends BaseClass{
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(xpath="//input[contains(@name,'LoginPortlet_login')]") 
	@CacheLookup
	public WebElement emailtxt;
	
	@FindBy(xpath="//input[contains(@name,'password')]")
	@CacheLookup
	public WebElement passwordtxt;

	@FindBy(xpath="//button[contains(@id,'login')]")
	@CacheLookup
	public WebElement loginBtn;

	public boolean userLogin(String email,String password) {
		boolean status=false;
		boolean emailFlag=TestUtility.sendKeys(driver, emailtxt,email,2);
		if (emailFlag) {
			boolean passwordFlag=TestUtility.sendKeysWithEncryption(driver, passwordtxt,password,2);
			if (passwordFlag) {
				status=TestUtility.clickOn(driver, loginBtn,2);
			}
		}
		return status;
	}





}








