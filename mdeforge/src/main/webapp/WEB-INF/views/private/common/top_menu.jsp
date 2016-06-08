<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="navbar main">
			
			<!-- Menu Toggle Button -->
			<button type="button" class="btn btn-navbar pull-left">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<!-- // Menu Toggle Button END -->
			
			
						<!-- Not Blank page -->
			
						<!-- Full Top Style -->
			<ul class="topnav pull-left">
				
				<li class="dropdown dd-1">
					<a href="#upload-artifact" data-toggle="modal" class="glyphicons cloud-upload"><i></i> ARTIFACT UPLOAD <!--  <span class="caret"></span>--></a>
					<%-- <ul class="dropdown-menu pull-left">
						
						<!-- Components Submenu Regular Items -->
						<li class=""><a href="${pageContext.request.contextPath}/private/EcoreMetamodel/upload" class="glyphicons cloud-upload"><i></i> Metamodel</a></li>
						<li class=""><a href="${pageContext.request.contextPath}/private/ATLTransformation/upload" class="glyphicons cloud-upload"><i></i> ATL Transformation</a></li>
						<li class=""><a href="${pageContext.request.contextPath}/private/Model/upload" class="glyphicons cloud-upload"><i></i> Model</a></li>
						
					</ul>--%>
				</li>
				
					<%-- <li><a href="${pageContext.request.contextPath}/public/search" class="glyphicons search"><i></i> Search</a></li>	 --%>
					
				<li class="glyphs hidden-tablet hidden-phone">
					<ul>
						<li><a href="${pageContext.request.contextPath}/public/dashboard" class="glyphicons folder_open" data-toggle="tooltip" data-title="Browse the repository" data-placement="bottom" data-original-title="" title=""><i></i></a></li>
						<li><a href="${pageContext.request.contextPath}/public/search" class="glyphicons search" data-toggle="tooltip" data-title="Search Artifacts" data-placement="bottom" data-original-title="" title=""><i></i></a></li>
						<li><a href="${pageContext.request.contextPath}/private/dashboard" class="glyphicons dashboard" data-toggle="tooltip" data-title="Private Area" data-placement="bottom" data-original-title="" title=""><i></i></a></li>
					</ul>
				</li>
				<li class="search open">
					<form action="${pageContext.request.contextPath}/public/search" method="get" class="dropdown dd-1">
						<input type="text" value="" placeholder="Search Artifacts.." name="search_string" />
						<button type="button" class="glyphicons search"><i></i></button>
					</form>
				</li>
			</ul>
			<!-- // Full Top Style END -->
						
						
			<!-- // Not Blank Page END -->
						
						
						<!-- Top Menu Right -->
			<ul class="topnav pull-right">
			
								<!-- Themer -->
				<li class="account dropdown dd-1">
					<a data-toggle="dropdown" href="#" class="logout">
					<span class="hidden-tablet hidden-phone hidden-desktop-1"> <security:authentication property="principal.user.username"/></span></a>
					<ul class="dropdown-menu pull-right">				
								
						<li class="profile">
							<span>
								<span class="heading">Profile <a href="#" class="pull-right">edit</a></span>
								<span class="img"></span>
								<span class="details">
									<a href="#"><security:authentication property="principal.user.firstname"/> <security:authentication property="principal.user.lastname"/></a>
									<a href="#"><security:authentication property="principal.user.email"/></a>
									<!--<security:authentication property="principal.user.id" var="userId"/>-->
									<input type="hidden" value="${userId}" id="loggedUserId">
								</span>
								<span class="clearfix"></span>
							</span>
						</li>
						<li><a href="${pageContext.request.contextPath}/private/dashboard" class="menu-right-dropdown pull-right">Dashboard</a></li>		
						<li><a href="${pageContext.request.contextPath}" class="menu-right-dropdown pull-right">MDE Forge Home</a></li>
						<hr>
						<li>
								<a id="logout" class="btn btn-default pull-right" href="${pageContext.request.contextPath}/j_spring_security_logout"><spring:message code="common.logout"/></a>
						</li>
					</ul>
				</li>
				<!-- // Profile / Logout menu END -->
				
			</ul>
			<!-- // Top Menu Right END -->
						<div class="clearfix"></div>
			
		</div>
