import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1.Создание множества
        Set<String> words = new HashSet<>();
        words.add("Java");
        words.add("Python");
        words.add("C++");
        words.add("Kotlin");
        words.add("Go");

        System.out.println("Множество:");
        for (String word : words) {
            System.out.println(word);
        }

        // 2. Проверка на наличие элемента
        boolean hasJava = false;
        for (String s : words) {
            if (s != null && s.trim().equalsIgnoreCase("java")) {
                hasJava = true;
                break;
            }
        }
        System.out.println("\nСодержит 'java': " + hasJava);

        // 3. Удаление элемента
        boolean removed = words.removeIf(s -> s != null && s.trim().equalsIgnoreCase("python"));
        System.out.println("Удалено 'python': " + removed);

        System.out.println("После удаления:");
        for (String word : words) {
            System.out.println(word);
        }

        // 4. Подсчёт уникальных
        List<String> list = Arrays.asList("Java", "java", "Python", "C++", "Python", "GO");
        Set<String> unique = new HashSet<>();
        for (String s : list) {
            if (s != null) { unique.add(s.trim().toLowerCase());
        }
    }
        System.out.println("\nУникальных слов: " + unique.size());

        // HashMap
        // 1. Создание и вывод Map
        Map<String, Integer> grades = new HashMap<>();
        grades.put("Math", 4);
        grades.put("English", 3);
        grades.put("Physics", 5);
        grades.put("History", 4);

        System.out.println("\nОценки:");
        for (Map.Entry<String, Integer> e : grades.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }

        // 2. Получение значения по ключу
        System.out.println("\nОценка по Math: " + grades.get("Math"));

        // 3. Изменение значения
        if (grades.containsKey("English")) {
            grades.put("English", 5);
        }

        System.out.println("Новая оценка по English: " + grades.get("English"));

        // 4. Проверка наличия ключа
        System.out.println("Есть ли 'History': " + grades.containsKey("History"));

        // 5. Удаление ключа
        grades.remove("Physics");
        System.out.println("После удаления Physics:");
        for (Map.Entry<String, Integer> e : grades.entrySet()) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    // 1.Анаграммы
    public static boolean areAnagrams(String a, String b) {
        if (a == null || b == null || a.length() != b.length()) return false;
        Map<Character, Integer> count = new HashMap<>();
        for (char c : a.toCharArray()) count.put(c, count.getOrDefault(c, 0) + 1);
        for (char c : b.toCharArray()) {
            if (!count.containsKey(c)) return false;
            count.put(c, count.get(c) - 1);
            if (count.get(c) == 0) count.remove(c);
        }
        return count.isEmpty();
    }

    // 2.Поиск дубликатов с помощью Set
    public static boolean hasDuplicates(List<Integer> list) {
        Set<Integer> seen = new HashSet<>();
        for (Integer n : list) {
            if (!seen.add(n)) return true;
        }
        return false;
    }

    // 3.Рейтинг студентов
    public static String bestStudent(Map<String, Integer> scores) {
        String best = null;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, Integer> e : scores.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                best = e.getKey();
            }
        }
        return best;
    }

    // 4. Словарь синонимов
    public static void addSynonym(Map<String, Set<String>> dict, String word, String synonym) {
        if (dict == null || word == null || synonym == null) return;
        dict.computeIfAbsent(word.trim(), k -> new HashSet<>()).add(synonym.trim());
    }
}
