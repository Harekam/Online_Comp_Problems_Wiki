package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	private int tree[][], nodesCount[], size;
	private boolean[] visited;
	private Queue<Integer> queue;

	public BFS(int n) {
		size = n;
		queue = new LinkedList<Integer>();
		tree = new int[n][n];
		nodesCount = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			nodesCount[i] = 1;
			visited[i] = false;
			for (int j = 0; j < n; j++) {
				tree[i][j] = 0;
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
				System.out));

		String input = in.readLine().trim();

		StringTokenizer st = new StringTokenizer(input);
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		BFS bfs = new BFS(n);
		while (m-- > 0) {
			input = in.readLine().trim();
			st = new StringTokenizer(input);
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			bfs.addNode(p - 1, q - 1);
		}

		
		bfs.bfs();
		bfs.show();
		out.flush();
	}

	private void addNode(int p, int q) {
		tree[q][p] = 1;
		// nodesCount[q]++;
	}

	private void bfs() {
		visited[0] = true;
		queue.add(0);
		int i, node;
		while (!queue.isEmpty()) {
			node = queue.remove();
			i = node;
			//System.out.print(i + "\t");
			while (i < size) {
				if (tree[node][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					nodesCount[i]++;
				}
				i++;

			}
		}
	}

	private void show() {
		StringBuffer sb2 = new StringBuffer();
		int m = tree.length;
		for (int i = 0; i < m; i++) {			
			
			sb2.append(nodesCount[i] + " ");
		}
		//System.out.println(sb3);
		//System.out.println(sb1);
		System.out.println(sb2);
	}
}
