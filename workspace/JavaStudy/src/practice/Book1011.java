package practice;

import java.util.Arrays;

public class Book1011 {
	
	String title;
	int price;
	boolean borrowed;
	
	Book1011(String titles, int prices, boolean borrowed){
		title=titles;
		price=prices;
		this.borrowed=borrowed;
	}
	
	void rented () {
		borrowed=true;
	}
	
	void returned () {
		borrowed=false;
	}
	
	public String toString() {
		return "["+title+"]"+price+"원, 대여하시겠습니까?"+borrowed;
	}
	
	public static void main (String args[]) {
		Book1011[] books = new Book1011[10];
		books[0]=new Book1011("책0", 8000, false);
		books[1]=new Book1011("책1", 8100, false);
		books[2]=new Book1011("책2", 8200, false);
		books[3]=new Book1011("책3", 8300, false);
		books[4]=new Book1011("책4", 8400, false);
		books[5]=new Book1011("책5", 8500, false);
		books[6]=new Book1011("책6", 8600, false);
		books[7]=new Book1011("책7", 8700, false);
		books[8]=new Book1011("책8", 8800, false);
		books[9]=new Book1011("책9", 8900, false);
		
		System.out.println(Arrays.toString(books));
		
		books[0].rented();
		books[1].rented();
		books[2].rented();
		books[3].rented();
		books[4].rented();
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==true) {
				System.out.println(books[i]);
			}
		}
		
		int[] a = new int[5];
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*10);
			System.out.println(a[i]);
			for(int j=0;j<i;j++) {
				if(a[i]==a[j]) {
					i--;
				}
			}

		}
		
		for(int i=0;i<a.length;i++) {
			books[a[i]].rented();
		}
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==false) {
				System.out.println(books[i]);
			}
		}
		
		
		
	}
	
	
	
	
}
