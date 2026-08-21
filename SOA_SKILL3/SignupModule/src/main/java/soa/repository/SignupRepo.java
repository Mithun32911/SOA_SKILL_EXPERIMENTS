package soa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import soa.model.Signup;

@Repository
public interface SignupRepo extends JpaRepository<Signup, String>{

	Signup findByUsername(String username);

}
