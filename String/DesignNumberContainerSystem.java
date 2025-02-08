package String;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DesignNumberContainerSystem {
    public static void main(String[] args) {
    }

    //Approach-1 (Using two maps : map of int, int and map of int, set)
    // Time Complexity : O(log(n))
    // Space Complexity : O(n)
    static class NumberContainers {
        private Map<Integer, Integer> idxToNum;
        private Map<Integer, TreeSet<Integer>> numToIdx;

        public NumberContainers() {
            idxToNum = new HashMap<>();
            numToIdx = new HashMap<>();
        }

        public void change(int index, int number) {
            if (idxToNum.containsKey(index)) { // O(1)
                int prevNum = idxToNum.get(index);
                numToIdx.get(prevNum).remove(index); // O(log(n))
                if (numToIdx.get(prevNum).isEmpty()) {
                    numToIdx.remove(prevNum); // O(1)
                }
            }

            idxToNum.put(index, number);
            numToIdx.putIfAbsent(number, new TreeSet<>());
            numToIdx.get(number).add(index); // O(log(n))
        }

        public int find(int number) {
            if (numToIdx.containsKey(number)) { // O(1)
                return numToIdx.get(number).first(); // O(1)
            }
            return -1;
        }
    }

    //Approach-2 (Using two maps : map of int, int and map of int, min-heap)
    // Time Complexity : O(log(n) + k*logn)
    // Space Complexity : O(n)
//    static class NumberContainers {
//        // Space : O(n)
//        private Map<Integer, Integer> idxToNum;
//        private Map<Integer, PriorityQueue<Integer>> numToIdx;
//
//        public NumberContainers() {
//            idxToNum = new HashMap<>();
//            numToIdx = new HashMap<>();
//        }
//
//        public void change(int index, int number) {
//            idxToNum.put(index, number); // O(1)
//            numToIdx.putIfAbsent(number, new PriorityQueue<>());
//            numToIdx.get(number).offer(index); // O(log(n))
//        }
//
//        public int find(int number) {
//            if (!numToIdx.containsKey(number)) {
//                return -1;
//            }
//
//            PriorityQueue<Integer> pq = numToIdx.get(number);
//
//            while (!pq.isEmpty()) { // O(k * logn)
//                int idx = pq.peek(); // O(1)
//                if (idxToNum.get(idx) == number) {
//                    return idx;
//                }
//                pq.poll(); // O(log(n))
//            }
//            return -1;
//        }
//    }
}
