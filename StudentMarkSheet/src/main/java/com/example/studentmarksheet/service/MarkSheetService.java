package com.example.studentmarksheet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.studentmarksheet.dao.MarkSheetDao;
import com.example.studentmarksheet.entity.MarkSheet;


@Service
public class MarkSheetService {
	@Autowired
	MarkSheetDao markdao;

	public String addmsheet(MarkSheet msheet) {
		return markdao.addmsheet(msheet);
	}

	public MarkSheet getmsheet(int id) {
		return markdao.getmsheet(id);
	}

	public String updatemsheet(MarkSheet id) {
		return markdao.updatemsheet(id);
	}

	public String deletemsheet(int id) {
		return markdao.deletemsheet(id);
	}

	public String addallmsheet(List<MarkSheet> msheet) {
		return markdao.addallmsheet(msheet);
	}

	public List<MarkSheet> getallmsheet() {
		return markdao.getallmsheet();
	}
	public int getsem1total(int rollnumber) {
		return markdao.getsem1total(rollnumber);
	}
	
	public int getsem2total(int rollnumber) {
		return markdao.getsem2total(rollnumber);
	}
	


}
