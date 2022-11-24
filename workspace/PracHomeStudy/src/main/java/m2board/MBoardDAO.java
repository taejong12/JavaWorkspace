package m2board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import common.JDBConnPool;

public class MBoardDAO extends JDBConnPool {
	
	public MBoardDAO () {
		super();
	}
	
	public int selectCount(Map<String, Object> map) {
		int totalCount =0;
		String query = "SELECT COUNT(*) FROM FILEBOARD1";
		
		if(map.get("searchStr") != null) {
			query += " WHERE " + map.get("searchType")+"Like '%"
					+map.get("searchStr")+"%'";
		}
		
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			rs.next();
			totalCount = rs.getInt(1);
		
		} catch (Exception e) {
			System.out.println("게시물 카운트 중 에러");
			e.printStackTrace();
		}
		return totalCount;
	}
	
	public List<MBoardDTO> selectListPage(Map<String, Object> map) {
		List<MBoardDTO> bl = new Vector<MBoardDTO>();
		String query = "SELECT * FROM ( "
				+ " SELECT ROWNUM AS PNUM, S.* FROM ( "
				+ " SELECT * FROM FILEBOARD1 ";
		
		if(map.get("searchStr") != null) {
			query += " WHERE " +map.get("searchType")+ "Like '%"
					+map.get("searchStr")+"%'";
		}
		
		query += " ORDER BY IDX DESC";
		query += " ) S "
				+ " ) "
				+ " WHERE PNUM BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				MBoardDTO dto = new MBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getString("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setDowncount(rs.getString("downcount"));
				dto.setVisitcount(rs.getString("visitcount"));
				dto.setPass(rs.getString("pass"));
				bl.add(dto);
			}
		}  catch (Exception e) {
			System.out.println("게시물 목록 읽기중 에러");
			e.printStackTrace();
		}
		
		return bl;
	}
	
}

