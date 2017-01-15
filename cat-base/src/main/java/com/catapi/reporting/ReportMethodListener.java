package com.catapi.reporting;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;

public class ReportMethodListener implements IInvokedMethodListener, ITestListener, ISuiteListener {
	public static int testCaseCount = 0;
	public static List<Object> testSteps = new LinkedList<>();

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
		
		
		if (method.getTestMethod().isTest()) {
			testCaseCount++;
			Map<String, Object> model = new HashMap<String, Object>();
			JadeTemplate template;
			try {
				model.put("testCasesteps", testSteps);
				String fileName = getClass().getClassLoader().getResource("templates//TestCaseTemplate.Jade").getPath();
				template = Jade4J.getTemplate(fileName);
				String html = Jade4J.render(template, model);
				FileUtils.write(new File("report//resultestCase" + testCaseCount + "s.html"), html);
				FileUtils.copyDirectory(new File(getClass().getClassLoader().getResource("templates//css").getPath()),
						new File("report//css"));
				FileUtils.copyDirectory(
						new File(getClass().getClassLoader().getResource("templates//scripts").getPath()),
						new File("report//scripts"));
				///
				String result =testResult.isSuccess()?"true":"false";
				
				HashMap<String, String> testCaseDetails2 = new HashMap<>();
				testCaseDetails2.put("testCaseID", String.valueOf(testCaseCount));
				testCaseDetails2.put("testName", testResult.getName());
				testCaseDetails2.put("testDescription", method.getTestMethod().getDescription() );
				testCaseDetails2.put("result", result);
				testCaseDetails2.put("link", "resultestCase" + testCaseCount + "s.html");
				
				ReportListen.totalList.add(testCaseDetails2);

			} catch (IOException e) {
				e.printStackTrace();
			}

			testSteps.clear();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
	}

	@Override
	public void onTestSkipped(ITestResult result) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	@Override
	public void onStart(ISuite suite) {
	}

	@Override
	public void onFinish(ISuite suite) {
	}

}
