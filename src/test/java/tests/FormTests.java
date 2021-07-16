package tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;



public class FormTests {
    RegistrationPage registrationPage= new RegistrationPage();


    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String gender = "Other";
    String phone = faker.numerify("##########");
    String day = "01";
    String month = "November";
    String year = "1995";
    String subject = "Maths";
    String picture = "file.jpeg";
    String hobbies = "Reading";
    String address = faker.address().fullAddress();
    String state = "Haryana";
    String city = "Panipat";

    @BeforeAll
    static void setup() {
        Configuration.baseUrl="https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveFillTest() {
       registrationPage.openPage();
        //Заполнение полей
       registrationPage.typeFirstName(firstName)
                        .typeLastName(lastName)
                        .typeEmail(email)
                        .chooseGender(gender)
                        .typePhone(phone)
                        .setBirthDate(day,month,year)
                        .chooseSubject(subject)
                        .uploadPicture(picture)
                        .chooseHobbies(hobbies)
                        .typeAddress(address)
                        .chooseState(state)
                        .chooseCity(city);


       registrationPage.submitForm();


        //Проверка данных
       registrationPage.checkResults(firstName+ " " +lastName )
               .checkResults(email)
               .checkResults(gender)
               .checkResults(phone)
               .checkResults(day+ " " +month + "," + year)
               .checkResults(subject)
               .checkResults(picture)
               .checkResults(hobbies)
               .checkResults(address)
               .checkResults(state + " " + city);

       registrationPage.closePopup();
       registrationPage.checkClosePopup();


    }
}
