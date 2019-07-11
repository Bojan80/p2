package p2;

import java.util.Random;
import javax.swing.*;
	/* Ett racing program d�r en bl� och en r�d bil t�vlar mot varandra. Bilarna r�r sig
	 * fram�t i slumpm�ssiga v�rden
	 * 
	 */
		public class Race {
			// variabler f�r programmet deklareras
			private PaintWindow window;
			private Car car1; 
			private Car car2;
			int x;
			int x1;
			int dx;
			int dx1;
			private Sound sound;
			// konstruktor med respektive parametrar
			public Race(PaintWindow window, Car car1, Car car2) {
				ImageIcon image = new ImageIcon("images/background.jpg"); // referensvariabel f�r bakgrund skapas
				this.window = new PaintWindow(image);
				this.car1 = car1;
				this.car2 = car2;
				sound = Sound.getSound("sound/Race Car.mp3"); // ljudfilen lagras i variabeln sound
			}
			private void show(){
				car1.moveTo(400, 135); // bl� bil s�tts till v�rdet av 400 p� x-axeln och 135 p� y-axeln
				car2.moveTo(400, 425); // r�d bil s�tts till v�rdet av 400 p� x-axeln och 425 p� y-axeln
				window.showImage(car1.getImage(), car1.getX(), car1.getY()); // bl� bil visas och s�tts p� dess v�rde 
				window.showImage(car2.getImage(), car2.getX(), car2.getY()); // r�d bil visas och s�tts p� dess v�rde 
			}
			private void moveCar(Car car) {
				Random rand = new Random();
				dx = rand.nextInt(3) -3; // slumpm�ssig hastighet mellan -3, -2, -1 p� bl� bil. V�rdet m�ste vara negativt annars backar bilen
				dx1 = rand.nextInt(3) -3; // slumpm�ssig hastighet mellan -3, -2, -1 p� r�d bil. V�rdet m�ste vara negativt annars backar bilen
				int x = car1.getX(); // variabel x omvandlas till bl� bils x v�rde
				int x1 = car2.getX(); // variabel x1 omvandlas till r�d bils x v�rde
				Sound aSound = Sound.getSound("sound/Race Car.mp3"); 
				if(aSound!=null) {
					aSound.play(); 
				}
				while(true) {
					window.showImage(car1.getImage(), x, 425); // bl� bil visas i while loopen
					window.showImage(car2.getImage(), x1, 135); // r�d bill visas i while loopen
					PaintWindow.pause(10); // pausa exekveringen i 10 ms innan n�sta f�rflyttning
					x += dx;
					if(x<0) {
						dx = 0;
						aSound.stop();
						System.exit(0); // funktionen avslutar JVM
					}
					x1 += dx1;
				    if(x1<0) {
				    	dx1 = 0;
				    	aSound.stop();
				    	System.exit(0); // funktionen avslutar JVM
				    }
				}
			}
		    private void start() {
		      	moveCar(car1);
		       	moveCar(car2);
	        }
		    public void action() {
				show(); // funktionen initierar bilarna och s�tter dem p� deras v�rden
				start(); // funktionen s�tter bilarna i r�relse och st�nger f�nstret n�r f�rsta bil kommer i m�l
		    }
		}



