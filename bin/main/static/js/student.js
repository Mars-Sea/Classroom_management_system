window.onload = function(){
    $(document).ready(function(){
        /*表格分页 */
        $("#table").bootstrapTable({
            pagination:true,
            singleSelect:false,
            search:true,
            sidePagination:"client",
            striped:true,
            /*每页显示多少条数据 */
            pageSize:13,
            /*初始页码 */
            pageNumber:1,
            /*数组，单个不显示组合框  多个则显示可选择的组合框 */
            pageList:[13],
            columns: [{
                field:'sno',
                title: '学号'
            },{
                field:'sname',
                title: '姓名'
            },{
                field:'className',
                title: '班级名称'
            },{
                field:'absent',
                title: '旷课'
            },{ 
                field:'late',
                title: '迟到'
            },{
                field:'sleave',
                title: '请假'
            },{
                field:'poing',
                title: '平时加分'
            },{
                field:'general_comment',
                title: '总分'
            },{
                field:'caozuo',
                title: '操作'
            },]
        });
    });
}

/**保存选中学生的ID*/
var stusno = 0;
/**删除学生信息模态框*/
function stuDelete(data){   
    var modalsno = document.getElementById("modal-studelete-body-sno");
    var modalsname = document.getElementById("modal-studelete-body-sname");
    var getstuinfo = $("#"+data.name+" td");
    stuID = data.name;
    modalsno.innerHTML = "学号："+getstuinfo[0].innerHTML;
    modalsno.style.marginLeft = "30%";
    modalsname.innerHTML = "姓名："+getstuinfo[1].innerHTML;
    modalsname.style.marginLeft = "30%";
}
/**修改学生信息模态框*/
function stuAlter(data){
    var getstuinfo = $("#"+data.name+" td");
    stuID = data.name;
    var setstuinfo = $("#modal-stualter-body input");
    for(var i=0; i<setstuinfo.length-1;i++){
        setstuinfo[i].value = getstuinfo[i].innerHTML;
    }
    var coursename = document.getElementById("title");
    setstuinfo[setstuinfo.length-1].value = coursename.className; 
}

/*删除学生*/
function toStuDelete(data){
    $.ajax({
        type:"post",
        url:'/student/delete',
        data:{'stuid':stuID},
    });
    setTimeout(function(){location.reload();},300);
}

/**修改学生 */
function toStuAlter(data){
    var getstuinfo = $("#modal-stualter-body input");
    var stu = new Array();
    for(var i=0;i<getstuinfo.length;i++){
        stu[i] = getstuinfo[i].value;
    }
    $.ajax({
        type:"POST",
        url:'/student/alter',
        data:{'stuid':stuID,
        'sno':stu[0],
        'sname':stu[1],
        'sex':stu[2],
        'sabsent':stu[3],
        'slate':stu[4],
        'sleave':stu[5],
        'speacetime':stu[6],
        'sterminal':stu[7],
        'sclassname':stu[8],
        },
    });
    setTimeout(function(){location.reload();},300);
}