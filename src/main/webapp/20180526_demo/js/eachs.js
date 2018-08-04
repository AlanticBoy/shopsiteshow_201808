$(function () {
    var articles = [{"name": "fusong", "sex": "nan", "age": "20", "hobby": "run"},
        {"name": "fuyi", "sex": "nan", "age": "13", "hobby": "games"},
        {"name": "fufu", "sex": "nan", "age": "2", "hobby": "eat"}];
    //循环添加数据到table
    $.each(articles, function (index, article) {
        $("tbody").append($('<tr/>'))
            .append($('<td/>').html("<input id='check" + index + "' type='checkbox' />"))
            .append($('<td/>').html(article.name))
            .append($('<td/>').html(article.sex))
            .append($('<td/>').html(article.age))
            .append($('<td/>').html(article.hobby))
            .append($('<td/>').html("<button type='button' value='" + article.name + "'>修改</button>" +
                "<button type='button'  value='" + article.hobby + "'>删除</button>" +
                "<button type='button'  value='" + article.age + "'>查看</button>"));
    });

    $("tbody").find("tr").each(function () {
        alert($(this).find("td").first().html());
    });


    /*$("#bodies").find("button").click(function () {
     alert($(this).val());
     });*/
    $("#bodies").find("button").bind("click", function () {
        /* alert($(this).html());
         *$(this).html()，获取<html>里的值
         * $(this).val()，获取元素的值
         * */
        if ($(this).html() === "修改") {
            updateBtn($(this).val());
        }
        if ($(this).html() === "删除") {
            deleteBtn($(this).val())
        }
        if ($(this).html() === "查看") {
            viewBtn($(this).val())
        }
    });
    function updateBtn(val) {
        alert(" 修改  " + val)
    }

    function deleteBtn(val) {
        alert(" 删除  " + val)
    }

    function viewBtn(val) {
        alert(" 查看  " + val)
    }

    /*寻找table下td属性的方法*/
    $("#tabs").find("td").css({
        "text-align": "center",
        "width": "120px",
        "height": "5%"
    });
    $("#oper").css({
        "text-align": "center",
        "width": "280px",
        "height": "5%"
    });
})
;
