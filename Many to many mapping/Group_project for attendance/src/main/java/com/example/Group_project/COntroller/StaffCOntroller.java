package com.example.Group_project.COntroller;

import com.example.Group_project.REpository.CourseREpository;
import com.example.Group_project.REpository.StudentREpository;
import com.example.Group_project.REpository.UserREpository;
import com.example.Group_project.entities.Course;
import com.example.Group_project.entities.Student;
import com.example.Group_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/staff")
public class StaffCOntroller {

        @Autowired
        private UserREpository userREpository;

        @Autowired
        private CourseREpository courseREpository;
        @Autowired
        private StudentREpository studentREpository;

        @ModelAttribute
        public void addCommonData(Model model, Principal principal){

            String userName = principal.getName();
            User user = userREpository.getUserByUserName(userName);
            model.addAttribute("user", user);

        }

        @RequestMapping("/index")
        public String homepageView(Model model, Principal principal){
            return "staff/staff-dashboard";
        }

//        @RequestMapping("/show-courses")
//        public String showCourse(Model m, Principal principal){
////        m.addAttribute("title", "Student courses");
//            String userName =  principal.getName();
//            Student student = this.studentREpository.getStudentByUserName(userName);
//            List<Course> courses = this.courseREpository.findCourseById(student.getCourse().getcId());
//            m.addAttribute("courses", courses);
//            return "staff/show-course";
//        }



}
