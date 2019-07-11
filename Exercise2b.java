package p2;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

	/* Ett program skapat för att visa tiden samt en metod som uppdaterar tiden 
	 * 
	 */
public class Exercise2b{
	public void demo() {         
	String message1, message2; // variabler deklareras         
	int hour, minute, second; // variabler deklareras
	
	Time dt = new Time(); // ny instans av klassen Time skapas
	
	hour = dt.getHour(); // instansen hämtar värdet från metoden getHour() och lagrar i variabeln hour;        
	minute = dt.getMinute(); // instansen hämtar värdet från metoden getMinute() och lagrar i variabeln minute;        
	second = dt.getSecond(); // instansen hämtar värdet från metoden getSecond() och lagrar i variabeln second;
	
	message1 = "Klockan är " + minute + " minuter över " + hour + " (+" + second + " sekunder)";
	message2 = dt.toString(); // data från metoden toString lagras i variabeln message2        
	JOptionPane.showMessageDialog(null, message1);         
	JOptionPane.showMessageDialog(null, message2);
	
	dt.update(); // instansen kör metoden update() som uppdaterar med aktuell tid 
    message2 = dt.toString();         
	JOptionPane.showMessageDialog(null, message2);     
} 

	public static void main(String[] args) {
		Exercise2b prog = new Exercise2b();         
		prog.demo();     
	}
}
