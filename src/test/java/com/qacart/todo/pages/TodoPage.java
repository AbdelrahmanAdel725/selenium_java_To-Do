package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoints;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TodoPage extends BasePage{

    public TodoPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(css = "[data-testid=\"welcome\"]")
    private WebElement isWelcomeDisplayed;

    @FindBy(css = "[data-testid=\"add\"]")
    private WebElement addButton;
    @FindBy(css = "[data-testid=\"todo-item\"]")
    private WebElement todoItem;
    @FindBy(css = "[data-testid=\"delete\"]")
    private WebElement deleteTodo;
    @FindBy(css = "[data-testid=\"no-todos\"]")
    private WebElement noTodoMessage;

    @Step
    public boolean isWelcomeDisplayed()
    {
        return isWelcomeDisplayed.isDisplayed();
    }
    @Step
    public String getTodoText()
    {
        return todoItem.getText();
    }
    @Step
    public TodoPage deleteTodo()
    {
        deleteTodo.click();
        return this;
    }

    @Step
    public TodoPage load()
    {
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoints.TODO_END_POINT);
        return this;
    }
    @Step
    public NewTodoPage clickOnAddButton()
    {
        addButton.click();
        return new NewTodoPage(driver);
    }
    @Step
    public boolean isNoTodoDisplayed()
    {
        return noTodoMessage.isDisplayed();
    }

}
