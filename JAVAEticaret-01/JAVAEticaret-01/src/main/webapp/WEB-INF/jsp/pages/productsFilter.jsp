<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Bootstrap E-commerce Templates</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
    <!-- bootstrap -->
    <%--<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">      --%>
    <%--<link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">		--%>
    <%--<link href="themes/css/bootstrappage.css" rel="stylesheet"/>--%>
    <%----%>
    <%--<!-- global styles -->--%>
    <%--<link href="themes/css/flexslider.css" rel="stylesheet"/>--%>
    <%--<link href="themes/css/main.css" rel="stylesheet"/>--%>

    <%--<!-- scripts -->--%>
    <%--<script src="themes/js/jquery-1.7.2.min.js"></script>--%>
    <%--<script src="bootstrap/js/bootstrap.min.js"></script>				--%>
    <%--<script src="themes/js/superfish.js"></script>	--%>
    <%--<script src="themes/js/jquery.scrolltotop.js"></script>--%>
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
                    <li><a href="/UI/productslist">Woman</a>
                        <ul>
                            <li><a href="products.jsp">Lacinia nibh</a></li>
                            <li><a href="products.jsp">Eget molestie</a></li>
                            <li><a href="products.jsp">Varius purus</a></li>
                        </ul>
                    </li>
                    <li><a href="/UI/productslist">Man</a></li>
                    <li><a href="/UI/productslist">Sport</a>
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
        <h4><span>New products</span></h4>
    </section>
    <section class="main-content">

        <div class="row">
            <div class="span9">
                <ul class="thumbnails listing-products">
                    <c:forEach  items="${productslist}"  var="productDet">
                        <%--<li><c:out value="${product.}"/></li>--%>

                        <li class="span3">
                            <div class="product-box">
                                <span class="sale_tag"></span>
                                <a href="/UI/productsDet/${productDet.productDetailId}"><img alt="" src="${productDet.productsByProductId.productImagesByProductImageId.productImage}"></a><br/>
                                <a href="/UI/productsDet/${productDet.productDetailId}" class="title">"${productDet.productsByProductId.productName}"</a><br/>
                                <a href="/UI/productsDet/${productDet.productDetailId}" class="category">${productDet.productColor}</a>
                                <p class="price">${productDet.productPrice} &#x20BA; </p>
                            </div>
                        </li>

                    </c:forEach>

                </ul>
                <hr>
                <div class="pagination pagination-small pagination-centered">
                    <ul>
                        <li><a href="#">Prev</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">Next</a></li>
                    </ul>
                </div>
            </div>
            <div class="span3 col">

                <div class="block">
                    <h5 class="title">
                        <span class="text">Filtrele</span>
                    </h5>
                    <form action="/UI/productsfilter" method="get">
                        <div class="form-group row">
                            <div class="col-xs-2">
                                <label style="margin-left: -180px;">Renk</label>
                                <input class="form-control" type="text" name="Renk">
                            </div>
                            <br/>
                            <div class="col-xs-2">
                                <label  style="margin-left: -164px;" >Beden</label>
                                <input class="form-control" type="text" name="Beden">
                            </div>
                            <br/>
                            <div class="col-xs-2">
                                <label  style="margin-left: -150px;" >Max.Fiyat</label>
                                <input class="form-control" type="text" name="Fiyat">
                            </div>
                            <button type="submit" class="btn" >Filtrele</button>
                            <%--href="/UI/productsfilter"--%>
                        </div>
                    </form>
                </div>





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
<script src="/resources/themes/js/common.js"></script>
</body>
</html>