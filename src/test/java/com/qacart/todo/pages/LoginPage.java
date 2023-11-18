package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "submit")
    private WebElement submitLogin;



    @Step
    public TodoPage login(String email, String password)
    {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submitLogin.click();
        return new TodoPage(driver);
    }

    @Step
    public LoginPage load()
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }
}
