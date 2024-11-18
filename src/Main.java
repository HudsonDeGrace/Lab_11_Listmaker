import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> myArrList = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean terminate = false;

        do {
            listPrint(myArrList);

            System.out.println("\nA – Add an item to the list");
            System.out.println("D – Delete an item from the list");
            System.out.println("I – Insert an item into the list");
            System.out.println("P – Print (i.e. display) the list");
            System.out.println("Q – Quit the program");

            String input = SafeInput.getRegExString(in, "Please select an option", "[AaDdIiPpQq]");
            if (input.equals("A") || input.equals("a")) {
                listAdd(in, myArrList);
            } else if (input.equals("D") || input.equals("d")) {
                listDelete(in, myArrList);
            } else if (input.equals("I") || input.equals("i")) {
                listInput(in, myArrList);
            } else if (input.equals("P") || input.equals("p")) {
                listPrint(myArrList);
            } else {
                if(SafeInput.getYNConfirm(in, "Are you sure you want to quit?")){
                    terminate = true;
                }
            }
        }while(!terminate);
    }

    public static ArrayList<String> listAdd(Scanner in, ArrayList<String> myArrList){
        String input = SafeInput.getNonZeroLenString(in, "Type what you want added to the list: ");
        myArrList.add(input);
        return myArrList;
    }

    public static void numberedDisplay(ArrayList<String> myArrList){
        for(int i = 0; i < myArrList.size(); i++){
            System.out.printf("\n%1$d. %2$s", i+1, myArrList.get(i));
        }
        System.out.println();
    }

    public static ArrayList<String> listDelete(Scanner in, ArrayList<String> myArrList){
        numberedDisplay(myArrList);

        int input = SafeInput.getRangedInt(in, "Choose an item to delete", 1, myArrList.size());
        myArrList.remove(input - 1);
        in.nextLine();

        return myArrList;
    }

    public static ArrayList<String> listInput(Scanner in, ArrayList<String> myArrList){
        numberedDisplay(myArrList);

        int index = SafeInput.getRangedInt(in, "Choose where to put a new item", 1, myArrList.size() + 1);
        in.nextLine();
        String string = SafeInput.getNonZeroLenString(in, "Type what you want inputted into the list: ");
        myArrList.add(index - 1, string);

        return myArrList;
    }

    public static void listPrint(ArrayList<String> myArrList){
        System.out.println();
        for(String i : myArrList){
            System.out.println("*   " + i);
        }
    }
}