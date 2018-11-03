package com.graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadGraph {
	
	public static Graph read(File file, int type) {
		Graph g;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String l = br.readLine();
			String[] str = l.split(" ");
			if (type == 1) {
				g = new DenseGraph(Integer.parseInt(str[0]), false);
			}
			else {
				g = new SparseGraph(Integer.parseInt(str[0]), false);
			}
			while((l = br.readLine()) != null) {
				String[] arr = l.split(" ");
				g.add(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
				
			}
			return g;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
