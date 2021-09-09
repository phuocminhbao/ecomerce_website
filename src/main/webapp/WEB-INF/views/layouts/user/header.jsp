<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="<c:url value="/home"/>"><span></span> <img
					src="<c:url value ="/assets/user/img/logo.png" />"  alt="shop" height="30" width="60">
				</a>
			</h1>
		</div>
		<div class="span4">
			<div class="offerNoteWrapper"></div>
		</div>
		<div class="span4 alignR">
			<p>
				<br>
			</p>
			<span class="btn btn-mini">[ ${ TotalQuantyCart } ] <span
				class="icon-shopping-cart"></span></span>
		</div>
	</div>
</header>

<!--
Navigation Bar Section 
-->
<div class="navbar">
	<div class="navbar-inner">
		<div class="container">
			<a data-target=".nav-collapse" data-toggle="collapse"
				class="btn btn-navbar"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a>
			<div class="nav-collapse">
				<ul class="nav">
					<c:forEach var="item" items="${ menus }">
						<li class="active"><a href="<c:url value="/${ item.name }"/>">${ item.name }</a></li>
					</c:forEach>
				</ul>
				<form action="<c:url value ="/search${name}"  />">
					<input type="text" name ="name" placeholder="Search" class="search-query span2">
					<button>Find</button>
				</form>

				<ul class="nav pull-right">
					<c:if test="${ empty LoginInfo }">
						
					</c:if>
					<c:if test="${ not empty LoginInfo }">
						<li><a href="#">${ LoginInfo.displayName } <b
						class ="caret"></b></a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>