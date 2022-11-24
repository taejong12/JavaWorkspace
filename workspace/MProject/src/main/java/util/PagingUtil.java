package util;

public class PagingUtil {
	public static String pagingCenter(int totalCount,int pageSize, int pageBlock,int pageNum, String reqUri) {
		   String pagingRes = "";
		   
		   int totalPage = (int)Math.ceil((double)totalCount/pageSize);
		   int div = pageBlock/2;
		   int pageTemp = pageNum-div;
		   if(pageTemp<=0)pageTemp=1;
		   if(pageTemp!=1) {
		      pagingRes="<a href='"+reqUri+"?pageNum=1'>[first page]</a>";
		   }
		   int Count=1;
		   while(Count<=pageBlock && pageTemp<=totalPage) {
		      if(pageTemp==pageNum) {
		         pagingRes +="&nbsp;"+pageTemp+"&nbsp;";
		      }else {
		         pagingRes+="&nbsp;<a href='"+reqUri+"?pageNum="+pageTemp+"'>"+pageTemp+"</a>&nbsp;";
		      }
		      pageTemp++;
		      Count++;
		   }
		   if(pageTemp<=totalPage) {
		      pagingRes+="<a href='"+reqUri+"?pageNum="+totalPage+"'>[last page]</a>";
		   }
		   return pagingRes;
		   
		}
}
