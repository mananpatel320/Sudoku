import java.util.*;

class Sudoku{
	int[][] puzzle = new int[9][9];
	Sudoku(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				puzzle[i][j] = 0;
			}
		}
	}
	
	void makeGame(){
		System.out.println("INSTRUCTIONS");
		System.out.println("Input three numbers separated by space.");
		System.out.println("First two numbers represent the row and column indices of the number.");
		System.out.println("Third number represents the number to be placed in that position. (Should be between 1 and 9)");
		int posR,posC,num,entries;
		Scanner sc = new Scanner(System.in);
		System.out.print("Number of entries:");
		entries = sc.nextInt();
		for(int i=1;i<=entries;i++){
			posR = sc.nextInt();
			posC = sc.nextInt();
			num = sc.nextInt();
			puzzle[posR][posC] = num;
		}
	}
	
	void printGame(){
		System.out.println("SUDOKU");
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.print(puzzle[i][j] + " ");
			}
		System.out.println();
	 	}
	 }
	 
	 boolean checkSquare(int indexI,int indexJ,int item){
	 	int posR,posC;
	 	posR = (indexI/3) * 3;
	 	posC = (indexJ/3) * 3;
	 	for(int i=posR;i<(posR+3);i++){
	 		for(int j=posC;j<(posC+3);j++){
	 			if(puzzle[i][j] == item){
	 				return true;
	 			}
	 		}
	   }
	   return false;
	 }
	 
	 boolean checkRow(int indexI,int item){
	 	for(int j=0;j<9;j++){
	 		if(puzzle[indexI][j] == item){
	 			return true;
	 		}
	 	}
	 	return false;
	 }
	 
	 boolean checkCol(int indexJ,int item){
	 	for(int i=0;i<9;i++){
	 		if(puzzle[i][indexJ] == item){
	 			return true;
	 		}
	 	}
	 	return false;
	 }
}

class Demo{
	public static void main(String args[]){
		Sudoku su = new Sudoku();
		su.makeGame();
		su.printGame();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(su.puzzle[i][j] == 0){
					for(int k=1;k<=9;k++){
						if(su.checkSquare(i,j,k) == false && su.checkRow(i,k) == false && su.checkCol(j,k) == false){
							su.puzzle[i][j] = k;
							break;
						}
					}
				}
			}
		}
		su.printGame();
	}
}

		
