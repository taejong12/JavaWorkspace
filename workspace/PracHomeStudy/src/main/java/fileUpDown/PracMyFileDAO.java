package fileUpDown;

import java.util.List;
import java.util.Vector;

import common.JDBConnPool;

public class PracMyFileDAO extends JDBConnPool {
	
	public int insertFile(PracMyFileDTO dto) {
		int applyResult = 0;
		try {
			String query = " INSERT INTO PRACMYFILE ( "
					+ " id, name, title, cate, ofile, nfile) "
					+ " VALUES ( "
					+ " seq_board_num.nextval, ?, ?, ?, ?, ?)";
			
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getNfile());
			
			applyResult = psmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
			e.printStackTrace();
		}
		return applyResult;
	}
	
	
	public List<PracMyFileDTO> myFileList() {
		List<PracMyFileDTO> fileList = new Vector<>();
		
		String query = "SELECT * FROM PRACMYFILE ORDER BY id DESC";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			while(rs.next()) {
				PracMyFileDTO dto = new PracMyFileDTO();
				dto.setId(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setNfile(rs.getString(6));
				dto.setRegdate(rs.getString(7));
				
				fileList.add(dto);
			}
		} catch (Exception e) {
			System.out.println("SELECT 시 예외 발생");
			e.printStackTrace();
		}
		return fileList;
	}
	
	
	
	
	
	
}
