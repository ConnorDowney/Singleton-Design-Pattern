import java.util.HashMap;

/**
 * A Library
 * @author Connor Downey
 */
public class Library {
    private HashMap<String, Integer> books = new HashMap<String,  Integer>();
    private static Library library;

    private Library() {}

    /**
     * Creates an instance of a library if there isn't one
     * @return The instance of the library
     */
    public static Library getInstance()
    {
        if(library==null)
        {
            System.out.println("Creating our Library. Time to begin reading.");
            library = new Library();
        }
        return library;
    }

    /**
     * Checks out the book
     * @param bookName Name of the book
     * @return True if the book is checked out, False if there were no copies of the book
     */
    public boolean checkoutBook(String bookName)
    {
        if(books.containsKey(bookName) && books.get(bookName)>0)
        {
            books.put(bookName, 0);
            System.out.println(bookName+" was successfully checked out");
            return true;
        }
        else
        {
            System.out.println("Sorry "+bookName+" is not in stock");
            return false;
        }
    }

    /**
     * Checks in a book
     * @param bookName Name of the book
     * @param numToAdd Number of books being checked in
     */
    public void checkInBook(String bookName, int numToAdd)
    {
        if(books.containsKey(bookName))
        {
            books.put(bookName, books.get(bookName)+numToAdd);
            System.out.print("A new copy of ");
        }
        else
        {
            books.put(bookName, numToAdd);
        }
        System.out.println(bookName+" was added to the library");
    }

    /**
     * Displays the books in the inventory with the number of copies
     */
    public void displayBooks()
    {
        System.out.println("Inventory:");
        books.forEach((i, j) -> System.out.println("- "+i+", copies: "+j));
    }
}
