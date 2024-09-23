import java.util.*;

public class ClassroomManager {

    private static Classroom[] classrooms = new Classroom[100]; 
    private static int numClassrooms = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] command = input.split(" ", 2);

            try {
                switch (command[0]) {
                    case "add_classroom":
                        addClassroom(command[1]);
                        break;
                    case "remove_classroom":
                        removeClassroom(command[1]);
                        break;
                    case "add_student":
                        addStudent(command[1]);
                        break;
                    case "schedule_assignment":
                        scheduleAssignment(command[1]);
                        break;
                    case "submit_assignment":
                        submitAssignment(command[1]);
                        break;
                    case "list_classrooms":
                        listClassrooms();
                        break;
                    case "list_students":
                        listStudents(command[1]);
                        break;
                    case "exit":
                        System.out.println("Exiting!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Unknown command.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addClassroom(String name) {
        if (findClassroom(name) != null) {
            System.out.println("Classroom already exists.");
        } else {
            if (numClassrooms >= classrooms.length) {
                System.out.println("No more space for new classrooms.");
                return;
            }
            classrooms[numClassrooms++] = new Classroom(name);
            System.out.println("Classroom " + name + " has been created.");
        }
    }

    private static void removeClassroom(String name) {
        Classroom classroom = findClassroom(name);
        if (classroom != null) {
            for (int i = 0; i < numClassrooms; i++) {
                if (classrooms[i].getName().equals(name)) {
                    classrooms[i] = classrooms[numClassrooms - 1];
                    classrooms[numClassrooms - 1] = null;
                    numClassrooms--;
                    System.out.println("Classroom " + name + " has been removed.");
                    return;
                }
            }
        } else {
            System.out.println("Classroom does not exist.");
        }
    }

    private static Classroom findClassroom(String name) {
        for (int i = 0; i < numClassrooms; i++) {
            if (classrooms[i].getName().equals(name)) {
                return classrooms[i];
            }
        }
        return null;
    }

    private static void addStudent(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length != 2) throw new IllegalArgumentException("Usage: add_student [student_id] [class_name]");
        String studentId = parts[0];
        String className = parts[1];
        
        Classroom classroom = findClassroom(className);
        if (classroom == null) {
            System.out.println("Classroom does not exist.");
        } else {
            classroom.addStudent(studentId);
            System.out.println("Student " + studentId + " has been enrolled in " + className + ".");
        }
    }

    private static void scheduleAssignment(String input) {
        String[] parts = input.split(" ", 2);
        if (parts.length != 2) throw new IllegalArgumentException("Usage: schedule_assignment [class_name] [assignment_details]");
        String className = parts[0];
        String assignmentDetails = parts[1];
        
        Classroom classroom = findClassroom(className);
        if (classroom == null) {
            System.out.println("Classroom does not exist.");
        } else {
            classroom.scheduleAssignment(assignmentDetails);
            System.out.println("Assignment for " + className + " has been scheduled.");
        }
    }

    private static void submitAssignment(String input) {
        String[] parts = input.split(" ", 3);
        if (parts.length != 3) throw new IllegalArgumentException("Usage: submit_assignment [student_id] [class_name] [assignment_details]");
        String studentId = parts[0];
        String className = parts[1];
        String assignmentDetails = parts[2];
        
        Classroom classroom = findClassroom(className);
        if (classroom == null) {
            System.out.println("Classroom does not exist.");
        } else {
            classroom.submitAssignment(studentId, assignmentDetails);
            System.out.println("Assignment submitted by Student " + studentId + " in " + className + ".");
        }
    }

    private static void listClassrooms() {
        if (numClassrooms == 0) {
            System.out.println("No classrooms available.");
        } else {
            for (int i = 0; i < numClassrooms; i++) {
                System.out.println(classrooms[i].getName());
            }
        }
    }

    private static void listStudents(String className) {
        Classroom classroom = findClassroom(className);
        if (classroom == null) {
            System.out.println("Classroom does not exist.");
        } else {
            classroom.listStudents();
        }
    }
}

class Classroom {
    private final String name;
    private final Set<String> students = new HashSet<>();
    private final List<String> assignments = new ArrayList<>();

    public Classroom(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStudent(String studentId) {
        students.add(studentId);
    }

    public void scheduleAssignment(String assignmentDetails) {
        assignments.add(assignmentDetails);
    }

    public void submitAssignment(String studentId, String assignmentDetails) {
        
    }

    public void listStudents() {
        if (students.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (String student : students) {
                System.out.println(student);
            }
        }
    }
}