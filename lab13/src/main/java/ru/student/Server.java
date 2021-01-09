package ru.student;

import java.io.Serializable;
import java.util.function.Consumer;

public class Server extends NetworkConnection {

    private final int port;

    public Server(int port, Consumer<Serializable> callback) {
        super(callback);
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return true;
    }

    @Override
    protected String getIpAddress() {
        return null;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
