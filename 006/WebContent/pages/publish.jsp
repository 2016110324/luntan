<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>发表</title>
    <style>
        form {
            margin: 0;
        }
        textarea {
            display: block;
        }
    </style>
    <link rel="stylesheet" href="../default/default.css" />
    <script charset="utf-8" src="../js/kindeditor-min.js"></script>
    <script charset="utf-8" src="../js/zh_CN.js"></script>
    <script>
        var editor;
        KindEditor.ready(function(K) {
            editor = K.create('textarea[name="content2"]', {
                resizeType : 1,
                allowPreviewEmoticons : false,
                allowImageUpload : false,
                items : [
                    'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
                    'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
                    'insertunorderedlist', '|', 'emoticons', 'image', 'link'],
                allowFileManager : true,
                afterCreate : function() {
                    var self = this;
                    K.ctrl(document, 13, function() {
                        self.sync();
                        document.forms['publish'].submit();
                    });
                    K.ctrl(self.edit.doc, 13, function() {
                        self.sync();
                        document.forms['publish'].submit();
                    });
                }
            });
        });
    </script>
</head>
<body>
<div class="publish-content">

    <form name="publish" method="post" action="/publish.action">
        <div class="publish-title">
            类型：<input type="text" name="infopublishtype">
        </div>
        <div class="publish-title">
            主题：<input type="text" name="infopublishtitle">
        </div>
        <textarea name="content2" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"><%=htmlspecialchars(publishDate)%></textarea><br/>
        <input type="submit" name="button" value="提交内容" />
    </form>
</div>

</body>
</html>
<%!
    String publishDate="";
    private String htmlspecialchars(String str) {
        str = str.replaceAll("&", "&amp;");
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        str = str.replaceAll("\"", "&quot;");
        return str;
    }
%>
