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
		}
		return bankList;
	}

	public ArrayList<Bank> selectAccount(String accountNo) {
		ArrayList<Bank> bankList = bService.selectAccount(accountNo);
		
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}
		return bankList;
	}

	public ArrayList<Bank> selectTransaction(String accountNo) {
		ArrayList<Bank> bankList = bService.selectTransaction(accountNo);
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}
		return bankList;
	}

	public ArrayList<Bank> selectName(String userName) {
		ArrayList<Bank> bankList = bService.selectName(userName);
		if(bankList.size() == 0) {
			System.out.println("\n통장이 없습니다.");
		}
		return bankList;
	}
	
}
