public class Student {
    String id;
    String name;
    String program;
    double marks;

    public Student(String id, String name, String program, double marks) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Program: " + program + " | Marks: " + marks;
    }
}