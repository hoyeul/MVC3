<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% String path  = request.getContextPath(); %>
 <link rel="stylesheet" href="css/index.css">

<%
 String id  = (String)session.getAttribute("sessionID");
 
%>


<link rel="stylesheet" href="<%=path %>/css/boardEnter.css">

</head>
<body>
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
	<main>
		<form action= "BoardEnter" method ="post" name= "en_frm"  class="boardContent">
		    <table>
		        <caption>문의함</caption>
		        <thead class="content_head">
		            <tr class="content_head__title">
		                <td><label> 제  목  :</label></td>
		                <td><input type="text" name="title" placeholder="제목을 입력해주세요"></td>
		            </tr>
		            <tr class="content_head__writer">
		                <td colspan="2">
		                    <label> 작성자 : </label><span><%=id%></span>
		                </td>
		            </tr>
		        </thead>
		        <tbody  class="content-text">
		            <tr >
		                <td  class="content_text__content" colspan="2">
		                    <textarea name="content" id="" placeholder="내용을 입력해주세요" ></textarea>
		                </td>
		            </tr>
		            <tr>
		                <td class="content_btn" colspan="2">
		                    <button>등록</button>
		                    <button  type="button" onclick="location.href='board.con'">목록으로</button>
		                    <!-- 데이터를 보내면 안대는딩 js로 보내지않게 해야하는가 -->
		                </td>
		            </tr>
		        </tbody>
		    </table>  
		    <input type="hidden" name="id" value="<%=id%>"> 
		    
		    
		
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
</body>
</html>