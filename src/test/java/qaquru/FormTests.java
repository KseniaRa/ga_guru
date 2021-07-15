package qaquru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;


public class FormTests {
    RegistrationPage registrationPage= new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
       registrationPage.openPage();
        //Заполнение полей
       registrationPage.typeFirstName()
                        .typeLastName()
                        .typeEmail()
                        .chooseGender()
                        .typePhone();

        registrationPage.setBirthDate(01,"November",1995);


       registrationPage.chooseSubject();
       registrationPage.uploadPicture();
       registrationPage.chooseHobby();
       registrationPage.typeAddress();
       registrationPage.chooseState();
       registrationPage.chooseCity();
       registrationPage.submitForm();


        //Проверка данных
       registrationPage.checkResults();
       registrationPage.closePopup();


    }
}
