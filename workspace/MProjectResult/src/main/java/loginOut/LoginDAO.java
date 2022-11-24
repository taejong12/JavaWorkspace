package loginOut;

import common.JDBConnect;

public class LoginDAO extends JDBConnect{
	public LoginDTO getLoginDTO(String uid,String upw) {
	      LoginDTO dto=new LoginDTO();
	      String query= "SELECT * FROM MEMBERS "
	    		  	+" WHERE ME_ID=? AND ME_PASS=?";
	      
	      try {
	         psmt=con.prepareStatement(query);
	         psmt.setString(1,uid);
	         psmt.setString(2,upw);
	         rs = psmt.executeQuery();
	         
	         if(rs.next()) {
	        	 dto.setMe_id(rs.getString("me_id"));
	        	 dto.setMe_num(rs.getString("me_num"));
	        	 dto.setMe_name(rs.getString("me_name"));
	        	 dto.setMe_kakao(rs.getString("me_kakao"));
	        	 dto.setMe_phone(rs.getString("me_phone"));
	        	 dto.setMe_email(rs.getString("me_email"));
	        	 dto.setMe_pass(rs.getString("me_pass"));
	         }
	         
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	      
	      return dto;
	   }
}
