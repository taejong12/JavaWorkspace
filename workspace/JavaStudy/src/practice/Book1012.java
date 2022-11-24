package practice;

import java.util.Arrays;

public class Book1012 {

	String title;
	int price;
	boolean borrowed;

	Book1012(String titles, int prices, boolean borrowed) {
		title = titles;
		price = prices;
		this.borrowed = borrowed;
	}

	void rented() {
		borrowed = true;
	}

	void retured() {
		borrowed = false;
	}

	public String toString() {
		return "[" + title + "]" + price + "원, 대여하시겠습니까?" + borrowed;
	}

	public static void main(String args[]) {
		Book1012[] books = new Book1012[10];
		books[0] = new Book1012("책0", 8000, false);
		books[1] = new Book1012("책1", 8000, false);
		books[2] = new Book1012("책2", 8000, false);
		books[3] = new Book1012("책3", 8000, false);
		books[4] = new Book1012("책4", 8000, false);
		books[5] = new Book1012("책5", 8000, false);
		books[6] = new Book1012("책6", 8000, false);
		books[7] = new Book1012("책7", 8000, false);
		books[8] = new Book1012("책8", 8000, false);
		books[9] = new Book1012("책9", 8000, false);

		System.out.println(Arrays.toString(books));

		books[0].rented();
		books[1].rented();
		books[2].rented();
		books[3].rented();
		books[4].rented();
		
		for (int i = 0; i < books.length; i++) {
			if (books[i].borrowed == true) {
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
		
		
		for(int i=0; i<a.length;i++) {
			books[a[i]].rented();
		}
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==false) {
				System.out.println(books[i]);
			}
		}

	}

}
