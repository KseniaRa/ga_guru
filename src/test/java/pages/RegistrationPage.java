package pages;

import com.codeborne.selenide.Selenide;
import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class RegistrationPage {

    private Calendar calendar= new Calendar();

    public RegistrationPage openPage(){

        open("/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        $("#firstName").val(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        $("#lastName").val(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        $("#userEmail").val(email);

        return this;
    }

    public RegistrationPage chooseGender(){
        $("#genterWrapper").$(byText("Female")).click();
        return this;
    }


    public RegistrationPage typePhone(){
        $("#userNumber").setValue("9999990000");
        return this;
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
            calendar.setDate(day,month, year);
            return this;
        }

    public RegistrationPage chooseSubject(){
        $("#subjectsInput").setValue("M").pressEnter();
        return this;
    }

    public RegistrationPage uploadPicture(){
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.jpeg"));
        return this;
    }

    public RegistrationPage chooseHobby(){
        $("#hobbiesWrapper").$(byText("Reading")).click();
        return this;
    }

    public RegistrationPage typeAddress(){
        $("#currentAddress").setValue("some home on some street");
        return this;
    }

    public RegistrationPage chooseState(){
        $("#react-select-3-input").setValue("Haryana").pressEnter();
        return this;
    }

    public RegistrationPage chooseCity(){
        $("#react-select-4-input").setValue("Panipat").pressEnter();
        return this;
    }

    public RegistrationPage submitForm(){
        $("#submit").scrollTo().click();
        return this;
    }

    public RegistrationPage checkResults(){
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
        return this;
    }

    public RegistrationPage closePopup(){
        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").should(disappear);
        return this;
    }

    }



