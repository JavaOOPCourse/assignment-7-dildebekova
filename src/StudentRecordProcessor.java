import java.io.*;
import java.util.*;

public class StudentRecordProcessor {
    private final List<Student> students = new ArrayList<>();
    private double averageScore;
    private Student highestStudent;

    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("data/students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;
                try {
                    String[] parts = line.split(",");
                    if (parts.length != 2) {
                        System.out.println("Invalid data: " + line);
                        continue;
                    }
                    String name = parts[0].trim();
                    String scoreStr = parts[1].trim();
                    double score = Double.parseDouble(scoreStr);
                    if (score < 0 || score > 100) {
                        throw new InvalidScoreException("Score out of range: " + score);
                    }
                    students.add(new Student(name, score));
                } catch (NumberFormatException | InvalidScoreException e) {
                    System.out.println("Invalid data: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO error: " + e.getMessage());
        }
    }

    public void processData() {
        if (students.isEmpty()) {
            averageScore = 0;
            highestStudent = null;
            return;
        }
        double sum = 0;
        highestStudent = students.get(0);
        for (Student s : students) {
            sum += s.getScore();
            if (s.getScore() > highestStudent.getScore()) {
                highestStudent = s;
            }
        }
        averageScore = sum / students.size();
        students.sort((a, b) -> Double.compare(b.getScore(), a.getScore()));
    }

    public void writeFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("output/report.txt"))) {
            writer.printf("Average: %.1f%n", averageScore);
            if (highestStudent != null) {
                writer.printf("Highest: %s - %.0f%n", highestStudent.getName(), highestStudent.getScore());
            }
            for (Student s : students) {
                writer.printf("%s - %.0f%n", s.getName(), s.getScore());
            }
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        StudentRecordProcessor processor = new StudentRecordProcessor();
        try {
            processor.readFile();
            processor.processData();
            processor.writeFile();
            System.out.println("Processing completed. Check output/report.txt");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
}

class InvalidScoreException extends Exception {
    public InvalidScoreException(String message) {
        super(message);
    }
}

class Student {
    private final String name;
    private final double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
