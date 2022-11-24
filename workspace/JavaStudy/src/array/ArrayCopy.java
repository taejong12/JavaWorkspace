package array;

import java.util.Arrays;

public class ArrayCopy {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] b = a;

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			System.out.println(b[i]);
		}

		Book[] bArr1 = new Book[3];
		Book[] bArr2 = new Book[3];

		bArr1[0] = new Book("태백산맥1", "누군가");
		bArr1[1] = new Book("태백산맥2", "누군가");
		bArr1[2] = new Book("태백산맥3", "누군가");

		bArr2 = bArr1;

		for (int i = 0; i < bArr1.length; i++) {
			System.out.println(bArr1[i]);
			System.out.println(bArr2[i]);
			bArr1[i].printBookInfo();
			bArr2[i].printBookInfo();
		}
		bArr1[0].setBookName("레미제라블");
		bArr1[0].setAuthor("빅트르 위고");
		for (int i = 0; i < bArr2.length; i++) {
			bArr2[i].printBookInfo();
		}

		// Object.clone()
		int[] scores = { 1, 2, 3, 4, 5 };
		int[] newScores = scores; // 얕은 복사
		int[] newScores2 = scores.clone(); // 깊은 복사

		System.out.println(scores);
		System.out.println(newScores);
		System.out.println(newScores2);
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(newScores));
		System.out.println(Arrays.toString(newScores2));

		scores[1] = 11;
		System.out.println(Arrays.toString(scores));
		System.out.println(Arrays.toString(newScores));
		System.out.println(Arrays.toString(newScores2));

		// Arrays.copyOf()

		int[] cars = { 1, 2, 3, 4, 5, 6, 7 };
		int[] newCars = Arrays.copyOf(cars, cars.length);
		System.out.println(Arrays.toString(cars));
		System.out.println(Arrays.toString(newCars));
		int[] newCars2 = Arrays.copyOf(cars, 3);
		System.out.println(Arrays.toString(newCars2));
		int[] newCars3 = Arrays.copyOf(cars, 10);
		System.out.println(Arrays.toString(newCars3));

		int[] newCars4 = Arrays.copyOfRange(cars, 1, 3);
		System.out.println(Arrays.toString(newCars4));

		// System.arraycopy()
		int[] stars = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] newStars = new int[8];
		System.arraycopy(stars, 0, newStars, 0, 8);
		System.out.println(Arrays.toString(newStars));

		int[] newStars2 = new int[3];
		System.arraycopy(newStars, 4, newStars2, 0, 3);
		System.out.println(Arrays.toString(newStars2));

		// for문과 index를 통한 복사
		int[] inds = { 1, 2, 3, 4, 5 };
		int[] newInds = new int[5];

		for (int i = 0; i < inds.length; i++) {
			for (int j = 0; j < inds[i]; j++) {
				System.out.println("[" + i + "]" + "[" + j + "]");
			}
		}
		System.out.println(Arrays.toString(inds));
		System.out.println(newInds);
		for (int i = 0; i < inds.length; i++) {
			newInds[i] = inds[i];
		}
		System.out.println(Arrays.toString(inds));
		System.out.println(Arrays.toString(newInds));

		Book[] bArr3 = new Book[3];// 복사대상
		Book[] bArr4 = new Book[3];// 복사목적지

		bArr3[0] = new Book("우리1", "당신");
		bArr3[1] = new Book("우리2", "당신");
		bArr3[2] = new Book("우리3", "당신");

		// 주소가 같은지 확인해봄
		Book c = bArr3[0];
		System.out.println(c);
		c = bArr3[0].clone();
		System.out.println(c + c.getBookName() + c + c.getAuthor());

		for (int i = 0; i < bArr3.length; i++) {
			bArr4[i] = bArr3[i].clone();
		}
		bArr3[0].setBookName("적");
		bArr3[0].setAuthor("놈");
		for (int i = 0; i < bArr3.length; i++) {
			bArr3[i].printBookInfo();
		}
		for (int i = 0; i < bArr4.length; i++) {
			bArr4[i].printBookInfo();
		}

		System.out.println(Arrays.toString(bArr3));
		System.out.println(Arrays.toString(bArr4));

		
		
	}

}
