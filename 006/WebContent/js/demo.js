$(function(){
    $(".register-dialog").dialog({
        title:"用户注册",
        modal:true,
        autoOpen:false,
        draggable:true,
        resizable:false,//弹出框大小不能修改
        show:{effect:"slideDown",duration:"normal"},
        hide:{effect:"slideUp",duration:"fast"},
        buttons:{
            注册: function(){
                var name = $("#username").val();
                var phone =$("#userephone").val();
                var email=$("#useremail").val();
                var pwd1=$("#userpwd1").val();
                var pwd2=$("#userpwd2").val();
                if(pwd1!=pwd2){
                    $(".tps").html("密码不一致！");
                }else {
                    $.post("./register.action",{"username":name,"userphone":phone,"useremail":email,"userpwd":pwd1},function(result){
                        if(result=="true"){
                            $(".register-dialog").dialog("close");
                            $("#username").val("");
                            $("#userephone").val("");
                            $("#useremail").val("");
                            $("#userpwd1").val("");
                            $("#userpwd2").val("");
                            $(".tps").html("");
                        }else {
                            $(".tps").html(result);
                        }
                    });
                }
            },
            取消: function(){
                $("#username").val("");
                $("#useremail").val("");
                $("#useremail").val("");
                $("#userpwd1").val("");
                $("#userpwd2").val("");
                $(".tps").html("");
                $(".register-dialog").dialog("close");
            }
        }
    });
    $("#btn-register").click(function(){
        if($(this).html()=="注册") {
            $(".register-dialog").dialog("open");
        }
    });
    $(".login-dialog").dialog({
        title:"用户登录",
        modal:true,
        autoOpen:false,
        resizable:false,
        draggable:false,//固定
        show:{effect:"slideDown",duration:"normal"},
        hide:{effect:"slideUp",duration:"fast"},
        position:{my:"right top",of:"#btn-login",at:"right bottom"},//定位
        buttons:{
            登录: function(){
                var loginname = $("#loginname").val();
                var loginpwd =$("#loginpwd").val();
                $.post("./login.action",{"loginname":loginname,"loginpwd":loginpwd},function(result){
                    if(result=="true"){

                        $("#loginpwd").val("");
                        $("#loginname").val("");
                        $(".tps").html("");
                        $("#btn-register").html("用户："+loginname);
                        $("#btn-register").unbind();
                        $("#btn-publish").html("发帖");
                        $("#btn-login").html("退出登录");
                        //$(location).attr('href', '?id='+loginname);
                        $(".login-dialog").dialog("close");
                    }else {
                        $(".tps").html(result);
                    }
                });
            },
            取消: function(){

                $(".tps").html("");
                $("#loginpwd").val("");
                $("#loginname").val("");
                $(".login-dialog").dialog("close");
            }
        }
    });
    $("#btn-login").click(function(){
        if($(this).html()=="登录"){
            $(".login-dialog").dialog("open");
        }

    });
    $(".avator").tooltip({//工具提示框
        items:"img",
        content:function(){
            return "<img class='avator-tooltip' src='"+$(this).attr('src')+"' alt='"+$(this).attr('alt')+"'>'"
        },
        position:{my:"left+40 center",at:"right center"}
    });
});