package com.example.soapclient;

public class Main {
    public static void main(String[] args) throws Exception {
        SoapClient client = new SoapClient();
        client.callService();
    }
}
