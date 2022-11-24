<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnAList</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 
<style>
	@import 'https://fonts.googleapis.com/css?family=Open+Sans:600,700';
	
	* {font-family: 'Open Sans', sans-serif;}
	
	.rwd-table {
	  margin: auto;
	  min-width: 300px;
	  max-width: 100%;
	  border-collapse: collapse;
	}
	
	.rwd-table tr:first-child {
	  border-top: none;
	  background:#ffeaea;
	  color: #000000;
	}
	
	.rwd-table tr {
	  border-top: 1px solid #ddd;
	  border-bottom: 1px solid #ddd;
	  background-color: #FFFFF0;
	}
	
	.rwd-table tr:nth-child(odd):not(:first-child) {
	  background-color: #FFF5EE;
	}
	
	.rwd-table th {
	  display: none;
	}
	
	.rwd-table td {
	  display: block;
	}
	
	.rwd-table td:first-child {
	  margin-top: .5em;
	}
	
	.rwd-table td:last-child {
	  margin-bottom: .5em;
	}
	
	.rwd-table td:before {
	  content: attr(data-th) ": ";
	  font-weight: bold;
	  width: 120px;
	  display: inline-block;
	  color: #000;
	}
	
	.rwd-table th,
	.rwd-table td {
	  text-align: left;
	}
	
	.rwd-table {
	  color: #333;
	  border-radius: .4em;
	  overflow: hidden;
	}
	
	.rwd-table tr {
	  border-color: #dbd9d9;
	}
	
	.rwd-table th,
	.rwd-table td {
	  padding: .5em 1em;
	}
	
	@media screen and (max-width: 601px) {
	  .rwd-table tr:nth-child(2) {
	    border-top: none;
	  }
	}
	
	@media screen and (min-width: 600px) {
	  .rwd-table tr:hover:not(:first-child) {
	    background-color: #E0FFFF;
	  }
	  .rwd-table td:before {
	    display: none;
	  }
	  .rwd-table th,
	  .rwd-table td {
	    display: table-cell;
	    padding: .25em .5em;
	  }
	  .rwd-table th:first-child,
	  .rwd-table td:first-child {
	    padding-left: 0;
	  }
	  .rwd-table th:last-child,
	  .rwd-table td:last-child {
	    padding-right: 0;
	  }
	  .rwd-table th,
	  .rwd-table td {
	    padding: 1em !important;
	  }
	}
	
	
	h1 {
	  text-align: center;
	  font-size: 2.4em;
	  color: #ff9ccd;
	}
	
	.container {
	  display: block;
	  text-align: center;
	}
	
	h3 {
	  display: inline-block;
	  position: relative;
	  text-align: center;
	  font-size: 1.5em;
	  color: #cecece;
	}
	
	h3:before {
	  content: "\25C0";
	  position: absolute;
	  left: -50px;
	  -webkit-animation: leftRight 2s linear infinite;
	  animation: leftRight 2s linear infinite;
	}
	
	h3:after {
	  content: "\25b6";
	  position: absolute;
	  right: -50px;
	  -webkit-animation: leftRight 2s linear infinite reverse;
	  animation: leftRight 2s linear infinite reverse;
	}

	.pageNumber {
		color:#f1575b;
	}
	
	.pageNumber a {
		color:skyblue;
	}
	
</style>

</head>
<body>
<jsp:include page="../Common/Top.jsp"/>
	
	
	<!-- 목록 -->
	<div style=" padding: 0em 5em; margin: 5% 0em;">
	
		<h2>QnA목록보기</h2>
		
		<table class="rwd-table" width="100%">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		
			<c:choose>
				<c:when test="${empty boardLists}">
					<tr>
						<td colspan="5" align="center"><h3>등록된 게시물이 없습니다.</h3></td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${boardLists}" var="list" varStatus="stat">
						<tr align="center">
							<td>
								${map.totalCount-(((map.pageNum-1)*map.pageSize)+stat.index) }
							</td>
							<td align="left">
								<a href="../qnasBoard/qnasView.do?num=${list.num}" style="color:black;">${list.name}</a>
							</td>
							<td>${list.menum}</td>
							<td>${list.postdate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
		
		<!-- 하단 메뉴(페이징) -->
		<table style="margin: auto;">
			<tr align="center">
				<td class="pageNumber">
					${map.pagingStr}
				</td>
			</tr>
		</table>
		
			<!-- 검색,글쓰기 -->
			<form method="get">
				<div style="margin: auto; width: 500px;">
					<select name="searchType" class="form-select form-select-sm" aria-label=".form-select-sm example" style="margin-left: 5%;  width:80px;font-size:15px; display: inline;">
						<option value="qa_name"
							<c:if test="${map.searchType=='qa_name'}">selected</c:if>>제목
						</option>
						<option value="qa_content"
							<c:if test="${map.searchType=='qa_content'}">selected</c:if>>내용
						</option>
					</select>
					<input class="form-control me-2" type="search" name="searchStr" placeholder="Search" aria-label="Search" value="${map.searchStr}" style="width:50%; display: inline;" />
					<input class="btn btn-outline-dark" type="submit" value="검색" style="display: inline;" />
				</div>
				<div style="align-content: center;" style="margin: auto;">	
				<button style="float: right;" class="btn btn-outline-dark" type="button"
					onclick="location.href='../qnasBoard/qnasWrite.do';">글쓰기</button>
				</div>
			</form>
	</div>
		
<jsp:include page="../Common/Footer.jsp"/>
</body>
</html>