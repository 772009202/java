package algorithm.dfs.middleorder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenyu
 * @date 2021-07-16
 */
public class Course {

  class Solution {
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
      edges = new ArrayList<>();
      for (int i = 0; i < numCourses; ++i) {
        edges.add(new ArrayList<>());
      }
      visited = new int[numCourses];
      for (int[] info : prerequisites) {
        edges.get(info[1]).add(info[0]);
      }
      for (int i = 0; i < numCourses && valid; ++i) {
        if (visited[i] == 0) {
          dfs(i);
        }
      }
      return valid;
    }

    public void dfs(int u) {
      visited[u] = 1;
      for (int v : edges.get(u)) {
        if (visited[v] == 0) {
          dfs(v);
          if (!valid) {
            return;
          }
        } else if (visited[v] == 1) {
          valid = false;
          return;
        }
      }
      visited[u] = 2;
    }
  }
}
