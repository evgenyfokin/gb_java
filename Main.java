import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        HashSet<Notebook> notebooks = new HashSet<>();

        Notebook notebook1 = new Notebook("apple", "air", "macintosh", "grey", 32,
                1024, 01, 1500);
        Notebook notebook2 = new Notebook("asus", "zenbook", "windows", "black", 8,
                512, 02, 600);
        Notebook notebook3 = new Notebook("apple", "pro", "macintosh", "grey", 64,
                1024, 03, 3100);
        Notebook notebook4 = new Notebook("hp", "omen", "linux", "black", 16,
                512, 04, 999);
        Notebook notebook5 = new Notebook("hp", "inspire", "windows", "white", 4,
                128, 05, 900);

        notebooks.add(notebook1);
        notebooks.add(notebook2);
        notebooks.add(notebook3);
        notebooks.add(notebook4);
        notebooks.add(notebook5);

        notebook1.menu1(notebooks);

    }
}
