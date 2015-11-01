package maze;

import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectCharView {
	
	JButton startGame=null;
	Image sodium=null;
	Image carbon=null;
	Image hydrogen=null;
	Image oxygen=null;
	Image chlorine=null;
	Image calcium=null;
	Image nitrogen=null;
	JButton na=null;
	JButton ca=null;
	JButton cl=null;
	JButton c=null;
	JButton n=null;
	JButton o=null;
	JButton h=null;
	ArrayList<JButton> elements=new ArrayList<JButton>();
	ArrayList<String> players=new ArrayList<String>();
	JFrame frame=new JFrame();
	JPanel mainPanel=null;
	JPanel header=null;
	JPanel footer=null;
	JPanel grid=null;

	public SelectCharView() {
		// TODO Auto-generated constructor stub
		
		init2();
	}
	
	public void init2(){
frame.setSize(1000,1000);
		
		
		mainPanel=new JPanel();
		header=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		JLabel heading=new JLabel("Select 3 elements");
		header.add(heading);
		grid=new JPanel();
		grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
		
		startGame=new JButton("Next");
		footer=new JPanel();
		footer.add(startGame);
		
	
		
		try {
			sodium = ImageIO.read(this.getClass().getResource("/images/Na.png"));
			sodium=sodium.getScaledInstance(100,100,1);
			carbon = ImageIO.read(this.getClass().getResource("/images/C.png"));
			carbon=carbon.getScaledInstance(100,100,1);
			chlorine = ImageIO.read(this.getClass().getResource("/images/Cl.png"));
			chlorine=chlorine.getScaledInstance(100,100,1);
			hydrogen = ImageIO.read(this.getClass().getResource("/images/H.png"));
			hydrogen=hydrogen.getScaledInstance(100,100,1);
			calcium = ImageIO.read(this.getClass().getResource("/images/Ca.png"));
			calcium=calcium.getScaledInstance(100,100,1);
			nitrogen = ImageIO.read(this.getClass().getResource("/images/N.png"));
			nitrogen=nitrogen.getScaledInstance(100,100,1);
			oxygen = ImageIO.read(this.getClass().getResource("/images/O.png"));
			oxygen=oxygen.getScaledInstance(100,100,1);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		na=new JButton(new ImageIcon(sodium));
		na.setName("na");
		elements.add(na);
	
		
		n=new JButton(new ImageIcon(nitrogen));
		n.setName("n");
		elements.add(n);
		
		c=new JButton(new ImageIcon(carbon));
		c.setName("c");
		elements.add(c);
		
		cl=new JButton(new ImageIcon(chlorine));
		cl.setName("cl");
		elements.add(cl);
		
		ca=new JButton(new ImageIcon(calcium));
		ca.setName("ca");
		elements.add(ca);
		
		o=new JButton(new ImageIcon(oxygen));
		o.setName("o");
		elements.add(o);
		
		h=new JButton(new ImageIcon(hydrogen));
		h.setName("h");
		elements.add(h);
	
		for(JButton jb:elements){
			jb.setBorder(BorderFactory.createEmptyBorder());
			jb.setContentAreaFilled(false);
			grid.add(jb);
		}
		
	
		grid.setLayout(new FlowLayout());
		mainPanel.add(header);
		mainPanel.add(grid);
		mainPanel.add(footer);
		
		frame.getContentPane().add(mainPanel);
		frame.setVisible(true);
		
		
	}

	public void changeImage(JButton but) {
		// TODO Auto-generated method stub
		String name=but.getName()+"Clicked";
		Image temp=null;
		try {
			temp = ImageIO.read(this.getClass().getResource("/images/"+name+".png"));
			temp=temp.getScaledInstance(100,100,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		but.setIcon(new ImageIcon(temp));
		
	}
}
