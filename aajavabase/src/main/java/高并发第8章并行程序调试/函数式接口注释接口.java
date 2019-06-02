package 高并发第8章并行程序调试;
@FunctionalInterface
public interface 函数式接口注释接口 {

	void 接口();
	
	boolean equals(Object o);
	
	default void use() {
		System.out.println("use");
	}
}
