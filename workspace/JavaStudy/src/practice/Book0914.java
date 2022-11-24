package practice;

public class Book0914 {

	String title;
	int price;
	boolean borrowed;
	
	Book0914(String titles, int prices, boolean borrowed){
		title=titles;
		price=prices;
		this.borrowed=borrowed;
	}
	
	public String toString(){
		return "["+title+"]"+price+"원, 대여중입니까?"+borrowed;
	}
	
	void rented(){
		borrowed=true;
	}
	
	void returned() {
		borrowed=false;
	}
	
	public static void main(String args[]) {
		Book0914[] books = new Book0914[10];
		books[0]=new Book0914("책0", 9000, false);
		books[1]=new Book0914("책1", 9100, false);
		books[2]=new Book0914("책2", 9200, false);
		books[3]=new Book0914("책3", 9300, false);
		books[4]=new Book0914("책4", 9400, false);
		books[5]=new Book0914("책5", 9500, false);
		books[6]=new Book0914("책6", 9600, false);
		books[7]=new Book0914("책7", 9700, false);
		books[8]=new Book0914("책8", 9800, false);
		books[9]=new Book0914("책9", 9900, false);
		
		books[1].rented();
		books[3].rented();
		books[5].rented();
		books[7].rented();
		books[9].rented();
		
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==true)
			System.out.println(books[i]);
		}
		
		int[] a=new int[5];
		
		for(int i=0;i<a.length;i++) {
			a[i]=(int)(Math.random()*10);
			System.out.println(a[i]);
			for(int j=0;j<i;j++) {
				if(a[i]==a[j]) {
					i--;
				}
			}
		}
		
		for(int k=0;k<a.length;k++) {
			books[a[k]].rented();
		}
		
		System.out.println("=============");
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==true)
			System.out.println(books[i]);
		}
		
		System.out.println("=============");
		for(int i=0;i<books.length;i++) {
			if(books[i].borrowed==false)
			System.out.println(books[i]);
		}
		
		
		
		
		
		
		
	}
}
