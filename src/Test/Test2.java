package Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2 {

	private String String1 = "hello";
	private char Char = 'l';
	private String afterremove = "heo";

	public String Remove(String String, char Char) {
		String s = "";
		for (int i = 0; i < String.length(); i++) {
			if (String.charAt(i) != Char)
				s += String.charAt(i) ;
		}
		return s;
	}

	public String Remove(char Char, String string) {
		String c=String.valueOf(Char);
		return string.replaceAll(c, "");
	}

	@Test(description="direct approach")
	public void StringProblem() {

		String actualresult = Remove(Char, String1);

		Assert.assertEquals(actualresult, afterremove);

	}

	@Test(description="interator")
	public void StringProblem2() {

		String actualresult = Remove(String1,Char);

		Assert.assertEquals(actualresult, afterremove);

	}


}
