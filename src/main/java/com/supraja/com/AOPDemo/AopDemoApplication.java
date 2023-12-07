package com.supraja.com.AOPDemo;

import com.supraja.com.AOPDemo.dao.AccountDAO;
import com.supraja.com.AOPDemo.dao.MembershipDAO;
import com.supraja.com.AOPDemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO,
												MembershipDAO membershipDAO,
												TrafficFortuneService trafficFortuneService) {
			return runner -> {
//				demoTheBeforeAdvice(accountDAO, membershipDAO);
//				demoTheAfterReturningAdvice(accountDAO, membershipDAO);
//				demoTheAfterThrowingAdvice(accountDAO, membershipDAO);
//				demoTheAfterAdvice(accountDAO, membershipDAO);
//				demoTheAroundAdvice(trafficFortuneService);
				demoTheAroundAdviceHandleException(trafficFortuneService);
			};
	}

	private void demoTheAroundAdviceHandleException(TrafficFortuneService trafficFortuneService) {
		boolean tripWire = true;
		String result = null;
		System.out.println("In main application for Around advice handles exception");
		try {
			result = trafficFortuneService.getFortune(tripWire);
		} catch (Exception ex) {
			System.out.println("Exception thrown while simulating exception for AroundAdvice " + ex);
		}
		System.out.println("Result in main --- " + result);

	}

	private void demoTheAroundAdvice(TrafficFortuneService trafficFortuneService) {
		String data = trafficFortuneService.getFortune();
		System.out.println("Fortune in main app --- " + data);
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accountList  = null;

		try {
			boolean tripWire = false;
			accountList = accountDAO.findAccounts(tripWire);
		} catch (Exception exc ) {
			System.out.println("Caught exception ---- " +exc);
		}


		System.out.println("Account List AfterAdvice " + accountList);
	}

	private void demoTheAfterThrowingAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accountList  = null;

		try {
			boolean tripWire = true;
			accountList = accountDAO.findAccounts(tripWire);
		} catch (Exception exc ) {
			System.out.println("Caught exception ---- " +exc);
		}


		System.out.println("Account List AfterThrowingAdvice " + accountList);
	}

	private void demoTheAfterReturningAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		List<Account> accountList  = accountDAO.findAccounts();

		System.out.println("Account List " + accountList);
	}

	private void demoTheBeforeAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
		Account theAccount = new Account();
		theAccount.setName("Supraja");
		theAccount.setLevel("872");
		boolean res = accountDAO.addSillyNumber( theAccount, true);
		accountDAO.doWork();
		// let's call it again
		System.out.println("Calling addAccount() in membershipDAO!");
		membershipDAO.addAccount();

		// Calling AccountDAO setters and getters
		System.out.println("Calling AccountDAO setters and getters");
		accountDAO.setName("Supraja Srikanth");
		System.out.println(accountDAO.getName());
		accountDAO.setServiceCode("1");
		System.out.println(accountDAO.getServiceCode());

	}

}
