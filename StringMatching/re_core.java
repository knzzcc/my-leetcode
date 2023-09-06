String s = "9876";

int r = 0;
for(int i = 0; i < s.length(); i++){
    r = r * 10 + s.charAt(i) - 'a';    
}
// r = 9876;

// Remove the most sigificant bit
// 9876 -> 876
// 9876 - 9 * 10 ^3 = 876
r = r - (s.charAt(0) - '0') * (int) Math.pow(10, s.length() - 1);
