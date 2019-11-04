//compile with javac HC05.java -classpath ./bluecove-2.1.1.jar

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.bluetooth.DeviceClass;
import javax.bluetooth.DiscoveryAgent;
import javax.bluetooth.DiscoveryListener;
import javax.bluetooth.LocalDevice;
import javax.bluetooth.RemoteDevice;
import javax.bluetooth.ServiceRecord;
import javax.bluetooth.UUID;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;

public class HC05 {
	static boolean scanFinished = false;
	static String hc05Url = "btspp://98d3b1fd3ac2:1;authenticate=false;encrypt=false;master=false"; //Replace this with your bluetooth URL




	public static void go(int i) throws Exception {
		StreamConnection streamConnection = (StreamConnection) Connector.open(hc05Url);
		OutputStream os = streamConnection.openOutputStream();
		//InputStream is = streamConnection.openInputStream();
		if (i == 1) {
			os.write("1".getBytes()); //light
			os.close();
		} else if (i == 0) {
			os.write("0".getBytes()); //turning off
			os.close();
		} else {
			os.write("2".getBytes()); //motor
			os.close();			
		}
		
		//byte[] b = new byte[200];
		//Thread.sleep(200);
		//is.read(b);
		//is.close();
		streamConnection.close();
		//System.out.println("received " + new String(b));
	}
}