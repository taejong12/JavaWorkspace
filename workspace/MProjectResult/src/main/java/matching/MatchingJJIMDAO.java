package matching;

import java.util.List;
import java.util.Vector;

import common.JDBConnPool;

public class MatchingJJIMDAO extends JDBConnPool{
	//찜목록 출력리스트
	public List<MatchingJJIMDTO> selectList(String jjim_from_num){
		List<MatchingJJIMDTO> boardLists = new Vector<MatchingJJIMDTO>();
		String query = "SELECT * FROM JJIMS";
			  query += " WHERE JJIM_FROM_NUM=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(jjim_from_num));
			rs=psmt.executeQuery();
			while(rs.next()) {
				MatchingJJIMDTO dto = new MatchingJJIMDTO();
				//dto.setJjim_from_num(rs.getInt("JJIM_FROM_NUM"));
				dto.setJjim_to_num(rs.getInt("JJIM_TO_NUM"));
				dto.setJjim_to_age(rs.getInt("JJIM_TO_AGE"));
				dto.setJjim_to_name(rs.getString("JJIM_TO_NAME"));
				boardLists.add(dto);
				System.out.println(boardLists.toString());
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return boardLists;
		
	}
	
	public int insertList(MatchingJJIMDTO dto) {
		int res = 0;
		try {
			String sql = "INSERT INTO JJIMS ( "
					+ " JJIM_FROM_NUM, JJIM_TO_NUM, JJIM_TO_AGE, JJIM_TO_NAME)"
					+ " VALUES( "
					+ " ?,?,?,?)";
			psmt=con.prepareStatement(sql);
			psmt.setInt(1, dto.getJjim_from_num());
			psmt.setInt(2, dto.getJjim_to_num());
			psmt.setInt(3, dto.getJjim_to_age());
			psmt.setString(4, dto.getJjim_to_name());
			res = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("게시물 입력 중 에러");
			e.printStackTrace();
		}	
		return res;
	}
	
	
	public int deleteList(String jjim_from_num, String jjim_to_num) {
		int result = 0;
		try {
			String query = "DELETE FROM JJIMS WHERE JJIM_FROM_NUM=? AND JJIM_TO_NUM=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, Integer.parseInt(jjim_from_num));
			psmt.setInt(2, Integer.parseInt(jjim_to_num));
			result = psmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("찜목록 삭제 중 에러");
			e.printStackTrace();
		}
		return result;
	}
}
