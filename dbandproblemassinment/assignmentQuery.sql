select training.user_id,count(training.user_id),training.training_date ,ser.username
from training_details training join exauser ser
on training.user_id = ser.user_id
GROUP BY training.training_date, training.user_id, ser.username
having count(training.user_id) >= 2

--changed the name of the table user due to the system table user in postgres