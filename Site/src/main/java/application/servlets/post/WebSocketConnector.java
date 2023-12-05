package application.servlets.post;
import application.model.Client;
import application.model.Post;
import application.service.ClientService;
import application.service.PostService;
import com.google.gson.Gson;
import jakarta.websocket.*;
import jakarta.websocket.server.*;

import java.io.IOException;
import java.sql.Time;
import java.util.*;


@ServerEndpoint(value = "/msg/{username}")
public class WebSocketConnector {

    private Session session;
    private String username;
    private Long lastPostId = 0L;
    public static Map<String, WebSocketConnector> endPoints = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {
        System.out.println("WS connect " + username);
        this.session = session;
        this.username = username;
        endPoints.put(username, this);
        sendList();
    }
    @OnMessage
    public void onMessage(Session session, String message, @PathParam("username") String username) {
        ClientService clientService = new ClientService();
        Client client = clientService.findByUserName(username);
        PostService postService = new PostService();
        Post post = new Post();
        post.setClient(client);
        post.setDate(new Date());
        post.setTime(new Time(System.currentTimeMillis()));
        post.setMessage(message);
        postService.save(post);
    }


    @OnClose
    public void onClose(Session session) {
        // WebSocket connection closes
    }

    @OnError
    public void onError(Session session, Throwable throwable) {

    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (IOException  e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
    private void sendList() throws IOException {
        PostService service = new PostService();
        Gson gson = new Gson();
        List<Post> list = service.findAll();
        Collections.reverse(list);
        String json = gson.toJson(list);
        sendMessage(json);
    }
}