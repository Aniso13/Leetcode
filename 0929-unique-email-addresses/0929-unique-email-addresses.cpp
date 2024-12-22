class Solution {
public:
    int numUniqueEmails(vector<string>& emails) {
        set<string>str;
        for(int i=0;i<emails.size();i++){
            string email=emails[i];
            string clean="";
            for(int j=0;j<email.size();j++){
                if(email[j]=='.')
                    continue;
                else if(email[j]=='+'||email[j]=='@')
                    break;
                clean+=email[j];
            }
            clean+=email.substr(email.find('@'),email.size()-1);
            str.insert(clean);
        }
        return str.size();
    }
};