package com.User;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormatSymbols;

public class Account {
	// variables
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	// private String history;

	Scanner input = new Scanner(System.in);
	// DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
// public static void main(String[] args)
// {
//     double harga = 999999999.00;
 
//     DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
//     DecimalFormatSymbols dfs = new DecimalFormatSymbols();
//     dfs.setCurrencySymbol("");
//     dfs.setMonetaryDecimalSeparator(',');
//     dfs.setGroupingSeparator('.');
//     df.setDecimalFormatSymbols(dfs);
//     String hsl = "Rp. " + df.format(harga);
//     System.out.println(hsl);
// }

	public Account() {
	}

	public Account(int customerNumber, int pinNumber) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
	}

	public Account(int customerNumber, int pinNumber, double checkingBalance, double savingBalance) {
		this.customerNumber = customerNumber;
		this.pinNumber = pinNumber;
		this.checkingBalance = checkingBalance;
		this.savingBalance = savingBalance;
	}

	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public double calcCheckingWithdraw(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	public double calcSavingWithdraw(double amount) {
		savingBalance = (savingBalance - amount);
		return savingBalance;
	}

	public double calcCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	public double calcSavingDeposit(double amount) {
		savingBalance = (savingBalance + amount);
		return savingBalance;
	}

	public void calcCheckTransfer(double amount) {
		checkingBalance = checkingBalance - amount;
		savingBalance = savingBalance + amount;
	}

	public void calcSavingTransfer(double amount) {
		savingBalance = savingBalance - amount;
		checkingBalance = checkingBalance + amount;
	}

	public void getCheckingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + checkingBalance);
				System.out.print("\nAmount you want to withdraw from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance - amount) >= 0 && amount >= 0) {
					calcCheckingWithdraw(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + checkingBalance);
					end = true;
				} else {
					System.out.println("\nBalance Cannot be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getsavingWithdrawInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
				System.out.print("\nAmount you want to withdraw from Savings Account: ");
				double amount = input.nextDouble();
				if ((savingBalance - amount) >= 0 && amount >= 0) {
					calcSavingWithdraw(amount);
					System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
					end = true;
				} else {
					System.out.println("\nBalance Cannot Be Negative.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getCheckingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Checkings Account Balance: " + checkingBalance);
				System.out.print("\nAmount you want to deposit from Checkings Account: ");
				double amount = input.nextDouble();
				if ((checkingBalance + amount) >= 100000 && amount <= 1000000000 ) {
					calcCheckingDeposit(amount);
					System.out.println("\nCurrent Checkings Account Balance: " + checkingBalance);
					end = true;
				} else {
					System.out.println("\ncan't be under a hundred thousand.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getSavingDepositInput() {
		boolean end = false;
		while (!end) {
			try {
				System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
				System.out.print("\nAmount you want to deposit into your Savings Account: ");
				double amount = input.nextDouble();

				if ((savingBalance + amount) >= 100000 && amount <= 1000000000) {
					calcSavingDeposit(amount);
					System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
					end = true;
				} else {
					System.out.println("\ncan't be under a hundred thousand.");
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void getTransferInput(String accType) {
		boolean end = false;
		while (!end) {
			try {
				if (accType.equals("Checkings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to:");
					System.out.println("1. Savings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
					
						System.out.println("\nCurrent Checkings Account Balance: " + checkingBalance);

						System.out.println("masukan nomer rekening tujuan:");
						int norek = input.nextInt();
						System.out.println("No rekening Tujuan:" + norek);

						System.out.println("masukan nama pemilik:" );
						String nama = input.nextLine();
						System.out.println("nama pemilik:" + nama);

						System.out.print("\nAmount you want to deposit into your Savings Account: ");
						double amount = input.nextDouble();
						if ((savingBalance + amount) >= 0 && (checkingBalance - amount) >= 0 && amount >= 0) {
							calcCheckTransfer(amount);
							System.out.print("nama pemilik:" + nama);
							System.out.print("No rekening Tujuan:" + norek);
							System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
							System.out.println(
									"\nCurrent Checkings Account Balance: " + checkingBalance);
							System.out.println("anda yakin ingin transfer ke rekening ini?");		
							System.out.println("1. yes");
							System.out.println("2. no");
							int konfir = input.nextInt();
							switch (konfir) {
								case 1:
									System.out.println("data berhasil ditransfer");
									end = true;
									break;
								default:
									System.out.println("data gagal ditransfer");
									break;
							}

							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				} else if (accType.equals("Savings")) {
					System.out.println("\nSelect an account you wish to tranfers funds to: ");
					System.out.println("1. Checkings");
					System.out.println("2. Exit");
					System.out.print("\nChoice: ");
					int choice = input.nextInt();
					switch (choice) {
					case 1:
						System.out.println("\nCurrent Savings Account Balance: " + savingBalance);
						System.out.print("\nAmount you want to deposit into your savings account: ");
						double amount = input.nextDouble();
						if ((checkingBalance + amount) >= 0 && (savingBalance - amount) >= 0 && amount >= 0) {
							calcSavingTransfer(amount);
							System.out.println("\nCurrent checkings account balance: " + checkingBalance);
							System.out.println("\nCurrent savings account balance: " + savingBalance);
							end = true;
						} else {
							System.out.println("\nBalance Cannot Be Negative.");
						}
						break;
					case 2:
						return;
					default:
						System.out.println("\nInvalid Choice.");
						break;
					}
				}
			} catch (InputMismatchException e) {
				System.out.println("\nInvalid Choice.");
				input.next();
			}
		}
	}

	public void gettransactionhistory() {

		System.out.println("HISTORY Transactions:");
		System.out.println("===================");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));



		System.out.println("No Rekening:");
		System.out.println(getPinNumber());

		System.out.println("Checking Balance:");
		System.out.println(getCheckingBalance());

		System.out.println("Saving Balance:");
		System.out.println(getSavingBalance());
	}
}