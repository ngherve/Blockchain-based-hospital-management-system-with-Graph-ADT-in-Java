package Entitymodels;

import blockchainmodels.Blockchain;

public class HealthCenter implements Comparable<HealthCenter>{
	
	private String HospID;
	private String HospName;
	private Blockchain hospTransactions;
	private String specialityCare;
	
	/**
	 * @param id
	 * @param name
	 * @param specialityCare
	 * @param hospTransactions
	 */
	public HealthCenter(String id, String name, String specialityCare, 
			Blockchain hospTransactions) {
		// TODO Auto-generated constructor stub
		this.HospID = id;
		this.HospName = name;
		this.hospTransactions = hospTransactions;
		this.specialityCare = specialityCare;
		
	}

	/**
	 * @return the hospID
	 */
	public String getHospID() {
		return HospID;
	}

	/**
	 * @param hospID the hospID to set
	 */
	public void setHospID(String hospID) {
		HospID = hospID;
	}

	/**
	 * @return the hospName
	 */
	public String getHospName() {
		return HospName;
	}

	/**
	 * @param hospName the hospName to set
	 */
	public void setHospName(String hospName) {
		HospName = hospName;
	}

	/**
	 * @return the hospTransactions
	 */
	public Blockchain getHospTransactions() {
		return hospTransactions;
	}

	/**
	 * @param hospTransactions the hospTransactions to set
	 */
	public void setHospTransactions(Blockchain hospTransactions) {
		this.hospTransactions = hospTransactions;
	}

	/**
	 * @return the specialityCare
	 */
	public String getSpecialityCare() {
		return specialityCare;
	}

	/**
	 * @param specialityCare the specialityCare to set
	 */
	public void setSpecialityCare(String specialityCare) {
		this.specialityCare = specialityCare;
	}

	@Override
	public int compareTo(HealthCenter hosp) {
		// TODO Auto-generated method stub
		return HospID.compareTo(hosp.getHospID());
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hospital: " + getHospName() + " Code: " + getHospID() + "\n"
				+ "Speciality Care: " + getSpecialityCare() + "\n" + getHospTransactions().toString();
	}
	
}
