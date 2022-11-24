package throwable;

class IDFormatException extends Exception{
	public IDFormatException(String message) {
		super(message);
	}
}
class UserId{
	private String userId;
	public String getuserId() {
		return userId;
	}
	public void setUsertId(String userId) throws IDFormatException {
		if(userId==null) {
			throw new IDFormatException("ID는 null이면 안됩니다.");
		} else if(userId.length()<8||userId.length()>20) {
			throw new IDFormatException("ID는 8자이상 20자까지 작성가능합니다.");
		}
		this.userId = userId;
	}
}
public class CusExceptionRun {

	public static void main(String[] args) {
		UserId uid = new UserId();
		String userId = null;
		try {
			uid.setUsertId(userId);
		} catch(IDFormatException e) {
			System.out.println(e.getMessage());
		}
	}

}
