package classPrac;

public class WrapperClassPrac {

	public static void main(String[] args) {
		int a =10;
		Integer num = 10; //박싱(boxing) 자동박싱
		int n = num.intValue(); //언박싱
		n = num; //자동 언박싱

		String str = "100";
		String str2 = "3.14";
		String str3 = "false";
		
		System.out.println(str+str2+1);
		
		byte b = Byte.parseByte(str);
		System.out.println(b);
		int i = Integer.parseInt(str);
		System.out.println(i);
		short s = Short.parseShort(str);
		System.out.println(s);
		long l = Long.parseLong(str);
		System.out.println(l);
		float f = Float.parseFloat(str2);
		System.out.println(f);
		double d = Double.parseDouble(str2);
		System.out.println(d);
		boolean bool = Boolean.parseBoolean(str3);
		System.out.println(bool);
		
		System.out.println(l+f+1);
	}

}
