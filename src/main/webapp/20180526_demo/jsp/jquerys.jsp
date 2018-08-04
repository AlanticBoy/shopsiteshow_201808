<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/6/1
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../../mstp_37_megashop/magashop/js/jquery-1.8.2.min.js"></script>
    <link href="../css/jquerydemo.css" rel="stylesheet" type="text/css">
    <script type="text/javascript">


        /* $(document).ready(function () {
         $("#action").click(function () {
         alert($("#content").val());
         $("#content").val("");
         })
         })*/
        $(function () {
            $("#action").blur(function () {
                alert($("#content").val());
                $("#content").val("");
            });
            $("#fadesDiv").find("p").click(function () {
                //寻找当前标签的父标签的下一个标签
                //$(this).parent().next().find("ul").css("display","block");
                //寻找当前标签的父亲标签的所有兄弟标签
                $(this).parent().siblings().find("ul").css("display", "none");
                //寻找当前标签的下一个标签
                //$(this).next().css("display", "block");
                $(this).next().css({
                    "padding-top":"5px",
                    "display":"block"
                })
            })
        })
    </script>
</head>
<body>


<div class="article">
    <div id="fadesDiv" class="article01">
        <div class="types">
            <p>天猫精选</p>
            <ul id="first">
                <li>
                    <a href="#">天猫精选01</a>
                </li>
                <li>
                    <a href="#">天猫精选01</a>
                </li>
                <li>
                    <a href="#">天猫精选01</a>
                </li>
                <li>
                    <a href="#">天猫精选01</a>
                </li>
            </ul>
        </div>

        <div class="types">
            <p>东方财富</p>
            <ul id="second">
                <li>
                    <a href="#">东方财富01</a>
                </li>
                <li>
                    <a href="#">东方财富01</a>
                </li>
                <li>
                    <a href="#">东方财富01</a>
                </li>
                <li>
                    <a href="#">东方财富01</a>
                </li>
            </ul>
        </div>
        <div class="types">
            <p>京东商城</p>
            <ul id="third">
                <li>
                    <a href="#">京东商城01</a>
                </li>
                <li>
                    <a href="#">京东商城01</a>
                </li>
                <li>
                    <a href="#">京东商城01</a>
                </li>
                <li>
                    <a href="#">京东商城01</a>
                </li>
            </ul>
        </div>

        <div class="types">
            <p>苏宁易购</p>
            <ul id="fouth">
                <li>
                    <a href="../../mstp_37_megashop/magashop/account_create.html" target="pageContent">苏宁易购01</a>
                </li>
                <li>
                    <a href="../../amz_02_adp/one/person/blog.html" target="pageContent">苏宁易购01</a>
                </li>
                <li>
                    <a href="../../mstp_37_megashop/magashop/cart.html" target="pageContent">苏宁易购01</a>
                </li>
                <li>
                    <a href="../../mstp_37_megashop/index.html" target="pageContent">苏宁易购01</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="article02">
        <%--网页一打开iframe显示的页面--%>
        <iframe src="../../mstp_37_megashop/magashop/category.html" name="pageContent">

        </iframe>
    </div>
</div>
</body>
</html>
