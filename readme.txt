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

*********************COMO COMPILAR E EXECUTAR O EP1********************

1- Compilando
    
    No prompt de comando, após navegar até o diretório onde estão as 
    .java Image, ImageEx e Main, compile a classe Main com:

    "javac Main.java"

2- Executando

    Para executar o pgrograma, coloque no diretório um arquivo .txt
    com os comandos desejados seguindo o padrão estabelecido e então,
    ainda no prompt de comando, execute Main passando os argumentos:

    arg1: o arquivo de entrada .txt
    arg2: o nome do arquivo de saída .png

    ex: java Main comandos.txt imagem.png

    Em caso de report de overflow no call stack, comum em entradas
    que acionem a Curva de Koch, use a expansão do limite de memória
    na chamada da classe:
    
    java -Xss250M Main comandos.txt imagem.png

