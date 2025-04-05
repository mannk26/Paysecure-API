package in.Mrityunjay.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryResponseDTO {
    private Integer userId;
    private String username;
    private Double basicSalary;
    private Double taxDeduction;
    private Double netSalary;
}
