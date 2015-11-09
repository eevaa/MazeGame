package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameView{

	CreateMazeView cmView=null;
	JPanel startPanel=null;
	ArrayList<String> mainChars=new ArrayList<String>();
	//Image mainChar=null;
	JLabel mainElem=null;
	MazeConfig maze=null;
        ArrayList<Quest> quests=new ArrayList<Quest>();
	ArrayList<JLabel> answers=new ArrayList<JLabel>();
	ArrayList<JLabel> enemies=new ArrayList<JLabel>();
	int answersFound=0;
	int currQuestCount=0;
	int answerCount=0;
	int enemyCount=0;
        int life = 3;
	Quest currQuest=null;
	Boolean forward=true;
        JPanel mainPanel=null;
        JPanel header=null;
        JPanel footer=null;
        JLabel heading=null;
        JLabel heading2=null;
        static JPanel collected;
        static ArrayList<JLabel> coll=new ArrayList<JLabel>();
        Timer moveChar=null;
        
	public GameView(CreateMazeView cmView) {
		// TODO Auto-generated constructor stub
		this.cmView=cmView;
		mainChars=cmView.scView.players;
		initGame();
		
	}
        
        	public void addQuestElements() {
		// TODO Auto-generated method stub
        		
        		
        //Are all quests over?
        		
        		if(currQuestCount==quests.size()){
        			JOptionPane.showMessageDialog(cmView.scView.frame, "Congratulations! You completed the Game :)");
        			 moveChar.stop();
                     
                     cmView.scView.header.removeAll();
                     cmView.scView.header.repaint();
                     cmView.scView.header.revalidate();
                     cmView.scView.mainPanel.removeAll();
                     cmView.scView.mainPanel.repaint();
                     cmView.scView.mainPanel.revalidate();
                     cmView.scView.footer.removeAll();
                     cmView.scView.footer.repaint();
                     cmView.scView.mainPanel.revalidate();
                         
                       
                     //create new game - selectcharview
                 	SelectCharView scView2=new SelectCharView();
                 	SelectCharController scController = new SelectCharController(scView2);
                         scView2.frame.setVisible(true);
                         cmView.scView.frame.dispose();
        		}
		
		//Positioning Main Element 
		startPanel=cmView.panels[0][0];
                
		currQuest=quests.get(currQuestCount);
		mainElem=new JLabel(new ImageIcon(currQuest.mainElement.elemImage));
		startPanel.add(mainElem);
		startPanel.repaint();
		//adding quest name to heading
                heading.setText("QUEST: "+currQuest.questDisplayText);
                heading2.setText("LIFE: "+life);
		//Positioning Answer Elements
		answersFound=0;
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
			autoMover(jlb);		
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
					autoMover(jlb);
				}
		
	}
        	
    //This function automatically moves enemies/answers around the maze    	
   public void autoMover(JLabel jlb){
	    moveChar=new Timer(900, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			JPanel parentPan=(JPanel) jlb.getParent();
			if(parentPan!=null){
			 
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
			}
		});
		moveChar.start();
		
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
			return true;
		}
		
		else
		return false;
		
	}
	
	public void moveRight(JLabel lab){
		int[] index=getIndex((JPanel) lab.getParent());
		int[] indexNext={index[0],index[1]+1};
		if(isBlocked(indexNext)==false){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		
		JPanel targetPanel=cmView.panels[index[0]][index[1]+1];
		//Detecting collision
		detectCollision(targetPanel, lab);
		
		}
	}
	
	
	public void moveLeft(JLabel lab){
		
		int[] index=getIndex((JPanel) lab.getParent());
		int[] indexNext={index[0],index[1]-1};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		
		JPanel targetPanel=cmView.panels[index[0]][index[1]-1];
		//Detecting collision
		detectCollision(targetPanel, lab);
		}
	}
	public void moveDown(JLabel lab){
		int[] index=getIndex((JPanel) lab.getParent());
		int[] indexNext={index[0]+1,index[1]};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		JPanel targetPanel=cmView.panels[index[0]+1][index[1]];
		//Detecting collision
		detectCollision(targetPanel, lab);
		}
	}
	public void moveUp(JLabel lab){
		int[] index=getIndex((JPanel) lab.getParent());
		int[] indexNext={index[0]-1,index[1]};
		if(!isBlocked(indexNext)){
		cmView.panels[index[0]][index[1]].removeAll();
		cmView.panels[index[0]][index[1]].repaint();
		cmView.panels[index[0]][index[1]].revalidate();
		JPanel targetPanel=cmView.panels[index[0]-1][index[1]];
		//Detecting collision
		detectCollision(targetPanel, lab);
		}
	}
	
	public void detectCollision(JPanel targetPanel, JLabel lab)
	{
		if(targetPanel.getComponentCount()==0){
			targetPanel.add(lab);
			targetPanel.repaint();
		}
		//if there is something in the target panel
		else{
			JLabel jlab=(JLabel) targetPanel.getComponent(0);
			if(enemies.contains(jlab))
			{
				die();
			}
			else if(answers.contains(jlab)){
				answerFound(targetPanel,lab,jlab);
			
			}
		}
	}
	public void answerFound(JPanel targetPanel, JLabel playerLabel,JLabel answer) {
		// TODO Auto-generated method stub
	
		
		answersFound++;
		moveChar.stop();
		if(answersFound<answerCount){
                
		answers.remove(answer);
                
                answer.getParent().removeAll();
		JOptionPane.showMessageDialog(cmView.scView.frame, "Good! "+(answerCount-answersFound)+" more to go...");
                
		targetPanel.add(playerLabel);
		targetPanel.repaint();
                setCollected(answer, answersFound);
		moveChar.start();
		}
		else{
                        collected.removeAll();
                        collected.repaint();
                        collected.revalidate();
                        coll.clear();	
                        moveChar.stop();
                        JOptionPane.showMessageDialog(cmView.scView.frame, "Thats perfect!");
			currQuestCount++;
			
			//Remove all elements from this quest
			for(int q=0;q<cmView.mazeDimY;q++){
				for(int r=0;r<cmView.mazeDimX;r++){
					JPanel jpnl=cmView.panels[q][r];
					if(jpnl.getComponentCount()>0){
						jpnl.removeAll();	
					}
					jpnl.repaint();
				}
			}
			answers.clear();
			addQuestElements();
		}
		
		
	}

	private void die() {
		// TODO Auto-generated method stub
            life--; 
            collected.removeAll();
            collected.repaint();
            collected.revalidate();
            coll.clear();
            if (life<=0){
                
                JOptionPane.showMessageDialog(cmView.scView.frame, "Game Over!");
                
                moveChar.stop();
                cmView.scView.header.removeAll();
                cmView.scView.header.repaint();
                cmView.scView.header.revalidate();
                cmView.scView.mainPanel.removeAll();
                cmView.scView.mainPanel.repaint();
                cmView.scView.mainPanel.revalidate();
                cmView.scView.footer.removeAll();
                cmView.scView.footer.repaint();
                cmView.scView.mainPanel.revalidate();
                    
                  
                //create new game - selectcharview
            	SelectCharView scView2=new SelectCharView();
            	SelectCharController scController = new SelectCharController(scView2);
                scView2.frame.setVisible(true);
                cmView.scView.frame.dispose();
                
                }
            else{
		JOptionPane.showMessageDialog(cmView.scView.frame, "Oops! That was a disaster! Lets try again..");
                    
                    for(int q=0;q<cmView.mazeDimY;q++){
			for(int r=0;r<cmView.mazeDimX;r++){
				JPanel jpnl=cmView.panels[q][r];
				if(jpnl.getComponentCount()>0){
					jpnl.removeAll();	
				}
				jpnl.repaint();
			}
                    }
		answers.clear();
		addQuestElements();
                
            }	
	}
        
        public void setCollected(JLabel element, int answerFound){
            
                Icon elementCopy = element.getIcon();
                JLabel elementCopyLabel = new JLabel();
                System.out.println(answerCount);
                if(answerFound==1){
                    JLabel collectedText = new JLabel("COLLECTED:  ");
                    collectedText.setFont(new Font("arial", Font.BOLD, 24));
                    collected.add(Box.createRigidArea(new Dimension(117, 0)));
                    collected.add(collectedText, BorderLayout.CENTER);
                }
                elementCopyLabel.setIcon(elementCopy);
                coll.add(elementCopyLabel);
                
                
                for (int i=0; i<coll.size(); i++){
                    collected.add(coll.get(i));
                    collected.add(Box.createRigidArea(new Dimension(10, 0)));
                    cmView.scView.header.repaint();
                    cmView.scView.header.revalidate();
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
		cmView.heading2nd.setText("");
                
                cmView.scView.frame.setLayout(new BorderLayout());
                
                mainPanel = new JPanel();
                header = new JPanel();
                footer = new JPanel();
                
		heading=new JLabel();
                heading.setFont(new Font("gretoon", Font.BOLD, 24));
                heading.setVerticalAlignment(heading.CENTER);
                heading2=new JLabel();
                heading2.setFont(new Font("gretoon", Font.BOLD, 32));
                heading2.setForeground(new Color(75,202,210));
                collected = new JPanel();
                collected.setOpaque(false);
                collected.setLayout(new BoxLayout(collected, BoxLayout.X_AXIS));
                collected.setPreferredSize(new Dimension(1066,80));
                collected.setMaximumSize(new Dimension(1066,80));
                cmView.scView.mainPanel.setLayout(new BorderLayout());
                cmView.scView.footer.setLayout(new BorderLayout());
                cmView.scView.footer.revalidate();
                cmView.scView.footer.repaint();
                cmView.scView.footer.setPreferredSize(new Dimension(1066,50));
                cmView.scView.footer.setMaximumSize(new Dimension(1066,50));
                cmView.scView.footer.add(Box.createRigidArea(new Dimension(0, 10)));
                
		cmView.scView.header.add(heading, BorderLayout.WEST);
                cmView.scView.header.add(heading2, BorderLayout.EAST);
                cmView.scView.footer.add(collected, BorderLayout.CENTER);
               
                
		
		for(int i=0;i<cmView.mazeDimY;i++){
			for(int j=0;j<cmView.mazeDimX;j++){
				JPanel temp=cmView.panels[i][j];
				temp.setBorder(BorderFactory.createDashedBorder(null));
				temp.setLayout(new BorderLayout());
                                temp.setPreferredSize(new Dimension(48,48));
                                temp.setMinimumSize(new Dimension(48,48));
                                temp.setMaximumSize(new Dimension(48,48));
				temp.removeMouseListener(temp.getMouseListeners()[0]);
				temp.repaint();
				temp.revalidate();
			}
		}
			
                        
			
		
	}

}