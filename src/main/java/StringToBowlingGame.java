public class StringToBowlingGame {

    public static BowlingGame getBowlingGame(String stringRolls){
        String[] rolls = stringRolls.split("\s+");

        BowlingGame game = new BowlingGame();

        for(int i = 0; i < 10; i++){
            String frame = rolls[i];

            if(frame.equals("X")){
                game.strike();
            } else {
                int firstThrow = Integer.decode(frame.substring(0, 1));
                if(frame.charAt(1) == '/'){
                    int secondThrow = 10 - firstThrow;
                    game.spare(firstThrow, secondThrow);
                } else {
                    int secondThrow = Integer.decode(frame.substring(1, 2));
                    game.openFrame(firstThrow, secondThrow);
                }
            }
        }

        bonusRolls(game, rolls);

        return game;
    }

    private static void bonusRolls(BowlingGame game, String[] rolls){
        String bonus;
        if(rolls[9].equals("X")){
            bonus = rolls[10];
            for(int i = 0; i < 2; i++){
                String bonusThrow = bonus.substring(i, i+1);
                if(bonusThrow.equals("X")){
                    game.bonusRoll(10);
                } else {
                    game.bonusRoll(Integer.decode(bonusThrow));
                }
            }
        } else if(rolls[9].charAt(1) == '/'){
            bonus = rolls[10];
            if(bonus.equals("X")){
                game.bonusRoll(10);
            } else {
                game.bonusRoll(Integer.decode(bonus));
            }
        }
    }

}
