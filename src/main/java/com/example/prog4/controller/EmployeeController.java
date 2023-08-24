package com.example.prog4.controller;

import com.example.prog4.controller.mapper.EmployeeMapper;
import com.example.prog4.controller.validator.EmployeeValidator;
import com.example.prog4.facade.EmployeeCNAPSFacade;
import com.example.prog4.model.Employee;
import com.example.prog4.model.EmployeeCNAPS;
import com.example.prog4.model.EmployeeFilter;
import com.example.prog4.service.CSVUtils;
import com.example.prog4.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/server/employee")
public class EmployeeController {
    private EmployeeMapper employeeMapper;
    private EmployeeValidator employeeValidator;
    private EmployeeService employeeService;
    private EmployeeCNAPSFacade employeeCNAPSFacade;

    @GetMapping("/list/csv")
    public ResponseEntity<byte[]> getCsv(HttpSession session) {
        EmployeeFilter filters = (EmployeeFilter) session.getAttribute("employeeFiltersSession");
        List<Employee> data = employeeService.getAll(filters).stream().map(employeeMapper::toView).toList();

        String csv = CSVUtils.convertToCSV(data);
        byte[] bytes = csv.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDispositionFormData("attachment", "employees.csv");
        headers.setContentLength(bytes.length);
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }

    @GetMapping("/list/filters/clear")
    public String clearFilters(HttpSession session) {
        session.removeAttribute("employeeFilters");
        return "redirect:/employee/list";
    }

    private String generateCnapsNumber() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    @PostMapping("/createOrUpdate")
    public String saveOne(@ModelAttribute Employee employee) {
        employeeValidator.validate(employee);

        if (employee.getId() != null) {
            com.example.prog4.repository.entity.Employee existingEmployee =
                    employeeService.getEmployeeById(employee.getId());

            existingEmployee.setFirstName(employee.getFirstName());
            existingEmployee.setLastName(employee.getLastName());
            employeeService.saveOne(existingEmployee);
        } else {
            String generatedCnapsNumber = generateCnapsNumber();
            employee.setCnaps(generatedCnapsNumber);

            com.example.prog4.repository.entity.Employee domain = employeeMapper.toDomain(employee);
            employeeService.saveOne(domain);
        }
        return "redirect:/employee/list";
    }
    @GetMapping("/cnaps/{cnapsNumber}")
    public String getEmployeeByCnapsNumber(@PathVariable String cnapsNumber, Model model) {
        EmployeeCNAPS employeeCNAPS = employeeCNAPSFacade.getEmployeeCNAPSByCnapsNumber(cnapsNumber);
        model.addAttribute("employeeCNAPS", employeeCNAPS);
        return "employee/cnaps-details";
    }
}

