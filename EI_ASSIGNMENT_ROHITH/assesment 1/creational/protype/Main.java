public class Main {
    
    interface Clonable {
        Clonable duplicate();
    }

    
    static class Person implements Clonable {
        private String fullName;
        private String emailAddress;

        
        public Person(String fullName, String emailAddress) {
            this.fullName = fullName;
            this.emailAddress = emailAddress;
        }

        
        public Clonable duplicate() {
            return new Person(fullName, emailAddress);
        }

        
        public String toString() {
            return "Person Info: {" +
                    "Name='" + fullName + '\'' +
                    ", Email='" + emailAddress + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        
        Person initialUser = new Person("sathwik", "sathwik420@gmail.com");
        
        
        Person copiedUser = (Person) initialUser.duplicate();

        
        System.out.println("Original User: " + initialUser);
        System.out.println("Cloned User: " + copiedUser);
    }
}
