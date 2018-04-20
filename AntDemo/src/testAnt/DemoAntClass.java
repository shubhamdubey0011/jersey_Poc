package testAnt;
import org.testng.annotations.Test;
import java.util.Date;



public class DemoAntClass 
{
@Test
public static String currentDate(){					        
	return new Date().toString();					  
	}
}
