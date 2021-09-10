<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    isELIgnored="false"
    %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script defer src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" integrity="sha384-rOA1PnstxnOBLzCLMcre8ybwbTmemjzdNlILg8O7z1lUkLXozs4DHonlDtnE7fpc" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css"/>
    <script src="mais.js" defer></script>  
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <title>Document</title>
  <style>
   
   .logo__icon{
      position: relative;
      bottom: 12px;
      right: 20px;
      width: 85px;
    } 
    
    .login{
        position: relative;
        right: 55px;
    }

    .mypage{
        position: relative;
        right: 40px;
    }

    .alert{
        position: relative;
        right: 60px;
        top: 9px;    
    }
  </style>
  </head>
  
<body>

                                             <!-- <--Header--> 
   <div class="container" >
       <div class="row">
        <div class="col-lg-12">
            <nav class="navbar navbar-expand-lg navbar-light  ">
                <div class="container-fluid">
                    <div class="header__logo">
                        <img class="logo__icon" src="/imgs/logo.png" alt="brand logo"> 
                    </div>
                    <button class="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon btn-sm"></span>
                      </button>
                  <class class="collapse navbar-collapse " id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto ml-3 ">
                        <li class="nav-item">
                            <a class="nav-link fw-bold"style="font: small-caps bold 20px/1 sans-serif;" href="#">대회</a>
                          </li>
                      <li class="nav-item">
                        <a class="nav-link fw-bold" style="font: small-caps bold 20px/1 sans-serif;" href="#">공지사항</a>
                      </li>
                      <li class="nav-item">
                        <a class="nav-link fw-bold"style="font: small-caps bold 20px/1 sans-serif;">사이트 소개</a>
                      </li>
                    </ul>
                  </class>                        
                  
                                                 <!-- Sign Out--> 
<!--                         
                        <div class= "login">
                            <button type="button" class="btn btn-light btn-sm">Login</button>
                        </div> -->

                         
                                                     <!-- Sign In--> 
                        
                    <div class="alert" ><i class="far fa-bell fa-lg" style="color:#57CC99; "></i></div>                      
                                                             

                   <div class= "login">
                     <button type="button" class="btn btn-light btn-sm">Logout</button>
                   </div> 
                  
                   <div class= "mypage">
                     <button type="button" class="btn btn-light btn-sm">Mypage</button>
                   </div>                   
                      
                   <form class="d-flex">
                     <input class="form-control me-2 btn-sm rounded-pill " type="search" placeholder="Search" aria-label="Search">
                     <button class="btn btn-outline-success btn-sm "  type="submit">Search</button>
                   </form>
                      
                                                    
 
                    


                  </div>
                </div>
              </nav>

        </div>
       </div>
   </div>
    
</body>
</html>