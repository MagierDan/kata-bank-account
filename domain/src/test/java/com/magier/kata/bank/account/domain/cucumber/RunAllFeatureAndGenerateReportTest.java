package com.magier.kata.bank.account.domain.cucumber;

import com.magier.kata.bank.account.domain.reporting.PdfSimpleReport;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BDDRunnerTest.class})
public class RunAllFeatureAndGenerateReportTest {

    @AfterClass
    public static void generateExecutionReport() throws Exception {
        new PdfSimpleReport().generate();
    }
}
