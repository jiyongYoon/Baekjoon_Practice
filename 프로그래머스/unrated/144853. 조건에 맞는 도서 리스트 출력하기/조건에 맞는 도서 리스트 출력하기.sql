-- 코드를 입력하세요
SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d')
From Book
where year(Published_date) = 2021
    and category in ('인문')
ORDER BY PUBLISHED_DATE