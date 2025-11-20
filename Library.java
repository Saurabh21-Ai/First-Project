// public class Book {
//     static int bookCount = 0;
//     String title, author, ISBN;
//     boolean isBorrowed;         // default value is false
    
//     static int booksAvailable () {
//         return bookCount;
//     }

//     Book (String title, String author, String ISBN) {            // Constructor 
//         bookCount++;            // Creating object to increment count
//         this.title = title;
//         this.author = author;
//         this.ISBN = ISBN;
//     }

//     void borrowBook () {
//         if (isBorrowed) {       // If true
//             System.out.println ("Sorry, " + title + " is already borrowed.");
//             return;
//         } else {
//             isBorrowed = true;   // Mark as borrowed
//             System.out.println ("Borrowed: " + title + " of author " + author);
//         }
//     }

//     void returnBook () {
//         if (this.isBorrowed) {
//             isBorrowed = false;  // Mark as returned
//             System.out.println ("Returned: " + title + " of author " + author);
//         } else {
//             System.out.println (title + " was not borrowed.");
//         }
//     }

//     void bookInfo () {
//         System.out.println ("Title: " + title + ", Author: " + author + ", ISBN: " + ISBN);
//     }


//     public static void main (String[] args) {
//         Book book1 = new Book ("1984", "George Orwell", "123");
//         Book book2 = new Book ("To Kill a Mockingbird", "Harper Lee", "321");

//         System.out.println ("Total books available: " + Book.booksAvailable ());

//         book1.borrowBook();
//         book1.borrowBook();     // Trying to borrow again

//         book1.returnBook();
//         book1.returnBook();     // Trying to return again

//         book2.author = "Sighi"; // Modifying author directly
//         book2.bookInfo ();      // Get details

//         System.out.println ("Total books available: " + Book.booksAvailable());

//     }
// }

import java.util.Scanner;

public class Library {
    static int libraryCount = 0;
    
    String libraryName;             
    int canStoreBooks, totalBooks;  // Library details

    private String books [] [];     // 2D array to store book details

    Library (String libraryName, int canStoreBooks) {
        books = new String [canStoreBooks] [3];
        
        this.canStoreBooks = canStoreBooks;
        this.libraryName = libraryName;
        libraryCount++;
        totalBooks = 0;
    }

    Library (String libraryName) {   // Constructor with default StoreBooks
        this (libraryName, 20);
    }

    void libraryInfo () {
        System.out.println ("Library Name: " + this.libraryName);
        System.out.println ("Library Capacity: " + canStoreBooks + " books.");
    }

    void storeBooks (String author, String title, String ISBN) {
        if ( totalBooks == canStoreBooks ) {
            System.out.println ("Library full. Cannot store more books.");
            return;
        }
        books [totalBooks] = new String [] { title, author, ISBN };
        totalBooks++;
    }

    void showBooks () {
        if (totalBooks == 0) {
            System.out.println ("There no books in " + libraryName);
        } else {
            System.out.println ("Books in " + libraryName + ":");
            for (int i = 0; i < totalBooks; i++) {
                System.out.println ("\t Title: " + books[i][0] + ", Author: " + books[i][1] + ", ISBN: " + books[i][2]);
            }
        }
    }

    void borrowBook (String ISBN) {
        boolean found = false;
        int bookIndex = -1;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i][2].equals(ISBN)) {
                found = true;
                bookIndex = i;
                break;
            }
        }
        if (totalBooks == 0) {
            System.out.println ("There no books in " + libraryName);
        } else if ( found ) {
            System.out.println ("Borrowed the book with ISBN: " + ISBN);
            
            for (int i = bookIndex; i < totalBooks - 1; i++) {
                books[i] = books [i + 1];       // Left shift books to fill the gap
            }
            totalBooks--;                       // Decrease total books count 

        } else {
            System.out.println (ISBN + ": Book not available.");
        }
    }


    public static void main (String [] args) {
        Scanner Sc = new Scanner (System.in);
        
        System.out.print ("Enter you library name: ");
        String LibName = Sc.nextLine ();

        System.out.print ("No of Books can store: ");
        int canStore = Sc.nextInt ();
        

        Library library = new Library (LibName, canStore);
        
        library.libraryInfo ();
        System.out.println ("Store books in " + LibName);


    }
}