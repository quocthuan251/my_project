package tuan_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class UnDirectedGraph extends Graph {

	public UnDirectedGraph(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
public int getSize() {
	return adj.length;
}
	@Override
	// thêm cạnh xy
	public void addEdge(int x, int y) {
		adj[x][y]++;
		adj[y][x]++;
		// if (x == y)
		// adj[y][x]--;
	}

	// tính bâc của đỉnh v
	public int degreeOvertex(int v) {
		int s = 0;
		for (int j = 0; j < adj.length; j++) {
			s += adj[v][j];
		}
		return s;
	}

	// đếm số cạnh của đồ thị
	@Override
	public int countEdges() {
		int s = 0;
		for (int i = 0; i < adj.length; i++) {
			s += degreeOvertex(i);
		}
		return s / 2;
	}
//	@Override
//	public boolean isconectedDegree2(int a, int b) {
//		Stack<Integer> stack = new Stack<Integer>();
//		boolean[] array = new boolean[adj.length];
//		int v =a;
//		array[v] = true;
//		if(a==b) return true;
//		while(true) {
//			for(int i= 0;i<adj.length;i++) {
//				if(!array[i] &&adj[v][i]>0) {
//					if(i==b)
//						return true;
//					stack.push(v);
//					v=i;
//					array[v] = true;
//					break;
//				}else {
//					if(!stack.isEmpty()&&i==adj[v].length-1) {
//						v= stack.pop();
//					}
//				}
//			}
//			break;
//		}
//		return false;
//	}
	@Override
	public boolean isconectedDegree2(int a, int b) {
		visitedFalse();
		Stack<Integer> stack = new Stack<>();
		int v = a;
		visited[v] = true;
		ArrayList<Integer> arrR = new ArrayList<>();
		//arrR.add(v);
		boolean stop = false;
		// while (!stack.isEmpty()) {
		while (!stop) {
			boolean found = false;
			for (int i = 0; i < adj.length; i++) {
				if (adj[v][i] > 0 && visited[i] == false) {
					stack.push(v);
				//	arrR.add(i);
					v = i;
					found = true;
					visited[i] = true;
					if(i==b) {
						stop =true;
						return true;
					}
					break;
				}
			}
			if (found == false)
				
				if (!stack.isEmpty())
					v = stack.pop();
					
				else stop=true;
		}
		return false;
		
	}
	// public static void dfs( Graph grap,int v) {
	// Stack<Integer> stacktop = new Stack<>();
	// boolean[] visited = new boolean[grap.adj.length];
	// visited[v] = true;
	// // stacktop.push(v);
	// // while (!stacktop.isEmpty()) {
	//
	// bb: for (int j = 0; j < grap.adj.length; j++) {
	// if (grap.adj[v][j] > 0) {
	// stacktop.push(v);
	// System.out.println(v +" ");
	// v = j;
	// visited[j] = true;
	// } else {
	// if (!stacktop.isEmpty()) {
	// v = stacktop.pop();
	// continue bb;
	// }
	// else break;
	// }
	// }
	//
	// // }
	// // return true;
	// }

	public static void main(String[] args) {
		Graph g = new UnDirectedGraph(9);
		///////////
		// // ma trận lưỡng phân 5x5 biểu diễn ma trận kề vô hướng
		// g.addEdge(0, 1);
		// g.addEdge(0, 3);
		// g.addEdge(0, 4);
		// g.addEdge(1, 2);
		// g.addEdge(2, 3);
		// g.addEdge(2, 4);
		///////////////
		//// ma trận không lưỡng phân 6x6 biểu diễn ma trận kề vô hướng
		// g.addEdge(0, 1);
		// g.addEdge(0, 3);
		// g.addEdge(0, 4);
		// g.addEdge(1, 2);
		// g.addEdge(1, 5);
		// g.addEdge(2, 3);
		// g.addEdge(2, 4);
		// g.addEdge(2, 5);
		//////
		// g.addEdge(0, 1);
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(0, 3);
		// g.addEdge(1, 3);
		// g.addEdge(1, 2);
		// g.addEdge(2, 3);
		// g.addEdge(2, 3);
		///
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(1, 6);
		g.addEdge(1, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 3);
		g.addEdge(5, 4);
		g.addEdge(4, 3);
		g.addEdge(7, 8);
//		g.addEdge(0, 1);
//		g.addEdge(0, 3);
//		g.addEdge(2, 1);
//		g.addEdge(2, 3);
		////
		// g.addEdge(0, 1);
		// g.addEdge(0, 2);
		// g.addEdge(2, 1);
		// g.addEdge(2, 4);
		// g.addEdge(2, 3);
		// g.addEdge(3, 4);
		System.out.println("matrix 5x5");
		g.printAddMatrix();
		System.out.println("\n" + "so canh la: " + g.countEdges());
		// g.dFS(1);
		System.out.println("hai dinh 0 va 5 co lien thong nhau ko "+g.isconectedDegree2(0, 6));
		System.out.println("Thứ tự duyệt qua các đỉnh theo DFS bắt đầu từ đỉnh: " + 0 + "\n" + g.dFS(0).toString());
		System.out.println("Do thi co lien thong hay khong:  " + g.isConnection());
		System.out.println(g.checkBipartiteGraph());
		System.out.println("đồ thị có chu trình euler hay không: " + g.kTraCTEuler());
		System.out.println("đồ thị có phải nữa euler hay không: " + g.kTraNuaEuler());
		 System.out.println("duyet theo BFS: "+"\n" + g.bFS(0).toString());
		System.out.println("chu trình euler: " + g.xuatCTrinhEuler(0).toString());
		// System.out.println("Đường đi euler: " + g.printDuongDiEuler().toString());
		// g.printAddMatrix();
		System.out.println("co la hamilton hay ko: " +g.checkHamiltonCycle());
		g.hamiltonianCycle(0);
		
	}

	boolean[] visited = new boolean[adj.length];

	// cho visited về false
	public void visitedFalse() {
		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
	}

	// Duyệt đồ thị DFS dùng stack
	// @Override
	// public void dFS(int start) {
	//
	// Stack<Integer> stack = new Stack<>();
	// int v = start - 1;
	// System.out.println("Thứ tự duyệt qua các đỉnh theo DFS bắt đầu từ đỉnh: "+
	// start + "\n");
	// visited[v] = true;
	// System.out.print((v + 1) + " ");
	// do {
	// for (int i = 0; i < adj.length; i++) {
	// if (adj[v][i] > 0 && visited[i] == false) {
	// stack.push(v);
	// v = i;
	// visited[i] = true;
	// System.out.print((v + 1) + " ");
	// }
	// if (i == adj.length - 1)
	// if (!stack.isEmpty()) {
	// v = stack.pop();
	// }
	// }
	// } while (!stack.isEmpty());
	// }
/////////////////////////////////////////////////////
	//@Override
//	public ArrayList<Integer> dFS2(int start) {
//		// visitedFalse();
//		Stack<Integer> stack = new Stack<>();
//		int v = start;
//		visited[v] = true;
//		ArrayList<Integer> arrR = new ArrayList<>();
//		stack.push(v);
//		arrR.add(v);
//		while (!stack.isEmpty()) {
//			boolean found = false;
//			for (int i = 0; i < adj.length; i++) {
//				if (adj[v][i] > 0 && visited[i] == false) {
//					stack.push(i);
//					v = i;
//					arrR.add(v);
//					found = true;
//					visited[i] = true;
//					break;
//				}
//			}
//			if (found == false)
//				if (!stack.isEmpty())
//					v = stack.pop();
//
//		}
//		return arrR;
//	}
@Override
	public ArrayList<Integer> dFS(int start) {
		 visitedFalse();
		Stack<Integer> stack = new Stack<>();
		int v = start;
		visited[v] = true;
		ArrayList<Integer> arrR = new ArrayList<>();
		arrR.add(v);
		boolean stop = false;
		// while (!stack.isEmpty()) {
		while (!stop) {
			boolean found = false;
			for (int i = 0; i < adj.length; i++) {
				if (adj[v][i] > 0 && visited[i] == false) {
					stack.push(v);
					arrR.add(i);
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
		return arrR;
	}

	// kiểm tra đồ thị có phải là lưỡng phân hay không
	@Override
	public boolean checkBipartiteGraph() {

		ArrayList<Integer> arrX = new ArrayList<>();
		ArrayList<Integer> arrY = new ArrayList<>();
		boolean luongphan = true;
		arrX.add(0);
		boolean cont = true;
		while (cont) {
			cont = false;
			for (int i = 0; i < arrX.size(); i++) {
				for (int j = 0; j < adj.length; j++) {
					if (adj[(arrX.get(i))][j] > 0 && !arrY.contains(j)) {
						arrY.add(j);
						cont = true;
					}
				}
				for (int h = 0; h < arrY.size(); h++) {
					for (int j = 0; j < adj.length; j++) {
						if (adj[(arrY.get(h))][j] > 0 && arrX.indexOf(j) < 0) {
							// cung co the dung contains thay cho indexOf
							arrX.add(j);
							cont = true;
						}
					}
					for (int k = 0; k < arrX.size(); k++) {
						if (arrY.indexOf(arrX.get(k)) > 0) {
							cont = false;
							luongphan = false;
						}
					}
				}
			}
		}
		System.out.print("\n" + "Do thi co luong phan hay khong:   ");
		return luongphan;
	}

	// kiểm tra đồ thị có liên thông hay không.
	@Override
	public boolean isConnection() {
		dFS(0);
		for (int i = 0; i < adj.length; i++) {
			if (visited[i] == false)
				return false;
		}
		// System.out.print("Do thi co lien thong hay khong: ");
		return true;
	}

	// kiểm tra đồ thị có bao nhiêu đồ thành phần liên thông
	@Override
	public int countConnection() {
		int dem = 1;

		return dem;

	}

	// duyệt theo chiều rộng
	@Override
	public ArrayList<Integer> bFS(int u) {
		boolean[] dinhTham = new boolean[adj.length];
		ArrayList<Integer> arrResult = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		int v;
		queue.add(u);
		dinhTham[u] = true;
		arrResult.add(u);
		while (queue.isEmpty() == false) {
			v = queue.remove();
			for (int i = 0; i < adj.length; i++) {
				if (adj[v][i] > 0 && dinhTham[i] == false) {
					queue.offer(i);
					dinhTham[i] = true;
					arrResult.add(i);
				}
			}
		}

		return arrResult;
	}

	@Override
	public boolean kTraCTEuler() {
		if (isConnection() == false || adj.length <= 1)
			return false;
		for (int i = 0; i < adj.length; i++) {
			if ((degreeOvertex(i) % 2) != 0)
				return false;
		}
		return true;
	}

	@Override
	public boolean kTraNuaEuler() {
		int dem = 0;
		if (isConnection() == false || adj.length <= 1)
			return false;
		for (int i = 0; i < adj.length; i++) {
			if ((degreeOvertex(i) % 2) != 0)
				dem++;
		}
		return dem == 2;
	}

	// sao chép mảng adj thêm 1 mảng phụ
	public int[][] saoMang(int[][] arr) {
		int[][] arrCopy = new int[arr.length][arr.length];
		for (int i = 0; i < arrCopy.length; i++)
			for (int j = 0; j < arrCopy[i].length; j++)
				arrCopy[i][j] = arr[i][j];
		return arrCopy;
	}
	//////////////////////

	// xuất ra chu trình euler của đồ thị nếu có
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
						arrCopy[i][v]--;
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
//		ArrayList<Integer> c = new ArrayList<>();
//		ArrayList<Integer> c1 = new ArrayList<>();
//		boolean found = true;
//	while(found) {
//		
//		
//	}
//		
//		return result;
//	}

	// in ra đường đi euler
	@Override
	public ArrayList<Integer> printDuongDiEuler() {
		int start = 0;
		for (int i = 0; i < adj.length; i++) {
			if (degreeOvertex(i) % 2 != 0) {
				start = i;
				break;
			}
		}
		ArrayList<Integer> resultDD = xuatCTrinhEuler(start);
		return resultDD;
	}

	@Override
	public boolean checkHamiltonCycle() {
		//Dựa vào định lý dirac nè các bạn
				//Dirac (1952) Xét G là đơn đồ thị vô hướng với n đỉnh (n ≥ 3). Nếu d(x) ≥ n/2 với mọi đỉnh x của G thì G là đồ thị Hamilton.
				int top = adj.length;
				if (top < 3)
					return false;
				for (int i = 0; i < adj.length; i++) {
					int sum = degreeOvertex(i);
					if (sum < (top / 2))
						return false;
				}
				return true;
	}
	boolean visited1[];
	//hc là mãng chứa chu trình tìm được
	int[] hc;
	@Override
	public void hamiltonianCycle(int index) {
		//Bước khởi tạo
		visited = new boolean[adj.length];
		hc = new int[adj.length];
		
		//Đánh dấu vị trí đỉnh index được viếng thăm
		for (int j = 0; j < this.adj.length; j++) {
			visited[j] = false;
			hc[index] = 0;
			visited[index] = true;
		}
		//Phương thức đệ quy để duyệt chu trình nếu có
		Expand(1);

	}

	private void Expand(int i) {
		for (int j = 0; j < adj.length; j++)
			if (!visited[j] && this.adj[hc[i - 1]][j] > 0) {
				hc[i] = j;
				if (i < adj.length - 1) {
					visited[j] = true;
					Expand(i + 1);
					visited[j] = false;
				} else if (this.adj[hc[i]][0] > 0) {
					printHamiltonCycle(hc);
				}
			}
	}
	//Phương thức in ra chu trình
	private void printHamiltonCycle(int[] arr) {
		String string = "";
		String temp = " ==> ";
		for (int k = 0; k < arr.length; k++) {
			string += arr[k];
			if (k < arr.length - 1) {
				string += temp;
			}
		}
		System.out.println(string + temp + arr[0]);
	}
	public Tree kruskal() {
		return null;
		
	}

}
