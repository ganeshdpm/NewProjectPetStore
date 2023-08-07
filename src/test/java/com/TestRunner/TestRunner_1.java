package com.TestRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/feature/",
        glue = {"com.stepdefinition"},plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = "@PetStore_Regression",
        dryRun = false,
        monochrome = true
)

public class TestRunner_1 {


}