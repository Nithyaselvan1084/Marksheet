package com.example.studentresult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ResultsDao {
	@Autowired
	ResultsRepository resultrepo;

	public String addresult(Results result) {
		resultrepo.save(result);
		return "success";
	}

	public Results getresult(int id) {
		return resultrepo.findById(id).get();
	}

	public String updateresult(Results id) {
		resultrepo.save(id);
		return "success";
	}

	public String deleteresult(int id) {
		resultrepo.deleteById(id);
		return "success";
	}

	public String addallresult(List<Results> result) {
		resultrepo.saveAll(result);
		return "success";
	}

	public List<Results> getallresult() {
		return resultrepo.findAll();
	}
	public List<Integer> getrollnumber() {
		return resultrepo.getrollnumber();
	}

	

}
