package car_rent;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.google.protobuf.TextFormat.ParseException;

public class CarReturn {
	public Date ReturnDate;
	public Booking booking;
	public long getdelay() throws ParseException {
		long diffInMillies = Math.abs(ReturnDate.getTime() - booking.End.getTime());
		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		return diff;
	}
	public int HubCapsMissing;
	public boolean PolicyLost;
	public boolean RegistrationLost;
	public Payment payment = new Payment();
}
