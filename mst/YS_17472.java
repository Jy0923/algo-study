import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 섬 연결 여부 로직을 바꾸자 
public class Main {

	static int[] parent;
	static int n, m;
	static int[][] map;
	static int numOfIsland;
	static island[] sizeOfIsland = new island[7];
	static int[][] isConnected;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int find(int x) {
		if (x != parent[x]) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	static void union(int x, int y) {
		parent[find(y)] = find(x);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[n][m];
		isConnected = new int[121][3];

		for (int row = 0; row < n; row++) {
			st = new StringTokenizer(br.readLine());
			for (int col = 0; col < m; col++) {
				map[row][col] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬에 이름을 붙여주자.
		numOfIsland = 0;

		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (map[row][col] != 0 && !visited[row][col]) {
					++numOfIsland;

					// bfs를 돌면서 rowSt, rowEd, colSt, colEd를 갱신해주자.
					bfs(row, col, numOfIsland);
				}
			}
		}
//		System.out.println(Arrays.deepToString(map));

		parent = new int[numOfIsland + 1];

		int isConnectedIdx = 0;
		for (int i = 0; i < sizeOfIsland.length - 1; i++) {
			for (int j = i + 1; j < sizeOfIsland.length; j++) {
				if (sizeOfIsland[j] == null)
					continue;
				if (sizeOfIsland[i] == null)
					break;

				int dist = Integer.MAX_VALUE;

				// i번째 섬이 j번째 섬의 시작 row와 끝 row 사이에 있을 경우 -> 연결 가능
				if ((sizeOfIsland[i].rowEd >= sizeOfIsland[j].rowSt && sizeOfIsland[i].rowEd <= sizeOfIsland[j].rowEd)
						|| (sizeOfIsland[i].rowSt >= sizeOfIsland[j].rowSt
								&& sizeOfIsland[i].rowSt <= sizeOfIsland[j].rowEd)) {
					if (sizeOfIsland[i].colSt > sizeOfIsland[j].colSt) {
						for (int start = sizeOfIsland[i].rowSt; start <= sizeOfIsland[i].rowEd; start++) {
							int cnt = 0;
							int nr = start;
							int nc = m - 1;
							while (map[nr][nc] != i) {
								nc += dc[2];
							}
							while (map[nr][nc] == i) {
								nc += dc[2];
								if (nr < 0 || nr > n || nc < 0 || nc > m)
									break;
							}
							while (map[nr][nc] != j) {
								cnt++;
								nr = nr + dr[2];
								nc = nc + dc[2];
								if (!(nr >= 0 && nr < n && nc >= 0 && nc < m))
									break;
								if (map[nr][nc] == i)
									continue;
								if ((map[nr][nc] != j && map[nr][nc] != 0))
									break;
							}
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == j) {
								if (cnt > 1 && cnt < dist) {
									dist = cnt;
								}
							}

						}

						// 오른쪽으로 쏘자
					} else {
						for (int start = sizeOfIsland[i].rowSt; start <= sizeOfIsland[i].rowEd; start++) {
							int cnt = 0;
							int nr = start;
							int nc = 0;
							while (map[nr][nc] != i) {
								nc += dc[3];
							}
							while (map[nr][nc] == i) {
								nc += dc[3];
								if (nr < 0 || nr > n || nc < 0 || nc > m)
									break;
							}
							while (map[nr][nc] != j) {
								cnt++;
								nr = nr + dr[3];
								nc = nc + dc[3];
								if (!(nr >= 0 && nr < n && nc >= 0 && nc < m))
									break;
								if (map[nr][nc] == i)
									continue;
								if ((map[nr][nc] != j && map[nr][nc] != 0))
									break;
							}
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == j) {
								if (cnt > 1 && cnt < dist) {
									dist = cnt;
								}
							}

						}
					}
				}

				// 위로 쏘자
				if ((sizeOfIsland[i].colEd >= sizeOfIsland[j].colSt && sizeOfIsland[i].colEd <= sizeOfIsland[j].colEd)
						|| (sizeOfIsland[i].colSt >= sizeOfIsland[j].colSt
								&& sizeOfIsland[i].colSt <= sizeOfIsland[j].colEd)) {
					if (sizeOfIsland[i].rowSt > sizeOfIsland[j].rowSt) {
						for (int start = sizeOfIsland[i].colSt; start <= sizeOfIsland[i].colEd; start++) {
							int cnt = 0;
							int nr = n - 1;
							int nc = start;
							while (map[nr][nc] != i) {
								nr += dr[0];
							}
							while (map[nr][nc] == i) {
								nr += dr[0];
								if (nr < 0 || nr > n || nc < 0 || nc > m)
									break;
							}
							while (map[nr][nc] != j) {
								cnt++;
								nr = nr + dr[0];
								nc = nc + dc[0];
								if (!(nr >= 0 && nr < n && nc >= 0 && nc < m))
									break;
								if (map[nr][nc] == i)
									continue;
								if ((map[nr][nc] != j && map[nr][nc] != 0))
									break;
							}
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == j) {
								if (cnt > 1 && cnt < dist) {
									dist = cnt;
								}
							}

						}
						// 아래로 쏘자
					} else {
						for (int start = sizeOfIsland[i].colSt; start <= sizeOfIsland[i].colEd; start++) {
							int cnt = 0;
							int nr = 0;
							int nc = start;
							while (map[nr][nc] != i) {
								nr += dr[1];
							}
							while (map[nr][nc] == i) {
								nr += dr[1];
								if (nr < 0 || nr > n || nc < 0 || nc > m)
									break;
							}

							while (map[nr][nc] != j) {
								cnt++;
								nr = nr + dr[1];
								nc = nc + dc[1];
								if (!(nr >= 0 && nr < n && nc >= 0 && nc < m))
									break;
								if (map[nr][nc] == i)
									continue;
								if ((map[nr][nc] != j && map[nr][nc] != 0))
									break;
							}
							if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == j) {
								if (cnt > 1 && cnt < dist) {
									dist = cnt;
								}
							}
						}
					}

				}
				if (dist != Integer.MAX_VALUE && dist > 1) {
					isConnected[isConnectedIdx][0] = i;
					isConnected[isConnectedIdx][1] = j;
					isConnected[isConnectedIdx][2] = dist;
					isConnectedIdx++;

				}
			}
		}

		Arrays.sort(isConnected, (o1, o2) -> o1[2] - o2[2]);

		for (int i = 1; i < parent.length; i++) {
			parent[i] = i;
		}
