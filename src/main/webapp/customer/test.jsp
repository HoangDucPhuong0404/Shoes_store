<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="#!">Pegasus Store</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
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
<section class="py-5">

    <div class="container px-4 px-lg-5 mt-5">
<c:forEach items='${requestScope["productList"]}' var="items">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top" src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/03525dbc-a139-4063-8ffb-8ebec04c599d/mercurial-vapor-14-elite-fg-football-boots-GzzgK8.png" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${items.name}</h5>
                            <!-- Product price-->
                            $40.00 - $80.00
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                    </div>
                </div>
            </div>
            </c:forEach>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/e1246d73-d232-4b83-8933-0e92794c6def/phantom-gt2-dynamic-fit-elite-fg-football-boots-c2H8s5.png" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Special Item</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$20.00</span>--%>
<%--                            $18.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/7a9f7c81-c47f-4d3f-89e9-25f8c078f4a1/phantom-gt2-club-mg-multi-ground-football-boots-8tZ2r8.png" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Sale Item</h5>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$50.00</span>--%>
<%--                            $25.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://static.nike.com/a/images/t_PDP_864_v1/f_auto,b_rgb:f5f5f5/b984bad8-5b2a-4c14-8c19-ddb55c7cdec1/mercurial-vapor-14-academy-mg-multi-ground-football-boot-tPZz5n.png" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Popular Item</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            $40.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://static.nike.com/a/images/t_PDP_864_v1/5ef8fcbf-d1a9-4eb5-b822-4a5ab1e60100/mercurial-vapor-14-club-fg-mg-multi-ground-football-boots-t74W26.png" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Sale Item</h5>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$50.00</span>--%>
<%--                            $25.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/9c56ae5f-9876-44cf-b8ea-637e20f5213f/custom-nike-mercurial-superfly-8-academy-by-you.png" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Fancy Product</h5>--%>
<%--                            <!-- Product price-->--%>
<%--                            $120.00 - $280.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/cb8f2d5203f643ae8646ad8300c462cf_9366/Gamemode_Knit_Firm_Ground_Soccer_Cleats_Pink_GW8524_01_standard.jpg" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Special Item</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$20.00</span>--%>
<%--                            $18.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top" src="https://images.puma.com/image/upload/f_auto,q_auto,b_rgb:fafafa,w_600,h_600/global/106787/01/sv01/fnd/EEA/fmt/png/FUTURE-1.3-Glow-FG/AG-Men's-Football-Boots" alt="..." />--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Popular Item</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            $40.00--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark"  style="background-color: orangered !important;" >
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="js/scripts.js"></script>
</body>
</html>
