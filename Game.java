package blackjack;

import java.util.Scanner;
import java.util.Random;



public class Game {
    Player players [] = new Player[4];
    Card[] card_deck = new Card[52];
    int H_Score[]=new int[4];
      boolean valid = true;

     void genCardDeck(){
         int card_no=0;
         for(int suit = 0;suit < 4;suit++)
         {
             for(int rank=0,value=1;rank<13 ;rank++,value++,card_no++)
             {
                 if (value > 9)value = 10;
                 card_deck[card_no]=new Card(suit,rank,value);

             }
         }

     }

Card passcards(){
         Random rn=new Random();
         Card card=null;
         do{
            int Rand_Num=rn.nextInt(51) ;
             card=card_deck[Rand_Num];
             card_deck[Rand_Num]=null;
         }while (card==null);
         return  card;
}

  void setinfoplayers(){
         Scanner sn=new Scanner(System.in);
         for(int i =0 ;i< 3;i++)
         {
             System.out.print("Enter Player "+(i+1)+" name  ");
             players[i]=new Player();
             players[i].P_name=sn.next();
             for(int j=0;j<2;j++) players[i].givecard(this.passcards());
         }
      players[3]=new Player();
      players[3].P_name="Dealer";
      for(int j=0;j<2;j++)  players[3].givecard(this.passcards());

  }

}
