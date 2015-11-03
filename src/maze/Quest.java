package maze;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Quest {
	String questName;
	String questDisplayText;
	ArrayList<Element> elementsInQuest;
	ArrayList<Element> enemies;
	Element mainElement;
	public Quest() {
		// TODO Auto-generated constructor stub
		//Empty quest to just access functions
	}
	
	public Quest(String name, String txt, ArrayList<Element> elems, ArrayList<Element> enems) {
		// TODO Auto-generated constructor stub
		questName=name;
		questDisplayText=txt;
		elementsInQuest=elems;
		enemies=enems;
		
		
	}

	public Quest getQuest(Element e){
		//Hard coding each quest!
		
		Quest q=null;
		Image oxygen = null;
		Image sodium=null;
		Image calcium=null;
		Image chlorine=null;
		Image hydrogen=null;
		Image nitrogen=null;
		Image carbon=null;
		try {
			sodium = ImageIO.read(this.getClass().getResource("/images/Na.png"));
			sodium=sodium.getScaledInstance(30,30,1);
			carbon = ImageIO.read(this.getClass().getResource("/images/C.png"));
			carbon=carbon.getScaledInstance(30,30,1);
			chlorine = ImageIO.read(this.getClass().getResource("/images/Cl.png"));
			chlorine=chlorine.getScaledInstance(30,30,1);
			hydrogen = ImageIO.read(this.getClass().getResource("/images/H.png"));
			hydrogen=hydrogen.getScaledInstance(30,30,1);
			calcium = ImageIO.read(this.getClass().getResource("/images/Ca.png"));
			calcium=calcium.getScaledInstance(30,30,1);
			nitrogen = ImageIO.read(this.getClass().getResource("/images/N.png"));
			nitrogen=nitrogen.getScaledInstance(30,30,1);
			oxygen = ImageIO.read(this.getClass().getResource("/images/O.png"));
			oxygen=oxygen.getScaledInstance(30,30,1);
			
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Element o= new Element("O","oxygen",oxygen);
		Element c= new Element("C","carbon",carbon);
		Element n= new Element("N","nitrogen",nitrogen);
		Element ca= new Element("Ca","calcium",calcium);
		Element cl= new Element("Cl","chlorine",chlorine);
		Element h= new Element("H","hydrogen",hydrogen);
		Element na= new Element("Na","sodium",sodium);
		ArrayList<Element> elems=new ArrayList<Element>();
		ArrayList<Element> enemyList=new ArrayList<Element>();
		
		
		//Water 
		if (e.symbol=="h"){
			e.name="hydrogen";
			e.elemImage=hydrogen;
			elems.add(h);
			elems.add(o);
			enemyList.add(n);
			enemyList.add(ca);
			q=new Quest("water","Oops I'm thirsty",elems,enemyList);
		}
		
		//Carbon Dioxide
		else if (e.symbol=="c"){
			e.name="carbon";
			e.elemImage=carbon;
			elems.add(o);
			elems.add(o);
			enemyList.add(cl);
			enemyList.add(h);
			q=new Quest("CarbonDioxide","you exhale me",elems,enemyList);
		}
		//HydroChloric Acid
		else if (e.symbol=="cl"){
			e.name="chlorine";
			e.elemImage=chlorine;
			elems.add(h);
			enemyList.add(cl);
			enemyList.add(na);
			q=new Quest("hydro chloric acid","The acid in your stomach",elems,enemyList);
		}
		
		//Sodium Chloride
		else if (e.symbol=="na"){
			e.name="sodium";
			e.elemImage=sodium;
			elems.add(cl);
			enemyList.add(ca);
			enemyList.add(o);
			q=new Quest("sodium chloride","I am always paired with pepper",elems,enemyList);
		}
		
		//Oxygen o2
		else if (e.symbol=="o"){
			e.name="oxygen";
			e.elemImage=oxygen;
			elems.add(o);
			enemyList.add(n);
			enemyList.add(c);
			q=new Quest("oxygen","You breathe me in",elems,enemyList);
		}
		
		//Ammonia
		else if (e.symbol=="n"){
			e.name="nitrogen";
			e.elemImage=nitrogen;
			elems.add(h);
			elems.add(h);
			elems.add(h);
			enemyList.add(o);
			q=new Quest("ammonia","I am famous for my fountain experiment",elems,enemyList);
		}	
		
		q.mainElement=e;
		return q;
		
	}

}
