<%@page import="com.google.api.services.books.Books"%>
<%@page import="com.google.api.services.books.model.Volumes"%>
<%@page import="com.google.api.services.books.model.Volume"%>
<%@page import="com.google.api.services.books.Books.Volumes.List"%>
<%@page import="com.google.api.client.json.JsonFactory"%>
<%@page import="com.google.api.client.json.jackson2.JacksonFactory"%>
<%@page import="com.google.api.services.books.BooksRequestInitializer"%>
<%@page import="com.google.api.client.googleapis.javanet.GoogleNetHttpTransport"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
    </head>
    <body>        <form action="test.jsp" >
            <input type="text" name="query">
            <input type="submit"value="Search" name="btnSubmit">
        </form>
        <%
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            String query = request.getParameter("query");

            // Set up Books client.
            final Books books = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                    .setApplicationName("").setGoogleClientRequestInitializer(
                    new BooksRequestInitializer("AIzaSyBZ2GaZBjPw7lnVjON0YXbXQ-ttgv4Ez2Q"))
                    .build();
            out.print("<table border='1' >");
            out.print(" <tr><th>Title</th><th>Author</th>");
            // Set query string and filter only Google eBooks.
            List volumesList = books.volumes().list(query);

            // Execute the query.
            Volumes volumes = volumesList.execute();
            if (volumes.getTotalItems() == 0 || volumes.getItems() == null) {
                out.println("No matches found.");
                return;
            }

            // Output results.
            for (Volume volume : volumes.getItems()) {
                Volume.VolumeInfo volumeInfo = volume.getVolumeInfo();
                Volume.SaleInfo saleInfo = volume.getSaleInfo();
                out.println("<tr>");
                // Title.
                out.println("<td>" + volumeInfo.getTitle() + "</td>");
                // Author(s).
                java.util.List<String> authors = volumeInfo.getAuthors();
                out.print("<td> ");
                if (authors != null && !authors.isEmpty()) {

                    for (int i = 0; i < authors.size(); ++i) {
                        out.print(authors.get(i));
                        if (i < authors.size() - 1) {
                            out.print("</td>,<td> ");
                        }
                        out.print("");
                    }
                    out.println("</br>");
                }
            }
            out.println("==========");
            out.println("</table>");
        %>
        <%

        %>


    </body>
</html>