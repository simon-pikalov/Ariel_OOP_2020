package gui.buttons;

import javax.swing.*;

 public class JoptionPaneExample{

    public static void main(String[] args) {

        //JOptionPane = pop up a standard dialog box that prompts users for a value
        //    or informs them of something.

        JOptionPane.showMessageDialog(null, "This is a message dialog box", "title", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "Here is some useless info", "title", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "really?", "title", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "Your computer has a VIRUS!", "title", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "CALL TECH SUPPORT OR ELSE!", "title", JOptionPane.ERROR_MESSAGE);


        //int answer = JOptionPane.showConfirmDialog(null, "bro, do you even code?");
        //String name = JOptionPane.showInputDialog("What is your name?: ");

        ImageIcon icon = new ImageIcon("smile.png");
        String[] responses = {"No, you are!","thank you!","*blush*"};
        int answer = JOptionPane.showOptionDialog(
                null,
                "You are the best! :D",
                "Secret message",
                JOptionPane.DEFAULT_OPTION,
                0,
                icon,
                responses,
                responses[0]);
        System.out.println(answer);

    }
}
