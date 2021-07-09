package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.entity.employee.Division;
import com.example.model.entity.employee.EducationDegree;
import com.example.model.entity.employee.Employee;
import com.example.model.entity.employee.Position;
import com.example.model.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    IEmployeeService  iEmployeeService;
    @ModelAttribute("positions")
    public List<Position> positions(){
        return iEmployeeService.listPosition();
    }
    @ModelAttribute("divisions")
    public List<Division> divisions(){
        return iEmployeeService.listDivision();
    }
    @ModelAttribute("educations")
    public List<EducationDegree> educationDegrees(){
        return iEmployeeService.listEdu();
    }
    @GetMapping(value = {"","/list"})
    public String showListEmployee(@PageableDefault(value = 2) Pageable pageable, Model model,
                                   @RequestParam Optional<String> keyword){
        String keywordValue = "";
        if (keyword.isPresent()){
            keywordValue = keyword.get();
        }
        Page<Employee> employees = iEmployeeService.findAllSearchName(pageable,keywordValue);
        model.addAttribute("employees",employees);
        model.addAttribute("keywordValue",keywordValue);
        return "employee/list";
    }
    @GetMapping(value = "create")
    public String showFormCreate(Model model){
        EmployeeDto employeeDto = new EmployeeDto();
        model.addAttribute("employeeDto",employeeDto);
        return "employee/create";
    }
    @PostMapping(value = "create")
    public String createNewEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                                    BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Create success");
        return "redirect:/employee/";
    }
    @GetMapping(value = "edit")
    public String showFormEdit(@RequestParam Integer id, Model model){
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee,employeeDto);
        model.addAttribute("employeeDto",employeeDto);
        return "employee/edit";
    }
    @PostMapping(value = "edit")
    public String editEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "employee/edit";
        }
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto,employee);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg","Edit success");
        return "redirect:/employee/";
    }
    @PostMapping(value = "delete")
    public String deleteEmployee(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        iEmployeeService.remove(id);
        redirectAttributes.addFlashAttribute("msg","Delete success");
        return "redirect:/employee/";
    }
}
