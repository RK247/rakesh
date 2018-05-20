package com.jlcindia.hibernate;

@Entity
@Table(name="jlcstudents")
public class Student {

	    @Id
	    @Column(name="sid")
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private Integer sid;
	    
	    @Column(name="sname")
		private String sname;
	    
	    @Column(name="email")
	    private String email;
	    
	    @Column(name="phone")
		private long phone;
	    
	    @ManyToMany
	    @JoinTable(name="stu_cou",joinColumns=@JoinColumn(name="sid",referencedColumnName="sid"),inverseJoinColumns=@JoinColumn(name="cid",referencedColumnName="cid"))
		private Set<Course> courses;
		public Student(){}
		
	    public Student(String sname, String email, long phone) {

			this.sname = sname;
			this.email = email;
			this.phone = phone;

		}
	    public Student(Integer sid, String sname, String email, long phone) {
	    	
			this.sid = sid;
			this.sname = sname;
			this.email = email;
			this.phone = phone;
		}

				public Integer getSid() {
			return sid;
		}

		public void setSid(Integer sid) {
			this.sid = sid;
		}

		public String getSname() {
			return sname;
		}

		public void setSname(String sname) {
			this.sname = sname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public long getPhone() {
			return phone;
		}

		public void setPhone(long phone) {
			this.phone = phone;
		}

		public Set<Course> getCourses() {
			return courses;
		}

		public void setCourses(Set<Course> courses) {
			this.courses = courses;
		}

				@Override
		public String toString() {
			return sid+","+sname+","+email+","+phone;
		}

		}

