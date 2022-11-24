package matching;

import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import common.JDBConnPool;

public class MatchingDAO extends JDBConnPool{
	public List<MatchingDTO> selectList(Map<String, Object> map){
		List<MatchingDTO> boardLists = new Vector<MatchingDTO>();
		String query = "SELECT * FROM(SELECT M.*, I.IN_HEIGHT, I.IN_STYLE, I.IN_EDU, I.IN_RLG, I.IN_DRUNK, I.IN_SMOKE, I.IN_CHAR, I.IN_MBTI, I.IN_HOBBY, I.IN_JOB, I.IN_HASPET, I.IN_OPIC, I.IN_NPIC, I.IN_OVOICE, I.IN_NVOICE, I.PE_NUM , R.RE_NAME FROM MEMBERS M, MEMINFOS I, REGIONS R WHERE M.ME_NUM = I.ME_NUM AND M.RE_NUM = R.RE_NUM)";
		
		System.out.println("dao selectlist에 들어온 변수들 찍기");
		System.out.println(map.get("sex"));
		System.out.println(map.get("age"));
		System.out.println(map.get("minage"));
		System.out.println(map.get("maxage"));
		System.out.println(map.get("height"));
		System.out.println(map.get("minHeight"));
		System.out.println(map.get("maxHeight"));
		System.out.println(map.get("style"));
		System.out.println(map.get("edu"));
		System.out.println(map.get("rlg"));
		System.out.println(map.get("drunk"));
		System.out.println(map.get("smoke"));
		System.out.println(map.get("exin"));
		System.out.println(map.get("mbti"));
		System.out.println(map.get("my_mbti"));
		System.out.println(map.get("job"));
		System.out.println(map.get("pet"));
	
		//성별
		if(map.get("sex")==null) {
			query+=" WHERE ME_SEX IN('남','여')";
		}
		
		if(map.get("sex")!=null) {
			query+=" WHERE ME_SEX="+"'"+map.get("sex")+"' ";
		}
		//나이
		if(map.get("age")!=null) {
			query+=" AND ME_AGE >"+ map.get("age");
		}else if(map.get("age")==null && map.get("minage")!=null && map.get("maxage")!=null) {
			query+=" AND ME_AGE BETWEEN "+map.get("minage")+" AND "+map.get("maxage");
		}
		
		//키
		if(map.get("height")==null && map.get("minHeight")!=null && map.get("maxHeight")!=null) {
			query += " AND IN_HEIGHT BETWEEN "+map.get("minHeight")+" AND "+map.get("maxHeight");
		}
		//체형
		if(map.get("style")!=null) {
			query += " AND IN_STYLE="+"'"+map.get("style")+"'";
		}
		//최종학력
		if(map.get("edu")!=null) {
			query += " AND IN_EDU="+"'"+map.get("edu")+"'";
		}
		//종교
		if(map.get("rlg")!=null) {
			query += " AND IN_RLG="+"'"+map.get("rlg")+"'";
		}
		//음주
		if(map.get("drunk")!=null) {
			query += " AND IN_DRUNK="+"'"+map.get("drunk")+"'";
		}
		//흡연
		if(map.get("smoke")!=null) {
			query += " AND IN_SMOKE="+"'"+map.get("smoke")+"'";
		}
		//외향/내향
		if(map.get("exin")!=null) {
			query += " AND IN_CHAR="+"'"+map.get("exin")+"'";
		}
		//MBTI
		if(map.get("mbti")!=null && map.get("my_mbti")!=null) {
			switch((String)map.get("my_mbti")) {
				case "ISTJ":
					query += " AND IN_MBTI IN('INTP','ENFJ','ISFP','INFP','ESTP','ESFP','ISTJ','ISFJ')";
					break;
				case "ISTP":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','ISTP','INTP','ESFP','ENTP','ENFP','INFJ')";
					break;
				case "ISFJ":
					query += " AND IN_MBTI IN('ENTJ','ISTP','INTP','INFP','ESTP','ESFP','ISTJ','ISFJ')";
					break;
				case "ISFP":
					query += " AND IN_MBTI IN('ESFJ','ENFJ','ISFP','INFP','ISTJ','ENTP','INTJ','INFJ')";
					break;
				case "INTJ":
					query += " AND IN_MBTI IN('ISTP','ESFJ','ISFP','INFP','ENTP','ENFP','INTJ','INFJ')";
					break;
				case "INTP":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','ISTP','INTP','ESFP','ISTJ','ISFJ','INTJ')";
					break;
				case "INFJ":
					query += " AND IN_MBTI IN('ESTJ','ISTP','INTP','ISFP','ENTP','ENFP','INTJ','INFJ')";
					break;
				case "INFP":
					query += " AND IN_MBTI IN('ESFJ','ENFJ','ISFP','INFP','ESTP','ISTJ','ISFJ','INTJ')";
					break;
				case "ESTJ":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','ISTP','INTP','ESFP','ENTP','ENFP','INFJ')";
					break;
				case "ESTP":
					query += " AND IN_MBTI IN('ENTJ','ESFJ','ENFJ','INFP','ESTP','ESFP','ISTJ','ISFJ')";
					break;
				case "ESFJ":
					query += " AND IN_MBTI IN('ESFJ','ENFJ','ISFP','INFP','ESTP','ENTP','ENFP','INTJ')";
					break;
				case "ESFP":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','INTP','ENFJ','ESTP','ESFP','ISFJ','ISTJ')";
					break;
				case "ENTJ":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','ISTP','INTP','ESTP','ESFP','ISFJ','ENFP')";
					break;
				case "ENTP":
					query += " AND IN_MBTI IN('ESTJ','ESFJ','ENFJ','ISFP','ENTP','ENFP','INTJ','INFJ')";
					break;
				case "ENFJ":
					query += " AND IN_MBTI IN('ESFJ','ENFJ','ISFP','INFP','ESTP','ESFP','ISTJ','ENTP')";
					break;
				case "ENFP":
					query += " AND IN_MBTI IN('ESTJ','ENTJ','ISTP','ESFJ','ENTP','ENFP','INTJ','INFJ')";
					break;
			}
		}
		else if(map.get("mbti")!=null ) {
			query += " AND IN_MBTI="+"'"+map.get("mbti")+"'";
		}
		//직업
		if(map.get("job")!=null) {
			query += " AND IN_JOB="+"'"+map.get("job")+"'";
		}
		//반려동물유무
		if(map.get("pet")!=null) {
			query += " AND IN_HASPET="+"'"+map.get("pet")+"'";
		}
		query += " ORDER BY ME_NAME ";
		
		try {
			psmt = con.prepareStatement(query);
			
			rs = psmt.executeQuery();
			while(rs.next()) {
				MatchingDTO dto = new MatchingDTO();
				//System.out.println("DTO 찍어보기");
				dto.setMe_num(rs.getInt("ME_NUM"));
				//System.out.println(dto.getMe_num());
				dto.setMe_age(rs.getInt("ME_AGE"));
				//System.out.println(dto.getMe_age());
				dto.setMe_sex(rs.getString("ME_SEX"));
				//System.out.println(dto.getMe_sex());
				dto.setMe_name(rs.getString("ME_NAME"));
				//System.out.println(dto.getMe_name());
				dto.setRe_num(rs.getInt("RE_NUM"));
				//System.out.println(dto.getRe_num());
				dto.setRe_name(rs.getString("RE_NAME"));
				//System.out.println(dto.getRe_name());
				dto.setMe_phone(rs.getString("ME_PHONE"));
				//System.out.println(dto.getMe_phone());
				dto.setMe_email(rs.getString("ME_EMAIL"));
				//System.out.println(dto.getMe_email());
				dto.setMe_kakao(rs.getString("ME_KAKAO"));
				//System.out.println(dto.getMe_kakao());
				dto.setIn_height(rs.getInt("IN_HEIGHT"));
				//System.out.println(dto.getIn_height());
				dto.setIn_style(rs.getString("IN_STYLE"));
				//System.out.println(dto.getIn_style());
				dto.setIn_edu(rs.getString("IN_EDU"));
				//System.out.println(dto.getIn_edu());
				dto.setIn_rlg(rs.getString("IN_RLG"));
				//System.out.println(dto.getIn_rlg());
				dto.setIn_drunk(rs.getString("IN_DRUNK"));
				//System.out.println(dto.getIn_drunk());
				dto.setIn_smoke(rs.getString("IN_SMOKE"));
				//System.out.println(dto.getIn_smoke());
				dto.setIn_char(rs.getString("IN_CHAR"));
				//System.out.println(dto.getIn_char());
				dto.setIn_mbti(rs.getString("IN_MBTI"));
				//System.out.println(dto.getIn_mbti());
				dto.setIn_hobby(rs.getString("IN_HOBBY"));
				//System.out.println(dto.getIn_hobby());
				dto.setIn_job(rs.getString("IN_JOB"));
				//System.out.println(dto.getIn_job());
				dto.setIn_haspet(rs.getString("IN_HASPET"));
				dto.setIn_opic(rs.getString("IN_OPIC"));
				dto.setIn_npic(rs.getString("IN_NPIC"));
				dto.setIn_ovoice(rs.getString("IN_OVOICE"));
				dto.setIn_nvoice(rs.getString("IN_NVOICE"));
				dto.setPe_num(rs.getInt("PE_NUM"));
				boardLists.add(dto);
				System.out.println(boardLists);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardLists;
	}
	
	
	public MatchingDTO selectView(int ME_NUM) {
		MatchingDTO dto = new MatchingDTO();
		String query = "SELECT * FROM(SELECT M.*, I.IN_HEIGHT, I.IN_STYLE, I.IN_EDU, I.IN_RLG, I.IN_DRUNK, I.IN_SMOKE, I.IN_CHAR, I.IN_MBTI, I.IN_HOBBY, I.IN_JOB, I.IN_HASPET, I.IN_OPIC, I.IN_NPIC, I.IN_OVOICE, I.IN_NVOICE, I.PE_NUM , R.RE_NAME FROM MEMBERS M, MEMINFOS I, REGIONS R WHERE M.ME_NUM = I.ME_NUM AND M.RE_NUM = R.RE_NUM)";
			  query += " WHERE ME_NUM=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setInt(1, ME_NUM);
			rs=psmt.executeQuery();
			if(rs.next()) {
				dto.setMe_num(rs.getInt("ME_NUM"));
				//System.out.println(dto.getMe_num());
				dto.setMe_age(rs.getInt("ME_AGE"));
				//System.out.println(dto.getMe_age());
				dto.setMe_sex(rs.getString("ME_SEX"));
				//System.out.println(dto.getMe_sex());
				dto.setMe_name(rs.getString("ME_NAME"));
				//System.out.println(dto.getMe_name());
				dto.setRe_num(rs.getInt("RE_NUM"));
				//System.out.println(dto.getRe_num());
				dto.setRe_name(rs.getString("RE_NAME"));
				//System.out.println(dto.getRe_name());
				dto.setMe_phone(rs.getString("ME_PHONE"));
				//System.out.println(dto.getMe_phone());
				dto.setMe_email(rs.getString("ME_EMAIL"));
				//System.out.println(dto.getMe_email());
				dto.setMe_kakao(rs.getString("ME_KAKAO"));
				//System.out.println(dto.getMe_kakao());
				dto.setIn_height(rs.getInt("IN_HEIGHT"));
				//System.out.println(dto.getIn_height());
				dto.setIn_style(rs.getString("IN_STYLE"));
				//System.out.println(dto.getIn_style());
				dto.setIn_edu(rs.getString("IN_EDU"));
				//System.out.println(dto.getIn_edu());
				dto.setIn_rlg(rs.getString("IN_RLG"));
				//System.out.println(dto.getIn_rlg());
				dto.setIn_drunk(rs.getString("IN_DRUNK"));
				//System.out.println(dto.getIn_drunk());
				dto.setIn_smoke(rs.getString("IN_SMOKE"));
				//System.out.println(dto.getIn_smoke());
				dto.setIn_char(rs.getString("IN_CHAR"));
				//System.out.println(dto.getIn_char());
				dto.setIn_mbti(rs.getString("IN_MBTI"));
				//System.out.println(dto.getIn_mbti());
				dto.setIn_hobby(rs.getString("IN_HOBBY"));
				//System.out.println(dto.getIn_hobby());
				dto.setIn_job(rs.getString("IN_JOB"));
				//System.out.println(dto.getIn_job());
				dto.setIn_haspet(rs.getString("IN_HASPET"));
			    //System.out.println(dto.getIn_haspet());
				dto.setIn_opic(rs.getString("IN_OPIC"));
				dto.setIn_npic(rs.getString("IN_NPIC"));
				dto.setIn_ovoice(rs.getString("IN_OVOICE"));
				dto.setIn_nvoice(rs.getString("IN_NVOICE"));
				dto.setPe_num(rs.getInt("PE_NUM"));	
			}
		}catch(Exception e) {
			System.out.println("게시물 상세보기 중 예외");
			e.printStackTrace();
		}
		return dto;
	}
}
