package random;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Dungeon {
    static String[] grid = new String[100];
    static char[][] tempGrid = new char[100][100];
    static int N=5, M=10;
    static int[][] dist = new int[100][100];

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};


    public static void main(String[] args) {

        grid = new String[] {
                "S#...........#.........#...#.....#.........#.....",
                ".#.#########.#.#######.#.#.#####.#.#######.#.###.",
                "...#.#...#...#.#.......#.#.........#...#...#...#.",
                "####.#.#.###.#.#.###.###.###########.#.#.#######.",
                "...#.#.#.....#.#...#.#...#...#...#...#.#.#...#...",
                ".#.#.#.#######.###.#.#.###.#.#.#.#.###.#.#.###.##",
                ".#...#.........#...#...#.#.#...#.#...#.#...#...#.",
                ".###############.#######.#.#####.#####.#####.#.#.",
                ".#.....#.........#.......#.#...#.....#...#.#.#.#.",
                ".#####.#########.#.#####.#.#.#.#####.###.#.#.###.",
                ".....#...#...#...#.....#...#.#.............#.....",
                "####.###.#.#.#.#######.#################.#.#####.",
                "...#...#.#.#.#.#...#...#.....#.......#...#.#.....",
                ".#.###.#.#.###.#.#.#.###.###.#######.#.###.#.####",
                ".#...#...........#.#.....#.....#.#...#...#.#.#...",
                ".#.#.###.#########.#####.#.###.#.#.#####.#.#.###.",
                ".#.#...#.#...#.....#.....#...#.....#.....#.#...#.",
                ".#####.#.#.#.#.#############.#######.###.#.#.#.#.",
                ".#...#.#.#.#.#...#...#...#.#.#.......#...#...#.#.",
                ".#.###.#.#.#.###.#.#.#.#.#.#.#.###############.#.",
                ".#...#.....#.#.#...#...#.....#.......#.......#.#.",
                ".###.#######.#.#.###################.#.#####.#.#.",
                ".....#.......#.#.....#.............#...#...#.#...",
                "######.#######.#######.#####.###########.###.####",
                ".#.....#.....#...#.....#.............#.......#...",
                ".#.#########.###.#.#################.#.#.#####.##",
                ".#.....#...#...#.#...#.....#.......#...#.....#...",
                ".#####.#.#.###.#.###.###.###.#####.#########.###.",
                ".......#.#.#.#.#.....#...#...#...#...#.......#...",
                "######.#.#.#.#.#######.#.#.###.#.###.#####.###.##",
                ".....#.#.#...#.#.....#.#.#...#.#...#.......#.....",
                ".###.#.#.###.#.#.###.#.#####.#.###.#######.#.####",
                "...#.#.#...#.#.#...#.#.#.....#...#...#...#.......",
                "##.#.#.###.#.#.###.#.#.#.#######.###.#.#.#######.",
                "...#.#.#...#...#...#.#.......#...#.#.#.#.#.....#.",
                ".###.#.#.###########.#######.###.#.#.#.#.#####.#.",
                "...#...#.#...#...#.#...........#.#.....#.....#.#.",
                ".#.#####.#.#.###.#.#########.#.#.###.###.###.#.#.",
                ".#.........#.....#...........#...#...#.....#...#E"
        };
        N = grid.length;
        M = grid[0].length();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                tempGrid[i][j] = grid[i].charAt(j);
            }
        }



        for (int[] d : dist) {
            Arrays.fill(d, 987654321);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i].charAt(j) == 'S') {
                    queue.add(new int[] {i, j});
                    dist[i][j] = 0;
                }
            }
        }


        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int[] next = new int[] {curr[0] + dx[i], curr[1] + dy[i]};
                if (isValid(next[0], next[1]) && dist[next[0]][next[1]] > dist[curr[0]][curr[1]] + 1) {
                    dist[next[0]][next[1]] = dist[curr[0]][curr[1]] + 1;


                    if (grid[next[0]].charAt(next[1]) == 'E') {
                        modifyGrid(next[0], next[1]);
                        for (int z = 0; z < grid.length; z++) {
                            for (int z1 = 0; z1 < grid[0].length(); z1++) {
                                if (tempGrid[z][z1] == '#') {
                                    System.out.print(" ");
                                } else {
                                    System.out.print(tempGrid[z][z1]);
                                }
                            }
                            System.out.println();
                        }
                        return;
                    }

                    queue.add(next);
                }
            }
        }
    }

    private static void modifyGrid(int x, int y) {
        int curr = dist[x][y] - 1;
        while (curr > 0) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (isValid(nx, ny) && dist[nx][ny] == curr) {
                    if (i == 0) {
                        tempGrid[nx][ny] = '>';
                    } else if (i == 1){
                        tempGrid[nx][ny] = '^';
                    }  else if (i == 2){
                        tempGrid[nx][ny] = '<';
                    }  else {
                        tempGrid[nx][ny] = 'v';
                    }
                    x = nx;
                    y = ny;
                    curr--;
                }
            }
        }
    }

    static boolean isValid(int x, int y) {
        return (x >=0 && x < N && y >=0 && y < M && (grid[x].charAt(y) == '.' || grid[x].charAt(y) == 'E'));
    }


}
