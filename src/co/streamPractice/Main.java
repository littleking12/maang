package co.streamPractice;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Student student1 = new Student("Jayesh", 20, new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));

        Student student2 = new Student("Khyati", 20, new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));

        Student student3 = new Student("Jason", 20, new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));

        List<Student> students = Arrays.asList(student1, student2, student3);
        List<String> linkedAccounts = Arrays.asList("asdf", "wefgb", "sdf");

//        List<LinkedAccount> linkedAccounts2 = Optional.ofNullable(linkedAccounts).orElse(Collections.emptyList())
//                .stream().map((s -> {}));


        /*****************************************************
         Get student with exact match name "jayesh"
         *****************************************************/

        Optional<Student> stud = students.stream().filter((a) -> a.getName().equalsIgnoreCase("Jayesh")).findFirst();

        System.out.println(stud.isPresent() ? stud.get().getName() : "not found");

        /*****************************************************
         Get student with matching address "1235"
         *****************************************************/
        Optional<Student> student = students.stream().filter((s) -> s.getAddress().getZipcode().equals("1235"))
                .findAny();
        System.out.println(student.isPresent() ? student.get() : "not found");

        /*****************************************************
         Get all student having mobile numbers 3333.
         *****************************************************/
        System.out.println("---------");
        List<Student> studentsWith3333 = students.stream()
                .filter((s) -> s.getMobileNumbers().stream().anyMatch((m) -> m.getNumber().equals("3333")))
                .collect(Collectors.toList());
        String result = studentsWith3333.stream().map(Student::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(result);
        System.out.println("--------------------");

        /*****************************************************
         Get all student having mobile number 1233 and 1234
         *****************************************************/
        List<Student> studentsWith1233n1234 = students.stream().filter((s) -> s.getMobileNumbers().stream()
                .anyMatch((m) -> m.getNumber().equals("1233") || m.getNumber().equals("1234")))
                .collect(Collectors.toList());

        /*****************************************************
         Create a List<Student> from the List<TempStudent>
         *****************************************************/
        TempStudent tmpStud1 = new TempStudent("Jayesh1", 201, new Address("12341"),
                Arrays.asList(new MobileNumber("12331"), new MobileNumber("12341")));

        TempStudent tmpStud2 = new TempStudent("Khyati1", 202, new Address("12351"),
                Arrays.asList(new MobileNumber("11111"), new MobileNumber("33331"), new MobileNumber("12331")));

        List<TempStudent> tmpStudents = Arrays.asList(tmpStud1, tmpStud2);
        // List<Student> studentList = tmpStudents.stream().map((ts) -> new Student()).collect(Collectors.toList());

        /*****************************************************
         Conditionally apply Filter condition, say if flag is enabled then sort
         *****************************************************/

        boolean flag = false;

        Stream<Student> ss = students.stream().filter((a) -> a.getName().startsWith("J"));
        if (flag) {
            ss.sorted(Comparator.comparing(Student::getName)).forEach(System.out::println);
        }
        //List<Student> finalre = ss.collect(Collectors.toList());
        else
            ss.forEach(System.out::println);

    }
}
/*


mapToInt
filter


-----terminal
count
sum
min
max
forEach
allMatch()
collect()
anyMatch()
noneMatch()
reduce()

 */