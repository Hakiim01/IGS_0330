package ue02;

import org.apache.log4j.Logger;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.v24.message.ADT_A01;
import ca.uhn.hl7v2.model.v24.segment.MSH;
import ca.uhn.hl7v2.model.v24.segment.PID;
import ca.uhn.hl7v2.parser.Parser;

/**
 * Example transmitting a message
 */
public class CreateAMessage {

    private static Logger logger = Logger.getLogger(CreateAMessage.class);

    /**
     * @param args
     * @throws HL7Exception
     */
    public static void main(String[] args) throws Exception {

        /* ######################################################
         * TODO: Use HAPI to create a HL7v2 ADT_A01 Message
         * - add MSH Segment (Sending Application, Sequence Number)
         * - add PID Segment (Family name, Given name, ID)
         * - Encode the Message as Pipe an XML
         * #####################################################
         */

    }
}
