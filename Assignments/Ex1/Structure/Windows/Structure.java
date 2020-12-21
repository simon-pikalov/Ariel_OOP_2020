package ex1;

import java.io.File;

public class Structure {

	private static String[] _dirs = {"src", "tests", "README.txt"};
	private static String[] _files = {"node_info.java", "weighted_graph.java",
			"weighted_graph_algorithms.java", "WGraph_Algo.java", "WGraph_DS.java"};
	private static String _log = "";

	public static void main(String[] a) {
		String _log = "";
		String folder_path = System.getProperty("user.dir")+"\\src\\ex1\\";
		String src_file = folder_path+"src\\";
		boolean b0 = testFolders(folder_path);
		boolean b1 =testFiles(src_file);
		System.out.println("Report: Folders: "+b0+"  Files: "+b1);
		if(b0&b1) {
			System.out.println("Ex1 Structure is OK!"); }
		else {
			System.out.println("Ex1 Structure is Wrong!"); }
	}
	
	public static boolean testFolders(String folders_path) {
		boolean ans = true;
		for (int i = 0; i < _dirs.length; i++) {
			File src = new File(folders_path+_dirs[i]);
			if (!src.exists()) {
				ans = false;
				String str = "ERR: no folder named " + _dirs[i];
				if(_dirs[i].equals("README.txt"))
					str = "ERR: no file named " + _dirs[i];
				System.err.println(str);
				log(str);
			}
		}
		return ans;
	}

	public static boolean testFiles(String path_src) {
		boolean ans = true;
		File f = new File(path_src);
		if(f.exists()) {
			for (int i = 0; i < _files.length; i++) {
				File ff = new File(path_src+_files[i]);
				boolean b = ff.exists();
				if (!b) {
					ans = false;
					String str = "ERR: no file named " + ff;
					System.err.println(str);
					log(str);
				}
			}
		}
		else {
			;
		}
		return ans;
	}
	
	private static void log(String s) {
		_log+=s+"\n";
	}
}
