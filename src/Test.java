import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

class A{
	static{
	System.out.println("A Class is Loaded...");	
	}
	A(){
		System.out.println("A class cons Call..");
	}
	void setVisible(){
		System.out.println("A is visible...");
	}
}


class B{
	static{
		System.out.println("B Class is Loaded...");	
		}
		B(){
			System.out.println("B class cons Call..");
		}
		void setVisible(){
			System.out.println("C is visible...");
		}


class Student{
	void setVisible(){
		System.out.println("Student class visible");
	}
	int id;
	String name;
	String address;
		
	
	Student(){
		System.out.println("student cons loaded...");
		id = 1001;
		name = "Ram";
		address = "Delhi";

	}

@Override
public int hashCode(){
	return 10;
	}
@Override
public String toString(){
	return "Student[id=" +id + ", name=" +name + ", address=" + address + "]";
}
}



public  class Test {
	public void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the CLass to Load...");
		String className = s.next();
		Object object = Class.forName(className).newInstance();
		Method method = object.getClass().getDeclaredMethod("setVisible", null);
		method.invoke(object, null);
	
	}

}
}

