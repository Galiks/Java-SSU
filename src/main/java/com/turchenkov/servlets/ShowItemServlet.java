package com.turchenkov.servlets;

import com.turchenkov.dao.ItemDAO;
import com.turchenkov.dao.database.ConnectDatabase;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowItemServlet extends HttpServlet {

    private ItemDAO dbDao = new ConnectDatabase();

//    private ItemDAO txtDao = new TxtDao("textFile.txt");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("showItems.jsp");
//        req.setAttribute("items", txtDao.getItems());
        req.setAttribute("items", dbDao.getItems());
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
