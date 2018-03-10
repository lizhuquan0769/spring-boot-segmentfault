package com.segmentfault.springboot.lession13.servserendpoint;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lizhuquan on 2018/3/10.
 */
@ServerEndpoint(value = "/chat-room/{username}")
public class ChatRoomServerEndpoint {

    /**
     * 一个ws session对应一个server endpoint, 所以这个变量要设置为static才能共享
     */
    private static Map<String, Session> livingSessions = new ConcurrentHashMap<String, Session>();

    @OnOpen
    public void openSession(@PathParam("username") String username, Session session) {
        System.out.println(this);
        String sessionId = session.getId();

        livingSessions.put(sessionId, session);

        sendTextAll("欢迎用户[" + username + "] 来到聊天室！");
    }

    @OnMessage
    public void onMessage(@PathParam("username") String username, Session session, String message) {
        System.out.println(this);
        sendTextAll("用户[" + username + "] : " + message);
    }

    @OnClose
    public void onClose(@PathParam("username") String username, Session session) {
        System.out.println(this);
        String sessionId = session.getId();

        //当前的Session 移除
        livingSessions.remove(sessionId);
        //并且通知其他人当前用户已经离开聊天室了
        sendTextAll("用户[" + username + "] 已经离开聊天室了！");
    }


    private void sendTextAll(String message) {

        livingSessions.forEach((sessionId, session) -> {
            sendText(session,message);
        });
    }

    private void sendText(Session session, String message) {

        RemoteEndpoint.Basic basic = session.getBasicRemote();

        try {
            basic.sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
