<%--
  Created by IntelliJ IDEA.
  User: dariyazhukova
  Date: 20.11.2023
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Procedure list</title>
  <%@include file="component/allcss.jsp"%>
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
    }

    body {
      font-family: Arial, sans-serif;
      font-size: 16px;
      line-height: 1.5;
      color: #333;
    }

    header {
      background-color: #f2f2f2;
      padding: 10px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    nav ul {
      list-style: none;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }

    nav li a {
      text-decoration: none;
      color: #333;
      padding: 10px;
      border-radius: 5px;
      transition: all 0.3s ease-in-out;
    }

    nav li a:hover {
      background-color: #333;
      color: #fff;
    }

    main {
      max-width: 1200px;
      margin: 0 auto;
      padding: 20px;
    }

    h2 {
      font-size: 32px;
      font-weight: bold;
      text-align: center;
      margin-bottom: 30px;
    }

    .boxes {
      display: flex;
      flex-wrap: wrap;
      justify-content: center;
      align-items: stretch;
    }

    .box {
      background-color: #fff;
      border: 1px solid #ccc;
      border-radius: 5px;
      padding: 20px;
      margin: 10px;
      flex-basis: calc(33.33% - 20px);
      text-align: center;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
      transition: all 0.3s ease-in-out;
    }

    .box:hover {
      transform: translateY(-5px);
      box-shadow: 0 5px 10px rgba(0,0,0,0.2);
    }

    .box img {
      max-width: 100%;
      height: auto;
      margin-bottom: 10px;
    }

    .box p {
      font-size: 18px;
      margin-bottom: 10px;
    }

    footer {
      background-color: #333;
      color: #fff;
      padding: 10px;
      text-align: center;
      box-shadow: 0 -2px 5px rgba(0,0,0,0.1);
    }

    footer p {
      font-size: 14px;
      font-style: italic;
    }

    .home-button {
      position: initial;
      top: 10px;
      right: 10px;
      font-size: 20px;
      text-decoration: none;
      color: #333;
    }

    .empty-line {
      margin-bottom: 10px;
    }
  </style>
</head>
<body>
<%@include file="component/navbar.jsp"%>
<p class="empty-line"></p>
<a href="/SemestrWork1/personalAccount" class="home-button">
  <i class="fa-solid fa-house"></i> Home
</a>

<main>
  <section>
    <h2>Catalog of services</h2>
    <div class="boxes">
      <div class="box">
        <img src="img/tooth/tooth1.jpg" alt="procedure1">
        <p><strong>Treatment of pulpitis</strong></p>
        <p>Price: 5 000</p>
        <p>Duration: 20 minutes</p>
        <p>Doctor: Benjamin Taylor</p>
        </div>
      <div class="box">
        <img src="img/tooth/tooth2.jpg" alt="procedure2">
        <p><strong>Treatment of dental caries</strong></p>
        <p>Price: 4 000</p>
        <p>Duration: 30 minutes</p>
        <p>Doctor: Benjamin Taylor</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth3.jpg" alt="procedure3">
        <p><strong>Treatment of periodontitis</strong></p>
        <p>Price: 4 500</p>
        <p>Duration: 35 minutes</p>
        <p>Doctor: Benjamin Taylor</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth4.jpg" alt="procedure4">
        <p><strong>Installation of veneers</strong></p>
        <p>Price: 500 000</p>
        <p>Duration: 2 hours</p>
        <p>Doctor: Lucas Martin</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth5.jpg" alt="procedure5">
        <p><strong>Installation of "Star Smile" aligners</strong></p>
        <p>Price: 150 000</p>
        <p>Duration: 2 hours</p>
        <p>Doctor: Lucas Martin</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth6.jpg" alt="procedure6">
        <p><strong>Installing braces "Damon"</strong></p>
        <p>Price: 300 000</p>
        <p>Duration: 2 hours</p>
        <p>Doctor: Lucas Martin</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth7.jpg" alt="procedure7">
        <p><strong>Production of crowns from zirconium dioxide</strong></p>
        <p>Price: 50 000</p>
        <p>Duration: 1 hour</p>
        <p>Doctor: Emily Parker</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth8.jpg" alt="procedure8">
        <p><strong>Production of ceramic tabs</strong></p>
        <p>Price: 35 000</p>
        <p>Duration: 1 hour 15 minutes</p>
        <p>Doctor: Emily Parker</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth9.jpg" alt="procedure9">
        <p><strong>Manufacture of metal-ceramic crowns</strong></p>
        <p>Price: 40 000</p>
        <p>Duration: 45 minutes</p>
        <p>Doctor: Emily Parker</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth10.jpg" alt="procedure10">
        <p><strong>Tooth extraction surgery</strong></p>
        <p>Price: 50 000</p>
        <p>Duration: 1 hour</p>
        <p>Doctor: Samantha Lee</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth11.jpg" alt="procedure11">
        <p><strong>Plasmolifting</strong></p>
        <p>Price: 20 000</p>
        <p>Duration: 25 minutes</p>
        <p>Doctor: Samantha Lee</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth12.jpg" alt="procedure12">
        <p><strong>Plastic surgery of the frenulum of the tongue and lips</strong></p>
        <p>Price: 15 000</p>
        <p>Duration: 30 minutes</p>
        <p>Doctor: Samantha Lee</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth13.jpg" alt="procedure13">
        <p><strong>Bone grafting</strong></p>
        <p>Price: 75 000</p>
        <p>Duration: 2 hours</p>
        <p>Doctor: Jacob Brown</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth14.jpg" alt="procedure14">
        <p><strong>Sinus lifting</strong></p>
        <p>Price: 150 000</p>
        <p>Duration: 1 hour 25 minutes</p>
        <p>Doctor: Jacob Brown</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth15.jpg" alt="procedure15">
        <p><strong>Installation of dental implants</strong></p>
        <p>Price: 90 000</p>
        <p>Duration: 1 hour 55 minutes</p>
        <p>Doctor: Jacob Brown</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth16.jpg" alt="procedure16">
        <p><strong>Treatment of stomatitis</strong></p>
        <p>Price: 6 000</p>
        <p>Duration: 20 minutes</p>
        <p>Doctor: Olivia Davis</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth17.jpg" alt="procedure17">
        <p><strong>Correction of bite</strong></p>
        <p>Price: 10 000</p>
        <p>Duration: 30 minutes</p>
        <p>Doctor: Olivia Davis</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth18.jpg" alt="procedure18">
        <p><strong>Help with teething</strong></p>
        <p>Price: 1 500</p>
        <p>Duration: 20 minutes</p>
        <p>Doctor: Olivia Davis</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth19.jpg" alt="procedure19">
        <p><strong>Removal of dental stones</strong></p>
        <p>Price: 15 000</p>
        <p>Duration: 40 minutes</p>
        <p>Doctor: Grace Roberts</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth20.jpg" alt="procedure20">
        <p><strong>Sanitation of the oral cavity</strong></p>
        <p>Price: 10 000</p>
        <p>Duration: 35 minutes</p>
        <p>Doctor: Grace Roberts</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth21.jpg" alt="procedure21">
        <p><strong>Prosthetics of teeth</strong></p>
        <p>Price: 50 000</p>
        <p>Duration: 1 hour</p>
        <p>Doctor: Grace Roberts</p>
      </div>

      <div class="box">
        <img src="img/tooth/tooth22.jpg" alt="procedure22">
        <p><strong>Hygienic cleaning</strong></p>
        <p>Price: 25 000</p>
        <p>Duration: 25 minutes</p>
        <p>Doctor: Michael Johnson</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth23.jpg" alt="procedure23">
        <p><strong>Sealing of the chewing surface</strong></p>
        <p>Price: 15 000</p>
        <p>Duration: 20 minutes</p>
        <p>Doctor: Michael Johnson</p>
      </div>
      <div class="box">
        <img src="img/tooth/tooth24.jpg" alt="procedure24">
        <p><strong>Individual selection of oral hygiene and protection products</strong></p>
        <p>Price: 2 000</p>
        <p>Duration: 15 minutes</p>
        <p>Doctor: Michael Johnson</p>
      </div>

    </div>
  </section>
</main>

<%--<list procedurelist as procedure>--%>
<%--<fieldset>--%>
<%--  <legend>${procedure.name}</legend>--%>
<%--  <div>Name: ${procedure.name}</div>--%>
<%--  <div>Price: ${procedure.price}</div>--%>
<%--  <div>Time: ${procedure.time}</div>--%>
<%--  <div>--%>
<%--    <form method="post" action="/SemestrWork1/procedureList">--%>
<%--      <input type="hidden" name="procedurename" value="${procedure.name}">--%>
<%--      <input type="submit" value="Select">--%>
<%--    </form>--%>
<%--  </div>--%>
<%--</fieldset>--%>
<%--</list>--%>
<%@include file="component/footer.jsp"%>
</body>
</html>
