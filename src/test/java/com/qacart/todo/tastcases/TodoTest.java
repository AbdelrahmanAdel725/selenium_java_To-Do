package com.qacart.todo.tastcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewTodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.checkerframework.checker.units.qual.N;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add New Todo")
    @Test(description = "should be able to add a new todo")
    public void shouldBeAbleToAddNewTodo(){
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();
        NewTodoPage newTodoPage = new NewTodoPage(getDriver());
        newTodoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        String actualResult = newTodoPage
                .load()
                .addNewTask("Cookies Added")
                .getTodoText();
        System.out.println(actualResult);
        Assert.assertEquals(actualResult,"Cookies Added");
    }

    @Story("Delete Todo")
    @Test(description = "should be able to delete a todo")
    public void shouldBeAbleToDeleteTodo()
    {
        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(getDriver());
        todoPage.load();
        injectCookiesToBrowser(registerApi.getRestAssuredCookies());
        boolean isNotTodoDisplayed = todoPage
                .load()
                .deleteTodo()
                .isNoTodoDisplayed();//--------
        Assert.assertTrue(isNotTodoDisplayed);
    }
}
