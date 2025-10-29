"""
Complex Data Structures & Algorithms Solutions
Contains implementations for advanced problems in graphs, trees, dynamic programming, and more
"""

# ==================== GRAPH ALGORITHMS ====================

class Graph:
    """Advanced graph implementations with multiple algorithms"""
    
    def __init__(self, vertices):
        self.V = vertices
        self.graph = [[] for _ in range(vertices)]
        self.adj_matrix = [[0] * vertices for _ in range(vertices)]
    
    def add_edge(self, u, v, weight=1):
        self.graph[u].append((v, weight))
        self.adj_matrix[u][v] = weight
    
    def dijkstra(self, src):
        """Dijkstra's shortest path algorithm using min heap"""
        import heapq
        dist = [float('inf')] * self.V
        dist[src] = 0
        pq = [(0, src)]
        
        while pq:
            d, u = heapq.heappop(pq)
            if d > dist[u]:
                continue
            for v, w in self.graph[u]:
                if dist[u] + w < dist[v]:
                    dist[v] = dist[u] + w
                    heapq.heappush(pq, (dist[v], v))
        return dist
    
    def bellman_ford(self, src):
        """Bellman-Ford algorithm for negative edge weights"""
        dist = [float('inf')] * self.V
        dist[src] = 0
        
        for _ in range(self.V - 1):
            for u in range(self.V):
                for v, w in self.graph[u]:
                    if dist[u] != float('inf') and dist[u] + w < dist[v]:
                        dist[v] = dist[u] + w
        
        # Check for negative cycles
        for u in range(self.V):
            for v, w in self.graph[u]:
                if dist[u] != float('inf') and dist[u] + w < dist[v]:
                    return None  # Negative cycle detected
        return dist
    
    def floyd_warshall(self):
        """All-pairs shortest path algorithm"""
        dist = [[float('inf')] * self.V for _ in range(self.V)]
        
        for i in range(self.V):
            dist[i][i] = 0
        
        for u in range(self.V):
            for v, w in self.graph[u]:
                dist[u][v] = w
        
        for k in range(self.V):
            for i in range(self.V):
                for j in range(self.V):
                    dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
        
        return dist
    
    def tarjan_scc(self):
        """Tarjan's algorithm for strongly connected components"""
        index = 0
        stack = []
        indices = [-1] * self.V
        lowlinks = [-1] * self.V
        on_stack = [False] * self.V
        sccs = []
        
        def strongconnect(v):
            nonlocal index
            indices[v] = index
            lowlinks[v] = index
            index += 1
            stack.append(v)
            on_stack[v] = True
            
            for w, _ in self.graph[v]:
                if indices[w] == -1:
                    strongconnect(w)
                    lowlinks[v] = min(lowlinks[v], lowlinks[w])
                elif on_stack[w]:
                    lowlinks[v] = min(lowlinks[v], indices[w])
            
            if lowlinks[v] == indices[v]:
                scc = []
                while True:
                    w = stack.pop()
                    on_stack[w] = False
                    scc.append(w)
                    if w == v:
                        break
                sccs.append(scc)
        
        for v in range(self.V):
            if indices[v] == -1:
                strongconnect(v)
        
        return sccs
    
    def kruskal_mst(self):
        """Kruskal's algorithm for minimum spanning tree"""
        edges = []
        for u in range(self.V):
            for v, w in self.graph[u]:
                edges.append((w, u, v))
        edges.sort()
        
        parent = list(range(self.V))
        rank = [0] * self.V
        
        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        def union(x, y):
            px, py = find(x), find(y)
            if px == py:
                return False
            if rank[px] < rank[py]:
                px, py = py, px
            parent[py] = px
            if rank[px] == rank[py]:
                rank[px] += 1
            return True
        
        mst = []
        for w, u, v in edges:
            if union(u, v):
                mst.append((u, v, w))
        return mst
    
    def topological_sort(self):
        """Topological sort using DFS"""
        visited = [False] * self.V
        stack = []
        
        def dfs(v):
            visited[v] = True
            for u, _ in self.graph[v]:
                if not visited[u]:
                    dfs(u)
            stack.append(v)
        
        for i in range(self.V):
            if not visited[i]:
                dfs(i)
        
        return stack[::-1]


