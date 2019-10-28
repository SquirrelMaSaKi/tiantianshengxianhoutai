<%--
  Created by IntelliJ IDEA.
  User: 海马哥
  Date: 2019/10/27
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>单个商品展示</title>
</head>
<style type="text/css">
    th {
        text-align: left;
        height: 40px;
        width: 100px;
    }

    #fanhui {
        text-decoration: none;
    }
    #fanhui:hover{
        font-weight: bold;
        color: red;
    }
</style>
<body>
<h2>展示商品</h2>
    <table style="width: 600px">
        <tr>
            <th>商品名称</th>
            <td>
                ${good.goodsname}
            </td>
        </tr>
        <tr>
            <th>单价/500g</th>
            <td>
                ${good.price}<b>￥</b>
            </td>
        </tr>
        <tr>
            <th>上架时间</th>
            <td>
                <fmt:formatDate value="${good.upshelf}" pattern="yyyy年MM月dd日"/>
            </td>
        </tr>
        <tr>
            <th>商品类别</th>
            <td>
                ${good.typename}
            </td>
        </tr>
        <tr>
            <th>热度</th>
            <td>
                ${good.hot}
            </td>
        </tr>
        <tr>
            <th>副标题</th>
            <td>
                ${good.subtitle}
            </td>
        </tr>
        <tr>
            <th style="height: 200px">详情</th>
            <td>
                ${good.introduce}
            </td>
        </tr>
        <tr>
            <th>略图</th>
            <td>
                <img src="${pageContext.request.contextPath}/goods/${good.img}" style="height: 100px"/>
            </td>
        </tr>
        <tr>
            <th>大图</th>
            <td>
                <img src="${pageContext.request.contextPath}/goods/${good.imgdetail}" style="height: 100px"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <h4>
                    <a href="${pageContext.request.contextPath}/goodsList" id="fanhui">返回</a>
                </h4>
            </td>
        </tr>
    </table>
</body>
</html>
