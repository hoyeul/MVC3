<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.revDao" %>
<%@ page import="model.revService" %>
<%
	String rev_id = (String) session.getAttribute("sessionID");
	String userName = (String)request.getAttribute("userName");

	revDao dao = new revDao();
	revService s = new revService(dao);
	int num = s.selectNum(rev_id);
	
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<% String id  =(String) session.getAttribute("sessionID");%>
<link rel="stylesheet" href="css/index.css">
<% String path  = request.getContextPath(); %>
<link rel="stylesheet" href="<%=path %>/css/revInsertForm.css">
<script src="<%=path %>/js/revInsertForm.js"></script>
</head>
<body>
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
<main class="main-rev">
<form action="revInsertController.do" method="post" name="frm" class="revFrom_table">
<table class="revFrom_table">
<caption>건강검진 예약</caption>
<tr>
	<td>예약번호</td>
	<td><input type="text" name="rev_num" value="<%=num %>" readonly ></td>
	<!-- 예약번호 자동 생성(해결) -->
</tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="rev_name" value=<%=userName %> readonly></td>
	<!-- 로그인한 사람 이름 연결받아서 박아두기 -->
</tr>
<tr>
	<td>지역</td>
	<td>
		<input type="radio" id="hong" name="rev_location" value="홍대점" onchange="change()" checked> 홍대점
		<input type="radio" id="gang" name="rev_location" value="강남점" onchange="change()"> 강남점
	</td>
	<!-- js로 onchange일 때 다르게 나오게(해결) -->
</tr>
<tr>
	<td>날짜</td>
	<td><input type="text" name="rev_date" id="datepicker"></td>
	<!-- js로, 라이브러리 확인(해결) -->
</tr>
<tr>
	<td>시간</td>
	<td>
		<select name="rev_time" id="rev_time" disabled>
			<option value="">선택</option>
			<option value="09:00">09:00</option>
			<option value="10:00">10:00</option>
			<option value="11:00">11:00</option>
			<option value="12:00">12:00</option>
			<option value="13:00">13:00</option>
			<option value="14:00">14:00</option>
			<option value="15:00">15:00</option>
			<option value="16:00">16:00</option>
			<!-- 이미 예약된 시간 안보이게 하기(해결) -->
		</select>
	</td>
</tr>
<tr>
	<td>건강검진 프로그램</td>
	<td>
		<select name="rev_program">
			<option value="">선택</option>
			<option value="선택1" id="hong1">선택1</option>
			<option value="선택2" id="hong2">선택2</option>
			<option value="선택3" id="gang1" hidden>선택3</option>
			<option value="선택4" id="gang2" hidden>선택4</option>
		</select>
	</td>
</tr>
<tr>
	<td colspan="2">
		<button type="button" onclick="save()">예약</button>
		<button type="button" onclick="window.location.href='home.do'">취소</button>
	</td>
</tr>
</table>
<input type="hidden" name="rev_id" value=<%=rev_id %>>
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