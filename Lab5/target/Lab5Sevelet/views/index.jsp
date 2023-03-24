<%@ page import="java.util.List" %>
<%@ page import="POJO.Product" %>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="org.hibernate.Session" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%if(request.getSession().isNew()) response.sendRedirect("./login");%>--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Danh sách sản phẩm</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body style="background-color: #f8f8f8">

<div class="container-fluid p-5">
    <div class="row mb-5">
        <div class="col-md-6">
            <h3>Product Management</h3>
        </div>
        <div class="col-md-6 text-right">
            <%
                List<Cookie> cookieList = Arrays.stream(request.getCookies()).filter(p->p.getName().equals("username")).collect(Collectors.toList());
                if (cookieList.size()>0){
                    request.setAttribute("username",cookieList.get(0).getValue());
                }else if(request.getSession().getAttribute("usernameSS")!=null){
                    request.setAttribute("username",request.getSession().getAttribute("usernameSS"));
                }
                else {
                    response.sendRedirect("./login");
                    return;
                }
            %>
            Xin chào <span class="text-danger"><%=request.getAttribute("username")%></span> | <a href="?logout=true">Logout</a>
        </div>
    </div>
    <div class="row rounded border p-3">
        <div class="col-md-4">
            <h4 class="text-success">Thêm sản phẩm mới</h4>
            <form class="mt-3" method="post"  action="./">
                <div class="form-group">
                    <label for="product-name">Tên sản phẩm</label>
                    <input class="form-control" type="text" placeholder="Nhập tên sản phẩm" id="product-name" name="name">
                </div>
                <div class="form-group">
                    <label for="price">Giá sản phẩm</label>
                    <input class="form-control" type="number" placeholder="Nhập giá bán" id="price" name="price">
                </div>
                <div class="form-group">
                    <button class="btn btn-success mr-2">Thêm sản phẩm</button>
                </div>
<%--                <div class="form-group">--%>
<%--                    <button class="btn btn-success mr-2">>Cập nhập</button>--%>
<%--                </div>--%>
                <div class="alert alert-danger">
                    Vui lòng nhập tên sản phẩm
                </div>
            </form>
        </div>
        <div class="col-md-8">
            <h4 class="text-success">Danh sách sản phẩm</h4>
            <p>Chọn một sản phẩm cụ thể để xem chi tiết</p>
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Thao tác</th>
                </tr>
                </thead>
                <tbody>
                <% List<Product> list = (List<Product>) request.getAttribute("list");
                   for (Product item : list){ %>
                <tr>
                    <td><%=item.getID()%></td>
                    <td><%=item.getName()%></td>
                    <td><%=item.getPrice()%></td>
                    <td><a href="#" id="delete" onclick="confirmRemoval(this)">Delete</a></td>
                </tr>
                <%
                    }
                 %>
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="confirm-removal-modal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <p>Bạn có chắc chắn muốn xóa  <strong id="producer-name"></strong>?</p>
            </div>
            <div class="modal-footer">

                <a id="a-delete" href="">Xóa</a>
                <button type="button" class="btn btn-default" data-dismiss="modal">Không</button>
            </div>
        </div>

    </div>
</div><!-- Confirm Removel modal -->
<script>
    $(document).ready(function ()  {
    // Add the following code if you want the name of the file appear on select
        $(".custom-file-input").on("change", function() {
            var fileName = $(this).val().split("\\").pop();
            $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
    });
    function confirmRemoval(btn) {
        let tds = $(btn).closest('tr').find('td')
        document.getElementById("producer-name").innerHTML = tds[1].innerText;
        // $('#delete-button').attr('uid', tds[0].innerHTML);
        $('#confirm-removal-modal').modal({ show: true });
        $("#a-delete").attr("href","?mode=delete&id=" + tds[0].innerText);
    }

</script>
</body>
</html>
