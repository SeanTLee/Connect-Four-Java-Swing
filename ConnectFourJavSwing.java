import java.util.Scanner;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;  
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.Image;
import java.awt.Dimension;
import java. util.ArrayList;
import javax.sound.sampled.*;

public class Connect4
{
    
    private static int playerTurn = 1;
    private static int xRed = 150;
    private static int yRed = 50;
    private static int xYellow = 150;
    private static int yYellow = 50;
    
    private static int y = 4;
    private static int r = 4;

  private String [][] board;
  private static int c1;
  private static int c2;
  private static int c3;
  private static int c4;
  private static int c5;
  private static int c6;
  private static int c7;
  private String player1;
  private String player2;
  private int p1counters;
  private int p2counters;
  private static int col;
  public  int setCol()
{
    
    if (col<0)
    col++;
    if (col>6)
    col--;
    return col;
}
  public Connect4(String player1, String player2)
  {
    col=0;
    this.player1 = player1;
    p1counters=21;
    this.player2 = player2;
    p2counters=21;
    board = new String[6][7];
    for (int j=0; j<board.length; j++)
    {
        for (int k=0; k<board[0].length; k++)
        {
            board[j][k]="x";
        }
    }
    c1=5; c2=5; c3=5; c4=5; c5=5; c6=5; c7=5;
  }
  public void dropCounter()
  {
      String pColor="";
      if (playerTurn==1)
      {
          pColor="R";
      }
      else if(playerTurn==2)
      {
          pColor="Y";
      }
      if (col==0)
      {
            if (c1>=0)
            {
                board[c1][col]=pColor;
                c1--;
                p1counters--;
            }
            else
                System.out.println("Column "+col+" is full.");
      }
      if (col==1)
      {
        if (c2>=0)
        {
            board[c2][col]=pColor;
            c2--;
            p1counters--;
        }
        else
            System.out.println("Column "+col+" is full.");

      }
          if (col==2)
          {
              if (c3>=0)
              {
                  board[c3][col]=pColor;
                  c3--;
                  p1counters--;
              }
              else
                  System.out.println("Column "+col+" is full.");

          }
          if (col==3)
          {
              if (c4>=0)
              {
                  board[c4][col]=pColor;
                  c4--;
                  p1counters--;
              }
              else
                  System.out.println("Column "+col+" is full.");
          }
          if (col==4)
          {
              if (c5>=0)
              {
                  board[c5][col]=pColor;
                  c5--;
                  p1counters--;
              }
              else
                  System.out.println("Column "+col+" is full.");
          }
          if (col==5)
          {
              if (c6>=0)
              {
                  board[c6][col]=pColor;
                  c6--;
                  p1counters--;
              }
              else
                  System.out.println("Column "+col+" is full.");
          }
          if (col==6)
          {
              if (c7>=0)
              {
                  board[c7][col]=pColor;
                  c7--;
                  p1counters--;
              }
              else
                  System.out.println("Column "+col+" is full.");
          }
  }
  public int hCheck()
  {
      int rCount=0;
      int yCount=0;
      for (String[] row: board)
      {
          for (int i=0; i<row.length; i++)
          {
              if (row[i].equals("R"))
              {
                  rCount++;
                  if (rCount==4)
                      return 1;
              }
              else
                  rCount=0;
          }
      }
      for (String[] row: board)
      {
          for (int n=0; n<row.length; n++)
          {
              if (row[n].equals("Y"))
              {
                  yCount++;
                  if (yCount==4)
                      return 2;
              }
              else
                  yCount=0;
          }
      }
      return 0;
  }
  public int vCheck()
 {
     int rCount=0;
     int yCount=0;
     for (int i=0; i<board[0].length; i++)
     {
         for (int n=0; n<board.length; n++)
         {
             if (board[n][i].equals("R"))
             {
                 rCount++;
                 if (rCount==4)
                     return 1;
             }
             else
                 rCount=0;
         }
     }
     for (int i=0; i<board[0].length; i++)
     {
         for (int n=0; n<board.length; n++)
         {
             if (board[n][i].equals("Y"))
             {
                 yCount++;
                 if (yCount==4)
                     return 2;
             }
             else
                 yCount=0;
         }
     }
     return 0;   
 }
 public boolean fourInRow(ArrayList<String> list, String color)
  {
    for (String element: list)
      {
        if (!element.equals(color))
            return false;
      }
    return true;
  }
  public int rightDCheck()
  {
    ArrayList<String> rList=new ArrayList<String>();
    ArrayList<String> yList=new ArrayList<String>();
    for (int i=board.length-1; i>3; i--)
      {
        for (int j=0; j<board[0].length-3; j++)
          {
            if (board[i][j].equals("R"))
            {
              rList.add(board[i][j]);
              rList.add(board[i-1][j+1]);
              rList.add(board[i-2][j+2]);
              rList.add(board[i-3][j+3]);
              if (fourInRow(rList, "R"))
              {
                return 1;
              }
            }
            if (board[i][j].equals("Y"))
              {
                yList.add(board[i][j]);
                yList.add(board[i-1][j+1]);
                yList.add(board[i-2][j+2]);
                yList.add(board[i-3][j+3]);
                if (fourInRow(yList, "Y"))
                {
                  return 2;
                }
              }
          }
        }
    return 0;
  
  }
  public int leftDCheck()
    {
      ArrayList<String> rList=new ArrayList<String>();
      ArrayList<String> yList=new ArrayList<String>();
      for (int i=0; i<board.length-3; i++)
        {
          for (int j=0; j<board[0].length-3; j++)
            {
              if (board[i][j].equals("R"))
              {
                rList.add(board[i][j]);
                rList.add(board[i+1][j+1]);
                rList.add(board[i+2][j+2]);
                rList.add(board[i+3][j+3]);
                if (fourInRow(rList, "R"))
                {
                  return 1;
                }
              }
              if (board[i][j].equals("Y"))
                {
                  yList.add(board[i][j]);
                  yList.add(board[i+1][j+1]);
                  yList.add(board[i+2][j+2]);
                  yList.add(board[i+3][j+3]);
                  if (fourInRow(yList, "Y"))
                  {
                    return 2;
                  }
                }
            }
          }
      return 0;
    }

