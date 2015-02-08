public class PhoneNumber {
	String home;
	String cell;
	String work;

	public PhoneNumber(String a, String b, String c) {
		home = a;
		cell = b;
		work = c;
	}

	// Getter Methods
	public String getHome() {
		return home;
	}

	public String getCell() {
		return cell;
	}
 
	public String getWork() {
		return work;
	}

	public String toString() {
		return getHome() + "    " + getCell() + "    " + getWork()+"\r\n";
	}

}
