package bank.model.service;

import bank.model.dao.BankDao;
import bank.model.vo.Bank;
import static common.BankTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BankService {
	//DI
	private BankDao bdao = new BankDao();
	
	public int bankInsert(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.bankInsert(conn, bank);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}

	public ArrayList<Bank> selectAll() {
		Connection conn = getConnection();
		ArrayList<Bank> bookList = bdao.selectAll(conn);
		close(conn);
		return bookList;
	}

	public ArrayList<Bank> selectAccountNo(String accountNo) {
		Connection conn = getConnection();
		ArrayList<Bank> bookList = bdao.selectAll(conn, accountNo);
		close(conn);
		return bookList;
	}

	public ArrayList<Bank> selectTransaction(String accountNo) {
		Connection conn = getConnection();
		ArrayList<Bank> bookList = bdao.selectTransaction(conn, accountNo);
		close(conn);
		return bookList;
	}

}
