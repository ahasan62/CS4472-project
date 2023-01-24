package bank;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import bank.db.DBHandler;
import bank.transactions.BankDeposit;
import bank.transactions.BankTransaction;
import bank.transactions.BankTransfer;
import bank.transactions.BankWithdrawal;
import bank.utils.FeesCalculator;

public class BankServer {
	private BankHandler handler;
	
	public BankServer(BankFacade facade) {
		super();
		this.handler = new BankHandler(facade);
	}

	public void start() {
		int port = 9000;
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress("localhost", port), 0);
			System.out.println("server started at " + server.getAddress());
			server.createContext("/performTransaction", handler::performTransaction);
			server.createContext("/checkCredentials", handler::checkCredentials);
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FeesCalculator feesCalculator = new FeesCalculator();
		DBHandler dbHandler = new DBHandler();
		BankTransaction withdrawal = new BankWithdrawal(feesCalculator, dbHandler);
		BankTransaction deposit = new BankDeposit(feesCalculator, dbHandler);
		BankTransaction transfer = new BankTransfer(feesCalculator, dbHandler);
		BankFacade facade = new BankFacade(dbHandler, withdrawal, deposit, transfer);
		BankServer server = new BankServer(facade);
		server.start();

	}

}
