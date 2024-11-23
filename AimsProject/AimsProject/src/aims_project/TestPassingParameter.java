package aims_project;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		
		System.out.println("jungle dvd title: " + jungleDVD.getTitile());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitile());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitile());
		System.out.println("jungle dvd title: " + jungleDVD.getTitile());
	}

	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitile();
		dvd.setTitile(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}
