package com.FathiOs.aopdemo;

import com.FathiOs.aopdemo.dao.AccountDAO;
import com.FathiOs.aopdemo.dao.MembershipDAO;
import com.FathiOs.aopdemo.service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopdemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO theAccountDAO,
                                               MembershipDAO theMembershipDAO,
                                               TrafficFortuneService theTrafficFortuneService){
		return runner ->{

			// demoTheBeforeAdvice(theAccountDAO,theMembershipDAO);

            // demoTheAfterReturningAdvice(theAccountDAO);
            
            // demoTheAfterThrowingAdvice(theAccountDAO);
            
            // demoTheAfterAdvice(theAccountDAO);

            // demoTheAroundAdvice(theTrafficFortuneService);
            
            // demoTheAroundAdviceHandleException(theTrafficFortuneService);
            
            demoTheAroundAdviceRethrowException(theTrafficFortuneService);
		};
	}

    private void demoTheAroundAdviceRethrowException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main program : demoTheAroundAdviceRethrowException");

        System.out.println("Calling getFortune()");

        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\n My fortune is :" + data);

        System.out.println("Finished");

    }

    private void demoTheAroundAdviceHandleException(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main program : demoTheAroundAdviceHandleException");

        System.out.println("Calling getFortune()");

        boolean tripWire = true;
        String data = theTrafficFortuneService.getFortune(tripWire);

        System.out.println("\n My fortune is :" + data);

        System.out.println("Finished");
    }

    private void demoTheAroundAdvice(TrafficFortuneService theTrafficFortuneService) {

        System.out.println("\n Main program : demoTheAroundAdvice");

        System.out.println("Calling getFortune()");

        String data = theTrafficFortuneService.getFortune();

        System.out.println("\n My fortune is :" + data);

        System.out.println("Finished");
    }

    private void demoTheAfterAdvice(AccountDAO theAccountDAO) {
        // Call method to find the accounts
        List<Account> theAccounts =null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripwire = false;
            theAccounts = theAccountDAO.findAccounts(tripwire);
        }
        catch (Exception exc){
            System.out.println("\n\n main program : ... caught exception : " + exc);
        }

        // display the accounts
        System.out.println("\n\n main program : demoTheAfterThrowingAdvice");
        System.out.println("======");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheAfterThrowingAdvice(AccountDAO theAccountDAO) {

        // Call method to find the accounts
        List<Account> theAccounts =null;

        try{
            // add a boolean flag to simulate exceptions
            boolean tripwire = true;
            theAccounts = theAccountDAO.findAccounts(tripwire);
        }
        catch (Exception exc){
            System.out.println("\n\n main program : ... caught exception : " + exc);
        }

        // display the accounts
        System.out.println("\n\n main program : demoTheAfterThrowingAdvice");
        System.out.println("======");

        System.out.println(theAccounts);

        System.out.println("\n");

    }

    private void demoTheAfterReturningAdvice(AccountDAO theAccountDAO) {

        // Call method to find the accounts
        List<Account> theAccounts =theAccountDAO.findAccounts();

        // display the accounts
        System.out.println("\n\n main program : demoTheAfterReturningAdvice");
        System.out.println("======");

        System.out.println(theAccounts);

        System.out.println("\n");
    }

    private void demoTheBeforeAdvice(AccountDAO theAccountDAO, MembershipDAO theMembershipDAO) {

		// call the business method
		Account MyAccount = new Account();
		MyAccount.setName("fathyOsama");
		MyAccount.setLevel("Platinum");
		theAccountDAO.addAccount(MyAccount, true);
		theAccountDAO.doWork();

		//call the accountdao getter/setter methode
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");

		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();

		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.doToSleep();
	}

}
