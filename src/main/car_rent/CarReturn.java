package car_rent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CarReturn {
	public long distance;
	public Date ReturnDate;
	public Booking booking;
	public int phase=0;
	public String text="";
	public int HubCapsMissing=0;
	public boolean PolicyLost=false;
	public boolean RegistrationLost=false;
	private Payment payment = new Payment();
	public CarReturn(String ReturnDate,Booking booking) {
		try {
			this.ReturnDate = new SimpleDateFormat( "yyyyMMdd" ).parse(ReturnDate);
		} catch (ParseException e) {
			System.out.print("Niewłaściwy format daty początkowej.");
			this.phase=-1;
		}
		this.booking=booking;
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
	public long getdelay(){
		long diffInMillies = Math.abs(ReturnDate.getTime() - booking.End.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
}
