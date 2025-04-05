package in.Mrityunjay.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double basicSalary;
    private Double taxDeduction;
    private Double netSalary;
    private Double grossSalary;

    @OneToOne
    @JoinColumn(name = "user_id")  // Foreign key to User table
    private User user;
//    @PrePersist
//    @PreUpdate
    public void calculateSalary() {
        this.taxDeduction = this.basicSalary * 0.10;  // 10% tax deduction
        this.netSalary = this.basicSalary - this.taxDeduction;
        this.grossSalary = this.basicSalary;  // Assuming Gross Salary = Basic Salary
    }
}
//
