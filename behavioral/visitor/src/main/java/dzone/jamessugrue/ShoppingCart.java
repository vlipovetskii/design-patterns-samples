package dzone.jamessugrue;

/*
import java.util.ArrayList;

//Element interface
interface Visitable{
    public void accept(Visitor visitor);
}

//concrete element
class Book implements Visitable{
    private double price;
    private double weight;
    //accept the visitor
    public void accept(Visitor vistor) {
        visitor.visit(this);
    }
    public double getPrice() {
        return price;
    }
    public double getWeight() {
        return weight;
    }
}

interface Visitor{
    public void visit(Book book);

    //visit other concrete items
    public void visit(CD cd);
    public void visit(DVD dvd);
}


class PostageVisitor implements Visitor {
    private double totalPostageForCart;
    //collect data about the book
    public void visit(Book book) {
        //assume we have a calculation here related to weight and price
        //free postage for a book over 10
        if(book.getPrice() < 10.0) {
            totalPostageForCart += book.getWeight() * 2;
        }
    }
    //add other visitors here
    public void visit(CD cd) {...}
    public void visit(DVD dvd) {...}
    //return the internal state
    public double getTotalPostage() {
        return totalPostageForCart;
    }
}

public class ShoppingCart {
    //normal shopping cart stuff
    private ArrayList<Visitable> items;
    public double calculatePostage() {
        //create a visitor
        PostageVisitor visitor = new PostageVisitor();
        //iterate through all items
        for(Visitable item: items) {
            item.accept(visitor);
        }
        double postage = visitor.getTotalPostage();
        return postage;
    }
}
*/
