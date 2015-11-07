import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MazeTrial {
	
	 static ArrayList<JPanel> mazeChoice= new ArrayList<JPanel>();
	 static JButton done=new JButton("Done");
	 
	 static ActionListener showMaze =new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			if (done.getText()=="show maze"){
				done.setText("done");
				for(JPanel j:mazeChoice){
					j.setBackground(Color.BLACK);
					j.setBorder(null);
					
					
				}
			}
			else{
			for(JPanel j:mazeChoice){
				j.setBackground(null);
				
				j.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.GRAY));
			}
			done.setText("show maze");
			}
			
			
		}
	};
	
	private static MouseListener panelClicked=new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent mc) {
			// TODO Auto-generated method stub
			JPanel j=(JPanel) mc.getSource();
			System.out.println(mc.getSource());
			j.setBackground(Color.BLACK);
			j.setBorder(null);
			mazeChoice.add((JPanel) mc.getSource());
		
		}
	}; 
	
	public static void main(String[] args) {

		JFrame frame=new JFrame();
		frame.setTitle("Maze");
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
		GridLayout gridLayout = new GridLayout(15, 15);
		JPanel parentPanel = new JPanel(gridLayout);
		frame.setVisible(true);
		for(int i=0;i<(15*15);i++)
		{
			JPanel pan=new JPanel();
			pan.setBorder(BorderFactory.createBevelBorder(0, Color.BLACK, Color.GRAY));
			JLabel label =new JLabel(""+i);
			pan.add(label);
			pan.addMouseListener(panelClicked);
			parentPanel.add(pan);
		}
		
		done.addActionListener(showMaze);
		frame.getContentPane().add(parentPanel);
		frame.getContentPane().add(done);
		
	}
}
