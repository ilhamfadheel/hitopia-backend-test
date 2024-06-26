package org.ilhamfadheel;

import java.util.*;

public class WeightedStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = scanner.nextLine();

        System.out.println("Enter the queries as a comma-separated list inside brackets (e.g., [1, 2, 3, 4]):");
        String queryInput = scanner.nextLine();

//         Remove the brackets and convert to List of Integers
        queryInput = queryInput.substring(1, queryInput.length() - 1);
        String[] queryStrings = queryInput.split(",\\s*");
        List<Integer> queries = new ArrayList<>();
        for (String queryString : queryStrings) {
            queries.add(Integer.parseInt(queryString));
        }

//         Call the function
        List<String> result = weightedStrings(s, queries);
        System.out.println(result);
    }

    public static List<String> weightedStrings(String s, List<Integer> queries) {
        Map<Integer, Boolean> weights = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; ) {
            int charWeight = s.charAt(i) - 'a' + 1;
            int j = i;

            while (j < n && s.charAt(i) == s.charAt(j)) {
                int length = j - i + 1;
                weights.put(charWeight * length, true);
                j++;
            }
            i = j;
        }

//        Return Output as a List of Yes or No
        List<String> result = new ArrayList<>();
        for (int query : queries) {
            result.add(weights.containsKey(query) ? "Yes" : "No");
        }

        return result;
    }
}