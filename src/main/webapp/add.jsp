<%--
  Created by IntelliJ IDEA.
  User: 海马哥
  Date: 2019/10/26
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
    <script src="${pageContext.request.contextPath}/jquery/jquery-2.2.4.js" type="text/javascript"></script>
</head>
<h2>添加商品</h2>
<style type="text/css">
    tr {
        height: 50px;
    }
    th {
        text-align: left;
    }
    input,select {
        height: 30px;
        width: 300px;
    }
    textarea {
        height: 100px;
        width: 300px;
    }
</style>
<body>
    <form id="ff" method="post"  enctype="multipart/form-data">
        <table style="width: 600px">
            <tr>
                <th>商品名称</th>
                <td>
                    <input type="text" name="goodsname">
                </td>
            </tr>
            <tr>
                <th>单价/500g</th>
                <td>
                    <input type="text" name="price"><b>￥</b>
                </td>
            </tr>
            <tr>
                <th>上架时间</th>
                <td>
                    <input type="date" name="upshelf">
                </td>
            </tr>
            <tr>
                <th>商品类别</th>
                <td>
                    <select name="typeid">
                        <option value="1">新鲜水果</option>
                        <option value="2">海洋水产</option>
                        <option value="3">猪牛羊肉</option>
                        <option value="4">禽类蛋品</option>
                        <option value="5">新鲜蔬菜</option>
                        <option value="6">速冻食品</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>热度</th>
                <td>
                    <select name="hot">
                        <option value="1">1星</option>
                        <option value="2">2星</option>
                        <option value="3">3星</option>
                        <option value="4">4星</option>
                        <option value="5">5星</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>副标题</th>
                <td>
                    <input type="text" name="subtitle">
                </td>
            </tr>
            <tr>
                <th>详情</th>
                <td>
                    <textarea name="introduce"></textarea>
                </td>
            </tr>
            <tr style="height: 120px">
                <th>略图jpg/png/gif</th>
                <td>
                    <img src="${pageContext.request.contextPath}/goods/moren.jpg" id="simg" style="height: 100px"/>
                    <input type="file" name="simg">
                </td>
            </tr>
            <tr>
                <th>大图jpg/png/gif</th>
                <td>
                    <img src="${pageContext.request.contextPath}/goods/moren.jpg" id="bimg" style="height: 100px"/>
                    <input type="file" name="bimg">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="reset" value="取消" id="quxiao" style="width: 100px">
                    <input type="button" value="添加" id="sbbt" style="width: 100px">
                    <input type="button" id="fanhui" value="返回" style="width: 100px" />
                </td>
            </tr>
        </table>
    </form>
</body>
<script type="text/javascript">
    $("#sbbt").click(function () {
        $("#sbbt").attr("disabled","true");
        $.ajax({
            url:"${pageContext.request.contextPath}/add",
            type:"post",
            data:new FormData(document.getElementById("ff")),//ff表示表单的id
            success:function(s){
                if(s[0]=="no"){
                    alert("图片格式不正确");
                    return false;
                }
                if(s[0].length != 0){
                    document.getElementById("simg").src="${pageContext.request.contextPath}/goods/"+s[0];
                }
                if(s[1].length != 0){
                    document.getElementById("bimg").src="${pageContext.request.contextPath}/goods/"+s[1];
                }
            },
            processData: false,//禁止编码请求参数
            contentType: false //不设置请求头
            }
        )
    });
    
    $("#fanhui").click(function () {
        location.href="${pageContext.request.contextPath}/goodsList";
    });
    $("#quxiao").click(function () {
        $("#sbbt").removeAttr("disabled");
    });
</script>
</html>
