//window.onload = function(){
//    $(document).ready(function(){
//        /*表格分页 */
//        $("#table").bootstrapTable({
//            pagination:true,
//            singleSelect:false,
//            search:true,
//            sidePagination:"client",
//            striped:true,
//            /*每页显示多少条数据 */
//            pageSize:13,
//            /*初始页码 */
//            pageNumber:1,
//            /*数组，单个则不显示组合框  多个则显示可选择的组合框 */
//            pageList:[13],
//            columns: [{
//                field:'sno',
//                title: '学号'
//            },{
//                field:'sname',
//                title: '姓名'
//            },{
//                field:'sex',
//                title: '性别'
//            },{
//                field:'sabsent',
//                title: '旷课'
//            },{ 
//                field:'slate',
//                title: '迟到'
//            },{
//                field:'sleave',
//                title: '请假'
//            },{
//                field:'speacetime',
//                title: '平时成绩'
//            },{
//                field:'sterminal',
//                title: '期末成绩'
//            },{
//                field:'sclassname',
//                title: '班级名称'
//            },{
//                field:'caozuo',
//                title: '操作'
//            },]
//        });
//    });
//}

/**删除学生信息*/
function stuDelete(data){
   var modalbody = document.getElementById("modal-studelete-body");
   modalbody.innerHTML = "学号:"+data.title+"　姓名："+data.name;
}
/**修改学生信息 */
function stuAlter(data){
    var getstuinfo = $("#"+data.title+" td");
    var setstuinfo = $("#modal-stualter-body form input");
    for(var i=0; i<setstuinfo.length;i++){
        setstuinfo[i].value = getstuinfo[i].innerHTML;
    }
}