import java.util.Scanner;

public class Exercicio_2_3 {

	public static void main(String[] args) {
		
		int contaTentativa = 0, opcao;
		boolean conseguiuEvoluir = false;
		Scanner entrada = new Scanner(System.in);
		
		// criando um pokemon
		Pokemon pikachu = new Pokemon("Pikachú", "Elétrico", 3.0, 0.3, 0, 0.3);
		
		System.out.println("INÍCIO");
		
		// fazer o pokemon falar
		System.out.println(pikachu.Falar());
		
		// tentar pegar o pokemon (até conseguir)
		do
		{
			System.out.println("Tentando capturar o pokémon...");
			contaTentativa = contaTentativa + 1; 
		} while(!pikachu.Capturar());
		
		System.out.println("Consegui na tentativa: " + contaTentativa);
		
		
		System.out.println("Lidando com o pokemón para evoluí-lo: ");
		System.out.println("1) Alimentar");
		System.out.println("2) Brincar");
		System.out.println("3) Evoluir");
		
		do
		{
			System.out.print("Opção: ");
			opcao = entrada.nextInt();
			
			switch (opcao)
			{
				case 1:
					System.out.println("Alimentando...");
					pikachu.Alimentar();
					break;
				case 2:
					System.out.println("Brincando...");
					pikachu.Brincar();
					break;
				case 3:
					System.out.println("Tentando evoluir...");
					if (pikachu.Evoluir("Raichu", 1.0, 0.6, 0.7))
					{
						conseguiuEvoluir = true;
					}
					else
					{
						System.out.println("Não conseguiu! Tente brincar e alimentar mais seu pokémon!");
					}
					break;
			}
			
		} while (!conseguiuEvoluir);
		
		
		// fazer o pokemon falar
		System.out.println(pikachu.Falar());
		
		
		System.out.println("FIM");
		
		entrada.close();

	}

}
