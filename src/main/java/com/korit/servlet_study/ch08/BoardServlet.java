package com.korit.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ch08/boards")
public class BoardServlet extends HttpServlet {
    private List<Board> boardList = new ArrayList<>();

    Response response = new Response("게시글 작성완료");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
        BufferedReader br = req.getReader();
        ObjectMapper om = new ObjectMapper();
        StringBuilder json = new StringBuilder();


//        while (true) {
//            String str = br.readLine();
//            if (str == null) {
//                break;
//            }
//            json.append(str);
//
//        }

        Board aa = om.readValue(req.getReader(), Board.class);

        System.out.println(aa);
        boardList.add(aa);

        om.writeValue(resp.getWriter(), response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        ObjectMapper om2 = new ObjectMapper();
        om2.writeValue(resp.getWriter(), boardList);
    }
}
