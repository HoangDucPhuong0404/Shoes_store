<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../market/assets/favicon.ico" />
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../market/css/styles.css" rel="stylesheet" />
    <style>
        body {
            font-family: 'Roboto Condensed', sans-serif;
            background-color: #f5f5f5
        }

        .hedding {
            font-size: 20px;
            color: #ab8181`;
        }

        .main-section {
            position: absolute;
            left: 50%;
            right: 50%;
            transform: translate(-50%, 5%);
        }

        .left-side-product-box img {
            width: 100%;
        }

        .left-side-product-box .sub-img img {
            margin-top: 5px;
            width: 83px;
            height: 100px;
        }

        .right-side-pro-detail span {
            font-size: 15px;
        }

        .right-side-pro-detail p {
            font-size: 25px;
            color: #a1a1a1;
        }

        .right-side-pro-detail .price-pro {
            color: #E45641;
        }

        .right-side-pro-detail .tag-section {
            font-size: 18px;
            color: #5D4C46;
        }

        .pro-box-section .pro-box img {
            width: 100%;
            height: 200px;
        }

        @media (min-width:360px) and (max-width:640px) {
            .pro-box-section .pro-box img {
                height: auto;
            }
        }
    </style>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="http://localhost:8080/home?action=market">Pegasus Store</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="http://localhost:8080/home?action=market">Home</a></li>
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="http://localhost:8080/home?action=list">Dashboard</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">All Products</a></li>
                        <li><hr class="dropdown-divider" /></li>
                        <li><a class="dropdown-item" href="#!">Popular Items</a></li>
                        <li><a class="dropdown-item" href="#!">New Arrivals</a></li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <button class="btn btn-outline-dark" type="submit">
                    <i class="bi-cart-fill me-1"></i>
                    Cart
                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                </button>
            </form>
        </div>
    </div>
</nav>
<!-- Header-->
<header class="bg-dark py-5" style="background-image: url(https://images.footlocker.com/content/dam/final/footlockercanada/site/backpages/20200324-brand-asp-m-nike.jpg)">
    <div class="container px-4 px-lg-5 my-5" >

        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Pegasus</h1>
            <p class="lead fw-normal text-white-50 mb-0">Always by your side !</p>
        </div>
    </div>
</header>
<!-- Section-->
<div class="container">
    <div class="col-lg-8 border p-3 main-section bg-white">
        <div class="row hedding m-0 pl-3 pt-0 pb-3">
            Product detail
        </div>
        <div class="row m-0">
            <div class="col-lg-4 left-side-product-box pb-3">
                <img src="${productExist.image}" class="border p-3">
<%--                <span class="sub-img">--%>
<%--                    <img src="http://nicesnippets.com/demo/pd-image2.jpg" class="border p-2">--%>
<%--                    <img src="http://nicesnippets.com/demo/pd-image3.jpg" class="border p-2">--%>
<%--                    <img src="http://nicesnippets.com/demo/pd-image4.jpg" class="border p-2">--%>
<%--                </span>--%>
            </div>
            <div class="col-lg-8">
                <div class="right-side-pro-detail border p-3 m-0">
                    <div class="row">
                        <div class="col-lg-12">
                            <span>Who What Wear</span>
                            <p class="m-0 p-0">${productExist.name}</p>
                        </div>
                        <div class="col-lg-12">
                            <p class="m-0 p-0 price-pro">${productExist.price}$</p>
                            <hr class="p-0 m-0">
                        </div>
                        <div class="col-lg-12 pt-2">
                            <h5>Product Detail</h5>
                            <span>${productExist.description}</span>
                            <hr class="m-0 pt-2 mt-2">
                        </div>
                        <div class="col-lg-12">
                            <p class="tag-section"><strong>Tag : </strong><a href="http://localhost:8080/home?action=market">${productExist.title}</a><a href="">,Man</a></p>
                        </div>
                        <div class="col-lg-12">
                            <h5>Brand :  ${productExist.category} </h5>
                            <h5>Available : ${productExist.quantity} </h5>
                            <h6>Quantity :</h6>
                            <input type="number" class="form-control text-center w-100" value="0">
                        </div>
                        <div class="col-lg-12 mt-3">
                            <div class="row">
                                <div class="col-lg-6 pb-2">
                                    <a href="#" class="btn btn-danger w-100">Add To Cart</a>
                                </div>
                                <div class="col-lg-6">
                                    <a href="#" class="btn btn-success w-100">Shop Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center pt-3">
                <h4>More Product</h4>
            </div>
        </div>


        <div class="row mt-3 p-0 text-center pro-box-section">
            <c:forEach items='${requestScope["productList"]}' var="items">
            <div class="col-lg-3 pb-2">
                <div class="pro-box border p-0 m-0">
                    <a href="http://localhost:8080/home?action=detail&id=${items.id}">
                    <img src="${items.image}">
                    </a>
                </div>
            </div>
            </c:forEach>
        </div>


    </div>
</div>
<!-- Footer-->
<%--<footer class="py-5 bg-dark"  style="background-color: orangered !important;" >--%>
<%--    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>--%>
<%--</footer>--%>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
