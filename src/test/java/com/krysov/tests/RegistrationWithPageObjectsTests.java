package com.krysov.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationWithPageObjectsTests extends com.krysov.tests.TestBase {

    @Test
    @Owner("Alex Krysov")
    @DisplayName("Check filling form")
    void successfulRegistrationTest() {
        String userName = "Alex";
        String lastName = "Ivanov";
        String Email = "Ivan@ivanov.com";
        String gender = "Other";
        String Mobile = "1231231234";
        String dayBirth = "30";
        String monthBirth = "July";
        String yearBirth = "2008";
        String Subjects = "biology";
        String Hobbies = "Sports";
        String Picture = "img/1.png";
        String CurrentAddress = "street 7";
        String State = "NCR";
        String City = "Delhi";

        step("Open registrations form", () -> {
            registrationPage.openPage();
        });
        step("Fill form", () -> {
            registrationPage.setFirstName(userName)
                    .setLastName(lastName)
                    .setEmail(Email)
                    .setGender(gender)
                    .setPhone(Mobile)
                    .setBirthDate(dayBirth, monthBirth, yearBirth)
                    .setSubjects(Subjects)
                    .setHobbies(Hobbies)
                    .setPicture(Picture)
                    .setAddress(CurrentAddress)
                    .setState(State)
                    .setCity(City)
                    .submit();
        });
        step("Check form results", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResult("Student Name", userName + " " + lastName)
                    .verifyResult("Student Email", Email)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", Mobile)
                    .verifyResult("Date of Birth", dayBirth + " " + monthBirth + "," + yearBirth)
                    .verifyResult("State and City", State + " " + City)
                    .verifyResult("Subjects", Subjects);
        });
    }
}
