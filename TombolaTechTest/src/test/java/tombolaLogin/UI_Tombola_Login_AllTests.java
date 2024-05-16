package tombolaLogin;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;

public class UI_Tombola_Login_AllTests {
	
    private static final String LOGIN_PAGE_URL = "https://stage.tombola.co.uk/userauthenticationids/loginsso#/login";

	@Test
	public void TombolaUILoginPageTest001() {
		//Scenario : Validate the "Login to tombola" title is visible on the Tombola Login page
			
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		//Allow cookies if visible
	    boolean isAllowAllCookiesVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
	    //Validate the page
        if (isAllowAllCookiesVisible) {
        // Click the element if it is visible
        	page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
        }	

	    //Validate tombola title texts
	    boolean isLoginToTextVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("login to")).first().isVisible();	      
	    //Validate login to appears on the page
        if (isLoginToTextVisible) {
            System.out.println("login to text is visible");
        } else {       	
            System.out.println("login to text is not visible");
    		System.out.println("TombolaUILoginPageTest001 Failed");
        }
        Assert.assertTrue("login to text is visible", isLoginToTextVisible);
        
	    boolean isTombolaTitleTextVisible = page.getByRole(AriaRole.IMG, new Page.GetByRoleOptions().setName("tombola")).first().isVisible();      
	    //Validate Tombola title appears on the page
        if (isTombolaTitleTextVisible) {
            System.out.println("Tombola title text is visible");
        } else {       	
            System.out.println("Tombola title is not visible");
    		System.out.println("TombolaUILoginPageTest001 Failed");
        }
        Assert.assertTrue("Tombola title text is visible", isTombolaTitleTextVisible);
        
	    boolean isLoginInformationTextVisible = page.getByText("Please enter your existing tombola log in details to continue playing.").first().isVisible();      
	    //Validate Login information text appears on the page
        if (isLoginInformationTextVisible) {
            System.out.println("Please enter your existing tombola log in details to continue playing text is visible");
        } else {       	
            System.out.println("Please enter your existing tombola log in details to continue playing text is not visible");
    		System.out.println("TombolaUILoginPageTest001 Failed");
        }
        Assert.assertTrue("Please enter your existing tombola log in details to continue playing text is visible", isLoginInformationTextVisible);
                     
