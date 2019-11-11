package edu.unl.cse.csce361.book_management.blackboard;

        import java.util.ArrayList;
        import java.util.Observable;
        import java.util.Observer;
        import java.util.Scanner;
        import java.time.format.DateTimeFormatter;
        import java.time.LocalDateTime;

public class Patron implements Observer {

    /*
    This part for all parameters
     */
    static ArrayList<Book> arrBooks = Librarian.getArrBooks();
    static ArrayList<Patron> arrPatron = new ArrayList<Patron>();
    static Scanner scan = new Scanner(System.in);
    static Librarian librarian = new Librarian();
    public String name;
    public Book bookInCart;
    static ArrayList<Book> booksInCart;
    public ArrayList<Book> booksCheckedOut;
    public String date;


    /*
    This part for all get method and set method
     */
    public void AddBookIntoCart(Book bookInCart) {
        booksInCart.add(bookInCart);
    }
    public  void  CartSetup(){
        booksInCart =new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDate(String date) {
        this.date = date;
    }
 


    public static ArrayList<Book> getArrBooks() {
		return arrBooks;
	}
	public static ArrayList<Patron> getArrPatron() {
		return arrPatron;
	}
	public static Scanner getScan() {
		return scan;
	}
	public static Librarian getLibrarian() {
		return librarian;
	}
	public String getName() {
		return name;
	}
	public Book getBookInCart() {
		return bookInCart;
	}
	public static ArrayList<Book> getBooksInCart() {
		return booksInCart;
	}
	public ArrayList<Book> getBooksCheckedOut() {
		return booksCheckedOut;
	}
	public String getDate() {
		return date;
	}
	@Override
    public void update(Observable b, Object Books) {
        System.out.println("New book is added to a catalog");
    }


    /*
    This part for search book for author or book title
    if the title or author name can not be found in
    database, it will loop again
     */
    public static void searchBookbyAuthorOrTitle() {
        System.out.println("If you like to search by author then press 1 or If you like to search by title press 2");
        int search = scan.nextInt();
        scan.nextLine();
        Boolean NeedToLoop = true;
        while (NeedToLoop) {
            if (search == 1) {
                System.out.println("Please enter the author name");
                String authorName = scan.nextLine();
                NeedToLoop = CheckValidityInput(authorName);
                if (NeedToLoop){
                    System.out.println("You input is invalid which can not match in the author name of database");
                }
                Loop(authorName, "author_name");
            } else if (search == 2) {
                System.out.println("Please enter the title of the book");
                String titleName = scan.nextLine();
                NeedToLoop = CheckValidityInput(titleName);
                if (NeedToLoop){
                    System.out.println("You input is invalid which can not match in the titleName of database");
                }
                Loop(titleName, "Title");
            }
        }


    }

    /*
    This part is for adding the book to cart as a
    patron, if the author name can not be found in
    database,it can be loop again
     */
    public static void addBookToCartAsPatron() {

        Patron newPatron = new Patron();
        System.out.println("Please enter your Name");
        String patronName = scan.nextLine();
        newPatron.setName(patronName);
        System.out.println("Please enter the author of the book");
        String authorName = scan.nextLine();
        boolean NeedToLoop = true;
        while (NeedToLoop != false) {
            for (int i = 0; i < arrBooks.size(); i++) {
                if (arrBooks.get(i).getAuthor().equalsIgnoreCase(authorName)) {
                    newPatron.CartSetup();
                    newPatron.AddBookIntoCart(arrBooks.get(i));
                    
                    NeedToLoop = false;
                }
              
            }
            if (NeedToLoop == true){
                System.out.println("Please enter correct author name");
                authorName = scan.nextLine();
            }
         
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        newPatron.setDate(dtf.format(now));
        arrPatron.add(newPatron);
    }


    private static void Prompt(String AuthorName, String TitleName, String Status, String Summary){
        System.out.println("Author :- "+ AuthorName);
        System.out.println("Title :- "+ TitleName);
        System.out.println("Status :- "+Status);
        System.out.println("Summary :-"+Summary);
    }

    private static void Loop(String string,String Type){
        switch (Type){
	                /*This part only check for title,
	                This contains when the status is missing or not,
	                when the status is missing, it will shows that it will be
	                available later
	                */

            case "Title":
                for (Book book:arrBooks
                ) {
                    if (book.getTitle().equalsIgnoreCase(string)){
                        if (book.getStatus().equalsIgnoreCase("Missing")){
                            Prompt(book.getAuthor(),book.getTitle(),"Will be available later1",book.getSummary());
                        }
                        else {
                            Prompt(book.getAuthor(),book.getTitle(),book.getStatus(),book.getSummary());
                        }

                    }
                }
                break;
	                /*This part only check for author_name,
	                This contains when the status is missing or not,
	                when the status is missing, it will shows that it will be
	                available later
	                */
            case "author_name":
                for (Book book:arrBooks
                ) {
                    if (book.getAuthor().equalsIgnoreCase(string)){
                        if (book.getStatus().equalsIgnoreCase("Missing")){

                        }else {
                            Prompt(book.getAuthor(),book.getTitle(),book.getStatus(),book.getSummary());
                        }
                    }
                }
                break;
	                /*
	                This part shows that the invalid input
	                 */
        }
    }



    /*
    When the author name does not exist in database,
    it will return True ,which will result to loop again
    else,it will return false,which will result to no
    loop again
     */
    public static Boolean CheckValidityInput(String string){
        Boolean NeedToLoop= true;
        for (Book book:arrBooks
        ) {
            if (book.getAuthor().equalsIgnoreCase(string)){
                NeedToLoop =false;
            }else if (book.getTitle().equalsIgnoreCase(string)){
                NeedToLoop =false;
            }
        }
        return NeedToLoop;
    }
    public void ViewHoldList(){
        scan = new Scanner(System.in);
        System.out.println("What is the book title that you want to search?");
        String InputTitle = scan.nextLine();
        System.out.println(arrBooks.get(0).PatronHoldList());

        for (Book book:arrBooks
        ) {
            if (book.getTitle().equals(InputTitle)){
                System.out.println("The hold list is that: ");
                System.out.println(book.PatronHoldList());
            }

        }
    }
    public static void printBooksInCart() {

        System.out.println("Here is the list of books in cart");

        for(int i = 0; i<booksInCart.size();i++) {

            System.out.println("Book Number :- " + (i+1) + " ----------------------------------------------------------------");
            System.out.println("Author :- "+ booksInCart.get(i).getAuthor());
            System.out.println("Title :- "+ booksInCart.get(i).getTitle());

            System.out.println("CallNumber :- " + booksInCart.get(i).getCallNumber());
            System.out.println("Summary :-"+booksInCart.get(i).getSummary());
        }

    }

    public static void PlaceBookOnHoldAsPatron(){
        System.out.println("Please input your name");
        Scanner scanner2 =new Scanner(System.in);
        String PatronName = scanner2.nextLine();
        System.out.println("Please input the Book Title");
        String BookTitle = scanner2.nextLine();
        for (Book book:arrBooks
        ) {
            if (book.getTitle().equals(BookTitle)) {
                 book.AddPatron(PatronName);
                        break;
            }

        }

    }
    public static void PrintPatronInfo() {
    	System.out.println("Please enter your name");
    	String patronName = scan.nextLine();
    	boolean check = false;
    	while(check == false) {
    	for(int i =0 ; i< arrPatron.size(); i++) {
    		if(arrPatron.get(i).getName().equalsIgnoreCase(patronName)) {
    			System.out.println(" Your Name :- " + patronName);
               printBooksInCart();
                check = true;
    		}
    	}
    	if(check == false) {
    	   System.out.println("Please enter correct name");
    	   patronName = scan.nextLine();
    	}
    }
    }
}