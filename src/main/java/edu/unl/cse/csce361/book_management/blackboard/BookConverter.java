package edu.unl.cse.csce361.book_management.blackboard;

import java.awt.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public class BookConverter {
    /*
    This bookConvert method is to converting CSV file into
    Arraylist, the acceptance is that the content in each
    column should be not be null
     */

    public static ArrayList<Book> bookConvert( String filename){
        ArrayList<Book> arrBooks = new ArrayList<Book>();

        Set<Map<String, String>> csvSet = CSVReaderWriter.readCSV(filename);


/*
convert all contents in csv file
into arraylist for containing Book
Type
 */
        for( Map<String,String> mapping : csvSet) {
            BookBuilder builder = new BookBuilder();
            CheckingValidtyOfCSV(mapping,builder,"Author");
            CheckingValidtyOfCSV(mapping,builder,"Status");
            CheckingValidtyOfCSV(mapping,builder,"Title");
            CheckingValidtyOfCSV(mapping,builder,"CallNumber");
            CheckingValidtyOfCSV(mapping,builder,"Summary");
            Book b = builder.build();
            arrBooks.add(b);
        }

        return arrBooks;
    }

    /*
    Extracting the print message into
    function to avoid the duplicated code
     */
    public static void CheckingValidtyOfCSV(Map<String,String> mapping,BookBuilder builder,String Type){
        if(mapping.get(Type) != null && mapping.get(Type).length() >= 1) {
            switch (Type){
                case "Author":
                    builder.setAuthor(mapping.get(Type));
                    break;
                case "Status":
                    builder.setStatus(mapping.get(Type));
                    break;
                case "Title":
                    builder.setTitle(mapping.get(Type));
                    break;
                case "CallNumber":
                    builder.setCallnumber(mapping.get(Type));
                    break;
                case "Summary":
                    builder.setSummary(mapping.get(Type));
                    break;
                case "Copynumber":
                	int copyNumber = Integer.parseInt(mapping.get(Type));
                	builder.setCopyNumber(copyNumber);
                	break;
            }
        }
        
    }


}


