package fcu.iecs.oop.pokemon;

public class GYM {
	public static Player fight(Player... players) {

		String name1, name2;

		int i = 0, xnum = 0, ynum = 0, temp;
		PokemonType type1;
		Pokemon[] x, y;

		name1 = players[0].getPlayerName();
		name2 = players[1].getPlayerName();

		x = players[0].getPokemons();
		y = players[1].getPokemons();
		type1 = x[0].getType();

		while (i <= 3) {
			if (xnum >= 2) {
				players[0].setLevel(1);
				System.out.printf("Winner is [%s], and his/her level becomes [%d].", name1, players[0].getLevel());
				return players[0];
			} else if (ynum >= 2) {
				players[1].setLevel(1);
				System.out.printf("Winner is [%s], and his/her level becomes [%d].", name2, players[1].getLevel());
				return players[1];
			}

			if (x[i].getType().equals(y[i].getType()))// 種類一樣
			{
				if (x[i].getCp() > y[i].getCp()) {
					xnum++;
				} else if (x[i].getCp() < y[i].getCp()) {
					ynum++;
				} else {
					temp = (int) (Math.random() * 2 + 1);
					if (temp == 1)
						xnum++;
					else if (temp == 2)
						ynum++;
				}
			} else if (x[i].getType().equals(type1.FIRE)) {
				if (y[i].getType().equals(type1.GRASS))
					xnum++;
				else if (y[i].getType().equals(type1.WATER))
					ynum++;
			} else if (x[i].getType().equals(type1.GRASS)) {
				if (y[i].getType().equals(type1.FIRE))
					ynum++;
				else if (y[i].getType().equals(type1.WATER))
					xnum++;
			} else if (x[i].getType().equals(type1.WATER)) {
				if (y[i].getType().equals(type1.FIRE))
					xnum++;
				else if (y[i].getType().equals(type1.GRASS))
					ynum++;
			}
			i++;
		}
		return players[0];
	}

}