class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        if(!l1) return l2;
        if(!l2) return l1;
        ListNode* head=l1;

        if(l1->val > l2->val){
            head=l2;
            l2=l2->next;
        }else{
            head=l1;
            l1=l1->next;
        }

        ListNode* cru=head;
        while(l1 &&l2 ){
            if(l1->val < l2->val){
                cru->next=l1;
                l1=l1->next;

            }else{
                cru->next=l2;
                l2=l2->next;
            }
            cru=cru->next;
        }
        if(!l1) cru->next=l2;
        else cru->next=l1;
        return head;
    }
};