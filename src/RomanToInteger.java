public class RomanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));

    }

    static public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i == s.length() - 1) {
                    num += 1;
                } else if (s.charAt(i + 1) == 'V') {
                    i++;
                    num += 4;
                } else if (s.charAt(i + 1) == 'X') {
                    i++;
                    num += 9;
                } else {
                    num += 1;
                }
            } else if (s.charAt(i) == 'V') {
                num += 5;
            } else if (s.charAt(i) == 'X') {
                if (i == s.length() - 1) {
                    num += 10;
                } else if (s.charAt(i + 1) == 'L') {
                    i++;
                    num += 40;
                } else if (s.charAt(i + 1) == 'C') {
                    i++;
                    num += 90;
                } else {
                    num += 10;
                }
            }else if(s.charAt(i) == 'L') {
                num+=50;
            }else if(s.charAt(i) == 'C') {
                if (i == s.length() - 1) {
                    num += 100;
                } else if (s.charAt(i + 1) == 'D') {
                    i++;
                    num += 400;
                } else if (s.charAt(i + 1) == 'M') {
                    i++;
                    num += 900;
                } else {
                    num += 100;
                }
            }else if(s.charAt(i) == 'D') {
                num+= 500;
            }else if(s.charAt(i) == 'M') {
                num+= 1000;
            }
        }

        return num;
    }
}
