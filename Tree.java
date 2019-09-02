package tuan_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Tree {
	double[][] arrTree;

	public void addInfinity() {
		for (int i = 0; i < arrTree.length; i++) {
			for (int j = 0; j < arrTree.length; j++) {
				arrTree[i][j] = Double.POSITIVE_INFINITY;
				arrTree[j][i] = Double.POSITIVE_INFINITY;
			}
		}
	}
//public void inTree() {
//	for(int i =0;i< arrTree.length) {
//		for(int )
//	}
//}
	// đếm số đỉnh của đồ thị
	public int countEdgesTree() {
		int s = 0;
		for (int i = 0; i < arrTree.length; i++) {
			for (int j = 0; j < arrTree.length; j++) {
				if (arrTree[i][j] < Double.POSITIVE_INFINITY) {
					s = s + 1;
				}
			}
		}
		return s / 2;
	}

	public Tree(int n) {
		arrTree = new double[n][n];
	}

	// thêm cạnh vao do thi
	public void addWEdge(int x, int y, double w) {
		arrTree[x][y] = w;
		arrTree[y][x] = w;

	}

	// in một đồ thị dạng ma trận
	public void printAddMatrix() {
		for (int i = 0; i < arrTree.length; i++) {
			for (int j = 0; j < arrTree.length; j++) {
				System.out.print(arrTree[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

	// tìm cây bao trùm nhỏ nhất kruskal
	public Tree findKruskal() {
		Tree T = new Tree(arrTree.length);
		T.addInfinity();
		List<EdgeW> listEdge = new ArrayList<EdgeW>();
		// thêm cạnh có trọng số vào list
		for (int i = 0; i < arrTree.length; i++) {
			for (int j = i + 1; j < arrTree.length; j++) {
				if (arrTree[i][j] < Double.POSITIVE_INFINITY) {
					listEdge.add(new EdgeW(i, j, arrTree[i][j]));
				}
			}
		}
		// sap xep list canh trong so
		Collections.sort(listEdge);
		//in ra danh sách các cạnh trọng số đã sắp xếp
		for (int i = 0; i < listEdge.size(); i++) {
			System.out.println(listEdge.get(i).getS() + "/" + listEdge.get(i).getD() + "/" + listEdge.get(i).getW());
		}
		int id = 0;
		while (T.countEdgesTree() < (arrTree.length - 1)) {
			EdgeW e = listEdge.get(id);
			id++;
			if (!T.checkHasCycle(e.getS(), e.getD())) {
				T.addWEdge(e.getS(), e.getD(), e.getW());
			}
		}
		System.out.println("danh sach canh: ");
		System.out.println(listEdge.toString());
		return T;
	}

	// kiểm tra xem có đường đi giữa 2 đỉnh hay không, cách làm tương tự Dfs
	public boolean checkHasCycle(int a, int b) {
		boolean[] visited = new boolean[arrTree.length];
		Stack<Integer> stack = new Stack<>();
		int v = a;
		visited[v] = true;

		boolean stop = false;
		while (!stop) {
			boolean found = false;
			for (int i = 0; i < arrTree.length; i++) {
				if (arrTree[v][i] < Double.POSITIVE_INFINITY && visited[i] == false) {
					stack.push(v);
					v = i;
					found = true;
					visited[i] = true;
					if (i == b) {
						stop = true;
						return true;
					}
					break;
				}
			}
			if (found == false)
				if (!stack.isEmpty())
					v = stack.pop();
				else
					stop = true;
		}
		return false;
	}

	public Tree prim(int start) {
		Tree T = new Tree(arrTree.length);
		// tạo đồ thị T với tất cả là vô cực
		T.addInfinity();
		// tạo danh sách chứa các cạnh có trong cây kết quả
		List<EdgeW> listCanhTrongT = new ArrayList<EdgeW>();
		ArrayList<Integer> Vt = new ArrayList<>();
		Vt.add(start);
		while (listCanhTrongT.size() < (arrTree.length - 1)) {
			// tạo danh sách cạnh tạm thời để lấy ra cạnh nhỏ nhất thêm vào list cạnh kết quả
			List<EdgeW> listCanh = new ArrayList<EdgeW>();
			// tìm xem nếu có đỉnh kề với các đỉnh trong Vt thì add thêm cạnh vào listCanh
			// đỉnh nguồn i phải thuộc Vt, j là đỉnh kề các i mà ko thuộc Vt
			for (int i = 0; i < Vt.size(); i++) {
				int k= Vt.get(i);
				for (int j = 0; j < arrTree.length; j++) {
					if (arrTree[k][j] < Double.POSITIVE_INFINITY && !Vt.contains(j) ) {
						listCanh.add(new EdgeW(k, j, arrTree[k][j]));
					}
				}
			}
			// xem thứ tự đi qua các đỉnh khi tìm cây, in ra console
			System.out.println(Vt);

			Collections.sort(listCanh);
			listCanhTrongT.add(listCanh.get(0));

			// for (int i = 0; i < listCanhTrongT.size(); i++) {
			// System.out.println(listCanhTrongT.get(i).getS() + "/" +
			// listCanhTrongT.get(i).getD() + "/" + listCanhTrongT.get(i).getW());
			// }

			for (int i = 0; i < listCanhTrongT.size(); i++) {
				EdgeW e = listCanhTrongT.get(i);
				if (!Vt.contains(e.getD())) {
					Vt.add(e.getD());
				}
			}
		}
		for (int i = 0; i < listCanhTrongT.size(); i++) {
			EdgeW e = listCanhTrongT.get(i);
			T.addWEdge(e.getS(), e.getD(), e.getW());
		}
		return T;
	}

	public static void main(String[] args) {
		Tree tree = new Tree(9);
		tree.addInfinity();

		tree.addWEdge(0, 1, 8);
		tree.addWEdge(0, 5, 3);
		tree.addWEdge(1, 5, 7);
		tree.addWEdge(1, 2, 9);
		tree.addWEdge(1, 4, 12);
		tree.addWEdge(2, 4, 18);
		tree.addWEdge(2, 3, 4);
		tree.addWEdge(3, 4, 6);
		tree.addWEdge(4, 6, 5);
		tree.addWEdge(6, 5, 10);
		tree.addWEdge(6, 8, 1);
		tree.addWEdge(6, 7, 11);

		System.out.println("--Đồ thị ban đầu:");
		tree.printAddMatrix();
		System.out.println("---------------------------- ");
		System.out.println("so cạnh cua do thi: " + tree.countEdgesTree());
		System.out.println("kiểm tra từ có đường đi từ đỉnh 0 đến 3 hay không: " + tree.checkHasCycle(0, 3));
		System.out.println("---------------------------- ");
		System.out.println("cây bao trùm nhỏ nhất với TT Kruskal");
		tree.findKruskal().printAddMatrix();
		System.out.println("---------------------------- ");
		System.out.println("cây bao trùm nhỏ nhất với TT Prim");
		tree.prim(0).printAddMatrix();
	}
}
