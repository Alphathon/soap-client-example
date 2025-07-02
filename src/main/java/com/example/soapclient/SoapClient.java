package com.example.soapclient;

import jakarta.xml.ws.BindingProvider;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.crypto.Merlin;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SoapClient {

    public void callService() throws Exception {
        // Replace this with your generated service classes
        // Example: MyService service = new MyService();
        //          MyPort port = service.getMyPort();
        System.out.println("Replace with your service call");

        // Example signing setup:
        // Client client = ClientProxy.getClient(port);
        // Endpoint cxfEndpoint = client.getEndpoint();

        // Map<String, Object> outProps = new HashMap<>();
        // outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        // outProps.put(WSHandlerConstants.USER, "clientkey");
        // outProps.put(WSHandlerConstants.PW_CALLBACK_REF, new KeystorePasswordCallback());

        // Merlin crypto = new Merlin();
        // crypto.setKeyStorePassword("changeit");
        // crypto.loadProperties(new java.util.Properties() {{
        //     put("org.apache.wss4j.crypto.merlin.keystore.type", "jks");
        //     put("org.apache.wss4j.crypto.merlin.keystore.password", "changeit");
        //     put("org.apache.wss4j.crypto.merlin.keystore.alias", "clientkey");
        //     put("org.apache.wss4j.crypto.merlin.file", "src/main/resources/client.jks");
        // }});
        // outProps.put(WSHandlerConstants.SIG_PROP_REF_ID, "crypto");
        // outProps.put("crypto", crypto);

        // WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        // cxfEndpoint.getOutInterceptors().add(wssOut);

        // String result = port.sayHello("World");
        // System.out.println("Response: " + result);
    }

    private static class KeystorePasswordCallback implements CallbackHandler {
        @Override
        public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
            for (Callback cb : callbacks) {
                if (cb instanceof WSPasswordCallback) {
                    WSPasswordCallback pc = (WSPasswordCallback) cb;
                    if ("clientkey".equals(pc.getIdentifier())) {
                        pc.setPassword("changeit");
                    }
                }
            }
        }
    }
}
