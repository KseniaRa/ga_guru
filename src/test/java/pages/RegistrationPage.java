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

    private Calendar calendar= new Calendar;

    public RegistrationPage openPage(){

        open("/automation-practice-form");
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
    }


    public RegistrationPage typePhone(){
        $("#userNumber").setValue("9999990000");
    }

    public RegistrationPage setBirthDate(String day, String month, String year){
            calendar.setDate(day,month, year);
            return this;
        }

    public RegistrationPage chooseSubject(){
        $("#subjectsInput").setValue("M").pressEnter();
    }

    public RegistrationPage uploadPicture(){
        $("#uploadPicture").uploadFile(new File("src/test/resources/file.jpeg"));
    }

    public RegistrationPage chooseHobby(){
        $("#hobbiesWrapper").$(byText("Reading")).click();
    }

    public RegistrationPage typeAddress(){
        $("#currentAddress").setValue("some home on some street");
    }

    public RegistrationPage chooseState(){
        $("#react-select-3-input").setValue("Haryana").pressEnter();
    }

    public RegistrationPage chooseCity(){
        $("#react-select-4-input").setValue("Panipat").pressEnter();
    }

    public RegistrationPage submitForm(){
        $("#submit").scrollTo().click();
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
    }

    public RegistrationPage closePopup(){
        $("#closeLargeModal").click();
        $("#example-modal-sizes-title-lg").should(disappear);
    }

    }



