package qaquru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class FormTests {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        //Заполнение полей
        $("#firstName").setValue("Alexandra");
        $("#lastName").setValue("Good");
        $("#userEmail").setValue("alexandra@gmail.com");
        $(byText("Female")).click();
        $("#userNumber").setValue("9999990000");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--001:nth-child(4)").click();
        $("#subjectsInput").setValue("M").pressEnter();
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.jpeg"));
        $(byText("Reading")).click();
        $("#currentAddress").setValue("some home on some street");
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        $("#submit").scrollTo().click();

        //Проверка данных
        $(".table-responsive").shouldHave(text("Alexandra Good"),
                text("alexandra@gmail.com"),
                text("Female"),
                text("9999990000"),
                text("1 November,1995"),
                text("Maths"),
                text("Reading"),
                text("file.jpeg"),
                text("some home on some street"),
                text("Haryana Panipat"));

        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").should(disappear);
    }
}
