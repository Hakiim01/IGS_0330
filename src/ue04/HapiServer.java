package ue04;

import org.apache.log4j.Logger;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.HL7Service;
import ca.uhn.hl7v2.protocol.ReceivingApplication;

// Server class that runs in its own thread
public class HapiServer extends Thread {

    // Logging component
    private static Logger logger = Logger.getLogger(HapiServer.class);

    public void run() {
        // ##############################################
        // TODO: implement HL7 ADT_A03 Server
        // ##############################################

        // ##############################################
        // TODO: Add Receiver
        // ##############################################

        // ##############################################
        // TODO: Add Error Handling
        // ##############################################

        // ##############################################
        // TODO: Add Connection listener
        // ##############################################
    }

    public static void main(String[] args) {
        // Start the server
        new HapiServer().start();
    }

}

