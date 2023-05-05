package com.example.studentmarksheet.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="marksheet")
public class MarkSheet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int rollnumber;
	private int sem1theory;
	private int sem1practical;
	private int sem1total;
	private int sem2theory;
	private int sem2practical;
	private int sem2total;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
	public int getSem1theory() {
		return sem1theory;
	}
	public void setSem1theory(int sem1theory) {
		this.sem1theory = sem1theory;
	}
	public int getSem1practical() {
		return sem1practical;
	}
	public void setSem1practical(int sem1practical) {
		this.sem1practical = sem1practical;
	}
	public int getSem1total() {
		return sem1total;
	}
	public void setSem1total(int sem1total) {
		this.sem1total = sem1total;
	}
	public int getSem2theory() {
		return sem2theory;
	}
	public void setSem2theory(int sem2theory) {
		this.sem2theory = sem2theory;
	}
	public int getSem2practical() {
		return sem2practical;
	}
	public void setSem2practical(int sem2practical) {
		this.sem2practical = sem2practical;
	}
	public int getSem2total() {
		return sem2total;
	}
	public void setSem2total(int sem2total) {
		this.sem2total = sem2total;
	}
	
	
	

}
