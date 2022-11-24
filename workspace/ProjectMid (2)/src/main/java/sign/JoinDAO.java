package sign;

import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

import common.JDBConnect;

public class JoinDAO extends JDBConnect {
   
   public JoinDAO() {
      super();
   }   
   
   public int insertWrite(JoinDTO dto) {
      int result=0;
      try {
         String query = "INSERT INTO MEMBERS "
                     +" VALUES("
                     +" ME_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?)";
         
         psmt = con.prepareStatement(query);
                  
         psmt.setString(1, dto.getME_ID());
         psmt.setString(2, dto.getME_PASS());
         psmt.setString(3, dto.getME_NAME());
         psmt.setString(4, dto.getME_BIRTH());
         psmt.setString(5, dto.getME_SEX());         
         psmt.setString(6, dto.getME_AGE());         
         psmt.setString(7, dto.getME_PHONE());         
         psmt.setString(8, dto.getME_EMAIL());         
         psmt.setString(9, dto.getME_KAKAO());         
         psmt.setString(10, dto.getRE_NUM());
         result = psmt.executeUpdate();      
         close();
         
      }      
      catch(Exception e) {
         System.out.println("게시물 입력 중 예외");
         e.printStackTrace();
      }
      return result;
   }   
   
   public int insertWrite2(JoinDTO dto) {
	      int result = 0;
	      
	      try {
	         String query ="INSERT INTO MEMINFOS(ME_NUM,IN_HEIGHT,IN_STYLE"
	               + ",IN_EDU,IN_RLG,IN_DRUNK,IN_SMOKE ,IN_CHAR"
	               + ",IN_MBTI,IN_HOBBY,IN_JOB,IN_HASPET,IN_OPIC"
	               + ",IN_NPIC,IN_OVOICE,IN_NVOICE,PE_NUM)" 
	               + " VALUES( "
	               + " (ME_SEQ.NEXTVAL)-1,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	         psmt = con.prepareStatement(query);
	      //세션으로 아디 불러와서 회원번호로 저장함
	                  
	         psmt.setString(1,dto.getIn_height());
	         psmt.setString(2,dto.getIn_style());
	         psmt.setString(3,dto.getIn_edu());
	         psmt.setString(4,dto.getIn_rlg());
	         psmt.setString(5,dto.getIn_drunk());
	         psmt.setString(6,dto.getIn_smoke());
	         psmt.setString(7,dto.getIn_char());
	         psmt.setString(8,dto.getIn_mbti());
	         psmt.setString(9,dto.getIn_hobby());
	         psmt.setString(10,dto.getIn_job());
	         psmt.setString(11,dto.getIn_haspet());
	         psmt.setString(12,dto.getIn_opic());
	         psmt.setString(13,dto.getIn_npic());
	         psmt.setString(14,dto.getIn_ovoice());
	         psmt.setString(15,dto.getIn_nvoice());
	         psmt.setString(16,dto.getPe_num());
//	         psmt.setInt(17,dto.getPe_num());
	         
	         result = psmt.executeUpdate();

	      } catch (Exception e) {
	         System.out.println("게시물 입력 중 에러");
	         e.printStackTrace();
	      }
	      return result;
	   }
      
   public int checkId(String id) {    
	      String sql="SELECT * FROM MEMBERS WHERE ME_ID=? ";
	       int idCheck = 0;	            
	       try {
	            psmt=con.prepareStatement(sql);
	            psmt.setString(1,id);
	            rs = psmt.executeQuery();
	            
	            System.out.println(id);
	            
	               if(rs.next()|| id.equals("") ) {
	                  idCheck = 0;  // 이미 존재하는 경우, 생성 불가능
	             } else {
	                idCheck = 1;  // 존재하지 않는 경우, 생성 가능
	             }
	          } catch (SQLException e) {
	             e.printStackTrace();
	          } finally {
	             close();
	          }	          
	          return idCheck;
	}

   public int checkPh(String userPh) {    
	      String sql="SELECT * FROM MEMBERS WHERE ME_PHONE=? ";
	       int phCheck = 0;	            
	       try {
	            psmt=con.prepareStatement(sql);
	            psmt.setString(1,userPh);
	            rs = psmt.executeQuery();
	            
	            System.out.println(userPh);
	            
	               if(rs.next()|| userPh.equals("") ) {
	                  phCheck = 0;  // 이미 존재하는 경우, 생성 불가능
	             } else {
	                phCheck = 1;  // 존재하지 않는 경우, 생성 가능
	             }
	          } catch (SQLException e) {
	             e.printStackTrace();
	          } finally {
	             close();
	          }	          
	          return phCheck;
	}
   
