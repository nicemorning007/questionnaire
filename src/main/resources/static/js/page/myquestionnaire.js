/*
 * Copyright (c) 2019. All Rights Reserved.
 * FileName: myquestionnaire.js
 * Author: NiceMorning
 */
layui.use(['table', 'jquery'], function () {
    var table = layui.table;
    var $ = layui.jquery;
    var uid = $('#uid').val();
    //我的问卷分页表格
    table.render({
        elem: '#myquestionnairestable'
        , height: 'full'
        , toolbar: '<h3>我的问卷</h3>'
        , url: '/questions/getAllQuestionnaireByUid?uid=' + uid //数据接口
        , page: true //开启分页
        , cols: [[ //表头
            {field: 'qname', title: '问卷名称', fixed: 'left'}
            , {field: 'qcount', title: '已有答卷数', width: 150, sort: true}
            , {field: 'operation', title: '操作', width: 300, toolbar: '#lineToolbar'}
        ]]
    });

    table.on('row(myquestionnairestable)', function (obj) {
        var data = obj.data;
        console.log(data);
    });

    table.on('tool(myquestionnairestable)', function (obj) {
        var data = obj.data;
        if (obj.event === 'check') {
            layer.msg('ID：' + data.id + ' 的查看操作');
        } else if (obj.event === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del();
                layer.close(index);
            });
        }
    })

});
