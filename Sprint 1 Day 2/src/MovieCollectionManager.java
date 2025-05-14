import java.util.*;
public class MovieCollectionManager {
    ArrayList<String>Title=new ArrayList<>();
    ArrayList<String>Year=new ArrayList<>();
    ArrayList<String>Director=new ArrayList<>();
    ArrayList<String>Genre=new ArrayList<>();
    ArrayList<Float>Rating=new ArrayList<>();

    public void addInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie name:");
        Title.add(sc.nextLine());
        System.out.println("Enter year:");
        Year.add(sc.nextLine());
        System.out.println("Enter director:");
        Director.add(sc.nextLine());
        System.out.println("Enter genre:");
        Genre.add(sc.nextLine());
        System.out.println("Enter rating:");
        Rating.add(sc.nextFloat());
    }
    public void removeMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter movie name to be removed:");
        String movieName = sc.nextLine();
        int index = Title.indexOf(movieName);
        if (index != -1) {
            Title.remove(index);
            Director.remove(index);
            Genre.remove(index);
            Rating.remove(index);
        }
    }
    public void filterMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter criteria to be filtered (Genre/Director/Year):");
        String criteria = sc.nextLine();
        System.out.println("Enter value to filter by:");
        String value = sc.nextLine();

        boolean found = false;
        for (int i = 0; i < Title.size(); i++) {
            if ((criteria.equalsIgnoreCase("Genre") && Genre.get(i).equalsIgnoreCase(value)) ||
                    (criteria.equalsIgnoreCase("Director") && Director.get(i).equalsIgnoreCase(value)) ||
                    (criteria.equalsIgnoreCase("Year") && Year.get(i).equalsIgnoreCase(value))) {
                System.out.println(Title.get(i) + "\t" + Year.get(i) + "\t" + Director.get(i) + "\t" + Genre.get(i) + "\t" + Rating.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching movies found.");
        }
    }
    public void sortMovie() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter condition to be sorted(Title/Year/Rating):");
        String movieName = sc.nextLine();
        if (movieName.equals("Title")) {
            Collections.sort(Title);
        }
        else if (movieName.equals("Year")) {
            Collections.sort(Year);
        }
        else if (movieName.equals("Rating")) {
            Collections.sort(Rating);
        }
    }
    public void printMovie() {
        System.out.println("Title\tYear\tDirector\tGenre\tRating");
        for (int i = 0; i < Title.size(); i++){
        System.out.println(Title+"\t"+Year+"\t"+Director+"\t"+Genre+"\t"+Rating);
        }
    }
    public static void main(String[] args) {
        MovieCollectionManager m = new MovieCollectionManager();
        System.out.println("1.Add movie");
        System.out.println("2.Remove movie");
        System.out.println("3.Filter movie");
        System.out.println("4.Sort movie");
        System.out.println("5.Display");
        System.out.println("6.Exit program");
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();
            switch(choice) {
                case 1:m.addInfo();
                break;
                case 2:m.removeMovie();
                break;
                case 3:m.filterMovie();
                break;
                case 4:m.sortMovie();
                break;
                case 5:m.printMovie();
                break;
                case 6:return;
                default:System.out.println("Invalid choice");
            }
        }

    }
}
