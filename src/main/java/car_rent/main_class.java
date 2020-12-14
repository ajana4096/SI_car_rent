package car_rent;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.kie.api.KieServices;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class main_class {	
    public static final void main(String[] args) {
        try {
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	KieRuntimeLogger kLogger = ks.getLoggers().newFileLogger(kSession, "test");        
        
        	Client c1 = new Client();
        	c1.loyalty_program=true;
        	kSession.insert(c1);
        	
        	Client c2 = new Client();
        	c2.name="Klient 2";
        	c2.loyalty_program=true;
        	kSession.insert(c2);
        	
        	Booking b1 = new Booking();
        	b1.client=c1;
        	b1.CarID="A1";
        	b1.cartype= CarType.A;
        	b1.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201204");
        	b1.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201205");
        	
        	Booking b3 = new Booking();
        	b3.client=c1;
        	b3.CarID="A2";
        	b3.cartype= CarType.A;
        	b3.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201204");
        	b3.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201205");
        	       	
        	Booking b4 = new Booking();
        	b4.client=c1;
        	b4.CarID="B1";
        	b4.cartype= CarType.B;
        	b4.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201204");
        	b4.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201205");
        	
        	Booking b5 = new Booking();
        	b5.client=c1;
        	b5.CarID="D1";
        	b5.cartype= CarType.D;
        	b5.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201204");
        	b5.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201205");
        	
        	Booking b6 = new Booking();
        	b6.client=c1;
        	b6.CarID="D2";
        	b6.cartype= CarType.D;
        	b6.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201204");
        	b6.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201205");
        	
        	Booking b2 = new Booking();
        	b2.client=c2;
        	b2.cartype=CarType.any;
        	b2.baby_seat=false;
        	b2.rack=true;
        	b2.Start = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201201");
        	b2.End = new SimpleDateFormat( "yyyyMMdd" ).parse( "20201207");
        	
        	
        	//kSession.insert(b1);
        	//kSession.insert(b3);
        	//kSession.insert(b4);
        	//kSession.insert(b5);
        	//kSession.insert(b6);
        	kSession.insert(b2);

            kSession.fireAllRules();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
