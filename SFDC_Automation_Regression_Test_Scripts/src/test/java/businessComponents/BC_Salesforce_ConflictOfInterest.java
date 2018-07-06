package businessComponents;

import com.cognizant.Craft.ReusableLibrary;
import com.cognizant.Craft.ScriptHelper;
import pageObjects.ConflictOfInterest;

/**
 * Business Components Class for validating functionalities related to Conflict Of Interest Outcome Flag
 * 
 * @author Vishnuvardhan
 *
 */

public class BC_Salesforce_ConflictOfInterest extends ReusableLibrary {
	/**
	 * Constructor to initialize the component library
	 * 
	 * @param scriptHelper
	 *            The {@link ScriptHelper} object passed from the
	 *            {@link DriverScript}
	 */
	public BC_Salesforce_ConflictOfInterest(ScriptHelper scriptHelper) {
		super(scriptHelper);
	}


	ConflictOfInterest conflictOfInterest = new ConflictOfInterest(scriptHelper);
	
	/**
	 * Validating the launching the browser functionality 
	 * 
	 * @author Vishnuvardhan
	 *
	 */	
	
	public void bc_validateCOIOutcomeFlag() throws InterruptedException {
		conflictOfInterest.validateCoIOutcomeFlag();
	}
	
}