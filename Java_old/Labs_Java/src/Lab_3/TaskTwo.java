package Lab_3;

import java.util.*;

public class TaskTwo {

    public static class Contact {
        String name;
        String gmail;
        String extra;

        public Contact(String name, String gmail, String extra) {
            this.name = name;
            this.gmail = gmail;
            this.extra = extra;
        }

        @Override
        public String toString() {
            return "Contact{name='" + name + "', gmail='" + gmail + "', extra='" + extra + "'}";
        }
    }

    public static void insertContact(HashMap<String, Contact> hm, String phone, Contact contact) {
        hm.put(phone, contact);
        System.out.println("Контакт добавлен: " + phone + " : " + contact);
    }
    public static Contact findContact(HashMap<String, Contact> hm, String phone) {
        if (hm.containsKey(phone)) {
            return hm.get(phone);
        } else {
            System.out.println("Контакт с номером " + phone + " не найден.");
            return null;
        }
    }
    public static void removeContact(HashMap<String, Contact> hm, String phone) {
        if (hm.containsKey(phone)) {
            hm.remove(phone);
            System.out.println("Контакт с номером " + phone + " удалён.");
        } else {
            System.out.println("Невозможно удалить — контакт с номером " + phone + " не найден.");
        }
    }
    public static void main(String[] args){
        HashMap<String, Contact> phoneBook = new HashMap<>();

        insertContact(phoneBook, "+1-202-555-0147", new Contact("Alice", "alice@gmail.com", "коллега"));
        insertContact(phoneBook, "+1-202-555-0148", new Contact("Bob", "bob@mail.com", "друг детства"));
        insertContact(phoneBook, "+1-202-555-0149", new Contact("Charlie", "charlie@yahoo.com", "партнёр по проекту"));

        System.out.println("Все контакты:");
        for (String phone : phoneBook.keySet()) {
            System.out.println(phone + " : " + phoneBook.get(phone));
        }

        System.out.println("Поиск контакта:");
        Contact c = findContact(phoneBook, "+1-202-555-0148");
        if (c != null) System.out.println("Найден: " + c);

        System.out.println("Удаление контакта:");
        removeContact(phoneBook, "+1-202-555-0147");

        System.out.println("После удаления:");
        for (String phone : phoneBook.keySet()) {
            System.out.println(phone + " : " + phoneBook.get(phone));
        }
    }
}



