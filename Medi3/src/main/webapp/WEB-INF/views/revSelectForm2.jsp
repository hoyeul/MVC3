<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.revDto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<% String id  =(String) session.getAttribute("sessionID");%>
<% String path = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revSelectForm2.css">
<script src="<%=path %>/js/revSelectForm2.js"></script>
</head>
<body>
<% 
	revDto dto = (revDto)request.getAttribute("dto");
%>
<div class="warp">
              <header class="main-headerNav">
            <div class="headerNav">
                <div class="headerNav__menu">
                    <div>
                        <a href="/Medi3/home.do"><div class="headerNav__logo" ><!-- 메디 쓰리  이미지--></div></a>
                    </div>
                </div>
                <div class="headerNav__menu">
                    <!-- nav -->
                    <ul>
                        <li class="menu__item">
                            <h3><a href="#">예약 <span class="arow__size">▼</span><div class="stic"></div></a></h3>
                            <ul class="item__list">
                                <li><a href="revInsertController.do">예약 하기<div class="stic_small"></div></a></li>
                                <li><a href="revSelectController.do">예약 조회<div class="stic_small"></div></a></li>
                                <li><a href="revUpdateController.do">예약 변경<div class="stic_small"></div></a></li>
                            </ul>

                        </li>
                        <li class="menu__item">
                            <h3><a href="board.con">문의게시판<div class="stic"></div></a></h3>

                        </li>
                        <li class="menu__item">
                        <% if( id  !=  null){
						%>
							<h3><a href="#">마이페이지<span class="arow__size">▼</span><div class="stic"></div></a></h3>
							 <ul class="item__list">
                                <li><a href="modify.do">회원 정보 수정<div class="stic_small"></div></a></li>
                                <li><a href="delete.do">회원 탈퇴<div class="stic_small"></div></a></li>
                            </ul>
                        </li>
                            
						<%
							}
							else{
						%>
							<h3><a href="register.do">회원가입<div class="stic"></div></a></h3>
                        <% } %>
                        <li class="menu__item">
                       <% if( id  !=  null){
						%> <h3><a href="/Medi3/logout.do">로그아웃<div class="stic"></div></a></h3>
						<%
							}
							else{
							%>
							<h3><a href="/Medi3/login.do">로그인<span class="arow__size">▼</span><div class="stic"></div></a></h3>
							 <ul class="item__list">
                                <li><a href="searchID">아이디찾기<div class="stic_small"></div></a></li>
                                <li><a href="searchPW">비번찾기<div class="stic_small"></div></a></li>
                            </ul>
							<% } %>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
<main class="mainsearchid">
<form name="frm" action="revDeleteController.do" class="revFrom_table">
<table class="revFrom_table">
	<caption>건강검진 예약 조회</caption>
	<tr>
		<td>예약번호</td>
		<td><input type="text" name="rev_num" value=<%=dto.getRev_num() %> readonly></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" value=<%=dto.getRev_name() %> readonly></td>
	</tr>
	<tr>
		<td>지역</td>
		<td><input type="text" value=<%=dto.getRev_location() %> readonly></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" value=<%=dto.getRev_date() %> readonly></td>
	</tr>
	<tr>
		<td>시간</td>
		<td><input type="text" value=<%=dto.getRev_time() %> readonly></td>
	</tr>
	<tr>
		<td>프로그램</td>
		<td><input type="text" value=<%=dto.getRev_program() %> readonly></td>
	</tr>
	<tr>
		<td colspan="2">
			<button type="button" onclick="cancel()">예약취소</button>
			<button type="button" onclick="window.location.href='home.do'">홈으로</button>
		</td>
	</tr>
</table>
<input type="hidden" name="rev_id", value=<%=dto.getRev_id() %>>
</form>
</main>
  <footer>
            <!--
            <div class="footer_top">
                <div class="footer_top__content">
                    <ul class="footer_menus">
                        <li><a>개인정보 방침처리</a> ㅣ</li>
                        <li><a>이용약관</a> ㅣ</li>
                        <li><a>전국센터 전화번호</a> ㅣ</li>
                    </ul>
                    <div class="footer_menus">
                        <button>유관기관바로가기</button>
                        <button>협력의료기관</button>
                        <button>패밀리사이트</button>
                    </div>
                </div>
            </div>-->
            <div class="footer_bottom">
                <div class="footer_bottom__content">
                        <div class="content__one">
                            <span class="footer_log"></span>
                            <ul>
                                <li><span class="icon face "></span></li>
                                <li><span class="icon yotube"></span></li>
                                <li><span class="icon instar"></span></li>
                                <li><span class="icon naver"></span></li>
                            </ul>
                        </div> 
                        <div class="content__tow">
                            <ul>
                                <li>(07572) 서울시 강서구 화곡로 372(등총동 656-18)</li> ㅣ
                                <li>사업자등록번호 : 109-82-00394</li> ㅣ
                                <li>대표 : 3조</li>
                                <li>대표번호 : 02-2601-6141~5</li>
                            </ul>
                        </div>

                        <p class="Copyright">Copyright 2022 Korea Association of Health Promotion. All right reserved.
                </div>
                
            </div>
        </footer>
    </div>
</body>
</html>