import java.util.*;

public class DupEmailRemover {

    public static void main(String[] args) {
        Set<String> emailSet = new HashSet<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter email address ('exit' to end):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            emailSet.add(input);
        }
        System.out.println("Unique email addresses:");
        for (String email : emailSet) {
            System.out.println(email);
        }
    }
}
