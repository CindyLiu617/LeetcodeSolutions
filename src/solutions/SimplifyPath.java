package solutions;

/**
 * Created by James on 5/26/16.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null || path.charAt(0) != '/')
            return null;
        String[] splits = path.split("/");
        int wtr = 0;
        for (String split : splits) {
            if (!split.isEmpty() && split.equals("..") && wtr > 0)
                --wtr;
            else if (!split.isEmpty() && !split.equals(".") && !split.equals("..")) {
                splits[wtr] = split;
                ++wtr;
            }
        }
        if (wtr == 0)
            return "/";
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<wtr; ++i) {
            sb.append("/" + splits[i]);
        }
        return sb.toString();
    }
    static public class Test {
        static private SimplifyPath _solution = new SimplifyPath();


        static public void randomTest() {
            String path1 = "/a/./b/../../c/";
            String rst1 = _solution.simplifyPath(path1);
            System.out.println(rst1);

            String path2 = "/../c/";
            String rst2 = _solution.simplifyPath(path2);
            System.out.println(rst2);

            String path3 = "/c/";
            String rst3 = _solution.simplifyPath(path3);
            System.out.println(rst3);

            String path4 = "/../";
            String rst4 = _solution.simplifyPath(path4);
            System.out.println(rst4);
        }
    }
}
