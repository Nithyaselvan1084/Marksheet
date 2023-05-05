package com.example.studentmarksheet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.studentmarksheet.entity.MarkSheet;
import com.example.studentmarksheet.service.MarkSheetService;


@RestController
public class MarkSheetController {
	@Autowired
	MarkSheetService markser;

	@PostMapping(value = "/addmsheet")
	public String addmsheet(@RequestBody MarkSheet msheet) {
		int sem1total=msheet.getSem1practical()+msheet.getSem1theory();
		int sem2total=msheet.getSem2practical()+msheet.getSem2theory();
		msheet.setSem1total(sem1total);
		msheet.setSem2total(sem2total);
		return markser.addmsheet(msheet);
	}

	@GetMapping(value = "/getmsheet/{id}")
	public MarkSheet getmsheet(@PathVariable int id) {
		return markser.getmsheet(id);
	}

	@PutMapping(value = "/updatesheet/{id}")
	public String updatemsheet(@RequestBody MarkSheet id) {
		return markser.updatemsheet(id);
	}

	@DeleteMapping(value = "/deletesheet/{id}")
	public String deletesheet(@PathVariable int id) {
		return markser.deletemsheet(id);
	}

	@PostMapping(value = "/addallmsheet")
	public String addallmsheet(@RequestBody List<MarkSheet> msheet) {
		return markser.addallmsheet(msheet);
	}

	@GetMapping(value = "/getallmsheet")
	public List<MarkSheet> getallmsheet() {
		return markser.getallmsheet();
	}
	@GetMapping(value="/getsem1total/{rollnumber}")
	public int getsem1total(@PathVariable int rollnumber) {
		return markser.getsem1total(rollnumber);
	}
	@GetMapping(value="/getsem2total/{rollnumber}")
	public int getsem2total(@PathVariable int rollnumber) {
		return markser.getsem2total(rollnumber);
	}
	


}
