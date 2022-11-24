package practice;

import java.util.Arrays;

public class Book0922 {

	String title;
	int price;
	boolean borrowed;
	
	Book0922(String titles,int prices,boolean borrowed){
		title=titles;
		price=prices;
		this.borrowed=borrowed;
	}
	
	public String toString() {
		return "["+title+"]"+price+"원, 대여하시겠습니까?"+borrowed;
	}
	
	void rented() {
		borrowed=true;
	}
	
	void returned() {
		borrowed=false;
	}
	
	public static void main(String args[]) {
		Book0922[] books = new Book0922[10];
		books[0]=new Book0922("책0", 1000,false);
		books[1]=new Book0922("책1", 1100,false);
		books[2]=new Book0922("책2", 1200,false);
		books[3]=new Book0922("책3", 1300,false);
		books[4]=new Book0922("책4", 1400,false);
		books[5]=new Book0922("책5", 1500,false);
		books[6]=new Book0922("책6", 1600,false);
		books[7]=new Book0922("책7", 1700,false);
		books[8]=new Book0922("책8", 1800,false);
		books[9]=new Book0922("책9", 1900,false);
		
		System.out.println(Arrays.toString(books));
		
		books[1].rented();
		books[5].rented();
		books[6].rented();
		books[7].rented();
		books[8].rented();
		
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
