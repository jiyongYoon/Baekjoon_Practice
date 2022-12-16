-- 코드를 입력하세요
SELECT B.BOOK_ID, A.AUTHOR_NAME, Date_format(B.PUBLISHED_DATE, '%Y-%m-%d')
from BOOK B
JOIN AUTHOR A ON B.Author_id = A.Author_id
Where Category in ('경제')
ORDER BY PUBLISHED_DATE