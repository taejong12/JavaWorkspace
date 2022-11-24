package Loginout;

import connectPool.ConnectPool;

public class LoginDAO extends ConnectPool{
	public LoginDTO getLoginDTO(String uid,String upw) {
      	LoginDTO dto=new LoginDTO();
      	String query="SELECT * FROM MEMBERS WHERE me_id=? AND me_pass=?";
	      
      	try {
      		psmt=con.prepareStatement(query);
      		psmt.setString(1,uid);
      		psmt.setString(2,upw);
      		rs = psmt.executeQuery();
      		
      		if(rs.next()) {
      			dto.setMe_id(rs.getString("me_id"));
      			dto.setMe_pass(rs.getString("me_pass"));
      			dto.setMe_name(rs.getString("me_name"));
      			dto.setMe_num(rs.getString("me_num"));
      		}
	         
      	}catch(Exception e) {
      		e.printStackTrace();
      	}
      	
      	return dto;
	}
}