//		System.out.println(Arrays.deepToString(map));
//		System.out.println(Arrays.deepToString(isConnected));

		int ans = 0;
		int lineCnt = 0;
		for (int idx = 0; idx < 121; idx++) {
			if (isConnected[idx][0] == 0)
				continue;
			// 부모가 같다 -> 컨티뉴
			if (find(isConnected[idx][0]) == find(isConnected[idx][1]))
				continue;
			union(isConnected[idx][0], isConnected[idx][1]);
			System.out.println(Arrays.toString(parent));
			ans += isConnected[idx][2];
			lineCnt++;
			if (lineCnt == numOfIsland - 1)
				break;
		}

		if (lineCnt != numOfIsland - 1) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	private static void bfs(int r, int c, int num) {
		int rowSt = r;
		int colSt = c;
		int rowEd = r;
		int colEd = c;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { r, c });
		visited[r][c] = true;
		map[r][c] = num;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int row = curr[0];
			int col = curr[1];
			for (int i = 0; i < 4; i++) {
				int nr = row + dr[i];
				int nc = col + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 0)
					continue;
				visited[nr][nc] = true;
				map[nr][nc] = num;
				if (nr < rowSt)
					rowSt = nr;
				if (nr > rowEd)
					rowEd = nr;
				if (nc < colSt)
					colSt = nc;
				if (nc > colEd)
					colEd = nc;
				queue.offer(new int[] { nr, nc });
			}
		}
//		System.out.println("num" + num);
//		System.out.println("rowSt : " + rowSt);
//		System.out.println("rowEd : " + rowEd);
//		System.out.println("colSt : " + colSt);
//		System.out.println("colEd : " + colEd);

		sizeOfIsland[num] = new island(rowSt, rowEd, colSt, colEd);

	}

	// 각 섬의 행, 열의 시작과 끝을 저장하자.
	// 시작과 끝만 비교하면 되지 않을까?
	static public class island {
		int rowSt, rowEd, colSt, colEd;

		public island(int rowSt, int rowEd, int colSt, int colEd) {
			this.rowSt = rowSt;
			this.rowEd = rowEd;
			this.colSt = colSt;
			this.colEd = colEd;
		}
	}

}
// 결국 틀림
// 나중에 새 로직으로 다시 짜보는걸로

