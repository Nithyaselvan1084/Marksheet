package com.example.studentmarksheet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.studentmarksheet.entity.MarkSheet;
import com.example.studentmarksheet.repository.MarkSheetRepository;


@Repository
public class MarkSheetDao {
	@Autowired
	MarkSheetRepository markrepo;

	public String addmsheet(MarkSheet msheet) {
		markrepo.save(msheet);
		return "success";
	}

	public MarkSheet getmsheet(int id) {
		return markrepo.findById(id).get();
	}

	public String updatemsheet(MarkSheet id) {
		markrepo.save(id);
		return "success";
	}

	public String deletemsheet(int id) {
		markrepo.deleteById(id);
		return "success";
	}

	public String addallmsheet(List<MarkSheet> msheet) {
		markrepo.saveAll(msheet);
		return "success";
	}

	public List<MarkSheet> getallmsheet() {
		return markrepo.findAll();
	}
	public int getsem1total(int rollnumber) {
		return markrepo.getsem1total(rollnumber);
	}
	
	public int getsem2total(int rollnumber) {
		return markrepo.getsem2total(rollnumber);
	}
	

}
