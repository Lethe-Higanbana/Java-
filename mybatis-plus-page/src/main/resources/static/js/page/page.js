$(function(){
    initTable();
});
function initTable() {
    //先销毁表格
    $("#bootstrapTable").bootstrapTable({
        //表格高度
        height: getHeight(),
        //服务器数据的请求方式 'get' 或 'post'。
        method: 'post',
        //这句必须加，不然后台获取不到前端传的参数
        contentType:'application/x-www-form-urlencoded; charset=UTF-8',
        //设置为 true 会有隔行变色效果
        striped: true,
        //设置为 true 会在表格底部显示分页条。
        pagination: true,
        //请求后台的URL
        url: '/users/page',
        //服务器返回的数据类型。
        dataType: 'json',
        //工具按钮用哪个容器
        toolbar: '#toolbar',
        //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性
        cache: false,
        //设置为 true 启用分页条无限循环的功能
        //paginationLoop: true,
        //设置在哪里进行分页，可选值为 'client' 或者 'server'。设置 'server'时，必须设置服务器数据地址（url）或者重写ajax方法
        sidePagination: 'server',
        //初始化加载第一页，默认第一页
        pageNumber: 1,
        //每页的记录行数
        pageSize: 10,
        //可供选择的每页的行数
        pageList: [10,15,20, 50, 100],
        //设置为false 将禁止所有列的排序。
        sortable: true,
        //设置默认排序为 name
        sortName: 'id',
        //定义排序方式，'asc' 或者 'desc'。
        sortOrder: "desc",
        //是否显示刷新按钮
        showRefresh: true,
        //是否显示内容列下拉框。
        showColumns: true,
        //显示导出插件
        showExport: true,
        //是否显示右上角的搜索框
        search: false,
        //是否显示切换视图（table/card）按钮。
        showToggle:false,
        //是否启用点击选中行
//         clickToSelect: true,
        //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder
        //设置为limit可以获取limit, offset, search, sort, order
        queryParamsType:'undefined',
        //请求服务器数据
        queryParams: function queryParams(params){
            var param = {
                pageNumber: params.pageNumber,
                pageSize: params.pageSize,
                sortName: params.sortName,
                sortOrder: params.sortOrder
            };
            return param;
        },
        //加载成功时执行
        onLoadSuccess: function(data){
            console.log("加载成功");
        },
        //加载失败时执行
        onLoadError: function(status){
            console.log("加载数据失败"+status);
        },
        columns: [
            {
                title: "全选",
                field: "select",
                checkbox: true,
                width: 20,//宽度
                align: "left",//水平
                valign: "middle",
                formatter: function (value, row, index) {
                    return row._id;
                }
            },
            /*{
                title: '编号',//标题  可不加
                align: 'center',
                valign: 'middle',
                sortable: false,
                formatter: function (value, row, index) {
                    return index+1;
                }*/
            {
                field: 'id',
                title: 'ID',
                align: 'center',

            },{
                field: 'names',
                title: '姓名',
                align: 'center',

            },{
                field: 'job',
                title: '职业',
                align: 'center',

            },{
                field: 'difficulty',
                title: '上手难度',
                align:"center",
            },{
                field: 'popularity',
                title: '人气',
                align:"center",
            }]
    });
}
//获取table的高度
function getHeight() {
    return $(window).height() - 100;
}