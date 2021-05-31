<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en"
	xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta charset="utf-8">
        <title>Veterinaria</title>
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <!-- Favicon -->
        <link href="img/favicon.ico" rel="icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400|Source+Code+Pro:700,900&display=swap" rel="stylesheet">

        <!-- CSS Libraries -->
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
        <link href="lib/slick/slick.css" rel="stylesheet">
        <link href="lib/slick/slick-theme.css" rel="stylesheet">

        <!-- Template Stylesheet -->
        <link href="css/style_theme_blue.css" rel="stylesheet">
        <style type="text/css">
        	.banner{
        		width:100%;
        		height:400px;
        	}
        	.img_card{
        		width:100%;
        		height:400px;
        	}
        </style>
    </head>
    <body>
        <!-- Top bar Start -->
		<jsp:include page="menuCliente.jsp"></jsp:include>
        <!-- Nav Bar End -->      
        
        
        
        <!-- Bottom Bar End -->       
        
        <!-- Main Slider Start -->
        <div class="header">
            <div class="container-fluid">
                <div class="row ml-5 mr-5">
                    <div class="col-md-12">
                        <div class="header-slider normal-slider">
                            <div class="header-slider-item">
                                <img src="img/banner1.jpg" class="banner" alt="Slider Image" />
                                <!-- <div class="header-slider-caption">
                                    <p>Some text goes here that describes the image</p>
                                    <a class="btn" href=""><i class="fa fa-shopping-cart"></i>Shop Now</a>
                                </div> -->
                            </div>
                            <div class="header-slider-item">
                                <img src="img/banner2.jpg" alt="Slider Image" class="banner"/>
                               
                            </div>
                            <div class="header-slider-item">
                                <img src="img/banner3.jpg" alt="Slider Image" class="banner" />
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Main Slider End -->      
        
        <!-- Brand Start -->
           <!-- <div class="brand">
            <div class="container-fluid">
                <div class="brand-slider">
                    <div class="brand-item"><img src="img/brand-1.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-2.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-3.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-4.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-5.png" alt=""></div>
                    <div class="brand-item"><img src="img/brand-6.png" alt=""></div>
                </div>
            </div>
        </div>
     Brand End -->      
        
       
        
        <!-- Category Start-->
        
        <!-- Category End-->       
        
        <!-- Call to Action Start -->
        <div class="call-to-action mt-3">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-md-6">
                        <h1>Llamanos</h1>
                    </div>
                    <div class="col-md-6">
                        <a href="tel:948111608">(+51) 948111608</a>
                    </div>
                </div>
            </div>
        </div>
        <!-- Call to Action End -->       
        <!-- Featured Product Start -->
        <div class="featured-product product">
            <div class="container-fluid">
                <div class="section-header">
                    <h1>Nuestro Productos</h1>
                </div>
                <div class="row align-items-center product-slider product-slider-4" id="ltProductos">
                
                    <c:forEach items="${sessionScope.LISTAPRODUCTOS}" var="item">
                    	<div class="col-lg-3">
	                        <div class="product-item">
	                            <div class="product-title">
	                                <a href="verDetalleProducto?id=">${item.nombre}</a>
	                                <div class="ratting">
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                </div>
	                            </div>
	                            <div class="product-image">
	                                <a href="verDetalleProducto?id=${item.idproducto}">
	                                    <img src="img/${item.foto1}" class="img_card" alt="Product Image">
	                                </a>
	                                <div class="product-action">
	                                    <!-- <a href="#"><i class="fa fa-cart-plus"></i></a>
	                                    <a href="#"><i class="fa fa-heart"></i></a> -->
	                                    <a href="verDetalleProducto?id=${item.idproducto}"><i class="fa fa-search"></i></a>
	                                </div>
	                            </div>
	                            <div class="product-price">
	                                <h3><span>S/. </span>${item.precio}</h3>
	                                <a class="btn" href="verDetalleProducto?id=${item.idproducto}"><i class="fa fa-shopping-cart"></i>Comprar</a>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                    
                    
                </div>
            </div>
        </div>
        <!-- Featured Product End -->       
        
        <!-- Newsletter Start -->
        <div class="newsletter">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-6">
                        <h1>Nuestros Servicios</h1>
                    </div>
                    <!--<div class="col-md-6">
                        <div class="form">
                            <input type="email" value="Your email here">
                            <button>Submit</button>
                        </div>
                    </div>  -->
                </div>
            </div>
        </div>
        <!-- Newsletter End -->        
        
        <!-- Recent Product Start -->
        <div class="recent-product product">
            <div class="container-fluid">
                <div class="section-header">
                    <h1>Nuestros Servicios</h1>
                </div>
                <div class="row align-items-center product-slider product-slider-4" id="ltServicios">
                    
                    <c:forEach items="${sessionScope.LISTASERVICIOS}" var="item">
                    	<div class="col-lg-3">
	                        <div class="product-item">
	                            <div class="product-title">
	                                <a href="verDetalleServicio?id=${item.idservicio}">${item.nombre}</a>
	                                <div class="ratting">
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                    <i class="fa fa-star"></i>
	                                </div>
	                            </div>
	                            <div class="product-image">
	                                <a href="verDetalleServicio?id=${item.idservicio}">
	                                    <img src="img/${item.foto}" class="img_card" alt="Product Image">
	                                </a>
	                                <div class="product-action">
	                                    <!-- <a href="#"><i class="fa fa-cart-plus"></i></a>
	                                    <a href="#"><i class="fa fa-heart"></i></a> -->
	                                    <a href="verDetalleServicio?id=${item.idservicio}"><i class="fa fa-search"></i></a>
	                                </div>
	                            </div>
	                            <div class="product-price">
	                                <h3><span>S/. </span>${item.precio}</h3>
	                                <a class="btn" href="verDetalleServicio?id=${item.idservicio}"><i class="fa fa-shopping-cart"></i>Solicitar</a>
	                            </div>
	                        </div>
	                    </div>
                    </c:forEach>
                    
                </div>
            </div>
        </div>
        <!-- Recent Product End -->
       
        <!-- Review End -->        
         <!-- Feature Start-->
        <div class="feature">
            <div class="container-fluid">
                <div class="row align-items-center">
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <i class="fab fa-cc-mastercard"></i>
                            <h2>Secure Payment</h2>
                            <p>
                                Lorem ipsum dolor sit amet consectetur elit
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <i class="fa fa-truck"></i>
                            <h2>Worldwide Delivery</h2>
                            <p>
                                Lorem ipsum dolor sit amet consectetur elit
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <i class="fa fa-sync-alt"></i>
                            <h2>90 Days Return</h2>
                            <p>
                                Lorem ipsum dolor sit amet consectetur elit
                            </p>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6 feature-col">
                        <div class="feature-content">
                            <i class="fa fa-comments"></i>
                            <h2>24/7 Support</h2>
                            <p>
                                Lorem ipsum dolor sit amet consectetur elit
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Feature End-->      
        <!-- Footer Start -->
        <div class="footer">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Get in Touch</h2>
                            <div class="contact-info">
                                <p><i class="fa fa-map-marker"></i>123 E Store, Los Angeles, USA</p>
                                <p><i class="fa fa-envelope"></i>email@example.com</p>
                                <p><i class="fa fa-phone"></i>+123-456-7890</p>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Follow Us</h2>
                            <div class="contact-info">
                                <div class="social">
                                    <a href=""><i class="fab fa-twitter"></i></a>
                                    <a href=""><i class="fab fa-facebook-f"></i></a>
                                    <a href=""><i class="fab fa-linkedin-in"></i></a>
                                    <a href=""><i class="fab fa-instagram"></i></a>
                                    <a href=""><i class="fab fa-youtube"></i></a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Company Info</h2>
                            <ul>
                                <li><a href="#">About Us</a></li>
                                <li><a href="#">Privacy Policy</a></li>
                                <li><a href="#">Terms & Condition</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6">
                        <div class="footer-widget">
                            <h2>Purchase Info</h2>
                            <ul>
                                <li><a href="#">Pyament Policy</a></li>
                                <li><a href="#">Shipping Policy</a></li>
                                <li><a href="#">Return Policy</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                
                <div class="row payment align-items-center">
                    <div class="col-md-6">
                        <div class="payment-method">
                            <h2>We Accept:</h2>
                            <img src="img/payment-method.png" alt="Payment Method" />
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="payment-security">
                            <h2>Secured By:</h2>
                            <img src="img/godaddy.svg" alt="Payment Security" />
                            <img src="img/norton.svg" alt="Payment Security" />
                            <img src="img/ssl.svg" alt="Payment Security" />
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer End -->
        
        <!-- Footer Bottom Start -->
        <div class="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 copyright">
                        <p>Copyright &copy; <a href="https://htmlcodex.com">HTML Codex</a>. All Rights Reserved</p>
                    </div>

                    <div class="col-md-6 template-by">
                        <p>Template By <a href="https://htmlcodex.com">HTML Codex</a></p>
                    </div>
                </div>
            </div>
        </div>
        <!-- Footer Bottom End -->       
        
        <!-- Back to Top -->
        <a href="#" class="back-to-top"><i class="fa fa-chevron-up"></i></a>
        
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
        
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/slick/slick.min.js"></script>
        
	    <script src="js/sweetalert2.min.js"></script>
        <script type="text/javascript" src="js/carrito_js.js"></script>
        <script type="text/javascript" src="js/verCarrito.js"></script>
        
        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>
    
    <script type="text/javascript">
    </script>
</html>
