<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		
		<%--<!-- bootstrap -->--%>
		<%--<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      --%>
		<%--<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		--%>
		<%--<link href="themes/css/bootstrappage.css" rel="stylesheet"/>--%>
		<%----%>
		<%--<!-- global styles -->--%>
		<%--<link href="themes/css/main.css" rel="stylesheet"/>--%>
		<%--<link href="themes/css/jquery.fancybox.css" rel="stylesheet"/>--%>
				<%----%>
		<%--<!-- scripts -->--%>
		<%--<script src="themes/js/jquery-1.7.2.min.js"></script>--%>
		<%--<script src="bootstrap/js/bootstrap.min.js"></script>				--%>
		<%--<script src="themes/js/superfish.js"></script>	--%>
		<%--<script src="themes/js/jquery.scrolltotop.js"></script>--%>
		<%--<script src="themes/js/jquery.fancybox.js"></script>--%>
		<%--<!--[if lt IE 9]>			--%>
			<%--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>--%>
			<%--<script src="js/respond.min.js"></script>--%>
		<%--<![endif]-->--%>
	</head>
    <body>		

		<div id="wrapper" class="container">
			<section class="navbar main-menu">
				<div class="navbar-inner main-menu">				
					<a href="index.jsp" class="logo pull-left"><img src="/resources/themes/images/logo.png" class="site_logo" alt=""></a>
					<nav id="menu" class="pull-right">
						<ul>
							<li><a href="products.jsp">Woman</a>
								<ul>
									<li><a href="products.jsp">Lacinia nibh</a></li>
									<li><a href="products.jsp">Eget molestie</a></li>
									<li><a href="products.jsp">Varius purus</a></li>
								</ul>
							</li>															
							<li><a href="products.jsp">Man</a></li>
							<li><a href="products.jsp">Sport</a>
								<ul>									
									<li><a href="products.jsp">Gifts and Tech</a></li>
									<li><a href="products.jsp">Ties and Hats</a></li>
									<li><a href="products.jsp">Cold Weather</a></li>
								</ul>
							</li>							
							<li><a href="products.jsp">Hangbag</a></li>
							<li><a href="products.jsp">Best Seller</a></li>
							<li><a href="products.jsp">Top Seller</a></li>
						</ul>
					</nav>
				</div>
			</section>
			<section class="header_text sub">
			<img class="pageBanner" src="/resources/themes/images/pageBanner.png" alt="New products" >
				<h4><span>Product Detail</span></h4>
			</section>
			<section class="main-content">				
				<div class="row">						
					<div class="span9">
						<div class="row">
							<div class="span4">
								<a href="${productdetail.productsByProductId.productImagesByProductImageId.productImage}" class="thumbnail" data-fancybox-group="group1" title="Description 1"><img alt="" src="${productdetail.productsByProductId.productImagesByProductImageId.productImage}"></a>
								<%--<ul class="thumbnails small">								--%>
									<%--<li class="span1">--%>
										<%--<a href="/resources/themes/images/ladies/2.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 2"><img src="/resources/themes/images/ladies/2.jpg" alt=""></a>--%>
									<%--</li>								--%>
									<%--<li class="span1">--%>
										<%--<a href="/resources/themes/images/ladies/3.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 3"><img src="/resources/themes/images/ladies/3.jpg" alt=""></a>--%>
									<%--</li>													--%>
									<%--<li class="span1">--%>
										<%--<a href="/resources/themes/images/ladies/4.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 4"><img src="/resources/themes/images/ladies/4.jpg" alt=""></a>--%>
									<%--</li>--%>
									<%--<li class="span1">--%>
										<%--<a href="/resources/themes/images/ladies/5.jpg" class="thumbnail" data-fancybox-group="group1" title="Description 5"><img src="/resources/themes/images/ladies/5.jpg" alt=""></a>--%>
									<%--</li>--%>
								<%--</ul>--%>
							</div>
							<div class="span5">
								<address>
									<h3> <strong> <span>${productdetail.productsByProductId.productName}</span><br></strong></h3>
									<<strong>Size: <span>${productdetail.productSize}</span></strong> <br>
									<strong>Product Color:</strong> <span>${productdetail.productColor}</span></strong><br>
								</address>									
								<h4><strong>Price:</strong>${productdetail.productPrice} &#x20BA;</h4>
							</div>
							<div class="span5">
								<form class="form-inline">
									<%--<label class="checkbox">--%>
										<%--<input type="checkbox"  value=""> Option one is this and that--%>
									<%--</label>--%>

										<%--<h4>${productdetail.productsByProductId.commentsByProductId}</h4>--%>
									<br/>
									<label class="checkbox">
									  <input type="checkbox" value=""> Be sure to include why it's great
									</label>
									<p>&nbsp;</p>
									<label>Qty:</label>
									<input type="text" class="span1" placeholder="1">
									<button class="btn btn-inverse" type="submit">Add to cart</button>
								</form>
							</div>							
						</div>
						<div class="row">

							<div class="tab-pane fade active in" id="row" style="    padding-left: 60px;margin-top: 70px;" >
								<div class="col-sm-12">



									<ul>
										<c:forEach  items="${commentList}"  var="comment">

										<%--<c:if test="${productdetail.productsByProductId==comment.productsByProductId}">--%>
											<%--<li><a href="#"><i class="fa fa-user"></i>${comment.membersById.memberName}</a></li>--%>
											<div style="border: solid;border-color: antiquewhite;">
											<p style="font-size: medium;">${comment.comment}</p>
											<p style="  text-align: center;    padding-top: 20px;    margin-left: 75%;">
													${comment.membersById.memberName}
											</p>
											<br/>
											</div>
										<%--</c:if>--%>
										</c:forEach>
									</ul>

									<form action="#">
										<span>
											<input type="text" placeholder="Your Name"/>
											<input type="email" placeholder="Email Address"/>
										</span>
										<textarea name="" ></textarea>
										<b>Rating: </b> <img src="images/product-details/rating.png" alt="" />
										<button type="button" class="btn btn-default pull-right">
											Submit
										</button>
									</form>
								</div>
							</div>
						</div>
					</div>
					<div class="span3 col">
						<div class="block">	
							<ul class="nav nav-list">
								<li class="nav-header">SUB CATEGORIES</li>
								<li><a href="products.jsp">Nullam semper elementum</a></li>
								<li class="active"><a href="products.jsp">Phasellus ultricies</a></li>
								<li><a href="products.jsp">Donec laoreet dui</a></li>
								<li><a href="products.jsp">Nullam semper elementum</a></li>
								<li><a href="products.jsp">Phasellus ultricies</a></li>
								<li><a href="products.jsp">Donec laoreet dui</a></li>
							</ul>
							<br/>
							<ul class="nav nav-list below">
								<li class="nav-header">MANUFACTURES</li>
								<li><a href="products.jsp">Adidas</a></li>
								<li><a href="products.jsp">Nike</a></li>
								<li><a href="products.jsp">Dunlop</a></li>
								<li><a href="products.jsp">Yamaha</a></li>
							</ul>
						</div>

					</div>
				</div>
			</section>			
			<section id="footer-bar">
				<div class="row">
					<div class="span3">
						<h4>Navigation</h4>
						<ul class="nav">
							<li><a href="index.jsp">Homepage</a></li>
							<li><a href="./about.html">About Us</a></li>
							<li><a href="contact.jsp">Contac Us</a></li>
							<li><a href="cart.jsp">Your Cart</a></li>
							<li><a href="register.jsp">Login</a></li>
						</ul>					
					</div>
					<div class="span4">
						<h4>My Account</h4>
						<ul class="nav">
							<li><a href="#">My Account</a></li>
							<li><a href="#">Order History</a></li>
							<li><a href="#">Wish List</a></li>
							<li><a href="#">Newsletter</a></li>
						</ul>
					</div>
					<div class="span5">
						<p class="logo"><img src="/resources/themes/images/logo.png" class="site_logo" alt=""></p>
						<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. the  Lorem Ipsum has been the industry's standard dummy text ever since the you.</p>
						<br/>
						<span class="social_icons">
							<a class="facebook" href="#">Facebook</a>
							<a class="twitter" href="#">Twitter</a>
							<a class="skype" href="#">Skype</a>
							<a class="vimeo" href="#">Vimeo</a>
						</span>
					</div>					
				</div>	
			</section>
			<section id="copyright">
				<span>Copyright 2013 bootstrappage template  All right reserved.</span>
			</section>
		</div>
		<script src="themes/js/common.js"></script>
		<script>
			$(function () {
				$('#myTab a:first').tab('show');
				$('#myTab a').click(function (e) {
					e.preventDefault();
					$(this).tab('show');
				})
			})
			$(document).ready(function() {
				$('.thumbnail').fancybox({
					openEffect  : 'none',
					closeEffect : 'none'
				});
				
				$('#myCarousel-2').carousel({
                    interval: 2500
                });								
			});
		</script>
    </body>
</html>