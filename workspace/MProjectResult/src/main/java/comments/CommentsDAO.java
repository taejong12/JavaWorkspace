package comments;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class CommentsDAO extends JDBConnPool{
	public List<CommentsDTO> commList (Map<String,Object> map) {
		List<CommentsDTO> commLists = new Vector<CommentsDTO>();
		String query = "SELECT QNA_NUM,ME_NUM,WRITER,COMM_NUM,"
				+ " COMM_REGDATE,COMM_CONTENT,REGROUP,REGORDER,"
				+ " REGLEVEL,PASS FROM COMMENTS "
				+ " WHERE QNA_NUM=? ORDER BY REGROUP ASC, REGORDER";
		
		System.out.println("commList에 들어온 게시글번호 확인");
		System.out.println(map.get("qna_num"));
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1,map.get("qna_num").toString());
			rs=psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1));
				System.out.println(rs.getInt(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
				System.out.println(rs.getDate(5));
				System.out.println(rs.getString(6));
				System.out.println(rs.getInt(7));
				System.out.println(rs.getInt(8));
				System.out.println(rs.getInt(9));
				System.out.println(rs.getInt(10));
				CommentsDTO dto = new CommentsDTO();
				dto.setQna_num(rs.getInt("qna_num"));
				System.out.println(dto.getQna_num());
				dto.setMe_num(rs.getInt("me_num"));
				System.out.println(dto.getMe_num());
				dto.setWriter(rs.getString("writer"));
				System.out.println(dto.getWriter());
				dto.setComm_num(rs.getInt("comm_num"));
				System.out.println(dto.getComm_num());
				dto.setComm_regdate(rs.getDate("comm_regdate"));
				System.out.println(dto.getComm_regdate());
				dto.setContent(rs.getString("comm_content"));
				System.out.println(dto.getContent());
				dto.setRegroup(rs.getInt("regroup"));
				System.out.println(dto.getRegroup());
				dto.setRegorder(rs.getInt("regorder"));
				System.out.println(dto.getRegorder());
				dto.setReglevel(rs.getInt("reglevel"));
				System.out.println(dto.getReglevel());
				dto.setPass(rs.getInt("pass"));
				System.out.println(dto.getPass());
				commLists.add(dto);
			}
		}catch(Exception e) {
			System.out.println("댓글 읽기 중 에러");
			e.printStackTrace();
		}
		return commLists;	
	}
	
	public int insertComm(CommentsDTO dto) {
		int result =0;
		int comm_num =dto.getComm_num();
		
		String plus_comm_num_sql = "SELECT NVL(MAX(COMM_NUM),0)+1 FROM COMMENTS "; 
		String sql = "INSERT INTO COMMENTS VALUES(?,?,?,?,SYSDATE,?,?,?,?,?) ";
		String sql2= "UPDATE COMMENTS SET REGORDER = REGORDER +1 WHERE REGROUP = ? AND REGORDER > ?";
		
		try {
			if(comm_num!=0) {
				psmt = con.prepareStatement(sql2);
				psmt.setInt(1, dto.getRegroup());
				psmt.setInt(2, dto.getRegorder());
				psmt.executeUpdate();
				psmt.close();
				dto.setRegorder(dto.getRegorder()+1);
				dto.setReglevel(dto.getReglevel()+1);
			}
			// 현존하는 댓글 중 제일 높은 댓글번호에 1을 더해서 가져오기
			psmt = con.prepareStatement(plus_comm_num_sql);
			rs = psmt.executeQuery();
			rs.next();
			int number = rs.getInt(1);
			rs.close();
			psmt.close();
			
			//1부터 그룹 생성
			if(comm_num==0) {
				dto.setRegroup(number);
			}
			//
			psmt = con.prepareStatement(sql);
			psmt.setInt(1, dto.getQna_num());
			psmt.setInt(2, dto.getMe_num());
			psmt.setString(3, dto.getWriter());
			psmt.setInt(4, number);
			psmt.setString(5, dto.getContent());
			psmt.setInt(6, dto.getRegroup());
			psmt.setInt(7, dto.getRegorder());
			psmt.setInt(8, dto.getReglevel());
			psmt.setInt(9, dto.getPass());
			
			result = psmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int deleteComm(int comm_num) {
		int result = 0;
		try {
			String query = "DELETE FROM COMMENTS WHERE COMM_NUM=?";
			psmt = con.prepareStatement(query);
			psmt.setInt(1, comm_num);
			result = psmt.executeUpdate();
		}catch(Exception e) {
			System.out.println("댓글 삭제 중 에러");
			e.printStackTrace();
		}
		return result;
	}
	
}
