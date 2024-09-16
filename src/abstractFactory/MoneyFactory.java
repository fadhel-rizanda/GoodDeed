package abstractFactory;

import model.Donation;
import model.Money;

public class MoneyFactory implements DonationFactory {
	
	String donatorName;
	String donatorContact;
	String donationDescription;
	Double donationAmount; 
	String donationMessage;

	public MoneyFactory(String donatorName, String donatorContact, String donationDescription,
			Double donationAmount, String donationMessage) {
		super();
		this.donatorName = donatorName;
		this.donatorContact = donatorContact;
		this.donationDescription = donationDescription;
		this.donationAmount = donationAmount;
		this.donationMessage = donationMessage;
	}

	@Override
	public Donation createDonation() {
		// TODO Auto-generated method stub
		return new Money(donatorName, donatorContact, donationDescription, donationAmount, donationMessage);
	}

}


