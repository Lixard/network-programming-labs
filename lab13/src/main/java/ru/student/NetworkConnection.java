package ru.student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class NetworkConnection {

    private final ConnectionThread thread = new ConnectionThread();
    private final Consumer<Serializable> callback;

    protected NetworkConnection(Consumer<Serializable> callback) {
        this.callback = callback;
        thread.setDaemon(true);
    }

    public void start() {
        thread.start();
    }

    public void send(Serializable data) throws IOException {
        thread.out.writeObject(data);
    }

    public void close() throws IOException {
        thread.socket.close();
    }

    protected abstract boolean isServer();

    protected abstract String getIpAddress();

    protected abstract int getPort();

    private class ConnectionThread extends Thread {

        private Socket socket;
        private ObjectOutputStream out;

        @Override
        public void run() {
            try (ServerSocket server = isServer() ? new ServerSocket(getPort()) : null;
                 Socket socket = isServer() ? server.accept() : new Socket(getIpAddress(), getPort());
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {
                this.socket = socket;
                this.out = out;

                socket.setTcpNoDelay(true);

                while (true) {
                    Serializable data = (Serializable) in.readObject();
                    callback.accept(data);
                }

            } catch (IOException | ClassNotFoundException e) {
                callback.accept("connection closed");
            }
        }
    }
}
