package com.somelier.web;

import com.somelier.model.ViExpert;
import com.somelier.model.Vins;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "ViSelectionAction", value = "/ViSelectionAction")
public class ViSelectionAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Obtenim el color de vi que ha seleccionar l'usuari
        String color = request.getParameter("color");

        //Creem els vins
        ViExpert viExpert = new ViExpert();
        viExpert.AddVins(new Vins("Martin Green", "negre"));
        viExpert.AddVins(new Vins("Antinori", "rosat"));
        viExpert.AddVins(new Vins("Catena", "blanc"));
        viExpert.AddVins(new Vins("Penfolds", "rosat"));

        //Obtenim una llista amb les marques de vi del color seleccionat
        List<String> marques = viExpert.getMarques(color);

        //Imprimim l'HTML amb les marques de vi del color determinat
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println ("<HTML>");
        printWriter.println("<HEAD><link rel=\"stylesheet\" href=\"./src/main/webapp/style.css\"></HEAD>");
        printWriter.println ("<BODY>");
        printWriter.println ("<H1>Marques de Vi suggerides</H1>");
        printWriter.println("<div>");
        printWriter.println ("<p>Llista de marques de vins del tipus " + color + ": </p>");
        printWriter.println("<br>");
        printWriter.println("<ul>");
        for (String marca : marques) {
            printWriter.println("<li>" + marca + "</li>");
        }
        printWriter.println("</ul>");
        printWriter.println("</div>");
        printWriter.println ("</BODY>");
        printWriter.println ("</HTML>");
    }
}
