package client;

import java.util.Scanner;
import facade.DonationValidationFacade;

public class Client {
	Scanner scan = new Scanner(System.in);
	DonationValidationFacade donationValidationFacade = new DonationValidationFacade();
	
	public void showMenu() {
		int mainMenu;
		do {
			for (int i = 0; i < 50; ++i) System.out.println();
			System.out.println("============================");
			System.out.println("||         GoodDeed       ||");
			System.out.println("============================");
			System.out.println("|| 1. Make Donation       ||");
			System.out.println("|| 2. View Donations      ||");
			System.out.println("|| 3. Cancel Donation     ||");
			System.out.println("|| 0. Exit                ||");			
			System.out.println("============================");
			System.out.print(">> ");
			mainMenu = scan.nextInt();
			scan.nextLine();
			switch (mainMenu) {
			case 1:
				for (int i = 0; i < 50; ++i) System.out.println();
				donationValidationFacade.makeDonation();
				System.out.println("Press Enter to Continue...");
				scan.nextLine();
				break;
				
			case 2:
				for (int i = 0; i < 50; ++i) System.out.println();
				donationValidationFacade.viewDonationList();
				System.out.println("Press Enter to Continue...");
				scan.nextLine();
				break;
				
			case 3:
				for (int i = 0; i < 50; ++i) System.out.println();
				donationValidationFacade.cancelDonation();
				System.out.println("Press Enter to Continue...");
				 scan.nextLine();
				break;

			default:
				break;
			}
			if(mainMenu == 0) {
				System.out.println("Thank you for using GoodDeed! Your contributions make a difference.");
				System.out.println("Press Enter to Continue...");
				 scan.nextLine();
				 System.out.println("Bye !!!");
			}
		} while (mainMenu != 0);
	}
	
	public Client() {			
		showMenu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client();
	}

}



