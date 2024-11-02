import java.util.*;
import java.io.*;

public class DeleteEmptyDir
{
	public static File dir = new File("/storage/emulated/0");
	public static void main()
	{
		System.out.println("****************   删除空文件夹  *************** ");
		clean(dir);
		System.out.println("****************   删除空文件夹结束   ***************");
	}
	
	public static void clean(File file)
	{
		if(file.isDirectory())
		{
			for(File f : file.listFiles())
			{
				if( null != f.list() )
				{
					if(f.listFiles().length==0)
						delete(f);
					else
						clean(f);
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
}
