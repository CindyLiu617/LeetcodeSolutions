import solutions.ContainsDuplicateIII;

/**
 * Created by James on 10/31/16.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        String [] auxArray = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = auxArray.length - 1; i >= 0; --i){
            if (!auxArray[i].equals("")){
                sb.append(auxArray[i]).append(" ");
            }
        }
        if (sb.length() != 0){
            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }
    static public class Test {
        static private ReverseWordsInAString _solution = new ReverseWordsInAString();

        static public void randomTest() {
            String s = "I hate you";
            System.out.println(_solution.reverseWords(s) + ";");
        }
    }
}
