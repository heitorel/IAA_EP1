/*********************************************************************/
/**   ACH2002 - Introdução a Análise de Algoritimos                 **/
/**   EACH-USP - Segundo Semestre de 2020                           **/
/**               <Flávio Coutinho>                                 **/
/**                                                                 **/
/**   Primeiro Exercício-Programa                                   **/
/**                                                                 **/
/**   <HEITOR LOPES BIANCHI>                   <10258730>           **/
/**                                                                 **/
/**   <30/11/2020>                                                  **/
/*********************************************************************/

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

// Essa classe não deve ser modifciada pois foi disponibilizada pelo professor enunciado

public class Image {

	private int width, height;
	private BufferedImage image;
	private Graphics graphics;

	private Color color;
	private Color bgColor;

	public Image(int w, int h){

		setup(w, h, 0, 0, 0);
	}

	public Image(int w, int h, int r, int g, int b){

		setup(w, h, r, g, b);
	}

	private void setup(int w, int h, int r, int g, int b){

		image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		width = image.getWidth();
		height = image.getHeight();
		graphics = image.createGraphics();
		
		setBgColor(new Color(limit(r), limit(g), limit(b)));
		setColor(Color.WHITE);
		clear();
	}

	private int limit(int value){

		if (value < 0){
			return (0);
		}
		else{
			if (value > 255){
				return(255);
			}
			else{
				return(value);
			}
		}
	}

	public int getWidth(){

		return width;
	}
	
	public int getHeight(){

		return height;
	}

	public void setBgColor(Color c){

		bgColor = c;
	}

	public void setBgColor(int r, int g, int b){

		setBgColor(new Color(limit(r), limit(g), limit(b)));
	}

	public void setColor(Color c){

		color = c;
	}

	public void setColor(int r, int g, int b){

		setColor(new Color(limit(r), limit(g), limit(b)));
	}

	public void clear(){

		graphics.setColor(bgColor);
		graphics.fillRect(0, 0, width, height);
	}

	public void setPixel(int x, int y){
			
		if(x >= 0 && y >= 0 && x < width && y < height){
			
			image.setRGB(x, y, color.getRGB());
		}
	}

	public int getPixel(int x, int y){

		return image.getRGB(x, y); 
	}

	public void drawLine(int x1, int y1, int x2, int y2){

		graphics.setColor(color);
		graphics.drawLine(x1, y1, x2, y2);
	}

	public void save(String fileName){

		try{

			ImageIO.write(image, "png", new File(fileName));
		}
		catch(IOException e){
	
			System.out.println("Unable to save image...");
			e.printStackTrace();
		}
	}
}

