package in.Mrityunjay.Service;


import in.Mrityunjay.Entity.SalaryResponseDTO;

public interface SalaryService {

    String addSalary(Integer user,SalaryResponseDTO salaryRequest);

	//Salary getSalaryByUserId(Integer userId);
     SalaryResponseDTO getDetails (Integer userId) ;


}
