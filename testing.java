package MathGame;

import java.io.File;
import java.io.IOException;

public class testing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Runtime.getRuntime().exec(System.getProperty("user.home")+File.separator+"Desktop"+File.separator+"run.bat");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
