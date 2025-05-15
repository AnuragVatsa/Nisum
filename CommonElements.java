import java.util.*;
class CommonElement{
    public static <T> List<T> findCommon(List<T> list1, List<T> list2) {
        List<T> commonElements = new ArrayList<>();
        for (T element : list1) {
            if (list2.contains(element) && !commonElements.contains(element)) {
                commonElements.add(element);
            }
        }
        return commonElements;
    }
    public static void main(String[] args) {
        List<String> l1 = List.of("apple", "banana", "cherry", "apple");
        List<String> l2 = List.of("banana", "grape", "cherry");
        List<String> result = findCommon(l1, l2);
        System.out.println("Common elements: " + result);
    }
}