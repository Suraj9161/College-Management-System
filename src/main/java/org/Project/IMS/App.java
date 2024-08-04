package org.Project.IMS;

import java.util.Date;
import java.util.HashSet;

import com.Dao.CMS.CollegeDao;
import com.Dao.CMS.CourseDao;
import com.Dao.CMS.DepartmentDao;
import com.Dao.CMS.ProfessorDao;
import com.Dao.CMS.StudentDao;
import com.entites.CMS.College;
import com.entites.CMS.Course;
import com.entites.CMS.Department;
import com.entites.CMS.Professor;
import com.entites.CMS.Student;
import com.util.CMS.ExcelUtil;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Collage Management System (CMS)" );
//        insert data Example-->
        CollegeDao collegeDao=new CollegeDao();
        DepartmentDao departmentDao=new DepartmentDao();
        CourseDao courseDao=new CourseDao();
        StudentDao studentDao=new StudentDao();
        ProfessorDao professorDao=new ProfessorDao();
        
        
//        create an object 
        // Create an object for College
        College college = new College();
        college.setName("ITCode Institute College");
        college.setAddress("Pune");
        college.setEmail("ITCode@gmail.com");
        college.setMobileNumber(9161974218L);
        college.setEstablishedDate(new Date(2004-1900, 5, 25)); // Date is deprecated, but used here for simplicity
        college.setCollageCode("AB01678");
        collegeDao.save(college);
        
        // Create an object for Department
        Department department = new Department();
        department.setName("Computer Science");
        department.setCollege(college);
        departmentDao.save(department);
        
        // Create an object for Course
        Course course = new Course();
        course.setName("Data Structures");
        course.setCerdits(4);
        course.setDepartment(department);
        courseDao.save(course);
        
        // Create an object for Student
        Student student = new Student();
        student.setName("Suraj");
        student.setEmail("suraj.maurya@itcode.com");
        
        if (student.getCourses() == null) {
            student.setCourses(new HashSet<>());
        }
        student.getCourses().add(course);
        studentDao.save(student);
        
        // Create an object for Professor
        Professor professor = new Professor();
        professor.setName("Dr. Smith");
        professor.setEmail("dr.smith@example.com");
        Professor professor2 = new Professor();
        professor.setName("Dr. Smith");
        professor.setEmail("dr.smith@example.com");
        
        if (professor.getDepartments() == null) {
            professor.setDepartments(new HashSet<>());
        }
        if (professor2.getDepartments() == null) {
            professor2.setDepartments(new HashSet<>());
        }
        professor2.getDepartments().add(department);
        professor.getDepartments().add(department);
        professorDao.save(professor);
        professorDao.save(professor2);
        
        System.out.println("Data saved successfully.");
       
       
      
       
    // Save data to Excel
       String[] collegeColumns = {"ID", "Name", "Address","EstablishDate","Email","collegeCode" ,"Mobile"};
       Object[][] collegeData = {
               {college.getId(), college.getName(), college.getAddress(),college.getEmail(),college.getEstablishedDate(),college.getMobileNumber()}
       };
       ExcelUtil.saveDataToExcel("College", collegeColumns, collegeData);

       String[] departmentColumns = {"ID", "Name", "College ID"};
       Object[][] departmentData = {
               {department.getId(), department.getName(), department.getCollege().getId()}
       };
       ExcelUtil.saveDataToExcel("Department", departmentColumns, departmentData);

       String[] courseColumns = {"ID", "Name", "Credits", "Department ID"};
       Object[][] courseData = {
               {course.getId(), course.getName(), course.getCerdits(), course.getDepartment().getId()}
       };
       ExcelUtil.saveDataToExcel("Course", courseColumns, courseData);

       String[] studentColumns = {"ID", "Name", "Email"};
       Object[][] studentData = {
               {student.getId(), student.getName(), student.getEmail()}
       };
       ExcelUtil.saveDataToExcel("Student", studentColumns, studentData);

       String[] professorColumns = {"ID", "Name", "Email"};
       Object[][] professorData = {
               {professor.getId(), professor.getName(), professor.getEmail()}
       };
       ExcelUtil.saveDataToExcel("Professor", professorColumns, professorData);

       // Read data from Excel and display
       Object[][] readCollegeData = ExcelUtil.readDataFromExcel("College");
       for (Object[] row : readCollegeData) {
           for (Object cell : row) {
               System.out.print(cell + "\t");
           }
           System.out.println();
       }
   }
     
       
       
    }

