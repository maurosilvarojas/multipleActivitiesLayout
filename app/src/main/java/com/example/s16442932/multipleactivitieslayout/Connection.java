package com.example.s16442932.multipleactivitieslayout;

/**
 * Created by s16442932 on 01/02/2017.
 */

class Connection {
    String quality;
    String port;
    String broker;



    Connection(){
        return;
    }

    public Connection(String quality, String port, String broker) {
        this.quality = quality;
        this.port = port;
        this.broker = broker;
    }

    public Connection(String port, String broker) {
        this.port = port;
        this.broker = broker;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }
}
