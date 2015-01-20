package game;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class field {
	
	//DIRECTIONS TO SHOOT
	static final int UP = 0;
	static final int UP_RIGHT = 1;
	static final int RIGHT = 2;
	static final int DOWN_RIGHT = 3;
	static final int DOWN = 4;
	static final int DOWN_LEFT = 5;
	static final int LEFT = 6;
	static final int UP_LEFT = 7;
	
	//VALUES OF THE ARRAY
	static final int FREE = 0;
	static final int BORDER = 1;
	static final int PLAYER_ONE = 2;
	static final int PLAYER_TWO = 3;
	static final int OUT_OF_GAME = 4;

	private int[][][] field;	// [h�he][breite][1-4(0:_, 1:|, 2:/,3:\)]
	int Balli = 7;
	int Ballj = 5;
	private int player = 2;

	private Player one;
	private Player two;
	private static field testField;
	private static int quality = 0;
	private static int max_turn_quality = 0;
	private static int[] quality_of_direction = {0,-1,-1,-1,0,1,1,1};
	public static ArrayList<String> pList = new ArrayList<String>();
	// Setzen der Umrandung des Spielfeldes
	public field(Player beginner, Player second) {
		beginner.intern_id = 2;
		one = beginner;
		second.intern_id = 3;
		two = second;

		field = new int[][][] {
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 4, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 1, 1, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 1, 0, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 2, 2, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 3, 0, 0, 0 }, { 4, 3, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 0, 2, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 4, 3, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 2, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 3, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 0, 1, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
						{ 4, 1, 4, 4 }, { 4, 4, 4, 4 } },
				{ { 4, 4, 4, 4 }, { 4, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 1, 4, 4, 4 }, { 1, 4, 4, 4 }, { 1, 4, 4, 4 },
						{ 4, 4, 4, 4 }, { 4, 4, 4, 4 } } };

	}

	public field(field toCopy) {
		this.Balli = toCopy.Balli;
		this.Ballj = toCopy.Ballj;
		this.player = toCopy.player;
		this.field = new int[10][14][4];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 14; j++) {
				for (int k = 0; k < 4; k++) {

					this.field[i][j][k] = toCopy.field[i][j][k];
				}
			}
		}
	}

	// Gibt Wert des Feldes zur�ck
	public int getValue(int i, int j, int k) {
		return field[j][i][k];
	}

	// Liegt der Ball auf dem Punkt (i,j)
	public boolean isBall(int i, int j) {
		if (Balli == i && Ballj == j)
			return true;
		return false;
	}

	// Ist in Schussrichtung schon ein Strich gezogen?
	private boolean isValidShoot(int direction) { //
		if ((direction == UP_LEFT && 0 != this.getValue(Balli - 1, Ballj - 1, 3))
				|| (direction == UP && 0 != this.getValue(Balli, Ballj - 1, 1))
				|| (direction == UP_RIGHT && 0 != this.getValue(Balli, Ballj - 1, 2))
				|| (direction == LEFT && 0 != this.getValue(Balli - 1, Ballj, 0))
				|| (direction == RIGHT && 0 != this.getValue(Balli, Ballj, 0))
				|| (direction == DOWN_LEFT && 0 != this.getValue(Balli - 1, Ballj, 2))
				|| (direction == DOWN && 0 != this.getValue(Balli, Ballj, 1))
				|| (direction == DOWN_RIGHT && 0 != this.getValue(Balli, Ballj, 3))) {
			return false;
		}
		return true;
	}

	// Ball wird in angegebene Richtung bewegt und der Strich wird gesetzt
	public boolean shoot(int direction) {
		if (!isValidShoot(direction)) {
			JOptionPane.showMessageDialog(null, "Ung�ltiger Zug!");
			return false;

		} else {
			switch (direction) { // qweadyxc
			case (UP_LEFT):
				field[Ballj - 1][Balli - 1][3] = player;
				Balli -= 1;
				Ballj -= 1;
				break;
			case (UP):
				field[Ballj - 1][Balli][1] = player;
				Ballj -= 1;
				break;
			case (UP_RIGHT):
				field[Ballj - 1][Balli][2] = player;
				Balli += 1;
				Ballj -= 1;
				break;
			case (LEFT):
				field[Ballj][Balli - 1][0] = player;
				Balli -= 1;
				break;
			case (RIGHT):
				field[Ballj][Balli][0] = player;
				Balli += 1;
				break;
			case (DOWN_LEFT):
				field[Ballj][Balli - 1][2] = player;
				Balli -= 1;
				Ballj += 1;
				break;
			case (DOWN):
				field[Ballj][Balli][1] = player;
				Ballj += 1;
				break;
			case (DOWN_RIGHT):
				field[Ballj][Balli][3] = player;
				Balli += 1;
				Ballj += 1;
				break;
			}
			again(direction);
			return true;
		}
	}

	public boolean goBack(int direction, int tempPlayer) {
		switch (direction) { // qweadyxc
		case (UP_LEFT):
			Balli += 1;
			Ballj += 1;
			field[Ballj - 1][Balli - 1][3] = 0;

			break;
		case (UP):
			Ballj += 1;

			field[Ballj - 1][Balli][1] = 0;
			break;
		case (UP_RIGHT):
			Balli -= 1;
			Ballj += 1;
			field[Ballj - 1][Balli][2] = 0;

			break;
		case (LEFT):
			Balli += 1;
			field[Ballj][Balli - 1][0] = 0;

			break;
		case (RIGHT):
			Balli -= 1;
			field[Ballj][Balli][0] = 0;

			break;
		case (DOWN_LEFT):
			Balli += 1;
			Ballj -= 1;
			field[Ballj][Balli - 1][2] = 0;

			break;
		case (DOWN):
			Ballj -= 1;
			field[Ballj][Balli][1] = 0;

			break;
		case (DOWN_RIGHT):
			Balli -= 1;
			Ballj -= 1;
			field[Ballj][Balli][3] = 0;

			break;
		}
		player = 3;
		return true;
	}

	// Testet ob der Spieler nochmal ziehen kann
	private void again(int direction) {
		switch (direction) { // qweadyxc
		case (UP_LEFT):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (UP):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (UP_RIGHT):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (LEFT):
			if (field[Ballj][Balli][1] != 0 || field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (RIGHT):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN_LEFT):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][1] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli - 1][3] != 0) {
				return;
			} else {
				break;
			}
		case (DOWN_RIGHT):
			if (field[Ballj][Balli][0] != 0 || field[Ballj][Balli][1] != 0
					|| field[Ballj][Balli][3] != 0
					|| field[Ballj][Balli - 1][2] != 0
					|| field[Ballj][Balli - 1][0] != 0
					|| field[Ballj - 1][Balli][2] != 0
					|| field[Ballj - 1][Balli][1] != 0) {
				return;
			} else {
				break;
			}
		}
		if (player == 2) {
			player = 3;
		} else if (player == 3) {
			player = 2;
		}
	}

	// Testet ob der Ball im Tor ist
	public boolean isWinner(Player test) {

		if (Balli == 1) {
			two.intern_winner= true;
		}
		if (Balli == 13) {
			one.intern_winner=true;
		}
		if (field[Ballj][Balli][0] != 0 && field[Ballj][Balli][1] != 0
				&& field[Ballj][Balli][3] != 0
				&& field[Ballj][Balli - 1][2] != 0
				&& field[Ballj][Balli - 1][0] != 0
				&& field[Ballj - 1][Balli][2] != 0
				&& field[Ballj - 1][Balli][1] != 0
				&& field[Ballj - 1][Balli - 1][3] != 0) {
			if (player == 2) {
				one.intern_winner=true;
			}
			if (player == 3) {
				two.intern_winner = true;
			}
		}
		if(test == one && one.intern_winner==true){
			return true;
		}
		else if(test == two && two.intern_winner == true){
			return true;
		}
		return false;
	}

	public int getPlayer() {
		return player;
	}

	// KI
	public String getBestShoots() {
		ArrayList<String> allShoots = new ArrayList<String>();

		testField = new field(this);
		pList.clear();
		allShoots = testDirections("");
		System.out.println(allShoots.toString());
		System.out.println(max_turn_quality);
		return "Hallo";
	}

	private ArrayList<String> testDirections(String turn) {
		for(int i = 0; i<8;i++){
			//Durchl�uft alle 8 Richtungen
			if (testField.isValidShoot(i)) {
				//Wenn ich in diese Richtung spielen kann
				testField.shoot(i);
				turn = turn + i;
				quality += quality_of_direction[i];
				System.out.print(quality+ " ");
				if (testField.player == 3) {
					//Wenn der Spieler nochmal an der Reihe ist -> Rekursion
					testDirections(turn);
				} else {
					//Wenn der Spieler nicht mehr an der Reihe ist -> Maximum testen
					if(max_turn_quality < quality){
						//Wenn aktuell getesteter Zug besser als vorherige ist
						pList.clear();
						pList.add(turn);
						max_turn_quality = quality;
					}
					else if(max_turn_quality == quality){
						//Wenn der beste und der aktuelle gleich gut sind
						pList.add(turn);
					}
					quality = 0;
					
				}
				turn = turn.substring(0, turn.length() - 1);
				testField.goBack(i,3);
			}
		}
		return pList;
	}

}
