package bank.view;

import java.util.ArrayList;
import java.util.Scanner;

import bank.controller.BankController;
import bank.model.vo.Bank;

public class BankMenu {
	//DI
	private Scanner sc = new Scanner(System.in);
	private BankController bController = new BankController();
	
	public BankMenu() {}
	
	public void displayMenu() {
		do {
			System.out.println("*** 계좌 관리 프로그램 ***");
			System.out.print("\n1. 관리자메뉴"
								   + "\n2. 사용자메뉴"
								   + "\n3. 프로그램 종료"
								   + "\n메뉴 선택 :");
			switch(sc.nextInt()) {
			case 1 :adminMenu(); break;
			case 2 :userMenu(); break;
			case 3 :System.out.print("종료(y), 취소(n) :");
					if(sc.next().toLowerCase().charAt(0) == 'y') {
						return;
					} else {
						break;
					}
			default : System.out.println("잘못 입력하셨습니다.");
						System.out.println("확인 후 다시 입력하세요.\n"); break;
			}
		} while(true);
	}
	
	public void adminMenu() {
		do {
			System.out.println("\n*** 관리자 메뉴 ***");
			System.out.print("\n1. 통장개설"
								+ "\n2. 전체 사용자 통장 조회"
								+ "\n3. 해당 사용자 통장 조회"
								+ "\n4. 해당 계좌 거래내역 조회"
								+ "\n5. 통장삭제"
								+ "\n6. 이전으로 돌아가기"
								+ "\n메뉴 선택 :");
			switch(sc.nextInt()) {
			case 1 :bController.bankInsert(bankInsert()); 
					  break;
			case 2 :printAllUser(bController.selectAll()); 
					  break;
			case 3 :printAllUser(bController.selectAccountNo(inputAccountNo()));
					  break;
			case 4 :printAll(bController.selectTransaction(inputAccountNo()));
					  break;
			case 5 ://deleteAccount(bController.deleteAccount(inputAccountNo()));
					   break;
			case 6 :System.out.print("이전 메뉴로 돌아가시겠습니까(y,n) ? :");
						if(sc.next().toLowerCase().charAt(0) == 'y') {
							return;
						} else {
							break;
						}
			default :System.out.println("잘못 입력하셨습니다.");
						System.out.println("확인 후 다시 입력하세요.\n");
						break;
			}
		} while(true);
	}
	
	public void userMenu() {
		do {
			System.out.println("\n*** 사용자 메뉴 ***");
			System.out.print("\n\r1. 입금"
								+ "\n2. 출금"
								+ "\n3. 계좌이체"
								+ "\n4. 계좌조회"
								+ "\n5. 이전으로 돌아가기"
								+ "\n메뉴 선택 :");
			switch(sc.nextInt()) {
			case 1 ://bController.insertDeposit(inputDeposit());
					  break;
			case 2 ://bController.insertWithdraw(inputWithdraw());
					  break;
			case 3 ://printAll(bController.selectTransaction(inputAccountNo()));
					  break;
			case 4 ://printAll(bController.selectAll(inputAccountNo()));
			case 5 :System.out.print("이전 메뉴로 돌아가시겠습니까(y,n) ? :");
					if(sc.next().toLowerCase().charAt(0) == 'y') {
						return;
					} else {
						break;
					}
			default : System.out.println("잘못 입력하셨습니다.");
						System.out.println("확인 후 다시 입력하세요.\n");
						break;
			}
		} while(true);
	}
	
	public Bank bankInsert() {
		Bank bank = new Bank();
		System.out.print("고객명 :");
		bank.setUserName(sc.next());
		System.out.print("고객주민번호[-포함] :");
		bank.setUserSsn(sc.next());
		System.out.print("첫 입금액[1000원 이상] :");
		bank.setDeposit(sc.nextInt());
		System.out.print("고객전화번호[-미포함] :");
		bank.setPhone(sc.next());
		return bank;
	}
	
	public void printAll(ArrayList<Bank> bankList) {
		if(bankList.size() > 0) {
			System.out.println(
					"고객고유번호   계좌번호      거래이름       거래일자            거래내용              입금액             출금액             잔액");
			for (Bank bank : bankList) {
				System.out.println(bank);
			}
		}
	}
	
	public void printAllUser(ArrayList<Bank> bankList) {
		for(Bank bank : bankList) {
			System.out.println(bank.getUserNo() + ", " + bank.getAccountNo() +", "+
							bank.getUserName() + ", " + bank.getOpenDate() );
		}
	}
	
	public void printOneUser(Bank bank) {
		System.out.println(bank.getUserNo() + ", " + bank.getAccountNo() +", "+
				bank.getUserName() + ", " + bank.getOpenDate() );
	}
	
	public String inputAccountNo() {
		System.out.print("계좌번호[-포함] :");
		return sc.next();
	}
	
	public String inputUserName() {
		System.out.print("고객명 :");
		return sc.next();
	}
	
	/*public void printOne(Bank bank) {
		System.out.println(bank);
	}*/
	
	public Bank inputDeposit() {
		Bank bank = new Bank();
		System.out.print("계좌번호 입력[-포함] :");
		bank.setAccountNo(sc.next());
		System.out.print("입금액 :");
		bank.setDeposit(sc.nextInt());
		return bank;
	}
	
	public Bank inputWithdraw() {
		Bank bank = new Bank();
		System.out.print("계좌번호 입력[-포함] :");
		bank.setAccountNo(sc.next());
		System.out.print("출금액 :");
		bank.setWithdraw(sc.nextInt());
		return bank;
	}
	
	public void inputDeleteAccount(Bank bank) {
		
	}
	
} 
