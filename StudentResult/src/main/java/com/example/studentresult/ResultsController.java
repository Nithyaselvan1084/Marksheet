package com.example.studentresult;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class ResultsController {
	@Autowired
	ResultsService resultser;
	@Autowired
	RestTemplate rest;
  
	@PostMapping(value = "/addResults")
	public String addresult(@RequestBody Results result) {
		String Url2 = "http://localhost:8081/getsem1total/";
		String Url3 = "http://localhost:8081/getsem2total/";
		String Url4 = "http://localhost:8080/getname/";
		String Url5 = "http://localhost:8080/getattendence/";
		int temp = result.getRollnumber();
		ResponseEntity<Integer> response1 = rest.exchange(Url2 + temp, HttpMethod.GET, null, Integer.class);
		int sem1total = response1.getBody();
		ResponseEntity<Integer> response2 = rest.exchange(Url3 + temp, HttpMethod.GET, null, Integer.class);
		int sem2total = response2.getBody();
		int total = sem2total + sem1total;
		ResponseEntity<Integer> response3 = rest.exchange(Url5 + temp, HttpMethod.GET, null, Integer.class);
		int attendance = response3.getBody();
		if (attendance > 90) {
			int total2 = total + 5;
			result.setTotalmarks(total2 / 2);
		}
		else {
			result.setTotalmarks(total / 2);  
		}
		if (result.getTotalmarks() > 200) {
			result.setTotalmarks(200);
		}
		else {
			result.setTotalmarks(total/2);
		}
		int per = result.getTotalmarks() / 2;
		result.setPercentage(per);
		ResponseEntity<String> response4 = rest.exchange(Url4 + temp, HttpMethod.GET, null, String.class);
		String name = response4.getBody();
		result.setName(name);
		return resultser.addresult(result);
	}

	@GetMapping(value = "/getresult/{id}")
	public Results getresult(@PathVariable int id) {
		return resultser.getresult(id);
	}

	@PutMapping(value = "/updateresult/{id}")
	public String updateresult(@RequestBody Results id) {
		return resultser.updateresult(id);
	}

	@DeleteMapping(value = "/deleteresult/{id}")
	public String deleteresult(@PathVariable int id) {
		return resultser.deleteresult(id);
	}

	@PostMapping(value = "/addallResults")
	public String addallresult(@RequestBody List<Results> result) {
		String Url2 = "http://localhost:8081/getsem1total/";
		String Url3 = "http://localhost:8081/getsem2total/";
		String Url4 = "http://localhost:8080/getname/";
		String Url5 = "http://localhost:8080/getattendance/";
		List<Results> res = result;
		for (Results x : res) {
			int temp = x.getRollnumber();
			ResponseEntity<Integer> response1 = rest.exchange(Url2 + temp, HttpMethod.GET, null, Integer.class);
			int sem1total = response1.getBody();
			ResponseEntity<Integer> response2 = rest.exchange(Url3 + temp, HttpMethod.GET, null, Integer.class);
			int sem2total = response2.getBody();
			int total = sem2total + sem1total;
			ResponseEntity<Integer> response3 = rest.exchange(Url5 + temp, HttpMethod.GET, null, Integer.class);
			int attendance = response3.getBody();
			if (attendance > 90) {
				int total2 = total + 5;
				x.setTotalmarks(total2 / 2);
			}
			else {
				x.setTotalmarks(total/2);
			}
			if (x.getTotalmarks() > 100) {
				x.setTotalmarks(200);
			}
			else {
				x.setTotalmarks(total/2);
			} 
			int per = x.getTotalmarks() / 2;
			x.setPercentage(per);
			ResponseEntity<String> response4 = rest.exchange(Url4 + temp, HttpMethod.GET, null, String.class);
			String name = response4.getBody();
			x.setName(name);
		}
		return resultser.addallresult(result);
	}

	@GetMapping(value = "/getallresult")
	public List<Results> getallresult() {
		return resultser.getallresult();
	}
	@GetMapping(value = "/gettopper")
	public Results gettopper() {
		return resultser.gettopper();
	} 
	@GetMapping(value = "/getrollnumberbetween170And190")
	public List<Integer> getrollnumber() {
		return resultser.getrollnumber();
	}
	@GetMapping(value = "/gettop3")
	public List<Results> gettop3() {
		return resultser.gettop3();
	}
	@GetMapping(value = "/getstudentbetween170And190")
	public List<Student> getstudentbw170and190() {
		return resultser.getstudentbw170and190();
	}
}
