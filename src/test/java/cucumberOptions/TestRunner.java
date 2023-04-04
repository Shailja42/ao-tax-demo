package cucumberOptions;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		// path of feature file
		features = { "C:\\work-stuff\\workspace\\ao-tax\\src\\test\\java\\com\\featureFiles\\MyProfile.feature" },
		
		glue = "com.StepDefinations", 
		plugin = { "pretty", "json:target/cucumber-reports/reports.json",
				"junit:target/cucumber-reports/Cucumber.xml",
	            "html:target/cucumber-reports/reports2.html" }, 
		tags=   "@tag1",
				
		monochrome = true,
		dryRun = false
)
public class TestRunner {

}
