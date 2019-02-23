/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: userCenter.js
 * Author: NiceMorning
 */
layui.use(['element', 'jquery'], function () {
    var element = layui.element;
    var $ = layui.jquery;
    var uid = $('#uid').val();
    /**
     * 通过uid获取该用户所拥有的问卷数。
     */
    $.ajax({
        type: 'GET',
        url: '/questions/getCountByUid?uid=' + uid,
        success: function (result) {
            $('#count').html(result.count);
        }
    });

});
