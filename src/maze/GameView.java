package maze;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameView {

	CreateMazeView cmView=null;
	JPanel startPanel=null;
	ArrayList<String> mainChars=new ArrayList<String>();
	//Image mainChar=null;
	JLabel mainElem=null;
	MazeConfig maze=null;
        ArrayList<Quest> quests=new ArrayList<Quest>();
	ArrayList<JLabel> answers=new ArrayList<JLabel>();
	ArrayList<JLabel> enemies=new ArrayList<JLabel>();
	int currQuestCount=0;
	int answerCount=0;
	int enemyCount=0;
	Quest currQuest=null;
	Boolean forward=true;
        JPanel mainPanel=null;
        JPanel header=null;
        JLabel heading=null;
        
	public GameView(CreateMazeView cmView) {
		// TODO Auto-generated constructor stub
		this.cmView=cmView;
		mainChars=cmView.scView.players;
		initGame();
		
	}
        
        	public void addQuestElements() {
		// TODO Auto-generated method stub
		
		//Positioning Main Element 
		startPanel=cmView.panels[0][0];
		currQuest=quests.get(currQuestCount);
		mainElem=new JLabel(new ImageIcon(currQuest.mainElement.elemImage));
		startPanel.add(mainElem);
		startPanel.repaint();
		
		//Positioning Answer Elements
		 answerCount=currQuest.elementsInQuest.size();
		for(int a=0;a<answerCount;a++){
		int i=0,j=0;
		Random random=new Random();
		 i=random.nextInt(cmView.mazeDimY-1 )+1;
		 j=random.nextInt(cmView.mazeDimX -1)+1;

		//If the resulting panel is part of the maze
		if(maze.walls.contains(cmView.panels[i][j])){
			a--;
			continue;
		}
		//otherwise
		JLabel ans=new JLabel(new ImageIcon(currQuest.elementsInQuest.get(a).elemImage));
		JPanel pan=cmView.panels[i][j];
		answers.add(ans);
		pan.add(ans);
		
		}
		
		//Start moving the correct answers
		
		for(JLabel jlb:answers){
			
			Timer moveChar=new Timer(900, new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
				JPanel parentPan=(JPanel) jlb.getParent();
				 
				int indexi=0,indexj=0;
				for(int a=0;a<cmView.mazeDimY;a++){ 	
					for(int b=0;b<cmView.mazeDimX;b++){
						if(cmView.panels[a][b]==parentPan){
							indexi=a;
							indexj=b;	
						}
					}
				}
				
				//Choosing if I should move i or j
				  int randomInt = new Random().nextInt(100);
				if(randomInt%2==0){
					
					if(indexi+1==cmView.mazeDimY)
						forward=false;
					if(indexi==0)
						forward=true;
					
					
					
					if(forward){
						indexi++;
					}
					else{
						indexi--;
					}
					//If it meets a wall
					if(maze.walls.contains(cmView.panels[indexi][indexj])){
						forward=!forward;
						
					}
					else{
						parentPan.remove(jlb);
						parentPan.repaint();
					cmView.panels[indexi][indexj].add(jlb);
					cmView.panels[indexi][indexj].repaint();
					}
					
					
					
				}
				
				else {
					if(indexj+1==cmView.mazeDimX)
						forward=false;
					if(indexj==0)
						forward=true;

					if(forward){
						indexj++;
					}
					else{
						indexj--;
					}
					//If it meets a wall
					if(maze.walls.contains(cmView.panels[indexi][indexj])){
						forward=!forward;
						
					}
					else if(cmView.panels[indexi][indexj].getComponentCount()>0){
						forward=!forward;
						
					}
					else{
						parentPan.remove(jlb);
						parentPan.repaint();
					cmView.panels[indexi][indexj].add(jlb);
					cmView.panels[indexi][indexj].repaint();
					}
				}
				
			
				}
			});
			moveChar.start();
			
		}
		
		//Positioning Enemies Elements
		 enemyCount=currQuest.enemies.size();
		for(int a=0;a<enemyCount;a++){
		int i=0,j=0;
		Random random=new Random();
		 i=random.nextInt(cmView.mazeDimY-1)+1;
		 j=random.nextInt(cmView.mazeDimX-1 )+1;
		 
		//If the resulting panel is part of the maze
		if(maze.walls.contains(cmView.panels[i][j])){
			a--;
			continue;
		}
		//otherwise
		JLabel ans=new JLabel(new ImageIcon(currQuest.enemies.get(a).elemImage));
		JPanel pan=cmView.panels[i][j];
		enemies.add(ans);
		pan.add(ans);
		
		}
		
		//Start moving the enemies
		
				for(JLabel jlb:enemies){
					
					Timer moveChar=new Timer(900, new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
						JPanel parentPan=(JPanel) jlb.getParent();
						 
						int indexi=0,indexj=0;
						for(int a=0;a<cmView.mazeDimY;a++){ 	
							for(int b=0;b<cmView.mazeDimX;b++){
								if(cmView.panels[a][b]==parentPan){
									indexi=a;
									indexj=b;	
								}
							}
						}
						
						//Choosing if I should move i or j
						  int randomInt = new Random().nextInt(100);
						if(randomInt%2==0){
							
							if(indexi+1==cmView.mazeDimY)
								forward=false;
							if(indexi==0)
								forward=true;
							
							
							
							if(forward){
								indexi++;
							}
							else{
								indexi--;
							}
							//If it meets a wall
							if(maze.walls.contains(cmView.panels[indexi][indexj])){
								forward=!forward;
								
							}
							else if(cmView.panels[indexi][indexj].getComponentCount()>0){
								forward=!forward;
								
							}
							else{
								parentPan.remove(jlb);
								parentPan.repaint();
							cmView.panels[indexi][indexj].add(jlb);
							cmView.panels[indexi][indexj].repaint();
							}
							
							
							
						}
						
						else {
							if(indexj+1==cmView.mazeDimX)
								forward=false;
							if(indexj==0)
								forward=true;

							if(forward){
								indexj++;
							}
							else{
								indexj--;
							}
							//If it meets a wall
							if(maze.walls.contains(cmView.panels[indexi][indexj])){
								forward=!forward;
								
							}
							else{
								parentPan.remove(jlb);
								parentPan.repaint();
							cmView.panels[indexi][indexj].add(jlb);
							cmView.panels[indexi][indexj].repaint();
							}
						}
						
					
						}
					});
					moveChar.start();
					
				}
		
	}
	public int[] getIndex(JPanel pan){
		int i = 0,j=0;
		int[] index = null; 
		for(i=0;i<cmView.mazeDimY;i++){
			for(j=0;j<cmView.mazeDimX;j++){
				if(cmView.panels[i][j]==pan){
					index=new int[]{i, j};
				}
			}
		}
		return index;
	}
	
	public boolean isBlocked(int[] index){
		JPanel jp=cmView.panels[index[0]][index[1]];
                if(maze.walls.contains(jp)){
			System.out.println("yes..its  a wall");
			return true;
		}
		
		else
		return false;
		
	}
	
	public void moveRight(JLabel lab){
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0],index[1]+1};
		if(isBlocked(indexNext)==false){
			System.out.println("not blocked");
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]][index[1]+1].add(lab);
                cmView.panels[index[0]][index[1]+1].repaint();
		}
	}
	public void moveLeft(JLabel lab){
		
		int[] index=getIndex((JPanel) lab.getParent());
		//System.out.println("idex is"+index[0]+"and"+index[1]);
		int[] indexNext={index[0],index[1]-1};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		cmView.panels[index[0]][index[1]-1].add(lab);
                cmView.panels[index[0]][index[1]-1].repaint();
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
                cmView.panels[index[0]+1][index[1]].repaint();
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
                cmView.panels[index[0]-1][index[1]].repaint();
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
                
                
                mainPanel = new JPanel();
                header = new JPanel();
                cmView.scView.mainPanel.setLayout(new BoxLayout(cmView.scView.mainPanel, BoxLayout.Y_AXIS));
		JLabel heading=new JLabel("QUEST #1: ");
                heading.setFont(new Font("Arial", Font.PLAIN, 24));
                //cmView.scView.header.add(Box.createRigidArea(new Dimension(0, 30)));
		cmView.scView.header.add(heading);
		
		for(int i=0;i<cmView.mazeDimY;i++){
			for(int j=0;j<cmView.mazeDimX;j++){
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
			
                        
			
		
	}

}
