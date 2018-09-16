package tests;

import org.testng.annotations.*;
import utils.Fixture;
import utils.NoSuchLocatorException;
import java.io.IOException;

import static org.testng.Assert.*;


public class TestsLoginPage extends Fixture{

    @Test
    public void negativeLoginFieldEmpty() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginString() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin(gmail.randomData.getRandomString());
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Не удалось найти аккаунт Google");
    }

    @Test
    public void inputLoginScript() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("<script>alert(123)</script>");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginSQL() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("SELECT * FROM blog WHERE code LIKE ‘a%’");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginHTML() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("<form action=»http://live.hh.ru»><input type=»submit»></form>");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginUnicode() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("<*******@gmail.com>");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginPhoneNumber() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("+380".concat(gmail.randomData.getRandomInt()));
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Аккаунт Google не найден. Попробуйте ввести адрес электронной почты.");
    }

    @Test
    public void inputLoginAndClickEnter() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.clickButtonEnter("*******@gmail.com");
        assertTrue(gmail.web.isElementPresent("PassForm"));
    }

    @Test
    public void inputLoginSymbols() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("«»‘~!@#$%^&*()?>,./<][ /*<!—«»");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void inputLoginAllSpace() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("                                    ");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ErrorLogin"),"Введите адрес электронной почты или номер телефона");
    }

    @Test
    public void currentLogin() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        assertEquals(gmail.web.getElementsText("ProfileIdentifier"),"*******@gmail.com");
    }

    @Test
    public void inputPassFieldEmpty() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        gmail.loginPage.waitLoadPassMenu();
        gmail.loginPage.clickButtonNextPass();
    }

   @Test
    public void inputWrongPass() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        gmail.loginPage.inputPassword(gmail.randomData.getRandomLongString());
        gmail.loginPage.clickButtonNextPass();
        assertFalse(gmail.web.isElementPresent("ErrorPass"));
    }

    @Test
    public void inputEmptyPass() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        gmail.loginPage.inputPassword("");
        gmail.loginPage.clickButtonNextPass();
        assertEquals(gmail.web.getElementsText("ErrorPass"),"Введите пароль");
    }

    @Test
    public void returnToLoginForm() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        gmail.loginPage.waitLoadPassMenu();
        gmail.loginPage.clickChangeLogin();
        gmail.loginPage.clearField();
    }

    @Test
    public void clickForgotMail() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.clickForgotMailLink();
        gmail.loginPage.inputPhoneNumberAndClick("+380".concat(gmail.randomData.getRandomInt()));
    }

    @Test
    public void clickCreateAccount() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.clickCreateAccount();
        assertTrue(gmail.web.isElementPresent("CreateAccountForm"));
    }

    //@Test
    public void currentLoginAndPass() throws NoSuchLocatorException, InstantiationException, IllegalAccessException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.inputLogin("*******@gmail.com");
        gmail.loginPage.clickButtonNextLogin();
        gmail.loginPage.inputPassword("*******");
        gmail.loginPage.clickButtonNextPass();
        gmail.loginPage.clickLogout();
        assertTrue(gmail.web.isElementPresent("MenuPresentation"));
        gmail.loginPage.clickChangeAccount();
    }

    @Test
    public void clickChangeLanguage() throws IllegalAccessException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IOException {
        gmail.loginPage.openPage();
        gmail.loginPage.selectLanguage("mn");
    }

}
