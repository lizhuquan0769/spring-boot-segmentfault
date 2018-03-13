package com.segmentfault.springboot.lession14.servlet;

import org.springframework.web.context.request.async.StandardServletAsyncWebRequest;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lizhuquan on 2018/3/13.
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();


        AsyncContext asyncContext = request.startAsync();
        StandardServletAsyncWebRequest asyncListener = new StandardServletAsyncWebRequest(request, response);
        asyncListener.addCompletionHandler(() -> {
            writer.println("completion handler");
            writer.flush();
        });
        asyncListener.addTimeoutHandler(() -> {
            writer.println("timeout handler");
            writer.flush();
        });
        asyncContext.addListener(asyncListener);

        asyncContext.start(() -> {
            try {
                writer.println("async context start");
                writer.flush();
                Thread.sleep(3000L);
                asyncContext.complete();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
