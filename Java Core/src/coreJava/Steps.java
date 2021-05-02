package coreJava;

public class Steps {
	
	Webdriver driver; //as we know we use selenium webdriver to interact with the browser so with the cucumber framework we are also using the selenium web driver to interact with the browser(
	//exactly sure how they are refering to seleniu deriver here need to ask Bapu)
	@Given("^Open the Browser and Launch the Application$") //this is the condition which is given in the feature file here we are providing the step definition for that, given annotation with the parameter will map this to the feature file.
	public void open_the_firefox_and_launch_the_application() throws throwable
	{
	
	//The setProperty() method of Java system class sets the property of the system which is indicated by a key
	System.setProperty("webdriver.chrome.driver", C:\\ayan\\automation\\cucumber jars\\chromedriver.exe");
	
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://d2digital01.cbspdev.com/digital/");
	Thread.sleep(10000);
	//here we are using the findElement method of webdriver to interact with the browser and using the xpath to locate the element on the browser we can also use the id instead of Xpath.
	driver.findElement(By.xpath("//*[@title='Accept all cookies']")).click();//click method is used to click on the element which we located using findElement method.
	Thread.sleep(100000);
	driver.findElement(By.xpath("//*[text()='Log in'][1]")).click();
	Thread.sleep(10000);
	System.out.println("This Step will open the browser and will launch the application.");

}
	//this is again will map the condition to the feature file and will read the inputs from the feature file which we gave in the Examples in the Feature file
	@When("^Enter the Username(\\d) and dob(\\d+)$")
	public void ente_the_username_and_dob(String username, String dob) throws Throwable //how the username and dob will be passed here
	{
		driver.findElement(By.xpath("//*[@name='C2_LOGIN[1].FORMUSERID']")).sendkeys(username);//here we are using the id of the page to locate the element on the UI and then invoking sendkeys method to
		//to pass the value to the username field that we will get from the feature file.
		driver.findElement(By.xpath("//*[@id='C2_LOGIN[1].FORMUSERID']")).sendkeys(dob);//id would be different this is just an example
		driver.findElement(By.xpath("//span[.='Continue'")).click();
		System.out.println("this step will enter the username and password.");
		Thread.sleep(5000);
	}
	
	@When("^Enter the Pin(\\d+)$")
	public void enter_pin(String pin) throws Throwable
	{
		//If an empty string ("") is used as the separator, the string is split between each character
		String[] arrPin=pin.split("");
		List<WebElement> lstPinEnterFieldGrp= driver.findElements(By.xpath("//fieldSet[contains(@id,'GROUP_FS_HEAD')]/descendant::input[@type='number'"));//this will get the list of elements i.e. the boxes
		//are there on the PIN page then we will see which box is enabled and will get the same element from the above array and fill it in the box.
		for(int i=0; i<lstPinEnterFieldGrp.size();i++)
		{
			if(lstPinEnterFieldGrp.get(i).isEnabled())
			{
				lstPinEnterFieldGrp.get(i).sendKeys(arrPin[i]);
			}
		}
		driver.findElement(By.xpath("//*[text()='Confirm']")).click();
		System.out.println("This step enter the 3/6 pin.");
	}
	
	@Then("^Login is successful$")
	public void login_successful() throws Throwable
	{
		System.out.println("The Step verifies login is successful.");
	}
}
