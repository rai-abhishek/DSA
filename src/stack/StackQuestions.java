package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.Stack;

public class StackQuestions {
    public static boolean validSeqOfParanthesis(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (str.isEmpty()) {
                    return false;
                } else if (ch == ')' && st.peek() != '(') {
                    return false;
                } else if (ch == '}' && st.peek() != '{') {
                    return false;
                } else if (ch == ']' && st.peek() != '[') {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }

    //nsl - nearest smallest number on LHS
    public static int[] nsl(int[] ar) {
        int n = ar.length;
        int[] nsl = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n;i++) {
            // pop all greater element
            while(st.size() > 0 && ar[st.peek()] >= ar[i]) {
                st.pop();
            }
            //update answer
            if(st.size() == 0 ) {
                nsl[i] = -1;
            }
            else {
                nsl[i] = st.peek();
            }
            // push current index in stack
            st.push(i);
        }
        return nsl;
    }

    //nsl - nearest smallest number on LHS
    public static int[] nsr(int[] ar) {
        int n = ar.length;
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i < 0;i--) {
            // pop all greater element
            while(st.size() > 0 && ar[st.peek()] >= ar[i]) {
                st.pop();
            }
            //update answer
            if(st.size() == 0 ) {
                nsr[i] = -1;
            }
            else {
                nsr[i] = st.peek();
            }
            // push current index in stack
            st.push(i);
        }
        return nsr;
    }

    //in a string, remove equal pair of consecutive elements till possible
    public static String removeEqualPairs(String ss) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < ss.length(); i++) {
            if(st.size() == 0 || ss.charAt(i) != st.peek()) {
                st.push(ss.charAt(i));
            } else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(st.size() != 0) {
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }

    public static int largestAreaRectangle(int[] ar) {
        int n = ar.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n;i++) {
            while(st.size() > 0 && ar[st.peek()] >= ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st = new Stack<>();
        for(int i = n - 1; i >= 0;i--) {
            while(st.size() > 0 && ar[st.peek()] >= ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }
        int ans = 0;
        for(int i = 0; i < n;i++) {
            ans = Math.max(ans, ar[i] * (nsr[i] - nsl[i] - 1));
        }
        return ans;
    }

    //sum of max - min for all subarrays
    public  static int maxMinusMinSubarrays(int[] ar) {
        int n = ar.length;
        int[] nsl = new int[n];
        int[] nsr = new int[n];
        int[] ngr = new int[n];
        int[] ngl = new int[n];

        //nsl
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n;i++) {
            while(st.size() > 0 && ar[st.peek()] >= ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        //nsr
        st = new Stack<>();
        for(int i = n - 1; i >= 0;i--) {
            while(st.size() > 0 && ar[st.peek()] >= ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                nsr[i] = -1;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        //ngl
        st = new Stack<>();
        for(int i = 0; i < n;i++) {
            while(st.size() > 0 && ar[st.peek()] < ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                ngl[i] = -1;
            } else {
                ngl[i] = st.peek();
            }
            st.push(i);
        }

        //ngr
        st = new Stack<>();
        for(int i = n - 1; i >= 0;i--) {
            while(st.size() > 0 && ar[st.peek()] < ar[i]){
                st.pop();
            }
            if(st.size() == 0) {
                ngr[i] = -1;
            } else {
                ngr[i] = st.peek();
            }
            st.push(i);
        }

        long ans = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n;i++) {
            long maxContri = (long)ar[i] * (i - ngl[i]) * (ngr[i] - 1);
            long minContri = (long)ar[i] * (i - nsl[i]) * (nsr[i] - 1);
            ans = (ans * (maxContri - minContri)) % mod;
        }
        return (int) ans;
    }

    public static void print(int[] a) {
        for(int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public  static int maxMinusMinSubarraysARLIST(ArrayList<Integer> A) {
        // nsl, nsr,ngr,ngl
        // max conrib = ar[i] * (i - ngl(i)) * (ngr[i] - 1))
        //min contib =  ar[i] * (i - nsl(i)) * (nsr[i] - 1))
        // ans = ans + max contri - min contri) % mod;
        int n = A.size();

        int[] nsl = new int[n];
        int[] nsr = new int[n];

        Stack<Integer> st = new Stack<>();

        //nsl
        for(int i = 0; i < n; i++) {
            // pop update ans push index
            while(st.size() > 0 && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        //nsr
        for(int i = n - 1; i >= 0; i--) {
            // pop update ans push index
            while(st.size() > 0 && A.get(st.peek()) >= A.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        int[] ngl = new int[n];
        int[] ngr = new int[n];

        st.clear();

        //ngl
        for(int i = 0; i < n; i++) {
            // pop update ans push index
            while(st.size() > 0 && A.get(st.peek()) < A.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                ngl[i] = -1;
            } else {
                ngl[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();
        //ngr
        for(int i = n - 1; i >= 0; i--) {
            // pop update ans push index
            while(st.size() > 0 && A.get(st.peek()) < A.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                ngr[i] = n;
            } else {
                ngr[i] = st.peek();
            }
            st.push(i);
        }

        print(nsl);
        print(nsr);
        print(ngl);
        print(ngr);

        long ans = 0;
        int mod = (int)1e9 + 7;
        for(int i = 0; i < n;i++) {
            long maxContri = (long) A.get(i) * (i - ngl[i]) * (ngr[i] - 1);
            long minContri = (long) A.get(i) * (i - nsl[i]) * (nsr[i] - 1);
            System.out.println("maxContri_minContri_ans " + maxContri + "_" + minContri + "_" + ans);
//            System.out.println(minContri);
            ans = (ans * (maxContri - minContri));
        }
        return (int) ans;
    }

    public static void main(String[] args) {
//        String a = "{}[]((";
//        System.out.println(validSeqOfParanthesis(a));
//
//        System.out.println("------ NSL & NSR------");
//        int[] b = {5,4,2,7,6,9,15,3};
//        int[] nsl = nsl(b);
//        for(int c : nsl) {
//            System.out.print(c + " ");
//        }
//        System.out.println();
//
//        int[] nsr = nsl(b);
//        for(int c : nsr) {
//            System.out.print(c + " ");
//        }
//        System.out.println();
//
//        System.out.println("------ equal pairs ------");
//        String s1 = "abbcbbcacx";
//        String e = removeEqualPairs(s1);
//        System.out.println(e);
//        int[] f = {47,69,67,97,86,34,98,16,65,95,66,69,18,1,99,56,35,9,48,72,49,47,1,72,87,52,13,23,95,55,21,92,36,88,48,39,84,16,15,65,7,58,2,21,54,2,71,92,96,100,28,31,24,10,94,5,81,80,43,35,67,33,39,81,69,12,66,87,86,11,49,94,38,44,72,44,18,97,23,11,30,72,51,61,56,41,30,71,12,44,81,43,43,27};
//        System.out.println(largestAreaRectangle(f));
//        int[] fa = {1,8,3,5,4,2,11,7,2};
//        System.out.println(maxMinusMinSubarrays(fa));
        ArrayList<Integer> aa = new ArrayList<>();
        Integer[] a5 = {992387,932142,971117,934674,988917,967890,948508,970347};
        aa.addAll(Arrays.asList(a5));

        System.out.println(maxMinusMinSubarraysARLIST(aa));
    }
}
