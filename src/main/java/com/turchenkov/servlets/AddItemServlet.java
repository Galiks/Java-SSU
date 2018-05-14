package com.turchenkov.servlets;

import com.turchenkov.dao.ItemDAO;
import com.turchenkov.dao.database.ConnectDatabase;
import com.turchenkov.model.Item;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {

    private ItemDAO dbDao = new ConnectDatabase();

//    private ItemDAO txtDao = new TxtDao("file.txt");

    private Item item;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("createItem.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int money = Integer.parseInt(req.getParameter("money"));

        item = new Item(name, money);

//        txtDao.addItem(item);

        dbDao.addItem(item);

        resp.sendRedirect("showItems");

        System.out.println("Add ITEM");
    }

    @Override
    public void init() throws ServletException {

    }
}
