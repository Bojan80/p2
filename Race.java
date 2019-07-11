package p2;

import java.util.Random;
import javax.swing.*;
	/* Ett racing program där en blå och en röd bil tävlar mot varandra. Bilarna rör sig
	 * framåt i slumpmässiga värden
	 * 
	 */
		public class Race {
			// variabler för programmet deklareras
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
				ImageIcon image = new ImageIcon("images/background.jpg"); // referensvariabel för bakgrund skapas
				this.window = new PaintWindow(image);
				this.car1 = car1;
				this.car2 = car2;
				sound = Sound.getSound("sound/Race Car.mp3"); // ljudfilen lagras i variabeln sound
			}
			private void show(){
				car1.moveTo(400, 135); // blå bil sätts till värdet av 400 på x-axeln och 135 på y-axeln
				car2.moveTo(400, 425); // röd bil sätts till värdet av 400 på x-axeln och 425 på y-axeln
				window.showImage(car1.getImage(), car1.getX(), car1.getY()); // blå bil visas och sätts på dess värde 
				window.showImage(car2.getImage(), car2.getX(), car2.getY()); // röd bil visas och sätts på dess värde 
			}
			private void moveCar(Car car) {
				Random rand = new Random();
				dx = rand.nextInt(3) -3; // slumpmässig hastighet mellan -3, -2, -1 på blå bil. Värdet måste vara negativt annars backar bilen
				dx1 = rand.nextInt(3) -3; // slumpmässig hastighet mellan -3, -2, -1 på röd bil. Värdet måste vara negativt annars backar bilen
				int x = car1.getX(); // variabel x omvandlas till blå bils x värde
				int x1 = car2.getX(); // variabel x1 omvandlas till röd bils x värde
				Sound aSound = Sound.getSound("sound/Race Car.mp3"); 
				if(aSound!=null) {
					aSound.play(); 
				}
				while(true) {
					window.showImage(car1.getImage(), x, 425); // blå bil visas i while loopen
					window.showImage(car2.getImage(), x1, 135); // röd bill visas i while loopen
					PaintWindow.pause(10); // pausa exekveringen i 10 ms innan nästa förflyttning
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
				show(); // funktionen initierar bilarna och sätter dem på deras värden
				start(); // funktionen sätter bilarna i rörelse och stänger fönstret när första bil kommer i mål
		    }
		}