# ==================== ADVANCED TREE STRUCTURES ====================

class AVLNode:
    def __init__(self, key):
        self.key = key
        self.left = None
        self.right = None
        self.height = 1

class AVLTree:
    """Self-balancing AVL Tree implementation"""
    
    def get_height(self, node):
        return node.height if node else 0
    
    def get_balance(self, node):
        return self.get_height(node.left) - self.get_height(node.right) if node else 0
    
    def rotate_right(self, y):
        x = y.left
        T2 = x.right
        x.right = y
        y.left = T2
        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))
        x.height = 1 + max(self.get_height(x.left), self.get_height(x.right))
        return x
    
    def rotate_left(self, x):
        y = x.right
        T2 = y.left
        y.left = x
        x.right = T2
        x.height = 1 + max(self.get_height(x.left), self.get_height(x.right))
        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))
        return y
    
    def insert(self, root, key):
        if not root:
            return AVLNode(key)
        
        if key < root.key:
            root.left = self.insert(root.left, key)
        else:
            root.right = self.insert(root.right, key)
        
        root.height = 1 + max(self.get_height(root.left), self.get_height(root.right))
        balance = self.get_balance(root)
        
        # Left Left
        if balance > 1 and key < root.left.key:
            return self.rotate_right(root)
        
        # Right Right
        if balance < -1 and key > root.right.key:
            return self.rotate_left(root)
        
        # Left Right
        if balance > 1 and key > root.left.key:
            root.left = self.rotate_left(root.left)
            return self.rotate_right(root)
        
        # Right Left
        if balance < -1 and key < root.right.key:
            root.right = self.rotate_right(root.right)
            return self.rotate_left(root)
        
        return root


class SegmentTree:
    """Segment Tree for range queries"""
    
    def __init__(self, arr):
        self.n = len(arr)
        self.tree = [0] * (4 * self.n)
        self.build(arr, 0, 0, self.n - 1)
    
    def build(self, arr, node, start, end):
        if start == end:
            self.tree[node] = arr[start]
        else:
            mid = (start + end) // 2
            self.build(arr, 2 * node + 1, start, mid)
            self.build(arr, 2 * node + 2, mid + 1, end)
            self.tree[node] = self.tree[2 * node + 1] + self.tree[2 * node + 2]
    
    def update(self, node, start, end, idx, val):
        if start == end:
            self.tree[node] = val
        else:
            mid = (start + end) // 2
            if idx <= mid:
                self.update(2 * node + 1, start, mid, idx, val)
            else:
                self.update(2 * node + 2, mid + 1, end, idx, val)
            self.tree[node] = self.tree[2 * node + 1] + self.tree[2 * node + 2]
    
    def query(self, node, start, end, l, r):
        if r < start or end < l:
            return 0
        if l <= start and end <= r:
            return self.tree[node]
        mid = (start + end) // 2
        left_sum = self.query(2 * node + 1, start, mid, l, r)
        right_sum = self.query(2 * node + 2, mid + 1, end, l, r)
        return left_sum + right_sum


class Trie:
    """Trie (Prefix Tree) implementation"""
    
    def __init__(self):
        self.root = {}
    
    def insert(self, word):
        node = self.root
        for char in word:
            if char not in node:
                node[char] = {}
            node = node[char]
        node['$'] = True
    
    def search(self, word):
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return '$' in node
    
    def starts_with(self, prefix):
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True
    
    def autocomplete(self, prefix):
        """Find all words with given prefix"""
        node = self.root
        for char in prefix:
            if char not in node:
                return []
            node = node[char]
        
        results = []
        def dfs(curr_node, path):
            if '$' in curr_node:
                results.append(prefix + path)
            for char, next_node in curr_node.items():
                if char != '$':
                    dfs(next_node, path + char)
        
        dfs(node, "")
        return results


# ==================== DYNAMIC PROGRAMMING ====================

def longest_increasing_subsequence(arr):
    """O(n log n) LIS using binary search"""
    from bisect import bisect_left
    tails = []
    
    for num in arr:
        pos = bisect_left(tails, num)
        if pos == len(tails):
            tails.append(num)
        else:
            tails[pos] = num
    
    return len(tails)


