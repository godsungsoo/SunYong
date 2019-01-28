package bank.controller;

import java.util.ArrayList;

import bank.model.service.BankService;
import bank.model.vo.Bank;

public class BankController {
	//DI
	private BankService bService = new BankService();
	
	public void bankInsert(Bank bank) {
		int result = bService.bankInsert(bank);
		
		if(result == 0) {
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

	public ArrayList<Bank> selectAccountNo(String accountNo) {
		ArrayList<Bank> bankList = bService.selectAccountNo(accountNo);
		
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
	
}
