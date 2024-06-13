package blackjack;
//import java.util.Random;

public class Player {
    public String P_name;
    public int score=0;
    private Card P_Hand[] = new Card[11];
    public boolean got_BlackJack = false;

    public boolean busted=false ;
    private int C_Counter =0;
    void givecard(Card card){
        if(C_Counter<11){
            P_Hand[C_Counter]=card;
            C_Counter++;
            score+=card.getValue();
        }
    }

    public Card[] getP_Hand() {
        return P_Hand;
    }
}
