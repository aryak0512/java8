
public class Employee implements Comparable<Employee> {

	private String name;

	private String age;

	@Override
	public String toString() {
		return name + age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAges() {
		return age;
	}

	public void setAges(String age) {
		this.age = age;
	}

	public Employee(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Employee e1) {

		Integer a1 = Integer.parseInt(this.age);
		Integer a2 = Integer.parseInt(e1.getAges());
		return a1.compareTo(a2);
	}

}
