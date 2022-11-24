package utils;
//페이징 관리 클래스
public class PagingUtil {
	
	//블록으로 관리
	public static String pagingStr(int totalCount,int pageSize, int pageBlock, 
			int pageNum,String reqUri) {
		String pagingRes ="";
		int totalPage = (int)Math.ceil((double)totalCount/pageSize);
		
		int pageTemp = (((pageNum-1)/pageBlock)*pageBlock)+1;
		if(pageTemp!=1) {
			pagingRes+="<a href='"+reqUri+"?pageNum=1'>[first]</a>";
			pagingRes+= "&nbsp";
			pagingRes+= "<a href='"+reqUri+"?pageNum="+(pageTemp-1)+"'>[prev Block]</a>";
		}
		int blockCount=1;
		while(blockCount<=pageBlock && pageTemp<=totalPage) {
			if(pageTemp==pageNum) {
				pagingRes+="&nbsp;"+pageTemp+"&nbsp;";
			}else {
				pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp+"'>"+pageTemp+"</a>&nbsp;";
			}
			pageTemp++;
			blockCount++;
		}
		if(pageTemp<=totalPage) {
			pagingRes+="<a href='"+reqUri+"?pageNum="+pageTemp+"'>[next block]</a>";
			pagingRes+="&nbsp;";
			pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last]</a>";
		}
		return pagingRes;
	}
	//현재 페이지 중심으로 좌우로 2개씩 해서 5개
	public static String pagingCenter(int totalCount, int pageSize, int pageBlock, int pageNum, String reqUri) {
		String pagingRes="";
		int totalPage =(int)Math.ceil((double)totalCount/pageSize);//전체 데이터 수를/페이지당 데이터 수로 나눠서 총 페이지 수 도출
		int div = pageBlock/2; // 이거랑 밑에꺼랑.. 밑에 설명
		int pageTemp = pageNum-div; // 1,2,3페이지일 때 first 링크 생성하지 않기 위한 공간을 만들 수식.
		if(pageTemp<=0) {pageTemp=1;} //임시 페이지가 숫자가 0보다 작으면 무조건 1페이지로
		if(pageTemp!=1) { //임시 페이지가 1이 아니면 pageNum=1 로 가는 first 링크 생성
			pagingRes+="<a href='"+reqUri+"?pageNum=1'>[first]</a>";
		}

		int count=1; //pageBlock만큼 반복횟수를 돌리기 위해 만들어진 임의의 변수 count
		while(count<=pageBlock && pageTemp <=totalPage) {
			if(pageTemp==pageNum) { //현재 페이지와 임시 페이지가 같은 경우 
				pagingRes+="&nbsp;"+pageTemp+"&nbsp;"; //링크가 없이 그냥 페이지 번호만 써짐.
			}else {
				pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp+"'>"+pageTemp+"</a>&nbsp;";
			}
			pageTemp++;
			count++;
		}
		if(pageTemp<=totalPage) {
			pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last]</a>";
		}
		return pagingRes;
	}
}


