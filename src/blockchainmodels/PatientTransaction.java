package blockchainmodels;

public class PatientTransaction {

	private String patientInsuranceAmount;
	private String patFullName;
	private String patientsDoct;
	private String patDisease;
	private String patPrescription;
	private String patientID;

	/**
	 * @param patientInsuranceAmount
	 * @param patFullName
	 * @param patientsDoct
	 * @param patDisease
	 * @param patPrescription
	 */
	public PatientTransaction(String patID, String patientInsuranceAmount, String patFullName, 
			String patientsDoct, String patDisease, String patPrescription) { 
		
		this.patientID = patID;
		this.patientInsuranceAmount = patientInsuranceAmount;
	    this.patFullName = patFullName;
	    this.patientsDoct = patientsDoct;
	    this.patDisease = patDisease;
	    this.patPrescription = patPrescription;
	}

	/**
	 * @return
	 */
	public boolean isValid() {
		 
		return true;
	}

	/**
	 * @return the patientInsuranceAmount
	 */
	public String getPatientInsuranceAmount() {
		return patientInsuranceAmount;
	}

	/**
	 * @param patientInsuranceAmount the patientInsuranceAmount to set
	 */
	public void setPatientInsuranceAmount(String patientInsuranceAmount) {
		this.patientInsuranceAmount = patientInsuranceAmount;
	}

	/**
	 * @return the patFullName
	 */
	public String getPatFullName() {
		return patFullName;
	}

	/**
	 * @param patFullName the patFullName to set
	 */
	public void setPatFullName(String patFullName) {
		this.patFullName = patFullName;
	}

	/**
	 * @return the patientsDoct
	 */
	public String getPatientsDoct() {
		return patientsDoct;
	}

	/**
	 * @param patientsDoct the patientsDoct to set
	 */
	public void setPatientsDoct(String patientsDoct) {
		this.patientsDoct = patientsDoct;
	}

	/**
	 * @return the patDisease
	 */
	public String getPatDisease() {
		return patDisease;
	}

	/**
	 * @param patDisease the patDisease to set
	 */
	public void setPatDisease(String patDisease) {
		this.patDisease = patDisease;
	}

	/**
	 * @return the patPrescription
	 */
	public String getPatPrescription() {
		return patPrescription;
	}

	/**
	 * @param patPrescription the patPrescription to set
	 */
	public void setPatPrescription(String patPrescription) {
		this.patPrescription = patPrescription;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}
}
