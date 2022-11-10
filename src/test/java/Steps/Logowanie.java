package Steps;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Logowanie {

    static WebDriver driver;

    @BeforeAll
    public static void setDriver(){
        System.out.println("Uruchomienie przeed wszystkimi scenariuszami");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Before
    public void before(){
        System.out.println("Uruchomienie przed kazdym scenariuszem testowym ");
    }


    @Given("Uzytkownik otwiera przegladarke")
    public void testUzytkownikOtwieraPrzegladarke(){
        System.out.println("Uzytkownik otworzyl przegladarke");
        //System.setProperty("webdriver.chrome.driver","C:/Users/zblewski/Desktop/chromdriver/chromedriver107.exe");
       // driver = new ChromeDriver();
       // driver.manage().window().maximize();
    }

    @Given("Uzytkownik wpisuje adres https:\\/\\/the-internet.herokuapp.com\\/login")
    public void uzytkownik_wpisuje_adres_https_the_internet_herokuapp_com_login() {
        System.out.println("Uzytkownik wpisuje adres strony internetowej");
        driver.navigate().to("https://the-internet.herokuapp.com/login");
    }
// inny sposób na uruchomienie strony
    //Given Uzytkownik wpisuje adres https://the-internet.herokuapp.com/login
    @Given("Uzytkownik wpisuje adres {string}")
    public void uzytkownik_wpisuje_w_pole_username2(String url) {
        driver.navigate().to(url);
    }
// inny sposób wpisywania nazwy
    @When("Uzytkownik wpisuje {string} w pole username")
    public void uzytkownik_wpisuje_w_pole_username(String nazwaUzytkownika) {
        driver.findElement(By.id("username")).sendKeys(nazwaUzytkownika);
    }
    //Uzytkownik wpisuje "SuperSecretPassword!" w pole pasword
    @When("Uzytkownik wpisuje {string} w pole pasword")
    public void uzytkownik_wpisuje_w_pole_pasword(String haslo) {
      driver.findElement(By.id("password")).sendKeys(haslo);
    }

    @When("Uzytkownik wpisuje poprawny username")
    public void uzytkownik_wpisuje_poprawny_username() {
        System.out.println("Uzytkownik wpisuje poprawny login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");

    }
    @When("Uzytkownik wpisuje poprawne haslo")
    public void uzytkownik_wpisuje_poprawne_haslo() {
        System.out.println("Uzytkowanik wpisuje poprawne haslo");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("SuperSecretPassword!");
    }

    @When("Uzytkownik klika przycisk Login")
    public void uzytkownik_klika_przycisk_login() {
        System.out.println("Uzytkownik klika przycisk Login");
        driver.findElement(By.tagName("button")).click();

    }

    @Then("Uzytkownik zostal poprawnie zalogowany")
    public void uzytkownik_zostal_poprawnie_zalogowany() {
        System.out.println("Uzytkownik zostal poprawnie zalogowany");
        Assert.assertEquals("https://the-internet.herokuapp.com/secure", driver.getCurrentUrl());
        //driver.close();
    }
    @When("Uzytkownik wpisuje niepoprawne haslo")
    public void uzytkownik_wpisuje_niepoprawne_haslo() {
        System.out.println("Uzytkowanik popełnia błąd w haśle");
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.sendKeys("aaa");


    }
    @Then("Uzytkownik nie zostal poprawnie zalogowany")
    public void uzytkownik_nie_zostal_poprawnie_zalogowany() {
        System.out.println("Uzytkownik nie zostal poprawnie zalogowany");
        Assert.assertEquals("https://the-internet.herokuapp.com/login", driver.getCurrentUrl());
        //driver.close();
    }
    //Uzytkownik wpisuje <nazwa uzytkownika> w pole username
    @When("^Uzytkownik wpisuje (.+) w pole username$")
    public void uzytkownik_wpisuje_w_pole_username3(String nazwauzytkownika)  {

        driver.findElement(By.id("username")).sendKeys(nazwauzytkownika);
    }

    @And("^Uzytkownik wpisuje (.+) w pole pasword$")
    public void uzytkownik_wpisuje_w_pole_pasword3(String haslo)  {

        driver.findElement(By.id("password")).sendKeys(haslo);
    }

        @AfterAll
    public static void tearDown(){
            driver.close();
        }

}
