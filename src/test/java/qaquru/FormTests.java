package qaquru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;


public class FormTests {
    @BeforeAll
    static void setup() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexandra");
        $("#lastName").setValue("Good");
        $("#userEmail").setValue("alexandra@gmail.com");

      //  $$(".custom-radio").find(text("gender-radio-2")).click();
        $("#userNumber").setValue("9999990000");



        $("#currentAddress").setValue("some home on some street");

    }
}
