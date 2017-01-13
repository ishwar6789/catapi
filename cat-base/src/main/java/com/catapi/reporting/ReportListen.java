package com.catapi.reporting;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;

public class ReportListen implements IReporter {
	static List<Object> totalList = new ArrayList<>();
	
	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		Map<String, Object> model = new HashMap<String, Object>();		
		model.put("company", "NeverLand");
		JadeTemplate template;
		System.out.println("outputDirectory : " + outputDirectory);
		
		for (ISuite suite : suites) {
			// Following code gets the suite name
			String suiteName = suite.getName();			
			model.put("name", suiteName);
			// Getting the results for the said suite
			Map suiteResults = suite.getResults();
			for (Object sr : suiteResults.values()) {
				ISuiteResult k = (ISuiteResult) sr;
				ITestContext tc = k.getTestContext();
				
				System.out.println(
						"Passed tests for suite '" + suiteName + "' is:" + tc.getPassedTests().getAllResults().size());
				System.out.println(
						"Failed tests for suite '" + suiteName + "' is:" + tc.getFailedTests().getAllResults().size());
				System.out.println("Skipped tests for suite '" + suiteName + "' is:"
						+ tc.getSkippedTests().getAllResults().size());
			}
		}
		
		
		
		try {
			model.put("testCaseListTotal", totalList);
			String fileName = getClass().getClassLoader().getResource("templates//TestSuite.Jade").getPath();
			template = Jade4J.getTemplate(fileName);
			String html = Jade4J.render(template, model);
			FileUtils.write(new File("report//results.html"), html);
			FileUtils.copyDirectory(new File(getClass().getClassLoader().getResource("templates//css").getPath()),
					new File("report//css"));
			FileUtils.copyDirectory(new File(getClass().getClassLoader().getResource("templates//scripts").getPath()),
					new File("report//scripts"));

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
