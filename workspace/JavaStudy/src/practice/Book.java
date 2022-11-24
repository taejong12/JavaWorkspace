package practice;

public class Book {

	String title;
	int price;
	boolean borrowed;

	Book(String title, int price, boolean borrowed) {
		this.title = title;
		this.price = price;
		this.borrowed = borrowed;
	}

	public String toString() {
		return "[" + title + "]" + price + ", 대여중입니까?" + borrowed;
	}

	public void rented() {
		borrowed = true;
	}

	public void returned() {
		borrowed = false;
	}

	public static void main(String args[]) {
		Book[] books = new Book[10];
		books[0] = new Book("책0", 8000, false);
		books[1] = new Book("책1", 8100, false);
		books[2] = new Book("책2", 8200, false);
		books[3] = new Book("책3", 8300, false);
		books[4] = new Book("책4", 8400, false);
		books[5] = new Book("책5", 8500, false);
		books[6] = new Book("책6", 8600, false);
		books[7] = new Book("책7", 8700, false);
		books[8] = new Book("책8", 8800, false);
		books[9] = new Book("책9", 8900, false);

//		books[0].rented();
//		books[2].rented();
//		books[4].rented();
//		books[6].rented();
//		books[8].rented();

		int[] a = new int[5];

		for (int i = 0; i < a.length; i++) {
			a[i] = (int) (Math.random() * 10);
//			System.out.println(a[i]);
			for (int j = 0; j < i; j++) {
				if (a[i] == a[j]) {
					i--;
				}
			}
		}

		for (int k = 0; k <a.length; k++) {
			books[a[k]].rented();
		}

		for (int i = 0; i < books.length; i++) {
			if (books[i].borrowed == false) {
				System.out.println(books[i]);
			}
		}

	}

}
