getData();

function create(data) {
    let title = $("#title").val();
    let content = $("#content").val();
    let date = $("#date").val();
    let idCategory = $("#idCategory").val();
    let blog = {
        title: title,
        content: content,
        date: date,
        img: data,
        category: {
            id: idCategory
        }
    }
    $.ajax({
        type: "POST",
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

function getData() {
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/blogs",
        //xử lý khi thành công
        success: function (data) {
            console.log("data")
            console.log(data)
            showData(data.content);
        },
        error: function (err) {
            console.log(err)
        }
    })
}

function showData(data) {
    let str = "";
    for (const d of data) {
        str += ` 
       
                    <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.2s" data-wow-duration="1000ms" >
                        <div class="row align-items-center">
                            <div class="col-12 col-md-6">
                                <div class="single-blog-thumbnail">
                                    <img src="${d.img}" alt="">
                                    <div class="post-date">
                                        <a href="#">12 <span>march</span></a>
                                    </div>
                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <!-- Blog Content -->
                                <div class="single-blog-content">
                                    <div class="line"></div>
                                    <a href="#" class="post-tag">${d.title}</a>
                                    <h4><a href="#" class="post-headline">Party people in the house</a></h4>
                                    <p>${d.content}</p>
                                    <div class="post-meta">
                                        <p>By <a href="#">${d.date}</a></p>
                                        <p>3 comments</p>
                                    </div>
                                    <button type="button" class="btn btn-warning"  data-toggle="modal" data-target="#myModalEdit" onclick="getEdit(${d.id})">Edit</button>
                                    <button type="button" class="btn btn-danger" onclick="deleteBlog(${d.id})">Delete</button>
                                </div>
                            </div>
                        </div>
                    </div>
                `;
    }

    document.getElementById("show").innerHTML = str;
}


function uploadFile() {
    let fileImg = document.getElementById("img").files;
    if (fileImg.length === 0) {
        alert("Doesn't up image!");
        return;
    }
    let formData = new FormData();
    formData.append("file", fileImg[0]);
    $.ajax({
        contentType: false,
        processData: false,
        type: "POST",
        data: formData,
        url: "http://localhost:8080/blogs/upImg",
        success: function (data) {
            create(data);
        }
    });
}

function deleteBlog(id) {
    confirm("Do you want to delete?") ?
        $.ajax({
            type: "DELETE",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            url: "http://localhost:8080/blogs/" + id,
            //xử lý khi thành công
            success: function (data) {
                getData();
            },
            error: function (err) {
                console.log(err)
            }
        }) : ""
}


function searchBlog() {
    let search = document.getElementById("searchBlog").value;
    console.log(search)
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/blogs/search?title=" + search,
        //xử lý khi thành công
        success: function (data) {
            showData(data);
        },
        error: function (err) {
            console.log(err)
        }
    })

}