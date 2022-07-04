package src.corejava.oops.in28Minutes;

public class BookDriver {

    public static void main(String[] args) {
        Book artOfComputerProgramming = new Book("Art of Computer Programming");
        Book effectiveJava = new Book("Effective Java");
        Book cleanCode = new Book("Clean Code");

        artOfComputerProgramming.setBookPublisher("Penguin Books");
        cleanCode.setNoOfCopies(87);
        effectiveJava.setNoOfCopies(21);
        artOfComputerProgramming.setNoOfCopies(55);



    }
}
