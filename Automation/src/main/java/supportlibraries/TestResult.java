package supportlibraries;

/**
 * 
 * @author Vishnuvardhan
 *
 */
public class TestResult {

	private String testCaseName;
	private String testClassName;
	private int result;
	private String reason;
	private float executionTime;
	private String failureType;
	public TestResult(String testCaseName, String testClassName, int result, String reason, String failureType, String executionTime){
		this.testCaseName = testCaseName;
		this.testClassName = testClassName;
		this.result = result;
		this.reason = reason;
		this.executionTime = Float.parseFloat(executionTime);
		this.setFailureType(failureType);
	}

	public String getTestCaseName() {
		return testCaseName;
	}

	public void setTestCaseName(String testCaseName) {
		this.testCaseName = testCaseName;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getTestClassName() {
		return testClassName;
	}

	public void setTestClassName(String testClassName) {
		this.testClassName = testClassName;
	}

	public float getExecutionTime() {
		return executionTime;
	}

	public void setExecutionTime(float executionTime) {
		this.executionTime = executionTime;
	}

	public String getFailureType() {
		return failureType;
	}

	public void setFailureType(String failureType) {
		this.failureType = failureType;
	}
	
}
