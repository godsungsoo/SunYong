package bank.controller;

import java.util.ArrayList;

import bank.model.service.BankService;
import bank.model.vo.Bank;

public class BankController {
	//DI
	private BankService bService = new BankService();
	
	public void bankNewInsert(Bank bank) {
		int result = bService.bankNewInsert(bank);
		
		if(result > 0) {
			System.out.println("\n통장 개설 완료!");
		}else {
			System.out.println("\n통장 개설 실패!");
			System.out.println("확인하고 다시 입력하세요.");
		}
		return;
	}
	
	public void bankOldInsert(Bank bank) {
		int result = bService.bankOldInsert(bank);
		
		if(result > 0) {
			System.out.println("\n통장 개설 완료!");
		}else {
			System.out.println("\n통장 개설 실패!");
			System.out.println("확인하고 다시 입력하세요.");
		}
	}

	public ArrayList<Bank> selectAll() {
		ArrayList<Bank> bankList = bService.selectAll();
		
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}else {
			System.out.println("통장 조회 완료!");
		}
		return bankList;
	}

	public ArrayList<Bank> selectName(String userName) {
		ArrayList<Bank> bankList = bService.selectName(userName);
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}else {
			System.out.println("이름으로 통장 조회 완료!");
		}
		return bankList;
	}
	
	public ArrayList<Bank> selectAccount(String accountNo) {
		ArrayList<Bank> bankList = bService.selectAccount(accountNo);
		
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}else {
			System.out.println("계좌번호로 거래내역 조회 완료!");
		}
		return bankList;
	}

	public int updatePhone(Bank bank) {
		int result = bService.updatePhone(bank);
		
		if(result <= 0) {
			System.out.println("\n변경 실패!!!");
		}else {
			System.out.println("전화번호 변경 성공!!!");
		}
		return result;
	}

	public int deleteAccount(Bank bank) {
		int result = bService.deleteAccount(bank);
		
		if(result <= 0) {
			System.out.println("\n삭제 실패!!!");
		}else {
			System.out.println("통장 삭제 성공!!!");
		}
		return result;
	}

	public int insertDeposit(Bank bank) {
		int result = bService.insertDeposit(bank);
		
		if(result <= 0) {
			System.out.println("\n입금 실패!!!");
		}else {
			System.out.println("입금 성공!!!");
		}
		return result;
	}

	public int insertWithdraw(Bank bank) {
		int result = bService.insertWithdraw(bank);
		
		if(result <= 0) {
			System.out.println("\n출금 실패!!!");
		}else {
			System.out.println("출금 성공!!!");
		}
		return result;
		
	}

	public ArrayList<Bank> selectUserAcc(String accountNo) {
		ArrayList<Bank> bankList = bService.selectUserAcc(accountNo);
		if(bankList.size() == 0) {
			System.out.println("\n계좌 조회 실패!!");
		}else {
			System.out.println("계조 조회 성공");
		}
		return bankList;
	}
	
}