def edit_distance(s1, s2):
    """Minimum edit distance (Levenshtein distance)"""
    m, n = len(s1), len(s2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    for i in range(m + 1):
        dp[i][0] = i
    for j in range(n + 1):
        dp[0][j] = j
    
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1]
            else:
                dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1])
    
    return dp[m][n]


def matrix_chain_multiplication(dims):
    """Optimal matrix chain multiplication order"""
    n = len(dims) - 1
    dp = [[float('inf')] * n for _ in range(n)]
    
    for i in range(n):
        dp[i][i] = 0
    
    for length in range(2, n + 1):
        for i in range(n - length + 1):
            j = i + length - 1
            for k in range(i, j):
                cost = dp[i][k] + dp[k+1][j] + dims[i] * dims[k+1] * dims[j+1]
                dp[i][j] = min(dp[i][j], cost)
    
    return dp[0][n-1]


def knapsack_01(weights, values, capacity):
    """0/1 Knapsack problem"""
    n = len(weights)
    dp = [[0] * (capacity + 1) for _ in range(n + 1)]
    
    for i in range(1, n + 1):
        for w in range(capacity + 1):
            if weights[i-1] <= w:
                dp[i][w] = max(dp[i-1][w], values[i-1] + dp[i-1][w - weights[i-1]])
            else:
                dp[i][w] = dp[i-1][w]
    
    return dp[n][capacity]


def longest_common_subsequence(s1, s2):
    """LCS with backtracking to get actual sequence"""
    m, n = len(s1), len(s2)
    dp = [[0] * (n + 1) for _ in range(m + 1)]
    
    for i in range(1, m + 1):
        for j in range(1, n + 1):
            if s1[i-1] == s2[j-1]:
                dp[i][j] = dp[i-1][j-1] + 1
            else:
                dp[i][j] = max(dp[i-1][j], dp[i][j-1])
    
    # Backtrack to find LCS
    lcs = []
    i, j = m, n
    while i > 0 and j > 0:
        if s1[i-1] == s2[j-1]:
            lcs.append(s1[i-1])
            i -= 1
            j -= 1
        elif dp[i-1][j] > dp[i][j-1]:
            i -= 1
        else:
            j -= 1
    
    return ''.join(reversed(lcs))


def rod_cutting(prices, n):
    """Maximum revenue from cutting rod"""
    dp = [0] * (n + 1)
    
    for i in range(1, n + 1):
        for j in range(i):
            dp[i] = max(dp[i], prices[j] + dp[i - j - 1])
    
    return dp[n]


# ==================== ADVANCED ALGORITHMS ====================

def rabin_karp(text, pattern):
    """Rabin-Karp string matching algorithm"""
    d = 256  # Number of characters
    q = 101  # Prime number
    m = len(pattern)
    n = len(text)
    h = pow(d, m - 1) % q
    p = 0  # Pattern hash
    t = 0  # Text hash
    result = []
    
    for i in range(m):
        p = (d * p + ord(pattern[i])) % q
        t = (d * t + ord(text[i])) % q
    
    for i in range(n - m + 1):
        if p == t:
            if text[i:i+m] == pattern:
                result.append(i)
        
        if i < n - m:
            t = (d * (t - ord(text[i]) * h) + ord(text[i + m])) % q
            if t < 0:
                t += q
    
    return result


def kmp_search(text, pattern):
    """Knuth-Morris-Pratt string matching"""
    def compute_lps(pattern):
        m = len(pattern)
        lps = [0] * m
        length = 0
        i = 1
        
        while i < m:
            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length
                i += 1
            else:
                if length != 0:
                    length = lps[length - 1]
                else:
                    lps[i] = 0
                    i += 1
        return lps
    
    n, m = len(text), len(pattern)
    lps = compute_lps(pattern)
    result = []
    i = j = 0
    
    while i < n:
        if text[i] == pattern[j]:
            i += 1
            j += 1
        
        if j == m:
            result.append(i - j)
            j = lps[j - 1]
        elif i < n and text[i] != pattern[j]:
            if j != 0:
                j = lps[j - 1]
            else:
                i += 1
    
    return result


