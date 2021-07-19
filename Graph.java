package tuan_1;

import java.util.ArrayList;

public abstract class Graph {
	protected int[][] adj;

	public Graph(int n) {
		adj = new int[n][n];
	}

	public abstract void addEdge(int x, int y);
//in một đồ thị dạng ma trận 123 23
	public void printAddMatrix() {
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.print(adj[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}
	//kiem tra lien thong giua 2 dinh 123123
	public abstract boolean isconectedDegree2(int a, int b);
	//đếm số cạnh
	public abstract int countEdges();
	//duyệt theo chiều sâu DFS
	//public abstract void dFS(int start);
	public abstract ArrayList<Integer> dFS(int start);
	//Duyệt theo chiều rộng.
	public abstract ArrayList<Integer> bFS(int start);
	//kiểm tra xem đồ thị phải euler hay không
	public abstract boolean kTraCTEuler();
	//kiểm tra xem đồ thị có phải nữa euler hay không
	public abstract boolean kTraNuaEuler();
	//chu trình euler
	public abstract ArrayList<Integer> xuatCTrinhEuler(int start);
	//in đường đi euler
	public abstract ArrayList<Integer> printDuongDiEuler();
	
	//kiểm tra lưỡng phân hay không
	public abstract boolean checkBipartiteGraph();
	//kiểm tra liên thông
	public abstract boolean isConnection();
	////kiểm tra đồ thị có bao nhiêu đồ thành phần liên thông
	public abstract int countConnection();
	//hamilton
	public abstract boolean checkHamiltonCycle();
	public abstract void hamiltonianCycle(int index);
	
	/////////////////////
//	public ArrayList<Integer> timDinhKe(int n) {
//		ArrayList<Integer> k = new ArrayList<>();
//		for (int i = 0; i < adj.length; i++) {
//			if (adj[n][i] > 0)
//				k.add(i);
//		}
//		return k;
//	}
//	public boolean giao(ArrayList<Integer> a, ArrayList<Integer> b) {
//		boolean result = false;
//		// nếu a giao b ra rỗng thì trả về true không thì false
//		a.retainAll(b);
//
//		if (a.size()==0) {
//			result = true;
//		}
//		return result;
//	}
//	public boolean kiemTraLuongPhan() {
//		boolean result2 = true;
//		ArrayList<Integer> x = new ArrayList<>();
//		ArrayList<Integer> y = new ArrayList<>();
//		ArrayList<Integer> t = new ArrayList<>();
//		ArrayList<Integer> z = new ArrayList<>();
//		x.add(0);
//		for (int i = 0; i < x.size(); i++) {
//			y = timDinhKe(x.get(i));
//		}
//		for (int j = 0; j < y.size(); j++) {
//			t = timDinhKe(y.get(j));
//		}
//		for (int k = 0; k < t.size(); k++) {
//			z = timDinhKe(t.get(k));
//		}
//		
//		if(giao(x,y) == false) {result2 =false; 
//		}
//		if (giao(y, t) == false) {
//			result2 = false;
//		}
//		if(giao(t, z) == false) {
//			result2 = false;
//		}
//		System.out.println("ssss");
//		return result2;
//	}
}
