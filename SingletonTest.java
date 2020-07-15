package com.test.java.practice;

/*
 * Singleton class example using two ways : lazy initialization and eager initialization
 */
class SingletonClass {
	
	// Approach-1: using eager initialization
	static SingletonClass singleton;
	
	// since instantiation happens in static block, whether instance is needed or not, object gets created during class loading
	static {
		singleton = new SingletonClass();
	}
	
	private SingletonClass() {	
	}	
	
	public static SingletonClass getSingletonClassInstance() {
		return singleton;
	}
	
}

class SingletonLazyLoadingClass {
	
	//Approach-2: Using lazy instantiation
	// Lazy instanitation means only whenever requested then only object should get created
	
	static SingletonLazyLoadingClass lazyObj;
	
	private SingletonLazyLoadingClass() {}
	
	// here object creation happens in static method. whenever user calls this method, if instance is not created, only for the
	// first time it creates the instance, next time it uses the same instance
	public static SingletonLazyLoadingClass getSingletonLazyInstance() {
		if (lazyObj == null) {
			// if object is not created, then create instance
			lazyObj = new SingletonLazyLoadingClass();
		}
		return lazyObj;
	}
}

public class SingletonTest {
	
	public static void main(String[] args) {
		
		// getting instance of singleton class which is created using eager instantiation
		SingletonClass obj = SingletonClass.getSingletonClassInstance();
		
		SingletonLazyLoadingClass lazyObj = SingletonLazyLoadingClass.getSingletonLazyInstance();
		
		// now print hashcode of obj
		System.out.println(obj.hashCode());
		
		// now print hashcode of lazyObj
		System.out.println(lazyObj.hashCode());
		
	}
}



