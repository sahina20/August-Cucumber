package RunnerPkg;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(features="C:\\Users\\Sahina\\eclipse-workspace\\AugustCucumberSession\\src\\test\\java\\features",
                glue="step_definitions",
                monochrome= true,
                plugin={"pretty", "html:target/ExecutionReport"},
                tags= "@Test")
public class Runner {

}
