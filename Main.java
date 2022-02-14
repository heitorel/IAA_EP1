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

import java.util.*;
import java.io.*;


public class Main {

	//método que gera as imagens a partir da entrada do .txt e devolve um .png
	public static void generateImage(String inputFileName, String outputFileName) throws IOException {

		//cria-se o objeto scanner a aprtir do arquivo informado na chamada da classe
		Scanner scanner = new Scanner(new File(inputFileName));

		//cria-se o objeto imagem a partir dos parametros informados no arquivo chamada da classe atribuidos ao objeto scanner
		ImageEx image = new ImageEx(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
		
		//laço que executa cada comando do arquivo .txt armazenado no objeto scanner até que se acabem os comandos
		while(scanner.hasNext()){

			//a variável command é alimentada com o próximo comando
			String command = scanner.next();
			
			// o comando é identificado, chamando assim seu método correspondente que recebrá seus arguemntos que vem na sequência
			switch (command){
				case ("SET_COLOR"):
					image.setColor(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
					break;
				case ("SET_PIXEL"):
					image.setPixel(scanner.nextInt(), scanner.nextInt());
					break;
				case ("DRAW_LINE"):
					image.drawLine(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
					break;
				case ("KOCH_CURVE"):
					image.kochCurve(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
					break;
				case ("REGION_FILL"):
					image.regionFill(scanner.nextInt(), scanner.nextInt());
					break;
			}
		}
		//ao fim do laço a imagem é salva
		image.save(outputFileName);
	}

	//main da classe
	public static void main(String [] args){

		//verificação dos argumentos na chamada da classe
		if(args.length != 2){
			
			//mensagem de dica de uso correto ao usuário
			System.out.println("a chamada correta é: java " + Main.class.getName() + " 'entrada.txt' 'saida.png'");
			System.exit(1);
		}

		//lançamento e tratamento de exceção
		try{
			generateImage(args[0], args[1]);
		}
		catch(IOException e){
			
			System.out.println("Problem generating image... :(");
			e.printStackTrace();
		}
	}
}
