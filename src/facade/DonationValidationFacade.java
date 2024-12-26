package facade;

import abstractFactory.GoodsFactory;
import abstractFactory.MoneyFactory;
import adapter.MoneyAdapter;
import model.Donation;
import singleton.DonationSingleton;

import java.util.Scanner;
import java.util.Vector;

public class DonationValidationFacade {
	Vector<Donation> donationList = new Vector<>();
	DonationSingleton database = DonationSingleton.getInstance(donationList);
	
	Scanner scan = new Scanner(System.in);
	

    public void makeDonation() {
        String donationType;
        String donatorName;
        String donatorContact;
        String donationDescription;
        Double donationAmount; 
        String donationMessage;

        do {
            System.out.print("Input Donation Type [Money | Goods]: ");
            donationType = scan.nextLine();
        } while (!(donationType.equals("Money") || donationType.equals("Goods")));

        do {
            System.out.print("Input Your Name[maximum 20 characters]: ");
            donatorName = scan.nextLine();
        } while (donatorName.trim().equals("") || donatorName.length() > 20);

        do {
            System.out.print("Input Your Phone Number [must contain 9 - 12 numbers]: +62 ");
            donatorContact = scan.nextLine();            
        } while (donatorContact.length() < 9 || donatorContact.length() > 12);

        if (donationType.equals("Money")) {
            do {
                System.out.print("Input Your Currency [Dollar | Euro | Rupiah]: ");
                donationDescription = scan.nextLine();
            } while (!(donationDescription.equals("Dollar") || donationDescription.equals("Euro") || donationDescription.equals("Rupiah")));

            System.out.print("Input Money Amount[must be a number]: ");
            donationAmount = scan.nextDouble();
            scan.nextLine();            
        } else {
            do {
                System.out.print("Input Your Goods Name[maximum 20 characters]: ");
                donationDescription = scan.nextLine();
            } while (donationDescription.equals("") || donationDescription.length() > 20);

            System.out.print("Input Goods Quantity[must be a number]: ");
            donationAmount = scan.nextDouble();
            scan.nextLine();
        }

        System.out.print("Input Your Message[optional]: ");
        donationMessage = scan.nextLine();

        if (donationType.equals("Money")) {
            MoneyFactory mf = new MoneyFactory(donatorName, donatorContact, donationDescription, donationAmount, donationMessage);
            Donation donateMoney = mf.createDonation();
            database.addDonationlist(donateMoney);
        } else {
            GoodsFactory gf = new GoodsFactory(donatorName, donatorContact, donationDescription, donationAmount, donationMessage);
            Donation donateGoods = gf.createDonation();
            database.addDonationlist(donateGoods);            
        }
    }

