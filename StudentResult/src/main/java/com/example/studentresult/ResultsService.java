package com.example.studentresult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ResultsService {
	@Autowired
	ResultsDao resultdao;
	@Autowired
	RestTemplate rest;

	public String addresult(Results result) {
		return resultdao.addresult(result);
	}

	public Results getresult(int id) {
		return resultdao.getresult(id);
	}

	public String updateresult(Results id) {
		return resultdao.updateresult(id);
	}

	public String deleteresult(int id) {
		return resultdao.deleteresult(id);
	}

	public String addallresult(List<Results> result) {
		return resultdao.addallresult(result);
	}

	public List<Results> getallresult() {
		return resultdao.getallresult();
	}
	public Results gettopper() {
		Results topper=resultdao.getallresult().stream().max(Comparator.comparing(Results::getTotalmarks)).get();
		return topper;
	}
	public List<Integer> getrollnumber() {
		return resultdao.getrollnumber();
	}
	public List<Results>gettop3(){
		List<Results> ascend=resultdao.getallresult().stream().sorted(Comparator.comparing(Results::getTotalmarks).reversed()).limit(3).collect(Collectors.toList());
	
		return ascend;
		
		}
	public List<Student> getstudentbw170and190() {
		String Url1 = "http://localhost:8080/getallstud";
		String Url2 = "http://localhost:8082/getallresult";
		ResponseEntity<List<Student>> response1=rest.exchange(Url1,HttpMethod.GET,null,new ParameterizedTypeReference<List<Student>>() {});
		List<Student>studs=response1.getBody();
		ResponseEntity<List<Results>> response2=rest.exchange(Url2,HttpMethod.GET,null,new ParameterizedTypeReference<List<Results>>() {});
		List<Results>rsts=response2.getBody();
		List<Student>newstud=new ArrayList<>();
	    for(Results x: rsts) {
		if(x.getTotalmarks()>170&&x.getTotalmarks()<190)
		for(Student p:studs) {
			
				if(p.getRollnumber()==x.getRollnumber()) {
					newstud.add(p);
				}
			}
	    }
			return newstud;
	}

}

	

