<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.Member" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>�޵� ����</title>
    <link rel="stylesheet" href="css/member_info.css">
    <meta charset="UTF-8">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="./js/m_modify.js"></script>
	<% String id  =(String) session.getAttribute("sessionID"); %>
</head>
<body>
    <div class="warp">
        <header class="main-headerNav">
            <div class="headerNav">
                <div class="headerNav__menu">
                    <div>
                        <div class="headerNav__logo" ><!-- �޵� ����  �̹���--></div>
                    </div>
                </div>
                <div class="headerNav__menu">
                    <!-- nav -->
                    <ul>
                        <li class="menu__item">
                            <h3><a href="#">���� <span class="arow__size">��</span><div class="stic"></div></a></h3>
                            <ul class="item__list">
                                <li><a href="revInsertController.do">���� �ϱ�<div class="stic_small"></div></a></li>
                                <li><a href="revSelectController.do">���� ��ȸ<div class="stic_small"></div></a></li>
                                <li><a href="revDeleteController.do">���� ����<div class="stic_small"></div></a></li>
                            </ul>

                        </li>
                        <li class="menu__item">
                            <h3><a href="borad.con">���ǰԽ���<div class="stic"></div></a></h3>

                        </li>
                        <li class="menu__item">
                        <% if( id  !=  null){
						%>
							<h3><a>����������<span class="arow__size">��</span><div class="stic"></div></a></h3>
							 <ul class="item__list">
                                <li><a href="modify.do">ȸ�� ���� ����<div class="stic_small"></div></a></li>
                                <li><a href="delete.do">ȸ�� Ż��<div class="stic_small"></div></a></li>
                            </ul>
                        </li>
                            
						<%
							}
							else{
						%>
							<h3><a href="register.do">ȸ������<div class="stic"></div></a></h3>
                        <% } %>
                        <li class="menu__item">
                       <% if( id  !=  null){
						%> <h3><a href="/Medi3/logout.do">�α׾ƿ�<span class="arow__size">��</span><div class="stic"></div></a></h3>
						<%
							}
							else{
							%>
							<h3><a href="/Medi3/login.do">�α���<span class="arow__size">��</span><div class="stic"></div></a></h3>
							 <ul class="item__list">
                                <li><a href="searchID">���̵�ã��<div class="stic_small"></div></a></li>
                                <li><a href="searchPW">���ã��<div class="stic_small"></div></a></li>
                            </ul>
							<% } %>
                        </li>
                    </ul>
                </div>
            </div>
        </header>
<main class="main-m_modify">
<%  request.setCharacterEncoding("utf-8");
	Member member = (Member)request.getAttribute("member");
   %>
<form name="modfrm" method="post" action="modify2.do">
<table id="jjy_table">
<caption>ȸ�� ���� ����</caption>
<tr><td colspan="2"><input type="hidden" name ="userid" value=<%= member.getUserid() %>></td></tr>
<tr>
<td>��й�ȣ</td>
<td><input type="password" name="userpw" value="<%= member.getUserpw() %>" onkeyup="chkCharCode(event)" >
<input type="hidden" name="userpwpast" value="<%= member.getUserpw() %>">
</td>
</tr>
<tr>
<td>��й�ȣ Ȯ��</td>
<td><input type="password" name="userpwcheck"></td>
</tr>
<tr>
<td>�̸�</td>
<td><input type="text" name="name" value="<%= member.getName()%>"  onkeyup="chkNameCode(event)"></td>
</tr>
<tr>
<td>�ֹι�ȣ</td>
<td><input type="text" name="num" value="<%= member.getNum()%>" onkeyup="chkNumCode(event)" maxlength="14"></td>
</tr>
<tr>
<td>�ּ�</td>
<td><input type="text" name="addr" id="addr" value="<%= member.getAddr() %>">
<button type="button" onclick="checkaddr()">���� ��ȣ ã��</button></td>
</tr>
<tr>
<td>��ȭ��ȣ</td>
<td><input type="tel" name="tel" value="<%= member.getTel() %>" onkeyup="chkNumCode(event)"></td>
</tr>
<tr>
<td colspan="2">
<button type="button" onclick="check2();">����</button>
<button type="button" onclick = "window.location.href = 'home.do' ">���</button>
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
                        <li><a>�������� ��ħó��</a> ��</li>
                        <li><a>�̿���</a> ��</li>
                        <li><a>�������� ��ȭ��ȣ</a> ��</li>
                    </ul>
                    <div class="footer_menus">
                        <button>��������ٷΰ���</button>
                        <button>�����Ƿ���</button>
                        <button>�йи�����Ʈ</button>
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
                                <li>(07572) ����� ������ ȭ��� 372(���ѵ� 656-18)</li> ��
                                <li>����ڵ�Ϲ�ȣ : 109-82-00394</li> ��
                                <li>��ǥ : 3��</li>
                                <li>��ǥ��ȣ : 02-2601-6141~5</li>
                            </ul>
                        </div>

                        <p class="Copyright">Copyright 2022 Korea Association of Health Promotion. All right reserved.
                </div>
                
            </div>
        </footer>
    </div>
</body>
</html>