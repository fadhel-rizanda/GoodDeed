package singleton;

import java.util.Iterator;
import java.util.Vector;

import model.Donation;

public class DonationSingleton {
	Vector<Donation> donationList;
	
	private static volatile DonationSingleton instance;

	public DonationSingleton(Vector<Donation> donationList) {
		super();
		this.donationList = donationList;
	}
	
	public static DonationSingleton getInstance(Vector<Donation> donationList) {
		if(instance == null) {
			synchronized (DonationSingleton.class) {
				if(instance == null) {
					return new DonationSingleton(donationList);
				}
			}
		}
		return instance;
	}
	
	public void addDonationlist(Donation newDonation) {
		donationList.add(newDonation);
	}
	
	public Vector<Donation> readDonationList(){
		return this.donationList;
	}
	
	public void deleteDonationList(String donationID) {
		Iterator<Donation> iterator = donationList.iterator();
		while(iterator.hasNext()) {
			Donation donation = iterator.next();
			if(donation.getDonationID().equals(donationID)) {
				iterator.remove();
			}
		}
	}
	
}


