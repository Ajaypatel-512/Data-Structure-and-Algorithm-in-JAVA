package Extra;

import java.util.*;

public class Find2ndHeightestNumberInAnArray {
    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondHighest = find2ndHighest(arr);
        System.out.println("The second highest number in the array is: " + secondHighest);
    }

    // Method 1: Using a single loop
    //Time Complexity: O(n)
    //Space Complexity: O(1)
    public static int find2ndHighest(int[] arr) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > highest) {
                secondHighest = highest;
                highest = num;
            } else if (num > secondHighest && num != highest) {
                secondHighest = num;
            }
        }

        return secondHighest;
    }

    // Method 2: Using sorting
    //Time Complexity: O(n log n)
    //Space Complexity: O(1)
    public static int find2ndHighestUsingSorting(int[] arr) {
        Arrays.sort(arr);
        return arr[arr.length - 2];
    }

    // Method 3: Using a Set to remove duplicates
    //Time Complexity: O(n log n)
    //Space Complexity: O(n)
    public static int find2ndHighestUsingSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(list.size() - 2);
    }

    // Method 4: Using Java 8 Streams
    //Time Complexity: O(n log n)
    //Space Complexity: O(n)
    public static int find2ndHighestUsingStream(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .sorted()
                .skip(arr.length - 2)
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    // Method 5: Using PriorityQueue
    //Time Complexity: O(n log k)
    //Space Complexity: O(k)
    public static int find2ndHighestUsingPriorityQueue(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : arr) {
            pq.offer(num);
        }
        pq.poll(); // Remove the highest
        return pq.poll(); // Return the second highest
    }

    // Method 6: Using a TreeSet
    //Time Complexity: O(n log n)
    //Space Complexity: O(n)
    public static int find2ndHighestUsingTreeSet(int[] arr) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : arr) {
            set.add(num);
        }
        if (set.size() < 2) {
            throw new NoSuchElementException("No second highest element found");
        }
        return set.lower(set.last());
    }

    //Method 7 : Using a HashMap
    //Time complexity: O(n)
    //Space complexity: O(n)
    public static void find2ndHeightestUsingHashMap(){
        int[] arr = {12, 35, 1, 10, 34, 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        if (keys.size() < 2) {
            throw new NoSuchElementException("No second highest element found");
        }
        System.out.println("The second highest number in the array is: " + keys.get(keys.size() - 2));
    }


}
