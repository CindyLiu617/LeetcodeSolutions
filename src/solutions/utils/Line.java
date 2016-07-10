package solutions.utils;

/**
 * Created by James on 6/30/16.
 */
public class Line {
    double slope;
    double intercept;
    Line (Point A, Point B){
        if (A.x == B.x){
            slope = (double) Integer.MAX_VALUE;
            intercept = A.x;
            return;
        }
        slope = ((double)A.y-(double)B.y)/((double)A.x-(double)B.x);
        intercept = (double)A.y - slope * (double)A.x;
    }
}
