package com.qacart.todo.tastcases;

import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login With Email and Password")
    @Description("it will login by filling the email and password fields and navigate to Todo Page")
    @Test(description = "Test the login functionality using email and password")
    public void shouldBeAbleToLoginWithEmailAndPassword()
    {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean loggedIn = loginPage
                .load()
                .login(ConfigUtils.configUtils.getEmail(),ConfigUtils.getInstance().getPassword())
                .isWelcomeDisplayed();
        Assert.assertTrue(loggedIn);
    }
}
