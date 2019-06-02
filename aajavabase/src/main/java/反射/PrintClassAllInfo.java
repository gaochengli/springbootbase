/**
 * 
 */
package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author clgao
 * 输入类名，打印该类的所有信息。
 */
public class PrintClassAllInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String name;
		if(args.length>0) name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("输入类名(e.g. java.util.Date):");
			name = in.next();
		}
		
		//如果不是Object,打印类名和父类名
		try {
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.println("class "+name);
			if(supercl != null && supercl != Object.class) {
				System.out.println(" extends "+supercl.getName());
			}
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printField(cl);
			System.out.println("}");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void printConstructors(Class cl) {
		Constructor[] cs = cl.getDeclaredConstructors();
		for(Constructor c: cs) {
			String name = c.getName();
			System.out.print("  ");
			String modifiers = Modifier.toString(c.getModifiers());
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(name+"(");
			Class[] ps = c.getParameterTypes();
			for(int j=0;j<ps.length;j++) {
				if(j>0) {
					System.out.print(ps[j].getName());
				}
			}
			System.out.print(");");
		}
	}
	public static void printMethods(Class cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m:methods) {
			Class retType = m.getReturnType();
			String name = m.getName();
			System.out.println("  ");
			//
			String modifiers = Modifier.toString(m.getModifiers());
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.print(retType.getName()+" "+name+" (");
			Class[] paramTypes = m.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++) {
				if(j>0) {
					System.out.print(", ");
				}
				System.out.print(paramTypes[j].getName());
			}
			System.out.print(");");
		}
	}
	public static void printField(Class cl) {
		Field[] fields = cl.getDeclaredFields();
		for(Field f: fields) {
			Class type = f.getType();
			String name = f.getName();
			System.out.println("  ");
			System.out.print(f.toString());
			System.out.print(Integer.toBinaryString(f.getModifiers()));
			String modifiers = Modifier.toString(f.getModifiers());
			if(modifiers.length()>0) {
				System.out.print(modifiers+" ");
			}
			System.out.println(type.getName()+" "+name+";");
		}
	}

}





































