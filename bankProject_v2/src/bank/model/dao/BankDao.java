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
	
	public int bankNewInsert(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("newinsert");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bank.getUserName());
			pstmt.setString(2, bank.getUserSsn());
			pstmt.setString(3, bank.getPhone());
			pstmt.setInt(4, 1);
			pstmt.setString(5, "통장개설");
			pstmt.setInt(6, bank.getDeposit());
			pstmt.setInt(7, bank.getDeposit());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int bankOldInsert(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String query = prop.getProperty("oldinsert"); 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bank.getUserName());
			pstmt.setString(2, bank.getUserSsn());
			pstmt.setInt(3, 1);
			pstmt.setString(4, "통장 개설");
			pstmt.setInt(5, bank.getDeposit());
			pstmt.setInt(6, bank.getDeposit());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	
	
	public ArrayList<Bank> selectAll(Connection conn) {
		ArrayList<Bank> bankList = new ArrayList<>();
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {
			stmt = conn.prepareStatement(prop.getProperty("selectall"));
			rset = stmt.executeQuery();
			while(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setAccountNo(rset.getString("account_no"));
				bank.setUserName(rset.getString("user_name"));
				bank.setBalance(rset.getInt("balance"));
				bank.setOpenDate(rset.getDate("open_date"));
				bank.setTransDate(rset.getDate("trans_date"));
				bank.setPhone(rset.getString("phone"));
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
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectaccountno"));
			pstmt.setString(1, accountNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				Bank bank = new Bank();
				bank.setUserNo(rset.getInt("user_no"));
				bank.setAccountNo(accountNo);
				bank.setTransDate(rset.getDate("trans_date"));
				bank.setTypeNo(rset.getInt("type_no"));
				bank.setTransContent(rset.getString("trans_content"));
				bank.setDeposit(rset.getInt("deposit"));
				bank.setWithdraw(rset.getInt("withdraw"));
				bank.setBalance(rset.getInt("balance"));
				
				bankList.add(bank);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return bankList;
	}

	public int updatePhone(Connection conn, Bank bank){
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("updatePhone"));
			pstmt.setString(1, bank.getPhone());
			pstmt.setString(2, bank.getUserName());
			pstmt.setString(3, bank.getUserSsn());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteAccount(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("delete"));
			pstmt.setString(1, bank.getUserName());
			pstmt.setString(2, bank.getUserSsn());
			pstmt.setString(3, bank.getAccountNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertDeposit(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("deposit"));
			pstmt.setString(1, bank.getAccountNo());
			pstmt.setString(2, bank.getAccountNo());
			pstmt.setString(3, "입금");
			pstmt.setInt(4, bank.getDeposit());
			pstmt.setInt(5, bank.getDeposit());
			pstmt.setString(6, bank.getAccountNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public int insertWithdraw(Connection conn, Bank bank) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("withdraw"));
			pstmt.setString(1, bank.getAccountNo());
			pstmt.setString(2, bank.getAccountNo());
			pstmt.setString(3, "출금");
			pstmt.setInt(4, bank.getWithdraw());
			pstmt.setString(5, bank.getAccountNo());
			pstmt.setInt(6, bank.getWithdraw());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<Bank> selectUserAcc(Connection conn, String accountNo) {
		ArrayList<Bank> bankList = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			pstmt = conn.prepareStatement(prop.getProperty("selectuseracc"));
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return bankList;
	}

}
