class Solution {
public:
    bool isCircularSentence(string sentence) {
        if (sentence.front() != sentence.back())
            return false;
        
        // Split the sentence by spaces and store each word in a vector
        std::istringstream stream(sentence);
        std::vector<std::string> words;
        std::string word;
        while (stream >> word) {
            words.push_back(word);
        }
        
        // Iterate through each word and check if the last character of the current word
        // matches the first character of the next word
        for (size_t i = 0; i < words.size() - 1; ++i) {
            if (words[i].back() != words[i + 1].front()) {
                return false;
            }
        }
        
        return true;
    }
};