package com.jptest.report;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		suite.addTestSuite(GenerateReportTest.class);
		suite.addTestSuite(ReportTest.class);
		return suite;
	}

}
