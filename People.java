import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class People implements Serializable {
	private static final long serialVersionUID = -4191607695428387493L;
	static LinkedList<Person> sortedList = new LinkedList<Person>();
	static Scanner read;
	public static PrintWriter write;

	public static void addPerson(String nameGetter, String surnameGetter,
			String addressGetter, String home, String cell, String work) {

		Person a = new Person(nameGetter, surnameGetter, addressGetter, home,
				cell, work);

		// Control duplicates
		if (hasDuplicateName(a)) {
			PAddContact.errorDialog(searchByPerson(a.getName(), a.getSurname())
					+ " named contact has been already in the list!");
		} else {
			sortedList.addLast(a);
			Collections.sort(sortedList);
		}

	}

	public static LinkedList<Person> searchByName(String sNameEntry) {

		LinkedList<Person> searchResult = new LinkedList<Person>();
		Iterator<Person> it = sortedList.iterator();
		Person temp;

		while (it.hasNext()) {
			temp = it.next();

			if (temp.getName().contains(sNameEntry)) {
				searchResult.addLast(temp);
			}
		}

		return searchResult;
	}

	public static LinkedList<Person> searchByNumber(String sNumEntry) {

		LinkedList<Person> searchResult = new LinkedList<Person>();
		Person result = new Person();
		Iterator<Person> it = sortedList.iterator();

		while (it.hasNext()) {

			if (it.next().number.home.contains(sNumEntry)) {
				if (searchResult.contains(result)) {
					System.out.println();
				} else {
					searchResult.addLast(result);
				}

			}
			if (it.next().number.cell.contains(sNumEntry)) {
				if (searchResult.contains(result)) {

				} else {
					searchResult.addLast(result);
				}
			}
			if (it.next().number.work.contains(sNumEntry)) {
				if (searchResult.contains(result)) {

				} else {
					searchResult.addLast(result);
				}
			}
		}

		return searchResult;
	}

	public static void changeHome(String sName, String sSurname, String sNum) {

		Iterator<Person> it = sortedList.iterator();
		while (it.hasNext()) {

			if (sName.equals(it.next().getName())
					&& sSurname.equals(it.next().getSurname())) {
				it.next().number.home = sNum;
				break;
			}
		}

	}

	public static void changeCell(String sName, String sSurname, String sNum) {

		Iterator<Person> it = sortedList.iterator();
		while (it.hasNext()) {

			if (sName.equals(it.next().getName())
					&& sSurname.equals(it.next().getSurname())) {
				it.next().number.cell = sNum;
				break;
			}
		}

	}

	public static void changeWork(String sName, String sSurname, String sNum) {

		Iterator<Person> it = sortedList.iterator();
		while (it.hasNext()) {

			if (sName.equals(it.next().getName())
					&& sSurname.equals(it.next().getSurname())) {
				it.next().number.work = sNum;
				break;
			}
		}

	}

	public static Person searchByPerson(String sName, String sSurname) {

		Person temp = new Person();
		Iterator<Person> it = sortedList.iterator();

		while (it.hasNext()) {
			temp = it.next();

			if (sName.equals(temp.getName())
					&& sSurname.equals(temp.getSurname())) {
				break;
			}
		}

		return temp;
	}

	public static Person searchByPerson(String sNumber) {

		Person temp = new Person();
		Iterator<Person> it = sortedList.iterator();

		while (it.hasNext()) {
			temp = it.next();

			if (sNumber.equals(temp.number.getHome())) {
				break;
			}

			else if (sNumber.equals(temp.number.getCell())) {
				break;
			}

			else if (sNumber.equals(temp.number.getWork())) {
				break;
			}
		}

		return temp;
	}

	public static Boolean hasDuplicateName(Person sPersonEntry) {

		Iterator<Person> it = sortedList.iterator();
		Boolean state = false;

		while (it.hasNext()) {
			Person temp = it.next();

			if (sPersonEntry.getName().equals(temp.getName())
					&& sPersonEntry.getSurname().equals(temp.getSurname())) {
				state = true;
				break;
			} else {
				state = false;
			}
		}
		return state;
	}

	public static Boolean hasDuplicateNum(String sNumEntry) {

		Iterator<Person> it = sortedList.iterator();
		Boolean state = false;
		while (it.hasNext()) {
			Person temp = it.next();

			if (sNumEntry.equals(temp.number.getHome())) {
				state = true;
				break;
			}

			if (sNumEntry.equals(temp.number.getCell())) {
				state = true;
				break;
			}

			if (sNumEntry.equals(temp.number.getWork())) {
				state = true;
				break;
			}

			else {
				state = false;
			}
		}
		return state;
	}

	public static void loadData() throws IOException {
		read = new Scanner(new File("db.txt"));
		String readName;
		String readSurname;
		String readAddress;
		String readHomePhone;
		String readCellPhone;
		String readWorkPhone;

		while (read.hasNext()) {

			readName = read.nextLine();
			readSurname = read.nextLine();
			readAddress = read.nextLine();
			readHomePhone = read.nextLine();
			readCellPhone = read.nextLine();
			readWorkPhone = read.nextLine();

			addPerson(readName, readSurname, readAddress, readHomePhone,
					readCellPhone, readWorkPhone);
		}
	}

	public static void saveData() throws IOException {
		write = new PrintWriter("db.txt");
		Person[] array = new Person[sortedList.size()];
		Iterator<Person> it1 = sortedList.iterator();
		while (it1.hasNext()) {
			Person temp = it1.next();
			int i = 0;
			array[i] = temp;
			i++;
		}
		for (Person person : sortedList) {
			write.println(person.write());
		}
		write.close();
	}

	public static void printList() {
		for (Person person : sortedList) {
			System.out.println(person);
		}
		System.out.println();
	}

	public static String makeString(LinkedList<Person> haha) {
		String isimkalmadý = "";
		Iterator<Person> it = haha.iterator();

		while (it.hasNext()) {
			isimkalmadý += it.next();
		}
		return isimkalmadý;
	}
}
