package Extra;

public class Book {
    int bookId;
    String bookName;
    double salary;

    Book(){};
    Book(int id, String name, int salary){
        this.bookId = id;
        this.bookName = name;
        this.salary = salary;
    }

    public int getId(){
        return bookId;
    }

    public String getTitle(){
        return bookName;
    }

    public static void main(String[] args) {
        Book[] bookarray = new Book[3];
        bookarray[0] = new Book(11,"java",2000);
        bookarray[1] = new Book(12,"python",3000);
        bookarray[2] = new Book(13,"cpp",1000);

        Book result = getBookById(bookarray,11);
        if(result != null){
            System.out.println(result.getTitle());
        }else{
            System.out.println("No book found");
        }
    }
    public static Book getBookById(Book[] bookList, int id){
        Book book = null;
        for (Book b: bookList) {
            if(b.getId() == id){
                book = b;
                break;
            }
        }
        return book;
    }
}
