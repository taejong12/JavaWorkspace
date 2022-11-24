package utils;

public class PagingUtil {
	public static String pagingStr(int totalCount, int pageSize, int pageBlock,
			int pageNum, String reqUri) {
		String pagingRes="";
		
		int totalPage= (int)Math.ceil((double)totalCount/pageSize); // 전체페이지 개수
		
//		int div = pageBlock/2;
//		int pageTemp = pageNum-div;
//		if(pageTemp<=0)pageTemp=1;
//		if(pageTemp!=1) {
//			pagingRes = "<a href='"+reqUri+"?pageNum=1'>[first]</a>";
//			}
//			
//			int count=1;
//			while(count<=pageBlock && pageTemp<=totalPage) {
//				if(pageTemp==pageNum) {
//					pagingRes += "&nbsp;"+pageTemp+"&nbsp;";
//				} else {
//					pagingRes += "&nbsp;<a href='"+reqUri+"?pageNum="
//							+pageTemp+"'>"+pageTemp+"</a>&nbsp;";
//				}
//				pageTemp++;
//				count++;
//			}
//			
//			if(pageTemp<=totalPage) {
//				pagingRes += "<a href='"+reqUri+"?pageNum="+pageTemp
//						+"'>[last]</a>";
//				}
//			
//			return pagingRes;

		// 나누면 바로 앞페이지가 속한 블럭 번호가 나온다 
		int pageTemp = (((pageNum-1)/pageBlock)*pageBlock)+1;
		
		if(pageTemp!=1) {
		pagingRes = "<a href='"+reqUri+"?pageNum=1'>[first]</a>";
		pagingRes += "&nbsp";
		pagingRes += "<a href='"+reqUri+"?pageNum="+(pageTemp-1)
				+"'>[prev block]</a>";
		}
		
		int blockCount=1;
		while(blockCount<=pageBlock && pageTemp<=totalPage) {
			if(pageTemp==pageNum) {
				pagingRes += "&nbsp;"+pageTemp+"&nbsp;";
			} else {
				pagingRes += "&nbsp;<a href='"+reqUri+"?pageNum="
						+pageTemp+"'>"+pageTemp+"</a>&nbsp;";
				
			}
			pageTemp++;
			blockCount++;
		}
		
		if(pageTemp<=totalPage) {
			pagingRes += "<a href='"+reqUri+"?pageNum="+pageTemp
					+"'>[next block]</a>";
			pagingRes += "&nbsp";
			pagingRes += "<a href='"+reqUri+"?pageNum="+totalPage
					+"'>[last]</a>";
			}
		
		return pagingRes;
	}
}
