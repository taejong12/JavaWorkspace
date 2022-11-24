package infoEdit;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import common.JDBConnect;
import sign.JoinDTO;
//JoinDTO  와 같이 연계.
//=======================================
public class ReviseDAO extends JDBConnect {
     
public JoinDTO selectView(String me_num) {
		JoinDTO dto = new JoinDTO();
		String query = "   SELECT * FROM(SELECT M.*, I.IN_HEIGHT, I.IN_STYLE, I.IN_EDU, I.IN_RLG, I.IN_DRUNK, I.IN_SMOKE, I.IN_CHAR, "
				+ "                I.IN_MBTI, I.IN_HOBBY, I.IN_JOB, I.IN_HASPET, I.IN_OPIC, I.IN_NPIC, I.IN_OVOICE, I.IN_NVOICE, I.PE_NUM "
				+ "                FROM MEMBERS M, MEMINFOS I WHERE M.ME_NUM = I.ME_NUM) WHERE ME_NUM=?";
		//idx가 일치하는 모든 정보를 찾는 커리문
		try {
			psmt = con.prepareStatement(query);
			//statement객체는 실행시 sql명령어를 지정하여 여러 sql구문을 하나의 statement객체로 수행
			//psmt == prepareStatement 
			
			psmt.setString(1, me_num);
			//1번을 idx로 설정
			rs= psmt.executeQuery();
			//psmt의 쿼리문을 실행함.
			//rs == result set 
			if(rs.next()) {
			//SQL문을 통해 얻은 데이터에서 첫번째행에서 마지막 행까지를 추출할때나 행이 있는지 없는지 판단
			// ResultSet에 저장된 데이터 얻기
				
				dto.setME_NUM(me_num);
				dto.setME_ID(rs.getString(2));
				System.out.println(dto.getME_ID());
				
				dto.setME_PASS(rs.getString(3));
				dto.setME_NAME(rs.getString(4));
				dto.setME_BIRTH(rs.getString(5));
				dto.setME_SEX(rs.getString(6));
				dto.setME_AGE(rs.getString(7));
				dto.setME_PHONE(rs.getString(8));
				dto.setME_EMAIL(rs.getString(9));
				dto.setME_KAKAO(rs.getString(10));
				dto.setRE_NUM(rs.getString(11));
				
				dto.setIn_height(rs.getString(12));
				dto.setIn_style(rs.getString(13));
				dto.setIn_edu(rs.getString(14));
				dto.setIn_rlg(rs.getString(15));
				

				dto.setIn_drunk(rs.getString(16));
				dto.setIn_smoke(rs.getString(17));
				dto.setIn_char(rs.getString(18));
				dto.setIn_mbti(rs.getString(19));
				dto.setIn_hobby(rs.getString(20));
				dto.setIn_job(rs.getString(21));
				dto.setIn_haspet(rs.getString(22));

				dto.setIn_opic(rs.getString(23));
				dto.setIn_npic(rs.getString(24));			
				
				dto.setIn_ovoice(rs.getString(25));
				dto.setIn_nvoice(rs.getString(26));
				
				dto.setPe_num(rs.getString(27));				
				
				System.out.println(dto.getIn_opic());
				System.out.println(dto.getIn_opic());
				System.out.println("==============");
				System.out.println(dto.getIn_npic());
				System.out.println(dto.getIn_npic());
				System.out.println(dto.getIn_npic());
				System.out.println("==============");
				System.out.println(dto.getIn_nvoice());
				System.out.println(dto.getIn_nvoice());
				System.out.println(dto.getIn_nvoice());
				System.out.println("==============");
				System.out.println(dto.getIn_ovoice());
				System.out.println(dto.getIn_ovoice());
				System.out.println(dto.getIn_ovoice());

				
			}
		}catch(Exception e) {
			System.out.println("회원정보 수정 중 예외");
			e.printStackTrace();
		}
		return dto;
	}


public int UpdateRevise(JoinDTO dto) {
    int res = 0;
    try {
       String query = " UPDATE MEMBERS  "
       			+ " SET  ME_PASS=?, ME_NAME=?, ME_BIRTH=?, ME_SEX=?, ME_AGE =?, ME_KAKAO=?, RE_NUM=?"    		   
       			+ "  WHERE ME_NUM=?";
       	
       psmt = con.prepareStatement(query);
       //MEMBERS         
       psmt.setString(1, dto.getME_PASS());         
       psmt.setString(2, dto.getME_NAME());
       psmt.setString(3, dto.getME_BIRTH());
       psmt.setString(4, dto.getME_SEX());
       psmt.setInt(5, Integer.parseInt(dto.getME_AGE())); 
       psmt.setString(6, dto.getME_KAKAO());
       psmt.setInt(7, Integer.parseInt(dto.getRE_NUM()));     
       psmt.setString(8, dto.getME_NUM());
       
       System.out.println(dto.getME_PASS());
       
       System.out.println(dto.getME_NAME());
       
       System.out.println(dto.getME_BIRTH());
       
       System.out.println(dto.getME_SEX());
       
       System.out.println(dto.getME_AGE());
       
       System.out.println(dto.getME_KAKAO());
       
       System.out.println(dto.getRE_NUM());
       
       System.out.println(dto.getME_NUM());
       
       res = psmt.executeUpdate();    
       
       
    }      
    catch(Exception e) {
       System.out.println("게시물 수정 중 예외");
       e.printStackTrace();
    }
    return res;
 }



public int UpdateRevise2(JoinDTO dto) {
    int res = 0;
    try {
       String query = "UPDATE MEMINFOS "
       		+ "	SET"
       		+ " IN_HEIGHT=?, IN_STYLE=?, IN_EDU=?, IN_RLG=?, IN_DRUNK=?, IN_SMOKE=? , IN_CHAR=?, IN_MBTI=?, IN_HOBBY=?, "
       		+ "	IN_JOB=?, IN_HASPET=?, IN_OPIC=?, IN_NPIC=?, IN_OVOICE=?, IN_NVOICE=?, PE_NUM=?"
       		+ " WHERE ME_NUM=?";       
       psmt = con.prepareStatement(query);       
       //MEMINFOS
       psmt.setString(1, dto.getIn_height());
       psmt.setString(2, dto.getIn_style());
       psmt.setString(3, dto.getIn_edu());
       psmt.setString(4, dto.getIn_rlg());
       psmt.setString(5, dto.getIn_drunk());
       psmt.setString(6, dto.getIn_smoke());
       psmt.setString(7, dto.getIn_char());       
       psmt.setString(8, dto.getIn_mbti());
       psmt.setString(9, dto.getIn_hobby());       
       psmt.setString(10, dto.getIn_job());
       psmt.setString(11, dto.getIn_haspet());
       psmt.setString(12, dto.getIn_opic());
       psmt.setString(13, dto.getIn_npic());
       psmt.setString(14, dto.getIn_ovoice());
       psmt.setString(15, dto.getIn_nvoice());
       psmt.setString(16, dto.getPe_num());          
       psmt.setString(17, dto.getME_NUM());
       
       res = psmt.executeUpdate();    
       
       
    }      
    catch(Exception e) {
       System.out.println("게시물 수정 중 예외");
       e.printStackTrace();
    }
    return res;
 }



public JoinDTO UpdatePRevise(JoinDTO dto) {
	
	try {
		String query = "UPDATE MEMBERS "       		
				+" SET ME_PHONE=?"
				+" WHERE ME_NUM=? ";
		
		psmt = con.prepareStatement(query);
		
		
		psmt.setString(1, dto.getME_PHONE());
		psmt.setString(2, dto.getME_NUM());
		
		rs = psmt.executeQuery();    
		close();
		System.out.println(dto.getME_PHONE());
		System.out.println(dto.getME_PHONE());
		System.out.println(dto.getME_PHONE());
		System.out.println(dto.getME_NUM());
		System.out.println(dto.getME_NUM());
		System.out.println(dto.getME_NUM());
	}      
	catch(Exception e) {
		System.out.println("게시물 입력 중 예외");
		e.printStackTrace();
	}
	return dto;
}

public JoinDTO UpdateERevise(JoinDTO dto) {
	
	try {
		String query = "UPDATE MEMBERS "       		
				+" SET ME_EMAIL=?"
				+" WHERE ME_NUM=? ";
		
		psmt = con.prepareStatement(query);
		System.out.println(dto.getME_EMAIL());
		System.out.println(dto.getME_EMAIL());
		System.out.println(dto.getME_EMAIL());
		System.out.println(dto.getME_EMAIL());
		
		psmt.setString(1, dto.getME_EMAIL());
		psmt.setString(2, dto.getME_NUM());
		
		rs = psmt.executeQuery();    
		close();
		
	}      
	catch(Exception e) {
		System.out.println("게시물 입력 중 예외");
		e.printStackTrace();
	}
	return dto;
}

//public JoinDTO UpdateRevise(JoinDTO dto) {
//    
//    try {
//       String query = "UPDATE MEMBERS "       		
//                   +" SET ME_PASS=?,ME_NAME=?,ME_BIRTH=?,ME_SEX=?,ME_AGE=?,RE_NUM=? "
//                   +" WHERE ME_NUM=? ";
//       
//       psmt = con.prepareStatement(query);
//                
//       psmt.setString(1, dto.getME_PASS());         
//       psmt.setString(2, dto.getME_NAME());
//       psmt.setString(3, dto.getME_BIRTH());
//       psmt.setString(4, dto.getME_SEX());
//       psmt.setString(5, dto.getME_AGE()); 
//       psmt.setString(6, dto.getRE_NUM());
//       psmt.setString(7, dto.getME_NUM());
//       
//       rs = psmt.executeQuery();    
//       close();
//       
//    }      
//    catch(Exception e) {
//       System.out.println("게시물 입력 중 예외");
//       e.printStackTrace();
//    }
//    return dto;
// }

//public int UpdateWrite2(JoinDTO dto,String me_id) {
//	
//	int result=0;
//    try {
//       String query = "UPDATE MEMBERS "       		
//                   +" SET ME_PHONE=? "
//                   +" WHERE ME_ID=? ";
//       psmt = con.prepareStatement(query);
//                
//       psmt.setString(1,dto.getME_PHONE());         
//       psmt.setString(2,me_id);         
//                
//       
//       result = psmt.executeUpdate();      
//  
//       close();
//       
//    }      
//    catch(Exception e) {
//       System.out.println("게시물 입력 중 예외");
//       e.printStackTrace();
//    }
//  
//    return result;
// }
}