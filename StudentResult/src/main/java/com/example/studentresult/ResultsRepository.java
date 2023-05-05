package com.example.studentresult;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultsRepository extends JpaRepository<Results,Integer>{
	@Query(value="select rollnumber from studentresult where totalmarks>170 And totalmarks<190",nativeQuery=true)
	public List<Integer> getrollnumber();
	
//	@Query(value = "select * from studentresult order by totalmarks desc limit 3")
//	List<Results> gettop3();

}