	    browser.close();
		System.out.println("TombolaUILoginPageTest001 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest002() {
		//Scenario : Validate the login fields are visible on the Tombola Login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();	

	    //Validate tombola login section
	    //Validate username is visible on the page
	    boolean isUsernameTextVisible = page.getByText("username/email").isVisible();;    
        if (isUsernameTextVisible) {
            System.out.println("Username text is visible");
        } else {       	
            System.out.println("Username text is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Username text is visible", isUsernameTextVisible);
        
       //Validate username entry box is visible on the page
        boolean isUsernameInputVisible = page.locator("input[name=\"LoginCredential\"]").isVisible();    
        if (isUsernameInputVisible) {
            System.out.println("Username entry is visible");
        } else {       	
            System.out.println("Username entry is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Username entry is visible", isUsernameInputVisible);
        
       //Validate password is visible on the page
        boolean isPasswordTextVisible = page.getByText("password").isVisible();    
        if (isPasswordTextVisible) {
            System.out.println("Password text is visible");
        } else {       	
            System.out.println("Password text is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Password text is visible", isPasswordTextVisible);
        
        //Validate password entry box is visible on the page
        boolean isPasswordInputVisible = page.locator("input[name=\"Password\"]").isVisible();    
        if (isPasswordInputVisible) {
            System.out.println("Password entry is visible");
        } else {       	
            System.out.println("Password entry is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Password entry is visible", isPasswordInputVisible);
        
        //Validate password visibility eye is visible on the page
        boolean isPasswordEyeVisible = page.locator("i").isVisible();;    
        if (isPasswordEyeVisible) {
            System.out.println("Password visibility eye is visible");
        } else {       	
            System.out.println("Password visibility eye is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Password visibility eye is visible", isPasswordEyeVisible);
        
        //Validate remember me checkbox is visible on the page
        boolean isRememberMeCheckboxVisible = page.getByText("remember me").isVisible(); 
        if (isRememberMeCheckboxVisible) {
            System.out.println("Remember me checkbox is visible");
        } else {       	
            System.out.println("Remember me checkbox is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Remember me checkbox is visible", isRememberMeCheckboxVisible);
        
        //Validate log in button is disabled by default on the page	    
        boolean isLoginInButtonDisabled = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("log in")).isDisabled();	   
        if (isLoginInButtonDisabled) {
            System.out.println("Log in button is disabled");
        } else {       	
            System.out.println("Log in button is not disabled");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("Login button is disabled", isLoginInButtonDisabled);
        
        //Validate forgot your login details? text is visible on the page
        boolean isForgotLoginDetialsVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("forgot your login details?")).isVisible();      
        if (isForgotLoginDetialsVisible) {
            System.out.println("forgot your login details? text is visible");
        } else {       	
            System.out.println("forgot your login details? is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("forgot your login details? text is visible", isForgotLoginDetialsVisible);
        
        //Validate By logging in you are accepting our T&Cs and Privacy Policy text is visible on the page
        boolean isTermsAndConditonsTextVisible = page.getByText("By logging in you are accepting our T&Cs and Privacy Policy.").isVisible();      
        if (isTermsAndConditonsTextVisible) {
            System.out.println("By logging in you are accepting our T&Cs and Privacy Policy. text is visible");
        } else {       	
            System.out.println("By logging in you are accepting our T&Cs and Privacy Policy. is not visible");
    		System.out.println("TombolaUILoginPageTest002 Failed");
        }
        Assert.assertTrue("By logging in you are accepting our T&Cs and Privacy Policy. text is visible", isTermsAndConditonsTextVisible);
        
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest002 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest003() {
		//Scenario : Validate the banner fields are visible on the Tombola Login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
		

	    //Validate tombola banner 	    
        //Validate banner title is visible on the page
        boolean isBannerTitleVisible = page.locator("#app div").filter(new Locator.FilterOptions().setHasText("Get £20 Bonus - deposit £20,")).nth(3).isVisible();     
        if (isBannerTitleVisible) {
            System.out.println("Banner title is visible");
        } else {       	
            System.out.println("Banner title is not visible");
    		System.out.println("TombolaUILoginPageTest003 Failed");
        }
        Assert.assertTrue("Banner title is visible", isBannerTitleVisible);
        
        //Validate banner text is visible on the page
        boolean isBannerTextVisible = page.getByText("Deposit from £10, match up to £50. First deposit only. Any winnings can be withdrawn excluding bonus money. T&Cs apply").isVisible();    
        if (isBannerTextVisible) {
            System.out.println("Banner text is visible");
        } else {       	
            System.out.println("Banner text is not visible");
    		System.out.println("TombolaUILoginPageTest003 Failed");
        }
        Assert.assertTrue("Banner text is visible", isBannerTextVisible);
        
        //Validate Join now button is visible on the page
        boolean isJoinNowVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Join now")).isVisible();     
        if (isJoinNowVisible) {
            System.out.println("Join now button is visible");
        } else {       	
            System.out.println("Join now button is not visible");
    		System.out.println("TombolaUILoginPageTest003 Failed");
        }
        Assert.assertTrue("Join now button is visible", isJoinNowVisible);
	        
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest003 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest004() {
		//Scenario : Validate the navigation icons are visible on the footer of the Tombola Login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
		

	    //Validate footer icons 	    
        //Validate SafePlay icon is visible on the page
        boolean isSafePlayIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Over 18s Only")).isVisible();     
        if (isSafePlayIconVisible) {
            System.out.println("SafePlay icon is visible");
        } else {       	
            System.out.println("SafePlay icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("SafePlay icon is visible", isSafePlayIconVisible);
	
        //Validate Gibraltar Gambling Authority icon is visible on the page
        boolean isGibralterGamblingAuthorityIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gibraltar Gambling Authority")).isVisible();    
        if (isGibralterGamblingAuthorityIconVisible) {
            System.out.println("Gibraltar Gambling Authority icon is visible");
        } else {       	
            System.out.println("Gibraltar Gambling Authority icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Gibraltar Gambling Authority icon is visible", isGibralterGamblingAuthorityIconVisible);
	
        //Validate Gamcare icon is visible on the page
        boolean isGamcareIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamcare")).isVisible();    
        if (isGamcareIconVisible) {
            System.out.println("Gamcare icon is visible");
        } else {       	
            System.out.println("Gamcare icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Gamcare icon is visible", isGamcareIconVisible);
	
        //Validate Safer Gambling Standard icon is visible on the page
        boolean isSaferGablingStandardIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Safer Gambling Standard")).isVisible();    
        if (isSaferGablingStandardIconVisible) {
            System.out.println("Safer Gambling Standard icon is visible");
        } else {       	
            System.out.println("Safer Gambling Standard icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Safer Gambling Standard icon is visible", isSaferGablingStandardIconVisible);
	
        //Validate Gamble Aware icon is visible on the page
        boolean isGambleAwareIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamble Aware")).isVisible();   
        if (isGambleAwareIconVisible) {
            System.out.println("Gamble Aware icon is visible");
        } else {       	
            System.out.println("Gamble Aware icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Gamble Aware icon is visible", isGambleAwareIconVisible);
	
        //Validate Gamstop icon is visible on the page
        boolean isGamstopIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gamstop")).isVisible();    
        if (isGamstopIconVisible) {
            System.out.println("Gamstop icon is visible");
        } else {       	
            System.out.println("Gamstop icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Gamstop icon is visible", isGamstopIconVisible);
	
        //Validate Gambling Commission Icon is visible on the page
        boolean isGamblingComissionIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Gambling Commission")).isVisible();    
        if (isGamblingComissionIconVisible) {
            System.out.println("Gambling Commission Icon is visible");
        } else {       	
            System.out.println("Gambling Commission Icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Gambling Commission Icon is visible", isGamblingComissionIconVisible);
	
        //Validate Visa icon is visible on the page
        boolean isVisaIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("visa").setExact(true)).isVisible();     
        if (isVisaIconVisible) {
            System.out.println("Visa icon is visible");
        } else {       	
            System.out.println("Visa icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Visa icon is visible", isVisaIconVisible);
	
        //Validate Mastercard icon is visible on the page
        boolean isMasterCardIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("mastercard")).isVisible();    
        if (isMasterCardIconVisible) {
            System.out.println("Mastercard icon is visible");
        } else {       	
            System.out.println("Mastercard icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Mastercard icon is visible", isMasterCardIconVisible);
	
        //Validate Visa Secure Icon is visible on the page
        boolean isVisaSecureIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("visasecure")).isVisible();    
        if (isVisaSecureIconVisible) {
            System.out.println("Visa Secure Icon is visible");
        } else {       	
            System.out.println("Visa Secure Icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Visa Secure Icon is visible", isVisaSecureIconVisible);
	
        //Validate Securecode icon is visible on the page
        boolean isSecurecodeIconVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("securecode")).isVisible();    
        if (isSecurecodeIconVisible) {
            System.out.println("Securecode icon is visible");
        } else {       	
            System.out.println("Securecode icon is not visible");
    		System.out.println("TombolaUILoginPageTest004 Failed");
        }
        Assert.assertTrue("Securecode icon is visible", isSecurecodeIconVisible);
	
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest004 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest005() {
		//Scenario : Validate the footer text elements are visible on the Tombola Login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
		

	    //Validate footer text elements 
        //Validate tombola careers hyperlink is visible on the page
        boolean isTombolaCareersHyperlinkVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("tombola careers")).isVisible(); 
        if (isTombolaCareersHyperlinkVisible) {
            System.out.println("Tombola careers hyperlink is visible");
        } else {       	
            System.out.println("Tombola careers hyperlink is not visible");
    		System.out.println("TombolaUILoginPageTest005 Failed");
        }
        Assert.assertTrue("Tombola careers hyperlink is visible", isTombolaCareersHyperlinkVisible);
        
        //Validate Copyright text is visible on the page
        boolean isCopyrightTextVisible = page.getByText("© tombola Ltd. 2005 - 2023, operated by tombola (International) Plc, company no. 105556 at operating address Tombola International Plc, Floor 4, 55 Line Wall Road, Gibraltar, GX11 1AA.Licensed by the Government of Gibraltar (RGL No. 052) and regulated by the Gibraltar Gambling Commissioner.Tombola (International) Plc is licensed and regulated in Great Britain by the Gambling Commission under account number").isVisible();        
        if (isCopyrightTextVisible) {
            System.out.println("Copyright text is visible");
        } else {       	
            System.out.println("Copyright text is not visible");
    		System.out.println("TombolaUILoginPageTest005 Failed");
        }
        Assert.assertTrue("Copyright text is visible", isCopyrightTextVisible);
        
        //Validate Gambling Authority Code is visible on the page
        boolean isGamblingAuthorityCodeVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("38613")).isVisible();  
        if (isGamblingAuthorityCodeVisible) {
            System.out.println("Gambling Authority Code is visible");
        } else {       	
            System.out.println("Gambling Authority Code is not visible");
    		System.out.println("TombolaUILoginPageTest005 Failed");
        }
        Assert.assertTrue("Gambling Authority Code is visible", isGamblingAuthorityCodeVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest005 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest006() {
		//Scenario : Validate the Need Help? elements are visible on the Tombola Login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
		
	    //Click on the Need Help? tab to display icons
		page.getByText("Need Help?").isVisible();
	    page.getByText("Need Help?").click();	
	    page.waitForTimeout(3000);	    
        //Validate Phone Support icon is visible on the page
        boolean isPhoneSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Phone Support")).isVisible(); 
        if (isPhoneSupportVisible) {
            System.out.println("Phone Support Icon is visible");
        } else {       	
            System.out.println("Phone Support Icon is not visible");
    		System.out.println("TombolaUILoginPageTest006 Failed");
        }
        Assert.assertTrue("Phone Support Icon is visible", isPhoneSupportVisible);
        
        //Validate Live Support Icon is visible on the page
        boolean isLiveSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("live help")).isVisible();  
        if (isLiveSupportVisible) {
            System.out.println("Live Help Support Icon is visible");
        } else {       	
            System.out.println("Live Help Support Icon is not visible");
    		System.out.println("TombolaUILoginPageTest006 Failed");
        }
        Assert.assertTrue("Live Help Support Icon is visible", isLiveSupportVisible);
        
        //Validate Email Support Icon is visible on the page
        boolean isEmailSupportVisible = page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Email Support")).isVisible();  
        if (isEmailSupportVisible) {
            System.out.println("Email Support Icon is visible");
        } else {       	
            System.out.println("Email Support Icon is not visible");
    		System.out.println("TombolaUILoginPageTest006 Failed");
        }
        Assert.assertTrue("Email Support Icon is visible", isEmailSupportVisible);
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest006 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest007() {
		//Scenario : Validate the image promotion on the right side of the screen is visible on the Tombola login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
	    page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).click();
			    
	    //Validate the image advertisement is visible on the page
        boolean isImageAdvertisementVisible = page.locator(".login > div:nth-child(3)").isVisible();  
        if (isImageAdvertisementVisible) {
            System.out.println("Image Advertisement is visible");
        } else {       	
            System.out.println("Image Advertisement is not visible");
    		System.out.println("TombolaUILoginPageTest007 Failed");
        }
        Assert.assertTrue("Image Advertisement is visible", isImageAdvertisementVisible);
        
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest007 Passed");
	}
	
	@Test
	public void TombolaUILoginPageTest008() {
		//Scenario : Validate the cookie acceptance notification banner on first load up of the Tomobola login page
		
		//Launch browser - Chromium
		Playwright pw = Playwright.create();
		BrowserType browsertype = pw.chromium();
		Browser browser = browsertype.launch(new BrowserType.LaunchOptions().setHeadless(false));
		Page page = browser.newPage();
		// Navigate to login page
        page.navigate(LOGIN_PAGE_URL);
		
	    //Validate the cookie acceptance notification banner	    
	    //Validate We value your privacy title is visible on the page
        boolean isWeValueYourPrivacyTitleVisible = page.getByRole(AriaRole.HEADING, new Page.GetByRoleOptions().setName("We value your privacy")).isVisible();
        if (isWeValueYourPrivacyTitleVisible) {
            System.out.println("We value your privacy title is visible");
        } else {       	
            System.out.println("We value your privacy title is not visible");
    		System.out.println("TombolaUILoginPageTest008 Failed");
        }
        Assert.assertTrue("We value your privacy title is visible", isWeValueYourPrivacyTitleVisible);

	    //Validate cookie policy text is visible on the page
        boolean isCookiePolicyTextVisible = page.getByText("If you 'Allow all cookies' you are agreeing to the storing of cookies on your device to enhance site navigation, assist with our marketing efforts, and analysis of product usage.").isVisible();
        if (isCookiePolicyTextVisible) {
            System.out.println("Cookie policy text is visible");
        } else {       	
            System.out.println("Cookie policy text  is not visible");
    		System.out.println("TombolaUILoginPageTest008 Failed");
        }
        Assert.assertTrue("Cookie policy text  is visible", isCookiePolicyTextVisible);
        
	    //Validate Manage cookies button is visible on the page
        boolean isManageCookieButtonVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Manage cookies")).isVisible(); 
        if (isManageCookieButtonVisible) {
            System.out.println("Manage cookies button is visible");
        } else {       	
            System.out.println("Manage cookies button is not visible");
    		System.out.println("TombolaUILoginPageTest008 Failed");
        }
        Assert.assertTrue("Manage cookies buttonis visible", isManageCookieButtonVisible);
        
	    //Validate Necessary only button is visible on the page
        boolean isNecessaryOnlyButtonVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Necessary only")).isVisible();  
        if (isNecessaryOnlyButtonVisible) {
            System.out.println("Necessary only button is visible");
        } else {       	
            System.out.println("Necessary only button is not visible");
    		System.out.println("TombolaUILoginPageTest008 Failed");
        }
        Assert.assertTrue("Necessary only button is visible", isNecessaryOnlyButtonVisible);
        
	    //Validate Allow all cookies button is visible on the page
        boolean isAllowAllCookiesButtonVisible = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Allow all cookies")).isVisible();   
        if (isAllowAllCookiesButtonVisible) {
            System.out.println("Allow all cookies button is visible");
        } else {       	
            System.out.println("Allow all cookies button is not visible");
    		System.out.println("TombolaUILoginPageTest008 Failed");
        }
        Assert.assertTrue("Allow all cookies button is visible", isAllowAllCookiesButtonVisible);
        
	    //Close browser
	    browser.close();
		System.out.println("TombolaUILoginPageTest008 Passed");
	}	
}