package org.example.waiting_explicit_implicit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.jetbrains.com/");

        mainPage = new MainPage(driver);
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @AfterAll
    public static void endingText(){
        System.out.println("Тесты завершены");
    }

    @Test
    @DisplayName("Тест по проверке кнопки Visible After 5 Seconds")
    public void visibleAfterSeconds() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(6));

        driver.findElement(By.cssSelector("#visibleAfter").click());
        wait.until(ExpectedCondition.elementToBeClickable(By.cssSelector("#visibleAfter")));
        WebElement but = new driver.findElement(By.cssSelector("#visibleAfter"));
        assertTrue(but.isDisplayed(), "Нет нужной кнопки");


    }
}
