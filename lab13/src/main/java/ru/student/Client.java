package ru.student;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends NetworkConnection {

    private final String ipAddress;
    private final int port;

    public Client(String ipAddress, int port, Consumer<Serializable> callback) {
        super(callback);
        this.ipAddress = ipAddress;
        this.port = port;
    }

    @Override
    protected boolean isServer() {
        return false;
    }

    @Override
    protected String getIpAddress() {
        return ipAddress;
    }

    @Override
    protected int getPort() {
        return port;
    }
}
