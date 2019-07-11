package p2;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.*;

	/* Ett program skapat f�r att visa tiden samt en metod som uppdaterar tiden 
	 * 
	 */

	public class Time {
		// Variabler f�r programmet deklareras
		private int second;
		private int minute;
		private int hour;
		private Calendar cal;
		 
		// konstruktorn med samma namn som klassen skapas f�r att lagra korrekt tid h�mtad fr�n klassen Calendar
		public Time() {
			cal = Calendar.getInstance(); 
			this.second = cal.get(Calendar.SECOND);
			this.minute = cal.get(Calendar.MINUTE);
			this.hour = cal.get(Calendar.HOUR);
		}
		public int getSecond() { // get-metoden returnerar sekunder
			return second;
		}
		public int getMinute() { // get-metoden returnerar minuter
			return minute;
		}
		public int getHour() { // get-metoden returnerar timme
			return hour;
		}
		public Calendar update() { // metoden uppdaterar tiden fr�n kalendern och lagrar den nya tiden i variablerna. Den nya tiden returneras
			cal.setTime( new Date() ); // kalender objektet uppdateras med aktuell tid
			return cal;
		}
		public String toString() {
			Format correctForm = new SimpleDateFormat("HH:mm:ss"); // nytt objekt skapas vars mening �r att formatera om tiden
			String outprint = correctForm.format(new Date()); // formaterar om tiden fr�n en siffra till tv� siffror, tex 8:00 till 08:00
			return outprint;
		}

}


