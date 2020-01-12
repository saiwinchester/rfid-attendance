
package attendance;

import  com.panamahitek.ArduinoException ;
import  com.panamahitek.PanamaHitek_Arduino ;
import  java.util.logging.Level ;
import  java.util.logging.Logger ;
import  jssc.SerialPortEvent ;
import  jssc.SerialPortEventListener ;
import  jssc.SerialPortException ;

public  class  RFIDConn {

    
    public static  PanamaHitek_Arduino ino =  new  PanamaHitek_Arduino ();

   
    private  static  final  SerialPortEventListener listener =  new  SerialPortEventListener () {
        @Override
        public  void  serialEvent ( SerialPortEvent  spe ) {
            try {

                if (ino . isMessageAvailable ()) {
                  
                    System.out.println("Ye Raha \n");
                    System . out . println (ino . printMessage ());
                }
            } catch ( SerialPortException  |  ArduinoException ex) {
                Logger . getLogger (RFIDConn . class . getName ()) . log ( Level . SEVERE , null , ex);
            }

        }
    };

    public  static  void  main ( String [] args ) {
        try {
           
            ino . arduinoRX ( "COM3" , 9600 , listener);
        } catch ( ArduinoException  |  SerialPortException ex) {
            Logger . getLogger (RFIDConn . class . getName ()) . log ( Level . SEVERE , null , ex);
        }
    }
}