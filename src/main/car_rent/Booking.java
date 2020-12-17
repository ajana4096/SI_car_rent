package car_rent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Booking {
	public Date Start;
	public Date End;
	public int phase = 0;
	public Client client;
	public CarType cartype;
	public String CarID="";
	public boolean baby_seat=false;
	public boolean rack=false;
	public AdditionalItem FreeItemChoice=AdditionalItem.none;
	public String text="";
	private Payment payment = new Payment();
	public CarReturn r;
	public Booking(String Start,String End,CarType cartype,Client client)
	{
		try {
			this.Start = new SimpleDateFormat( "yyyyMMdd" ).parse(Start);
		} catch (ParseException e) {
			System.out.print("Niewłaściwy format daty początkowej.");
		}
    	try {
			this.End = new SimpleDateFormat( "yyyyMMdd" ).parse(End);
		} catch (ParseException e) {
			System.out.print("Niewłaściwy format daty końcowej.");
			this.phase=-1;
		}
		this.cartype=cartype;
		this.client=client;
	}
	public void SetValue(long val){
		payment.value=val;
	}
	public void AddValue(long val) {
		payment.value+=val;
	}
	public long GetValue() {
		return payment.value;
	}
	public long getlength(){
		long diffInMillies = Math.abs(End.getTime() - Start.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff+1;
	}
}