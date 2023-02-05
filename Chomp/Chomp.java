// Chomp Applet Version 2
//
// Cleaned up variable names and reformatted the code.




import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Chomp extends Applet implements ActionListener
{

	public Rectangle mouserec;
	public int cellWidth= 25;
	public int rows=10;
	public int columns=10;
	public boolean position=false;
	public int xpos=0,ypos=0;
	public Chip[] piece =new Chip[101];
	public int chipNum=0;
	public boolean youLose=false;
	public boolean legal=false;
	public Button start,suicide,random,notsmart,play;
	public Panel p=new Panel();
	public Player regPlayer;
	public RandomPlayer randomDude;
	public NotSmartPlayer dumbPlayer;
	public SmartPlayer smartDude;
	public MyPlayer myChomp;
	public String loser;

	public void init()
	 {
      		setSize(550,400);
      
		smartDude=new SmartPlayer();
		dumbPlayer=new NotSmartPlayer();
		randomDude=new RandomPlayer();
		regPlayer=new Player();
		myChomp = new MyPlayer();

		//Set up buttons
		start= new Button("NewGame");
		start.addActionListener(this);
		p.add(start);

		play= new Button("Play");
		play.addActionListener(this);
		p.add(play);

		random= new Button("random");
		random.addActionListener(this);
		p.add(random);

		notsmart= new Button("notsmart");
		notsmart.addActionListener(this);
		p.add(notsmart);

		suicide= new Button("myChomp");
		suicide.addActionListener(this);
		p.add(suicide);
		setLayout(new BorderLayout());
		add("South",p);
      
		//create the chips
		for( int i = 0; i < columns; i++ )
		{
			for( int z = 0; z < rows; z++ )
			{
				xpos=i*25+85;
				ypos=z*25+35;
				piece[chipNum]= new Chip(xpos+18,ypos+18,chipNum);
				if (chipNum<100)
				{chipNum++;}
			}

		}
      
      //dumbPlayer.BoardCreator();

	}//init


	//mouse methods
	public boolean mouseDown(Event evt, int x, int y)
	{
		mouserec= new Rectangle(x,y,2,2);
		for(int z=0;z<100;z++)
		{

			if (mouserec.intersects(piece[z].myRect))
			{

				move(z);
				System.out.println("Chip  "+z+"  taken");
				repaint();
			}

		}
		return(true);
	}

	public void actionPerformed(ActionEvent e){


		if(e.getActionCommand().equals("Play"))
		{
			System.out.println("play");

			while(youLose==false)
			{
				int num;
				loser="player1";
				num= smartDude.move(piece);
				move(num);


				if(youLose==false)
				{
					loser="player2";
					num=smartDude.move(piece);
					move(num);

				}

			}//while
		}//if

		if(e.getActionCommand().equals("NewGame"))
		{
			youLose=false;
			for(int z=0;z<100;z++)
			{
				piece[z].isAlive=true;
			}

			//play(getCodeBase(), "audio/yahoo2.au");
			repaint();
		}//if

		if(e.getActionCommand().equals("myChomp"))
		{
			int num;
			num=myChomp.move(piece);
			move(num);
			repaint();
		}//if

		if(e.getActionCommand().equals("notsmart"))
		{
			int num;
			num=dumbPlayer.move(piece);
			move(num);
			repaint();
         
  		}//if

		if(e.getActionCommand().equals("random"))
		{

			int num;
			num=randomDude.move(piece);
			move(num);
			repaint();
		}//if

	}//actionPerformed



	public void move(int z)
	{
		//play(getCodeBase(), "audio/return.au");
		notLegal(piece[z],z);
		for(int q=0;q<100;q++)
		{
			if ((piece[z].xpos<=piece[q].xpos)&&(piece[z].ypos>=piece[q].ypos))
				piece[q].isAlive=false;
		}

		if (youLose==true)
		{System.out.println(loser+"  is the loser");}
	}//move

	public void notLegal(Chip chip, int chipNum)
	{
		if (chip.isAlive==false)
		{
			play(getCodeBase(), "audio/return.au");
			youLose=true;
			//repaint();
		}

		if (chipNum==9)
		{
			youLose=true;
		}

	}


	public void update(Graphics g) { paint(g); }

	public void paint( Graphics g )  // was boardPaint
	{
		//System.out.println("paint");
		if (youLose)
		{	g.setColor(Color.black);
			g.fillRect(0,0,600,600);
			g.setColor(Color.red);
			g.drawString("YOU LOSE ",100,100);

		}

		if (youLose==false)
		{
			chipNum=0;
			// paint the framework
			g.setColor( Color.white );
         g.fillRect(0, 0, 1000, 1000);
         g.setColor( Color.lightGray );
			g.fillRect( 100, 50, cellWidth*rows, cellWidth*rows );
			g.setColor( Color.black );
			g.drawRect( 95, 45, cellWidth*rows + 10, cellWidth*rows + 10 );

			for( int c = 0; c < rows; c++ )
			{
				for( int r = 0; r < rows; r++ )
				{
					g.drawRect( 100 + cellWidth*c, 50 + cellWidth*r, cellWidth, cellWidth );
				}
			}

			for( int i = 0; i < 100; i++ )
			{

				g.setColor( Color.red );

				if (piece[i].isAlive)
				{
					g.fillOval( piece[i].xpos, piece[i].ypos, cellWidth - 6,  cellWidth - 6 );
					g.setColor( Color.blue );
					g.drawOval( piece[i].xpos, piece[i].ypos, cellWidth - 6,  cellWidth - 6 );
					g.setColor( Color.red );

				}//if

			}//for


			//draw the poison chip in a different color.
			g.setColor( Color.blue );
			g.fillOval( piece[9].xpos, piece[9].ypos, cellWidth - 6,  cellWidth - 6 );
			g.drawOval( piece[9].xpos, piece[9].ypos, cellWidth - 6,  cellWidth - 6 );



		}//close for (youlose==fales)


	}//paint()



}	// close Chomp\


