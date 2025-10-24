package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    public ModelAndView getList(ModelAndView mav) {
        List<Employee> employees = employeeService.getAll();
        mav.addObject("employees", employees);
        mav.setViewName("employee-list");
        return mav;
    }

    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView mav) {
        mav.addObject("employee", new Employee());
        mav.setViewName("employee-form");
        return mav;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-form";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/show-form-update")
    public ModelAndView showFormUpdate(@RequestParam("employeeId") int id, ModelAndView mav) {
        Employee employee = employeeService.getById(id);
        mav.addObject("employee", employee);
        mav.setViewName("employee-update");
        return mav;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employee-update";
        }
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
