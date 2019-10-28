<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>登录界面</h2>
<style type="text/css">
    tr {
        height: 50px;
    }
    th{
        width: 120px;
        text-align: left;
    }
    td{
        width: 120px;
    }

</style>
<form method="post" action="${pageContext.request.contextPath}/login" enctype="application/x-www-form-urlencoded">
    <table>
        <tr>
            <th>用户名或邮箱：</th>
            <td>
                <input type="text" name="ue">
            </td>
        </tr>
        <tr>
            <th>密码：</th>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="登录">
                <input type="reset" value="取消">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
