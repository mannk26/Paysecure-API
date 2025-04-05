package in.Mrityunjay.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import in.Mrityunjay.Entity.SalaryResponseDTO;
import in.Mrityunjay.Service.SalaryService;
@CrossOrigin(origins = "*")  // Allow all origins (for testing)

@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    // ✅ Add Salary for User (POST Request)
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/add/{userId}")
    public ResponseEntity<String> addSalary(
            @PathVariable Integer userId,
            @RequestBody SalaryResponseDTO salaryRequest) {
        
        String response = salaryService.addSalary(userId, salaryRequest);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('ADMIN','USER')")

    @GetMapping("/get/{userId}")
    public ResponseEntity<SalaryResponseDTO> getSalary(@PathVariable Integer userId) {
    	System.out.println("inside get SAlary");
        SalaryResponseDTO salary = salaryService.getDetails(userId);
        
        if (salary == null) {
            return ResponseEntity.notFound().build(); 
        }

        return ResponseEntity.ok(salary);
    }
}
