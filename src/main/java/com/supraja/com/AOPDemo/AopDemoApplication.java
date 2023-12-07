package com.supraja.com.AOPDemo;

import com.supraja.com.AOPDemo.dao.AccountDAO;
import com.supraja.com.AOPDemo.dao.MembershipDAO;
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
	public CommandLineRunner commandLineRunner (AccountDAO accountDAO, MembershipDAO membershipDAO) {
			return runner -> {
//				demoTheBeforeAdvice(accountDAO, membershipDAO);
				demoTheAfterAdvice(accountDAO, membershipDAO);
			};
	}

	private void demoTheAfterAdvice(AccountDAO accountDAO, MembershipDAO membershipDAO) {
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
