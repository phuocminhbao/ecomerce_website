<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="row">
		<div class="span9">
			<ul class="breadcrumb">
				<li><a href="<c:url value="/home"/>">Home</a> <span class="divider">/</span></li>
				<li class="active">Login</li>
			</ul>
			<h3>User</h3>
			<hr class="soft" />

			<div class="row">
				<div class="span4">
					<div class="well">
						<h5>CREATE YOUR ACCOUNT</h5>
						<h1>${ status }</h1>
						<br />
						<form:form action="register" method = "POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">E-mail
									</label>
								<div class="controls">
									<form:input type="email" class="span3" placeholder="Input email" path="user" required="required"/>  
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Password</label>
								<div class="controls">
									<form:input type="password" class="span3" placeholder="Input password" path="password" required="required" /> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Full name</label>
								<div class="controls">								
									<form:input type="name" class="span3" placeholder="Input name" path="displayName" required="required"/> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputEmail">Address</label>
								<div class="controls">								
									<form:input type="address" class="span3" placeholder="Input address" path="address" /> 
								</div>
							</div>
							<div class="controls">
								<button type="submit" class="btn block">Create Your
									Account</button>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>
				<div class="span4">
					<div class="well">
						<h5>ALREADY REGISTERED ?</h5>
						<h1>${ statusLog }</h1>
						<form:form action="login" method = "POST" modelAttribute="user">  
							<div class="control-group">
								<label class="control-label" for="inputEmail">Email</label>
								<div class="controls">
									
									<form:input type="email" class="span3" placeholder="Input email" path="user" required="required"/> 
								</div>
							</div>
							<div class="control-group">
								<label class="control-label" for="inputPassword">Password</label>
								<div class="controls">
									<form:input type="password" class="span3" placeholder="Input password" path="password" required="required"/> 
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<button type="submit" class="defaultBtn">Sign in</button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>