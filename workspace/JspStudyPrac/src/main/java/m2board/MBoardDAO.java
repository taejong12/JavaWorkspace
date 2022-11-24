package m2board;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import board.BoardDTO;
import common.JDBConnPool;

public class MBoardDAO extends JDBConnPool{
	
	// 커넥트풀을 통해서 생성자가 만들어진다
	public MBoardDAO () {
		super();
	}

	// 진행하면서 하나씩 늘려나간다
	// ListController를 기반으로 DAO를 추가적으로 생성
	
	// 하나는 전체게시물 갯수를 세는 것
	// 검색어를 통해서
	// 전체갯수를 세기 위해서 쿼리문을 날려줘야 한다
	// 전달받은 조건도 웨얼절로 추가
	// 넘겨받는 파라미터 값이 서치타입과 서치str
	// 여기서 받는것도 map에서 받는다
	// 컬럼 영역에서 검색어를 통해서 웨어절로 추가
	// 트루면 추가 아니면 추가안함
	
	public int selectCount(Map<String, Object> map) {
		int totalCount=0;
		String query = " SELECT COUNT(*) FROM FILEBOARD ";
		
		if(map.get("searchStr") != null) {
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
	
	//	ListController를 통해서 뷰에서 게시물 목록을 출력해준다
	public List<MBoardDTO> selectListPage(Map<String, Object> map) {
		List<MBoardDTO> bl = new Vector<MBoardDTO>();
		String query= " SELECT * FROM ( "
				+ " SELECT ROWNUM AS PNUM, S.* FROM ( "
				+ " SELECT * FROM FILEBOARD ";
				
		if (map.get("searchStr") != null) {
			query += " WHERE " + map.get("searchType") + " Like '%" 
					+ map.get("searchStr") + "%'";
		}
		query += " ORDER BY IDX DESC";
		query += " ) S"
				+" ) "
				+" WHERE PNUM BETWEEN ? AND ?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, map.get("start").toString());
			psmt.setString(2, map.get("end").toString());
			rs = psmt.executeQuery();
			while (rs.next()) {
				MBoardDTO dto = new MBoardDTO();
				dto.setIdx(rs.getString("idx"));
				dto.setName(rs.getString("name"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPostdate(rs.getDate("postdate"));
				dto.setOfile(rs.getString("ofile"));
				dto.setNfile(rs.getString("nfile"));
				dto.setDowncount(rs.getInt("downcount"));
				dto.setVisitcount(rs.getInt("visitcount"));
				dto.setPass(rs.getString("pass"));
				bl.add(dto);
			}

		} catch (Exception e) {
			System.out.println("게시물 목록 읽기중 에러");
			e.printStackTrace();
		}

		return bl;
	}

	
	public int insertWrite(MBoardDTO dto) {
		int result = 0;
		try {
			String query = " INSERT INTO FILEBOARD ( "
					+ " idx, name, title, content, ofile, nfile, pass) "
					+ " VALUES ( "
					+ " seq_board_num.NEXTVAL, ?, ?, ?, ? ,? ,?) ";
			psmt = con.prepareStatement(query);
			psmt.setString(1,  dto.getName());
			psmt.setString(2,  dto.getTitle());
			psmt.setString(3,  dto.getContent());
			psmt.setString(4,  dto.getOfile());
			psmt.setString(5,  dto.getNfile());
			psmt.setString(6,  dto.getPass());
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 입력 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	public void updateVisiteCount(String idx) {
		String query = " UPDATE fileboard SET "
				+ " visitcount=visitcount+1 "
				+ " WHERE idx=? ";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			psmt.executeUpdate();
		}
		
		catch (Exception e) {
			System.out.println("게시물 조회수 증가 중 예외");
			e.printStackTrace();
		}
	}

	public MBoardDTO selectView(String idx) {
		MBoardDTO dto = new MBoardDTO();
		String query = " SELECT * FROM fileboard WHERE idx=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setContent(rs.getString(4));
				dto.setPostdate(rs.getDate(5));
				dto.setOfile(rs.getString(6));
				dto.setNfile(rs.getString(7));
				dto.setDowncount(rs.getInt(8));
				dto.setVisitcount(rs.getInt(9));
				dto.setPass(rs.getString(10));
			}
		} catch (Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return dto;
	}

	  //다운로드 횟수를 1 증가시킵니다.
	   public void downCountPlus(String idx) {
	      String sql = "UPDATE fileboard SET "
	            + " downcount = downcount+1 "
	            + " WHERE idx=? ";
	      try { 
	         psmt = con.prepareStatement(sql);
	         psmt.setString(1, idx);
	         psmt.executeUpdate();
	      }
	      catch(Exception e) {}
	   }

	public int getDownCount(String idx) {
		int dcount=0;
		String sql = "SELECT downcount FROM fileboard "
				+ " WHERE idx=? ";
		try {
			psmt = con.prepareStatement(sql);
			psmt.setString(1, idx);
			rs=psmt.executeQuery();
			rs.next();
			dcount = rs.getInt(1);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dcount;
	}

	public boolean confirmPassword(String pass, String idx) {
		boolean isCorr = true;
		try {
			String sql = "SELECT COUNT(*) FROM fileboard WHERE pass=? AND idx=?";
			psmt = con.prepareStatement(sql);
			psmt.setString(1, pass);
			psmt.setString(2, idx);
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

	public int deletePost(String idx) {
		int result =0;
		try {
			String query = "DELETE FROM fileboard WHERE idx=?";
			psmt = con.prepareStatement(query);
			psmt.setString(1, idx);
			result = psmt.executeUpdate();
		}
		catch (Exception e) {
			System.out.println("게시물 삭제 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	public int updatePost(MBoardDTO dto) {
		int result =0;
		try {
			String query = "UPDATE fileboard"
					+ " SET title=?, name=?, content=?, ofile=?, nfile=? "
					+ " WHERE idx=? and pass=? ";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getTitle());
			psmt.setString(2, dto.getName());
			psmt.setString(3, dto.getContent());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getNfile());
			psmt.setString(6, dto.getIdx());
			psmt.setString(7, dto.getPass());
			
			result = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("게시물 수정 중 예외");
			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
