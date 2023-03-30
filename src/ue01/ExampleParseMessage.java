package ue01;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.examples.ExampleParseMessages;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v22.datatype.PN;
import ca.uhn.hl7v2.model.v22.message.ADT_A01;
import ca.uhn.hl7v2.model.v22.segment.MSH;
import ca.uhn.hl7v2.parser.Parser;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ExampleParseMessage {

    private static final Logger logger = Logger.getLogger(ExampleParseMessages.class);

    /**
     * A simple example of parsing a message
     *
     * @throws IOException
     * @throws HL7Exception
     */
    public static void main(String[] args) throws Exception {
        String msg = "MSH|^~\\&|HIS|RIH|EKG|EKG|199904140038||ADT^A01||P|2.2\r"
                + "PID|0001|00009874|00001122|A00977|SMITH^JOHN^M|MOM|19581119|F|NOTREAL^LINDA^M|C|564 SPRING ST^^NEEDHAM^MA^02494^US|0002|(818)565-1551|(425)828-3344|E|S|C|0000444444|252-00-4414||||SA|||SA||||NONE|V1|0001|I|D.ER^50A^M110^01|ER|P00055|11B^M011^02|070615^BATMAN^GEORGE^L|555888^NOTREAL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^NOTREAL^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|199904101200||||5555112333|||666097^NOTREAL^MANNY^P\r"
                + "NK1|0222555|NOTREAL^JAMES^R|FA|STREET^OTHER STREET^CITY^ST^55566|(222)111-3333|(888)999-0000|||||||ORGANIZATION\r"
                + "PV1|0001|I|D.ER^1F^M950^01|ER|P000998|11B^M011^02|070615^BATMAN^GEORGE^L|555888^OKNEL^BOB^K^DR^MD|777889^NOTREAL^SAM^T^DR^MD^PHD|ER|D.WT^1A^M010^01|||ER|AMB|02|070615^VOICE^BILL^L|ER|000001916994|D||||||||||||||||GDD|WA|NORM|02|O|02|E.IN^02D^M090^01|E.IN^01D^M080^01|199904072124|199904101200|||||5555112333|||666097^DNOTREAL^MANNY^P\r"
                + "PV2|||0112^TESTING|55555^PATIENT IS NORMAL|NONE|||19990225|19990226|1|1|TESTING|555888^NOTREAL^BOB^K^DR^MD||||||||||PROD^003^099|02|ER||NONE|19990225|19990223|19990316|NONE\r"
                + "AL1||SEV|001^POLLEN\r"
                + "GT1||0222PL|NOTREAL^BOB^B||STREET^OTHER STREET^CITY^ST^77787|(444)999-3333|(222)777-5555||||MO|111-33-5555||||NOTREAL GILL N|STREET^OTHER STREET^CITY^ST^99999|(111)222-3333\r"
                + "IN1||022254P|4558PD|BLUE CROSS|STREET^OTHER STREET^CITY^ST^00990||(333)333-6666||221K|LENIX|||19980515|19990515|||PATIENT01 TEST D||||||||||||||||||02LL|022LP554";

        /* ######################################################
         * TODO: Use HAPI-Terser mechanism to read/write certain parts of the above message
         * - retrieve and display the sendingApplication and print it to console
         * - retrieve and display the second allergytype and print it to console
         * - set the sending application to mySendingApplication
         * - create a ORU_R01 Message and add 5 OBX segments to it
         * #####################################################
         */

        //Factory for the methods using the HAPI Framework
        HapiContext context = new DefaultHapiContext();

        //Parsing to convert string to an object
        Parser genericParser = context.getGenericParser();

        //Parsing of the message
        Message hapiMessage = genericParser.parse(msg);

        //Cast to ADT A01 Message
        ADT_A01 adtMsg = (ADT_A01) hapiMessage;
        //Loading of the message header
        MSH msh = adtMsg.getMSH();

        //Loading of the message type, trigger and header
        String msgType = msh.getMessageType().getMessageType().getValue();
        String msgTrigger = msh.getMessageType().getTriggerEvent().getValue();

        //logging of ADT A01
        System.out.println(msgType + " " + msgTrigger);
        logger.info(msgType + " " + msgTrigger);

        //Load patient
        PN patientName = adtMsg.getPID().getPatientName();
        String familyName = patientName.getFamilyName().getValue();
        String givenName = patientName.getGivenName().getValue();

        logger.info(familyName + " " + givenName);


    }
}