package bank.model.service;

import bank.model.dao.BankDao;
import bank.model.vo.Bank;
import static common.BankTemp.*;

import java.sql.Connection;
import java.util.ArrayList;

public class BankService {
	//DI
	private BankDao bdao = new BankDao();
	
	public int bankNewInsert(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.bankNewInsert(conn, bank);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int bankOldInsert(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.bankOldInsert(conn, bank);
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

	public ArrayList<Bank> selectAccount(String accountNo) {
		Connection conn = getConnection();
		ArrayList<Bank> bookList = bdao.selectAccount(conn, accountNo);
		close(conn);
		return bookList;
	}

	public ArrayList<Bank> selectName(String userName) {
		Connection conn = getConnection();
		ArrayList<Bank> bookList = bdao.selectName(conn, userName);
		close(conn);
		return bookList;
	}

	public int updatePhone(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.updatePhone(conn, bank);
		close(conn);
		return result;
	}

	public int deleteAccount(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.deleteAccount(conn, bank);
		close(conn);
		return result;
	}

	public int insertDeposit(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.insertDeposit(conn, bank);
		close(conn);
		return result;
	}

	public int insertWithdraw(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.insertWithdraw(conn, bank);
		close(conn);
		return result;
	}

	public ArrayList<Bank> selectUserAcc(String accountNo) {
		Connection conn = getConnection();
		ArrayList<Bank> bankList = bdao.selectUserAcc(conn, accountNo);
		close(conn);
		return bankList;
	}

	public int insertTransaction(Bank bank) {
		Connection conn = getConnection();
		int result = bdao.insertTransaction(conn, bank);
		close(conn);
		return result;
	}

}
