package loginOut;

import javax.servlet.http.HttpSession;

import common.JDBConnect;
import sign.JoinDTO;

public class SecChartChkDAO extends JDBConnect{
	public SecChartChkDTO  SecChartChk(String me_num) {
		SecChartChkDTO dto = new SecChartChkDTO();
	      String query= "SELECT * FROM MEMINFOS "
	    		  	+" WHERE ME_NUM=?";
	      try {
	         psmt=con.prepareStatement(query);
	         psmt.setString(1,me_num);
	         rs = psmt.executeQuery();
	         
	         if(rs.next()) {
	        	 dto.setMe_num(rs.getString("me_num"));
	        	 dto.setIn_height(rs.getString("in_height"));
	        	 dto.setIn_style(rs.getString("in_style"));
	        	 dto.setIn_edu(rs.getString("in_edu"));
	        	 dto.setIn_rlg(rs.getString("in_rlg"));
	        	 dto.setIn_mbti(rs.getString("in_mbti"));
	        	 dto.setIn_drunk(rs.getString("in_drunk"));
	        	 dto.setIn_smoke(rs.getString("in_smoke"));
	        	 dto.setIn_char(rs.getString("in_char"));
	        	 dto.setIn_hobby(rs.getString("in_hobby"));
	        	 dto.setIn_job(rs.getString("in_job"));
	        	 dto.setIn_haspet(rs.getString("in_haspet"));
	        	 dto.setIn_opic(rs.getString("in_opic"));
	        	 dto.setIn_npic(rs.getString("in_npic"));
	        	 dto.setIn_ovoice(rs.getString("in_ovoice"));
	        	 dto.setIn_nvoice(rs.getString("in_nvoice"));
	        	 dto.setPe_num(rs.getString("pe_num"));   
	         }
	         
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      
	      return dto;
	   }
	
	public int insertWrite2(SecChartChkDTO dto) {
	      int result = 0;
	      
	      try {
	         String query ="INSERT INTO MEMINFOS(ME_NUM,IN_HEIGHT,IN_STYLE"
	               + ",IN_EDU,IN_RLG,IN_DRUNK,IN_SMOKE ,IN_CHAR"
	               + ",IN_MBTI,IN_HOBBY,IN_JOB,IN_HASPET,IN_OPIC"
	               + ",IN_NPIC,IN_OVOICE,IN_NVOICE,PE_NUM)" 
	               + " VALUES( "
	               + " ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         psmt = con.prepareStatement(query);
	      //세션으로 아디 불러와서 회원번호로 저장함
	         psmt.setString(1,dto.getMe_num());
	         psmt.setString(2,dto.getIn_height());
	         psmt.setString(3,dto.getIn_style());
	         psmt.setString(4,dto.getIn_edu());
	         psmt.setString(5,dto.getIn_rlg());
	         psmt.setString(6,dto.getIn_drunk());
	         psmt.setString(7,dto.getIn_smoke());
	         psmt.setString(8,dto.getIn_char());
	         psmt.setString(9,dto.getIn_mbti());
	         psmt.setString(10,dto.getIn_hobby());
	         psmt.setString(11,dto.getIn_job());
	         psmt.setString(12,dto.getIn_haspet());
	         psmt.setString(13,dto.getIn_opic());
	         psmt.setString(14,dto.getIn_npic());
	         psmt.setString(15,dto.getIn_ovoice());
	         psmt.setString(16,dto.getIn_nvoice());
	         psmt.setString(17,dto.getPe_num());
//	         psmt.setInt(17,dto.getPe_num());
	         
	         result = psmt.executeUpdate();

	      } catch (Exception e) {
	         System.out.println("게시물 입력 중 에러");
	         e.printStackTrace();
	      }
	      return result;
	   }
}
