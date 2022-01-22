import java.util.Random;

public class Pokemon {
	private String nome;
	private String tipo;
	private double peso;
	private double altura;
	private int felicidade;
	private double chanceCaptura;
	private boolean capturado = false;
	
	public Pokemon(String pnome, String ptipo, double ppeso, double paltura, int pfelicidade, double pchance)
	{
		this.nome = pnome;
		this.tipo = ptipo;
		this.peso = ppeso;
		this.altura = paltura;
		this.felicidade = pfelicidade;
		this.chanceCaptura = pchance;
	}
	
	/*	O método “Capturar” deve levar em consideração a chance de captura do
		determinado pokémon para saber se a captura foi um sucesso ou não.
		- O método “Capturar” deve ser invalidado caso o pokémon já tenha sido 
		capturado com sucesso, do mesmo modo que o método “Libertar” só deve ser 
		válido caso o pokémon esteja capturado;	 */
	
	public boolean Capturar()
	{
		if (!this.capturado) // tentar capturar
		{
			Random gerador = new Random();
			
			 // sorteia número entre 0 e 1
			double tentativa = gerador.nextInt(100) / 100.0;
			
			if (chanceCaptura>=tentativa)
			{
				// teve sucesso, marque que conseguiu e retorna veridadeiro
				this.capturado = true;
				return true;
			}
			else
			{
				// não conseguiu, retorna falso
				return false;
			}
		}
		else
		{
			return false; // já capturado, então retorna falso
		}
	}
	
	public boolean Libertar()
	{
		if (this.capturado)
		{
			this.capturado = false; // marque que liberou o pokemon
			return true;
		}
		else
		{
			return false; // retorna falso, pois o pokemón não está capturado
		}
	}
	
	/* A “fala” de um pokémon é simplesmente dizer o seu nome. - */
	public String Falar()
	{
		return this.nome;
	}

	
	/* - Os métodos “Alimentar” e “Brincar” simplesmente aumentam a felicidade 
	   do pokémon em uma determinada quantia (que fica a seu critério); */
	
	public void Alimentar()
	{
		// quando é alimentado, aumenta felicidade em 25
		this.felicidade = this.felicidade + 25;
	}
	
	public void Brincar()
	{
		// ao brincar, aumenta felicidade em 20
		this.felicidade = this.felicidade + 20;
	}
	
	/* - Um pokémon pode evoluir para qualquer outro, desde que os dados que serão
	   alterados pela evolução sejam passados para o método (os dados em questão
	   ficam a seu critério); */
	
	public boolean Evoluir(String novoNome, double novoPeso, double novaAltura, double novaChance)
	{
		// - Um pokémon só pode evoluir se sua felicidade estiver acima de 100;
		if (this.felicidade>100)
		{
			this.felicidade = this.felicidade - 100; // - Evoluir um pokémon reduz sua felicidade em 100;
			
			// muda os atributos para "evoluir" o pokemón
			this.nome = novoNome;
			this.peso = novoPeso;
			this.altura = novaAltura;
			this.chanceCaptura = novaChance;
			
			return true;
		}
		else
		{
			return false; // não é possível evoluir
		}
	}
	
}
