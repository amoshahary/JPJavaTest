package com.jptest.report;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

public class GenerateReportTest extends TestCase {
	private static final String FORMAT_DDMMYYYY = "dd/MM/yyyy";

	public void testInitializeReport() {
		List<FinancialEntity> actualList = GenerateReport.initializeReport();

        assertEquals(actualList, Arrays.asList(
        		new FinancialEntity("foo", "B", BigDecimal.valueOf(0.50), "SGP", DateUtil.stringToCalendar("01/01/2016", FORMAT_DDMMYYYY), 
        				DateUtil.stringToCalendar("02/01/2016", FORMAT_DDMMYYYY), 200, BigDecimal.valueOf(100.25)),
			new FinancialEntity("bar", "S", BigDecimal.valueOf(0.22), "AED", DateUtil.stringToCalendar("05/01/2016", FORMAT_DDMMYYYY), 
					DateUtil.stringToCalendar("07/01/2016", FORMAT_DDMMYYYY), 450, BigDecimal.valueOf(150.50)),
			new FinancialEntity("foo1", "B", BigDecimal.valueOf(1.39), "GBP", DateUtil.stringToCalendar("06/01/2016", FORMAT_DDMMYYYY), 
					DateUtil.stringToCalendar("09/01/2016", FORMAT_DDMMYYYY), 450, BigDecimal.valueOf(150.50)),
			new FinancialEntity("foo2", "S", BigDecimal.valueOf(1.00), "USD", DateUtil.stringToCalendar("07/01/2016", FORMAT_DDMMYYYY), 
					DateUtil.stringToCalendar("10/01/2016", FORMAT_DDMMYYYY), 435, BigDecimal.valueOf(183.50)),
			new FinancialEntity("bar1", "S", BigDecimal.valueOf(0.27), "SAR", DateUtil.stringToCalendar("10/02/2016", FORMAT_DDMMYYYY), 
					DateUtil.stringToCalendar("12/02/2016", FORMAT_DDMMYYYY), 435, BigDecimal.valueOf(183.50))
        ));
        
	}
}