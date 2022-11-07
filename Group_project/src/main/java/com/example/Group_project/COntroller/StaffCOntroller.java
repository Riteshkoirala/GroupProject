package com.example.Group_project.COntroller;

import com.example.Group_project.REpository.*;

import com.example.Group_project.entities.Module;
import com.example.Group_project.entities.Staff;
import com.example.Group_project.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/staff")
public class StaffCOntroller {

        @Autowired
        private UserREpository userREpository;

        @Autowired
        private CourseREpository courseREpository;

        @Autowired
        private StudentREpository studentREpository;

        @Autowired
        private StaffREpository staffREpository;

        @Autowired
        private ModuleREpository moduleREpository;


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

        /* @RequestMapping("/show-courses")
    public String showCourse(Model m, Principal principal){
//        m.addAttribute("title", "Student courses");
        String userName =  principal.getName();
        Student student = this.studentREpository.getStudentByUserName(userName);
        List<Course> courses = this.courseREpository.findCourseById(student.getCourse().getcId());
        m.addAttribute("courses", courses);
        return "student/show-course";
    }*/
        @GetMapping("/show-modules")
        public String showModule(Model m, Principal principal){
        String userName = principal.getName();
        Staff staff = this.staffREpository.getStaffByUserName(userName);
        m.addAttribute("title", "Staff enrolled Modules");
        List<Module> modules = this.moduleREpository.findModuleById(staff.getModules().getmId());
        m.addAttribute("modules", modules);
        return "staff/show_module";
         }

        @RequestMapping("/{mId}/module/")
        public String showModuleDetails(@PathVariable("mId") Integer mId, Model model){
        Optional<Module> optionalModule = this.moduleREpository.findById(mId);
        Module module = optionalModule.get();
        model.addAttribute("module", module);
        return "staff/module_detail";
    }

//


}
