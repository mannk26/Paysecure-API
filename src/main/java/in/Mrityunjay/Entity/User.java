	package in.Mrityunjay.Entity;
	
	import jakarta.persistence.CascadeType;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
    import jakarta.persistence.OneToOne;
    import lombok.Data;
	
	@Data
	@Entity
	
	public class User {
	
		@Id  // Primary Key
	    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment ID
		private Integer id;
		private String username;
	
		private String email;
		private String password;
		private String role;
		@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
		
	   
		private Salary salary;
	
		
	}
