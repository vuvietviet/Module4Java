function checkEdit() {
    let fileImg = document.getElementById("imgEdit").files;
    if (fileImg.length === 0){
        editNoUpFile();
    }else {
        editYesUpFile()
    }
}


function getEdit(id) {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/blogs/" + id,
        //xử lý khi thành công
        success: function (data) {
            showEdit(data);
        },
        error: function (err) {
            console.log(err)
        }
    })

}

function showEdit(blog) {
    document.getElementById("titleEdit").value = blog.title;
    document.getElementById("contentEdit").value = blog.content;
    document.getElementById("dateEdit").value = blog.date;
    document.getElementById("idCategoryEdit").value = blog.category.id;
    document.getElementById("imageEdit").src = blog.img;
    document.getElementById("id").value = blog.id;
}

function editNoUpFile() {
    let id = $("#id").val();
    let title = $("#titleEdit").val();
    let content = $("#contentEdit").val();
    let date = $("#dateEdit").val();
    let idCategory = $("#idCategoryEdit").val();
    let img = document.getElementById("imageEdit").src;
    let blog = {
        id: id,
        title: title,
        content: content,
        date: date,
        img: img,
        category: {
            id: idCategory
        }
    }
    callEdit(blog);

}

function callEdit(blog){
    $.ajax({
        type: "PUT",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/blogs",
        data: JSON.stringify(blog),
        //xử lý khi thành công
        success: function (data) {
            getData();
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function editYesUpFile() {
    let id = $("#id").val();
    let title = $("#titleEdit").val();
    let content = $("#contentEdit").val();
    let date = $("#dateEdit").val();
    let idCategory = $("#idCategoryEdit").val();
    let fileImg = document.getElementById("imgEdit").files;
    let formData = new FormData();
    formData.append("file", fileImg[0]);
    $.ajax({
        contentType: false,
        processData: false,
        type: "POST",
        data: formData,
        url: "http://localhost:8080/blogs/upImg",
        success: function (data) {
            let blog = {
                id: id,
                title: title,
                content: content,
                date: date,
                img: data,
                category: {
                    id: idCategory
                }
            }
            callEdit(blog)
        }
    });
}