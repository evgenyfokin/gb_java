import java.util.ArrayList;
import java.util.HashMap;

public class programm_5_1 {
    public static void main(String[] args) {
        HashMap<ArrayList<Integer>, String> userData = new HashMap<>();

        ArrayList<Integer> ivanovNums = new ArrayList<>();
        ivanovNums.add(123456);
        ivanovNums.add(234561);
        userData.put(ivanovNums, "Иванов");

        ArrayList<Integer> vasilievNums = new ArrayList<>();
        vasilievNums.add(321456);
        vasilievNums.add(214561);
        userData.put(vasilievNums, "Васильев");

        ArrayList<Integer> petrovaNums = new ArrayList<>();
        petrovaNums.add(234432);
        petrovaNums.add(344321);
        petrovaNums.add(34432100);
        petrovaNums.add(34432144);
        userData.put(petrovaNums, "Петрова");

        ArrayList<Integer> ivanovNums_1 = new ArrayList<>();
        ivanovNums_1.add(004432);
        ivanovNums_1.add(044342);
        userData.put(ivanovNums_1, "Иванов");

        for (ArrayList<Integer> user : userData.keySet()) {
            System.out.println(userData.get(user) + ":" + user);

        }
    }
}
