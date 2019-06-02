package 封装;

public class Person {

	private String name;
	private int age;
	public void setName(String name) {
		//合理性校验
		if(name.length()>6||name.length()<2) {
			System.out.println("您设置的人名不符合要求！");
			return;
		}else {
			this.name = name;	
		}
		
	}
	public String getName() {
		return this.name;
	}
	//提供方法来操作age成员变量
	public void setAge(int age){
		//对年纪进行有效性验证
		if(age>150||age<1) {
			System.out.println("您输入的年龄不合法！");
			return;
		}else {
			this.age = age;
		}
	}
	
	public int getAge() {
		return this.age;
	}
	
	public static void main(String[] args) {
		Person p = new Person();
//		p.age = 1000;
//		p.setAge(1000);
//		System.out.println(p.getAge());
		p.setAge(30);
		System.out.println(p.age);
	}
	
}
