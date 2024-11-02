class Solution:
    def isCircularSentence(self, sentence: str) -> bool:
        if sentence[0]!=sentence[-1]:
            return False
        
        words_list = sentence.split(" ")
        for i in range(len(words_list) - 1):
            if words_list[i][-1] != words_list[i + 1][0]:
                return False
        
        return True