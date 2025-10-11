R, C = map(int, input().split())
grid = [list(input().strip()) for _ in range(R)]
seq = input().strip()

# Directions: up, right, down, left
dirs = [(-1, 0), (0, 1), (1, 0), (0, -1)]

valid_positions = set()

for i in range(R):
    for j in range(C):
        if grid[i][j] == '.':
            for d in range(4):  # 4 directions
                x, y, dir_idx = i, j, d
                ok = True

                for move in seq:
                    if move == 'L':
                        dir_idx = (dir_idx + 3) % 4
                    elif move == 'R':
                        dir_idx = (dir_idx + 1) % 4
                    elif move == 'S':
                        dx, dy = dirs[dir_idx]
                        x += dx
                        y += dy
                        if not (0 <= x < R and 0 <= y < C and grid[x][y] == '.'):
                            ok = False
                            break
                if ok:
                    valid_positions.add((x, y))

if valid_positions:
    print(len(valid_positions))
else:
    print("Impossible")
