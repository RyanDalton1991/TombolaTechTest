package tombolaLogin;

import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import org.junit.Assert;


public class Functional_Tombola_Login_AllTests {
	
    private static final String LOGIN_PAGE_URL = "https://stage.tombola.co.uk/userauthenticationids/loginsso#/login";
	
	@Test
	public void TombolaFunctionalLoginPageTest001() {
		//Scenario : Validate when a user enter's their username and password into designated fields, they will be able to login and proceed to the Tombola home page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	    
	    //Enter login details
	    page.locator("input[name=\"LoginCredential\"]").click();
	    page.locator("input[name=\"LoginCredential\"]").fill("techtest1");
	    page.locator("input[name=\"Password\"]").click();
	    page.locator("input[name=\"Password\"]").fill("TechTest1!");
	    page.locator("#app div").filter(new Locator.FilterOptions().setHasText("Login to Please enter your")).nth(3).click();
	    //Click to login
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).click();	
	    // Wait for page to load
        page.waitForLoadState();
	    //Validate home page
	    page.locator("div").filter(new Locator.FilterOptions().setHasText("Welcome techtest1 We offer")).locator("span").first().click();
	    page.waitForSelector("text=britain's biggest bingo site");
	    boolean isBingoSiteVisible = page.getByText("britain's biggest bingo site", new Page.GetByTextOptions().setExact(true)).isVisible();	      
	    //Validate the page
        if (isBingoSiteVisible) {
            System.out.println("britain's biggest bingo site is visible");
        } else {       	
            System.out.println("britain's biggest bingo site is not visible");
    		System.out.println("TombolaFunctionalLoginPageTest001 Failed: ");
        }
        Assert.assertTrue("britain's biggest bingo site is visible", isBingoSiteVisible);
        
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest001 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest002() {
		//Scenario : Validate when a user enter's their username and password into designated fields and ticks the "remember me" check box, they will be able to login and proceed to the Tombola Home page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Enter login details
	    page.locator("input[name=\"LoginCredential\"]").click();
	    page.locator("input[name=\"LoginCredential\"]").fill("techtest1");
	    page.locator("input[name=\"Password\"]").click();
	    page.locator("input[name=\"Password\"]").fill("TechTest1!");
	    //Clicks "remember me"
	    page.locator("#app div").filter(new Locator.FilterOptions().setHasText("Login to Please enter your")).nth(3).click();
	    page.getByText("remember me").click();
	    //Click to login
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).click();	
	    // Wait for page to load
        page.waitForLoadState();
	    //Validate home page
	    page.locator("div").filter(new Locator.FilterOptions().setHasText("Welcome techtest1 We offer")).locator("span").first().click();
	    page.waitForSelector("text=britain's biggest bingo site");
	    boolean isBingoSiteVisible = page.getByText("britain's biggest bingo site", new Page.GetByTextOptions().setExact(true)).isVisible();	             
	    //Validate the page
        if (isBingoSiteVisible) {
            System.out.println("britain's biggest bingo site is visible");
        } else {       	
            System.out.println("britain's biggest bingo site is not visible");
    		System.out.println("TombolaFunctionalLoginPageTest002 Failed");
        }
        Assert.assertTrue("britain's biggest bingo site is visible", isBingoSiteVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest002 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest003() {
		//Scenario : Validate when a user has not entered a username or password into the required fields, the "log in" button is disabled
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps		
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }       
	    //Validate log in button is disabled        
        boolean isLoginButtonDisabled = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).isEnabled();	             
	    //Validate the page
        if (isLoginButtonDisabled) {
            System.out.println("The login button is enabled");
            System.out.println("TombolaFunctionalLoginPageTest003 Failed");
        } else {       	
            System.out.println("The login button is disabled");
        }
        Assert.assertFalse("The login button is enabled", isLoginButtonDisabled);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest003 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest004() {
		//Scenario : Validate when a user clicks on the "forgot your login details?" button they are navigated to the "Reset your password" page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
        
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Navigate to Reset your password page
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("forgot your login details?")).click();	
	    page.waitForTimeout(5000);
	    boolean isResetPasswordTitleVisible = page.waitForSelector("text=Reset your password").isVisible();	             
	    //Validate the page
        if (isResetPasswordTitleVisible) {
        	System.out.println("Reset your password is found");
        } else {       	
        	System.out.println("Reset your password is not found");
    		System.out.println("TombolaFunctionalLoginPageTest004 Failed");
        }
        Assert.assertTrue("Reset your password is found", isResetPasswordTitleVisible);
        
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest004 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest005() {
		//Scenario : Validate when a user clicks on the "Need Help?" tab they are able to see the "Phone support" icon
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Click on the Need Help? tab to display icons
	    page.getByText("Need Help?").click();
	    page.waitForTimeout(3000);
	    //Check the support icon is visible
        boolean isPhoneSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Phone Support")).isVisible();             
	    //Validate the page
        if (isPhoneSupportVisible) {
            System.out.println("Phone Support is visible");
        } else {       	
            System.out.println("Phone Support is not visible");
            System.out.println("TombolaFunctionalLoginPageTest005 Failed");
        }
        Assert.assertTrue("Phone Support is visible", isPhoneSupportVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest005 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest006() {
		//Scenario : Validate when a user clicks on the "Need Help?" tab they are able to see the "Live help" icon
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the Need Help? tab to display icons
	    page.getByText("Need Help?").click();	
	    page.waitForTimeout(3000);       
	    //Check the support icon is visible
        boolean isLiveSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("live help")).isVisible();              
	    //Validate the page
        if (isLiveSupportVisible) {
            System.out.println("Live Support is visible");
        } else {       	
            System.out.println("Live Support is not visible");
            System.out.println("TombolaFunctionalLoginPageTest006 Failed");
        }
        Assert.assertTrue("Live Support is visible", isLiveSupportVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest006 Passed");
	}
		
	@Test
	public void TombolaFunctionalLoginPageTest007() {
		//Scenario : Validate when a user clicks on the "Need Help?" tab they are able to see the "Email support" icon
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
        
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Click on the Need Help? tab to display icons
	    page.getByText("Need Help?").click();
	    page.waitForTimeout(3000);        
	    //Check the support icon is visible
        boolean isEmailSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Email Support")).isVisible();            
	    //Validate the page
        if (isEmailSupportVisible) {
            System.out.println("Email Support is visible");
        } else {       	
            System.out.println("Email Support is not visible");
            System.out.println("TombolaFunctionalLoginPageTest007 Failed");
        }
        Assert.assertTrue("Email Support is visible", isEmailSupportVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest007 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest008() {
		//Scenario : Validate when a user clicks on the "Need Help?" tab they can then dismiss the tab by clicking on "Close Help."
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Click on the Need Help? tab to display icons
	    page.getByText("Need Help?").click();	
	    page.waitForTimeout(3000);
	    //Click on the "Close Help" to dismiss icons
	    page.getByText("Close Help.").click();
	    page.waitForTimeout(3000);	            
	    //Check the Need Help? is visible
        boolean isNeedHelpVisible = page.getByText("Need Help?").isVisible();           
	    //Validate the page
        if (isNeedHelpVisible) {
            System.out.println("Need Help? is visible");
        } else {       	
            System.out.println("Need Help? is not visible");
            System.out.println("TombolaFunctionalLoginPageTest008 Failed");
        }
        Assert.assertTrue("Need Help? is visible", isNeedHelpVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest008 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest009() {
		//Scenario : Validate when a user clicks on the "T&Cs" text, they will be displayed the Terms and Conditions information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	
	    //Click on the T&Cs text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("T&Cs").setExact(true)).click();
	    page.waitForTimeout(3000);        
	    //Validate the terms and conditions popup is visible
        boolean isTermsAndConditionsVisible = page.getByText("Terms And Conditions").first().isVisible();	         
	    //Validate the page
        if (isTermsAndConditionsVisible) {
            System.out.println("Terms And Conditions is visible");
        } else {       	
            System.out.println("Terms And Conditions is not visible");
            System.out.println("TombolaFunctionalLoginPageTest009 Failed");
        }
        Assert.assertTrue("Terms And Conditions is visible", isTermsAndConditionsVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest009 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest010() {
		//Scenario : Validate when a user clicks on the "T&Cs" text, they will be displayed the Terms and Conditions information and can click on "Close" to dismiss the information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
        
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the T&Cs text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("T&Cs").setExact(true)).click();	
	    page.waitForTimeout(3000);
	    page.getByText("Terms And Conditions").first().isVisible();	
	    //Click on the Close button to dismiss documentation
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
	    page.waitForTimeout(3000);	
	    //Validate the terms and conditions popup is not visible
        boolean isTermsAndConditionsVisible = page.getByText("(TESTING) The following").first().isVisible();	         
	    //Validate the page
        if (isTermsAndConditionsVisible) {
            System.out.println("Terms And Conditions is visible");
            System.out.println("TombolaFunctionalLoginPageTest009 Failed");
        } else {       	
            System.out.println("Terms And Conditions is not visible");
        }
        Assert.assertFalse("Terms And Conditions is visible", isTermsAndConditionsVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest010 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest011() {
		//Scenario : Validate when a user clicks on the "Privacy Policy" text, they will be displayed the Privacy Policy information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the Privacy Policy text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Privacy Policy")).click();  
	    page.waitForTimeout(3000);
	    page.getByText("Privacy policy").first().isVisible();	       
	    //Validate the privacy policy popup is visible
        boolean isPrivacyPolicyVisible = page.getByText("Privacy policy").first().isVisible(); 	         
	    //Validate the page
        if (isPrivacyPolicyVisible) {
            System.out.println("Privacy policy is visible");
        } else {       	
            System.out.println("Privacy policy is not visible");
            System.out.println("TombolaFunctionalLoginPageTest011 Failed");
        }
        Assert.assertTrue("Privacy policy is visible", isPrivacyPolicyVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest011 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest012() {
		//Scenario : Validate when a user clicks on the "Privacy Policy" text, they will be displayed the Privacy Policy information and can click on "Close" to dismiss the information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the Privacy Policy text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Privacy Policy")).click();
	    page.waitForTimeout(3000);
	    page.getByText("Privacy policy").first().isVisible();	
	    //Click on the Close button to dismiss documentation
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Close")).click();
	    page.waitForTimeout(3000);
	    page.getByText("Privacy policy").first().isHidden();
	    page.getByText("Privacy policy").first().isVisible();	        
	    //Validate the privacy policy popup is not visible
        boolean isPrivacyPolicyVisible = page.getByText("As a “data controller” (").first().isVisible();	         
	    //Validate the page
        if (isPrivacyPolicyVisible) {
            System.out.println("Privacy policy is visible");
            System.out.println("TombolaFunctionalLoginPageTest012 Failed");
        } else {       	
            System.out.println("Privacy policy is not visible");
        }
        Assert.assertFalse("Privacy policy is visible", isPrivacyPolicyVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest012 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest013() {
		//Scenario : Validate when a user clicks on the "T&Cs apply" text on the banner, they will be displayed the Terms and Conditions information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the T&Cs apply text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("T&Cs apply")).click();
	    page.waitForTimeout(3000);       
	    //Validate the terms and conditions apply popup is visible
        boolean isTermsAndConditionsApplyVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("New player first deposit sign")).first().isVisible();		         
	    //Validate the page
        if (isTermsAndConditionsApplyVisible) {
            System.out.println("Terms and Conditions Apply is visible");
        } else {       	
            System.out.println("Terms and Conditions Apply is not visible");
            System.out.println("TombolaFunctionalLoginPageTest013 Failed");
        }
        Assert.assertTrue("Terms and Conditions Apply is visible", isTermsAndConditionsApplyVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest013 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest014() {
		//Scenario : Validate when a user clicks on the "T&Cs apply" text on the banner, they will be displayed the Terms and Conditions information and can click on "Close" to dismiss the information
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the T&Cs apply text to display documentation
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("T&Cs apply")).click();
	    page.waitForTimeout(3000);
	    //Click on the Close button to dismiss documentation
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("OK")).click();
	    page.waitForTimeout(3000);        
	    //Validate the terms and conditions apply popup is not visible
        boolean isTermsAndConditionsApplyVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("New player first deposit sign")).first().isVisible();		         
	    //Validate the page
        if (isTermsAndConditionsApplyVisible) {
            System.out.println("Terms and Conditions Apply is visible");
            System.out.println("TombolaFunctionalLoginPageTest014 Failed");
        } else {       	
            System.out.println("Terms and Conditions Apply is not visible");
        }
        Assert.assertFalse("Terms and Conditions Apply is visible", isTermsAndConditionsApplyVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest014 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest015() {
		//Scenario : Validate when a user clicks on the "Join now" button on the banner, they will be navigated to the Registration page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the Join now to be navigated to registration page
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Join now")).click();   
	    // Wait for page to load
	    page.waitForTimeout(5000);  
	    //Validate the registration page is visible
        boolean isRegistrationPageVisible = page.getByText("registration 1 of").first().isVisible();	         
	    //Validate the page
        if (isRegistrationPageVisible) {
            System.out.println("registration 1 of is visible");
        } else {       	
            System.out.println("registration 1 of is not visible");
            System.out.println("TombolaFunctionalLoginPageTest015 Failed");
        }
        Assert.assertTrue("registration 1 of is visible", isRegistrationPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest015 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest016() {
		//Scenario : Validate when a user clicks on the Safeplay Over 18s Only icon, they are navigated to the Tombola Safeplay information page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Safeplay page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Over 18s Only")).click();  
	    // Wait for page to load
        page.waitForLoadState();
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
	    //Validate the Safeplay page is visible    
        boolean isSafePlayPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Safeplay logo")).isVisible();  	         
	    //Validate the page
        if (isSafePlayPageVisible) {
            System.out.println("Safeplay Page is visible");
        } else {       	
            System.out.println("Safeplay Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest016 Failed");
        }
        Assert.assertTrue("Safeplay Page is visible", isSafePlayPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest016 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest017() {
		//Scenario : Validate when a user clicks on the Remote Gambling Gibralter Gambling Authority icon, they are navigated to the HM Government of Gibraltar Remote Gambling page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to HM Government of Gibralter Remote Gambling page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gibraltar Gambling Authority")).click(); 
	    // Wait for page to load
        page.waitForLoadState();       
	    //Validate the Remote Gambling Gibralter Gambling Authority page is visible    
        boolean isRemoteGamblingPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Remote Gambling")).isVisible();   	         
	    //Validate the page
        if (isRemoteGamblingPageVisible) {
            System.out.println("Remote Gambling Page is visible");
        } else {       	
            System.out.println("Remote Gambling Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest017 Failed");
        }
        Assert.assertTrue("Remote Gambling Page is visible", isRemoteGamblingPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest017 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest018() {
		//Scenario : Validate when a user clicks on the Gamcare icon, they are navigated to the Gamcare Gambling Harm Support page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Gamcare page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamcare")).click();
	    // Wait for page to load
        page.waitForLoadState();
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home link")).isVisible();
	    //Validate the Gamcare page is visible        
        boolean isGamcarePageVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Home link")).isVisible();   	         
	    //Validate the page
        if (isGamcarePageVisible) {
            System.out.println("Gamcare Page is visible");
        } else {       	
            System.out.println("Gamcare Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest018 Failed");
        }
        Assert.assertTrue("Gamcare Page is visible", isGamcarePageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest018 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest019() {
		//Scenario : Validate when a user clicks on the Safe Gambler Standard icon, they are navigated to the Safer Gambling Standard page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Safer Gambler Standard page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Safer Gambling Standard")).click();
	    // Wait for page to load
        page.waitForLoadState();        
	    //Validate the Safe Gambler Standard page is visible        
        boolean isSafeGamblerStandardPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Social Responsibility -")).isVisible();  	         
	    //Validate the page
        if (isSafeGamblerStandardPageVisible) {
            System.out.println("Safe Gambler Standard Page is visible");
        } else {       	
            System.out.println("Safe Gambler Standard Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest019 Failed");
        }
        Assert.assertTrue("Safe Gambler Standard Page is visible", isSafeGamblerStandardPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest019 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest020() {
		//Scenario : Validate when a user clicks on the Independent Betting Adjudication Service icon, they are navigated to the IBAS home page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to IBAS page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Independent Betting")).click();
	    // Wait for page to load
        page.waitForLoadState();
	    page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Welcome to IBAS: Independent")).isVisible();
	    //Validate the IBAS page is visible        
        boolean isIBASPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Welcome to IBAS: Independent")).isVisible();  	         
	    //Validate the page
        if (isIBASPageVisible) {
            System.out.println("IBAS Page is visible");
        } else {       	
            System.out.println("IBAS Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest020 Failed");
        }
        Assert.assertTrue("IBAS Page is visible", isIBASPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest020 Passed");
	}
	
//Test failed for me as the website for Gamble Aware is throwing an invalid certificate NET::ERR_CERT_COMMON_NAME_INVALID preventing access to the page on my browsers	
//	@Test
//	public void TombolaFunctionalLoginPageTest021() {
//		//Scenario : Validate when a user clicks on the Gamble Aware icon, they are navigated to the Gamble Aware home page
//		
//		//Launch browser - Chromium
//		Playwright pw = Playwright.create();
//		BrowserType browsertype = pw.chromium();
//		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page page = browser.newPage();
//	// Navigate to login page
//    page.navigate(LOGIN_PAGE_URL);
//		
//		//Test steps
	//Allow cookies if visible
//    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
//    //Validate the page
//    if (isAllowAllCookiesVisible) {
//    // Click the element if it is visible
//    	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
//    }
//	    //Click on the icon to be navigated to Gamble Aware page
//	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamble Aware")).click();     
//    // Wait for page to load
//    page.waitForLoadState();
//    boolean isGambleAwarePageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("")).isVisible(); 	         
//    //Validate the page
//    if (isIBASPageVisible) {
//        System.out.println("Gamble Aware Page is visible");
//    } else {       	
//        System.out.println("Gamble Aware Page is visible");
//        System.out.println("TombolaFunctionalLoginPageTest021 Failed");
//    }
//    Assert.assertTrue("IBAS Page is visible", isGambleAwarePageVisible);
//	    //Close browser
//	    browser.close();
//		System.out.println("TombolaFunctionalLoginPageTest021 Passed");
//	}
	
	@Test
	public void TombolaFunctionalLoginPageTest022() {
		//Scenario : Validate when a user clicks on the Gamstop icon, they are navigated to the Gamstop home page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		//Browser URL
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Gamstop page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamstop")).click();
	    // Wait for page to load
        page.waitForLoadState();
		//Accept cookies if visible
	    boolean isAcceptCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).isVisible();  
	    //Validate the page
        if (isAcceptCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept")).click();
        }
	    page.waitForTimeout(3000);
	    //Validate the Gamstop page is visible        
        boolean isGamstopPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("FREE ONLINE SELF-EXCLUSION")).isVisible(); 	         
	    //Validate the page
        if (isGamstopPageVisible) {
            System.out.println("Gamstop Page is visible");
        } else {       	
            System.out.println("Gamstop Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest022 Failed");
        }
        Assert.assertTrue("Gamstop Page is visible", isGamstopPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest022 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest023() {
		//Scenario : Validate when a user clicks on the Gambling Commission icon, they are navigated to the Gambling Commission home page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Gambling Commission page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gambling Commission")).click();
	    // Wait for page to load
        page.waitForLoadState();
	    //Validate the Gamstop page is visible        
	    boolean isGamblingCommissionPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tombola (International) Plc")).isVisible();         
	    //Validate the page
        if (isGamblingCommissionPageVisible) {
            System.out.println("Gambling Commission Page is visible");
        } else {       	
            System.out.println("Gambling Commission Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest023 Failed");
        }
        Assert.assertTrue("Gambling Commission Page is visible", isGamblingCommissionPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest023 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest024() {
		//Scenario : Validate when a user clicks on the Visa icon, they are navigated to the Tombola Online Bingo Payment Methods page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Payment Methods page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("visa").setExact(true)).click();
	    // Wait for page to load
        page.waitForLoadState();
	    page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Online bingo payment methods")).isVisible();
	    //Validate the Online bingo payment methods page is visible        
        boolean isOnlinePaymentMethodsPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Online bingo payment methods")).isVisible();        
	    //Validate the page
        if (isOnlinePaymentMethodsPageVisible) {
            System.out.println("Online bingo payment methods Page is visible");
        } else {       	
            System.out.println("Online bingo payment methods Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest024 Failed");
        }
        Assert.assertTrue("Online bingo payment methods Page is visible", isOnlinePaymentMethodsPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest024 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest025() {
		//Scenario : Validate when a user clicks on the Mastercard icon, they are navigated to the Tombola Online Bingo Payment Methods page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Payment Methods page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("mastercard")).click();
	    // Wait for page to load
        page.waitForLoadState();       
	    //Validate the Online bingo payment methods page is visible        
        boolean isOnlinePaymentMethodsPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Online bingo payment methods")).isVisible();       
	    //Validate the page
        if (isOnlinePaymentMethodsPageVisible) {
            System.out.println("Online bingo payment methods Page is visible");
        } else {       	
            System.out.println("Online bingo payment methods Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest025 Failed");
        }
        Assert.assertTrue("Online bingo payment methods Page is visible", isOnlinePaymentMethodsPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest025 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest026() {
		//Scenario : Validate when a user clicks on the Visasecure icon, they are navigated to the Tombola Online Bingo Payment Methods page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Payment Methods page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("visasecure")).click();
	    // Wait for page to load
        page.waitForLoadState();    
	    //Validate the Online bingo payment methods page is visible  
        boolean isOnlinePaymentMethodsPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Online bingo payment methods")).isVisible();       
	    //Validate the page
        if (isOnlinePaymentMethodsPageVisible) {
            System.out.println("Online bingo payment methods Page is visible");
        } else {       	
            System.out.println("Online bingo payment methods Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest026 Failed");
        }
        Assert.assertTrue("Online bingo payment methods Page is visible", isOnlinePaymentMethodsPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest026 Passed");
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest027() {
		//Scenario : Validate when a user clicks on the Securecode icon, they are navigated to the Tombola Online Bingo Payment Methods page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the icon to be navigated to Payment Methods page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("securecode")).click();
	    // Wait for page to load
        page.waitForLoadState(); 
	    //Validate the Online bingo payment methods page is visible  
        boolean isOnlinePaymentMethodsPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Online bingo payment methods")).isVisible();       
	    //Validate the page
        if (isOnlinePaymentMethodsPageVisible) {
            System.out.println("Online bingo payment methods Page is visible");
        } else {       	
            System.out.println("Online bingo payment methods Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest027 Failed");
        }
        Assert.assertTrue("Online bingo payment methods Page is visible", isOnlinePaymentMethodsPageVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest027 Passed");
	}

// Locators on the page don't seem to be working on my end, its failing to click anything on the page or identify elements that the playwright console is able to identify	
//	@Test
//	public void TombolaFunctionalLoginPageTest028() {
//		//Scenario : Validate when a user clicks on the "tombola careers" text, they are navigated to the Tombola Careers page
//		
//		//Launch browser - Chromium
//		Playwright pw = Playwright.create();
//		BrowserType browsertype = pw.chromium();
//		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page page = browser.newPage();
//	// Navigate to login page
//    page.navigate(LOGIN_PAGE_URL);
//		
//		//Test steps
//		//Allow cookies if visible
//	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
//	    //Validate the page
//        if (isAllowAllCookiesVisible) {
//        // Click the element if it is visible
//        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
//        }
//	    //Click on the text to be navigated to Tombola Careers page
//	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("tombola careers")).click();
//	  // Wait for page to load
//    page.waitForLoadState();
//		//Allow cookies if visible
//	    boolean isAcceptCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept all cookies")).isVisible();  
//	    //Validate the page
//        if (isAcceptCookiesVisible) {
//        // Click the element if it is visible
//        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Accept all cookies")).click();
//            
//        }     
//	    page.waitForTimeout(3000);
//	    //Validate the Tombola Careers page is visible          
//        boolean isCareersPageVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("tombola career site")).isVisible();               
//	    //Validate the page
//        if (isCareersPageVisible) {
//            System.out.println("Careers Page is visible");
//        } else {       	
//            System.out.println("Careers Page is not visible");
//            System.out.println("TombolaFunctionalLoginPageTest028 Failed");
//        }
//        Assert.assertTrue("Careers Page is visible", isCareersPageVisible);     
//	    //Close browser
//	    browser.close();
//		System.out.println("TombolaFunctionalLoginPageTest028 Passed");	 
//	}
	
	@Test
	public void TombolaFunctionalLoginPageTest029() {
		//Scenario : Validate when a user clicks on the Gambling Commission account number text, they are navigated to the Tombola Gambling Commission page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Click on the text to be navigated to Tombola Gambling Commission page
	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("38613")).click(); 
	    // Wait for page to load
        page.waitForLoadState();  
	    //Validate the Gambling Commission page is visible          
        boolean isGamblingCommissionPageVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("Tombola (International) Plc")).isVisible();         
	    //Validate the page
        if (isGamblingCommissionPageVisible) {
            System.out.println("Gambling Commission Page is visible");
        } else {       	
            System.out.println("Gambling Commission Page is not visible");
            System.out.println("TombolaFunctionalLoginPageTest029 Failed");
        }
        Assert.assertTrue("Gambling Commission Page is visible", isGamblingCommissionPageVisible); 
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest029 Passed");	 
	}
	
	@Test
	public void TombolaFunctionalLoginPageTest030() {
		//Scenario : Validate when a user enters the incorrect login details and clicks "log in" they are displayed the error "The details you have entered are incorrect. Please check and try again or click here for help."
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		//Test steps
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }
	    //Enter login details
	    page.locator("input[name=\"LoginCredential\"]").click();
	    page.locator("input[name=\"LoginCredential\"]").fill("failtest");
	    page.locator("input[name=\"Password\"]").click();
	    page.locator("input[name=\"Password\"]").fill("failtest");
	    page.locator("#app div").filter(new Locator.FilterOptions().setHasText("Login to Please enter your")).nth(3).click();
	    //Click to login
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).click();	
	    page.waitForTimeout(5000);
	    //Error is displayed        
        boolean isLoginInlineErrorVisible = page.getByText("The details you have entered are incorrect. Please check and try again or click here for help.").isVisible();       
	    //Validate the page
        if (isLoginInlineErrorVisible) {
            System.out.println("The details you have entered are incorrect. Please check and try again or click here for help is visible");
        } else {       	
            System.out.println("The details you have entered are incorrect. Please check and try again or click here for help is not visible");
            System.out.println("TombolaFunctionalLoginPageTest030 Failed");
        }
        Assert.assertTrue("The details you have entered are incorrect. Please check and try again or click here for help is visible", isLoginInlineErrorVisible); 
	    //Close browser
	    browser.close();
		System.out.println("TombolaFunctionalLoginPageTest030 Passed");
	}
	
// 	Locators on the page don't seem to be working on my end, its failing to click anything on the page or identify elements that the playwright console is able to identify	
//	@Test
//	public void TombolaFunctionalLoginPageTest031() {
//		//Scenario : Validate when a user enters the incorrect login details and clicks "log in" they are displayed the inline error and can click on "click here for help." to be navigated to the Tombola Help page
//		
//		//Launch browser - Chromium
//		Playwright pw = Playwright.create();
//		BrowserType browsertype = pw.chromium();
//		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
//		Page page = browser.newPage();
//	// Navigate to login page
//    page.navigate(LOGIN_PAGE_URL);
//		//Test steps
//		//Allow cookies if visible
//	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
//	    //Validate the page
//        if (isAllowAllCookiesVisible) {
//        // Click the element if it is visible
//        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
//        }
//	    //Enter login details
//	    page.locator("input[name=\"LoginCredential\"]").click();
//	    page.locator("input[name=\"LoginCredential\"]").fill("failtest");
//	    page.locator("input[name=\"Password\"]").click();
//	    page.locator("input[name=\"Password\"]").fill("failtest");
//	    page.locator("#app div").filter(new Locator.FilterOptions().setHasText("Login to Please enter your")).nth(3).click();
//	    //Click to login
//	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).click();	
//	    page.waitForTimeout(5000);
//	    //Navigate to help pages
//	    page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("click here for help")).click();        
//	    //Validate the Help Page is visible      
//        boolean isHelpPageVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("Tombola Bingo Customer Service")).isVisible();       
//	    //Validate the page
//        if (isHelpPageVisible) {
//            System.out.println("Help Page is visible");
//        } else {       	
//            System.out.println("Help Page is not visible");
//            System.out.println("TombolaFunctionalLoginPageTest031 Failed");
//        }
//        Assert.assertTrue("Help Page is visible", isHelpPageVisible); 
//	    //Close browser
//	    browser.close();
//		System.out.println("TombolaFunctionalLoginPageTest031 Passed");
//	}	
}
