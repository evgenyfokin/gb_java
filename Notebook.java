import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Notebook {
    String brand;
    String model;
    String os;
    String color;
    int RAM;
    int HD;
    int ID;
    int price;

    public Notebook(String brand, String model, String os, String color, int RAM, int HD, int ID, int price) {
        this.brand = brand;
        this.model = model;
        this.os = os;
        this.color = color;
        this.RAM = RAM;
        this.HD = HD;
        this.ID = ID;
        this.price = price;
    }

    Scanner iScanner = new Scanner(System.in, "cp866");

    /**
     * "menu1" был выделен в отдельный метод, чтобы иметь возможность вызывать его
     * посторно
     * 
     * @param notebooks - хеш сет для всех элементов
     */
    public void menu1(HashSet<Notebook> notebooks) {
        System.out.println("\nДобро пожаловать в каталог ноутбуков! ");
        System.out.println("Выберите действие: \n1 - Печать всех товаров \n2 - Поиск по каталогу \n0 - Выход");
        int userInput = iScanner.nextInt();

        /**
         * Основное меню входа
         * 
         */
        switch (userInput) {
            case 1:
                for (Notebook notebook : notebooks) {
                    System.out.println(notebook.printNotebook());
                }
                menu2(notebooks);
                break;
            case 2:
                menu2(notebooks);
                break;
            case 0:
                System.out.println("Покетик");
                break;
            default:
                System.out.println(
                        "\nТакой операции не существует, попробуйте снова.\n");
                menu1(notebooks);
                return;

        }
    }

    /**
     * Аналогочно первому меню преобразован в метод, чтобы иметь возможность
     * возврщаться в предыдущее меню из консоли
     */
    public void menu2(HashSet<Notebook> notebooks) {
        System.out.println(
                "\nВведите цифру, соответствующую критерию поиска: \n1 - RAM \n2 - Объем HD \n3 - Операционная система  \n4 - Цена \n0 - Выход в предыдущее меню");
        int innerUserInput = iScanner.nextInt();
        switch (innerUserInput) {
            case 1:
                printFiltered(notebooks, "RAM", 4, 64, "Ноутбуки с объемом RAM от");
                menu2(notebooks);
                break;
            case 2:
                printFiltered(notebooks, "HD", 128, 1024, "Ноутбуки с объемом HD от");
                menu2(notebooks);
                break;
            case 3:
                System.out.println(
                        "\nВведите цифру, соответствующую критерию поиска: \n1 - Macintosh \n2 - Windows \n3 - Linux \n4 - Chrome Os \n0 - Выход в предыдущее меню");
                int osUserInput = iScanner.nextInt();
                switch (osUserInput) {
                    case 1:
                        filterNotebookStr(notebooks, "macintosh");
                        menu2(notebooks);

                        break;
                    case 2:
                        filterNotebookStr(notebooks, "windows");
                        menu2(notebooks);

                        break;
                    case 3:
                        filterNotebookStr(notebooks, "linux");
                        menu2(notebooks);
                        break;
                    case 4:
                        System.out.println("\nХахаха, хром ос самая жалкая os в мире, поэтому мы ее не продаем!");
                        menu2(notebooks);
                        break;
                    case 0:
                        menu2(notebooks);
                        break;
                    default:
                        System.out.println(
                                "\nТакой операции не существует, попробуйте снова.\n");
                        menu2(notebooks);
                        return;

                }
                break;
            case 4:
                printFiltered(notebooks, "HD", 600, 3100, "Ноутбуки в ценовой категории от ");
                menu2(notebooks);
                break;
            case 0:
                menu1(notebooks);
                break;
            default:
                System.out.println(
                        "\nТакой операции не существует, попробуйте снова.\n");
                menu2(notebooks);
                return;
        }
    }

    /**
     * Метод печати элементов
     * 
     */
    public String printNotebook() {
        return "brand: " + brand + "; model: " + model + "; OS: " + os + "; color: " + color + "; RAM: " + RAM
                + "; HD: " + HD + "; price: " + price;
    }

    /**
     * Метод фильтрует элементы по заданным параметрам типа int
     * 
     * @param field - поле класса
     * @param min   - минимальное значение поиска задаваемое из клиентского кода.
     * @param max   - максимальное значение поиска задаваемое из клиентского кода.
     */
    public List<Notebook> filterNotebook(HashSet<Notebook> hashNotebook, String field, int min, int max) {
        List<Notebook> notebookList = new ArrayList<Notebook>();
        for (Notebook notebook : hashNotebook) {
            try {
                Field f = Notebook.class.getDeclaredField(field);
                f.setAccessible(true);
                int value = (int) f.get(notebook);
                if (value >= min && value <= max) {
                    notebookList.add(notebook);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return notebookList;
    }

    /**
     * Метод фильтрует элементы по заданным параметрам типа String
     * 
     * @param field - поле класса типа String
     */
    public List<Notebook> filterNotebookStr(HashSet<Notebook> hashNotebook, String field) {
        List<Notebook> notebookList = new ArrayList<Notebook>();
        for (Notebook notebook : hashNotebook) {
            if (notebook.os.equalsIgnoreCase(field)) {
                System.out.println(notebook.printNotebook());
            }
        }

        return notebookList;

    }

    /**
     * Метод вывода массива с заданными из КК значениями.
     * 
     * @param min  - MIN значение, задаваемое из КК.
     * @param max  - MAX значение, задаваемое из КК.
     * @param text - Описание, задавемое из КК.
     */
    public void printFiltered(HashSet<Notebook> notebooks, String field, int min, int max, String text) {
        System.out.println(
                "\nВведите минимальное значение (от " + min + "):");
        int minInput = iScanner.nextInt();
        System.out.println(
                "\nВведите минимальное значение (до " + max + "):");
        int maxInput = iScanner.nextInt();
        List<Notebook> filteredList = filterNotebook(notebooks, field, minInput, maxInput);
        System.out
                .println("\n" + text + minInput + " до " + maxInput + ":");
        for (Notebook notebook : filteredList) {
            System.out.println(notebook.printNotebook());
            ;
        }
    }
}