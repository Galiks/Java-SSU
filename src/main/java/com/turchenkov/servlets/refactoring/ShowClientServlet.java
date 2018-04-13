package com.turchenkov.servlets.refactoring;

import com.turchenkov.dao.impl.TextDaoImpl;
import com.turchenkov.model.BankClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowClientServlet extends HttpServlet {

    private TextDaoImpl textDao;

    @Override
    public void init() throws ServletException {
        textDao = new TextDaoImpl("E:\\Загрузки\\turchenkov\\turchenkov\\Java-SSU\\AddClients.txt");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("showClients.jsp");
        List<BankClient> clients = textDao.read();
        req.setAttribute("clients", clients);
        dispatcher.forward(req, resp);
    }
}
