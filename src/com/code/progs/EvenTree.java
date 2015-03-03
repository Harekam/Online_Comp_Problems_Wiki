package com.code.progs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class EvenTree {
	private int tree[], nodesCount[], size;
	private boolean[] visited;

	public EvenTree(int n) {
		size = n;

		tree = new int[n];
		nodesCount = new int[n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			nodesCount[i] = 0;
			visited[i] = false;
			tree[i] = 0;

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
		EvenTree evenTree = new EvenTree(n);
		while (m-- > 0) {
			input = in.readLine().trim();
			st = new StringTokenizer(input);
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			evenTree.addNode(p - 1, q - 1);
		}
		// evenTree.show();
		evenTree.countChildNodes();
		// evenTree.show();
		int result = evenTree.countEven();
		out.write(result + "");
		out.flush();
	}

	private void addNode(int p, int q) {
		tree[p] = q;
		// nodesCount[q]++;
	}

	private void countChildNodes() {
		for (int node = size - 1; node >= 0; node--) {
			int parent = node;
			while (parent != 0) {
				nodesCount[parent]++;
				parent = tree[parent];
			}

		}
	}

	private int countEven() {
		int count = 0;
		for (int i = 1; i < size; i++) {
			if (nodesCount[i] % 2 == 0)
				count++;
		}
		return count;
	}

	private void show() {
		StringBuffer sb2 = new StringBuffer();
		int m = tree.length;
		for (int i = 0; i < m; i++) {

			sb2.append(nodesCount[i] + " ");
		}

		System.out.println(sb2);
	}

}
