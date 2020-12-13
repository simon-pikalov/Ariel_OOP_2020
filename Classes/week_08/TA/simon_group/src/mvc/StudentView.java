package mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.print.PrinterException;
import java.text.MessageFormat;

class StudentView extends JFrame
{


    public void printStudentDetails(String studentName, String studentRollNo)
    {

        JOptionPane.showMessageDialog(null, "printStudentDetails : "+ studentName +"studentRollNo : "+studentRollNo, "title", JOptionPane.INFORMATION_MESSAGE);
    }
}