class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        int[] alphabet = new int[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            int charIdx = (int) s.charAt(i);
            
            if(alphabet[charIdx - 97] != -1) {
                answer[i] = i - alphabet[charIdx - 97];
            } else {
                answer[i] = -1;
            }
            
            alphabet[charIdx - 97] = i;
        }
        
        return answer;
    }
}