 public boolean anotherRound()
{
	if (hCheck()==1 || vCheck()==1 || rightDCheck()==1 || leftDCheck()==1)
	{
		JOptionPane.showMessageDialog(null, player1+ " wins!");
         return false;

        }
	if (hCheck()==2 || vCheck()==2 || rightDCheck()==2 || leftDCheck()==2)
	{
           JOptionPane.showMessageDialog(null, player2+ " wins!");
         return false;

    }
    else
    {
        return true;
    }
}

 public void playGame()
 {
    if(anotherRound())
    {
         dropCounter();
    }
 }
 public void printBoard()
 {
     for (String[] row:board)
     {
         for (String element:row)
         {
             System.out.print(element+" ");
         }
         System.out.println();
     }
 }
     public static void intro(){
     String[] options = {"Yes","No"};
    int knowToPlay = JOptionPane.showOptionDialog(null, "Do you know how to play Connect 4?","Question", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    if(knowToPlay == 1) {
        JOptionPane.showMessageDialog(null,"You can use the left and right arrow keys to move the piece left or right or you can click on the physical buttons to move the piece."); 
        JOptionPane.showMessageDialog(null," Press the drop button or space to drop the piece. You must get 4 in a row either horizontally, diagonally, or vertically in order to win. Turns alternate between player one and two.");
    }
    else
            JOptionPane.showMessageDialog(null,"May the better player win.");
}
public static void playMusic(String filePath, boolean loop) {
        try {
            // Open an audio input stream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Connect4.class.getResource(filePath));

            // Get a clip resource
            Clip clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream
            clip.open(audioInputStream);

            // Set loop points if looping is requested
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }

            // Start playing the sound
            clip.start();

            // If loop is not requested, wait for the sound to finish playing
            if (!loop) {
                while (clip.isRunning()) {
                    Thread.sleep(10);
                }
                clip.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



 public static void main(String[] args)
 {
    // Scanner playerName=new Scanner(System.in);
    // System.out.println("Player1: ");
    // String name1=playerName.nextLine();
    // System.out.println("Player 2: ");
   //  String name2=playerName.nextLine();
   //  playerName.close();
   String filePath = "music/song.wav";
    

     
    playMusic(filePath, true);

    Connect4 c=new Connect4("Red", "Yellow");
     
    JFrame game = new JFrame("Connect Four Game");  
    intro();

    
    
    JLabel board = new JLabel(new ImageIcon("image.png"));
    board.setBounds(100,100,800,800);
 
    //create game pieces
    //red chip
    JLabel redChip = new JLabel(new ImageIcon("bestchipred.png"));
    redChip.setBounds(200,120,100,100);
    ImageIcon icon = new ImageIcon("bestchipred.png");
    Image img = icon.getImage();
    Image imgScale = img.getScaledInstance(redChip.getWidth(),redChip.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon = new ImageIcon(imgScale);
    redChip.setIcon(scaledIcon);
    //yellow chip
    JLabel yellowChip = new JLabel(new ImageIcon("bestchipyellow.png"));
    yellowChip.setBounds(300,120,100,100);
    ImageIcon icon2 = new ImageIcon("bestchipyellow.png");
    Image img2 = icon2.getImage();
    Image imgScale2 = img2.getScaledInstance(yellowChip.getWidth(),yellowChip.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon2 = new ImageIcon(imgScale2);
    yellowChip.setIcon(scaledIcon2);
    //board
    
    //rules
    JLabel rules = new JLabel(new ImageIcon("download.png"));
    rules.setBounds(1000,500,100,100);
    ImageIcon icon3 = new ImageIcon("download.png");
    Image img3 = icon3.getImage();
    Image imgScale3 = img3.getScaledInstance(rules.getWidth(),rules.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcon3 = new ImageIcon(imgScale3);
    rules.setIcon(scaledIcon3);

    redChip.setLocation(xRed,yRed);
    yellowChip.setLocation(xYellow,yYellow);

     

    JButton leftArrow = new JButton("<");  
    leftArrow.setBounds(350,800,100,30);  
    leftArrow.addActionListener(
    new ActionListener()
    {  
    public void actionPerformed(ActionEvent e)
        {  
        col--;
        if(playerTurn == 1)
        xRed-=100;
        if(playerTurn == 2)
        xYellow-=100;
        if(xRed < 150)
        xRed+=100;
        if(xYellow < 150)
        xYellow+=100;
          if(playerTurn == 1){
            redChip.setLocation(xRed,yRed);
        }
        if(playerTurn == 2){
            yellowChip.setLocation(xYellow,yYellow);
        }   
        }  
    });  
    JButton rightArrow = new JButton(">");  
    rightArrow.setBounds(550,800,100,30);  
        rightArrow.addActionListener(
    new ActionListener()
    {  
    public void actionPerformed(ActionEvent e)
        {  
        col++;   
        if(playerTurn == 1)
        xRed+=100;
        if(playerTurn == 2 && xYellow < 750)
        xYellow+=100;
        if(xRed > 750){
        xRed-=100;
        if(xYellow > 750)
        xYellow-=100;
    }
          if(playerTurn == 1){
            redChip.setLocation(xRed,yRed);
        }
        if(playerTurn == 2){
            yellowChip.setLocation(xYellow,yYellow);
        }  
        }  
    });  
    JButton down = new JButton("Drop");  
    down.setBounds(450,800,100,30);  
        down.addActionListener(
    new ActionListener()
    {  
    public void actionPerformed(ActionEvent e)
        {  

    JLabel redChipr = new JLabel(new ImageIcon("bestchipred.png"));
    redChipr.setBounds(200,120,100,100);
    ImageIcon iconr = new ImageIcon("bestchipred.png");
    Image imgr = iconr.getImage();
    Image imgScaler = imgr.getScaledInstance(redChipr.getWidth(),redChipr.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIconr = new ImageIcon(imgScaler);
    redChipr.setIcon(scaledIconr);
        
    JLabel yellowChipy = new JLabel(new ImageIcon("bestchipyellow.png"));
    yellowChipy.setBounds(300,120,100,100);
    ImageIcon icony = new ImageIcon("bestchipyellow.png");
    Image imgy = icony.getImage();
    Image imgScaley = imgy.getScaledInstance(yellowChipy.getWidth(),yellowChipy.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon scaledIcony = new ImageIcon(imgScaley);
    yellowChipy.setIcon(scaledIcony);
    if(playerTurn == 1)
    game.add(redChipr); 
    else
    game.add(yellowChipy); 
    r++;
    y++;
        int num = 0;
        if(col == 0){
          num = c1;
          
        }
        if(col == 1){
          num = c2;
        }
        if(col == 2){
          num = c3;
        }
        if(col == 3){
          num = c4;
        }
        if(col == 4){
          num = c5;
        }
        if(col == 5){
          num = c6;
        }
        if(col == 6){
          num = c7;
        }
        c.dropCounter();
        if(playerTurn == 1)
        yRed = 50 + 100*(num+1);
        if(playerTurn == 2)
        yYellow = 50 + 100*(num+1);
        if(yRed > 749)
        yRed = 750;
        if(yYellow > 749)
        yYellow = 750;
                c.printBoard();

        if(playerTurn == 1){
            playerTurn = 2;
            System.out.println("Player" + playerTurn + "'s turn");
            redChipr.setLocation(xRed,yRed);
            redChip.setVisible(false);
            yellowChip.setVisible(true);
        }
        else if(playerTurn == 2){
            playerTurn = 1;
            System.out.println("Player" + playerTurn + "'s turn");
            yellowChipy.setLocation(xYellow,yYellow);
            yellowChip.setVisible(false);
            redChip.setVisible(true);

        }
        

        yRed = 50;
        yYellow = 50;
        xRed = 150;
        xYellow = 150;
        col = 0;
 redChip.setLocation(xRed, yRed);
        yellowChip.setLocation(xYellow, yYellow);
            c.anotherRound();
                
        }  
    });  
    game.add(board); 
    game.add(redChip); 
    game.add(yellowChip); 
    game.add(rules); 

    game.add(rightArrow);
    game.add(leftArrow);
    game.add(down);
    game.setSize(1000,1000);  

    game.setLayout(null);  
    game.setVisible(true);   

 }
}











