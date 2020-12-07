package com.runner.test;

import java.io.File;
//import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/", plugin = { "json:target/cucumber.json", "pretty",
"html:target/cucumber-reports" })
public class TestRunner {

	@Test
	public void genReport() {
		Results results = Runner.parallel(getClass(), 5);
		generateReport(results.getReportDir());
	}

	public void generateReport(String karateOutputPath) {
		File reportOutputDirectory = new File("target");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/cucumber.json");
		Configuration config = new Configuration(reportOutputDirectory, "Presence-API");
		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
		reportBuilder.generateReports();
	}

}
