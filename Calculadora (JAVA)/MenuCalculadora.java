public class MenuCalculadora{
	private Calculadora calculadora;
	private int opcao;
	private ConversorNumeros conversor;
	private EntradaSaidaDados io;

	public MenuCalculadora (){
		this.calculadora = new Calculadora ();
		this.opcao = -1;
		this.conversor = new ConversorNumeros();
		this.io = new EntradaSaidaDados();
	}
	public void execultarCalculadora(){
		do{
			this.execultarMenuPrincipal();
			this.avaliarOpcaoEscolhida();
		}while(this.opcao!=0);
	}
	private void execultarMenuPrincipal(){
		String mensagemMenu = "Selecionar uma opção"
			+"\n 1 - Somar"
			+"\n 2 - Subtrair"
			+"\n 3 - Multiplicar"
			+"\n 4 - Dividir"
			+"\n 5 - Sair";
		String entradaDados = io.entradaDados(mensagemMenu);
		this.opcao = conversor.StringToInt(entradaDados);
	}
	public void avaliarOpcaoEscolhida(){
		String saida;
		double num1=0, num2=0;
		if (this.opcao != 0 && this.opcao <=4) {
			String mensagemEntrada = "Digite o 1° numero";
			num1 = conversor.StringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero01(num1);
			mensagemEntrada = "Digite o 2° numero";
			num2 = conversor.StringToDouble(io.entradaDados(mensagemEntrada));
			calculadora.setNumero02(num2);
		}
			switch(this.opcao){
				case 1:
					calculadora.somar(num1,num2);
					saida="Resultado da Soma : " + calculadora.getResultado();
					io.saidaDados(saida);
					break;
				case 2:
					calculadora.subtratir(num1,num2);
					saida="Resultado da Subtração : " + calculadora.getResultado();
					io.saidaDados(saida);
					break;
				case 3:
					calculadora.multiplicar(num1,num2);
					saida="Resultado da Multiplicação : " + calculadora.getResultado();
					io.saidaDados(saida);
					break;
				case 4:
					calculadora.dividir(num1,num2);
					saida="Resultado da Divisão : " + calculadora.getResultado();
					io.saidaDados(saida);
					break;
				case 5:
					calculadora.sair();
				default:
					io.saidaDados("Opção inválida");
					break;
			}

	}		
}