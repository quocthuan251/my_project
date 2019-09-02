package tuan_1;

import java.util.ArrayList;
import java.util.Stack;

public class DirectedGraph extends Graph {

	public DirectedGraph(int n) {
		super(n);

	}

	@Override
	public void addEdge(int x, int y) {
		adj[x][y] += 1;
	}

	public int inDegree(int v) {
		int s = 0;
		for (int j = 0; j < adj.length; j++) {
			s += adj[j][v];
		}
		return s;
	}

	public int outDegree(int v) {
		int s = 0;
		for (int j = 0; j < adj.length; j++) {
			s += adj[v][j];
		}
		return s;
	}

	@Override
	public int countEdges() {
		int s = 0;
		for (int i = 0; i < adj.length; i++) {
			s += inDegree(i);
		}
		return s;
	}
	public int[][] saoMang(int[][] arr) {
		int[][] arrCopy = new int[arr.length][arr.length];
		for (int i = 0; i < arrCopy.length; i++)
			for (int j = 0; j < arrCopy[i].length; j++)
				arrCopy[i][j] = arr[i][j];
		return arrCopy;
	}
	public int[][] transLate(DirectedGraph gg) {
		int[][] arrCopy = saoMang(gg.adj);
		for (int i = 0; i < arrCopy.length; i++) {
			for (int j = 0; j < arrCopy.length; j++) {
				arrCopy[i][j] += arrCopy[j][i];
				// arrCopy[j][i] = arrCopy[i][j];
			}
		}
		for (int i = 0; i < arrCopy.length; i++) {
			int k = 0;
			for (int j = k; j < arrCopy.length; j++) {
				arrCopy[j][i] = arrCopy[i][j];
			}
			k++;
		}
		return arrCopy;
	}

	@Override
	public ArrayList<Integer> dFS(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean kTraCTEuler() {
		if (adj.length <= 1)
			return false;
		for (int i = 0; i < adj.length; i++) {
			if (inDegree(i) != outDegree(i))
				return false;
		}
		return true;
	}

	@Override
	public boolean kTraNuaEuler() {
		int a = 0;
		int b = 0;
		int c = 0;
		for (int i = 0; i < adj.length; i++) {
			if (inDegree(i) == outDegree(i) + 1)
				a++;
			if (outDegree(i) == inDegree(i) + 1)
				b++;
			if (inDegree(i) == outDegree(i))
				c++;
		}
		if (a == 1 && b == 1 && a + b + c == adj.length)
			return true;
		return false;
	}

	@Override
	public boolean checkBipartiteGraph() {
		// TODO Auto-generated method stub
		return false;
	}
	//////////////////////////
	//kiểm tra liên thông yếu
	public boolean weaklyConnected() {
		boolean[] visited = new boolean[adj.length];
		Stack<Integer> stack = new Stack<>();
		int v = 0;
		visited[v] = true;
		boolean stop = false;
		int[][] arr = transLate(this);
		// while (!stack.isEmpty()) {
		while (!stop) {
			boolean found = false;
			for (int i = 0; i < arr.length; i++) {
				if (arr[v][i] > 0 && visited[i] == false) {
					stack.push(v);
					v = i;
					found = true;
					visited[i] = true;
					break;
				}
			}
			if (found == false)
				if (!stack.isEmpty())
					v = stack.pop();
				else stop=true;
		}
		for(int i=0;i<visited.length;i++) {
		if(	visited[i]==false)
					return false;
		}
		return true;
	}
	public boolean StronglyConnected() {
		if(!weaklyConnected())return false;
		for (int i = 0; i < adj.length; i++) {
			if (inDegree(i)<1||outDegree(i)<1)return false;}
		return true;
	}
	@Override
	public boolean isConnection() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int countConnection() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Integer> bFS(int start) {
		// TODO Auto-generated method stub
		return null;
	}

	// @Override
	// public ArrayList<Integer> printCTrinhEuler(int start) {
	//
	// return null;
	// }

	@Override
	public ArrayList<Integer> printDuongDiEuler() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		DirectedGraph gg = new DirectedGraph(4);

		// gg.addEdge(0, 4);
		// gg.addEdge(1, 0);
		// gg.addEdge(1, 4);
		// gg.addEdge(1, 3);
		// gg.addEdge(2, 1);
		// gg.addEdge(3, 1);
		// gg.addEdge(3, 2);
		// gg.addEdge(4, 1);
		// gg.addEdge(4, 3);
		/////
//		gg.addEdge(0, 4);
//		gg.addEdge(1, 0);
//		gg.addEdge(1, 4);
//		gg.addEdge(1, 3);
//		gg.addEdge(2, 1);
//		gg.addEdge(3, 2);
//		gg.addEdge(3, 1);
//		gg.addEdge(4, 1);
//		gg.addEdge(4, 3);
		/////////////
		gg.addEdge(0, 1);
		gg.addEdge(1, 3);
		gg.addEdge(1, 2);
		gg.addEdge(2, 1);
		gg.addEdge(2, 3);
		gg.addEdge(3, 2);
		gg.addEdge(3, 0);
		gg.printAddMatrix();
		System.out.println("//////////////////////////");
		System.out.println("chuyển đổi dt có hướng thành vô hướng");
		int[][] a = gg.transLate(gg);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		 System.out.println("số nữa bậc trong của đỉnh 1 là: " +gg.inDegree(1));
		 System.out.println("số nữa bậc ngoai của đỉnh 1 là: " +gg.outDegree(1));
		 System.out.println("số cạnh của đồ thị có hướng: " + gg.countEdges());
		 System.out.println("kiểm tra có nửa euler: "+gg.kTraNuaEuler());
		 System.out.println("kiểm tra có CT euler: "+gg.kTraCTEuler());
		 System.out.println(gg.xuatCTrinhEuler(0));
		 System.out.println("lien thong yeu hay ko: "+ gg.weaklyConnected());
		 System.out.println("lien thong manh hay ko: "+ gg.StronglyConnected());
	}

	@Override
	public ArrayList<Integer> xuatCTrinhEuler(int start) {
		ArrayList<Integer> result = new ArrayList<>();
		if (kTraCTEuler()) {
			int[][] arrCopy = saoMang(adj);
			Stack<Integer> stack = new Stack<>();
			stack.push(start);
			ArrayList<Integer> listVisit = new ArrayList<>();
			while (!stack.isEmpty()) {
				int v = stack.peek();
				boolean found = false;
				for (int i = 0; i < arrCopy.length; i++) {
					if ((arrCopy[v][i] > 0)) {
						found = true;
						stack.push(i);
						arrCopy[v][i]--;
					//	arrCopy[i][v]--;
						break;
					}
				}
				if (found == false) {
					listVisit.add(stack.pop());
				}
			}
			// đảo ngược listVisit lại vì pop từ stack.
			for (int i = listVisit.size() - 1; i >= 0; i--) {
				result.add(listVisit.get(i));
			}
			return result;
		}
		return result;
	}
//	public ArrayList<Integer> xuatCTrinhEuler2(int start) {
//		ArrayList<Integer> result = new ArrayList<>();
//		int[][] arrCopy = saoMang(adj);
//		return result;
//	}

	@Override
	public boolean checkHamiltonCycle() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void hamiltonianCycle(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isconectedDegree2(int a, int b) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
