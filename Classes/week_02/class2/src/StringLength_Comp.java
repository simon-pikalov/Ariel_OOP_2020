import java.util.Comparator;

public class StringLength_Comp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int ans = 0;
        if(o1!=null | o2!=null) {
            if(o1==null) {return -1;}
            if(o2==null) {return 1;}

            int l1 = o1.length();
            int l2 = o2.length();
            ans = l1 - l2;
            if(ans ==0) {
                ans = o1.compareTo(o2);
            }
        }
        return ans;
    }
}
