package com.magier.kata.bank.account.domain.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Dan on 25/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/cucumber",
        glue = {"com.magier.kata.bank.account.domain"},
        format = {"json:target/cucumber/wikipedia.json", "html:target/cucumber/wikipedia.html", "pretty"},
        tags = {"~@wip"}
)
public class BDDRunnerTest {
}