def manacher_algorithm(s):
    """Manacher's algorithm for longest palindrome"""
    t = '#'.join('^{}$'.format(s))
    n = len(t)
    p = [0] * n
    center = right = 0
    
    for i in range(1, n - 1):
        if i < right:
            p[i] = min(right - i, p[2 * center - i])
        
        while t[i + p[i] + 1] == t[i - p[i] - 1]:
            p[i] += 1
        
        if i + p[i] > right:
            center, right = i, i + p[i]
    
    max_len, center_idx = max((n, i) for i, n in enumerate(p))
    return s[(center_idx - max_len) // 2:(center_idx + max_len) // 2]


def convex_hull(points):
    """Graham scan for convex hull"""
    def cross(o, a, b):
        return (a[0] - o[0]) * (b[1] - o[1]) - (a[1] - o[1]) * (b[0] - o[0])
    
    points = sorted(set(points))
    if len(points) <= 1:
        return points
    
    lower = []
    for p in points:
        while len(lower) >= 2 and cross(lower[-2], lower[-1], p) <= 0:
            lower.pop()
        lower.append(p)
    
    upper = []
    for p in reversed(points):
        while len(upper) >= 2 and cross(upper[-2], upper[-1], p) <= 0:
            upper.pop()
        upper.append(p)
    
    return lower[:-1] + upper[:-1]


def suffix_array(s):
    """Build suffix array using sorting"""
    n = len(s)
    suffixes = [(s[i:], i) for i in range(n)]
    suffixes.sort()
    return [idx for _, idx in suffixes]


def lcp_array(s, suffix_arr):
    """Longest common prefix array from suffix array"""
    n = len(s)
    rank = [0] * n
    lcp = [0] * (n - 1)
    
    for i, suffix_idx in enumerate(suffix_arr):
        rank[suffix_idx] = i
    
    h = 0
    for i in range(n):
        if rank[i] > 0:
            j = suffix_arr[rank[i] - 1]
            while i + h < n and j + h < n and s[i + h] == s[j + h]:
                h += 1
            lcp[rank[i] - 1] = h
            if h > 0:
                h -= 1
    
    return lcp


# ==================== EXAMPLE USAGE ====================

if __name__ == "__main__":
    # Graph example
    g = Graph(6)
    g.add_edge(0, 1, 4)
    g.add_edge(0, 2, 3)
    g.add_edge(1, 2, 1)
    g.add_edge(1, 3, 2)
    g.add_edge(2, 3, 4)
    g.add_edge(3, 4, 2)
    g.add_edge(4, 5, 6)
    
    print("Dijkstra's shortest paths from node 0:")
    print(g.dijkstra(0))
    
    # AVL Tree example
    avl = AVLTree()
    root = None
    for val in [10, 20, 30, 40, 50, 25]:
        root = avl.insert(root, val)
    
    # Segment Tree example
    arr = [1, 3, 5, 7, 9, 11]
    seg_tree = SegmentTree(arr)
    print(f"\nSum of range [1, 3]: {seg_tree.query(0, 0, len(arr)-1, 1, 3)}")
    
    # Trie example
    trie = Trie()
    words = ["apple", "app", "apricot", "banana"]
    for word in words:
        trie.insert(word)
    print(f"\nAutocomplete 'app': {trie.autocomplete('app')}")
    
    # DP examples
    print(f"\nLIS of [10, 9, 2, 5, 3, 7, 101, 18]: {longest_increasing_subsequence([10, 9, 2, 5, 3, 7, 101, 18])}")
    print(f"Edit distance 'kitten' -> 'sitting': {edit_distance('kitten', 'sitting')}")
    print(f"LCS of 'AGGTAB' and 'GXTXAYB': {longest_common_subsequence('AGGTAB', 'GXTXAYB')}")
    
    # String matching
    text = "AABAACAADAABAABA"
    pattern = "AABA"
    print(f"\nKMP search for '{pattern}' in '{text}': {kmp_search(text, pattern)}")
    print(f"Longest palindrome in 'babad': {manacher_algorithm('babad')}")
    
    # Convex hull
    points = [(0, 0), (1, 1), (2, 2), (0, 2), (2, 0), (1, 0.5)]
    print(f"\nConvex hull: {convex_hull(points)}")