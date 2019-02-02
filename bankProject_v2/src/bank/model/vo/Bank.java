package bank.model.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author ysy95
 *
 */
public class Bank implements Serializable{
	//직렬화 처리
	private static final long SerialVersionUID = 20190126L;
	
	//Field
	private int userNo;              //고객번호
	private String userName;		//고객명
	private String userSsn;			//고객주민번호
	private String accountNo;		//계좌번호
	private String yAccountNo;  //상대방계좌번호
	private Date openDate;			//통장개설일자
	private int typeNo;				//거래종류
	private String typeName;		//거래이름
	private Date transDate;			//거래일자
	private String transContent;	//거래내용
	private int deposit;				//입금액
	private int withdraw;			//출금액
	private int balance;				//잔액
	private String phone;          //고객전화번호
	
	public Bank() {}
	
	public Bank(int userNo, String userName, String userSsn, String accountNo, Date openDate, int typeNo,
			String typeName, Date transDate, String transContent, int deposit, int withdraw, int balance,
			String phone) {
		super();
		this.userNo = userNo;
		this.userName = userName;
		this.userSsn = userSsn;
		this.accountNo = accountNo;
		this.openDate = openDate;
		this.typeNo = typeNo;
		this.typeName = typeName;
		this.transDate = transDate;
		this.transContent = transContent;
		this.deposit = deposit;
		this.withdraw = withdraw;
		this.balance = balance;
		this.phone = phone;
	}

	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSsn() {
		return userSsn;
	}
	public void setUserSsn(String userSsn) {
		this.userSsn = userSsn;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public Date getOpenDate() {
		return openDate;
	}
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	public int getTypeNo() {
		return typeNo;
	}
	public void setTypeNo(int typeNo) {
		this.typeNo = typeNo;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public String getTransContent() {
		return transContent;
	}
	public void setTransContent(String transContent) {
		this.transContent = transContent;
	}
	public int getDeposit() {
		return deposit;
	}
	public void setDeposit(int deposit) {
		this.deposit = deposit;
	}
	public int getWithdraw() {
		return withdraw;
	}
	public void setWithdraw(int withdraw) {
		this.withdraw = withdraw;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getyAccountNo() {
		return yAccountNo;
	}

	public void setyAccountNo(String yAccountNo) {
		this.yAccountNo = yAccountNo;
	}

	@Override
	public String toString() {
		return "  "+userNo + "      " + accountNo + "   "+ typeNo + "      " + transDate + "     " + transContent + "         " + deposit + "       " + withdraw + "      " + balance;
	}
	
	
	
}
