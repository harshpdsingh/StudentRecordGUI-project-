import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    private String name;
    private int rollNumber;
    private String course;
    private int semester;
    private int fee;
    private int age;
    private String gender;
    private String caste;

    public Student(String name, int rollNumber, String course, int semester, int fee, int age, String gender, String caste) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
        this.semester = semester;
        this.fee = fee;
        this.age = age;
        this.gender = gender;
        this.caste = caste;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Roll Number: " + rollNumber + "\n" +
                "Course: " + course + "\n" +
                "Semester: " + semester + "\n" +
                "Fee: " + fee + "\n" +
                "Age: " + age + "\n" +
                "Gender: " + gender + "\n" +
                "Caste: " + caste + "\n";
    }

    public int getRollNumber() {
        return rollNumber;
    }
}

public class StudentRecordGUI extends JFrame implements ActionListener {
    // GUI Components
    private JButton addBtn, viewBtn, searchBtn;
    private JTextField nameField, rollNoField, courseField, semesterField, feeField, ageField, genderField, casteField;
    private JTextArea displayArea;
    private JPanel inputPanel, displayPanel;

    // Data Collection
    private ArrayList<Student> students;

    public StudentRecordGUI() {
        setTitle("Student Record Management");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        students = new ArrayList<>();

        // Input Panel
        inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Name: "), gbc);

        gbc.gridx = 1;
        nameField = new JTextField(10);
        inputPanel.add(nameField, gbc);

        gbc.gridx = 2;
        inputPanel.add(new JLabel("Roll Number: "), gbc);

        gbc.gridx = 3;
        rollNoField = new JTextField(10);
        inputPanel.add(rollNoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Course: "), gbc);

        gbc.gridx = 1;
        courseField = new JTextField(10);
        inputPanel.add(courseField, gbc);

        gbc.gridx = 2;
        inputPanel.add(new JLabel("Semester: "), gbc);

        gbc.gridx = 3;
        semesterField = new JTextField(10);
        inputPanel.add(semesterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        inputPanel.add(new JLabel("Fee: "), gbc);

        gbc.gridx = 1;
        feeField = new JTextField(10);
        inputPanel.add(feeField, gbc);

        gbc.gridx = 2;
        inputPanel.add(new JLabel("Age: "), gbc);

        gbc.gridx = 3;
        ageField = new JTextField(10);
        inputPanel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        inputPanel.add(new JLabel("Gender: "), gbc);

        gbc.gridx = 1;
        genderField = new JTextField(10);
        inputPanel.add(genderField, gbc);

        gbc.gridx = 2;
        inputPanel.add(new JLabel("Caste: "), gbc);

        gbc.gridx = 3;
        casteField = new JTextField(10);
        inputPanel.add(casteField, gbc);

        // Buttons
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        searchBtn = new JButton("Search Student");
        searchBtn.addActionListener(this);
        inputPanel.add(searchBtn, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        addBtn = new JButton("Add Student");
        addBtn.addActionListener(this);
        inputPanel.add(addBtn, gbc);

        gbc.gridx = 3;
        viewBtn = new JButton("View Students");
        viewBtn.addActionListener(this);
        inputPanel.add(viewBtn, gbc);

        // Display Panel
        displayPanel = new JPanel(new BorderLayout());

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addBtn) {
            String name = nameField.getText();
            int rollNumber = Integer.parseInt(rollNoField.getText());
            String course = courseField.getText();
            int semester = Integer.parseInt(semesterField.getText());
            int fee = Integer.parseInt(feeField.getText());
            int age = Integer.parseInt(ageField.getText());
            String gender = genderField.getText();
            String caste = casteField.getText();

            Student student = new Student(name, rollNumber, course, semester, fee, age, gender, caste);
            students.add(student);

            JOptionPane.showMessageDialog(this, "Student Added Successfully!");
        } else if (e.getSource() == viewBtn) {
            displayArea.setText("");
            for (Student student : students) {
                displayArea.append(student.toString() + "\n");
            }
        } else if (e.getSource() == searchBtn) {
            int searchRollNo = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter Roll Number Of Student: "));
            boolean found = false;
            for (Student student : students) {
                if (student.getRollNumber() == searchRollNo) {
                    displayArea.setText("Student Found:\n" + student.toString());
                    found = true;
                    break;
                }
            }
            if (!found)
                JOptionPane.showMessageDialog(this, "Student not found!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentRecordGUI().setVisible(true);
            }
        });
    }
}
