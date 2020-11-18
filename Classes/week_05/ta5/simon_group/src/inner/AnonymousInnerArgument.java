package inner;

// interface
interface Message {
    /**
     *
     * @return String of some kind
     */
     String greet(); //this is a function ! not a variable
}

public class AnonymousInnerArgument {
    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.greet() +
                ", This is an example of anonymous inner class as an argument");
    }

    public static void main(String args[]) {
        // Instantiating the class
        AnonymousInnerArgument obj = new AnonymousInnerArgument();

        // Passing an anonymous inner class as an argument
        obj.displayMessage(new Message() {
            public String greet() {
                return " anonymous inner class as an argument is great :)";
            }
        });
    }
}
