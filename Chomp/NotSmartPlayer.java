public class NotSmartPlayer extends Player
{

   public int[] chipN= new int[10];
   public int[] chipNR= new int[10];
   public int total=0;
   public int totalR=0;
   
   public boolean Winner=false;
   public Board[] reduced= new Board[1000];
   public Board[] winner= new Board[1000];
   public Board[] loser = new Board[1000];
   public int reducedNum=0;
   public int winnerCount=0;
   public int lCount = 0;
   
   public int XX, YY, ZZ;
   
   public int move(Chip[] chip)
   {
      total=0;
      totalR=0;
      convCol(chip);
      convRow(chip);
   
      loser[0] = new Board (1,0,0);
      Winner = false;
   
      BoardCreator();
      
      for(int x=0; x<winnerCount;x++)
      {
         if(winner[x].c1 == chipN[0] && winner[x].c2 == chipN[1] && winner[x].c3 == chipN[2])
         {
            return(winner[x].takeChip);
         }
      }
      return(19); 
   }
   
   /*public void check()
   {
      for(int x=0;x<lCount;x++)
      {
         System.out.println(loser[x].c1+" "+loser[x].c2+" "+loser[x].c3);
      }
   }*/
   
   
   public void BoardCreator()
   {
      for(int x=1;x<4;x++)
      {
         for(int y=0;y<4;y++)
         {
            for(int z=0;z<4;z++)
            {
               if(y>=z && x>=y && x!=0)
               {               
                  reduce(x,y,z); 
               }
            }
         }
      }
   }
   
   
   public void reduce(int x, int y, int z)
   {
      reducedNum=0;
      Winner=false;
      XX=x;
      YY=y;
      ZZ=z;
      
      for(int c=0; c<z; c++)
      {
         ZZ--;
         
         reduced[reducedNum]= new Board(XX,YY,ZZ);
         reducedNum++;
                  
         for(int i=0;i<lCount;i++)
         {
            if(XX == loser[i].c1 && YY == loser[i].c2 && ZZ == loser[i].c3)
            { 
               Winner = true;
               winner[winnerCount] = new Board (x,y,z);
               winner[winnerCount].takeChip = 29-ZZ;
               winnerCount++;
            }
         }
      }
      ZZ=z;
      
   
      for(int b=0; b<y; b++)
      {
         YY--;
         if(ZZ>YY)
         {
            ZZ=YY;
         }     
         
         reduced[reducedNum]= new Board(XX,YY,ZZ);
         reducedNum++;
                     
         for(int i=0;i<lCount;i++)
         {
            if(XX == loser[i].c1 && YY == loser[i].c2 && ZZ == loser[i].c3)
            { 
               Winner = true;
               winner[winnerCount] = new Board (x,y,z);
               winner[winnerCount].takeChip = 19-YY;
               winnerCount++;
            }
         }
      }
      ZZ=z;
      YY=y;
      
   
   
      for(int a=1; a<x; a++)
      {
         XX--;
         if(YY>XX)
         {
            YY=XX;
         }
         if(ZZ>YY)
         {
            ZZ=YY;
         }
         
         reduced[reducedNum]= new Board (XX,YY,ZZ);
         reducedNum++;
               
         for(int i=0;i<lCount;i++)
         {
            if(XX == loser[i].c1 && YY == loser[i].c2 && ZZ == loser[i].c3)
            { 
               Winner = true;
               winner[winnerCount] = new Board (x,y,z);
               winner[winnerCount].takeChip = 9-XX;
               winnerCount++;
            }
         }
      }
      ZZ=z;
      YY=y;
      XX=x;
      
      
      if(Winner==false)
      {
         loser[lCount] = new Board (x,y,z);
         lCount++;
      }
   }


   public void convCol(Chip[] chip)
   {
      for(int x=0; x<10;x++)
      {
         chipN[x]=0;
         for(int z=0; z<10;z++)
         {
            if (chip[total].isAlive)
            {
               //System.out.println("TOTAL: "+total);
               chipN[x]=chipN[x]+1;
            }
            total=total+1;
         }//for z
      }//for n
   }//convCol
   
   public void convRow (Chip[] chip)
   {
      for(int x=0; x<10;x++)
      {
         chipNR[x]=0;
         for(int z=0; z<10;z++)
         {
            if (totalR<100 && chip[totalR].isAlive)
            {
               System.out.println("TOTALROW: "+totalR);
               chipNR[x]=chipNR[x]+1;
            }
            totalR=totalR+10;
         }
      }
   }

}//class