package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (BufferedWriter out = new BufferedWriter(
                        new OutputStreamWriter(socket.getOutputStream(), Charset.forName("WINDOWS-1251")));
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n");
                    boolean isExit = true;
                    String answer = "What";
                    while (in.ready()) {
                        String str = in.readLine();
                        if (str.contains("Exit")) {
                            isExit = false;
                            answer = "Завершить работу сервера";
                        } else if (str.contains("Hello")) {
                            answer = "Hello";
                        }
                        System.out.println(str);
                    }
                    out.write(answer);
                    out.flush();
                    if (!isExit) {
                        server.close();
                    }
                }
            }
        }
    }
}
