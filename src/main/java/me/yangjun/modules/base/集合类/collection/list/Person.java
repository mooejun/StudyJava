package me.yangjun.modules.base.集合类.collection.list;

public class Person {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "(name:" + name + " age:" + age + ")";
	}

}
