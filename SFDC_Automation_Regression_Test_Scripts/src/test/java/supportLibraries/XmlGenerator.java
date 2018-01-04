package supportLibraries;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.cognizant.Craft.CRAFTTestCase;

public class XmlGenerator {
	
	public static void reRunFailedTestCases() {
		
		XmlSuite xmlSuite = new XmlSuite();
		if(CRAFTTestCase.currentPacakage.equals("SF.UATTestScripts")) {
			xmlSuite.setName("UATTestScriptsSuite");
		} else if((CRAFTTestCase.currentPacakage.equals("SF.SmokeTestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScripts")) || 
				(CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScriptsOpp")) || (CRAFTTestCase.currentPacakage.equals("SF.Release37TestScripts")) ||
						(CRAFTTestCase.currentPacakage.equals("SF.Release38TestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.Release39TestScripts")) ||
								(CRAFTTestCase.currentPacakage.equals("SF.Release40TestScripts"))) {
			xmlSuite.setName("SmokeRegTestScriptsSuite");
		}	

		xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);
		xmlSuite.setThreadCount(2);
		//xmlSuite.setVerbose(1);
		
		XmlTest xmlTest = new XmlTest(xmlSuite);
		if(CRAFTTestCase.currentPacakage.equals("SF.UATTestScripts")) {
			xmlTest.setName("UATTestScripts");
		} else if((CRAFTTestCase.currentPacakage.equals("SF.SmokeTestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScripts")) || 
				(CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScriptsOpp")) || (CRAFTTestCase.currentPacakage.equals("SF.Release37TestScripts")) ||
						(CRAFTTestCase.currentPacakage.equals("SF.Release38TestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.Release39TestScripts")) ||
								(CRAFTTestCase.currentPacakage.equals("SF.Release40TestScripts"))) {
			xmlTest.setName("SmokeRegTests");
		}	
		xmlTest.setPreserveOrder("true");
		
		List<String> testCasesList = null;
		if(CRAFTTestCase.currentPacakage.equals("SF.UATTestScripts")) {
			testCasesList = CRAFTTestCase.failedTestCase;
		} else if((CRAFTTestCase.currentPacakage.equals("SF.SmokeTestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScripts")) || 
				(CRAFTTestCase.currentPacakage.equals("SF.RegressionTestScriptsOpp")) || (CRAFTTestCase.currentPacakage.equals("SF.Release37TestScripts")) ||
						(CRAFTTestCase.currentPacakage.equals("SF.Release38TestScripts")) || (CRAFTTestCase.currentPacakage.equals("SF.Release39TestScripts")) ||
								(CRAFTTestCase.currentPacakage.equals("SF.Release40TestScripts"))) {
			testCasesList = CRAFTTestCase.failedTestCase;
		}
		String sTestCaseList = null;
		XmlClass xmlClass = null;
		List<XmlClass> listClasses = new ArrayList<XmlClass>();

		for(int i=0; i < testCasesList.size(); i++) {
			sTestCaseList = testCasesList.get(i);
			xmlClass = new XmlClass(sTestCaseList);
			listClasses.add(xmlClass);
		}				
		xmlTest.setXmlClasses(listClasses);
		
		TestNG testng = new TestNG();
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		suites.add(xmlSuite);
		testng.setXmlSuites(suites);
		testng.run(); 
	}	
}
