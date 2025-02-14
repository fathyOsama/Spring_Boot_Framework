package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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

			// deleteInstructorDetail(appDAO);
			
			// createInstructorWithCourses(appDAO);
			
			// findInstructorWithCourses(appDAO); 
			
			// findCoursesForInstructor(appDAO);

            // findInstructorWithCoursesJoinFetch(appDAO);
			
			// updateInstructor(appDAO);

			// updateCourse(appDAO);

			// deleteInstructor(appDAO);

			deleteCourse(appDAO);
		};
	}

	private void deleteCourse(AppDAO appDAO) {

		int theId = 10;

		System.out.println("Deleting Course id :" +theId);

		appDAO.deleteCourseById(theId);

		System.out.println("المرا دي تقولي بقا عاششششششش ي هندسه ");
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;

		// find the Course
		System.out.println("Finding Course id :" + theId);
		Course tempCourse = appDAO.findCourseById(theId);

		// Update the Course
		System.out.println("Updating Course id :" + theId);
		tempCourse.setTitle("Enjoy the life you have");
		appDAO.update(tempCourse);

		System.out.println("قولي تماممممممم ياعمي فتحييي");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 1;

		// find the instructor
		System.out.println("Finding instructor id :" + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);

		// Update the Instructor
		System.out.println("Updating instructor id :" + theId);
		tempInstructor.setLastName("SoftWare Engineer");
		tempInstructor.setFirstName("Shehab");
		appDAO.update(tempInstructor);

		System.out.println("قولي تماممممممم");

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

        int theId = 1;

        // find the instructor
        System.out.println("Finding instructor id: "+theId);
        Instructor tempInstructor = appDAO.findInstructorByIdJoinFetch(theId);

        System.out.println("tempInstructor :" +tempInstructor);
        System.out.println("the associated courses : "+tempInstructor.getCourses());

        System.out.println("Done!!!!!");



    }

    private void findCoursesForInstructor(AppDAO appDAO) {

		int theId = 1;
		// find instructor
		System.out.println("Finding instructor id: " + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);

		System.out.println("tempInstructor: " + tempInstructor);

		// find courses for instructor
		System.out.println("Finding courses for instructor id: " + theId);
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);

		// associate the objects
		tempInstructor.setCourses(courses);

		System.out.println("the associated courses: " + tempInstructor.getCourses());

		System.out.println("Done!");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId = 1;
		System.out.println("Finding instructor id :" + theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);


		System.out.println("tempInstructor : "+tempInstructor);
		System.out.println("the associated  Courses : " +tempInstructor.getCourses());

		System.out.println("Done !!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		// create the instructor
		Instructor tempInstructor =
				new Instructor("Shehab","OSama","Shehab.osama@Shehab.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games");


		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		// create some courses
		Course tempCourse1 = new Course("Air Guitar - The Ultimate Guide");
		Course tempCourse2 = new Course("The Pinball Masterclass");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save the instructor
		//
		// NOTE : this will Also Save the courses
		// because of CascadeType.PERSIST
		//
		System.out.println("Saving instructor : " + tempInstructor);
		System.out.println("The Courses : " + tempInstructor.getCourses());
		appDAO.save(tempInstructor);

		System.out.println("Done!!");

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

		System.out.println("قولي هوه دي الكلام المظبوط ياهندسه");

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
