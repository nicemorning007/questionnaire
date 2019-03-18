/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: myinformation.js
 * Author: NiceMorning
 */
layui.use(['form', 'jquery', 'layer'], function () {
    var form = layui.form;
    var $ = layui.$;
    var layer = layui.layer;
    var uid = $('#uid').val();

    $.ajax({
        type: 'GET',
        url: '/user/getInfo',
        data: {
            id: uid
        },
        success: function (result) {
            $('#username').val(result.data.username);
        }
    });

    $('#changePassword').click(function () {
        var password = $('#password').val();
        var confirm = $('#confirm').val();
        if (password.length > 0 && confirm.length > 0) {
            if (confirm != password) {
                layer.msg('密码不匹配，请确认两次输入的密码是否一致。');
            } else {
                $.ajax({
                    type: 'POST',
                    url: '/user/editpwd',
                    data: {
                        uid: uid,
                        password: $.md5(password)
                    },
                    success: function (reslut) {
                        layer.msg(reslut.msg, {icon: 0});
                    },
                    error: function (result) {
                        layer.msg('网络错误请重试', {icon: 0});
                    }
                })
            }
        }
    });

    $('#changeNickname').click(function () {
        var nickname = $('#nickname').val();
        if (nickname.length > 0) {
            $.ajax({
                type: 'POST',
                url: '/user/editInfo',
                data: {
                    uid: uid,
                    nickname: nickname
                },
                success: function (result) {
                    layer.msg(result.msg, {icon: 0});
                },
                error: function (result) {
                    layer.msg('网络错误请重试', {icon: 0});
                }
            })
        }
    });


});
