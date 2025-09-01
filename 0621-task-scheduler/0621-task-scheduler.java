import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int countMax = 0;

        // Count how many tasks have frequency = maxFreq
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) countMax++;
            else break;
        }

        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int minTime = partCount * partLength + countMax;

        return Math.max(tasks.length, minTime);
    }
}
