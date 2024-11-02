import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;

public class Copy {
	public static void exeCmd(String commandStr) {
		BufferedReader br = null;
		try {
			Process p = Runtime.getRuntime().exec(commandStr);
			br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			if (br != null)
			{
				try {
					br.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		String commandStr = "cp -r /data/user/0/com.aide.ui/no_backup/ndksupport-1710240003/android-ndk-aide/sources /storage/emulated/0/AppProjects/";
		//String commandStr = "ipconfig";
		Copy.exeCmd(commandStr);
		System.out.println("cmd ok");
	}
}
