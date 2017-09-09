<%--
  Created by IntelliJ IDEA.
  User: Mithat
  Date: 30.07.2017
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>


    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>"/>--%>

    <link href="/resources/themes/css/bootstrappage.css" rel="stylesheet"/>

    <!-- global styles -->
    <link href="/resources/themes/css/flexslider.css" rel="stylesheet"/>
    <link href="/resources/themes/css/main.css" rel="stylesheet"/>

    <!-- scripts -->
    <script src="/resources/themes/js/jquery-1.7.2.min.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="/resources/themes/js/superfish.js"></script>
    <script src="/resources/themes/js/jquery.scrolltotop.js"></script>



</head>
<body>
<jsp:include page="Top-Bar.jsp"/>

<%--<a href="newpage.jsp">Index</a>--%>
<%--<a href="WEB-INF/jsp/pages/contact.jsp">Contact</a>--%>


<decorator:body/>

</body>
</html>
