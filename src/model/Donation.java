package model;

import java.util.Random;

public abstract class Donation {
	String donationID;
	String donatorName;
	String donatorContact;
	String donationType; 
	String donationDescription;
	Double donationAmount; 
	String donationMessage;
	
	public Donation(String donatorName, String donatorContact, String donationType,
			String donationDescription, Double donationAmount, String donationMessage) {
		super();
		this.donationID = setDonationID();
		this.donatorName = donatorName;
		this.donatorContact = donatorContact;
		this.donationType = donationType;
		this.donationDescription = donationDescription;
		this.donationAmount = donationAmount;
		this.donationMessage = donationMessage;
	}
	
	public String getDonationID() {
		return donationID;
	}

	public String getDonatorName() {
		return donatorName;
	}

	public String getDonatorContact() {
		return donatorContact;
	}

	public String getDonationType() {
		return donationType;
	}

	public String getDonationDescription() {
		return donationDescription;
	}

	public Double getDonationAmount() {
		return donationAmount;
	}

	public String getDonationMessage() {
		return donationMessage;
	}

	public String setDonationID() {
		Random random = new Random();
		StringBuilder accountNumber = new StringBuilder();
		for(int i=0;i<12;i++) {
			 accountNumber.append(random.nextInt(10));
		}
		return accountNumber.toString();
	}
}


