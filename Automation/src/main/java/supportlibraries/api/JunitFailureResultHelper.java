/*package supportlibraries.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.cognizant.framework.Util;

//import com.focus.report.ReportAttribute;

import freemarker.template.Configuration;
import freemarker.template.Template;
import supportlibraries.TestResult;

public class JunitFailureResultHelper {
	String reportFile;
	String summaryFile;
	String Path;

	public JunitFailureResultHelper(String path) {
		this.Path = path;
		this.reportFile = path + Util.getFileSeparator() + "SummaryWithFailure.html";
		this.summaryFile = path + "\\HTML Results\\Summary.Html";

	}

	public void GenerateHTMLReport() {
		// reportFile = path + Util.getFileSeparator() +
		// "SummaryWithFailure.html";
		// summaryFile = path + "\\HTML Results\\Summary.Html";
		List<TestResult> reportAttr = new ArrayList<>();
		try {
			reportAttr = readJunitReport();
		} catch (ParserConfigurationException | SAXException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Configuration cfg = new Configuration(Configuration.VERSION_2_3_0);
		try {
			// Load template from source folder
			// cfg.setClassForTemplateLoading(this.getClass(), "");
			cfg.setDirectoryForTemplateLoading(new File("src/main/resources"));
			// System.out.println(this.getClass());
			Template template = cfg.getTemplate("template.ftl");
			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();

			data.put("testResultMap", reportAttr);

			Writer file = new FileWriter(new File(reportFile));
			template.process(data, file);
			file.flush();
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		CombineReports();

	}

	private void CombineReports() {

		try {
			String SummaryString = IOUtils.toString(new FileInputStream(summaryFile));
			String reportString = IOUtils.toString(new FileInputStream(reportFile));
			// System.out.println(SummaryString + "<br/><br/>"+ reportString);
			Writer file = new FileWriter(new File(reportFile));
			file.write(SummaryString + "<br/><br/>" + reportString);
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<TestResult> readJunitReport() throws ParserConfigurationException, SAXException, IOException {

		List<TestResult> resultMap = new ArrayList<TestResult>();
		String[] filter = { "xml" };
		Collection<File> file = FileUtils.listFiles(new File(this.Path), filter, true);
		for (File fXmlFile : file) {
			// File fXmlFile = new File(files);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			NodeList nl = doc.getDocumentElement().getChildNodes();
			// System.out.println(atr);
			if (nl != null && nl.getLength() > 0) {
				for (int i = 0; i < nl.getLength(); i++) {
					if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
						Element el = (Element) nl.item(i);
						if (el.getNodeName().contains("testcase")) {
							String classname = el.getAttribute("classname");
							String casename = el.getAttribute("name");
							if (el.getChildNodes().getLength() > 0) {
								Element childNode = (Element) el.getElementsByTagName("failure").item(0);
								String exceptionText = childNode.getTextContent().substring(0, 200);
								exceptionText = exceptionText.replace("\n", "<br/>").concat("...");
								resultMap.add(new TestResult(casename, classname, 1, exceptionText.toString(),
										childNode.getAttribute("type"), el.getAttribute("time")));
							}
						}
					}
				}

			}
		}
		return resultMap;
	}

	public String getPassPercentage() throws ParserConfigurationException, SAXException, IOException {
		String PercentagePass = "";
		String[] filter = { "xml" };
		Collection<File> file = FileUtils.listFiles(new File(this.Path), filter, true);
		for (File fXmlFile : file) {
			// File fXmlFile = new File(files);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Element nl = (Element) doc.getDocumentElement().getChildNodes();
			if (nl.getTagName().equals("testsuite")) {
				int totalTests = Integer.parseInt(nl.getAttribute("tests"));
				int failedTests = Integer.parseInt(nl.getAttribute("failures"));
				PercentagePass = String.valueOf(((totalTests - failedTests) * 100) / totalTests) + "%; (" + "Executed: "
						+ totalTests + " Pass : " + (totalTests - failedTests) + " Fail : " + failedTests + ")";
			}
		}
		return PercentagePass;

	}

	public int getTotalTests() throws ParserConfigurationException, SAXException, IOException {

		String[] filter = { "xml" };
		Collection<File> file = FileUtils.listFiles(new File(this.Path), filter, true);
		for (File fXmlFile : file) {
			// File fXmlFile = new File(files);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();

			Element nl = (Element) doc.getDocumentElement().getChildNodes();
			if (nl.getTagName().equals("testsuite")) {
				int totalTests = Integer.parseInt(nl.getAttribute("tests"));
			}
		}

		return 0;

	}
}
*/