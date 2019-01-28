package bank.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import bank.model.vo.Bank;
import static common.BankTemp.*;

public class BankDao {
	private Properties prop = new Properties();
	
	public BankDao(){
		try {
			prop.load(new FileReader("properties/query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int bankInsert(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = "insert into bankmanager "
				+ "values(select user_no from transaction where account_no = ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bank.getAccountNo());
			pstmt.setString(2, bank.getUserName());
			pstmt.setString(3, bank.getUserSsn());
			pstmt.setString(4, bank.getPhone());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return 0;
	}

	
	
	public ArrayList<Bank> selectAll(Connection conn) {
		ArrayList<Bank> bankList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		String query = "select user_no, account_no, user_name, open_date from bankmanager"
				+ " join transaction using (user_no)"
				+ "join account using (account_no)";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			while(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setAccountNo(rset.getString("account_no"));
				bank.setUserName(rset.getString("user_name"));
				bank.setOpenDate(rset.getDate("open_date"));
				
				bankList.add(bank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		
		return bankList;
	}

	public ArrayList<Bank> selectName(Connection conn, String userName) {
		ArrayList<Bank> bankList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectname"));
			pstmt.setString(1, userName);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setUserName(userName);
				bank.setAccountNo(rset.getString("account_no"));
				bank.setBalance(rset.getInt("balance"));
				bank.setOpenDate(rset.getDate("open_date"));
				bank.setTransDate(rset.getDate("trans_date"));
				bank.setPhone(rset.getString("phone"));
				
				bankList.add(bank);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return bankList;
	}
	
	public ArrayList<Bank> selectAccount(Connection conn, String accountNo) {
		ArrayList<Bank> bankList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select user_no, account_no, user_name, open_date from bankmanager"
				+ " join transaction using (user_no)"
				+ "join account using (account_no)"
				+ " where account_no = '"
				+ accountNo+"'";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setAccountNo(rset.getString("account_no"));
				bank.setUserName(rset.getString("user_name"));
				bank.setOpenDate(rset.getDate("open_date"));
				
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(stmt);
		}
		return bankList;
	}

	public ArrayList<Bank> selectTransaction(Connection conn, String accountNo) {
		ArrayList<Bank> bankList = new ArrayList<>();
		Statement stmt = null;
		ResultSet rset = null;
		
		String query = "select user_no,account_no,trans_date,type_name,trans_content,"
				+ "deposit,withdraw,balance from transaction "
				+ "join type using (type_no) "
				+ "where account_no = '"
				+ accountNo+"' "
				+ "order by trans_date";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			while(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setAccountNo(accountNo);
				bank.setTransDate(rset.getDate("trans_date"));
				bank.setTypeName(rset.getString("type_name"));
				bank.setTransContent(rset.getString("trans_content"));
				bank.setDeposit(rset.getInt("deposit"));
				bank.setWithdraw(rset.getInt("withdraw"));
				bank.setBalance(rset.getInt("balance"));
				
				bankList.add(bank);
			}
		} catch (SQLException e) {
					e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return bankList;
	}

	

}
