class Solution {
   
    public String reverseVowels(String s) {
    Set<Character> vowels = new HashSet<>(
        Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        
        int left = 0;
        int right = s.length()-1;
        char[] stArr = s.toCharArray();
        while(left < right){
            if(!vowels.contains(stArr[left])){
                left++;
            }
            else if(!vowels.contains(stArr[right])){
                right--;
            }
            else{
                char tmp = stArr[left];
                stArr[left++] = stArr[right];
                stArr[right--] = tmp;
            }
        }
        return new String(stArr);

    }
    

}