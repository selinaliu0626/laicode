//https://app.laicode.io/app/problem/292?plan=3
//time: O(N)
//space:O(n);
public class AbbreviationMatching {
    public boolean match(String input, String pattern){
        return match(input, pattern,0,0);
    }

    private boolean match(String s, String t, int si, int ti ) {
        //when we run out these two string at the same time, there is a match
        if(si ==s.length() && ti ==t.length()){
            return true;
        }
        //if we run out of one of the string, but another one still have left, then they are not match
        if(si>=s.length() ||ti>=t.length()){
            return false;
        }
        //case 1, if the current character in t is not a digit
        if(t.charAt(ti)<'0' ||t.charAt(ti)>'9'){
            // if at this position is equal, let us continue see other following positions
            if(s.charAt(si) == t.charAt(ti)){
                return match(s,t,si+1,ti+1);
            }
            // if it is not equal,return false
            return false;
        }
        //case 2, if current position is digit
        int count = 0;
        //we could have consecutive numbers here, so we use while loop to check if
        // mutiple digits here, for exmeple"123"means a decimal number 123
        //ti must in bound, for example, string t is only a number
        while(ti< t.length() && t.charAt(ti) >='0' && t.charAt(ti) <='9'){
            count = count*10+ (t.charAt(ti)-'0');
            ti++;
        }
        // now si is in the position of si+count
        return match(s,t,si+count,ti);
    }

    public static void main(String[] args) {
        String s ="internationalization";
        String t ="i18n";
        AbbreviationMatching am = new AbbreviationMatching();
       boolean a = am.match(s,t);
       System.out.println(a);

    }
}
