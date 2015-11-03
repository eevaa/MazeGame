package maze;

import java.awt.Image;

public class Element {
	String name;
	String symbol;
	Image elemImage;
	public Element(String name, String symbol, Image elemImage) {
		super();
		this.name = name;
		this.symbol = symbol;
		this.elemImage = elemImage;
	}
	public Element(String symbol) {
		// TODO Auto-generated constructor stub
		this.symbol=symbol;
	}

}
