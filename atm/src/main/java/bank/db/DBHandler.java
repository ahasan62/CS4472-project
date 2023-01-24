package bank.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bank.exceptions.CardNotFoundException;
import bank.exceptions.UnsuccessfulBalanceUpdate;
import bank.exceptions.UserNotFoundException;
import bank.transactions.utils.AccountType;

public class DBHandler {
	
	private Connection conn;
	
	public DBHandler() {
		createDatabase();
	}
	
	public String getCardOwner(String cardNumber) throws CardNotFoundException {
		String query = "SELECT username FROM cards WHERE card = '" + cardNumber + "';";
		ResultSet rs = executeQuery(query);
		try {
			if (rs.next()) {
				String username = rs.getString("username");
				return username;
			} else {
				throw new CardNotFoundException();
			}
		} catch (SQLException e) {
			throw new CardNotFoundException();
		}
	}
	
	public double getBalance(String user, AccountType type) throws UserNotFoundException {
		String query = "SELECT balance FROM accounts WHERE username = '" + user + "' AND type = '" + type.ordinal() + "';";
		ResultSet rs = executeQuery(query);
		try {
			if (rs.next()) {
				double balance = rs.getDouble("balance");
				return balance;
			} else {
				throw new UserNotFoundException();
			}
		} catch (SQLException e) {
			throw new UserNotFoundException();
		}
	}
	
	public void setBalance(String user, AccountType type, double balance) throws UnsuccessfulBalanceUpdate {
		String query = String.format(
				"REPLACE INTO accounts(username, type, balance) VALUES ('%s', '%d', %f);",
				user, type.ordinal(), balance);
		
		boolean balanceSet = executeUpdate(query);
		
		if (!balanceSet)
			throw new UnsuccessfulBalanceUpdate();
		
	}
	
	public boolean isStudent(String user) throws UserNotFoundException {
		String query = "SELECT student FROM clients WHERE username = '" + user + "';";
		ResultSet rs = executeQuery(query);
		try {
			if (rs.next()) {
				boolean isStudent = rs.getBoolean("student");
				return isStudent;
			} else {
				throw new UserNotFoundException();
			}
		} catch (SQLException e) {
			throw new UserNotFoundException();
		}
	}
	
	public char[] getPIN(String user) throws UserNotFoundException {
		String query = "SELECT pin FROM cards WHERE username = '" + user + "';";
		ResultSet rs = executeQuery(query);
		try {
			if (rs.next()) {
				String pin = rs.getString("pin");
				return pin.toCharArray();
			} else {
				throw new UserNotFoundException();
			}
		} catch (SQLException e) {
			throw new UserNotFoundException();
		}
	}
	
	private void createDatabase() {
		String url = "jdbc:sqlite:bank.db";

		try {
			conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement();
			createTables(stmt);
		} catch (SQLException e) {
			System.out.println("SQLite Database creation: " + e.getMessage());
		}
	}

	private void createTables(Statement stmt) throws SQLException {
		if (conn != null) {
			String createTable;

			// Create table for clients
			createTable = "CREATE TABLE IF NOT EXISTS clients (\n" 
										+ " username text NOT NULL,\n"
										+ " first text NOT NULL,\n" 
										+ " last text NOT NULL,\n" 
										+ " student integer,\n" 
										+ " PRIMARY KEY(username)" 
						+ ");";
			stmt.execute(createTable);

			// Create table for accounts
			createTable = "CREATE TABLE IF NOT EXISTS accounts (\n" 
										+ " username text NOT NULL,\n"
										+ " type integer,\n" 
										+ " balance real,\n" 
										+ " PRIMARY KEY(username, type)" 
						+ ");";
			stmt.execute(createTable);
			
			// Create table for cards
			createTable = "CREATE TABLE IF NOT EXISTS cards (\n" 
										+ " card text NOT NULL,\n"
										+ " username text NOT NULL,\n"
										+ " pin text NOT NULL,\n" 
										+ " PRIMARY KEY(card)" 
						+ ");";
			
			
			stmt.execute(createTable);
		}
	}
	
	private ResultSet executeQuery(String query) {
		Statement stmt;
		ResultSet rs;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return rs;
	}
	
	private boolean executeUpdate(String query) {
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(query);

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}
}
