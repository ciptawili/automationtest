import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/ciptawiliansyah/Documents/Automation/examp_test2/src/test/resources/features/SignUpTest.feature"},
        plugin = {"json:/Users/ciptawiliansyah/Documents/Automation/examp_test2/target/cucumber-reports/3.json"},
        monochrome = false,
        tags = {},
        glue = {"StepDefinitions"})
public class Parallel03IT {
}
