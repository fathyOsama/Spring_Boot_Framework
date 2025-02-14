package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){

		return runner -> {
             // createInstructor(appDAO);

			// findInstructor(appDAO);
			
			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			 deleteInstructorDetail(appDAO);
			
		};
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 4;
		System.out.println("Deleting instructor detail id : "+theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {

		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail : " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor : " +tempInstructorDetail.getInstructor());

		System.out.println("Done!");

	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Delete Instructor id : " +theId);

		appDAO.deleteInstructorById(theId);

		System.out.println("Done !");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id :" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the associated instructorDetail only : " +tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*
		// create the instructor
		Instructor tempInstructor =
				new Instructor("Fathy","OSama","osama@Fat1code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.Fat1code.com",
						"Fat 1 code!!!");
		*/

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Shehab","OSama","osama@She 1 code.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.She 1 code.com",
						"She 1 code!!!");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		//
		// Note : this will Also Save the detail object
		// because of CascadeType.All
		//
		System.out.println("Saving Instructor :"  + tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");



	}

}
