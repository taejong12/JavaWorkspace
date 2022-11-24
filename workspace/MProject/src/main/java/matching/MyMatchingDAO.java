package matching;

import java.util.List;
import java.util.Vector;
import connectPool.ConnectPool;

public class MyMatchingDAO extends ConnectPool{
	public List<MyMatchingDTO> selectList(String My_num){
		List<MyMatchingDTO> matchLists = new Vector<MyMatchingDTO>();
		String query = "SELECT * FROM MATCHINGS";
			  query += " WHERE MA_FROM_NUM=? OR MA_TO_NUM=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, My_num);
			psmt.setString(2, My_num);
			rs=psmt.executeQuery();
			while(rs.next()) {
				MyMatchingDTO dto = new MyMatchingDTO();
				dto.setMa_from_num(rs.getInt("MA_FROM_NUM"));
				System.out.println(dto.getMa_from_num());
				dto.setMa_from_name(rs.getString("MA_FROM_NAME"));
				System.out.println(dto.getMa_from_name());
				dto.setMa_to_num(rs.getInt("MA_TO_NUM"));
				System.out.println(dto.getMa_to_num());
				dto.setMa_to_name(rs.getString("MA_TO_NAME"));
				System.out.println(dto.getMa_to_name());
				dto.setMa_sfrom_num(rs.getInt("MA_SFROM_NUM"));
				System.out.println(dto.getMa_sfrom_num());
				dto.setMa_sfrom_name(rs.getString("MA_SFROM_NAME"));
				System.out.println(dto.getMa_sfrom_name());
				dto.setMa_sto_num(rs.getInt("MA_STO_NUM"));
				System.out.println(dto.getMa_sto_num());
				dto.setMa_sto_name(rs.getString("MA_STO_NAME"));
				System.out.println(dto.getMa_sto_name());
				dto.setMa_message(rs.getString("MA_MESSAGE"));
				System.out.println(dto.getMa_message());
				
				dto.setMa_from_kakao(rs.getString("MA_FROM_KAKAO"));
				System.out.println(dto.getMa_from_kakao());
				dto.setMa_from_email(rs.getString("MA_FROM_EMAIL"));
				System.out.println(dto.getMa_from_email());
				dto.setMa_from_phone(rs.getString("MA_FROM_PHONE"));
				System.out.println(dto.getMa_from_phone());
				
				dto.setMa_to_kakao(rs.getString("MA_TO_KAKAO"));
				System.out.println(dto.getMa_to_kakao());
				dto.setMa_to_email(rs.getString("MA_TO_EMAIL"));
				System.out.println(dto.getMa_to_email());
				dto.setMa_to_phone(rs.getString("MA_TO_PHONE"));
				System.out.println(dto.getMa_to_phone());
				
				matchLists.add(dto);
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return matchLists;
	}
	
	public int insertList(MyMatchingDTO dto) {
		int res = 0;
		try {
			String sql = "INSERT INTO MATCHINGS ( "
					+ " MA_FROM_NUM, MA_FROM_NAME, MA_TO_NUM, MA_TO_NAME, MA_MESSAGE, "
					+ " MA_FROM_KAKAO, MA_FROM_PHONE, MA_FROM_EMAIL, MA_TO_KAKAO, MA_TO_PHONE, MA_TO_EMAIL)"
					+ " VALUES( "
					+ " ?,?,?,?,?,?,?,?,?,?,?)";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, dto.getMa_from_num());
			psmt.setString(2, dto.getMa_from_name());
			psmt.setInt(3, dto.getMa_to_num());
			psmt.setString(4, dto.getMa_to_name());
			psmt.setString(5, dto.getMa_message());
			
			psmt.setString(6, dto.getMa_from_kakao());
			psmt.setString(7, dto.getMa_from_phone());
			psmt.setString(8, dto.getMa_from_email());
			
			psmt.setString(9, dto.getMa_to_kakao());
			psmt.setString(10, dto.getMa_to_phone());
			psmt.setString(11, dto.getMa_to_email());
			
			
			res = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("매칭신청 등록 중 에러");
			e.printStackTrace();
		}	
		return res;
	}
	
	public int insertSucList(MyMatchingDTO dto) {
		int res = 0;
		try {
			String sql = "UPDATE MATCHINGS SET "
					+ " MA_SFROM_NUM =? ,MA_SFROM_NAME =? ,MA_STO_NUM=? ,MA_STO_NAME=? "
					+ " WHERE MA_FROM_NUM=? AND MA_TO_NUM=?";
			
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, dto.getMa_sfrom_num());
			psmt.setString(2, dto.getMa_sfrom_name());
			psmt.setInt(3, dto.getMa_sto_num());
			psmt.setString(4, dto.getMa_sto_name());
			
			psmt.setInt(5, dto.getMa_sfrom_num());
			psmt.setInt(6, dto.getMa_sto_num());
			res = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("매칭성공 등록 중 에러");
			e.printStackTrace();
		}	
		return res;
	}
	
	
	public int rejectList(String ma_sfrom_num, String ma_sto_num) {
		int result = 0;
		try {
			String query = "DELETE FROM MATCHINGS WHERE MA_FROM_NUM=? OR MA_TO_NUM=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(ma_sfrom_num));
			psmt.setInt(2, Integer.parseInt(ma_sto_num));
		
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("매칭 거절 중 에러");
			e.printStackTrace();
		}
		return result;
	}
}
