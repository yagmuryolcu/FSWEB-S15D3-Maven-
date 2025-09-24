package org.example;

import org.example.entity.Employee;

import java.util.*;

import static org.example.WordCounter.calculatedWord;

public class Main {

    public static void main(String[] args) {

        String text = "When the offensive resumed, the Turks received their first victory when the Greeks encountered stiff resistance in the battles of First and Second İnönü," +
                " due to İsmet Pasha's organization of an irregular militia into a regular army. " +
                " The two victories led to Allied proposals to amend the Treaty of Sèvres where both Ankara and Istanbul were represented, but Greece refused." +
                " With the conclusion of the Southern and Eastern fronts, Ankara was able to concentrate more forces on the West against the Greeks." +
                " They also began to receive support from Soviet Union, as well as France and Italy, who sought to check British influence in the Near East.\n" +
                " June–July 1921 saw heavy fighting in the Battle of Kütahya-Eskişehir. While it was an eventual Greek victory, the Turkish army withdrew in good order to the Sakarya river, their last line of defence." +
                " Mustafa Kemal Pasha replaced İsmet Pasha after the defeat as commander in chief as well as his political duties." +
                " The decision was made in the Greek military command to march on the nationalist capital of Ankara to force Mustafa Kemal to the negotiating table." +
                " For 21 days, the Turks and Greeks fought a pitched battle at the Sakarya river, which ended in Greek withdrawal." +
                " Almost of year of stalemate without much fighting followed, during which Greek moral and discipline faltered while Turkish strength increased." +
                " French and Italian forces evacuated from Anatolia. The Allies offered an armistice to the Turks, which Mustafa Kemal refused.";

        Map<String, Integer> result = WordCounter.calculatedWord(text);
        result.forEach((k, v) -> System.out.println(k + " : " + v));

        System.out.println("------------------------------------------------------------");

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Yağmur", "Yolcu"));
        employees.add(new Employee(2, "Pınar", "Baysal"));
        employees.add(new Employee(3, "Almina", "Şener"));
        employees.add(new Employee(3, "Almina", "Şener"));
        employees.add(new Employee(4, "Yiğit", "Çakmakcı"));
        employees.add(new Employee(5, "Büşra", "Kesgin"));
        employees.add(new Employee(5, "Büşra", "Kesgin"));
        employees.add(new Employee(6, "Mustafa", "Özcan"));

        List<Employee> tekrarlariBul = findDuplicates(employees);
        System.out.println("Tekrar edenler:");
        tekrarlariBul.forEach(System.out::println);

        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nBenzersizler:");
        uniques.values().forEach(System.out::println);

        List<Employee> removedDuplicates = removeDuplicates(employees);
        System.out.println("\nGüncel Liste :");
        removedDuplicates.forEach(System.out::println);

    }

    public static Map<Integer, Employee> findUniques(List<Employee> list) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : list) {
            if (e != null) {
                map.putIfAbsent(e.getId(), e);
            }
        }
        return map;
    }


    public static List<Employee> findDuplicates(List<Employee> list) {
        Set<Employee> seen = new HashSet<>();
        List<Employee> duplicates = new ArrayList<>();

        for (Employee e : list) {
            if (e != null && !seen.add(e)) {
                duplicates.add(e);
            }
        }

        return duplicates;

    }

    public static List<Employee> removeDuplicates(List<Employee> list) {
        Map<Employee, Integer> countMap = new HashMap<>();
        for (Employee e : list) {
            if (e != null) {
                countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            }
        }

        List<Employee> result = new ArrayList<>();
        for (Map.Entry<Employee, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
