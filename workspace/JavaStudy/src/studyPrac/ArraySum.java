package studyPrac;

public class ArraySum {

	public static void main(String[] args) {
		//array 객체를 만드는 법
		int[] arr = new int[10];
		//array에 값을 할당
		for (int i = 0; i <arr.length; i++) {
			arr[i] = i * i; //int[] arr2 = {0,1,4,9,16,25,36,49,64,81};
		}
		//객체를 생성하면 값 할당
		//int[] arr2 = {0,1,4,9,16,25,36,49,64,81};
		
		System.out.printf("총합: %d\n", sum(arr));
	}

	public static int sum(int[] numbers) {
		int sum = 0;
		for(int i=0;i<numbers.length;i++) {
			sum += numbers[i];
		}
		System.out.println(sum);
		
		sum=0;
		for(int num:numbers) {
			sum+=num;
		}
		return sum;
	}

}
