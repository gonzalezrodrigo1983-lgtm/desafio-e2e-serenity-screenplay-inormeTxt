package com.bancaecuador.e2e.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = "com.bancaecuador.e2e.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    plugin = {
        "pretty",
        "json:target/cucumber-reports/e2e-cucumber.json",
        "html:target/cucumber-reports/e2e-cucumber-html"
    },
    tags = "not @manual"
)
public class CucumberTestSuite {}
