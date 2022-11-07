package com.example.Group_project.COntroller;

import com.example.Group_project.HElper.Messages;
import com.example.Group_project.REpository.*;
import com.example.Group_project.entities.*;
import com.example.Group_project.entities.Module;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/student")
public class StudentCOntroller {

    @Autowired
    private UserREpository userREpository;

    @Autowired
    private CourseREpository courseREpository;

    @Autowired
    private ModuleREpository moduleREpository;
    @Autowired
    private StudentREpository studentREpository;

    @Autowired
    private AssignmentREpository assignmentREpository;

    // for encrypting new password
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @ModelAttribute
    public void addCommonData(Model model, Principal principal){

        String userName = principal.getName();
        User user = userREpository.getUserByUserName(userName);
        model.addAttribute("user", user);

    }

    @RequestMapping("/index")
    public String homepageView(Model model, Principal principal){
        return "student/student-dashboard";
    }

    @RequestMapping("/show-courses")
    public String showCourse(Model m, Principal principal){
//        m.addAttribute("title", "Student courses");
        String userName =  principal.getName();
        Student student = this.studentREpository.getStudentByUserName(userName);
        List<Course> courses = this.courseREpository.findCourseById(student.getCourse().getcId());
        m.addAttribute("courses", courses);
        return "student/show-course";
    }

    @GetMapping("/show-modules/{cid}")
    public String showModule(@PathVariable("cid") Integer cId, Model m){
        m.addAttribute("title", "Show Modules of courses");
        List<Module> modules = moduleREpository.findModuleByCourse(cId);
        m.addAttribute("modules", modules);
        return "student/show_module";
    }

    @RequestMapping("/{mId}/module/")
    public String showModuleDetails(@PathVariable("mId") Integer mId, Model model){
        Optional<Module> optionalModule = this.moduleREpository.findById(mId);
        Module module = optionalModule.get();
        model.addAttribute("module", module);
        return "student/module_detail";
    }

    @GetMapping("/show-assignment/{mid}")
    public String showAssignment(@PathVariable("mid") Integer mId, Model m){
        m.addAttribute("title", "Show Assignment of modules");
        List<Assignment> assignments = assignmentREpository.findAssignmentByModule(mId);
        m.addAttribute("assignment", assignments);
        return "student/show_assignment";
    }

    // open change password handler
    @GetMapping("/change-password")
    public String changePassword(Model model) {
       return "student/change_password";
    }

    // process change password
    @PostMapping("/process-password")
    public String changePassword(@RequestParam("newPassword") String newPass, @RequestParam("oldPassword") String oldPass, Principal principal, HttpSession session) {

        String username = principal.getName();
        User user1 = this.userREpository.getUserByUserName(username);

//        // if user input old password matches with password stored in database
        if(this.bCryptPasswordEncoder.matches(oldPass, user1.getPassword())){
            // change password
            user1.setPassword(this.bCryptPasswordEncoder.encode(newPass));
            this.userREpository.save(user1);
            session.setAttribute("message", new Messages("Your password successfully changed.", "alert-success"));
        }
        else {
//            // if error
            session.setAttribute("message", new Messages("Please enter correct old message.", "alert-danger"));
            return "redirect:/student/change-password";
        }
//
        return "redirect:/student/index";
    }

}
