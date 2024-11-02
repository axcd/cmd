import java.util.*;
import java.io.*;

public class CleanUp
{
	private static String[] fnames = new String[]
	{"/MIUI","/DCIM","/com.mao.work2","/Download","/Tencent","/Music","/QQBrowser","/Pictures","/AppProjects"};
	public static String dpath = "/storage/emulated/0";
	public static File dir = new File(dpath);
	public static void main()
	{
		System.out.println("****************   开始删除   *************** ");
		clean(dir);
		System.out.println("****************   删除结束   ***************");
	}

	public static void clean(File file)
	{
		if(file.isDirectory())
		{
			for(File f : file.listFiles())
			{
				if(!isProtected(f))
				{
					if(null != f.list())
					{
						if(f.listFiles().length==0)
							delete(f);
						else
							clean(f);
					}
					
					if(f.isFile())
					{
						delete(f);
					}
				}
			}
		}

	}

	public static void delete(File f)
	{
		if (f.exists() && !f.equals(dir))
		{
			if(f.isFile()|| ( f.isDirectory() && f.listFiles().length == 0))
			{
				System.out.println(f);

				f.delete();

				f = f.getParentFile();
				delete(f);
			}
		}
	}	
	
	public static boolean isProtected(File file)
	{
		boolean flag = false;
		String path = file.getPath();
		for(String fname : fnames)
		{
			if(path.equals(dpath+fname))
			{
				flag = true;
			}
		}
		return flag;
	}
}
