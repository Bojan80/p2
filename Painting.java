package p2;

public class Painting {
	/* Ett program som skriver ut information om målning
	 * 
	 */
	    // instansvariabler deklareras
		private String title;
		private String painter;
		private int year;
		// konstruktor med tre formella parametrar
		public Painting(String title, String painter, int year) {
			this.title = title;
			this.painter = painter;
			this.year = year;
		}
		public String getTitle() {
			return title; // värdet av variabeln title returneras
		}
		public String getPainter() {
			return painter; // // värdet av variabeln painter returneras
		}
		public int getYear() {
			return year; // värdet av variabeln year returneras
		}
		public String toString() {
			String result = this.title + " av " + this.painter + ", " + this.year;
			return result;
		}
	}
	

