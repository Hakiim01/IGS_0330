package ue04;

import org.apache.log4j.Logger;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.app.Connection;
import ca.uhn.hl7v2.app.Initiator;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v26.message.ADT_A03;
import ca.uhn.hl7v2.model.v26.segment.EVN;
import ca.uhn.hl7v2.model.v26.segment.MSH;
import ca.uhn.hl7v2.model.v26.segment.PID;
import ca.uhn.hl7v2.model.v26.segment.PV1;
import ca.uhn.hl7v2.parser.Parser;

//hapi client that runs in its own thread
public class HapiClient extends Thread {

    // logging component
    private static Logger logger = Logger.getLogger(HapiClient.class);

    public void run() {
        // ##############################################
        // TODO: implement HL7 ADT_A03 Client
        // ##############################################

    }

    private void discharge() throws Exception {


        // ###############################################
        // TODO: implement ADT_A03 Message
        // ###############################################

    }

    public static void main( String[] args ) {
        new HapiClient().start();
    }
}

