<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<header id="header">
	<div class="row">
		<div class="span4">
			<h1>
				<a class="logo" href="index.html"><span></span> <img
					src="<c:url value ="/assets/user/img/logo.png"/>" alt="shop">
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
				<form action="#" class="navbar-search pull-left">
					<input type="text" placeholder="Search" class="search-query span2">
				</form>

				<ul class="nav pull-right">
					<c:if test="${ empty LoginInfo }">
						<li class="dropdown"><a data-toggle="dropdown"
							class="dropdown-toggle" href="#"><span class="icon-lock"></span>Login
								<b class="caret"></b></a>
							<div class="dropdown-menu">
								<form class="form-horizontal loginFrm">
									<div class="control-group">
										<input type="text" class="span2" id="inputEmail"
											placeholder="Email">
									</div>
									<div class="control-group">
										<input type="password" class="span2" id="inputPassword"
											placeholder="Password">
									</div>
									<div class="control-group">
										<label class="checkbox"> <input type="checkbox">
											Remember me
										</label>
										<button type="submit" class="shopBtn btn-block">Sign
											in</button>
									</div>
								</form>
							</div></li>
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