
# Ref: https://leetcode.com/problems/word-ladder-ii/discuss/2421977/Python-solution-with-explanation-or-optimized
class Solution:

    WILDCARD = "."
    
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if endWord not in wordList:
            return []
        word_tree = self.getWordTree(beginWord, endWord, wordList)
        
        return self.getLadders(beginWord, endWord, word_tree)
    
    
    def getWordTree(self, beginWord: str, endWord: str, wordList: List[str]) -> Dict[str, List[str]]:
        adjacency_list = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                pattern = word[:i] + Solution.WILDCARD + word[i+1:]
                adjacency_list[pattern].append(word)

        visited_tree = {beginWord: []}
        
        found = False
        
        q = deque([beginWord])
        while q and not found:
            n = len(q)
            
            visited_this_level = {}

            for i in range(n):
                word = q.popleft()
                
                for i in range(len(word)):
                    pattern = word[:i] + Solution.WILDCARD + word[i+1:]

                    for next_word in adjacency_list[pattern]:
                        if next_word == endWord:
                            found = True
                        if next_word not in visited_tree:
                            if next_word not in visited_this_level:
                                visited_this_level[next_word] = [word]
                                q.append(next_word)
                            else:
                                visited_this_level[next_word].append(word)
            
            visited_tree.update(visited_this_level)
            
        return visited_tree
    
    
    def getLadders(self, beginWord: str, endWord: str, wordTree: Dict[str, List[str]]) -> List[List[str]]:
        def dfs(node: str) -> List[List[str]]:
            if node == beginWord:
                return [[beginWord]]
            if node not in wordTree:
                return []

            res = []
            parents = wordTree[node]
            for parent in parents:
                res += dfs(parent)
            for r in res:
                r.append(node)
            return res

        return dfs(endWord)
