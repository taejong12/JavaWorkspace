package practice;

import java.util.Arrays;

public class Book0915 {

	String title;
	int price;
	boolean borrowed;
	
	Book0915(String titles,int prices, boolean borrowed){
		title=titles;
		price=prices;
		this.borrowed=borrowed;
	}
	
	public String toString(){
		return "["+title+"]"+price+"원, 대여하시겠습니까?"+borrowed;
	}
	
	void rented(){
		borrowed=true;
	}
	
	void returned() {
		borrowed=false;
	}
	
	public static void main(String args[]) {
		Book0915[] books = new Book0915[10];
		books[0]=new Book0915("책0",8000,false);
		books[1]=new Book0915("책1",8000,false);
		books[2]=new Book0915("책2",8000,false);
		books[3]=new Book0915("책3",8000,false);
		books[4]=new Book0915("책4",8000,false);
		books[5]=new Book0915("책5",8000,false);
		books[6]=new Book0915("책6",8000,false);
		books[7]=new Book0915("책7",8000,false);
		books[8]=new Book0915("책8",8000,false);
		books[9]=new Book0915("책9",8000,false);
		
		System.out.println(Arrays.toString(books));
		
		books[0].rented();
		books[1].rented();
		books[3].rented();
		books[5].rented();
		books[8].rented();
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==true) {
				System.out.println(books[i]);
			}
		}
		
		int[] a= new int[5];
		
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*10);
			System.out.println(a[i]);
			for(int j=0;j<i;j++) {
				if(a[i]==a[j]) {
					i--;
				}
			}
		}
		
		System.out.println(Arrays.toString(a));
		
		for(int k=0;k<a.length;k++) {
			books[a[k]].rented();
		}
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==false) {
				System.out.println(books[i]);
			}
		}
	}
}
