-- 코드를 입력하세요
SELECT B.title, B.board_id, R.reply_id, R.writer_id, R.contents, DATE_FORMAT(R.created_date, '%Y-%m-%d')
FROM USED_GOODS_REPLY R
left JOIN USED_GOODS_BOARD B
    ON B.board_id = R.board_id
WHERE MONTH(B.created_date) = 10 
    and YEAR(B.created_date) = 2022
ORDER BY R.created_date asc, B.title asc