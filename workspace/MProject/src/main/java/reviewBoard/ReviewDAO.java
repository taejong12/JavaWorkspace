package reviewBoard;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import connectPool.ConnectPool;


public class ReviewDAO extends ConnectPool {

	public ReviewDAO () {
		super();
	}

	public int selectCount(Map<String, Object> map) {
		int totalCount=0;
		String query = " SELECT COUNT(*) FROM REVIEWS ";
		
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
	
	public List<ReviewDTO> selectListPage(Map<String, Object> map) {
		List<ReviewDTO> bl = new Vector<ReviewDTO>();
		String query= " SELECT * FROM ( "
				+ " SELECT ROWNUM AS PNUM, S.* FROM ( "
				+ " SELECT * FROM REVIEWS ";
				
		if (map.get("searchStr") != null) {
			query += " WHERE " + map.get("searchType") + " Like '%" 
					+ map.get("searchStr") +"%'";
		}
		query += " ORDER BY RV_NUM DESC";
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
				ReviewDTO dto = new ReviewDTO();
				dto.setNum(rs.getString("rv_num"));
				dto.setName(rs.getString("rv_name"));
				dto.setContent(rs.getString("rv_content"));
				dto.setStar(rs.getInt("rv_star"));
				dto.setOfile(rs.getString("rv_ofile"));
				dto.setNfile(rs.getString("rv_nfile"));
				dto.setMenum(rs.getString("me_num"));
				dto.setPostdate(rs.getDate("rv_postdate"));
				dto.setPass(rs.getString("rv_pass"));
				dto.setRV_POSTNAME(rs.getString("RV_POSTNAME"));
				bl.add(dto);
			}

		} catch (Exception e) {
			System.out.println("게시물 목록 읽기중 에러");
			e.printStackTrace();
		}

		return bl;
	}

	public int insertWrite(ReviewDTO dto) {
		int result =0;
		try {
			String query = " INSERT INTO REVIEWS ( "
					+ " RV_NUM, RV_NAME, RV_CONTENT, RV_STAR, RV_OFILE, RV_NFILE, RV_PASS, ME_NUM, RV_POSTNAME) "
					+ " VALUES ( "
					+ " REV_SEQ.NEXTVAL, ?, ?, ?, ? ,? , ?, ?, ?) ";
			psmt = con.prepareStatement(query);
//			System.out.println(dto.getName());
//			System.out.println(dto.getContent());
//			System.out.println(dto.getStar());
//			System.out.println(dto.getOfile());
//			System.out.println(dto.getNfile());
//			System.out.println(dto.getMenum());
//			System.out.println(dto.getPass());
			psmt.setString(1,  dto.getName());
			psmt.setString(2,  dto.getContent());
			psmt.setInt(3,  dto.getStar());
			psmt.setString(4,  dto.getOfile());
			psmt.setString(5,  dto.getNfile());
			psmt.setString(6,  dto.getPass());
			psmt.setString(7, dto.getMenum());
			psmt.setString(8, dto.getRV_POSTNAME());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	public ReviewDTO selectView(String num) {
		ReviewDTO dto = new ReviewDTO();
		String query = " SELECT * FROM REVIEWS WHERE RV_NUM=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, num);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setContent(rs.getString(3));
				dto.setStar(rs.getInt(4));
				dto.setOfile(rs.getString(5));
				dto.setNfile(rs.getString(6));
				dto.setMenum(rs.getString(7));
				dto.setPostdate(rs.getDate(8));
				dto.setPass(rs.getString(9));
				dto.setRV_POSTNAME(rs.getString(10));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return dto;
	}

	public int updatePost(ReviewDTO dto) {
		int result=0;
		try {
			String query = "UPDATE REVIEWS"
					+ " SET RV_NAME=?, RV_CONTENT=?, RV_OFILE=?, RV_NFILE=?, RV_STAR=? "
					+ " WHERE RV_NUM=? and RV_PASS=? ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getContent());
			psmt.setString(3, dto.getOfile());
			psmt.setString(4, dto.getNfile());
			psmt.setInt(5, dto.getStar());
			psmt.setString(6, dto.getNum());
			psmt.setString(7, dto.getPass());
			
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
			String sql = "SELECT COUNT(*) FROM REVIEWS WHERE RV_PASS=? AND RV_NUM=?";
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
			String query = "DELETE FROM REVIEWS WHERE RV_NUM=?";
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

	
	public List<ReviewDTO> reviewMain() {
		List<ReviewDTO> bl = new Vector<ReviewDTO>();
		String query= " SELECT ROWNUM, S.*  "
				+ " FROM ( SELECT R.* "
				+ "			FROM REVIEWS R "
				+ "			WHERE R.RV_STAR>3"
				+ " 		ORDER BY R.RV_STAR DESC, RV_POSTDATE DESC) S"
				+ " WHERE ROWNUM<4";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				ReviewDTO dto = new ReviewDTO();
				dto.setNum(rs.getString("rv_num"));
				dto.setName(rs.getString("rv_name"));
				dto.setContent(rs.getString("rv_content"));
				dto.setStar(rs.getInt("rv_star"));
				dto.setOfile(rs.getString("rv_ofile"));
				dto.setNfile(rs.getString("rv_nfile"));
				dto.setMenum(rs.getString("me_num"));
				dto.setPostdate(rs.getDate("rv_postdate"));
				dto.setPass(rs.getString("rv_pass"));
				dto.setRV_POSTNAME(rs.getString("RV_POSTNAME"));
				bl.add(dto);
			}

		} catch (Exception e) {
			System.out.println("홈페이지 리뷰 중 에러");
			e.printStackTrace();
		}

		return bl;
	}
	

	
	
}
