package inner;

// interface
interface Message {
    /**
     *
     * @return String of some kind
     */
     String show(); //this is a function ! not a variable
}




 class MessageUse {

    // method which accepts the object of interface Message
    public void displayMessage(Message m) {
        System.out.println(m.show() +
                ", This is an example of anonymous inner class as an argument");
    }



    public static void main(String args[]) {
        // Instantiating the class
        MessageUse argExample = new MessageUse();


        // Passing an anonymous inner class as an argument
        argExample.displayMessage(new Message() {
            @Override
            public String show() {
                return " anonymous inner class as an argument is great :)";
            }
        });


    }
}
