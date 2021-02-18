import java.util.HashMap;

public class Library {
    private HashMap<String, Integer> books;
    private static Library library;

    private Library() {}

    public static Library getInstance()
    {
        if(library==null)
        {
            System.out.println("Creating our Library. Time to begin reading");
            library = new Library();
        }
        return library;
    }

    public boolean checkoutBook(String bookName)
    {
        if(books.containsKey(bookName) && books.get(bookName)>0)
        {
            books.remove(bookName);
            System.out.println("...was successfully checkout out");
            return true;
        }
        else
        {
            System.out.println("Sorry "+bookName+" is not in stock");
            return false;
        }
    }

    public void checkInBook(String bookName, int numToAdd)
    {
        if(books.containsKey(bookName))
        {
            books.put(bookName, books.get(bookName)+numToAdd);
        }
        else
        {
            books.put(bookName, numToAdd);
        }
        System.out.println(bookName+" was added to the library");
    }

    public void displayBooks()
    {
        System.out.println("Inventory:");
        books.forEach((i, j) -> System.out.println("- "+i+", copies: "+j));
    }
}
