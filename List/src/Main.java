//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LUCLinkedList list = new LUCLinkedList();
        list.insert(2);
        list.insert(2);
        list.insert(2);
        list.insert(1);
        list.insert(3);
        list.insert(4);
        list.insert(2);
        list.insert(2);
        list.printList();

        System.out.println();
        System.out.println("Max: " + list.findMax());
        System.out.println("Sum: " + list.addList());


    }
}

