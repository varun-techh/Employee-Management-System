package com.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.project.model.Employee;
import com.spring.project.service.EmployeeService;


@Controller
public class HomeController {

	private EmployeeService es;

	@Autowired(required = true)
	@Qualifier("es")
	public void setEmployeeService(EmployeeService es) {
	    this.es = es;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		return "Home-Page";
	}

	@RequestMapping(value = "/List", method = RequestMethod.GET)
	public String listEmployees(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", this.es.listEmployees());
		return "Employees";
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public String newEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployee", this.es.listEmployees());
		return "AddEmployee";
	}
	
	@RequestMapping(value ="/jspToController", method = RequestMethod.POST)
	public String jspToController(@ModelAttribute("employee") Employee emp) {
	    if(emp.getId() == 0){
	        this.es.addEmployee(emp);
	    } else {
	        // existing employee, call update
	        this.es.updateEmployee(emp);
	    }
	    return "redirect:/List"; 
	}

	@RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
		
        this.es.removeEmployee(id);
        return "redirect:/List";
    }
 
	@RequestMapping("/edit/{id}")
	public String editEmployee(@PathVariable("id") int id, Model model){
	    model.addAttribute("employee", this.es.getEmployeeById(id));
	    return "updateEmployee";
	}

    
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String jspToController2(@ModelAttribute("employee") Employee emp , Model model) {
	    this.es.updateEmployee(emp);
	    return "redirect:/List"; 
	}

}
