/* Write your T-SQL query statement below */

with cte as (
select user_id, action,  
(case 
when action='confirmed' then count(action) 
end) as only_conf,
count(action) total
from confirmations
group by user_id, action
)
select s.user_id,  
(COALESCE(round((COALESCE(max(only_conf),0.0)/sum(total)),2),0.0)) as confirmation_rate from 
signups s left join 
cte c on s.user_id=c.user_id
group by s.user_id