   public int checkEmail(String userEmail) {    
	      String sql="SELECT * FROM MEMBERS WHERE ME_EMAIL=? ";
	       int emailCheck = 0;	            
	       try {
	            psmt=con.prepareStatement(sql);
	            psmt.setString(1,userEmail);
	            rs = psmt.executeQuery();
	            
	            System.out.println(userEmail);
	            
	               if(rs.next()|| userEmail.equals("") ) {
	            	   emailCheck = 0;  // 이미 존재하는 경우, 생성 불가능
	             } else {
	            	 emailCheck = 1;  // 존재하지 않는 경우, 생성 가능
	             }
	          } catch (SQLException e) {
	             e.printStackTrace();
	          } finally {
	             close();
	          }	          
	          return emailCheck;
	   }
   public int checkKakao(String userKakao) {    
	      String sql="SELECT * FROM MEMBERS WHERE ME_KAKAO=? ";
	       int kakaoCheck = 0;	            
	       try {
	            psmt=con.prepareStatement(sql);
	            psmt.setString(1,userKakao);
	            rs = psmt.executeQuery();
	            
	            System.out.println(userKakao);
	            
	               if(rs.next()|| userKakao.equals("") ) {
	            	   kakaoCheck = 0;  // 이미 존재하는 경우, 생성 불가능
	             } else {
	            	 kakaoCheck = 1;  // 존재하지 않는 경우, 생성 가능
	             }
	          } catch (SQLException e) {
	             e.printStackTrace();
	          } finally {
	             close();
	          }	          
	          return kakaoCheck;
	   }
   
   public JoinDTO selectView(String ME_ID) {
		JoinDTO dto = new JoinDTO();
		String query = "SELECT * FROM MEMBERS M , MEMINFOS I WHERE M.ME_NUM = I.ME_NUM AND M.ME_NUM=?";
		//idx가 일치하는 모든 정보를 찾는 커리문
		try {
			psmt = con.prepareStatement(query);
			//statement객체는 실행시 sql명령어를 지정하여 여러 sql구문을 하나의 statement객체로 수행
			//psmt == prepareStatement 
			
			psmt.setString(1, ME_ID);
			//1번을 idx로 설정
			rs= psmt.executeQuery();
			//psmt의 쿼리문을 실행함.
			//rs == result set 
			if(rs.next()) {
			//SQL문을 통해 얻은 데이터에서 첫번째행에서 마지막 행까지를 추출할때나 행이 있는지 없는지 판단
			// ResultSet에 저장된 데이터 얻기
				System.out.println(rs.getString(8));
				System.out.println(rs.getString(9));
				System.out.println(rs.getString(10));
				System.out.println(rs.getString(11));
				System.out.println(rs.getString(12));							
				
				dto.setME_NUM(rs.getString(1));
				dto.setME_ID(rs.getString(2));
				//getString() -- 지정한 값을 문자열로 읽음
				dto.setME_PASS(rs.getString(3));
				dto.setME_NAME(rs.getString(4));
				dto.setME_BIRTH(rs.getString(5));
				dto.setME_SEX(rs.getString(6));
				dto.setME_AGE(rs.getString(7));
				dto.setME_PHONE(rs.getString(8));
				dto.setME_EMAIL(rs.getString(9));
				dto.setME_KAKAO(rs.getString(10));
				
			}
		}catch(Exception e) {
			System.out.println("회원정보 수정 중 예외");
			e.printStackTrace();
		}
		return dto;
	}
   	public int signOut(String me_num) {
   		int result =0;
   		try {
   			String query = "DELETE FROM MEMBERS WHERE ME_NUM=?";
   			psmt = con.prepareStatement(query);
   			psmt.setString(1, me_num);
   			result = psmt.executeUpdate();
   		}catch(Exception e) {
   			System.out.println("회원기본정보 삭제 중 에러");
   			e.printStackTrace();
   		}
   		return result;
   	}
   	
   	public int signOut2(String me_num) {
   		int result =0;
   		try {
   			String query = "DELETE FROM MEMINFOS WHERE ME_NUM=?";
   			psmt = con.prepareStatement(query);
   			psmt.setString(1, me_num);
   			result = psmt.executeUpdate();
   		}catch(Exception e) {
   			System.out.println("회원추가정보 삭제 중 에러");
   			e.printStackTrace();
   		}
   		return result;
   	}
   

	
}