import java.util.Scanner;

public class JogoVelha {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		char[][] game = new char[3][3];
		
		System.out.println("Jogador 1 = X");
		System.out.println("Jogador 2 = O");
		
		boolean win = false;
		int round = 1;
		char symbol = 0;
		int line = 0, column = 0;
		
		while(!win) {
			if (round % 2 == 1) {
				System.out.println("Vez do jogador 1, escolha linha e coluna (1-3): ");
				symbol = 'X';
			} else {
				System.out.println("Vez do jogador 2, escolha linha e coluna (1-3): ");
				symbol = 'O';
			}
			
			boolean validLine = false;
			while(!validLine) {
				System.out.println("Entre com uma linha (1, 2 ou 3): ");
				line = sc.nextInt();
				
				if(line >= 1 && line <= 3) {
					validLine = true;
				} else {
					System.out.println("Entre com uma linha (1, 2 ou 3): ");
				}
			}
			
			boolean validColumn = false;
			while(!validColumn) {
				System.out.println("Entre com uma coluna (1, 2 ou 3): ");
				column = sc.nextInt();
				
				if(column >=1 && column <=3) {
					validColumn = true;
				} else {
					System.out.println("Entre com uma coluna (1, 2 ou 3): ");
				}
			}
		line--;
		column--;
		if(game[line][column] == 'X' || game[line][column] == 'O') {
			System.out.println("Posição já usada, tente novamente.");
		} else {
			game[line][column] = symbol;
			round++;
		}

		for(int i = 0; i<game.length; i++) {
			for(int j = 0; j<game[i].length; j++) {
				System.out.print(game[i][j] + " | ");
			}
			System.out.println();
		}
		//verificando se existem ganhadores
		if ((game[0][0] == 'X' && game[0][1] == 'X' && game[0][2] == 'X') || //linha1
			(game[1][0] == 'X' && game[1][1] == 'X' && game[1][2] == 'X') || //linha2
			(game[2][0] == 'X' && game[2][1] == 'X' && game[2][2] == 'X') || //linha3
			(game[0][0] == 'X' && game[1][0] == 'X' && game[2][0] == 'X') || //coluna1
			(game[0][1] == 'X' && game[1][1] == 'X' && game[2][1] == 'X') || //coluna2
			(game[0][2] == 'X' && game[1][2] == 'X' && game[2][2] == 'X') || //coluna3
			(game[0][0] == 'X' && game[1][1] == 'X' && game[2][2] == 'X') || //diagonal
			(game[0][2]) == 'X' && game[1][1] == 'X' && game[2][0] == 'X') { //diagonal inversa
			System.out.println("Parabéns, jogador 1 ganhou!");
			
		} else if  ((game[0][0] == 'O' && game[0][1] == 'O' && game[0][2] == 'O') || //linha1
					(game[1][0] == 'O' && game[1][1] == 'O' && game[1][2] == 'O') || //linha2
					(game[2][0] == 'O' && game[2][1] == 'O' && game[2][2] == 'O') || //linha3
					(game[0][0] == 'O' && game[1][0] == 'O' && game[2][0] == 'O') || //coluna1
					(game[0][1] == 'O' && game[1][1] == 'O' && game[2][1] == 'O') || //coluna2
					(game[0][2] == 'O' && game[1][2] == 'O' && game[2][2] == 'O') || //coluna3
					(game[0][0] == 'O' && game[1][1] == 'O' && game[2][2] == 'O') || //diagonal
					(game[0][2]) == 'X' && game[1][1] == 'X' && game[2][0] == 'O') { //diagonal inversa
					System.out.println("Parabéns, jogador 2 ganhou!");
					
		} else if (round > 9) {
			win = true;
			System.out.println("Deu velha");
		}
		}
		sc.close();
	}

}
