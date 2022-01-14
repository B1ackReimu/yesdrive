public class Test2 {

    public static void main(String[] args) {
        User sb = new User(1, 2, "sb");
        int hashCode = sb.hashCode();
        System.out.println(Test.pad(hashCode));
        System.out.println(Test.pad(hashCode >>> 16));
        System.out.println(Test.pad(hashCode ^ (hashCode >>> 16)));
        int a = hashCode ^ (hashCode >>> 16);
        int i = 15 & a;
        User asd = new User(2, 3, "asd");
        sb.next = asd;
        asd = new User(3,4,"asdf");
        System.out.println(Test.pad(15));
        System.out.println(Test.pad(i));
        System.out.println(sb.next);
    }

    static class User {
        private int id;
        private int age;
        private String name;
        User next;

        public User(int id, int age, String name) {
            this.id = id;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", age=" + age +
                    ", name='" + name + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

}
