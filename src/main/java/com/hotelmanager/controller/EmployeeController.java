package com.hotelmanager.controller;


import com.hotelmanager.dto.EmployeeDTO;
import com.hotelmanager.entity.Employee;
import com.hotelmanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ModelAndView listEmployee(@RequestParam("name") Optional<String> name,@PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees;
        ModelAndView modelAndView = new ModelAndView("employee/list");
        if (name.isPresent()) {
            employees = employeeService.findAllByDeletedIsFalseAndNameContaining(name.get(), pageable);
            modelAndView.addObject("name", name.get());
            if (employees.getTotalElements() == 0) {
                modelAndView.addObject("message", "Can not find");
            }
        } else {
            employees = employeeService.findAllByDeletedIsFalse(pageable);
        }
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employees", new EmployeeDTO());
        return modelAndView;
    }

    @PostMapping("/create")
    public String saveEmployee(@Valid @ModelAttribute("employees") EmployeeDTO employee, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "/employee/create";
        } else {
            employeeService.create(employee);
            redirect.addFlashAttribute("message", "New Employee created successfully");
            return "redirect:/employees/list";
        }

    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteEmployee(@PathVariable String id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/delete");
        modelAndView.addObject("employees", employeeDTO);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteEmployee(@ModelAttribute("employees") EmployeeDTO employeeDTO, RedirectAttributes redirect) {
        employeeService.delete(employeeDTO.getId());
        redirect.addFlashAttribute("message", "Employee deleted successfully");
        return "redirect:/employees/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditEmployee(@PathVariable String id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employees", employeeDTO);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String editEmployee(@Valid @ModelAttribute("employees") EmployeeDTO employeeDTO, BindingResult bindingResult, RedirectAttributes redirect) {
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        } else {
            employeeService.update(employeeDTO);
            redirect.addFlashAttribute("message", "Employee updated successfully");
            return "redirect:/employees/list";
        }
    }

    @GetMapping("/view/{id}")
    public ModelAndView modelAndView(@PathVariable String id) {
        EmployeeDTO employeeDTO = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("employee/view");
        modelAndView.addObject("employees", employeeDTO);
        return modelAndView;
    }
}



