package fileUpDown;

import java.util.List;
import java.util.Vector;
import common.JDBConnPool;

public class MyFileDAO extends JDBConnPool{
	//새로운 게시물을 입력합니다.
	public int insertFile(MyFileDTO dto) {
		int applyResult =0;
		try {
			String query = "INSERT INTO MYFILE("
					+" IDX, NAME, TITLE, CATE, OFILE, NFILE)"
					+" VALUES( "
					+" SEQ_BOARD_NUM.NEXTVAL,?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1,  dto.getName());
			psmt.setString(2,  dto.getTitle());
			psmt.setString(3,  dto.getCate());
			psmt.setString(4,  dto.getOfile());
			psmt.setString(5,  dto.getNfile());
			
			applyResult = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("Insert 중 예외발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	
	//파일 목록을 반환합니다.
	public List<MyFileDTO> myFileList(){
		List<MyFileDTO> fileList = new Vector<MyFileDTO>(); //파일 목록을 담을 리스트 작성
		//쿼리문 작성
		String query = "SELECT * FROM MYFILE ORDER BY IDX DESC";
		try {
			psmt=con.prepareStatement(query); //쿼리문을 담은 전송객체 생성
			rs=psmt.executeQuery(); //전송객체에 있는 쿼리문을 실행시켜 결과 반환
			while(rs.next()) { //목록이 있는 수만큼 반복해서 DTO에 저장
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setNfile(rs.getString(6));
				dto.setRegdate(rs.getString(7));
				
				fileList.add(dto); //DTO의 내용을 리스트에 저장
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return fileList;//파일목록리스트 반환
		
	}
}
