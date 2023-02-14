import java.util.HashMap;

public class program_5_2 {
    public static void main(String[] args) {
        HashMap<String, Integer> frequency = new HashMap<>();
        String[] employees = { "Светлана Петрова", "Кристина Белова", "Анна Мусина", "Анна Крутова", "Иван Юрин",
                "Петр Лыков", "Павел Чернов", "Петр Чернышов", "Мария Федорова", "Марина Светлова", "Иван Савин",
                "Мария Рыкова", "Марина Лугова", "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов" };
        for (String employee : employees) {
            String[] worker = employee.split(" ");
            if (frequency.containsKey(worker[0])) {
                frequency.put(worker[0], frequency.get(worker[0]) + 1);
            } else {
                frequency.put(worker[0], 1);
            }

        }
        System.out.println(frequency);
    }
}
