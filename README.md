# American Ten-Pin Bowling total score calculator

This is an implementation of the coding kata described [here](http://codingdojo.org/kata/Bowling/).

### Create an empty score sheet for the bowling game
```java
BowlingGame game = new BowlingGame();
```
### Fill up the scoresheet
```java
game.openFrame(fistThrow, secondThrow);
game.spare(firstThrow, secondThrow);
game.strike();
game.bonusRoll();
```
### Use the StringToBowlingGame to convert a string score to BowlingGame object
```java
String score1 = "X X X X X X X X X X XX";
        String score2 = "43 44 5/ 6/ X 5/ X 72 10 3/ 9";
        String score3 = "8/ X 3/ 4/ X 5/ 0/ 5/ 3/ X 64";
        BowlingGame game = StringToBowlingGame.getBowlingGame(score[1|2|3]);
```