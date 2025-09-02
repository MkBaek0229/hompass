
-- 더미 데이터 추가
-- Users 테이블에 데이터 추가

INSERT INTO Users(nickname,man_woman,age,cm,kg,activity_level,meal_goals) VALUES('테스트1', '여자', 28, 161, 46 , 0.8, 1.55);

INSERT INTO CAL_RESULT(users_id, kcal, carb, protein, fat, created_at, modified_at)
VALUES (1, 2800, 500, 245, 68, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);




