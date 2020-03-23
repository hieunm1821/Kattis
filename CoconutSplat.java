import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CoconutSplat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int syllables = sc.nextInt();
        int players = sc.nextInt();

        Deque<Coconut> game = new LinkedList<>();
        // there are all folded hands at the start, same as the number of players
        for (int i = 0; i < players; i++) {
            game.add(new Coconut(2, i+1));
        }

        // start the game
        // game is ongoing while there is more than 1 player
        while (game.size() > 1) {
            // 1 player may have both hands left in the game, but we dont need to worry about it too much

            // the coconut that will be tapped next is always at the head of the deque

            for (int i = 0; i < syllables-1; i++) { // tap all the ones that dont matter (all but the last)
                game.addLast(game.removeFirst());
            }

            Coconut affectedCoconut = game.removeFirst();

            if (affectedCoconut.state == 2) {
                // make 2 fists and start on the earlier fist
                game.addFirst(new Coconut(1, affectedCoconut.playerNum));
                game.addFirst(new Coconut(1, affectedCoconut.playerNum));
            } else if (affectedCoconut.state == 1) {
                affectedCoconut.state = 0;
                game.addLast(affectedCoconut);
            } // simply remove if state == 0, so nothing
        }

        Coconut lastCoconut = game.getFirst();
        System.out.println(lastCoconut.playerNum);
    }
}

class Coconut {
    public int state;
    // 2: folded, 1: fist, 0: palm, nothing for behind the back
    public int playerNum;

    public Coconut (int state, int playerNum) {
        this.state = state;
        this.playerNum = playerNum;
    }
}
