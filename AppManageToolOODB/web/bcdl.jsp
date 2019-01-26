<%-- 
    Document   : bcdl
    Created on : 05-Feb-2017, 19:20:50
    Author     : mikeo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*,bcdl.Branch"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Application Management Tools OODB</title>
  </head>
  <body>
    <table align="center">
      <tr>        
        <%
         List<Branch> query1 = (List<Branch>) request.getAttribute("branch");
         if (query1 != null) {
          for (Branch branch : query1) {
        %>
        <td>
          <table>
            <tr>
              <td rowspan="4">
                <img src="images/<%= branch.getbranchName()   %>" alt="">
              </td>
            </tr>
            <tr>
              <td>
                BranchCity:<b> <%= branch.getbranchCity()  %> </b>
              </td>
            </tr>
            <tr>
              <td>
                Assets :<b> <%= branch.getassets()  %> </b>
              </td>
            </tr>
            <tr>
              <td>
                Id:<b> <%= branch.getId()    %> </b>
              </td>
            </tr>
          </table>
        </td>
        <%
         }
        %>
        <%
         }
        %>
      </tr>
    </table>
    <form method="POST" action="BCDLServlet">
      <table align="center">
        <tr>
          <td colspan="2">
            Insert a new branch:
          </td>
        </tr>
        <tr>
          <td>
            branchname:
          </td>
        <td>
         <input type="text" name="branchname" />   
        <tr>
          <td>
            Assets:
          </td>
          <td>
            <input type="text" name="assets" />
          </td>
        </tr>
        <tr>
          <td>
            BranchCity:
          </td>
          <td>
            <input type="text" name="branchcity" />
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Add" />
          </td>
        </tr>
      </table>
    </form>
  </body>
</html>
