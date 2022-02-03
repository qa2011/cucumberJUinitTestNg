package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.global.BaseClass;
import com.util.common.TestUtility;

public class HomePage extends BaseClass{
	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Page Factory - OR:
	@FindBy(xpath="//a[contains(@class,'log-in-link')]") 
	@CacheLookup
	public WebElement loginLink;
	
	@FindBy(id="password")
	@CacheLookup
	public WebElement passwordtxt;

	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	public WebElement loginBtn;
	
	public boolean loginInMyAccount() {
		boolean flag=TestUtility.clickOn(driver, loginLink, 2);
		return flag;
	}






}








