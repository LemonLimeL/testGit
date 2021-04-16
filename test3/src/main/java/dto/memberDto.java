package dto;

public class memberDto {

	private int empid;
	private String name;
	private String jobid;
	private String phone;
	private String hiredate;
	
	public memberDto() {
		// TODO Auto-generated constructor stub
	}
	
	public memberDto(String name, String jobid, String phone, String hiredate) {
		super();
		this.name = name;
		this.jobid = jobid;
		this.phone = phone;
		this.hiredate = hiredate;
	}


	public memberDto(int empid, String name, String jobid, String phone, String hiredate) {
		super();
		this.empid = empid;
		this.name = name;
		this.jobid = jobid;
		this.phone = phone;
		this.hiredate = hiredate;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	@Override
	public String toString() {
		return "memberDto [empid=" + empid + ", name=" + name + ", jobid=" + jobid + ", phone=" + phone + ", hiredate="
				+ hiredate + "]";
	}
	
	
}
