package maze;

public class Main {
	public static void main(String[] args) {
	SelectCharView scView=new SelectCharView();
	SelectCharController scController = new SelectCharController(scView);
        scView.frame.setVisible(true);
	}
}
