package car_rent;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.TextFormat.ParseException;

public class Booking {
	public Date Start;
	public Date End;
	public int phase = 0;
	public Client client;
	public CarType cartype;
	public String CarID;
	public boolean baby_seat;
	public boolean rack;
	public AdditionalItem FreeItemChoice;
	public String text="";
	private Payment payment = new Payment();

	public void SetValue(long val){
		payment.value=val;
	}
	public void AddValue(long val) {
		payment.value+=val;
	}
	public long GetValue() {
		return payment.value;
	}
	public long getlength() throws ParseException {
		long diffInMillies = Math.abs(End.getTime() - Start.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
}