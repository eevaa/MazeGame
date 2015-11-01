package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import maze.MazeConfig;

public class GameView {

	CreateMazeView cmView=null;
	JPanel startPanel=null;
	ArrayList<String> mainChars=new ArrayList<String>();
	Image mainChar=null;
	JLabel mainElem=null;
	MazeConfig maze=null;
	public GameView(CreateMazeView cmView) {
		// TODO Auto-generated constructor stub
		this.cmView=cmView;
		mainChars=cmView.scView.players;
		initGame();
		
	}
	public int[] getIndex(JPanel pan){
		int i = 0,j=0;
		int[] index = null; 
		for(i=0;i<cmView.mazeDim;i++){
			for(j=0;j<cmView.mazeDim;j++){
				if(cmView.panels[i][j]==pan){
					index=new int[]{i, j};
				}
			}
		}
		return index;
	}
	
	public boolean isBlocked(int[] index){
		JPanel jp=cmView.panels[index[0]][index[1]];
		System.out.println(jp);
		System.out.println(maze.walls.get(0));
		System.out.println(jp.getBackground());
		if(jp.getBackground()==Color.BLACK){
			System.out.println("yes..its  a wall");
			return true;
		}
		
		else
		return false;
		
	}
	
	public void moveRight(JLabel lab){
		System.out.println(lab.getParent());
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0],index[1]+1};
		if(isBlocked(indexNext)==false){
			System.out.println("not blocked");
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]][index[1]+1].add(lab);
		}
	}
	public void moveLeft(JLabel lab){
		System.out.println(lab.getParent());
		
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0],index[1]-1};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]][index[1]-1].add(lab);
		}
	}
	public void moveDown(JLabel lab){
		System.out.println(lab.getParent());
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0]+1,index[1]};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]+1][index[1]].add(lab);
		}
	}
	public void moveUp(JLabel lab){
		System.out.println(lab.getParent());
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0]-1,index[1]};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]-1][index[1]].add(lab);
		}
	}
	
	
	public void initGame()
	{
		cmView.scView.footer.removeAll();
		cmView.scView.footer.repaint();
		cmView.scView.footer.revalidate();
		cmView.scView.header.removeAll();
		cmView.scView.header.repaint();
		cmView.scView.header.revalidate();
		
		for(int i=0;i<cmView.mazeDim;i++){
			for(int j=0;j<cmView.mazeDim;j++){
				JPanel temp=cmView.panels[i][j];
				temp.setBorder(BorderFactory.createDashedBorder(null));
				//temp.setBorder(null);
				temp.setLayout(new BorderLayout());
				temp.setPreferredSize(new Dimension(40,40));
				temp.removeMouseListener(temp.getMouseListeners()[0]);
				temp.repaint();
				temp.revalidate();
			}
		}
			startPanel=cmView.panels[0][0];
			
			try {
				mainChar=ImageIO.read(this.getClass().getResource("/images/"+mainChars.get(0)+".png"));
				mainChar=mainChar.getScaledInstance(40,40,1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mainElem=new JLabel(new ImageIcon(mainChar));
			mainElem.setSize(new Dimension(40,40));
			mainElem.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
			
			
			startPanel.add(mainElem);
			
		
	}

}
