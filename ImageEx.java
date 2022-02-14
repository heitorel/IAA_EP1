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

//classe que implementa os métodos chamados pela entrada .txt e extende a classe Image
public class ImageEx extends Image {

	//construtores da classe
	public ImageEx(int w, int h, int r, int g, int b){

		super(w, h, r, g, b);
	}
	public ImageEx(int w, int h){

		super(w, h);
	}

	//retorna o tamanho da linha a partir das coordenadas do pixel A e do pixel B
	public static int lineSize(int xA, int yA, int xB, int yB) {
		 
		int size = (int) Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
		return size;
	}

	//método recursivo que desenha a Curva de Koch a partir dos pontos inciais de uma reta e seu limiar
	public void kochCurve(int xA, int yA, int xB, int yB, int Limiar){

		//tomemos a diferença entre as coordenadas de Y e de X como deltas
		int Dy = yB-yA;
		int Dx = xB-xA;		
		
		//definimos então as coordenadas do ponto P e do ponto Q
		int Py = yA;
		int Px = xA;
		int Qy = yB;
		int Qx = xB;
		

		//a partir dessas coordenadas é traçadaa reta inicial e seu tamanho é armazenado
		int reta = lineSize(Px, Py, Qx, Qy);

		//verifica-se o tamanho da reta em relação ao limiar dado como parâmetro
		if(reta < Limiar){
			drawLine(Px, Py, Qx, Qy);
		}

		//são estabelecidos os pontos A, B e C na reta inicial afim de delimitar as coordenadas das retas de tamanho (reta/3)
		//que formarão a curva de koch
		else{
			//A
			int Ax = (int) (Px + (Dx/3));
			int Ay = (int) (Py + (Dy/3));

			//B
			int Bx = (int) ((Px+Qx)/2 - (Math.sqrt(3.0)/6)*(Py-Qy));
			int By = (int) ((Py+Qy)/2 - (Math.sqrt(3.0)/6)*(Qx-Px));
			
			//C
			int Cx = (int) (Qx - (Dx/3));
			int Cy = (int) (Qy - (Dy/3));

			//então o método é recursivamente invocado afim de traçar as novas retas (reta/3) indo de:

			//PA
			kochCurve(Px, Py, Ax, Ay, Limiar);
			//AB
			kochCurve(Ax, Ay, Bx, By, Limiar);
			//BC
			kochCurve(Bx, By, Cx, Cy, Limiar);
			//CQ
			kochCurve(Cx, Cy, Qx, Qy, Limiar);
		}
	}

	//métodos que colorem uma região da imagem a partir de um pixel referencial
	public void regionFill(int x, int y){
		regionFill(x, y, getPixel(x, y));
	}
	public void regionFill(int x, int y, int reference_rgb){
        if( x < 0 || y < 0 || y >= getHeight() || x >= getWidth())
            return;

        if(getPixel(x,y) != reference_rgb)
            return;
		
        setPixel(x,y);
            
        regionFill(x+1, y, reference_rgb);
        regionFill(x-1, y, reference_rgb);
        regionFill(x, y+1, reference_rgb);
        regionFill(x, y-1, reference_rgb);
	}
}
