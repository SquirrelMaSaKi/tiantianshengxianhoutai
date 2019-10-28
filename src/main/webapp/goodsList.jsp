<%--
  Created by IntelliJ IDEA.
  User: 海马哥
  Date: 2019/10/26
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<html>
<head>
    <title>商品展示页面</title>
    <script src="${pageContext.request.contextPath}/jquery/jquery-2.2.4.js" type="text/javascript"></script>
</head>
<style type="text/css">
    tr {
        height: 30px;
    }
    th,td{
        width: 150px;
        text-align: center;
    }
    .caozuo {
        text-decoration: none;
    }
    .caozuo:hover{
        font-weight: bold;
    }
    #tianjia:hover{
        font-weight:bold;
    }
    #tianjia {
        text-decoration: none;
        color: red;
        margin-left: 1350px;
    }

</style>
<body>
    <h2>查看商品列表</h2>
    <shiro:hasPermission name="product:update">
        <a href="${pageContext.request.contextPath}/add" id="tianjia">添加商品</a>
    </shiro:hasPermission>
    <table border="1px" cellspacing="0" style="width: 1420px">
        <tr>
            <th>商品序号</th>
            <th>商品类别</th>
            <th>商品名称</th>
            <th>副标题</th>
            <th>单价/500g</th>
            <th>上架时间</th>
            <th>热度</th>
            <th style="width: 180px">操作</th>
        </tr>
        <c:forEach items="${goods}" var="g">
            <tr>
                <td>${g.id}</td>
                <td>${g.typename}</td>
                <td>${g.goodsname}</td>
                <td style="width: 300px">${g.subtitle}</td>
                <td>${g.price}</td>
                <td><fmt:formatDate pattern="yyyy年MM月dd日" value="${g.upshelf}"/></td>
                <td><b>${g.hot}</b>星</td>
                <td>
                    <a href="${pageContext.request.contextPath}/show?gid=${g.id}" class="caozuo">查看详情</a>
                    <shiro:hasPermission name="product:update">
                        <a href="${pageContext.request.contextPath}/modify?gid=${g.id}" class="caozuo">修改</a>
                    </shiro:hasPermission>
                    <shiro:hasPermission name="product:update">
                        <a href="#" class="caozuo" onclick="click1(${g.id})">删除</a>
                    </shiro:hasPermission>
                </td>
            </tr>
        </c:forEach>
    </table>
    <script type="text/javascript">
       function click1(gid) {
           if(confirm("确定要删除吗？")){
               location.href="${pageContext.request.contextPath}/delete?gid="+gid;
           }
       }
    </script>
</body>
</html>
