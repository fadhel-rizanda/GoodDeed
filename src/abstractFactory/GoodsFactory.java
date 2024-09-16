package abstractFactory;

import model.Donation;
import model.Goods;

public class GoodsFactory implements DonationFactory {
	
	String donatorName;
	String donatorContact;
	String donationDescription;
	Double donationAmount; 
	String donationMessage;
	
	public GoodsFactory(String donatorName, String donatorContact, String donationDescription,
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
		return new Goods(donatorName, donatorContact, donationDescription, donationAmount, donationMessage);
	}

}


