package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.Calendar;
import pages.components.ResultModal;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectsPage {
    private Calendar calendar = new Calendar();
    private ResultModal resultModal = new ResultModal();

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderCheckBox = $("#genterWrapper"),
            numberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesCheckBox =  $("#hobbiesWrapper"),
            uploadPictureButton = $("#uploadPicture"),
            addressInput = $("#currentAddress"),
            stateSelect = $("#react-select-3-input"),
            citySelect = $("#react-select-4-input"),
            submitButton = $("#submit");

    public PracticeFormPageObjectsPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public PracticeFormPageObjectsPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public PracticeFormPageObjectsPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public PracticeFormPageObjectsPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public PracticeFormPageObjectsPage setGender(String gender) {
        genderCheckBox.$(byText(gender)).click();
        return this;
    }

    public PracticeFormPageObjectsPage setNumber(String number) {
        numberInput.setValue(number);
        return this;
    }

    public PracticeFormPageObjectsPage setBirthdate(String year, String month, String day){
        dateOfBirthInput.click();
        calendar.setDate(year,month,day);
        return this;
    }

    public PracticeFormPageObjectsPage setSubjects(String subjects) {
        subjectsInput.setValue(subjects).pressEnter();
        return this;
    }

    public PracticeFormPageObjectsPage setHobbies(String hobbies) {
        hobbiesCheckBox.$(byText(hobbies)).click();
        return this;
    }

    public PracticeFormPageObjectsPage uploadPicture(String value) throws IOException, URISyntaxException {
        uploadPictureButton.uploadFile(download(value));
        return this;
    }

    public PracticeFormPageObjectsPage setAddress(String address) {
        addressInput.setValue(address);
        return this;
    }

    public PracticeFormPageObjectsPage setState(String state) {
        stateSelect.setValue(state).pressTab();
        return this;
    }

    public PracticeFormPageObjectsPage setCity(String city) {
        citySelect.setValue(city).pressTab();
        return this;
    }

    public PracticeFormPageObjectsPage clickSubmit() {
        submitButton.pressEnter();
        return this;
    }

    public PracticeFormPageObjectsPage checkResultsVisible() {
        resultModal.checkResultsVisible();
        return this;
    }

    public PracticeFormPageObjectsPage checkResult(String key, String value) {
        resultModal.checkResult(key, value);
        return this;
    }

    public PracticeFormPageObjectsPage closeResultModal() {
        resultModal.closeResultModal();
        return this;
    }
}
