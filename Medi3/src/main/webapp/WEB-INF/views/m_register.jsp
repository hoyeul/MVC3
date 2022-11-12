<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path  = request.getContextPath(); %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>메디 쓰리</title>
    <link rel="stylesheet" href="css/member_info.css">
    <meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<%=path %>/js/m_register.js"></script>
	 <% String id  =(String) session.getAttribute("sessionID"); %>
</head>
<body>
    <div class="warp">
        <header class="main-headerNav">
            <div class="headerNav">
                <div class="headerNav__menu">
                    <div>
                        <div class="headerNav__logo" ><!-- 메디 쓰리  이미지--></div>
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
                                <li><a href="revDeleteController.do">예약 변경<div class="stic_small"></div></a></li>
                            </ul>

                        </li>
                        <li class="menu__item">
                            <h3><a href="borad.con">문의게시판<div class="stic"></div></a></h3>

                        </li>
                        <li class="menu__item">
                        <% if( id  !=  null){
						%>
							<h3><a>마이페이지<span class="arow__size">▼</span><div class="stic"></div></a></h3>
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
						%> <h3><a href="/Medi3/logout.do">로그아웃<span class="arow__size">▼</span><div class="stic"></div></a></h3>
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


   <main class="main-m_register">
    <form name="regfrm" action="register.do" method="post">
	<table id="jjy_table">
	<caption>회원가입</caption>
	<tr>
	<td>아이디</td>
	<td>
	<input type="text" name="userid" id="userid" onkeyup="chkCharCode(event)" />
	<button type="button" onclick="checkid()">아이디 확인</button>
	<input type="hidden" name="useridchk" id="useridchk" value="0" >
	</td>
	</tr>
	<tr>
	<td>비밀번호</td>
	<td><input type="password" name="userpw"  onkeydown="chkCharCode(event)" >
	</td>
	</tr>
	<tr>
	<td>비밀번호 확인</td>
	<td><input type="password" name="userpwcheck"  onkeyup="chkCharCode(event)" ></td>
	</tr>
	<tr>
	<td>이름</td>
	<td><input type="text" name="name" onkeyup="chkNameCode(event)" ></td>
	</tr>
	<tr>
	<td>주민번호</td>
	<td><input type="text" name="num" placeholder="123456-1234567" onkeyup="chkNumCode(event)" maxlength="14"></td>
	</tr>
	<tr>
	<td>주소</td>
	<td><input type="text" name="addr" id="addr">
	<button type="button" onclick="checkaddr()">우편 번호 찾기</button>
	</td>
	</tr>
	<tr>
	<td>전화번호</td>
	<td><input type="tel" name="tel" placeholder="010-1111-1111" onkeyup="chkNumCode(event)"></td>
	</tr>
	<tr>
	<td colspan="2">
	<button type="button" onclick="check();">가입</button>
	<button type="button" onclick = "window.location.href = 'home.do' ">취소</button>
	</td>
	</tr>
	</table>
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
                                <li>(07572) 서울시 강서구 화곡로 372(등총동 656-18)</li>
                                <li>사업자등록번호 : 109-82-00394</li>
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