    public void viewDonationList() {
        Vector<Donation> viewDonationList = database.readDonationList();
        MoneyAdapter moneyAdapter = new MoneyAdapter();
        if (viewDonationList.isEmpty()) {
            System.out.println("No Donations Made Yet");
            return;
        } else {
            System.out.println("=============================================================================================================================================================================");
            System.out.printf("|| %-167s ||\n","                                                                   GoodsDeed Donation List");
            System.out.println("=============================================================================================================================================================================");
            System.out.printf("|| %-2s || %-12s || %-20s || %-15s || %-15s || %-20s || %-30s || %-25s ||\n",
                                "No", "Donation ID", "    Donator Name", "Donator Contact", " Donation Type", "Donation Description", "        Donation Ammount", "    Donation Message");
            System.out.println("=============================================================================================================================================================================");

            int no = 1;

            for (Donation donation : viewDonationList) {
                String format = "|| %-2d || %-12s || %-20s || %-15s || %-15s || %-20s || %-30s || %-25s ||\n";
                if (donation.getDonationType().equals("Money")) {
                   if(donation.getDonationDescription().equals("Dollar") || donation.getDonationDescription().equals("Euro")) {
                	   System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(), donation.getDonationAmount() 
                			   + " (Rp " + moneyAdapter.convertToRupiah(donation.getDonationDescription(), donation.getDonationAmount()) + ")", donation.getDonationMessage());
                   }
                   else {
                	   System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(),
                			   "Rp " + donation.getDonationAmount(), donation.getDonationMessage());
                   }
                } else {
                    System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(), 
                    		+donation.getDonationAmount() + " items", donation.getDonationMessage());
                }
            }

            System.out.println("=============================================================================================================================================================================");        
        }
    }

    public void cancelDonation() {
        Vector<Donation> cancelDonationList = database.readDonationList();
        String cancelDonationID;
        String cancelProcess = "N";

        viewDonationList();

        if (cancelDonationList.isEmpty()) {
            return;
        }
        System.out.println();
        do {            
            System.out.print("Input Donation ID to cancel donation: ");
            cancelDonationID = scan.nextLine();

            for (Donation donation : cancelDonationList) {
                if (cancelDonationID.equals(donation.getDonationID())) {
                    database.deleteDonationList(cancelDonationID);
                    System.out.println("Your Cancelation Process Succeed");
                    System.out.println("Your Donation Has Been Canceled");
                    return;
                }
            }

            System.out.println("Invalid Donation ID. Please try again");
            do {
                System.out.print("Do you want to continue Process [Y|N]: ");
                cancelProcess = scan.nextLine();
            } while (!(cancelProcess.equals("Y") || cancelProcess.equals("N")));

        } while (cancelProcess.equalsIgnoreCase("Y"));
        System.out.println("Your Cancelation Process Has Been Terminated");
    }

	    public void cancelDonation() {
        Vector<Donation> cancelDonationList = database.readDonationList();
        String cancelDonationID;
        String cancelProcess = "N";

	 Vector<Donation> viewDonationList = database.readDonationList();
        MoneyAdapter moneyAdapter = new MoneyAdapter();
        if (viewDonationList.isEmpty()) {
            System.out.println("No Donations Made Yet");
            return;
        } else {
            System.out.println("=============================================================================================================================================================================");
            System.out.printf("|| %-167s ||\n","                                                                   GoodsDeed Donation List");
            System.out.println("=============================================================================================================================================================================");
            System.out.printf("|| %-2s || %-12s || %-20s || %-15s || %-15s || %-20s || %-30s || %-25s ||\n",
                                "No", "Donation ID", "    Donator Name", "Donator Contact", " Donation Type", "Donation Description", "        Donation Ammount", "    Donation Message");
            System.out.println("=============================================================================================================================================================================");

            int no = 1;

            for (Donation donation : viewDonationList) {
                String format = "|| %-2d || %-12s || %-20s || %-15s || %-15s || %-20s || %-30s || %-25s ||\n";
                if (donation.getDonationType().equals("Money")) {
                   if(donation.getDonationDescription().equals("Dollar") || donation.getDonationDescription().equals("Euro")) {
                	   System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(), donation.getDonationAmount() 
                			   + " (Rp " + moneyAdapter.convertToRupiah(donation.getDonationDescription(), donation.getDonationAmount()) + ")", donation.getDonationMessage());
                   }
                   else {
                	   System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(),
                			   "Rp " + donation.getDonationAmount(), donation.getDonationMessage());
                   }
                } else {
                    System.out.printf(format, no++, donation.getDonationID(), donation.getDonatorName(), donation.getDonatorContact(), donation.getDonationType(), donation.getDonationDescription(), 
                    		+donation.getDonationAmount() + " items", donation.getDonationMessage());
                }
            }

            System.out.println("=============================================================================================================================================================================");        
        }

        if (cancelDonationList.isEmpty()) {
            return;
        }
        System.out.println();
        do {            
            System.out.print("Input Donation ID to cancel donation: ");
            cancelDonationID = scan.nextLine();

            for (Donation donation : cancelDonationList) {
                if (cancelDonationID.equals(donation.getDonationID())) {
                    database.deleteDonationList(cancelDonationID);
                    System.out.println("Your Cancelation Process Succeed");
                    System.out.println("Your Donation Has Been Canceled");
                    return;
                }
            }

            System.out.println("Invalid Donation ID. Please try again");
            do {
                System.out.print("Do you want to continue Process [Y|N]: ");
                cancelProcess = scan.nextLine();
            } while (!(cancelProcess.equals("Y") || cancelProcess.equals("N")));

        } while (cancelProcess.equalsIgnoreCase("Y"));
        System.out.println("Your Cancelation Process Has Been Terminated");
    }
}
