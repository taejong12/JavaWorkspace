package array;

public class BookArray {

	public static void main(String[] args) {
		Book bo  = new Book();
		bo.setBookName("삼국지1");
		String bn = bo.getBookName();
		System.out.println(bo.getBookName());
		
		Book[] lib = new Book[5];
		lib[0] = new Book("삼국지1","나관중");
		lib[1] = new Book("삼국지2","나관중");
		lib[2] = new Book("삼국지3","나관중");
		lib[3] = new Book("삼국지4","나관중");
		lib[4] = new Book("삼국지5","나관중");
		//lib[5] = new Book("삼국지6","나관중"); //ArrayIndexOutOfBounds
		
		for(int i=0;i<lib.length;i++) {
			System.out.println(i+" "+lib[i]);
		}
		for(int i=0;i<lib.length;i++) {
			System.out.print(lib[i].getBookName()+" by ");
			System.out.println(lib[i].getAuthor());
		}
		for(int i=0;i<lib.length;i++) {
			lib[i].printBookInfo();
		}
	}

}
