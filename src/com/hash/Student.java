package com.hash;
/**
 * 
 * @author beta
 *java中的hashcode
 */
public class Student {
	private int grade;
	private int cls;
	private String fristName;
	private String lastName;
	
	
	
	public Student(int grade, int cls, String fristName, String lastName) {
		super();
		this.grade = grade;
		this.cls = cls;
		this.fristName = fristName;
		this.lastName = lastName;
	}
	
	//计算hash值
	@Override
	public int hashCode() {
		int B = 31;
		int hash = 0;
		hash = hash*B+grade;
		hash = hash*B+cls;
		hash = hash*B+fristName.toLowerCase().hashCode();
		hash = hash*B+lastName.toLowerCase().hashCode();
		return hash;
	}
	
	
	//hash冲突的解决
	@Override
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		}
		
		if(o == null) {
			return false;
		}
		
		if(o.getClass() != this.getClass()) {
			return false;
		}
		
		Student s = (Student) o;
		return s.cls==this.cls&&
				s.fristName.toLowerCase().equals(this.fristName.toLowerCase())&&
				s.grade==this.grade&&
				s.lastName.toLowerCase().equals(this.lastName.toLowerCase());
	}
	
	public static void main(String[] args) {
		Student s = new Student(1, 2, "asd", "w");
		System.out.println(s.hashCode());
	}
	
}
