package qna;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class QnasDAO extends JDBConnPool{
	public QnasDAO() {
		super();
	}

	public int selectCount(Map<String, Object> map) {
		int totalCount=0;
		String query = " SELECT COUNT(*) FROM QNAS ";
		
		if(map.get("searchStr") !=null) {
			query += " WHERE " +map.get("searchType")+" LIKE '%"
					+map.get("searchStr")+"%'";
		}
		
		try {
			stmt=con.createStatement();
			rs=stmt.executeQuery(query);
			rs.next();
			totalCount=rs.getInt(1);
			
		} catch(Exception e) {
			System.out.println("게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<QnasDTO> selectListPage(Map<String, Object> map) {
		List<QnasDTO> bl = new Vector<QnasDTO>();
		String query= " SELECT * FROM ( "
				+ " SELECT ROWNUM AS PNUM, S.* FROM ( "
				+ " SELECT * FROM QNAS ";
				
		if (map.get("searchStr") != null) {
			query += " WHERE " + map.get("searchType") + " Like '%" 
					+ map.get("searchStr") +"%'";
		}
		query += " ORDER BY QA_NUM DESC";
		query += " ) S"
				+" ) "
				+" WHERE PNUM BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				//System.out.println(rs.getString("me_num"));
				QnasDTO dto = new QnasDTO();
				dto.setNum(rs.getString("qa_num"));
				System.out.println(dto.getNum());
				dto.setName(rs.getString("qa_name"));
				System.out.println(dto.getName());
				dto.setContent(rs.getString("qa_content"));
				System.out.println(dto.getContent());
				dto.setOfile(rs.getString("qa_ofile"));
				System.out.println(dto.getOfile());
				dto.setNfile(rs.getString("qa_nfile"));
				System.out.println(dto.getNfile());
				dto.setMe_num(rs.getString("me_num"));
				System.out.println(dto.getMe_num());
				dto.setMe_name(rs.getString("me_name"));
				System.out.println(dto.getMe_name());
				dto.setWriter(rs.getString("qa_writer"));
				System.out.println(dto.getWriter());
				dto.setPostdate(rs.getDate("qa_postdate"));
				System.out.println(dto.getPostdate());
				dto.setPass(rs.getString("qa_pass"));
				System.out.println(dto.getPass());
				bl.add(dto);
			}

		} catch (Exception e) {
			System.out.println("게시물 목록 읽기중 에러");
			e.printStackTrace();
		}

		return bl;
	}

	public int insertWrite(QnasDTO dto) {
		int result =0;
		try {
			String query = " INSERT INTO QNAS ( "
					+ " QA_NUM, QA_NAME, QA_CONTENT, QA_OFILE, QA_NFILE, QA_WRITER, ME_NUM, ME_NAME, QA_PASS) "
					+ " VALUES ( "
					+ " QNA_SEQ.NEXTVAL, ?, ?, ?, ? ,?, ?, ?, ?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1,  dto.getName());
			psmt.setString(2,  dto.getContent());
			psmt.setString(3,  dto.getOfile());
			psmt.setString(4,  dto.getNfile());
			psmt.setString(5,  dto.getWriter());
			psmt.setString(6,  dto.getMe_num());
			psmt.setString(7,  dto.getMe_name());
			psmt.setString(8,  dto.getPass());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	public QnasDTO selectView(String num) {
		QnasDTO dto = new QnasDTO();
		String query = " SELECT * FROM QNAS WHERE QA_NUM=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setOfile(rs.getString(4));
				dto.setNfile(rs.getString(5));
				dto.setMe_num(rs.getString(6));
				dto.setPostdate(rs.getDate(7));
				dto.setPass(rs.getString(8));
				dto.setWriter(rs.getString(9));
				dto.setMe_name(rs.getString(10));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return dto;
	}

	public int updatePost(QnasDTO dto) {
		int result=0;
		try {
			String query = "UPDATE QNAS"
					+ " SET QA_NAME=?, QA_CONTENT=?, QA_OFILE=?, QA_NFILE=? "
					+ " WHERE QA_NUM=? and QA_PASS=? ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getNfile());
			psmt.setString(5, dto.getNum());
			psmt.setString(6, dto.getPass());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	public boolean confirmPassword(String pass, String num) {
		
		boolean isCorr = true;
		try {
			String sql = "SELECT COUNT(*) FROM QNAS WHERE QA_PASS=? AND QA_NUM=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, num);
			rs=psmt.executeQuery();
			rs.next();
			if(rs.getInt(1)==0) {
				isCorr = false;
			}
		} catch (Exception e) {
			isCorr = false;
			e.printStackTrace();
		}
		return isCorr;
	}

	public int deletePost(String num) {
		int result =0;
		try {
			String query = "DELETE FROM QNAS WHERE QA_NUM=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외");
			e.printStackTrace();
		}
		return result;
	}
	
}
