package blackjack;


import java.util.Scanner;

public class BlackJack {
    static Game game=new Game();
    public static void main(String[] args) {
        GUI gui=new GUI();
        game.genCardDeck();
        game.setinfoplayers();

        gui.runGUI(
                game.card_deck,
                game.players[0].getP_Hand(),
                game.players[1].getP_Hand(),
                game.players[2].getP_Hand(),
                game.players[3].getP_Hand());

        playerturn(gui);
        for(int i =0 ;i< 4;i++) //update game score
            game.H_Score[i]=(game.players[i].score<=21)?game.players[i].score:0;
       dealersturn(gui);
        for(int i =0 ;i<4;i++) //update game score
            game.H_Score[i]=(game.players[i].score<=21)?game.players[i].score:0;
        checkgame();

    }

    public static void  playerturn(GUI gui){
        Scanner sn=new Scanner(System.in);

        for(int i = 0 ;i<game.players.length-1;i++){
            String input="";
            game.valid=true;
            while (!(input.toUpperCase().equals("STAND")&& game.valid))
            {

               {
                    System.out.println("Player Number "+(i+1)+" Choose to Hit or Stand");
                    input= sn.next();
                    if(input.toUpperCase().equals("HIT"))
                    {
                        game.players[i].givecard(game.passcards());
                        gui.updatePlayerHand(game.passcards(),i);
                    }
                    else if(input.toUpperCase().equals("STAND")) break;

                    else
                    {
                        System.out.println("Enter One Choice From Above");
                        continue;
                    }
                }
                if(game.players[i].score>21)
                {
                    game.valid=false;
                    game.players[i].busted=true;
                    System.out.println("You Are Busted!!!");
                    break;
                }
                else if(game.players[i].score==21)
                {
                    game.valid=false;
                    game.players[i].got_BlackJack=true;
                    System.out.println("You Got Black Jack");
                    break;
                }
            }
        }

    }

    public static void dealersturn(GUI gui){

        boolean win=true;
        int highscore=0;
        for (int i =0;i<game.H_Score.length-1;i++) {
            if (game.H_Score[i] >= game.players[3].score) win = false;
            if (game.H_Score[i] > highscore) highscore = game.H_Score[i];

            }
        if (!(win)) {
            while (game.players[3].score < highscore) {
                game.players[3].givecard(game.passcards());
                gui.updateDealerHand(game.passcards(), game.card_deck);

            }

        }


        }

    public static void checkgame(){
        int highscore=0;
        int winnner=-1;
        for(int i =0;i<4;i++){
            if(game.H_Score[i]>highscore){
                highscore=game.H_Score[i];
                winnner=i;
            }
            if(game.players[i].got_BlackJack){
                winnner=i;
                break;
            }
        }
        if(winnner>=0)  System.out.println("The Winner Is "+game.players[winnner].P_name+" with Score "+highscore);

    }
}
