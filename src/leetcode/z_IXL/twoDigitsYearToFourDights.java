package leetcode.z_IXL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by qifu on 17/4/21.
 */
public class twoDigitsYearToFourDights {
    public String cover(String year) throws Exception{
        DateFormat two_ = new SimpleDateFormat("yy");
        Date now = two_.parse(year);
        DateFormat four_ = new SimpleDateFormat("yyyy");
        String after = four_.format(now);
        return after;
    }
}
