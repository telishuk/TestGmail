package pages;

import utils.NoSuchLocatorException;
import utils.PropertyLoader;
import utils.WebDriverWrapper;

import java.io.IOException;

public class LoginPage extends Page{

    private static final String PAGE = PropertyLoader.loadProperty("site.Url");

    public LoginPage(WebDriverWrapper dr) {
        super(dr, PAGE);
    }

    public void clickButtonNextLogin() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ButtonNextLogin");
    }

    public void clickButtonNextPass() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.clickButton("ButtonNextPass");
    }

    public void inputLogin(String login) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.input("LoginField", login);
    }

    public void inputPassword(String pass) throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.waitForElementToBeClickable("PassField");
        web.input("PassField", pass);
    }

    public void clickLogout() throws IOException, InstantiationException, CloneNotSupportedException, IllegalAccessException, NoSuchLocatorException {
        web.waitForElementPresent("UserSettingsMenu");
        web.clickElement("UserSettingsMenu");
        web.clickButton("ButtonLogout");
    }

    public void waitLoadPassMenu() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.waitForElementPresent("ButtonNextPass");
        web.clickButton("ButtonNextPass");
    }

    public void clickChangeLogin() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ChangeLogin");
    }

    public void clickForgotMailLink() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickLink("ForgotLink");
    }

    public void inputPhoneNumberAndClick(String number) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.waitForElementPresent("ForgotFieldInput");
        web.input("ForgotFieldInput", number);
        web.clickButton("ButtonForgotNext");
    }

    public void clickCreateAccount() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickButton("ButtonCreateAccount");
    }

    public void clickButtonEnter(String login) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.inputAndClickEnter("LoginField", login);
    }

    public void clearField() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clearField("LoginField");
    }


    public void clickChangeAccount() throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.clickElement("ChangeAccount");
    }

    public void selectLanguage(String lang) throws IOException, InstantiationException, NoSuchLocatorException, CloneNotSupportedException, IllegalAccessException {
        web.selectFromList("Language",lang);
    }

}
