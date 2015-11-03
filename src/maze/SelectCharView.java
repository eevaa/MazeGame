package maze;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class SelectCharView {
	
	JButton startGame=null;
	Image sodium=null;
	Image carbon=null;
	Image hydrogen=null;
	Image oxygen=null;
	Image chlorine=null;
	Image calcium=null;
	Image nitrogen=null;
        Image background = null;
        Image headingImg = null;
        Image pickImg = null;
        Image start;
        JLabel heading;
        JLabel pick;
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
	BackgroundPanel mainPanel;
	JPanel header=null;
	JPanel footer=null;
	JPanel grid=null;
        JPanel pickPane=null;
        //Font gretoon;

	public SelectCharView() {
		// TODO Auto-generated constructor stub
		
		init2();
	}
	
	public void init2(){
                frame.setSize(new Dimension(1300,800));
                frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setTitle("ChemGame");
		
		header=new JPanel();
		
		//JLabel heading=new JLabel("Select 3 elements");
                
		
		grid=new JPanel();
		grid.setLayout(new BoxLayout(grid, BoxLayout.Y_AXIS));
                
                pickPane=new JPanel();
		pickPane.setLayout(new BoxLayout(pickPane, BoxLayout.Y_AXIS));
		
                      
		
		try {
			sodium = ImageIO.read(this.getClass().getResource("/images/Na.png"));
			//sodium=sodium.getScaledInstance(100,100,1);
			carbon = ImageIO.read(this.getClass().getResource("/images/C.png"));
			//carbon=carbon.getScaledInstance(100,100,1);
			chlorine = ImageIO.read(this.getClass().getResource("/images/Cl.png"));
			//chlorine=chlorine.getScaledInstance(100,100,1);
			hydrogen = ImageIO.read(this.getClass().getResource("/images/H.png"));
			//hydrogen=hydrogen.getScaledInstance(100,100,1);
			calcium = ImageIO.read(this.getClass().getResource("/images/Ca.png"));
			//calcium=calcium.getScaledInstance(100,100,1);
			nitrogen = ImageIO.read(this.getClass().getResource("/images/N.png"));
			//nitrogen=nitrogen.getScaledInstance(100,100,1);
			oxygen = ImageIO.read(this.getClass().getResource("/images/O.png"));
			//oxygen=oxygen.getScaledInstance(100,100,1);
                        background = ImageIO.read(this.getClass().getResource("/images/bg.png"));
			headingImg = ImageIO.read(this.getClass().getResource("/images/heading.png"));
                        pickImg = ImageIO.read(this.getClass().getResource("/images/pick.png"));
                        start = ImageIO.read(this.getClass().getResource("/images/start.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
    
                startGame = new JButton(new ImageIcon(start));
                startGame.setPreferredSize(new Dimension(200, 80));
                startGame.setBackground(new Color(75,202,210));
                Border emptyBorder = BorderFactory.createEmptyBorder();
                startGame.setBorder(emptyBorder);
		footer=new JPanel();
		footer.add(startGame);
                
                Font gretoon=null;
                
                    try {
                        URL fontUrl = new URL("file://localhost//D://FAKS//ProgrammingProject//MazeGame//src//font//Gretoon.ttf");
                        //create the font to use. Specify the size!
                        gretoon = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
                        gretoon = gretoon.deriveFont(12f);
                        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                        ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream()));
                        frame.setFont(gretoon);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    catch(FontFormatException e)
                    {
                        e.printStackTrace();
                    }

                    
                
                
                mainPanel=new BackgroundPanel(background);
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
                
                heading=new JLabel(new ImageIcon(headingImg));
		heading.setName("heading");
                heading.setText("heading");
                heading.setFont(gretoon);
		header.add(heading);
                header.add(Box.createRigidArea(new Dimension(0, 150)));
                
                pick=new JLabel(new ImageIcon(pickImg));
		pick.setName("heading");
		pickPane.add(pick);
              
                
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
                        grid.add(Box.createRigidArea(new Dimension(40, 0)));
		}
		
                header.add(heading);
		grid.setLayout(new FlowLayout());
                pickPane.setLayout(new BoxLayout(pickPane, BoxLayout.Y_AXIS));
                pick.setAlignmentX(pick.CENTER_ALIGNMENT);
                pickPane.add(Box.createRigidArea(new Dimension(0, 30)));
		mainPanel.add(header);
                mainPanel.add(pickPane);
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
			//temp=temp.getScaledInstance(100,100,1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		but.setIcon(new ImageIcon(temp));
		
	}
        
        
}
