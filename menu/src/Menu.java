import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    public enum MenuItem {
        UP("1"),
        LEFT("2"),
        RIGHT("3"),
        DOWN("4");

        private final String id;

        MenuItem (String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    //    private Map<String, String> titles;
    private Map<String, Command> commands;
    private static Scanner input = new Scanner(System.in);

    public Menu() {
//        titles = new LinkedHashMap<>();
        commands = new LinkedHashMap<>();

//        titles.put("1", "1 - Up");
//        titles.put("2", "2 - Left");
//        titles.put("3", "3 - Right");
//        titles.put("4", "4 - Down");

        commands.put("1", this::up);
        commands.put("2", this::left);
        commands.put("3", this::right);
        commands.put("4", this::down);
    }


    private void up() {
        System.out.println("Up is chosen");
    }

    private void down() {
        System.out.println("Down is chosen");
    }

    private void left() {
        System.out.println("Left is chosen");
    }

    private void right() {
        System.out.println("Right is chosen");
    }

    private void showMenu() {
        System.out.println("\nMENU:");
        for (MenuItem item : MenuItem.values()) {
            System.out.println(String.format("%s - %s", item.getId(), item.name()));
        }
//        titles.values().forEach(System.out::println);
    }

    public void show() {
        String commandId;
        do {
            showMenu();
            System.out.println("Make your choice...");
            commandId = input.nextLine();
            try {
                if(commandId.equals("q"))
                    break;
                commands.get(commandId).execute();
            } catch (Exception e) {
                System.err.println("No such command");
            }
        } while (! commandId.equals("q"));
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.show();
    }
}