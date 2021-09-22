package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    boolean isExit = true;
                    String answer = "What";
                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
                        if (str.contains("Exit")) {
                            isExit = false;
                            answer = "Завершить работу сервера";
                        } else if (str.contains("Hello")) {
                            answer = "Hello";
                        }
                        System.out.println(str);
                    }
                    out.write(answer.getBytes());
                    out.flush();
                    if (!isExit) {
                        server.close();
                    }
                }
            }
        }
    }
}
