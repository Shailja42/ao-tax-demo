package com.StepDefinations;

import java.io.IOException;

import com.mainPages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyProfileStepDefination extends LoginPage  {

	@Given("I launch the application")
	public void i_launch_the_application() throws IOException {
		launch();
	}

	@Given("I enter the login details and navigate to home page")
	public void i_enter_the_login_details_and_navigate_to_home_page() throws IOException, InterruptedException {
		login();
	}


	

	

}
