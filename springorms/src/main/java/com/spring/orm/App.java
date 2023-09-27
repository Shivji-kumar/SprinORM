package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Spring ORM Concept");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	       boolean go=true;
	       while(go) {
	    	   System.out.println("Press 1 for add new student");
	           System.out.println("Press 2 for display all students");
	           System.out.println("Press 3 for get detail of single student");
	           System.out.println("Press 4 for delete student");
	           System.out.println("Press 5 for update student");
	           System.out.println("Press 6 for add exit");
	            
	           try {
	        	   int input=Integer.parseInt(br.readLine());
	        	  switch (input) {
				case 1:
					//Adding new Student
					System.out.println("Enter user id : ");
					int uid=Integer.parseInt(br.readLine());
					System.out.println("Enter user name : ");
					String uName=br.readLine();
					
					System.out.println("Enter user City : ");
					String uCity=br.readLine();
					
					Student s=new Student();
					s.setStudentId(uid);
					s.setStudentName(uName);
					s.setStudentCity(uCity);
					
					int r=studentDao.insert(s);
					System.out.println(r+" Student Added");
					System.out.println("======================");
					break;
					
				case 2:
					//Display all Student
					System.out.println("======================");
					List<Student> allStudents=studentDao.getAllStudents();
					for(Student st:allStudents) {
						System.out.println("Id : "+st.getStudentId());
						System.out.println("Name : "+st.getStudentName());
						System.out.println("City : "+st.getStudentCity());
						System.out.println("=================================");
					}
					break;
				case 3:
					//Single student data
					System.out.println("Enter user id : ");
					int userid=Integer.parseInt(br.readLine());
					Student student=studentDao.getStudent(userid);
					System.out.println("Id : "+student.getStudentId());
					System.out.println("Name : "+student.getStudentName());
					System.out.println("City : "+student.getStudentCity());
					System.out.println("=================================");
							
					break;
				case 4:
					//Delete Student by Id
					System.out.println("Enter user id : ");
					int id=Integer.parseInt(br.readLine());
					studentDao.delete(id);
					System.out.println("Student Deleted.....");
					break;
				case 5:
					//Updating Student Details
					System.out.println("Enter user id : ");
					int uids=Integer.parseInt(br.readLine());
					Student student1=studentDao.getStudent(uids);
					System.out.println("Id : "+student1.getStudentId());
					System.out.println("Name : "+student1.getStudentName());
					System.out.println("City : "+student1.getStudentCity());
					System.out.println("=================================");
							
					break;
				case 6:
					go=false;		
					break;

				default:
					break;
				}
	        	   
	           }catch (Exception e) {
				System.out.println("Invalid input try with another one !!");
				System.out.println(e.getMessage());
			}
	           
	       }
	       System.out.println("Thanks You for using Applications..");

	}
}
