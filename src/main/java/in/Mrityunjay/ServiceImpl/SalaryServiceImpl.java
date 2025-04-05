package in.Mrityunjay.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.Mrityunjay.Entity.Salary;
import in.Mrityunjay.Entity.SalaryResponseDTO;
import in.Mrityunjay.Entity.User;
import in.Mrityunjay.Repo.SalaryRepo;
import in.Mrityunjay.Repo.UserRepo;

import in.Mrityunjay.Service.SalaryService;
@Service
public class SalaryServiceImpl implements SalaryService{

	
	@Autowired
	private SalaryRepo salaryRepository;
	
	 private static final double TAX_PERCENTAGE = 0.1; // 10% Tax
	
	     @Autowired
	     private UserRepo userRepository; // Inject UserRepo

	     private static final double TAX_PERCENTAGE1 = 0.1; // 10% Tax

	   
	     public String addSalary(Integer userId, SalaryResponseDTO salaryRequest) {
	    	    // Check if User Exists
	    	    User user = userRepository.findById(userId).orElse(null);
	    	    if (user == null) {
	    	        return "User not found!";
	    	    }

	    	    // Check if Basic Salary is null or zero and set a default value if needed
	    	    if (salaryRequest.getBasicSalary() == null || salaryRequest.getBasicSalary() <= 0) {
	    	        // You can either set a default value or throw an exception depending on your requirement
	    	        salaryRequest.setBasicSalary(0.0); // Or you could throw an exception to indicate invalid input
	    	    }

	    	    // Calculate Salary Details
	    	    double taxDeduction = salaryRequest.getBasicSalary() * TAX_PERCENTAGE;
	    	    double netSalary = salaryRequest.getBasicSalary() - taxDeduction;

	    	    // Create Salary Object
	    	    Salary salary = new Salary();
	    	    salary.setBasicSalary(salaryRequest.getBasicSalary());
	    	    salary.setTaxDeduction(taxDeduction);
	    	    salary.setNetSalary(netSalary);
	    	    salary.setGrossSalary(salaryRequest.getBasicSalary()); // Assuming Gross = Basic
	    	    salary.setUser(user);

	    	    // Save Salary
	    	    salaryRepository.save(salary);
	    	    return "Salary added successfully for user ID: " + userId;
	    	}


	     // ✅ Get Salary by User ID
	     @Override
	     public SalaryResponseDTO getDetails(Integer userId) {
	    	   // Salary salary = salaryRepository.findByUserId(userId);
	    	 Salary salary= 	    salaryRepository.findByEmployeeId(userId);

	         if (salary == null || salary.getUser() == null) {
	             return null;
	         }

	         // Return only required fields
	         return new SalaryResponseDTO(
	             salary.getUser().getId(),
	             salary.getUser().getUsername(),
	             salary.getBasicSalary(),
	             salary.getTaxDeduction(),
	             salary.getNetSalary()
	         );
	     }

	 }


