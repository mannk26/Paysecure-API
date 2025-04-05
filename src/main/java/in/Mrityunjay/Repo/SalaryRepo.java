package in.Mrityunjay.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.Mrityunjay.Entity.Salary;

public interface SalaryRepo extends JpaRepository<Salary, Integer>{

	@Query("select s from Salary s where s.id=:userId")
	Salary findByUserId(Integer userId);
@Query("select s from Salary s where s.user.id=:id")
	 Salary findByEmployeeId(Integer id);

}
