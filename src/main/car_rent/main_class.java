package car_rent;

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
        
        	Client c1=new Client();
        	c1.name="Klient 1";
        	c1.loyalty_program=true;

        	Client c2=new Client();
        	c2.name="Klient 2";
        	c2.loyalty_program=false;
        	
        	Client c3=new Client();
        	c3.name="Klient 3";
        	c3.loyalty_program=false;
        	
        	Booking b1 = new Booking("20201111","20201112",CarType.any,c1);        	
        	b1.FreeItemChoice=AdditionalItem.baby_seat;
        	b1.rack=true;
        	b1.baby_seat=true;
        	if(b1.phase==0)
        	{
            	kSession.insert(b1);
                kSession.fireAllRules();
        	}
        	CarReturn r1 = new CarReturn("20201112",b1);
        	r1.distance=66;
        	if(r1.phase==0)
        	{
            	kSession.insert(r1);
                kSession.fireAllRules();
        	}
        	
        	Booking b2 = new Booking("20201110","20201113",CarType.B,c2);
        	b2.rack=true;
        	if(b2.phase==0)
        	{
            	kSession.insert(b2);
                kSession.fireAllRules();
        	}
        	
        	CarReturn r2 = new CarReturn("20201113",b2);
        	r2.distance=100;
        	if(r2.phase==0)
        	{
            	kSession.insert(r2);
                kSession.fireAllRules();
        	}
        	
        	Booking b3 = new Booking("20201111","20201114",CarType.A,c2);
        	if(b3.phase==0)
        	{
            	kSession.insert(b3);
                kSession.fireAllRules();
        	}
        	
        	Booking b4 = new Booking("20201111","20201116",CarType.B,c3);
        	if(b4.phase==0)
        	{
            	kSession.insert(b4);
                kSession.fireAllRules();
        	}
        	
        	CarReturn r4 = new CarReturn("20201118",b4);
        	r4.distance=1000;
        	r4.HubCapsMissing=2;
        	r4.RegistrationLost=true;
        	
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
