<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="/WEB-INF/views/layouts/user/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
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
						<br />
						<form:form action ="checkout" method ="post" modelAttribute ="bills" >
							<h3>Your Billing Details</h3>
							<div class="control-group">
								<label class="control-label">Name <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Input name" path = "displayName" required="required"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Email <sup>*</sup></label>
								<div class="controls">
									<form:input type="email" placeholder=" Input email" path = "user" required="required"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Phone number <sup>*</sup></label>
								<div class="controls">
									<form:input type="text" placeholder=" Input phone" path = "phone" required="required"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Address <sup>*</sup></label>
								<div class="controls">
									<form:textarea path = "address" row ="5" cols = "30" required="required"/>
								</div>
							</div>
							<div class="control-group">
								<label class="control-label">Note <sup>*</sup></label>
								<div class="controls">
									<form:textarea path = "note" row ="5" cols = "30"/>
								</div>
							</div>
							<div class="control-group">
								<div class="controls">
									<input type="submit" name="submitAccount" value="Order"
										class="shopBtn exclusive">
								</div>
							</div>
						</form:form>
					</div>
				</div>
				<div class="span1">&nbsp;</div>

			</div>

		</div>
	</div>
</body>
</html>