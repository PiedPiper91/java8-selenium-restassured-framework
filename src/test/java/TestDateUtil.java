import constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.DateUtil;

public class TestDateUtil {

    @Test
    void testDateNotNull(){
        String currentDateTime = DateUtil.getCurrentDateTime();
        Assert.assertNotNull(currentDateTime);
    }
    @Test
    void testDateNotEmpty(){
        String currentDateTime = DateUtil.getCurrentDateTime();
        Assert.assertFalse(currentDateTime.isEmpty());
    }
    @Test
    void testDateMatchesFormat(){
        String currentDateTime = DateUtil.getCurrentDateTime();
        Assert.assertTrue(currentDateTime.matches(FrameworkConstants.DATE_TIME_FORMAT));
    }


}
