package stu_grade_tracker;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class traker extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtname;
    private JTextField textage;
    JLabel lblinfo;
    private JTextField math;
    private JTextField sci;
    private JTextField Eng;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JTextField txttot;
    private JTextField txtavg;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    private JLabel lblNewLabel_8;
    private JTextField txtindex;
    private ArrayList<Student> students = new ArrayList<>();
    private JTextField max;
    private JTextField min;

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    traker frame = new traker();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    // Method to check if a string contains any digit
    private boolean containsDigit(String s) {
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    public traker() {
    	setForeground(new Color(255, 0, 128));
        setTitle("DemoFrame");
        setBackground(Color.PINK);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 579, 496);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(32, 178, 170));
        contentPane.setForeground(new Color(255, 0, 128));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Enter name");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel.setBounds(0, 50, 86, 14);
        contentPane.add(lblNewLabel);

        txtname = new JTextField();
        txtname.setBackground(Color.LIGHT_GRAY);
        txtname.setBounds(74, 47, 107, 20);
        contentPane.add(txtname);
        txtname.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Enter age");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_1.setBounds(0, 75, 67, 14);
        contentPane.add(lblNewLabel_1);

        textage = new JTextField();
        textage.setBackground(Color.LIGHT_GRAY);
        textage.setBounds(74, 75, 107, 20);
        contentPane.add(textage);
        textage.setColumns(10);

        lblinfo = new JLabel("");
        lblinfo.setBounds(130, 260, 165, 14);
        contentPane.add(lblinfo);

        JLabel lblNewLabel_2 = new JLabel("maths");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_2.setBounds(0, 100, 46, 14);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("science");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_3.setBounds(0, 125, 46, 14);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("English");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_4.setBounds(0, 150, 46, 14);
        contentPane.add(lblNewLabel_4);

        math = new JTextField();
        math.setBackground(Color.LIGHT_GRAY);
        math.setBounds(74, 97, 107, 20);
        contentPane.add(math);
        math.setColumns(10);

        sci = new JTextField();
        sci.setBackground(Color.LIGHT_GRAY);
        sci.setBounds(74, 122, 107, 20);
        contentPane.add(sci);
        sci.setColumns(10);

        Eng = new JTextField();
        Eng.setBackground(Color.LIGHT_GRAY);
        Eng.setBounds(74, 147, 107, 20);
        contentPane.add(Eng);
        Eng.setColumns(10);

        lblNewLabel_5 = new JLabel("total");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_5.setBounds(216, 50, 62, 14);
        contentPane.add(lblNewLabel_5);

        lblNewLabel_6 = new JLabel("average");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_6.setBounds(216, 75, 62, 14);
        contentPane.add(lblNewLabel_6);

        txttot = new JTextField();
        txttot.setBackground(Color.LIGHT_GRAY);
        txttot.setBounds(288, 47, 86, 20);
        contentPane.add(txttot);
        txttot.setColumns(10);

        txtavg = new JTextField();
        txtavg.setBackground(Color.LIGHT_GRAY);
        txtavg.setBounds(288, 72, 86, 20);
        contentPane.add(txtavg);
        txtavg.setColumns(10);

        btnNewButton = new JButton("add");
        btnNewButton.setBackground(Color.ORANGE);
        btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
     
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try {
                    String name = txtname.getText();
                    int age = Integer.parseInt(textage.getText());
                    int mathMark = Integer.parseInt(math.getText());
                    int scienceMark = Integer.parseInt(sci.getText());
                    int englishMark = Integer.parseInt(Eng.getText());
                    int stuindex = Integer.parseInt(txtindex.getText());
                 
                    // Validate name field to ensure it does not contain digits
                    if (containsDigit(name)) {
                        JOptionPane.showMessageDialog(null, "Name field should only contain alphabetic characters.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    
                    if (age < 5 || age > 50) {
                        JOptionPane.showMessageDialog(null, "Age must be between 5 and 50.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if age is not within the valid range
                    }
                    
                    // Input validation to ensure marks are within a valid range
                    if (mathMark < 0 || mathMark > 100 || scienceMark < 0 || scienceMark > 100 || englishMark < 0 || englishMark > 100) {
                        // Display an error message if marks are not within the valid range
                        JOptionPane.showMessageDialog(null, "Please enter valid marks (0-100).", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Exit the method if marks are not valid
                    }
                 // Check if the student index is already used
                    for (Student student : students) {
                        if (student.stuindex == stuindex) {
                            JOptionPane.showMessageDialog(null, "Student index already exists.", "Error", JOptionPane.ERROR_MESSAGE);
                            return; // Exit the method if student index already exists
                        }
                    }
                    
                    int tot = englishMark + mathMark + scienceMark;
                    double avg = (double) tot / 3;
                    txttot.setText(String.valueOf(tot));
                    txtavg.setText(String.valueOf(avg));
                    Student student = new Student(name,age, mathMark, scienceMark, englishMark,stuindex);
                    students.add(student);
                    updateDisplay();
                } catch (NumberFormatException ex) {
                    // Display an error message if non-numeric input is entered
                    JOptionPane.showMessageDialog(null, "No data added yet please input valid data.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            
            }
        });
        
      

    	
        btnNewButton.setBounds(0, 285, 121, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("clear");
        btnNewButton_1.setBackground(Color.ORANGE);
        btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtname.setText("");
                textage.setText("");
                math.setText("");
                 sci.setText("");
                Eng.setText("");
                txttot.setText("");
                txtavg.setText("");
                txtindex.setText("");
            }
        });
        btnNewButton_1.setBounds(0, 319, 115, 23);
        contentPane.add(btnNewButton_1);

        lblinfo = new JLabel("");
        lblinfo.setBounds(130, 260, 165, 14);
        contentPane.add(lblinfo);

        lblNewLabel_8 = new JLabel("Student_Grade_Tracker_System");
        lblNewLabel_8.setBackground(Color.BLUE);
        lblNewLabel_8.setForeground(Color.DARK_GRAY);
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
        lblNewLabel_8.setBounds(145, 1, 289, 38);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("Stuindex");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_9.setBounds(0, 175, 62, 14);
        contentPane.add(lblNewLabel_9);

        txtindex = new JTextField();
        txtindex.setBackground(Color.LIGHT_GRAY);
        txtindex.setBounds(74, 172, 107, 20);
        contentPane.add(txtindex);
        txtindex.setColumns(10);
        
        JLabel lblNewLabel_10 = new JLabel("hightotal");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_10.setBounds(216, 100, 56, 14);
        contentPane.add(lblNewLabel_10);
        
        max = new JTextField();
        max.setBackground(Color.LIGHT_GRAY);
        max.setBounds(288, 97, 86, 20);
        contentPane.add(max);
        max.setColumns(10);
        
        JLabel lblNewLabel_11 = new JLabel("low total");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_11.setBounds(216, 125, 62, 14);
        contentPane.add(lblNewLabel_11);
        
        min = new JTextField();
        min.setBackground(Color.LIGHT_GRAY);
        min.setBounds(288, 122, 86, 20);
        contentPane.add(min);
        min.setColumns(10);
        
        JButton btnNewButton_2 = new JButton("lowest mark Student");
        btnNewButton_2.setBackground(Color.ORANGE);
        btnNewButton_2.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if (students.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No students added yet.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Initialize variables to keep track of the student with the lowest total marks
                Student lowestMarkStudent = null;
                int minTotal = Integer.MAX_VALUE;

                // Iterate through the ArrayList of students to find the student with the lowest total marks
                for (Student student : students) {
                    int total = student.mathMark + student.scienceMark + student.englishMark;

                    if (total < minTotal) {
                        minTotal = total;
                        lowestMarkStudent = student;
                    }
                }

                // Display the details of the student with the lowest total marks in the text fields
                if (lowestMarkStudent != null) {
                    txtname.setText(lowestMarkStudent.name);
                    textage.setText(String.valueOf(lowestMarkStudent.age));
                    math.setText(String.valueOf(lowestMarkStudent.mathMark));
                    sci.setText(String.valueOf(lowestMarkStudent.scienceMark));
                    Eng.setText(String.valueOf(lowestMarkStudent.englishMark));
                    txttot.setText(String.valueOf(lowestMarkStudent.mathMark + lowestMarkStudent.scienceMark + lowestMarkStudent.englishMark));
                    txtavg.setText(String.valueOf((lowestMarkStudent.mathMark + lowestMarkStudent.scienceMark + lowestMarkStudent.englishMark) / 3.0));
                    txtindex.setText(String.valueOf(lowestMarkStudent.stuindex));
                }
        	}
        });
        btnNewButton_2.setBounds(334, 284, 178, 23);
        contentPane.add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("highest mark  Student");
        btnNewButton_3.setBackground(Color.ORANGE);
        btnNewButton_3.setFont(new Font("Dialog", Font.BOLD, 12));
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Check if the students list is not empty
                if (!students.isEmpty()) {
                    // Initialize variables to store details of the student with the highest total marks
                    Student highMarkStudent = null;
                    int highestTotal = Integer.MIN_VALUE;

                    // Iterate through the ArrayList of students to find the student with the highest total marks
                    for (Student student : students) {
                        int totalMarks = student.mathMark + student.scienceMark + student.englishMark;
                        if (totalMarks > highestTotal) {
                            highestTotal = totalMarks;
                            highMarkStudent = student;
                        }
                    }

                    // Populate the text fields with the details of the high mark student
                    if (highMarkStudent != null) {
                        txtname.setText(highMarkStudent.name);
                        textage.setText(String.valueOf(highMarkStudent.age));
                        math.setText(String.valueOf(highMarkStudent.mathMark));
                        sci.setText(String.valueOf(highMarkStudent.scienceMark));
                        Eng.setText(String.valueOf(highMarkStudent.englishMark));
                        txttot.setText(String.valueOf(highMarkStudent.mathMark + highMarkStudent.scienceMark + highMarkStudent.englishMark));
                        txtavg.setText(String.valueOf((highMarkStudent.mathMark + highMarkStudent.scienceMark + highMarkStudent.englishMark) / 3.0));
                        txtindex.setText(String.valueOf(highMarkStudent.stuindex));
                        
                    }
                } else {
                    // Display a message if the students list is empty
                    JOptionPane.showMessageDialog(null, "No students added yet.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
        	}
        });
        btnNewButton_3.setBounds(338, 323, 178, 23);
        contentPane.add(btnNewButton_3);
    }

    private void updateDisplay() {
    	 StringBuilder message = new StringBuilder("Student List:\n-------------\n");
        // Clear the console panel before displaying the updated student list
        System.out.println("Student List:");
        System.out.println("-------------");
        
        // Initialize minTotal with the maximum possible value
        int minTotal = Integer.MAX_VALUE;
        // Initialize maxTotal with the minimum possible value
        int maxTotal = Integer.MIN_VALUE;
        
        // Iterate through the ArrayList of students and display their details
        for (Student student : students) {
            // Calculate total marks for the current student
            int total = student.mathMark + student.scienceMark + student.englishMark;
            
            // Update minTotal if the current total is less than minTotal
            if (total < minTotal) {
                minTotal = total;
            }
            if (total > maxTotal) {
                maxTotal = total;
            }
            
            /*// Display the details of the current student
            System.out.println("Name: " + student.name);
            System.out.println("Age: " + student.age);
            System.out.println("Math Mark: " + student.mathMark);
            System.out.println("Science Mark: " + student.scienceMark);
            System.out.println("English Mark: " + student.englishMark);
            System.out.println("stu index: " + student.stuindex);
            System.out.println();*/
            message.append("Name: ").append(student.name).append("\n");
            message.append("Age: ").append(student.age).append("\n");
            message.append("Math Mark: ").append(student.mathMark).append("\n");
            message.append("Science Mark: ").append(student.scienceMark).append("\n");
            message.append("English Mark: ").append(student.englishMark).append("\n");
            message.append("Student Index: ").append(student.stuindex).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, message.toString(), "Student Details", JOptionPane.INFORMATION_MESSAGE); 
        // Set the value of the min text field to the minimum total found
        min.setText(String.valueOf(minTotal));
        max.setText(String.valueOf(maxTotal));
    }


    // Inner class to represent a student
    private class Student {
        String name;
        int age;
        int mathMark;
        int scienceMark;
        int englishMark;
        int stuindex;

        public Student(String name, int age, int mathMark, int scienceMark, int englishMark,int stuindex) {
            this.name = name;
            this.age = age;
            this.mathMark = mathMark;
            this.scienceMark = scienceMark;
            this.englishMark = englishMark;
            this.stuindex=stuindex;
        }
    }
}



