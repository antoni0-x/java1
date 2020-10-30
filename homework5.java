package javaVvod.lesson5;

public class homework5 {
    public static void main(String[] args) {
        Person[] perArr = new Person[5];
        perArr[0] = new Person("Иван", "Иванович", "Иванов", "Директор", "dir@mail.ru", "123456789", 100000, 50);
        perArr[1] = new Person("Петр", "Петрович", "Петров", "Заместитель Директора", "zam@mail.ru", "234567890", 90000, 45);
        perArr[2] = new Person("Алексей", "Алексеевич", "Алексеев", "Главный бухгалтер", "buh@mail.ru", "345678901", 80000, 40);
        perArr[3] = new Person("Игорь", "Игоревич", "Игорев", "Начальник отдела", "otdel@mail.ru", "3456789012", 70000, 35);
        perArr[4] = new Person("Юрий", "Юрьевич", "Юрьев", "Инженер", "ing@mail.ru", "4567890123", 60000, 46);

        for (int i = 0; i < perArr.length; i++) {
            if (perArr[i].age(45)) {
                perArr[i].toConsol();
            }
        }


    }

}

