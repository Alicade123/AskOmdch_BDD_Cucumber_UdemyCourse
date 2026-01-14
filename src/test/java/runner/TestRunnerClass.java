package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step.definitions",
                "hooks",
                "parameter.type"
                },
        plugin = {"pretty",
                "html:target/cucumber_report/CucumberHTMLReport.html",
                "summary"
                },
        snippets = CAMELCASE,
        dryRun = false,
        monochrome =false,
        tags = "@dummy"
)
public class TestRunnerClass {

}
