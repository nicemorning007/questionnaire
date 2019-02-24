/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: myquestionnaire.js
 * Author: NiceMorning
 */
console.log('questionnaire.js');
layui.use(['table', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var uid = $('#uid').val();
    //我的问卷分页表格
    table.render({
        elem: '#myquestionnairestable'
        , height: 'full-200'
        , toolbar: '<h3>我的问卷</h3>'
        , url: '/questions/getAllQuestionnaireByUid?uid=' + uid //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'qname', title: '问卷名称', fixed: 'left'}
            , {field: 'qcount', title: '已有答卷数', width: 150, sort: true}
            , {field: 'operation', title: '操作', width: 300, toolbar: '#lineToolbar'}
        ]]
    });

    //监听事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'add':
                layer.msg('添加');
                break;
            case 'delete':
                layer.msg('删除');
                break;
        }
    });
});
