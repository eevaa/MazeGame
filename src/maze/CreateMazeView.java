package maze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CreateMazeView {
	
	
	SelectCharView scView=null;
	JPanel horPanel=null;
	int mazeDimY=12;
	int mazeDimX=22;
	JButton next=null;
	JPanel panels[][]=new JPanel[mazeDimY][mazeDimX];
	JLabel heading2nd=null;
        JPanel infoPane=null;
	
	public CreateMazeView(SelectCharView scView){
		this.scView=scView;
		init();
	}

	
	
	
	public void init()
	{	
		scView.header.removeAll();
		scView.grid.removeAll();
                scView.pickPane.removeAll();
		scView.footer.removeAll();
		scView.mainPanel.repaint();
		scView.mainPanel.revalidate();
		
                scView.mainPanel.setLayout(new BoxLayout(scView.mainPanel, BoxLayout.Y_AXIS));
                
                scView.header.setLayout(new BorderLayout());
                scView.header.setMinimumSize(new Dimension(1066,90));
                scView.header.setMaximumSize(new Dimension(1066,90));
                scView.header.revalidate();
                scView.pickPane.setMaximumSize(new Dimension(1078,1));
                scView.pick.revalidate();
                scView.grid.setPreferredSize(new Dimension(1078,588));
                scView.grid.setMaximumSize(new Dimension(1078,588));
                scView.grid.setMinimumSize(new Dimension(1078,588));
                
		scView.grid.setLayout(new BoxLayout(scView.grid, BoxLayout.Y_AXIS));
                
                
		for(int i=0;i<mazeDimY;i++){
			//String horPanName="horpan"+i;
		 horPanel=new JPanel();
                 
                 horPanel.setOpaque(false);
			for(int j=0;j<mazeDimX;j++){
				
				JPanel innerPanel=new JPanel();
				innerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				horPanel.add(innerPanel);
				panels[i][j]=innerPanel;
                                
				
			}
			scView.grid.add(horPanel);
			horPanel.setBackground(Color.GRAY);
			horPanel.setLayout(new BoxLayout(horPanel,BoxLayout.X_AXIS));
			
			
		}
                JLabel heading=new JLabel("CLICK ON GRID TO CREATE WALLS");
                heading.setFont(new Font("gretoon", Font.PLAIN, 26));
                heading.setHorizontalAlignment(heading.CENTER);
                scView.header.add(heading);
                heading2nd=new JLabel("Hold shift and mouse over to create a continuous line");
                heading2nd.setFont(new Font("gretoon", Font.PLAIN, 18));
                infoPane = new JPanel();
                infoPane.setLayout(new FlowLayout());
                infoPane.add(heading2nd);
                infoPane.setOpaque(false);
                scView.grid.add(infoPane);
                
                
                next=new JButton("Game On");
                next.setPreferredSize(new Dimension(170, 60));
                next.setBackground(new Color(75,202,210));
              
                next.setFont(new Font("gretoon", Font.PLAIN, 22));
                scView.footer.add(Box.createRigidArea(new Dimension(0, 100)));
                scView.footer.add(next, BorderLayout.NORTH);
                scView.frame.getRootPane().setDefaultButton(next);
		
		
	}
}