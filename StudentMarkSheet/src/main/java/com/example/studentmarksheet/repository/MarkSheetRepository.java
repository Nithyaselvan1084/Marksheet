package com.example.studentmarksheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.studentmarksheet.entity.MarkSheet;

public interface MarkSheetRepository extends JpaRepository<MarkSheet, Integer> {
	@Query(value = "select sem1total from marksheet where rollnumber=?",nativeQuery=true)
	public int getsem1total(int id);
	@Query(value = "select sem2total from marksheet where rollnumber=?",nativeQuery=true)
	public int getsem2total(int id);
	
}
