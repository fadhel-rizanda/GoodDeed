package adapter;

public class MoneyAdapter {
	String donationDescription;
	Double donationAmount;
	
	public MoneyAdapter() {
		
	}
	
	public Double convertToRupiah(String donationDescription, Double donationAmount) {
		if(donationDescription.equals("Dollar")) {
			return donationAmount = Math.round(donationAmount * 16257) * 1.0;
		}
		else if(donationDescription.equals("Euro")) {
			return donationAmount = Math.round(donationAmount * 17702) * 1.0;
		}
		else if(donationDescription.equals("Rupiah")) {
			return donationAmount = donationAmount * 1.0;
		}
		return donationAmount;
	}
}



