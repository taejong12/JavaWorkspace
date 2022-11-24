package array;

public class EnhencedFor {

	public static void main(String[] args) {
		String[] family = {"아버지","어머니","나","동생","누나"};
		for(int i=0;i<family.length;i++) {
			System.out.print(family[i]+" ");
		}
		System.out.println();
		for(String el:family) {
			System.out.print(el+" ");
		}
		System.out.println();
		
	}

}
