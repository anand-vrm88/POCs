package org.gradle.features;

public class TypeSafeDemo {

	public static void main(String[] args) {
		CustomDataStore customDataStore = new CustomDataStore();
		UserDetails userDetails = customDataStore.deserialize(UserDetails.class);
		System.out.println(userDetails);
	}

	
	
}

class CustomDataStore{
	public <T> void serialize(T object){
		
	}
	
	public <T> T deserialize(Class<T> klass){
		return null;
	}
}

class UserDetails {
	
}

class Employee {
	
}
