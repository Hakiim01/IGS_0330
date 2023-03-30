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

        //Prep for the ADT A01 msg
        ADT_A01 adt = new ADT_A01();

        //Quick Init
        //1: Code -> ADT
        //2: TriggerEvent -> A01
        //3: Processing Code -> P = Production, T = Test
        adt.initQuickstart("ADT", "A01", "P");

        //Filling the msg header
        MSH msh = adt.getMSH();
        msh.getSendingApplication().getNamespaceID().setValue("TestSendingSystem");
        msh.getSequenceNumber().setValue("123");

        //Filling the patient information
        PID pid = adt.getPID();
        pid.getPatientName(0).getFamilyName().getSurname().setValue("Doe");
        pid.getPatientName(0).getGivenName().setValue("John");
        pid.getPatientIdentifierList(0).getID().setValue("123456");

        // fill msg over context
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getPipeParser();
        String encodedMessage = p.encode(adt).replace("\r", System.lineSeparator());
        logger.info("Printing encoded HL7 - ER7 Encoded message:");
        logger.info(encodedMessage);

        p = context.getXMLParser();
        encodedMessage = p.encode(adt).replace("\r", System.lineSeparator());
        logger.info("Printing encoded HL7 - ER7 Encoded message:");
        logger.info(encodedMessage);
    }
}
