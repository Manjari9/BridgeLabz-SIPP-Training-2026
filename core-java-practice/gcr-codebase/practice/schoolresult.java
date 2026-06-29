import java.io.*;
import java.util.*;

class schoolresult {
    
    public static List<Student> readStudentMarks(String inputFileName) {
        List<Student> students = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.trim().split(",");
                if (parts.length >= 2) {
                    String name = parts[0].trim();
                    try {
                        // Read marks (can be multiple subjects)
                        int[] marks = new int[parts.length - 1];
                        for (int i = 1; i < parts.length; i++) {
                            marks[i - 1] = Integer.parseInt(parts[i].trim());
                        }
                        students.add(new Student(name, marks));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid marks format for student: " + name);
                    }
                }
            }
            System.out.println("Successfully read " + students.size() + " students from file.");
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file '" + inputFileName + "' not found.");
            System.err.println("Please create the file with format: StudentName,Mark1,Mark2,Mark3,...");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return students;
    }
    public static void writeReportCards(List<Student> students, String outputFileName, boolean append) {
        if (students.isEmpty()) {
            System.out.println("No students to write report cards for.");
            return;
        }
        
        try (FileWriter fw = new FileWriter(outputFileName, append)) {
            if (append) {
                fw.write("\n" + "=".repeat(70) + "\n");
                fw.write("New Report Generated at: " + new Date() + "\n");
            } else {
                fw.write("=".repeat(70) + "\n");
                fw.write("SCHOOL RESULT PORTAL - REPORT CARD\n");
                fw.write("=".repeat(70) + "\n\n");
            }
            
            for (Student student : students) {
                fw.write(String.format("%-20s | Average: %.2f%% | Grade: %s\n",
                        student.getName(),
                        student.getAverage(),
                        student.getGrade()));
                int[] marks = student.getMarks();
                for (int i = 0; i < marks.length; i++) {
                    fw.write(String.format("  Subject %d: %d marks\n", (i + 1), marks[i]));
                }
                fw.write("-".repeat(70) + "\n");
            }
        
            double classAverage = students.stream()
                    .mapToDouble(Student::getAverage)
                    .average()
                    .orElse(0.0);
            
            fw.write("\nClass Average: " + String.format("%.2f%%\n", classAverage));
            fw.write("Total Students: " + students.size() + "\n");
            fw.write("=".repeat(70) + "\n");
            
            System.out.println("Report cards written successfully to '" + outputFileName + "'");
            if (append) {
                System.out.println("Results appended (not overwritten).");
            }
        } catch (IOException e) {
            System.err.println("Error writing report cards: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        // Create sample input file for testing
        createSampleInputFile("students_input.txt");
        List<Student> students = readStudentMarks("students_input.txt");
        
        if (!students.isEmpty()) {
            // Write report cards (first time - overwrite)
            writeReportCards(students, "report_cards.txt", false);
            
            // Append new results (if adding more students)
            List<Student> newStudents = new ArrayList<>();
            newStudents.add(new Student("David", new int[]{92, 88, 95}));
            writeReportCards(newStudents, "report_cards.txt", true);
        }
    }
    
    // Helper method to create a sample input file
    private static void createSampleInputFile(String fileName) {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write("Alice,85,90,88\n");
            fw.write("Bob,78,82,80\n");
            fw.write("Charlie,92,95,90\n");
            fw.write("Emma,88,91,89\n");
            System.out.println("Sample input file created: " + fileName);
        } catch (IOException e) {
            System.err.println("Error creating sample file: " + e.getMessage());
        }
    }
}

class Student {
    private String name;
    private int[] marks;
    
    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }
    
    public String getName() {
        return name;
    }
    
    public int[] getMarks() {
        return marks;
    }
    
    public double getAverage() {
        if (marks.length == 0) return 0;
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }
    
    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        if (avg >= 80) return "B";
        if (avg >= 70) return "C";
        if (avg >= 60) return "D";
        return "F";
    }
}
